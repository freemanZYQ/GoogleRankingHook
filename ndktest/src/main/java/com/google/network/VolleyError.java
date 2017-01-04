package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class VolleyError extends Exception{

    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        networkResponse = null;
    }

    public VolleyError(NetworkResponse response) {
        networkResponse = response;
    }

    public VolleyError(String exceptionMessage) {
        super(exceptionMessage);
        networkResponse = null;
    }

    public VolleyError(String exceptionMessage, Throwable reason) {
        super(exceptionMessage, reason);
        networkResponse = null;
    }

    public VolleyError(Throwable cause) {
        super(cause);
        networkResponse = null;
    }

    public NetworkResponse getNetworkResponse() {
        return networkResponse;
    }

    public long getNetworkTimeMs() {
        return networkTimeMs;
    }

    /* package */ void setNetworkTimeMs(long networkTimeMs) {
        this.networkTimeMs = networkTimeMs;
    }
}
