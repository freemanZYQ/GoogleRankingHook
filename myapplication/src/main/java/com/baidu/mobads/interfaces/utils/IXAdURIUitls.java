package com.baidu.mobads.interfaces.utils;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public interface IXAdURIUitls {
    String addParameter(String str, String str2, String str3);

    String addParameters(String str, HashMap hashMap);

    String encodeUrl(String str);

    HashMap getAllQueryParameters(String str);

    String getFileName(String str);

    String getFixedString(String str);

    HttpURLConnection getHttpURLConnection(URL url);

    Set getQueryParameterNames(Uri uri);

    String getQueryString(String str);

    String getRequestAdUrl(String str, HashMap hashMap);

    Boolean isHttpProtocol(String str);

    Boolean isHttpsProtocol(String str);

    void pintHttpInNewThread(String str);
}
