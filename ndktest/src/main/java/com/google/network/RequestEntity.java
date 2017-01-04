package com.google.network;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 16/10/5.
 */
public class RequestEntity<T> {

    private final int mMethod;
    private final String mUrl;
    private final Class<T> mClassOfT;
    private final Map<String, String> mHeaders;
    private final Map<String, String> mPostParams;


    public RequestEntity(String url, Class<T> classOfT) {
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/x-www-form-urlencoded");
        mUrl = url;
        mMethod = Request.Method.GET;
        mClassOfT = classOfT;
        mHeaders = null;
        mPostParams = null;
    }

    public RequestEntity(String url, int method, Class<T> classOfT) {
        this(url,method,classOfT,null,null);
    }

    public RequestEntity(String url, Class<T> classOfT,Map<String,String> headers) {
        this(url,Request.Method.GET,classOfT,headers,null);
    }


    public RequestEntity(String url, int method, Class<T> classOfT, Map<String, String> headers,
                         Map<String, String> postParams) {
        mUrl = url;
        mMethod = method;
        mClassOfT = classOfT;
        mHeaders = headers;
        mPostParams = postParams;
    }


    public String getUrl() {
        return mUrl;
    }

    public int getMethod() {
        return mMethod;
    }

    public Class<T> getClassOfT() {
        return mClassOfT;
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public Map<String, String> getPostParams() {
        return mPostParams;
    }
}
