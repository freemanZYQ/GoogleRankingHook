package com.google.network;

/**
 * Created by apple on 16/10/4.
 */
public interface Network {

    NetworkResponse performRequest(Request request) throws Exception;
}
