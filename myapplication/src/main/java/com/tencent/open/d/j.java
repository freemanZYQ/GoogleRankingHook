package com.tencent.open.d;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class j implements X509TrustManager {
    X509TrustManager a;

    j() {
        KeyStore instance;
        Throwable th;
        FileInputStream fileInputStream;
        try {
            instance = KeyStore.getInstance("JKS");
        } catch (Exception e) {
            instance = null;
        }
        TrustManager[] trustManagerArr = new TrustManager[0];
        if (instance != null) {
            try {
                InputStream fileInputStream2 = new FileInputStream("trustedCerts");
                try {
                    instance.load(fileInputStream2, "passphrase".toCharArray());
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    instance2.init(instance);
                    TrustManager[] trustManagers = instance2.getTrustManagers();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = null;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance3.init((KeyStore) null);
        trustManagers = instance3.getTrustManagers();
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof X509TrustManager) {
                this.a = (X509TrustManager) trustManagers[i];
                return;
            }
        }
        throw new Exception("Couldn't initialize");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.a.checkServerTrusted(x509CertificateArr, str);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
