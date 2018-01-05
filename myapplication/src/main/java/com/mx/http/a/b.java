package com.mx.http.a;

import com.qq.e.comm.constants.ErrorCode.InitError;
import java.net.HttpURLConnection;
import java.net.URL;

public class b {
    public static HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setReadTimeout(6000);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(false);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != InitError.INIT_ADMANGER_ERROR && responseCode != InitError.INIT_PLUGIN_ERROR) {
            return httpURLConnection;
        }
        httpURLConnection = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setReadTimeout(6000);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        return httpURLConnection;
    }
}
