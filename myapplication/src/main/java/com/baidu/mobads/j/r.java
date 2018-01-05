package com.baidu.mobads.j;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build.VERSION;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.b.b;
import com.baidu.mobads.openad.e.a;
import com.baidu.mobads.openad.e.d;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

class r implements IXAdURIUitls {
    private b a;

    r() {
    }

    private b a() {
        if (this.a == null) {
            try {
                this.a = new b();
            } catch (ClassNotFoundException e) {
            }
        }
        return this.a;
    }

    private Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Boolean a(String str) {
        boolean z = a(str, "sms:").booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue();
        return Boolean.valueOf(z);
    }

    @Deprecated
    public String addParameter(String str, String str2, String str3) {
        String fixedString = getFixedString(str);
        String queryString = getQueryString(str);
        return fixedString + "?" + (!m.a().m().isStringAvailable(queryString) ? str2 + "=" + str3 : queryString + "&" + str2 + "=" + str3);
    }

    public String addParameters(String str, HashMap hashMap) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (hashMap == null || hashMap.isEmpty()) {
            return stringBuilder.toString();
        }
        stringBuilder.append("?");
        for (Entry entry : hashMap.entrySet()) {
            try {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
                stringBuilder.append("&");
            } catch (Throwable e) {
                j.a().e(e);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.substring(0, stringBuilder2.length() - 1);
    }

    public String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public HashMap getAllQueryParameters(String str) {
        HashMap hashMap = new HashMap();
        Uri parse = Uri.parse(str);
        for (String str2 : getQueryParameterNames(parse)) {
            if (str2 != null && str2.length() > 0) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
        }
        return hashMap;
    }

    public String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException e) {
            return "";
        }
    }

    public String getFixedString(String str) {
        return str == null ? null : (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public HttpURLConnection getHttpURLConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        b a = a();
        if (a != null) {
            String a2 = a.a(url.toString());
            if (a2 != null && a2.length() > 0) {
                httpURLConnection.setRequestProperty("Cookie", a2);
            }
        }
        return httpURLConnection;
    }

    @SuppressLint({"NewApi"})
    public Set getQueryParameterNames(Uri uri) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return uri.getQueryParameterNames();
            }
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            Set linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                int indexOf = encodedQuery.indexOf(38, i);
                if (indexOf == -1) {
                    indexOf = encodedQuery.length();
                }
                int indexOf2 = encodedQuery.indexOf(61, i);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
                indexOf2 = indexOf + 1;
                if (indexOf2 >= encodedQuery.length()) {
                    return Collections.unmodifiableSet(linkedHashSet);
                }
                i = indexOf2;
            }
        } catch (Exception e) {
            return new HashSet();
        }
    }

    public String getQueryString(String str) {
        if (str == null) {
            return null;
        }
        String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
        return (split == null || split.length < 2) ? null : split[1];
    }

    public String getRequestAdUrl(String str, HashMap hashMap) {
        String str2;
        m a = m.a();
        StringBuilder stringBuilder = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str3 : hashMap.keySet()) {
                int i2 = i + 1;
                str2 = (String) hashMap.get(str3);
                if (i2 == 1) {
                    stringBuilder.append(str3).append("=").append(str2);
                } else {
                    stringBuilder.append("&").append(str3).append("=").append(str2);
                }
                i = i2;
            }
        }
        if (!com.baidu.mobads.a.b.a.booleanValue()) {
            return str + "?code2=" + a.e().encode(stringBuilder.toString());
        }
        if (hashMap != null) {
            for (String str32 : hashMap.keySet()) {
                try {
                    str2 = (String) hashMap.get(str32);
                    if (str2 != null) {
                        hashMap.put(str32, URLEncoder.encode(str2, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return a.i().addParameters(str, hashMap);
    }

    public Boolean isHttpProtocol(String str) {
        return a(str, "http:");
    }

    public Boolean isHttpsProtocol(String str) {
        return a(str, "https:");
    }

    public void pintHttpInNewThread(String str) {
        a aVar = new a();
        d dVar = new d(str, "");
        dVar.e = 1;
        aVar.a(dVar, Boolean.valueOf(true));
    }
}
