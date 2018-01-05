package picture;

import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 *	packet class
 */
class CCProtoPacket
{
    public	static	final	int	CC_PROTO_VER			=	1;		//	protocol version
    public	static	final	int	CC_RAND_SIZE			=	256;	//	size of the random sequence for authentication procedure
    public	static	final	int	CC_MAX_TEXT_SIZE		=	100;	//	maximum characters in returned text for picture
    public	static	final	int	CC_MAX_LOGIN_SIZE		=	100;	//	maximum characters in login string
    public	static	final	int	CC_MAX_PICTURE_SIZE		=	200000;	//	200 K bytes for picture seems sufficient for all purposes
    public	static	final	int	CC_HASH_SIZE			=	32;		//

    public	static	final	int	cmdCC_UNUSED			=	0;
    public	static	final	int	cmdCC_LOGIN				=	1;		//	login
    public	static	final	int	cmdCC_BYE				=	2;		//	end of session
    public	static	final	int	cmdCC_RAND				=	3;		//	random data for making hash with login+password
    public	static	final	int	cmdCC_HASH				=	4;		//	hash data
    public	static	final	int	cmdCC_PICTURE			=	5;		//	picture data, deprecated
    public	static	final	int	cmdCC_TEXT				=	6;		//	text data, deprecated
    public	static	final	int	cmdCC_OK				=	7;		//
    public	static	final	int	cmdCC_FAILED			=	8;		//
    public	static	final	int	cmdCC_OVERLOAD			=	9;		//
    public	static	final	int	cmdCC_BALANCE			=	10;		//	zero balance
    public	static	final	int	cmdCC_TIMEOUT			=	11;		//	time out occured
    public	static	final	int	cmdCC_PICTURE2			=	12;		//	picture data
    public	static	final	int	cmdCC_PICTUREFL			=	13;		//	picture failure
    public	static	final	int	cmdCC_TEXT2				=	14;		//	text data

    public	static	final	int	SIZEOF_CC_PACKET		=	6;
    public	static	final	int	SIZEOF_CC_PICT_DESCR	=	20;


    private	int		_ver		= CC_PROTO_VER;	//	version of the protocol
    private	int		_cmd		= cmdCC_BYE;	//	command, see cc_cmd_t
    private	int		_size		= 0;			//	data size in consequent bytes
    private	byte	_data[]		= null;			//	packet payload

    /**
     * @param cmd
     * @return
     */
    private boolean checkPackHdr( int cmd, int size )
    {
        if( _ver != CC_PROTO_VER )
            return false;
        if( (cmd != -1) && (_cmd != cmd) )
            return false;
        if( (size != -1) && (_size != size) )
            return false;

        return true;
    }

    public static int swapInt (int value)
    {
        int b1 = (value >>  0) & 0xff;
        int b2 = (value >>  8) & 0xff;
        int b3 = (value >> 16) & 0xff;
        int b4 = (value >> 24) & 0xff;

        return b1 << 24 | b2 << 16 | b3 << 8 | b4 << 0;
    }

    /**
     *
     */
    public boolean packTo( DataOutputStream oos ) {
        try {
            oos.writeByte( _ver  );
            oos.writeByte( _cmd  );
            oos.writeInt( swapInt( _size ) );
            if( _data != null ) {
                if( _data.length > 0 ) {
                    oos.write( _data );
                }
            }

            return true;
        } catch( Exception e ) {
            return false;
        }
    }

    /**
     *
     */
    private boolean unpackHeader( DataInputStream ios ) {
        try {
            _ver	= (int)ios.readByte();
            _cmd	= (int)ios.readByte();
            _size	= swapInt(ios.readInt() );

            return true;
        } catch( Exception e ) {
            return false;
        }
    }

    /**
     *
     */
    public boolean unpackFrom( DataInputStream dis, int cmd, int size )
    {
        unpackHeader( dis );

        if( checkPackHdr( cmd, size ) == false )
            return false;

        try {
            if( _size > 0 ) {
                // check error
                _data = new byte[_size];
                dis.readFully(_data);
            } else {
                _data = null;
            }
            return true;
        } catch(Exception e ) {
            return false;
        }
    }

    void setVer( int ver ) {
        _ver = ver;
    }

    int getVer() {
        return _ver;
    }

    void setCmd( int cmd ) {
        _cmd = cmd;
    }

    int getCmd() {
        return _cmd;
    }

    void setSize( int size ) {
        _size = size;
    }

    int getSize() {
        return _size;
    }

    int calcSize() {
        if( _data != null ) {
            _size = _data.length;
        } else {
            _size = 0;
        }
        return _size;
    }

