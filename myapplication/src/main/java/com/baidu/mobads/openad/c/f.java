package com.baidu.mobads.openad.c;

import android.content.Context;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

public class f extends Observable implements IOAdDownloader, Runnable {
    protected Context a;
    protected URL b;
    protected String c;
    protected String d;
    protected int e;
    protected DownloadStatus f;
    protected int g;
    protected int h;
    private boolean i = false;

    protected f(Context context, URL url, String str, String str2, boolean z) {
        this.a = context;
        this.b = url;
        this.c = str;
        this.i = z;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.d = str2;
        }
        this.e = -1;
        this.f = DownloadStatus.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    private void d() {
        a(DownloadStatus.ERROR);
    }

    protected void a() {
        m.a().k().renameFile(this.c + this.d + ".tmp", this.c + this.d);
    }

    protected void a(int i, float f) {
        this.g += i;
        c();
    }

    protected void a(DownloadStatus downloadStatus) {
        this.f = downloadStatus;
        c();
    }

    protected void b() {
        new Thread(this).start();
    }

    protected void c() {
        setChanged();
        notifyObservers();
    }

    @Deprecated
    public void cancel() {
    }

    public int getFileSize() {
        return this.e;
    }

    public String getOutputPath() {
        return this.c + this.d;
    }

    @Deprecated
    public String getPackageName() {
        return null;
    }

    public float getProgress() {
        return Math.abs((((float) this.g) / ((float) this.e)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.f;
    }

    @Deprecated
    public String getTargetURL() {
        return null;
    }

    @Deprecated
    public String getTitle() {
        return null;
    }

    public String getURL() {
        return this.b.toString();
    }

    @Deprecated
    public void pause() {
    }

    public void removeObservers() {
    }

    @Deprecated
    public void resume() {
    }

    public void run() {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        Exception exception;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        BufferedOutputStream bufferedOutputStream2;
        Throwable th2;
        Exception exception2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
            try {
                httpURLConnection3.setConnectTimeout(10000);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.connect();
                if (httpURLConnection3.getResponseCode() / 100 != 2) {
                    d();
                }
                int contentLength = httpURLConnection3.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
            } catch (Exception e) {
                bufferedInputStream = null;
                httpURLConnection = httpURLConnection3;
                exception = e;
                bufferedOutputStream = null;
                try {
                    m.a().f().e("OAdSimpleFileDownloader", exception.getMessage());
                    d();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            m.a().f().e("OAdSimpleFileDownloader", e2.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22) {
                            m.a().f().e("OAdSimpleFileDownloader", e22.getMessage());
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e222) {
                            m.a().f().e("OAdSimpleFileDownloader", e222.getMessage());
                        }
                    }
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                    httpURLConnection2 = httpURLConnection;
                    bufferedInputStream2 = bufferedInputStream;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e3) {
                            m.a().f().e("OAdSimpleFileDownloader", e3.getMessage());
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            m.a().f().e("OAdSimpleFileDownloader", e4.getMessage());
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e42) {
                            m.a().f().e("OAdSimpleFileDownloader", e42.getMessage());
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                bufferedOutputStream2 = null;
                bufferedInputStream2 = null;
                th2 = th4;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
            try {
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
                try {
                    byte[] bArr = new byte[10240];
                    ByteArrayOutputStream byteArrayOutputStream2 = this.i ? new ByteArrayOutputStream() : null;
                    int i = 0;
                    while (this.f == DownloadStatus.DOWNLOADING) {
                        try {
                            int read = bufferedInputStream2.read(bArr, 0, 10240);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream2.write(bArr, 0, read);
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            i += read;
                            a(read, ((float) i) / ((float) this.e));
                        } catch (Exception e5) {
                            exception2 = e5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = bufferedInputStream2;
                            httpURLConnection = httpURLConnection3;
                            exception = exception2;
                        } catch (Throwable th5) {
                            th2 = th5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            httpURLConnection2 = httpURLConnection3;
                            th = th2;
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (this.f == DownloadStatus.DOWNLOADING) {
                        a();
                        a(DownloadStatus.COMPLETED);
                    } else if (this.f == DownloadStatus.ERROR) {
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e422) {
                            m.a().f().e("OAdSimpleFileDownloader", e422.getMessage());
                        }
                    }
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e6) {
                            m.a().f().e("OAdSimpleFileDownloader", e6.getMessage());
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e62) {
                            m.a().f().e("OAdSimpleFileDownloader", e62.getMessage());
                        }
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Exception e7) {
                    exception2 = e7;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    httpURLConnection = httpURLConnection3;
                    exception = exception2;
                    m.a().f().e("OAdSimpleFileDownloader", exception.getMessage());
                    d();
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th42) {
                    th2 = th42;
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e72) {
                bufferedInputStream = bufferedInputStream2;
                httpURLConnection = httpURLConnection3;
                exception = e72;
                bufferedOutputStream = null;
                m.a().f().e("OAdSimpleFileDownloader", exception.getMessage());
                d();
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th422) {
                bufferedOutputStream2 = null;
                th2 = th422;
                httpURLConnection2 = httpURLConnection3;
                th = th2;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e8) {
            exception = e8;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
            m.a().f().e("OAdSimpleFileDownloader", exception.getMessage());
            d();
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
            httpURLConnection2 = null;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public void start() {
        a(DownloadStatus.DOWNLOADING);
        b();
    }
}
