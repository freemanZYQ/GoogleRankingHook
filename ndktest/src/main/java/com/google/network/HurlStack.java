package com.google.network;

import android.text.TextUtils;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessage;

import org.apache.http.*;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/**
 * Created by apple on 16/10/4.
 */
public class HurlStack implements HttpStack {

    public static String host;
    public static int port;
    private final UrlRewriter mUrlRewriter;
    private SSLSocketFactory mSslSocketFactory;

    public HurlStack(){
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter){
        this(urlRewriter,null);
    }

    public HurlStack(UrlRewriter urlRewriter,SSLSocketFactory sslSocketFactory){
        this.mUrlRewriter = urlRewriter;
        this.mSslSocketFactory = sslSocketFactory;
    }

    private static HttpEntity entityFromConnection(HttpURLConnection connection) {
        BasicHttpEntity entity = new BasicHttpEntity();
        InputStream inputStream;
        try {
            inputStream = connection.getInputStream();
        } catch (IOException ioe) {
            inputStream = connection.getErrorStream();
        }
        entity.setContent(inputStream);
        entity.setContentLength(connection.getContentLength());
        System.out.println("encode:"+connection.getContentEncoding());
        entity.setContentEncoding(connection.getContentEncoding());
        entity.setContentType(connection.getContentType());
        return entity;
    }

    private static void addBodyIfExists(HttpURLConnection connection, Request<?> request)
            throws IOException,AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            connection.setDoOutput(true);
            if(request.isRequestGzip()){
                connection.addRequestProperty("Content-Encoding", "gzip");
            }
//            connection.addRequestProperty(HEADER_CONTENT_TYPE, request.getBodyContentType());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(body);
            out.close();
        }

        if(request.getT() != null){
            connection.setDoOutput(true);
            if(request.getT() instanceof GeneratedMessage){
                GeneratedMessage message =(GeneratedMessage) request.getT();
                OutputStream outputStream = null;
                if(request.isRequestGzip()){
                    outputStream = new GZIPOutputStream(connection.getOutputStream());
                }else{
                    outputStream = connection.getOutputStream();
                }
                CodedOutputStream cosm = CodedOutputStream.newInstance(outputStream);
                message.writeTo(cosm);
                cosm.flush();
            }
        }

        if(request.getBodyString()!= null){
            byte[] bytes = request.getBodyString().getBytes();
            connection.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.write(bytes);
            out.close();
        }
    }

    protected HttpURLConnection createConnection(URL url) throws IOException {
        System.out.println("httpStack.host:"+host+"  port:"+port);
        if(!TextUtils.isEmpty(host) && !TextUtils.isEmpty(String.valueOf(port))) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress(host, port));
            return (HttpURLConnection) url.openConnection(proxy);
        }
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection openConnection(URL url, Request request) throws IOException,NetworkError{
        HttpURLConnection connection = createConnection(url);

        int timeoutMs = request.getTimeoutMs();
        connection.setConnectTimeout(timeoutMs);
        connection.setReadTimeout(timeoutMs);
        connection.setUseCaches(false);
        connection.setDoInput(true);

        // use caller-provided custom SslSocketFactory, if any, for HTTPS
        if ("https".equals(url.getProtocol())) {
                try {
                    javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
                    javax.net.ssl.TrustManager tm = new miTM();
                    trustAllCerts[0] = tm;
                    javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                            .getInstance("SSL");
                    sc.init(null, trustAllCerts, null);
                    mSslSocketFactory = sc.getSocketFactory();
                    ((HttpsURLConnection) connection).setSSLSocketFactory(mSslSocketFactory);
                } catch (NoSuchAlgorithmException e) {
                    throw new NetworkError(e);
                } catch (KeyManagementException e) {
                    throw new NetworkError(e);
                }

        }

        return connection;
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    static void setConnectionParametersForRequest(HttpURLConnection connection,
                                                  Request<?> request) throws IOException,AuthFailureError{
        switch (request.getMethod()) {
            case Method.GET:
                // Not necessary to set the request method because connection defaults to GET but
                // being explicit here.
                connection.setRequestMethod("GET");
                break;
            case Method.DELETE:
                connection.setRequestMethod("DELETE");
                break;
            case Method.POST:
                connection.setRequestMethod("POST");
                addBodyIfExists(connection, request);
                break;
            case Method.PUT:
                connection.setRequestMethod("PUT");
                addBodyIfExists(connection, request);
                break;
            case Method.HEAD:
                connection.setRequestMethod("HEAD");
                break;
            case Method.OPTIONS:
                connection.setRequestMethod("OPTIONS");
                break;
            case Method.TRACE:
                connection.setRequestMethod("TRACE");
                break;
            case Method.PATCH:
                connection.setRequestMethod("PATCH");
                addBodyIfExists(connection, request);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override
    public HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException,AuthFailureError, NetworkError{
        String url = request.getUrl();
        HashMap<String, String> map = new HashMap<String, String>();
        map.putAll(request.getHeaders());
        map.putAll(additionalHeaders);
        if (mUrlRewriter != null) {
            String rewritten = mUrlRewriter.rewriteUrl(url);
            if (rewritten == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
            url = rewritten;
        }
        URL parsedUrl = new URL(url);
        HttpURLConnection connection = openConnection(parsedUrl, request);
        for (String headerName : map.keySet()) {
            connection.addRequestProperty(headerName, map.get(headerName));
        }
        setConnectionParametersForRequest(connection, request);
        // Initialize HttpResponse with data from the HttpURLConnection.
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        int responseCode = connection.getResponseCode();
        if (responseCode == -1) {
            // -1 is returned by getResponseCode() if the response code could not be retrieved.
            // Signal to the caller that something was wrong with the connection.
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        StatusLine responseStatus = new BasicStatusLine(protocolVersion,
                connection.getResponseCode(), connection.getResponseMessage());
        BasicHttpResponse response = new BasicHttpResponse(responseStatus);
        response.setEntity(entityFromConnection(connection));
        for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
            if (header.getKey() != null) {
                Header h = new BasicHeader(header.getKey(), header.getValue().get(0));
                response.addHeader(h);
            }
        }
        return response;
    }

    /**
     * An interface for transforming URLs before use.
     */
    public interface UrlRewriter {
        /**
         * Returns a URL to use instead of the provided one, or null to indicate
         * this URL should not be used at all.
         */
        String rewriteUrl(String originalUrl);
    }

    /**
     * Supported request methods.
     */
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
}