    int getFullSize() {
        return SIZEOF_CC_PACKET + _size;
    }

    void setData( byte data[] ) {
        _data = data;
    }

    byte[] getData() {
        return _data;
    }
}


class CCPictDescr {
    private	int		_timeout	= APIConsts.ptoDEFAULT;
    private	int		_type		= APIConsts.ptUNSPECIFIED;
    private	int		_size		= 0;
    private	int		_major_id	= 0;
    private	int		_minor_id	= 0;
    private	byte[]	_data		= null;

    public byte[] pack() {

        int		data_length	= _data == null ? 0 : _data.length;
        byte[]	res			= new byte[4*5 + data_length];
        int		i			= 0;
        int		j			= 0;
        int		value		= 0;

        value    = _timeout;
        res[i++] = (byte)((value >>  0) & 0xff);
        res[i++] = (byte)((value >>  8) & 0xff);
        res[i++] = (byte)((value >> 16) & 0xff);
        res[i++] = (byte)((value >> 24) & 0xff);

        value    = _type;
        res[i++] = (byte)((value >>  0) & 0xff);
        res[i++] = (byte)((value >>  8) & 0xff);
        res[i++] = (byte)((value >> 16) & 0xff);
        res[i++] = (byte)((value >> 24) & 0xff);

        value    = _size;
        res[i++] = (byte)((value >>  0) & 0xff);
        res[i++] = (byte)((value >>  8) & 0xff);
        res[i++] = (byte)((value >> 16) & 0xff);
        res[i++] = (byte)((value >> 24) & 0xff);

        value    = _major_id;
        res[i++] = (byte)((value >>  0) & 0xff);
        res[i++] = (byte)((value >>  8) & 0xff);
        res[i++] = (byte)((value >> 16) & 0xff);
        res[i++] = (byte)((value >> 24) & 0xff);

        value    = _minor_id;
        res[i++] = (byte)((value >>  0) & 0xff);
        res[i++] = (byte)((value >>  8) & 0xff);
        res[i++] = (byte)((value >> 16) & 0xff);
        res[i++] = (byte)((value >> 24) & 0xff);

        if( _data != null ) {
            for( j = 0; j < _data.length; j++ ) {
                res[i++] = _data[j];
            }
        }

        return res;
    }


    public void unpack( byte[] bin ) {
        int	i	= 0;
        int	j	= 0;

        if( bin.length < CCProtoPacket.SIZEOF_CC_PICT_DESCR ) {
            return;
        }
        _timeout	= (bin[0] << 0) | (bin[1] << 8) | (bin[2] << 16) | (bin[3] << 24);
        _type		= (bin[4] << 0) | (bin[5] << 8) | (bin[6] << 16) | (bin[7] << 24);
        _size		= (bin[8] << 0) | (bin[9] << 8) | (bin[10] << 16) | (bin[11] << 24);
        _major_id	= (bin[12] << 0) | (bin[13] << 8) | (bin[14] << 16) | (bin[15] << 24);
        _minor_id	= (bin[16] << 0) | (bin[17] << 8) | (bin[18] << 16) | (bin[19] << 24);

        _data = null;

        // we have some additional data
        if( bin.length > CCProtoPacket.SIZEOF_CC_PICT_DESCR ) {
            _data = new byte[bin.length - CCProtoPacket.SIZEOF_CC_PICT_DESCR];
            for(i = CCProtoPacket.SIZEOF_CC_PICT_DESCR, j = 0; i < bin.length; i++, j++ ) {
                _data[j] = bin[i];
            }
        }
    }

    public void setTimeout( int to ) {
        _timeout = to;
    }

    public int getTimeout() {
        return _timeout;
    }

    public void setType( int type ) {
        _type = type;
    }

    public int getType() {
        return _type;
    }

    public void setSize( int size ) {
        _size = size;
    }

    public int getSize() {
        return _size;
    }

    public int calcSize() {
        if( _data == null ) {
            _size = 0;
        } else {
            _size = _data.length;
        }
        return _size;
    }

    public int getFullSize() {
        return CCProtoPacket.SIZEOF_CC_PICT_DESCR + _size;
    }

    public void setMajorID( int major_id ) {
        _major_id = major_id;
    }

    public int getMajorID() {
        return _major_id;
    }

    public void setMinorID( int minor_id ) {
        _minor_id = minor_id;
    }

    public int getMinorID() {
        return _minor_id;
    }

    public void setData( byte[] data ) {
        _data = data;
    }

    public byte[] getData() {
        return _data;
    }
}
