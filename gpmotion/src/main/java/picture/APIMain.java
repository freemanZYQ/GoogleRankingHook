package picture;

import net.luna.common.debug.LunaLog;

import java.io.File;
import java.io.FileInputStream;

public class APIMain {


    // your connect information
    public static String HOST = "api.de-captcher.com";        // YOUR ADDRESS

    public static int PORT = 3500;                    // YOUR PORT

    public static String USERNAME = "Julia Zhang";
    public static String PASSWORD = "helloyujuan";

//    public static String USERNAME = "mosida";
//    public static String PASSWORD = "333888";

//	public static String USERNAME = "jinxiangxu";
//	public static String PASSWORD = "jinxiangxu123";

    public static String[] deCaptcher(byte[] pic) throws Exception {

        CCProto ccp = new CCProto();

        boolean isLogin = login(ccp);
        if (!isLogin) {
            ccp.close();
            return null;
        }
        LunaLog.d("==># OK");


        int major_id = 0;
        int minor_id = 0;

        // binary picture data
        byte[] pict = pic;
//        try
//        {
//            FileInputStream is = new FileInputStream( file );
//            pict = new byte[(int) file.length()];
//            is.read( pict );
//            is.close();
//        }
//        catch( Exception e )
//        {
//            System.out.println( "==># Problms reading file" );
//            ccp.close();
//            throw e;
//        }

        String text = "";
        LunaLog.d("==># sending a picture...");

        int pict_to = APIConsts.ptoDEFAULT;
        int pict_type = APIConsts.ptUNSPECIFIED;

        int[] pict_to_arr = new int[2];
        pict_to_arr[0] = pict_to;

        int[] pict_type_arr = new int[2];
        pict_type_arr[0] = pict_type;

        String[] text_arr = new String[2];
        text_arr[0] = text;

        int[] major_id_arr = new int[2];
        major_id_arr[0] = major_id;

        int[] minor_id_arr = new int[2];
        minor_id_arr[0] = minor_id;

        int res = ccp.picture2(pict, pict_to_arr, pict_type_arr, text_arr, major_id_arr, minor_id_arr);
        switch (res) {
            // most common return codes
            case APIConsts.ccERR_OK:
                pict_to = pict_to_arr[0];
                pict_type = pict_type_arr[0];
                text = text_arr[0];
                major_id = major_id_arr[0];
                minor_id = minor_id_arr[0];

                LunaLog.d("==># got text for id=" + major_id + "/" + minor_id + ", type=" + pict_type + ", to=" + pict_to + ", text='" + text + "'");
                return new String[]{text, major_id + "", minor_id + ""};

            case APIConsts.ccERR_BALANCE:
                LunaLog.d("==># not enough funds to process a picture, balance is depleted");
                break;
            case APIConsts.ccERR_TIMEOUT:
                LunaLog.d("==># picture has been timed out on server (payment not taken)");
                break;
            case APIConsts.ccERR_OVERLOAD:
                LunaLog.d("==># temporarily server-side error");
                LunaLog.d("==># server's overloaded, wait a little before sending a new picture");
                break;

            // local errors
            case APIConsts.ccERR_STATUS:
                LunaLog.d("==># local error.");
                LunaLog.d("==># either ccproto_init() or ccproto_login() has not been successfully called prior to ccproto_picture()");
                LunaLog.d("==># need ccproto_init() and ccproto_login() to be called");
                break;

            // network errors
            case APIConsts.ccERR_NET_ERROR:
                LunaLog.d("==># network troubles, better to call ccproto_login() again");
                break;

            // server-side errors
            case APIConsts.ccERR_TEXT_SIZE:
                LunaLog.d("==># size of the text returned is too big");
                break;
            case APIConsts.ccERR_GENERAL:
                LunaLog.d("==># server-side error, better to call ccproto_login() again");
                break;
            case APIConsts.ccERR_UNKNOWN:
                LunaLog.d("==># unknown error, better to call ccproto_login() again");
                break;

            default:
                // any other known errors?
                break;
        }

        /*if( ccp.balance( balance_arr ) != APIConsts.ccERR_OK ) {
            System.out.println( "==># balance() FAILED\n" );
            return;
        }
        System.out.println( "==># Balance=" + balance_arr[0] );*/

        ccp.close();

        return null;
    }

