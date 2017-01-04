package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class ServerError extends VolleyError {

    public ServerError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ServerError() {
        super();
    }
}
