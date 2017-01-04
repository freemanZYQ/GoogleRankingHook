package com.google.network;

import org.apache.http.HttpStatus;

import java.util.Collections;
import java.util.Map;

/**
 * Created by apple on 16/10/4.
 */
public class NetworkResponse {

    public final int statusCode;
    public final byte[] data;
    public final long networkTimeMs;
    public final Map<String,String> headers;
    public final boolean notModified;

    public NetworkResponse(int statusCode, byte[] data, Map<String, String> headers,
                           boolean notModified, long networkTimeMs) {
        this.statusCode = statusCode;
        this.data = data;
        this.headers = headers;
        this.notModified = notModified;
        this.networkTimeMs = networkTimeMs;
    }

    public NetworkResponse(int statusCode, byte[] data, Map<String, String> headers,
                           boolean notModified) {
        this(statusCode, data, headers, notModified, 0);
    }

    public NetworkResponse(byte[] data) {
        this(HttpStatus.SC_OK, data, Collections.<String, String>emptyMap(), false, 0);
    }

    public NetworkResponse(byte[] data, Map<String, String> headers) {
        this(HttpStatus.SC_OK, data, headers, false, 0);
    }

}