    public static String[] deCaptcher(File file) throws Exception {

//        Log.v("vcode","上传的文件是："+file);
        CCProto ccp = new CCProto();

        boolean isLogin = login(ccp);
        if (!isLogin) {
            ccp.close();
            return null;
        }
        System.out.println("==># OK");

        /*String[] balance_arr = new String[1];
        if( ccp.balance(balance_arr) != APIConsts.ccERR_OK ) {
            System.err.println( "==># balance() FAILED" );
            return;
        }
        System.out.println( "==># Balance=" + balance_arr[0] );*/

        int major_id = 0;
        int minor_id = 0;

        // binary picture data
        byte[] pict = null;
        try {
            FileInputStream is = new FileInputStream(file);
            pict = new byte[(int) file.length()];
            is.read(pict);
            is.close();
        } catch (Exception e) {
            System.out.println("==># Problms reading file");
            ccp.close();
            throw e;
        }

        String text = "";
        System.out.println("==># sending a picture...");

        int pict_to = APIConsts.ptoDEFAULT;
        int pict_type = APIConsts.ptUNSPECIFIED;

        int[] pict_to_arr = new int[2];
        pict_to_arr[0] = pict_to;

        int[] pict_type_arr = new int[2];
        pict_type_arr[0] = pict_type;

        String[] text_arr = new String[2];
        text_arr[0] = text;

        int[] major_id_arr = new int[2];
        major_id_arr[0] = major_id;

        int[] minor_id_arr = new int[2];
        minor_id_arr[0] = minor_id;

        int res = ccp.picture2(pict, pict_to_arr, pict_type_arr, text_arr, major_id_arr, minor_id_arr);
        switch (res) {
            // most common return codes
            case APIConsts.ccERR_OK:
                pict_to = pict_to_arr[0];
                pict_type = pict_type_arr[0];
                text = text_arr[0];
                major_id = major_id_arr[0];
                minor_id = minor_id_arr[0];

                System.out.println("==># got text for id=" + major_id + "/" + minor_id + ", type=" + pict_type + ", to=" + pict_to + ", text='" + text + "'");
                return new String[]{text, major_id + "", minor_id + ""};

            case APIConsts.ccERR_BALANCE:
                System.out.println("==># not enough funds to process a picture, balance is depleted");
                break;
            case APIConsts.ccERR_TIMEOUT:
                System.out.println("==># picture has been timed out on server (payment not taken)");
                break;
            case APIConsts.ccERR_OVERLOAD:
                System.out.println("==># temporarily server-side error");
                System.out.println("==># server's overloaded, wait a little before sending a new picture");
                break;

            // local errors
            case APIConsts.ccERR_STATUS:
                System.out.println("==># local error.");
                System.out.println("==># either ccproto_init() or ccproto_login() has not been successfully called prior to ccproto_picture()");
                System.out.println("==># need ccproto_init() and ccproto_login() to be called");
                break;

            // network errors
            case APIConsts.ccERR_NET_ERROR:
                System.out.println("==># network troubles, better to call ccproto_login() again");
                break;

            // server-side errors
            case APIConsts.ccERR_TEXT_SIZE:
                System.out.println("==># size of the text returned is too big");
                break;
            case APIConsts.ccERR_GENERAL:
                System.out.println("==># server-side error, better to call ccproto_login() again");
                break;
            case APIConsts.ccERR_UNKNOWN:
                System.out.println("==># unknown error, better to call ccproto_login() again");
                break;

            default:
                // any other known errors?
                break;
        }

        /*if( ccp.balance( balance_arr ) != APIConsts.ccERR_OK ) {
            System.out.println( "==># balance() FAILED\n" );
            return;
        }
        System.out.println( "==># Balance=" + balance_arr[0] );*/

        ccp.close();

        return null;

    }

    public static void reportErrorCode(String major_id, String minor_id) {
        CCProto ccp = new CCProto();

        // process a picture and if it is badly recognized
        // call picture_bad2() to name it as error.
        // pictures named bad are not charged

        // ccp.picture_bad2( major_id, minor_id );
        // also you can mark picture as bad after session is closed, but you
        // need to be logged in again

        boolean isLogin = login(ccp);
        if (!isLogin) {
            System.out.println("==># report error code failure in login");
            ccp.close();
            return;
        }
        System.out.println("==># OK");
        System.out.println("==># Naming picture " + major_id + "/" + minor_id + " as bad");
        ccp.picture_bad2(Integer.parseInt(major_id), Integer.parseInt(minor_id));

        ccp.close();
    }

    private static boolean login(CCProto ccp) {
        int count = 0;
        LunaLog.d("==># Logging in...");
        while (true) {
            count++;
            if (count >= 15) {
                return false;
            }

            if (ccp.login(HOST, PORT, USERNAME, PASSWORD) < 0) {
                LunaLog.d("==># FAILED : " + count);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                LunaLog.d("==># SUCCESS");
                return true;
            }
        }
    }
}
