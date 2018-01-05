package net.luna.common.util;

import android.os.AsyncTask;

import net.luna.common.constant.HttpConstants;
import net.luna.common.entity.HttpRequest;
import net.luna.common.entity.HttpResponse;
import net.luna.common.service.HttpCache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * HttpUtils
 * <ul>
 * <strong>Http get, you can also use {@link HttpCache}</strong>
 * <li>{@link #httpGet(HttpRequest)} http get synchronous</li>
 * <li>{@link #httpGet(String)} http get synchronous</li>
 * <li>{@link #httpGetString(String)} http get synchronous, response is String</li>
 * <li>{@link #httpGet(HttpRequest, HttpListener)} http get asynchronous</li>
 * <li>{@link #httpGet(String, HttpListener)} http get asynchronous</li>
 * </ul>
 * <ul>
 * <strong>Http post</strong>
 * <li>{@link #httpPost(HttpRequest)}</li>
 * <li>{@link #httpPost(String)}</li>
 * <li>{@link #httpPostString(String)}</li>
 * <li>{@link #httpPostString(String, Map)}</li>
 * </ul>
 * <ul>
 * <strong>Http params</strong>
 * <li>{@link #getUrlWithParas(String, Map)}</li>
 * <li>{@link #getUrlWithValueEncodeParas(String, Map)}</li>
 * <li>{@link #joinParas(Map)}</li>
 * <li>{@link #joinParasWithEncodedValue(Map)}</li>
 * <li>{@link #appendParaToUrl(String, String, String)}</li>
 * <li>{@link #parseGmtTime(String)}</li>
 * </ul>
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-5-12
 */
public class HttpUtils {

    /**
     * url and para separator
     **/
    public static final String URL_AND_PARA_SEPARATOR = "?";
    /**
     * parameters separator
     **/
    public static final String PARAMETERS_SEPARATOR = "&";
    /**
     * paths separator
     **/
    public static final String PATHS_SEPARATOR = "/";
    /**
     * equal sign
     **/
    public static final String EQUAL_SIGN = "=";

    private HttpUtils() {
        throw new AssertionError();
    }

    private static TrustManager myX509TrustManager = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }
    };

    /**
     * http get synchronous
     * <ul>
     * <li>use gzip compression default</li>
     * <li>use bufferedReader to improve the reading speed</li>
     * </ul>
     *
     * @param request
     * @return the response of the url, if null represents http error
     */
    public static HttpResponse httpGet(HttpRequest request) {
        if (request == null) {
            return null;
        }

        BufferedReader input = null;
        HttpURLConnection con = null;
        try {
            URL url = new URL(request.getUrl());
            try {
                HttpResponse response = new HttpResponse(request.getUrl());
                // default gzip encode
                con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(15000);
                setURLConnection(request, con);
                input = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String s;
                while ((s = input.readLine()) != null) {
                    sb.append(s).append("\n");
                }
                response.setResponseBody(sb.toString());
                response.setContentType(con.getContentType());
                setHttpResponse(con, response);
                return response;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } finally {
            // close buffered
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // disconnecting releases the resources held by a connection so they may be closed or reused
            if (con != null) {
                con.disconnect();
            }
        }

        return null;
    }

    /**
     * http get synchronous
     *
     * @param httpUrl
     * @return the response of the url, if null represents http error
     * @see HttpUtils#httpGet(HttpRequest)
     */
    public static HttpResponse httpGet(String httpUrl) {
        return httpGet(new HttpRequest(httpUrl));
    }

    /**
     * http get synchronous
     *
     * @param request
     * @return the content of the url, if null represents http error
     * @see HttpUtils#httpGet(HttpRequest)
     */
    public static String httpGetString(HttpRequest request) {
        HttpResponse response = httpGet(request);
        return response == null ? null : response.getResponseBody();
    }

    /**
     * http get synchronous
     *
     * @param httpUrl
     * @return the content of the url, if null represents http error
     * @see HttpUtils#httpGet(HttpRequest)
     */
    public static String httpGetString(String httpUrl) {
        HttpResponse response = httpGet(new HttpRequest(httpUrl));
        return response == null ? null : response.getResponseBody();
    }

    public static String httpGetString(String httpUrl, String agent) {
        HttpRequest request = new HttpRequest(httpUrl);
        request.setUserAgent(agent);
        HttpResponse response = httpGet(request);
        return response == null ? null : response.getResponseBody();
    }

    /**
     * http get asynchronous
     * <ul>
     * <li>It gets data from network asynchronous.</li>
     * <li>If you want get data synchronous, use {@link #httpGet(HttpRequest)} or {@link #httpGetString(HttpRequest)}</li>
     * </ul>
     *
     * @param url
     * @param listener listener which can do something before or after HttpGet. this can be null if you not want to do
     *                 something
     */
    public static void httpGet(String url, HttpListener listener) {
        new HttpStringAsyncTask(listener).execute(url);
    }

    /**
     * http get asynchronous
     * <ul>
     * <li>It gets data or network asynchronous.</li>
     * <li>If you want get data synchronous, use {@link HttpCache#httpGet(HttpRequest)} or
     * {@link HttpCache#httpGetString(HttpRequest)}</li>
     * </ul>
     *
     * @param request
     * @param listener listener which can do something before or after HttpGet. this can be null if you not want to do
     *                 something
     */
    public static void httpGet(HttpRequest request, HttpListener listener) {
        new HttpRequestAsyncTask(listener).execute(request);
    }

    /**
     * http post
     * <ul>
     * <li>use gzip compression default</li>
     * <li>use bufferedReader to improve the reading speed</li>
     * </ul>
     *
     * @return the response of the url, if null represents http error
     */
    public static HttpResponse httpPost(HttpRequest request) {
        if (request == null) {
            return null;
        }

        BufferedReader input = null;
        HttpURLConnection con = null;
        HttpsURLConnection con2 = null;
        try {
            URL url = new URL(request.getUrl());
            try {

                HttpResponse response = new HttpResponse(request.getUrl());
                //检查是不是https
                if (request.getUrl().indexOf("https") == 0) {
                    con2 = (HttpsURLConnection) url.openConnection();
                    con2.setUseCaches(false);
                    con2.setConnectTimeout(5000);
                    con2.setReadTimeout(5000);
                    SSLContext instance = null;
                    try {
                        instance = SSLContext.getInstance("TLS");
                        instance.init(null, new TrustManager[]{myX509TrustManager}, null);
                        con2.setSSLSocketFactory(instance.getSocketFactory());
                        con2.setRequestMethod("POST");
                        con2.setDoOutput(true);

                        String postContent = request.getPostContent();
                        if (!StringUtils.isEmpty(postContent)) {
                            con2.getOutputStream().write(postContent.getBytes());
                        }

                        String paras = request.getParas();
                        if (!StringUtils.isEmpty(paras)) {
                            con2.getOutputStream().write(paras.getBytes());
                        }
                        input = new BufferedReader(new InputStreamReader(con2.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String s;
                        while ((s = input.readLine()) != null) {
                            sb.append(s).append("\n");
                        }
                        response.setResponseBody(sb.toString());
                        setHttpResponse(con2, response);
                        return response;
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (KeyManagementException e) {
                        e.printStackTrace();
                    }
                } else {
                    // default gzip encode
                    con = (HttpURLConnection) url.openConnection();
                    setURLConnection(request, con);
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);

                    String postContent = request.getPostContent();
                    if (!StringUtils.isEmpty(postContent)) {
                        con.getOutputStream().write(postContent.getBytes());
                    }

                    String paras = request.getParas();
                    if (!StringUtils.isEmpty(paras)) {
                        con.getOutputStream().write(paras.getBytes());
                    }
                    input = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String s;
                    while ((s = input.readLine()) != null) {
                        sb.append(s).append("\n");
                    }
                    response.setResponseBody(sb.toString());
                    setHttpResponse(con, response);
                    return response;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } finally {
            // close buffered
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // disconnecting releases the resources held by a connection so they may be closed or reused
            if (con != null) {
                con.disconnect();
            }
            if (con2 != null) {
                con2.disconnect();
            }
        }

        return null;
    }

    /**
     * http post
     *
     * @param httpUrl
     * @return the response of the url, if null represents http error
     * @see HttpUtils#httpPost(HttpRequest)
     */
    public static HttpResponse httpPost(String httpUrl) {
        return httpPost(new HttpRequest(httpUrl));
    }

    /**
     * http post
     *
     * @param httpUrl
     * @return the content of the url, if null represents http error
     * @see HttpUtils#httpPost(HttpRequest)
     */
    public static String httpPostString(String httpUrl) {
        HttpResponse response = httpPost(new HttpRequest(httpUrl));
        return response == null ? null : response.getResponseBody();
    }

    public static String httpPostString(String httpUrl, String postContent) {
        HttpRequest request = new HttpRequest(httpUrl);
        request.setPostContent(postContent);
        HttpResponse response = httpPost(request);
        return response == null ? null : response.getResponseBody();
    }

    /**
     * http post
     *
     * @param httpUrl
     * @param parasMap paras map, key is para name, value is para value. will be transfrom to String by
     *                 {@link HttpUtils#joinParas(Map)}
     * @return the content of the url, if null represents http error
     * @see HttpUtils#httpPost(HttpRequest)
     */
    public static String httpPostString(String httpUrl, Map<String, String> parasMap) {
        HttpResponse response = httpPost(new HttpRequest(httpUrl, parasMap));
        return response == null ? null : response.getResponseBody();
    }

    /**
     * join url and paras
     * <p/>
     * <pre>
     * getUrlWithParas(null, {(a, b)})                        =   "?a=b";
     * getUrlWithParas("baidu.com", {})                       =   "baidu.com";
     * getUrlWithParas("baidu.com", {(a, b), (i, j)})         =   "baidu.com?a=b&i=j";
     * getUrlWithParas("baidu.com", {(a, b), (i, j), (c, d)}) =   "baidu.com?a=b&i=j&c=d";
     * </pre>
     *
     * @param url      url
     * @param parasMap paras map, key is para name, value is para value
     * @return if url is null, process it as empty string
     */
    public static String getUrlWithParas(String url, Map<String, String> parasMap) {
        StringBuilder urlWithParas = new StringBuilder(StringUtils.isEmpty(url) ? "" : url);
        String paras = joinParas(parasMap);
        if (!StringUtils.isEmpty(paras)) {
            urlWithParas.append(URL_AND_PARA_SEPARATOR).append(paras);
        }
        return urlWithParas.toString();
    }

    /**
     * join url and encoded paras
     *
     * @param url
     * @param parasMap
     * @return
     * @see #getUrlWithParas(String, Map)
     * @see StringUtils#utf8Encode(String)
     */
    public static String getUrlWithValueEncodeParas(String url, Map<String, String> parasMap) {
        StringBuilder urlWithParas = new StringBuilder(StringUtils.isEmpty(url) ? "" : url);
        String paras = joinParasWithEncodedValue(parasMap);
        if (!StringUtils.isEmpty(paras)) {
            urlWithParas.append(URL_AND_PARA_SEPARATOR).append(paras);
        }
        return urlWithParas.toString();
    }

    /**
     * join paras
     *
     * @param parasMap paras map, key is para name, value is para value
     * @return join key and value with {@link #EQUAL_SIGN}, join keys with {@link #PARAMETERS_SEPARATOR}
     */
    public static String joinParas(Map<String, String> parasMap) {
        if (parasMap == null || parasMap.size() == 0) {
            return null;
        }

        StringBuilder paras = new StringBuilder();
        Iterator<Map.Entry<String, String>> ite = parasMap.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) ite.next();
            paras.append(entry.getKey()).append(EQUAL_SIGN).append(entry.getValue());
            if (ite.hasNext()) {
                paras.append(PARAMETERS_SEPARATOR);
            }
        }
        return paras.toString();
    }

    /**
     * join paras with encoded value
     *
     * @param parasMap
     * @return
     * @see #joinParas(Map)
     * @see StringUtils#utf8Encode(String)
     */
    public static String joinParasWithEncodedValue(Map<String, String> parasMap) {
        StringBuilder paras = new StringBuilder("");
        if (parasMap != null && parasMap.size() > 0) {
            Iterator<Map.Entry<String, String>> ite = parasMap.entrySet().iterator();
            try {
                while (ite.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) ite.next();
                    paras.append(entry.getKey()).append(EQUAL_SIGN).append(StringUtils.utf8Encode(entry.getValue()));
                    if (ite.hasNext()) {
                        paras.append(PARAMETERS_SEPARATOR);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return paras.toString();
    }

    /**
     * append a key and value pair to url
     *
     * @param url
     * @param paraKey
     * @param paraValue
     * @return
     */
    public static String appendParaToUrl(String url, String paraKey, String paraValue) {
        if (StringUtils.isEmpty(url)) {
            return url;
        }

        StringBuilder sb = new StringBuilder(url);
        if (!url.contains(URL_AND_PARA_SEPARATOR)) {
            sb.append(URL_AND_PARA_SEPARATOR);
        } else {
            sb.append(PARAMETERS_SEPARATOR);
        }
        return sb.append(paraKey).append(EQUAL_SIGN).append(paraValue).toString();
    }

    private static final SimpleDateFormat GMT_FORMAT = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z",
            Locale.ENGLISH);

    /**
     * parse gmt time to long
     *
     * @param gmtTime likes Thu, 11 Apr 2013 10:20:30 GMT
     * @return -1 represents exception otherwise time in milliseconds
     */
    public static long parseGmtTime(String gmtTime) {
        try {
            return GMT_FORMAT.parse(gmtTime).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * set HttpRequest to HttpURLConnection
     *
     * @param request       source request
     * @param urlConnection destin url connection
     */
    private static void setURLConnection(HttpRequest request, HttpURLConnection urlConnection) {
        if (request == null || urlConnection == null) {
            return;
        }

        setURLConnection(request.getRequestProperties(), urlConnection);
        if (request.getConnectTimeout() >= 0) {
            urlConnection.setConnectTimeout(request.getConnectTimeout());
        }
        if (request.getReadTimeout() >= 0) {
            urlConnection.setReadTimeout(request.getReadTimeout());
        }
    }

    /**
     * set HttpURLConnection property
     *
     * @param requestProperties
     * @param urlConnection
     */
    public static void setURLConnection(Map<String, String> requestProperties, HttpURLConnection urlConnection) {
        if (MapUtils.isEmpty(requestProperties) || urlConnection == null) {
            return;
        }

        for (Map.Entry<String, String> entry : requestProperties.entrySet()) {
            if (!StringUtils.isEmpty(entry.getKey())) {
                urlConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * set HttpURLConnection to HttpResponse
     *
     * @param urlConnection source url connection
     * @param response      destin response
     */
    private static void setHttpResponse(HttpURLConnection urlConnection, HttpResponse response) {
        if (response == null || urlConnection == null) {
            return;
        }
        try {
            response.setResponseCode(urlConnection.getResponseCode());
        } catch (IOException e) {
            response.setResponseCode(-1);
        }
        response.setResponseHeader(HttpConstants.EXPIRES, urlConnection.getHeaderField("Expires"));
        response.setResponseHeader(HttpConstants.CACHE_CONTROL, urlConnection.getHeaderField("Cache-Control"));
    }

    /**
     * AsyncTask to get data by String url
     *
     * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-11-15
     */
    private static class HttpStringAsyncTask extends AsyncTask<String, Void, HttpResponse> {

        private HttpListener listener;

        public HttpStringAsyncTask(HttpListener listener) {
            this.listener = listener;
        }

        protected HttpResponse doInBackground(String... url) {
            if (ArrayUtils.isEmpty(url)) {
                return null;
            }
            return httpGet(url[0]);
        }

        protected void onPreExecute() {
            if (listener != null) {
                listener.onPreGet();
            }
        }

        protected void onPostExecute(HttpResponse httpResponse) {
            if (listener != null) {
                listener.onPostGet(httpResponse);
            }
        }
    }

    /**
     * AsyncTask to get data by HttpRequest
     *
     * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-11-15
     */
    private static class HttpRequestAsyncTask extends AsyncTask<HttpRequest, Void, HttpResponse> {

        private HttpListener listener;

        public HttpRequestAsyncTask(HttpListener listener) {
            this.listener = listener;
        }

        protected HttpResponse doInBackground(HttpRequest... httpRequest) {
            if (ArrayUtils.isEmpty(httpRequest)) {
                return null;
            }
            return httpGet(httpRequest[0]);
        }

        protected void onPreExecute() {
            if (listener != null) {
                listener.onPreGet();
            }
        }

        protected void onPostExecute(HttpResponse httpResponse) {
            if (listener != null) {
                listener.onPostGet(httpResponse);
            }
        }
    }

    /**
     * HttpListener, can do something before or after HttpGet
     *
     * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-11-15
     */
    public static abstract class HttpListener {

        /**
         * Runs on the UI thread before httpGet.<br/>
         * <ul>
         * <li>this can be null if you not want to do something</li>
         * </ul>
         */
        protected void onPreGet() {
        }

        /**
         * Runs on the UI thread after httpGet. The httpResponse is returned by httpGet.
         * <ul>
         * <li>this can be null if you not want to do something</li>
         * </ul>
         *
         * @param httpResponse get by the url
         */
        protected void onPostGet(HttpResponse httpResponse) {
        }
    }
}
