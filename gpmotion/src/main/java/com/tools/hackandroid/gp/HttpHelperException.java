package com.tools.hackandroid.gp;

public class HttpHelperException extends Exception {
    private static final long serialVersionUID = 8753991112730781898L;

    public HttpHelperException(Throwable e) {
        super(e);
    }

    public HttpHelperException(String detailMessage) {
        super(detailMessage);
    }
}
