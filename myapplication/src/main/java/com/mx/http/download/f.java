package com.mx.http.download;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.mx.http.a;
import com.mx.http.a.b;
import com.mx.http.a.d;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

public class f {
    long a = 0;
    private Context b = null;
    private Handler c = null;
    private a d = null;
    private Thread e = null;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;

    public f(Context context, Handler handler, a aVar) {
        this.b = context;
        this.c = handler;
        this.d = aVar;
    }

    private void c() {
        int i;
        HttpURLConnection httpURLConnection;
        Exception e;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        int i2;
        Throwable th;
        synchronized (this.e) {
            this.h = 0;
            while (this.d.b() == i.DOWNLOADING) {
                this.g = true;
                HttpURLConnection httpURLConnection3 = null;
                InputStream inputStream3 = null;
                RandomAccessFile randomAccessFile = null;
                try {
                    i = this.h + 1;
                    this.h = i;
                    if (i > 3) {
                        this.d.a(i.DOWNLOAD_FAILED);
                        h.a(this.c, 9004, (Object) this);
                        h.a(this.b, 9004, this.d);
                        h.a(this.b, "com.moxiu.http.download.task.state", this.d);
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e2) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e3) {
                            }
                        }
                        return;
                    } else if (this.d.b() != i.DOWNLOADING) {
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        return;
                    } else {
                        File d;
                        RandomAccessFile randomAccessFile2;
                        Object obj = null;
                        long j = 0;
                        httpURLConnection3 = b.a(this.d.d());
                        try {
                            long length;
                            this.g = true;
                            d = d();
                            if (d.exists()) {
                                length = d.length();
                                if (length <= 0) {
                                    File file = new File(d.getAbsolutePath() + System.currentTimeMillis());
                                    d.renameTo(file);
                                    file.delete();
                                } else {
                                    obj = 1;
                                    j = length;
                                }
                            }
                            this.g = true;
                            if (obj != null) {
                                httpURLConnection3.setRequestProperty("Range", "bytes=" + j + "-");
                                httpURLConnection3.connect();
                                httpURLConnection3.getInputStream();
                                length = ((long) httpURLConnection3.getContentLength()) + j;
                                if (!(httpURLConnection3.getResponseCode() == 206 && length >= 0 && length == this.d.e())) {
                                    j = 0;
                                    httpURLConnection3.disconnect();
                                    httpURLConnection3 = b.a(this.d.d());
                                    httpURLConnection3.setConnectTimeout(6000);
                                    httpURLConnection3.setReadTimeout(6000);
                                    httpURLConnection3.setRequestProperty("accept", "*/*");
                                    httpURLConnection3.setRequestProperty("Accept-Encoding", "identity");
                                    httpURLConnection3.setRequestProperty("Connection", "close");
                                }
                            }
                            httpURLConnection = httpURLConnection3;
                        } catch (Exception e6) {
                            e = e6;
                            inputStream = inputStream3;
                            httpURLConnection2 = httpURLConnection3;
                            inputStream2 = inputStream;
                            e.printStackTrace();
                            i = 0;
                            while (this.d.b() == i.DOWNLOADING) {
                                i2 = i + 1;
                                if (i < 10) {
                                    break;
                                }
                                try {
                                    this.e.wait(500);
                                    i = i2;
                                } catch (InterruptedException e7) {
                                    e7.printStackTrace();
                                    i = i2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    httpURLConnection = httpURLConnection2;
                                    inputStream3 = inputStream2;
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e8) {
                                }
                            }
                            if (randomAccessFile == null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e9) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection3;
                        }
                        try {
                            httpURLConnection.connect();
                            httpURLConnection.getInputStream();
                            this.d.b(j);
                            this.d.a(((long) httpURLConnection.getContentLength()) + j);
                            h.a(this.b, "com.moxiu.http.download.task.update", this.d);
                            h.a(this.b, 9005, this.d);
                            randomAccessFile2 = new RandomAccessFile(d, "rw");
                        } catch (Exception e10) {
                            e = e10;
                            inputStream2 = inputStream3;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            i = 0;
                            while (this.d.b() == i.DOWNLOADING) {
                                i2 = i + 1;
                                if (i < 10) {
                                    break;
                                }
                                this.e.wait(500);
                                i = i2;
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (randomAccessFile == null) {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            randomAccessFile2.seek(j);
                            InputStream inputStream4 = httpURLConnection.getInputStream();
                            this.g = true;
                            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
                            this.d.e();
                            long currentTimeMillis = System.currentTimeMillis();
                            h.a(this.b, "com.moxiu.http.download.task.state", this.d);
                            while (this.d.b() == i.DOWNLOADING) {
                                int read = inputStream4.read(bArr);
                                if (read <= 0) {
                                    break;
                                } else if (!d.exists()) {
                                    this.d.a(i.DOWNLOAD_FAILED);
                                    d.a(this.b, this.d.c(), this.d);
                                    h.a(this.c, 9004, (Object) this);
                                    h.a(this.b, 9004, this.d);
                                    h.a(this.b, "com.moxiu.http.download.task.state", this.d);
                                    break;
                                } else {
                                    try {
                                        randomAccessFile2.write(bArr, 0, read);
                                        long j2 = ((long) read) + j;
                                        this.d.b(j2);
                                        j = System.currentTimeMillis();
                                        if (j - currentTimeMillis >= ((long) this.d.p())) {
                                            h.a(this.b, "com.moxiu.http.download.task.update", this.d);
                                            h.a(this.b, 9006, this.d);
                                            currentTimeMillis = j;
                                            j = j2;
                                        } else {
                                            j = j2;
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        httpURLConnection2 = httpURLConnection;
                                        inputStream = inputStream4;
                                        randomAccessFile = randomAccessFile2;
                                        inputStream2 = inputStream;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream3 = inputStream4;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                }
                            }
                            this.g = false;
                            if (this.d.b() == i.DOWNLOADING) {
                                if (d.exists()) {
                                    if ("mounted".equals(Environment.getExternalStorageState())) {
                                        File file2 = new File(a.p);
                                    }
                                    d.renameTo(new File(this.d.f()));
                                }
                                e();
                            } else if (this.d.b() == i.DOWNLOAD_PAUSE) {
                                h.a(this.c, 9003, (Object) this);
                            } else if (this.d.b() == i.DOWNLOAD_PAUSE) {
                                h.a(this.c, 9003, (Object) this);
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (inputStream4 != null) {
                                try {
                                    inputStream4.close();
                                } catch (Exception e12) {
                                }
                            }
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception e13) {
                                }
                            }
                        } catch (Exception e14) {
                            e = e14;
                            randomAccessFile = randomAccessFile2;
                            inputStream2 = inputStream3;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            i = 0;
                            while (this.d.b() == i.DOWNLOADING) {
                                i2 = i + 1;
                                if (i < 10) {
                                    break;
                                }
                                this.e.wait(500);
                                i = i2;
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (randomAccessFile == null) {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            randomAccessFile = randomAccessFile2;
                        }
                    }
                } catch (Exception e15) {
                    e = e15;
                    inputStream = inputStream3;
                    httpURLConnection2 = httpURLConnection3;
                    inputStream2 = inputStream;
                    e.printStackTrace();
                    i = 0;
                    while (this.d.b() == i.DOWNLOADING) {
                        i2 = i + 1;
                        if (i < 10) {
                            break;
                        }
                        this.e.wait(500);
                        i = i2;
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (randomAccessFile == null) {
                        randomAccessFile.close();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    httpURLConnection = httpURLConnection3;
                }
            }
            return;
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (inputStream3 != null) {
            try {
                inputStream3.close();
            } catch (Exception e16) {
            }
        }
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e17) {
            }
        }
        throw th;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        throw th;
        throw th;
    }

    private File d() {
        if (this.d.d() == null) {
            return null;
        }
        File file = new File(this.d.t());
        File file2 = new File(this.d.s());
        if (!(file == null || file.exists())) {
            file.mkdirs();
        }
        if (!(file2 == null || file2.exists())) {
            file2.mkdirs();
        }
        return new File(this.d.u());
    }

    private void e() {
        this.d.b(this.d.e());
        h.a(this.b, "com.moxiu.http.download.task.state", this.d);
        Object obj = (a) d.a(this.b, this.d.c(), a.class);
        this.d.a(i.WAIT_INSTALL);
        if (obj == null) {
            d.a(this.b, this.d.c(), this.d);
        } else {
            obj.a(i.WAIT_INSTALL);
            d.a(this.b, obj.c(), obj);
        }
        h.a(this.b, "com.moxiu.http.download.task.state", this.d);
        h.a(this.b, 9002, this.d);
        h.a(this.c, 9002, (Object) this);
        this.d.o();
    }

    public a a() {
        return this.d;
    }

    public void b() {
        if (this.d.b() == i.DOWNLOADING) {
            this.c.sendEmptyMessage(9001);
            return;
        }
        this.d.a(i.DOWNLOADING);
        Object obj = (a) d.a(this.b, this.d.c(), a.class);
        if (obj == null) {
            d.a(this.b, this.d.c(), this.d);
        } else {
            obj.a(i.DOWNLOADING);
            d.a(this.b, obj.c(), obj);
        }
        h.a(this.b, "com.moxiu.http.download.task.state", this.d);
        if (!this.f) {
            this.e = new g(this);
            this.e.setPriority(1);
            this.e.start();
        }
    }
}
