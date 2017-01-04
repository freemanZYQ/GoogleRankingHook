package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class NoConnectionError extends NetworkError {

    public NoConnectionError() {
        super();
    }

    public NoConnectionError(Throwable reason) {
        super(reason);
    }
}
