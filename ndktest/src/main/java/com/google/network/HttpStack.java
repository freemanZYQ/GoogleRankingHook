package com.google.network;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by apple on 16/10/4.
 */
public interface HttpStack {

    HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders)
            throws IOException ,AuthFailureError, NetworkError;
}
