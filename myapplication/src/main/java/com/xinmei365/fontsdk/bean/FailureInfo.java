package com.xinmei365.fontsdk.bean;

public class FailureInfo {
    public static final int ERROR_DOWNLOAD_FAILURE = 1004;
    public static final int ERROR_INTERNAL_SERVER = 1007;
    public static final int ERROR_INVALID_URL = 1002;
    public static final int ERROR_JSON_EXCEPTION = 1005;
    public static final int ERROR_NOT_NETWORK = 1001;
    public static final int ERROR_OPEN_CONNECT = 1003;
    public static final int ERROR_PARAMETER_ERROR = 1006;
    public static final int ERROR_SERVER_CALLBACK_ERROR = 1008;
    private int errorCode = 0;
    private String errorMessage = "";

    public FailureInfo(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public static String valueOf(int i) {
        String str = "UnKnow";
        switch (i) {
            case 1001:
                return "Network is not available.";
            case 1002:
                return "Url can not be null.";
            case 1003:
                return "http connect failed";
            case ERROR_DOWNLOAD_FAILURE /*1004*/:
                return "download the font failed, Font not found ";
            case 1005:
                return "parsing data failed";
            case 1006:
                return "Args error, IllegalArgumentException";
            case 1007:
                return "Internal server error";
            case 1008:
                return "Json data is not returned by the server";
            default:
                return str;
        }
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String toString() {
        return "FailureInfo{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + '\'' + '}';
    }
}
