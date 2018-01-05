package com.vlocker.locker.d;

import android.os.SystemClock;
import android.util.Log;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.theme.imageloader.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class j extends a implements a {
    private final AbstractHttpClient d;
    private final HttpContext e;
    private final l f = new l();
    private final b g = new b();
    private i h;
    private int i = 1;
    private String j = null;
    private String k;
    private m l;
    private boolean m;
    private String n;
    private long o;
    private String p;

    public j(AbstractHttpClient abstractHttpClient, HttpContext httpContext, i iVar, String str) {
        this.d = abstractHttpClient;
        this.e = httpContext;
        this.h = iVar;
        this.k = str;
        if (d.a != 0) {
            this.i = d.a;
        }
    }

    private void a(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        StatusLine statusLine = httpResponse.getStatusLine();
        if (statusLine.getStatusCode() >= InitError.INIT_AD_ERROR) {
            String str = "response status error code:" + statusLine.getStatusCode();
            if (statusLine.getStatusCode() == 416) {
                str = str + " \n maybe you have download complete.";
            }
            d(Integer.valueOf(3), new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), Integer.valueOf(statusLine.getStatusCode()), str);
            return;
        }
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                this.o = SystemClock.uptimeMillis();
                if (this.j != null) {
                    if (this.g.a(entity, this, this.j, httpUriRequest) == null) {
                        d(Integer.valueOf(3), new NullPointerException(), Integer.valueOf(0), "宸叉殏鍋�");
                        return;
                    }
                    d(Integer.valueOf(4), this.g.a(entity, this, this.j, httpUriRequest));
                    return;
                }
                n a = this.f.a(entity, this, this.k);
                if (this.l != null) {
                    try {
                        a = this.l.a((String) a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                d(Integer.valueOf(4), a);
            }
        } catch (IOException e2) {
            d(Integer.valueOf(3), e2, Integer.valueOf(0), e2.getMessage());
        }
    }

    private void a(HttpUriRequest httpUriRequest) {
        if (this.j != null) {
            File file = new File(this.j.replace(this.j.substring(this.j.lastIndexOf(".") + 1), "tmp"));
            if (file.isFile() && file.exists()) {
                httpUriRequest.setHeader("RANGE", "bytes=" + file.length() + "-");
            }
        }
        HttpRequestRetryHandler httpRequestRetryHandler = this.d.getHttpRequestRetryHandler();
        boolean z = true;
        while (z) {
            try {
                Log.i("moxiu", z + "");
                if (!c() && this.j == null) {
                    HttpResponse execute = this.d.execute(httpUriRequest, this.e);
                    if (!c()) {
                        a(execute, httpUriRequest);
                        return;
                    }
                    return;
                }
                return;
            } catch (UnknownHostException e) {
                d(Integer.valueOf(3), e, Integer.valueOf(0), "unknownHostException can't resolve host");
                return;
            } catch (IOException e2) {
                int i = this.i + 1;
                this.i = i;
                z = httpRequestRetryHandler.retryRequest(e2, i, this.e);
            } catch (NullPointerException e3) {
                IOException iOException = new IOException("NPE in HttpClient" + e3.getMessage());
                int i2 = this.i + 1;
                this.i = i2;
                z = httpRequestRetryHandler.retryRequest(iOException, i2, this.e);
            } catch (Exception e4) {
                Log.i("moxiu", e4.toString());
                iOException = new IOException("Exception" + e4.getMessage());
                i2 = this.i + 1;
                this.i = i2;
                z = httpRequestRetryHandler.retryRequest(iOException, i2, this.e);
            }
        }
    }

    protected Object a(Object... objArr) {
        if (objArr != null && objArr.length >= 3) {
            this.j = String.valueOf(objArr[0]);
            this.n = String.valueOf(objArr[1]);
            this.p = String.valueOf(objArr[2]);
        }
        try {
            d(Integer.valueOf(1));
            if (this.j != null) {
                a(this.j, this.n);
            } else {
                a((HttpUriRequest) objArr[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            d(Integer.valueOf(3), e, Integer.valueOf(0), e.getMessage());
        }
        return null;
    }

    public void a(long j, long j2, boolean z) {
        if (this.h != null && this.h.a()) {
            if (z) {
                d(Integer.valueOf(2), Long.valueOf(j), Long.valueOf(j2));
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.o >= ((long) this.h.b())) {
                this.o = uptimeMillis;
                d(Integer.valueOf(2), Long.valueOf(j), Long.valueOf(j2));
            }
        }
    }

    public void a(String str, String str2) {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        HttpURLConnection httpURLConnection;
        Exception exception;
        InputStream inputStream2;
        Throwable th;
        Throwable th2;
        if (str2 != null) {
            HttpURLConnection httpURLConnection2 = null;
            RandomAccessFile randomAccessFile3 = null;
            int i = 0;
            try {
                File file = new File(str + ".tmp");
                try {
                    i = file.createNewFile() ? 0 : (int) file.length();
                } catch (IOException e) {
                }
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str2).openConnection();
                try {
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setRequestProperty("Accept-Encoding", "identity");
                    httpURLConnection3.setRequestMethod("GET");
                    httpURLConnection3.addRequestProperty("Range", "bytes=" + i + "-");
                    if (httpURLConnection3.getResponseCode() == 200 || httpURLConnection3.getResponseCode() == 206) {
                        int contentLength;
                        inputStream = httpURLConnection3.getInputStream();
                        try {
                            contentLength = httpURLConnection3.getContentLength() + i;
                            randomAccessFile = new RandomAccessFile(file, "rwd");
                        } catch (Exception e2) {
                            randomAccessFile2 = null;
                            httpURLConnection = httpURLConnection3;
                            exception = e2;
                            inputStream2 = inputStream;
                            try {
                                exception.printStackTrace();
                                d(Integer.valueOf(3), exception, Integer.valueOf(0), "unknownHostException can't resolve host");
                                try {
                                    inputStream2.close();
                                    randomAccessFile2.close();
                                    httpURLConnection.disconnect();
                                } catch (Exception exception2) {
                                    exception2.printStackTrace();
                                    d(Integer.valueOf(3), exception2, Integer.valueOf(0), exception2.getMessage());
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = inputStream2;
                                httpURLConnection2 = httpURLConnection;
                                randomAccessFile3 = randomAccessFile2;
                                try {
                                    inputStream.close();
                                    randomAccessFile3.close();
                                    httpURLConnection2.disconnect();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                    d(Integer.valueOf(3), e22, Integer.valueOf(0), e22.getMessage());
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                            inputStream.close();
                            randomAccessFile3.close();
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                        try {
                            randomAccessFile.seek((long) i);
                            byte[] bArr = new byte[8096];
                            int i2 = i;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                randomAccessFile.write(bArr, 0, read);
                                i = i2 + read;
                                a((long) contentLength, (long) i, false);
                                if (this.m) {
                                    break;
                                }
                                i2 = i;
                            }
                            i2 = i;
                            if (this.m) {
                                d(Integer.valueOf(3), new Exception(), Integer.valueOf(0), "暂停中");
                            } else if (i2 == contentLength) {
                                File file2 = new File(str + this.p);
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                file.renameTo(file2);
                                a((long) contentLength, (long) i2, true);
                                d(Integer.valueOf(4), file2);
                            }
                        } catch (Exception e222) {
                            randomAccessFile2 = randomAccessFile;
                            httpURLConnection = httpURLConnection3;
                            exception2 = e222;
                            inputStream2 = inputStream;
                            exception2.printStackTrace();
                            d(Integer.valueOf(3), exception2, Integer.valueOf(0), "unknownHostException can't resolve host");
                            inputStream2.close();
                            randomAccessFile2.close();
                            httpURLConnection.disconnect();
                        } catch (Throwable th42) {
                            randomAccessFile3 = randomAccessFile;
                            th2 = th42;
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                            inputStream.close();
                            randomAccessFile3.close();
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                    }
                    inputStream = null;
                    randomAccessFile = null;
                    try {
                        inputStream.close();
                        randomAccessFile.close();
                        httpURLConnection3.disconnect();
                    } catch (Exception exception22) {
                        exception22.printStackTrace();
                        d(Integer.valueOf(3), exception22, Integer.valueOf(0), exception22.getMessage());
                    }
                } catch (Exception e2222) {
                    Exception exception3 = e2222;
                    inputStream2 = null;
                    randomAccessFile2 = null;
                    httpURLConnection = httpURLConnection3;
                    exception22 = exception3;
                    exception22.printStackTrace();
                    d(Integer.valueOf(3), exception22, Integer.valueOf(0), "unknownHostException can't resolve host");
                    inputStream2.close();
                    randomAccessFile2.close();
                    httpURLConnection.disconnect();
                } catch (Throwable th422) {
                    inputStream = null;
                    th2 = th422;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    inputStream.close();
                    randomAccessFile3.close();
                    httpURLConnection2.disconnect();
                    throw th;
                }
            } catch (Exception e3) {
                exception22 = e3;
                randomAccessFile2 = null;
                httpURLConnection = null;
                inputStream2 = null;
                exception22.printStackTrace();
                d(Integer.valueOf(3), exception22, Integer.valueOf(0), "unknownHostException can't resolve host");
                inputStream2.close();
                randomAccessFile2.close();
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                inputStream.close();
                randomAccessFile3.close();
                httpURLConnection2.disconnect();
                throw th;
            }
        }
    }

    protected void b(Object... objArr) {
        switch (Integer.valueOf(String.valueOf(objArr[0])).intValue()) {
            case 1:
                if (this.h != null) {
                    this.h.c();
                    break;
                }
                break;
            case 2:
                if (this.h != null) {
                    this.h.a(Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue());
                    break;
                }
                break;
            case 3:
                if (this.h != null) {
                    this.h.a((Throwable) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3]);
                    break;
                }
                break;
            case 4:
                if (this.h != null) {
                    try {
                        this.h.a(objArr[1]);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
                break;
        }
        super.b(objArr);
    }
}
