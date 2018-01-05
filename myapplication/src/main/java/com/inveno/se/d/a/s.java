package com.inveno.se.d.a;

import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class s extends SSLSocketFactory {
    private final SSLSocketFactory a;

    public s(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    private static String[] a(SSLSocketFactory sSLSocketFactory) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocketFactory.getDefaultCipherSuites()));
        arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] b(SSLSocketFactory sSLSocketFactory) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocketFactory.getSupportedCipherSuites()));
        arrayList.remove("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add(0, "TLS_RSA_WITH_AES_128_CBC_SHA");
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Socket createSocket(String str, int i) {
        Socket createSocket = this.a.createSocket(str, i);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        Socket createSocket = this.a.createSocket(str, i, inetAddress, i2);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        Socket createSocket = this.a.createSocket(inetAddress, i);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        Socket createSocket = this.a.createSocket(inetAddress, i, inetAddress2, i2);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        Socket createSocket = this.a.createSocket(socket, str, i, z);
        ((SSLSocket) createSocket).setEnabledCipherSuites(a(this.a));
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        return a(this.a);
    }

    public String[] getSupportedCipherSuites() {
        return b(this.a);
    }
}
