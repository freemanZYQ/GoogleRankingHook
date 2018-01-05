package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

class f {
    private final String a = "HttpAsyncTask";
    private Context b;
    private String c = null;
    private String d = null;
    private List e = null;
    private a f = null;

    interface a {
        void a(Object obj);
    }

    class b extends SSLSocketFactory {
        SSLContext a = SSLContext.getInstance("TLS");
        final /* synthetic */ f b;

        public b(f fVar, KeyStore keyStore) {
            this.b = fVar;
            super(keyStore);
            h hVar = new h(this, fVar);
            this.a.init(null, new TrustManager[]{hVar}, null);
        }

        public Socket createSocket() {
            return this.a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    protected f(Context context) {
        this.b = context;
    }

    private String a(Context context) {
        String str = IXAdSystemUtils.NT_WIFI;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "";
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        return (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) ? str : extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
    }

    private String a(HttpClient httpClient, String str, HashMap hashMap) {
        if (a.a) {
            a.a("httpPost start");
        }
        double currentTimeMillis = a.a ? (double) System.currentTimeMillis() : 0.0d;
        HttpUriRequest httpPost = new HttpPost(str);
        if (a.a) {
            a.a("httpPost url:" + str);
        }
        if (hashMap == null) {
            return ErrorMessage.a("Post paramters is null;");
        }
        List arrayList = new ArrayList(hashMap.size());
        for (Entry entry : hashMap.entrySet()) {
            if (!((String) entry.getKey()).equals("url")) {
                if (a.a) {
                    a.a("" + ((String) entry.getKey()) + ":" + ((String) entry.getValue()));
                }
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        if (a.a) {
            a.a("httpPost add params end");
        }
        for (Header header : httpPost.getAllHeaders()) {
            if (a.a) {
                a.a("http header : " + header.getName() + "=" + header.getValue());
            }
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
            try {
                if (a.a) {
                    a.a("httpPost execute");
                }
                HttpResponse execute = httpClient.execute(httpPost);
                if (a.a) {
                    a.a("POST Thread duration:" + ((((double) System.currentTimeMillis()) - currentTimeMillis) / 1000.0d) + "[url:" + str + "]");
                }
                if (execute == null || execute.getStatusLine() == null) {
                    return ErrorMessage.a("Error: http response can not get status code.");
                }
                int statusCode = execute.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    if (a.a) {
                        a.a("syncConnect 104" + execute.getStatusLine().getReasonPhrase());
                    }
                    return ErrorMessage.a("Http code:" + statusCode + ";" + execute.getStatusLine().getReasonPhrase());
                }
                try {
                    this.c = EntityUtils.toString(execute.getEntity(), "utf-8");
                    if (a.a) {
                        a.a("syncConnect parse result = " + this.c);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(this.c);
                        if (a.a) {
                            a.a("httpPost end");
                        }
                        return jSONObject.toString();
                    } catch (JSONException e) {
                        return ErrorMessage.a("JSONException:" + e.getMessage());
                    }
                } catch (Exception e2) {
                    return ErrorMessage.a("Exception:" + e2.getMessage());
                }
            } catch (ConnectTimeoutException e3) {
                return ErrorMessage.a("Connect timeout exception:" + e3.getMessage());
            } catch (SocketTimeoutException e4) {
                return ErrorMessage.a("Socket timeout exception:" + e4.getMessage());
            } catch (Exception e22) {
                return ErrorMessage.a("Exception:" + e22.getMessage());
            }
        } catch (UnsupportedEncodingException e5) {
            return ErrorMessage.a("Paramters encoding exception:" + e5.getMessage());
        }
    }

    private List a(HashMap hashMap, String[] strArr) {
        List arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            for (Object obj : hashMap.keySet()) {
                String obj2 = obj.toString();
                hashMap2.put(obj2, hashMap.get(obj2));
            }
            arrayList.add(hashMap2);
        } else {
            for (Object put : strArr) {
                HashMap hashMap3 = new HashMap();
                for (Object put2 : hashMap.keySet()) {
                    String obj3 = put2.toString();
                    hashMap3.put(obj3, hashMap.get(obj3));
                }
                hashMap3.put("mcode", put2);
                arrayList.add(hashMap3);
            }
        }
        return arrayList;
    }

    private HttpClient a() {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            SocketFactory bVar = new b(this, instance);
            bVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", bVar, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }

    private void a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException e) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.f != null) {
            this.f.a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    private void a(List list) {
        if (a.a) {
            a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        }
        if (list != null && list.size() > 0) {
            JSONObject jSONObject;
            List arrayList = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                if (a.a) {
                    a.a("auth sync resuest " + i + "  start!!!");
                }
                HashMap hashMap = (HashMap) list.get(i);
                HttpClient a = a();
                b(a);
                String str = (String) hashMap.get("url");
                if (a(a)) {
                    String a2 = a(a, str, hashMap);
                    if (a.a) {
                        a.a("auth sync resuest " + i + "  result:" + a2);
                    }
                    arrayList.add(a2);
                    try {
                        jSONObject = new JSONObject(a2);
                        if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                            if (a.a) {
                                a.a("auth end and break");
                            }
                            a(a2);
                            return;
                        }
                    } catch (JSONException e) {
                        if (a.a) {
                            a.a("continue-------------------------------");
                        }
                    }
                } else {
                    if (a.a) {
                        a.a("Current network is not available.");
                    }
                    arrayList.add(ErrorMessage.a("Current network is not available."));
                }
                if (a.a) {
                    a.a("syncConnect end");
                }
                i++;
            }
            if (a.a) {
                a.a("---------------------------iiiiii:" + i + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
            }
            if (list.size() > 0 && i == list.size() && arrayList.size() > 0 && i == arrayList.size() && i - 1 > 0) {
                try {
                    jSONObject = new JSONObject((String) arrayList.get(i - 1));
                    if (jSONObject.has("status") && jSONObject.getInt("status") != 0) {
                        if (a.a) {
                            a.a("i-1 result is not 0,return first result");
                        }
                        a((String) arrayList.get(0));
                    }
                } catch (JSONException e2) {
                    a(ErrorMessage.a("JSONException:" + e2.getMessage()));
                }
            }
        }
    }

    private boolean a(HttpClient httpClient) {
        if (a.a) {
            a.a("checkNetwork 1 start");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        String a = a(this.b);
        if (a.a) {
            a.a("checkNetwork = " + a);
        }
        if (a.equals("cmwap")) {
            httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80, "http"));
        } else if (a.equals("ctwap")) {
            httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80, "http"));
        }
        if (a.a) {
            a.a("checkNetwork 4 end");
        }
        return true;
    }

    private void b(HttpClient httpClient) {
        if (a.a) {
            a.a("setTimeout start");
        }
        httpClient.getParams().setIntParameter("http.socket.timeout", 50000);
        httpClient.getParams().setIntParameter("http.connection.timeout", 50000);
        if (a.a) {
            a.a("setTimeout end");
        }
    }

    protected void a(HashMap hashMap, String[] strArr, a aVar) {
        this.e = a(hashMap, strArr);
        this.f = aVar;
        new Thread(new g(this)).start();
    }
}
