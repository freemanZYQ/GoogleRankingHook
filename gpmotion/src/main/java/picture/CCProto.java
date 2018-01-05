package picture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.security.MessageDigest;


/**
 *	CC protocol class
 */
class CCProto
{

    public	static	final	int	sCCC_INIT		=	1;		//	initial status, ready to issue LOGIN on client
    public	static	final	int	sCCC_LOGIN		=	2;		//	LOGIN is sent, waiting for RAND (login accepted) or CLOSE CONNECTION (login is unknown)
    public	static	final	int	sCCC_HASH		=	3;		//	HASH is sent, server may CLOSE CONNECTION (hash is not recognized)
    public	static	final	int	sCCC_PICTURE	=	4;

    private	int					_status = sCCC_INIT;
    private Socket _sock;
    private DataOutputStream _dos;
    private DataInputStream _dis;


    /**
     *
     */
    public synchronized int login( String hostname, int port, String login, String pwd )
    {
        CCProtoPacket pack	= null;
        MessageDigest md5		= null;
        MessageDigest	sha		= null;
        int 			i		= 0;
        int 			j		= 0;

        _status	= sCCC_INIT;

        try {
            _sock	= new Socket( hostname, port );
            _dos	= new DataOutputStream( _sock.getOutputStream() );
            _dis	= new DataInputStream( _sock.getInputStream() );
        } catch( Exception e ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        pack = new CCProtoPacket();
        pack.setVer( CCProtoPacket.CC_PROTO_VER );

        pack.setCmd( CCProtoPacket.cmdCC_LOGIN );
        pack.setSize( login.length() );
        pack.setData( login.getBytes() );

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        if( pack.unpackFrom( _dis, CCProtoPacket.cmdCC_RAND, CCProtoPacket.CC_RAND_SIZE ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        try{
            md5 = MessageDigest.getInstance( "MD5" );
        } catch( Exception e ) {
            System.out.println( "No MD5" );
            return APIConsts.ccERR_UNKNOWN;
        }

        md5.update( pwd.getBytes() );
        byte[] md5bin = md5.digest();
        String md5str = "";
        char[] cvt = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        for( i = 0; i < md5bin.length; i++ ) {
            md5str += cvt[(md5bin[i] & 0xF0) >> 4];
            md5str += cvt[md5bin[i] & 0x0F];
        }

        byte shabuf[] = new byte[ pack.getData().length + md5str.length() + login.length() ];
        j = 0;
        for( i = 0; i < pack.getData().length; i++, j++ ) {
            shabuf[j] = pack.getData()[i];
        }
        for( i = 0; i < md5str.getBytes().length; i++, j++ ) {
            shabuf[j] = md5str.getBytes()[i];
        }
        for( i = 0; i < login.getBytes().length; i++, j++ ) {
            shabuf[j] = login.getBytes()[i];
        }

        try{
            sha = MessageDigest.getInstance( "SHA-256" );
        } catch( Exception e ) {
            System.out.println( "No SHA256" );
            return APIConsts.ccERR_UNKNOWN;
        }
        sha.update( shabuf );

        pack = new CCProtoPacket();
        pack.setVer( CCProtoPacket.CC_PROTO_VER );
        pack.setCmd( CCProtoPacket.cmdCC_HASH );
        pack.setSize( CCProtoPacket.CC_HASH_SIZE );
        pack.setData( sha.digest() );

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        if( pack.unpackFrom( _dis, CCProtoPacket.cmdCC_OK, 0 ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        _status = sCCC_PICTURE;

        return APIConsts.ccERR_OK;
    } // login()

    public static class PictureResult
    {
        public final int timeReallyUsed;
        public final int typeReallyUsed;
        public final String text;
        public final int majorId;
        public final int minorId;
        public final int returnCode;

        public PictureResult( int time, int type, String text, Integer major, Integer minor, int returnCode )
        {
            this.timeReallyUsed = time;
            this.typeReallyUsed = type;
            this.text = text;
            this.majorId = (null == major) ? 0 : major;
            this.minorId = (null == minor) ? 0 : minor;
            this.returnCode = returnCode;
        }
    }

    /**
     * Receive back a result object that includes all the details in a format trivial to use
     * in other Java code, while passing only and exactly what's needed.
     *
     * This is a simple wrapper to picture2 and does no logic of its own.
     *
     * @param pict The bytes of the picture to solve
     * @param timeout How long the solution should take at most
     * @param type
     * @return
     */
    public synchronized PictureResult picture2( byte[] pict, int timeout, int type )
    {
        int[] to_wrapper		= new int[]{timeout};
        int[] type_wrapper		= new int[]{type};
        int[] major_wrapper		= new int[1];
        int[] minor_wrapper		= new int[1];
        String[] text_wrapper	= new String[]{""};

        int result = picture2( pict, to_wrapper, type_wrapper, text_wrapper, major_wrapper, minor_wrapper );
        return new PictureResult( to_wrapper[0], type_wrapper[0], text_wrapper[0], major_wrapper[0], minor_wrapper[0], result );
    }

    /**
     * say "thanks" to Java incapability to pass values by reference in order to use them as multiple returns
     * all arrays[] are used as workarond to get values out of the function, really
     *
     */
    public synchronized int picture2(
            byte[]		pict,			//	IN		picture binary data
            int[]		pict_to, 		//	IN/OUT	timeout specifier to be used, on return - really used specifier, see ptoXXX constants, ptoDEFAULT in case of unrecognizable
            int[]		pict_type, 		//	IN/OUT	type specifier to be used, on return - really used specifier, see ptXXX constants, ptUNSPECIFIED in case of unrecognizable
            String[]	text,			//	OUT	text
            int[]		major_id,		//	OUT	OPTIONAL	major part of the picture ID
            int[]		minor_id		//	OUT OPTIONAL	minor part of the picture ID
    ) {

        if( _status != sCCC_PICTURE )
            return APIConsts.ccERR_STATUS;

        CCProtoPacket pack = new CCProtoPacket();
        pack.setVer( CCProtoPacket.CC_PROTO_VER );
        pack.setCmd( CCProtoPacket.cmdCC_PICTURE2 );


        CCPictDescr desc = new CCPictDescr();
        desc.setTimeout( pict_to[0] );
        desc.setType( pict_type[0] );
        desc.setMajorID( 0 );
        desc.setMinorID( 0 );
        desc.setData( pict );
        desc.calcSize();

        pack.setData( desc.pack() );
        pack.calcSize();

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        if( pack.unpackFrom( _dis, -1, -1 ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        switch( pack.getCmd() ) {
            case CCProtoPacket.cmdCC_TEXT2:
                desc.unpack( pack.getData() );
                pict_to[0]		= desc.getTimeout();
                pict_type[0]	= desc.getType();
                text[0]			= desc.getData() == null ? "" : new String(desc.getData());

                if( major_id != null )
                    major_id[0]	= desc.getMajorID();
                if( minor_id != null )
                    minor_id[0]	= desc.getMinorID();

                return APIConsts.ccERR_OK;

            case CCProtoPacket.cmdCC_BALANCE:
                // balance depleted
                return APIConsts.ccERR_BALANCE;

            case CCProtoPacket.cmdCC_OVERLOAD:
                // server's busy
                return APIConsts.ccERR_OVERLOAD;

            case CCProtoPacket.cmdCC_TIMEOUT:
                // picture timed out
                return APIConsts.ccERR_TIMEOUT;

            case CCProtoPacket.cmdCC_FAILED:
                // server's error
                return APIConsts.ccERR_GENERAL;

            default:
                // unknown error
                return APIConsts.ccERR_UNKNOWN;
        }
    } // picture2()


    public synchronized int picture_bad2( int major_id, int minor_id ) {
        CCProtoPacket pack = new CCProtoPacket();

        pack.setVer( CCProtoPacket.CC_PROTO_VER );
        pack.setCmd( CCProtoPacket.cmdCC_PICTUREFL );

        CCPictDescr desc = new CCPictDescr();
        desc.setTimeout( APIConsts.ptoDEFAULT );
        desc.setType( APIConsts.ptUNSPECIFIED );
        desc.setMajorID( major_id );
        desc.setMinorID( minor_id );
        desc.calcSize();

        pack.setData( desc.pack() );
        pack.calcSize();

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        return APIConsts.ccERR_NET_ERROR;
    } // picture_bad2()

    public synchronized int balance( String[] balance ) {
        CCProtoPacket pack	= null;

        if( _status != sCCC_PICTURE )
            return APIConsts.ccERR_STATUS;

        pack = new CCProtoPacket();
        pack.setVer( CCProtoPacket.CC_PROTO_VER );
        pack.setCmd( CCProtoPacket.cmdCC_BALANCE );
        pack.setSize( 0 );

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        if( pack.unpackFrom( _dis, -1, -1 ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        switch( pack.getCmd() ) {
            case CCProtoPacket.cmdCC_BALANCE:

                balance[0] = new String( pack.getData() );

                return APIConsts.ccERR_OK;

            default:
                // unknown error
                return APIConsts.ccERR_UNKNOWN;
        }
    } // balance()

    public synchronized int close() {
        CCProtoPacket pack = new CCProtoPacket();
        pack.setVer( CCProtoPacket.CC_PROTO_VER );

        pack.setCmd( CCProtoPacket.cmdCC_BYE );
        pack.setSize( 0 );

        if( pack.packTo( _dos ) == false ) {
            return APIConsts.ccERR_NET_ERROR;
        }

        try {
            _sock.close();
        } catch( Exception e ) {}
        _status = sCCC_INIT;

        return APIConsts.ccERR_NET_ERROR;
    } // close()
}
