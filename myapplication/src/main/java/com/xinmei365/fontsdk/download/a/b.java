package com.xinmei365.fontsdk.download.a;

import com.qq.e.comm.constants.ErrorCode.NetWorkError;

public class b {
    public static String valueOf(int i) {
        String str = "UnKnow";
        switch (i) {
            case NetWorkError.QUEUE_FULL_ERROR /*401*/:
                return "download failed, connect out time";
            case NetWorkError.RETRY_TIME_NATIVE_ERROR /*402*/:
                return "download failed, connect failed";
            case NetWorkError.HTTP_STATUS_ERROR /*403*/:
                return "download failed, cannot get file length";
            case NetWorkError.TIME_OUT_ERROR /*404*/:
                return "download failed, processing failed";
            case NetWorkError.RESOURCE_LOAD_FAIL_ERROR /*405*/:
                return "download failed, end task exception";
            case NetWorkError.IMG_LOAD_ERROR /*406*/:
                return "download failed, IllegalArgumentException";
            default:
                return str;
        }
    }
}
