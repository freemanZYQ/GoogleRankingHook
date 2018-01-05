package com.xinmei365.fontsdk.b;

import android.text.TextUtils;
import com.xinmei365.fontsdk.a.e;
import com.xinmei365.fontsdk.c.a;
import com.xinmei365.fontsdk.c.d;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

class b extends Thread {
    private c ag;

    b(c cVar) {
        this.ag = cVar;
    }

    private byte[] y() {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (a.ap == -1) {
                this.ag.errorCode = 1001;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return httpURLConnection2;
            } else if (TextUtils.isEmpty(this.ag.E)) {
                this.ag.errorCode = 1002;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return httpURLConnection2;
            } else {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.ag.E).openConnection();
                try {
                    httpURLConnection3.setRequestProperty("encoding", "UTF-8");
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.setRequestMethod("GET");
                    if (httpURLConnection3.getResponseCode() == 200) {
                        InputStream bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                        byte[] a = com.xinmei365.fontsdk.c.b.a(bufferedInputStream);
                        d.a(bufferedInputStream);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        return a;
                    }
                    throw new RuntimeException("Could Not Connect,ResponseCode " + httpURLConnection3.getResponseCode());
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection3;
                    exception = exception2;
                    try {
                        this.ag.errorCode = 1003;
                        this.ag.aj = exception.getMessage();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return httpURLConnection2;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection2 = httpURLConnection3;
                    th = th4;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = httpURLConnection2;
            this.ag.errorCode = 1003;
            this.ag.aj = exception.getMessage();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return httpURLConnection2;
        } catch (Throwable th5) {
            th = th5;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    void a(byte[] bArr, boolean z) {
        if (bArr != null) {
            SoftReference softReference;
            try {
                softReference = new SoftReference(new String(bArr, "UTF-8"));
            } catch (Exception e) {
                softReference = null;
            }
            if (!(softReference == null || softReference.get() == null)) {
                this.ag.y((String) softReference.get());
            }
        }
        if (this.ag.obj != null) {
            this.ag.onSuccess();
            e.t();
            bArr = null;
        } else if (z) {
            this.ag.C();
            b(y(), false);
        } else {
            this.ag.A();
        }
        if (bArr == null) {
        }
    }

    void b(byte[] bArr, boolean z) {
        SoftReference softReference;
        try {
            softReference = new SoftReference(new String(bArr, "UTF-8"));
        } catch (Exception e) {
            softReference = null;
        }
        if (!(softReference == null || softReference.get() == null)) {
            this.ag.y((String) softReference.get());
        }
        if (this.ag.obj != null) {
            this.ag.a(bArr);
            this.ag.onSuccess();
            if (!TextUtils.isEmpty(this.ag.E) && this.ag.E.contains("font/list")) {
                e.w();
            }
            e.s();
        } else if (z) {
            a(this.ag.c(true), false);
        } else {
            this.ag.A();
        }
        if (bArr == null) {
        }
    }

    public void run() {
        byte[] c = this.ag.c(false);
        if (c != null) {
            a(c, true);
            return;
        }
        c = y();
        if (this.ag.ak) {
            b(c, true);
        } else {
            b(c, false);
        }
    }
}
