package com.google.network;

/**
 * Created by apple on 16/10/4.
 */
public interface RetryPolicy {

    public int getCurrentTimeOut();

    void retry(VolleyError e) throws VolleyError;

    public int getCurrentRetryCount();
}
