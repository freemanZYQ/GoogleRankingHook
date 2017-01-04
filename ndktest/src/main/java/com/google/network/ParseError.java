package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class ParseError extends VolleyError {

    public ParseError() {
    }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable cause) {
        super(cause);
    }
}
