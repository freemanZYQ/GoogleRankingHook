package com.vlocker.new_theme.a;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class k implements HttpRequestRetryHandler {
    private static HashSet a = new HashSet();
    private static HashSet b = new HashSet();
    private final int c;

    static {
        a.add(NoHttpResponseException.class);
        a.add(UnknownHostException.class);
        a.add(SocketException.class);
        b.add(InterruptedIOException.class);
        b.add(SSLHandshakeException.class);
    }

    public k(int i) {
        this.c = i;
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = true;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z2 = bool != null && bool.booleanValue();
        z2 = i > this.c ? false : b.contains(iOException.getClass()) ? false : a.contains(iOException.getClass()) ? true : !z2 ? true : true;
        if (z2) {
            HttpUriRequest httpUriRequest = (HttpUriRequest) httpContext.getAttribute("http.request");
            if (httpUriRequest == null || "POST".equals(httpUriRequest.getMethod())) {
                z = false;
            }
        } else {
            z = z2;
        }
        if (z) {
            SystemClock.sleep(1000);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }
}
