package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class NetworkError extends VolleyError {

    public NetworkError() {
        super();
    }

    public NetworkError(Throwable cause) {
        super(cause);
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public NetworkError(String error) {
        super(error);
    }
}
