package com.google.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/**
 * Created by apple on 16/10/4.
 */
public class Request<T> {

    /**
     * Default encoding for POST or PUT parameters. See {@link #getParamsEncoding()}.
     */
    protected static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    /**
     * Request method of this request.  Currently supports GET, POST, PUT, DELETE, HEAD, OPTIONS,
     * TRACE, and PATCH.
     */
    protected final int mMethod;
    /**
     * URL of this request.
     */
    protected final String mUrl;
    /**
     * The retry policy for this request.
     */
    protected RetryPolicy mRetryPolicy;

    protected Cache.Entry mCacheEntry = null;

    protected String mRedirectUrl;

    protected boolean isRequestGzip;

    protected T t;

    protected String bodyString;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public boolean isRequestGzip() {
        return isRequestGzip;
    }

    public void setRequestGzip(boolean requestGzip) {
        isRequestGzip = requestGzip;
    }

    public Request(int method, String url){
        this.mUrl = url;
        this.mMethod = method;
        setRetryPolicy(new DefaultRetryPolicy());
    }

    public void setBodyString(String bodyString){
        this.bodyString = bodyString;
    }

    public String getBodyString() {
        return bodyString;
    }

    public Cache.Entry getCacheEntry() {
        return mCacheEntry;
    }



    public int getMethod() {
        return mMethod;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    protected Map<String, String> getParams() throws AuthFailureError  {
        return null;
    }

    protected String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }


    /**
     * Returns the URL of this request.
     */
    public String getUrl() {
        return (mRedirectUrl != null) ? mRedirectUrl : mUrl;
    }

    /**
     * Returns the URL of the request before any redirects have occurred.
     */
    public String getOriginUrl() {
        return mUrl;
    }

    /**
     * Sets the redirect url to handle 3xx http responses.
     */
    public void setRedirectUrl(String redirectUrl) {
        mRedirectUrl = redirectUrl;
    }

    /**
     * Returns the content type of the POST or PUT body.
     */
    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }

    /**
     * Converts <code>params</code> into an application/x-www-form-urlencoded encoded string.
     */
    private byte[] encodeParameters(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                System.out.print(entry.getKey()+":"+entry.getValue());
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }

    public final int getTimeoutMs() {
        return mRetryPolicy.getCurrentTimeOut();
    }

    /**
     * Returns the retry policy that should be used  for this request.
     */
    public RetryPolicy getRetryPolicy() {
        return mRetryPolicy;
    }

    /**
     * Sets the retry policy for this request.
     *
     * @return This Request object to allow for chaining.
     */
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        mRetryPolicy = retryPolicy;
        return this;
    }

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params = getParams();
        if (params != null && params.size() > 0) {
            return encodeParameters(params, getParamsEncoding());
        }
        return null;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }



    public interface Method {
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }
}
