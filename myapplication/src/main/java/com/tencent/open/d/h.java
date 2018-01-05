package com.tencent.open.d;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class h extends SSLSocketFactory {
    private final SSLContext a = SSLContext.getInstance("TLS");

    public h(KeyStore keyStore) {
        j jVar;
        super(keyStore);
        try {
            jVar = new j();
        } catch (Exception e) {
            jVar = null;
        }
        this.a.init(null, new TrustManager[]{jVar}, null);
    }

    public Socket createSocket() {
        return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return this.a.getSocketFactory().createSocket(socket, str, i, z);
    }
}
