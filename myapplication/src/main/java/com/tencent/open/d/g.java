package com.tencent.open.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.b.c;
import com.tencent.open.a.j;
import com.tencent.tauth.a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

final class g extends Thread {
    final /* synthetic */ c a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ Bundle d;
    final /* synthetic */ String e;
    final /* synthetic */ a f;

    public void run() {
        try {
            JSONObject a = f.a(this.a, this.b, this.c, this.d, this.e);
            if (this.f != null) {
                this.f.a(a);
                j.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
            }
        } catch (MalformedURLException e) {
            if (this.f != null) {
                this.f.a(e);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e);
            }
        } catch (ConnectTimeoutException e2) {
            if (this.f != null) {
                this.f.a(e2);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e2);
            }
        } catch (SocketTimeoutException e3) {
            if (this.f != null) {
                this.f.a(e3);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e3);
            }
        } catch (l e4) {
            if (this.f != null) {
                this.f.a(e4);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e4);
            }
        } catch (i e5) {
            if (this.f != null) {
                this.f.a(e5);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e5);
            }
        } catch (IOException e6) {
            if (this.f != null) {
                this.f.a(e6);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e6);
            }
        } catch (JSONException e7) {
            if (this.f != null) {
                this.f.a(e7);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e7);
            }
        } catch (Exception e8) {
            if (this.f != null) {
                this.f.a(e8);
                j.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e8);
            }
        }
    }
}
