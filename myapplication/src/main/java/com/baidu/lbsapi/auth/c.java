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

class c {
    private final String a = "HttpAsyncTask";
    private Context b;
    private String c = null;
    private String d = null;
    private HashMap e = null;
    private a f = null;

    interface a {
        void a(Object obj);
    }

    class b extends SSLSocketFactory {
        SSLContext a = SSLContext.getInstance("TLS");
        final /* synthetic */ c b;

        public b(c cVar, KeyStore keyStore) {
            this.b = cVar;
            super(keyStore);
            e eVar = new e(this, cVar);
            this.a.init(null, new TrustManager[]{eVar}, null);
        }

        public Socket createSocket() {
            return this.a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    protected c(Context context) {
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

    private HashMap a(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Object obj : hashMap.keySet()) {
            String obj2 = obj.toString();
            hashMap2.put(obj2, hashMap.get(obj2));
        }
        return hashMap2;
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

    private void a(String str, HashMap hashMap) {
        if (a.a) {
            a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        }
        HttpClient a = a();
        b(a);
        if (a(a)) {
            a(a, str, hashMap);
        } else {
            a(ErrorMessage.a("Current network is not available."));
        }
        if (a.a) {
            a.a("syncConnect end");
        }
    }

    private void a(HttpClient httpClient, String str, HashMap hashMap) {
        if (a.a) {
            a.a("httpPost start");
        }
        double currentTimeMillis = a.a ? (double) System.currentTimeMillis() : 0.0d;
        HttpUriRequest httpPost = new HttpPost(str);
        if (a.a) {
            a.a("httpPost url:" + str);
        }
        if (hashMap == null) {
            a(ErrorMessage.a("Post paramters is null;"));
            return;
        }
        int i;
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
                    a(ErrorMessage.a("Error: http response can not get status code."));
                    i = 0;
                } else {
                    i = execute.getStatusLine().getStatusCode();
                }
                if (i != 200) {
                    if (a.a) {
                        a.a("syncConnect 104" + execute.getStatusLine().getReasonPhrase());
                    }
                    a(ErrorMessage.a("Http code:" + i + ";" + execute.getStatusLine().getReasonPhrase()));
                    return;
                }
                try {
                    this.c = EntityUtils.toString(execute.getEntity(), "utf-8");
                    if (a.a) {
                        a.a("syncConnect parse result = " + this.c);
                    }
                    a(this.c);
                    if (a.a) {
                        a.a("httpPost end");
                    }
                } catch (Exception e) {
                    a(ErrorMessage.a("Exception:" + e.getMessage()));
                }
            } catch (ConnectTimeoutException e2) {
                a(ErrorMessage.a("Connect timeout exception:" + e2.getMessage()));
            } catch (SocketTimeoutException e3) {
                a(ErrorMessage.a("Socket timeout exception:" + e3.getMessage()));
            } catch (Exception e4) {
                a(ErrorMessage.a("Exception:" + e4.getMessage()));
            }
        } catch (UnsupportedEncodingException e5) {
            a(ErrorMessage.a("Paramters encoding exception:" + e5.getMessage()));
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

    protected void a(HashMap hashMap, a aVar) {
        this.e = a(hashMap);
        this.f = aVar;
        this.d = (String) this.e.get("url");
        new Thread(new d(this)).start();
    }
}
