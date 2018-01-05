package com.baidu.mobads.openad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class a extends Observable implements IOAdDownloader, Runnable {
    protected Context a;
    protected URL b;
    protected URL c;
    protected String d;
    protected int e;
    protected Boolean f = Boolean.valueOf(true);
    protected String g;
    protected int h;
    protected DownloadStatus i;
    protected volatile int j;
    protected int k;
    protected ArrayList l;
    g m = null;
    private String n;
    private String o;

    public class a implements Runnable {
        protected int a;
        protected URL b;
        protected String c;
        protected int d;
        protected int e;
        protected int f;
        protected boolean g;
        protected Thread h;
        final /* synthetic */ a i;
        private volatile boolean j = false;
        private volatile int k = 0;
        private HttpURLConnection l;

        public a(a aVar, int i, URL url, String str, int i2, int i3, int i4) {
            this.i = aVar;
            this.a = i;
            this.b = url;
            this.c = str;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = false;
        }

        public void a(HttpURLConnection httpURLConnection) {
            this.l = httpURLConnection;
        }

        public boolean a() {
            return this.g;
        }

        public synchronized void b() {
            this.j = false;
            this.h = new Thread(this);
            this.h.start();
        }

        public synchronized void c() {
            this.j = true;
            this.k++;
        }

        public void d() {
            if (this.h != null) {
                this.h.join();
                return;
            }
            m.a().f().w("DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null");
        }

        public void run() {
            RandomAccessFile randomAccessFile;
            BufferedInputStream bufferedInputStream;
            HttpURLConnection httpURLConnection;
            IXAdLogger f;
            Object[] objArr;
            Exception e;
            HttpURLConnection httpURLConnection2;
            BufferedInputStream bufferedInputStream2;
            Throwable th;
            RandomAccessFile randomAccessFile2 = null;
            int i = this.k;
            BufferedInputStream bufferedInputStream3 = null;
            RandomAccessFile randomAccessFile3 = null;
            try {
                if (this.d + this.f >= this.e) {
                    this.g = true;
                    randomAccessFile = null;
                    bufferedInputStream = null;
                    httpURLConnection = null;
                } else {
                    if (this.l == null) {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) this.b.openConnection();
                        try {
                            if (this.i.f.booleanValue()) {
                                httpURLConnection3.setRequestProperty("Range", "bytes=" + ((this.d + this.f) + "-" + this.e));
                            } else {
                                this.f = 0;
                            }
                            httpURLConnection3.connect();
                            int responseCode = httpURLConnection3.getResponseCode();
                            if (i != this.k) {
                                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (null != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException e2) {
                                        m.a().f().w("DownloadThread", e2.getMessage());
                                    }
                                }
                                if (null != null) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (IOException e3) {
                                        m.a().f().w("DownloadThread", e3.getMessage());
                                    }
                                }
                                if (httpURLConnection3 != null) {
                                    try {
                                        httpURLConnection3.disconnect();
                                        return;
                                    } catch (Exception e4) {
                                        f = m.a().f();
                                        objArr = new Object[]{"DownloadThread", e4.getMessage()};
                                        f.w(objArr);
                                        return;
                                    }
                                }
                                return;
                            } else if (responseCode / 100 != 2) {
                                this.i.b();
                                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (null != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException e22) {
                                        m.a().f().w("DownloadThread", e22.getMessage());
                                    }
                                }
                                if (null != null) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (IOException e32) {
                                        m.a().f().w("DownloadThread", e32.getMessage());
                                    }
                                }
                                if (httpURLConnection3 != null) {
                                    try {
                                        httpURLConnection3.disconnect();
                                        return;
                                    } catch (Exception e42) {
                                        f = m.a().f();
                                        objArr = new Object[]{"DownloadThread", e42.getMessage()};
                                        f.w(objArr);
                                        return;
                                    }
                                }
                                return;
                            } else if (httpURLConnection3.getContentType().equals("text/html")) {
                                this.i.b();
                                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (null != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (IOException e222) {
                                        m.a().f().w("DownloadThread", e222.getMessage());
                                    }
                                }
                                if (null != null) {
                                    try {
                                        bufferedInputStream3.close();
                                    } catch (IOException e322) {
                                        m.a().f().w("DownloadThread", e322.getMessage());
                                    }
                                }
                                if (httpURLConnection3 != null) {
                                    try {
                                        httpURLConnection3.disconnect();
                                        return;
                                    } catch (Exception e422) {
                                        f = m.a().f();
                                        objArr = new Object[]{"DownloadThread", e422.getMessage()};
                                        f.w(objArr);
                                        return;
                                    }
                                }
                                return;
                            } else {
                                httpURLConnection = httpURLConnection3;
                            }
                        } catch (Exception e5) {
                            httpURLConnection2 = httpURLConnection3;
                            e422 = e5;
                            randomAccessFile = null;
                            try {
                                m.a().f().d("DownloadThread", e422.getMessage());
                                if (i == this.k) {
                                    this.i.b();
                                }
                                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e6) {
                                        m.a().f().w("DownloadThread", e6.getMessage());
                                    }
                                }
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e62) {
                                        m.a().f().w("DownloadThread", e62.getMessage());
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (Exception e4222) {
                                        f = m.a().f();
                                        objArr = new Object[]{"DownloadThread", e4222.getMessage()};
                                        f.w(objArr);
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection = httpURLConnection2;
                                bufferedInputStream = bufferedInputStream2;
                                randomAccessFile2 = randomAccessFile;
                                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e3222) {
                                        m.a().f().w("DownloadThread", e3222.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e32222) {
                                        m.a().f().w("DownloadThread", e32222.getMessage());
                                    }
                                }
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e52) {
                                        m.a().f().w("DownloadThread", e52.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            bufferedInputStream = null;
                            httpURLConnection = httpURLConnection3;
                            th = th3;
                            m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    HttpURLConnection httpURLConnection4 = this.l;
                    try {
                        this.l = null;
                        httpURLConnection = httpURLConnection4;
                    } catch (Exception e7) {
                        e4222 = e7;
                        httpURLConnection2 = httpURLConnection4;
                        randomAccessFile = null;
                        m.a().f().d("DownloadThread", e4222.getMessage());
                        if (i == this.k) {
                            this.i.b();
                        }
                        m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection4;
                        m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            int i2 = this.d + this.f;
                            m.a().f().d("DownloadThread", "tmpStartByte = " + i2);
                            randomAccessFile = new RandomAccessFile(this.c, "rw");
                            try {
                                randomAccessFile.seek((long) i2);
                                byte[] bArr = new byte[102400];
                                while (this.i.i == DownloadStatus.DOWNLOADING) {
                                    int read = bufferedInputStream.read(bArr, 0, 102400);
                                    if (read == -1 || i2 >= this.e || i != this.k) {
                                        break;
                                    }
                                    randomAccessFile.write(bArr, 0, read);
                                    this.f += read;
                                    i2 += read;
                                    this.i.a(read);
                                    synchronized (this) {
                                        if (this.j) {
                                        }
                                    }
                                }
                                if (i2 >= this.e) {
                                    this.g = true;
                                }
                            } catch (Exception e8) {
                                e4222 = e8;
                                bufferedInputStream2 = bufferedInputStream;
                                httpURLConnection2 = httpURLConnection;
                            } catch (Throwable th5) {
                                th = th5;
                                randomAccessFile2 = randomAccessFile;
                            }
                        } catch (Exception e9) {
                            e4222 = e9;
                            randomAccessFile = null;
                            bufferedInputStream2 = bufferedInputStream;
                            httpURLConnection2 = httpURLConnection;
                            m.a().f().d("DownloadThread", e4222.getMessage());
                            if (i == this.k) {
                                this.i.b();
                            }
                            m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        e4222 = e10;
                        randomAccessFile = null;
                        httpURLConnection2 = httpURLConnection;
                        m.a().f().d("DownloadThread", e4222.getMessage());
                        if (i == this.k) {
                            this.i.b();
                        }
                        m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedInputStream = null;
                        m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e622) {
                        m.a().f().w("DownloadThread", e622.getMessage());
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6222) {
                        m.a().f().w("DownloadThread", e6222.getMessage());
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e42222) {
                        f = m.a().f();
                        objArr = new Object[]{"DownloadThread", e42222.getMessage()};
                    }
                }
            } catch (Exception e11) {
                e42222 = e11;
                randomAccessFile = null;
                httpURLConnection2 = null;
                m.a().f().d("DownloadThread", e42222.getMessage());
                if (i == this.k) {
                    this.i.b();
                }
                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th8) {
                th = th8;
                bufferedInputStream = null;
                httpURLConnection = null;
                m.a().f().d("DownloadThread", "Thread[" + this.a + "] ver(" + i + ") executed end; isFinished=" + this.g);
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        }
    }

    public a(Context context, URL url, String str, String str2, int i, String str3, String str4) {
        this.a = context;
        this.b = url;
        this.d = str;
        this.e = i;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.g = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.g = str2;
        }
        this.h = -1;
        this.i = DownloadStatus.NONE;
        this.j = 0;
        this.k = 0;
        this.n = str3;
        this.o = str4;
        this.l = new ArrayList();
    }

    protected void a() {
        setChanged();
        notifyObservers();
    }

    protected synchronized void a(int i) {
        this.j += i;
        int progress = (int) getProgress();
        if (this.k < progress) {
            this.k = progress;
            a();
        }
    }

    protected void a(DownloadStatus downloadStatus) {
        this.i = downloadStatus;
        a();
    }

    protected void a(HttpURLConnection httpURLConnection) {
        Throwable e;
        List arrayList;
        int i;
        int i2;
        int round;
        int i3;
        Object obj;
        List arrayList2;
        Iterator it;
        a aVar;
        String url = this.c.toString();
        String str = (this.d + this.g) + ".tmp";
        if (this.l.size() == 0) {
            RandomAccessFile randomAccessFile;
            a aVar2;
            File file = new File(this.d);
            if (!file.exists()) {
                file.mkdirs();
            }
            List list = null;
            File file2 = new File(str);
            if (this.f.booleanValue() && file2.exists() && file2.length() == ((long) this.h)) {
                List arrayList3;
                try {
                    this.m = new g(this.a);
                    List<h> b = this.m.b(url, str);
                    if (b != null && b.size() > 0) {
                        arrayList3 = new ArrayList();
                        try {
                            HashSet hashSet = new HashSet();
                            for (h hVar : b) {
                                if (!hashSet.contains(Integer.valueOf(hVar.c()))) {
                                    hashSet.add(Integer.valueOf(hVar.c()));
                                    arrayList3.add(hVar);
                                    m.a().f().d("Downloader", "resume from db: start=" + hVar.d() + ";end =" + hVar.e() + ";complete=" + hVar.a());
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            m.a().f().d("Downloader", e);
                            list = arrayList3;
                            if (file2.exists()) {
                                file2.delete();
                            }
                            try {
                                file2.createNewFile();
                                randomAccessFile = new RandomAccessFile(file2, "rwd");
                                randomAccessFile.setLength((long) this.h);
                                randomAccessFile.close();
                                m.a().f().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                                arrayList = new ArrayList();
                                i = -1;
                                i2 = 0;
                                if (this.e > 1) {
                                    round = Math.round((((float) this.h) / ((float) this.e)) / 102400.0f) * 102400;
                                    while (i < this.h) {
                                        i3 = i + 1;
                                        i = i + round < this.h ? i + round : this.h;
                                        i2++;
                                        arrayList.add(new h(i2, url, str, i3, i, 0));
                                    }
                                    list = arrayList;
                                } else {
                                    arrayList.add(new h(1, url, str, 0, this.h, 0));
                                    list = arrayList;
                                }
                                for (h hVar2 : r2) {
                                    aVar2 = new a(this, hVar2.c(), this.c, hVar2.f(), hVar2.d(), hVar2.e(), hVar2.a());
                                    aVar2.a(httpURLConnection);
                                    this.l.add(aVar2);
                                }
                                if (this.f.booleanValue()) {
                                    i3 = 0;
                                    for (i2 = 0; i2 < this.l.size(); i2++) {
                                        i3 += ((a) this.l.get(i2)).f;
                                    }
                                } else {
                                    i3 = 0;
                                }
                                this.j = i3;
                                this.k = (int) getProgress();
                                a(DownloadStatus.DOWNLOADING);
                                m.a().f().d("Downloader", "Downloader starts unfinished threads and waits threads end");
                                for (i2 = 0; i2 < this.l.size(); i2++) {
                                    if (((a) this.l.get(i2)).a()) {
                                        ((a) this.l.get(i2)).b();
                                    }
                                }
                                for (i2 = 0; i2 < this.l.size(); i2++) {
                                    if (((a) this.l.get(i2)).a()) {
                                        ((a) this.l.get(i2)).d();
                                    }
                                }
                                if (this.i != DownloadStatus.DOWNLOADING) {
                                    for (i2 = 0; i2 < this.l.size(); i2++) {
                                        if (((a) this.l.get(i2)).a()) {
                                            obj = 1;
                                            break;
                                        }
                                    }
                                    obj = null;
                                    if (obj != null) {
                                        a(DownloadStatus.ERROR);
                                    } else {
                                        a(this.l);
                                        a(DownloadStatus.COMPLETED);
                                    }
                                } else if (this.i != DownloadStatus.ERROR) {
                                    a(DownloadStatus.ERROR);
                                } else if (this.i != DownloadStatus.CANCELLED) {
                                    m.a().f().d("Downloader", "Downloader is cancelled");
                                } else if (this.i == DownloadStatus.PAUSED) {
                                    m.a().f().d("Downloader", "Downloader is paused");
                                }
                                if (this.i == DownloadStatus.COMPLETED) {
                                    m.a().f().d("Downloader", "save database now");
                                    if (!this.f.booleanValue()) {
                                        try {
                                            if (this.m == null) {
                                                this.m = new g(this.a);
                                            }
                                            arrayList2 = new ArrayList();
                                            it = this.l.iterator();
                                            while (it.hasNext()) {
                                                aVar = (a) it.next();
                                                arrayList2.add(new h(aVar.a, url, str, aVar.d, aVar.e, aVar.f));
                                                m.a().f().d("Downloader", "save to db: start=" + aVar.d + ";end =" + aVar.e + ";complete=" + aVar.f);
                                            }
                                            if (this.m.a(url, str)) {
                                                this.m.b(arrayList2);
                                            } else {
                                                this.m.a(arrayList2);
                                            }
                                        } catch (Throwable e3) {
                                            m.a().f().d("Downloader", e3);
                                            return;
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                m.a().f().d("Downloader", " 建立文件失败:");
                                a(DownloadStatus.ERROR);
                                return;
                            }
                        }
                        list = arrayList3;
                    }
                } catch (Throwable e5) {
                    Throwable th = e5;
                    arrayList3 = null;
                    e3 = th;
                    m.a().f().d("Downloader", e3);
                    list = arrayList3;
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    randomAccessFile = new RandomAccessFile(file2, "rwd");
                    randomAccessFile.setLength((long) this.h);
                    randomAccessFile.close();
                    m.a().f().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                    arrayList = new ArrayList();
                    i = -1;
                    i2 = 0;
                    if (this.e > 1) {
                        arrayList.add(new h(1, url, str, 0, this.h, 0));
                        list = arrayList;
                    } else {
                        round = Math.round((((float) this.h) / ((float) this.e)) / 102400.0f) * 102400;
                        while (i < this.h) {
                            i3 = i + 1;
                            if (i + round < this.h) {
                            }
                            i2++;
                            arrayList.add(new h(i2, url, str, i3, i, 0));
                        }
                        list = arrayList;
                    }
                    for (h hVar22 : r2) {
                        aVar2 = new a(this, hVar22.c(), this.c, hVar22.f(), hVar22.d(), hVar22.e(), hVar22.a());
                        aVar2.a(httpURLConnection);
                        this.l.add(aVar2);
                    }
                    if (this.f.booleanValue()) {
                        i3 = 0;
                    } else {
                        i3 = 0;
                        for (i2 = 0; i2 < this.l.size(); i2++) {
                            i3 += ((a) this.l.get(i2)).f;
                        }
                    }
                    this.j = i3;
                    this.k = (int) getProgress();
                    a(DownloadStatus.DOWNLOADING);
                    m.a().f().d("Downloader", "Downloader starts unfinished threads and waits threads end");
                    for (i2 = 0; i2 < this.l.size(); i2++) {
                        if (((a) this.l.get(i2)).a()) {
                            ((a) this.l.get(i2)).b();
                        }
                    }
                    for (i2 = 0; i2 < this.l.size(); i2++) {
                        if (((a) this.l.get(i2)).a()) {
                            ((a) this.l.get(i2)).d();
                        }
                    }
                    if (this.i != DownloadStatus.DOWNLOADING) {
                        for (i2 = 0; i2 < this.l.size(); i2++) {
                            if (((a) this.l.get(i2)).a()) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            a(this.l);
                            a(DownloadStatus.COMPLETED);
                        } else {
                            a(DownloadStatus.ERROR);
                        }
                    } else if (this.i != DownloadStatus.ERROR) {
                        a(DownloadStatus.ERROR);
                    } else if (this.i != DownloadStatus.CANCELLED) {
                        m.a().f().d("Downloader", "Downloader is cancelled");
                    } else if (this.i == DownloadStatus.PAUSED) {
                        m.a().f().d("Downloader", "Downloader is paused");
                    }
                    if (this.i == DownloadStatus.COMPLETED) {
                        m.a().f().d("Downloader", "save database now");
                        if (!this.f.booleanValue()) {
                            if (this.m == null) {
                                this.m = new g(this.a);
                            }
                            arrayList2 = new ArrayList();
                            it = this.l.iterator();
                            while (it.hasNext()) {
                                aVar = (a) it.next();
                                arrayList2.add(new h(aVar.a, url, str, aVar.d, aVar.e, aVar.f));
                                m.a().f().d("Downloader", "save to db: start=" + aVar.d + ";end =" + aVar.e + ";complete=" + aVar.f);
                            }
                            if (this.m.a(url, str)) {
                                this.m.a(arrayList2);
                            } else {
                                this.m.b(arrayList2);
                            }
                        }
                    }
                }
            }
            if (list == null || list.size() < 1) {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                randomAccessFile = new RandomAccessFile(file2, "rwd");
                randomAccessFile.setLength((long) this.h);
                randomAccessFile.close();
                m.a().f().d("Downloader.init():  建立完random文件 ts:" + System.currentTimeMillis());
                arrayList = new ArrayList();
                i = -1;
                i2 = 0;
                if (this.e > 1) {
                    round = Math.round((((float) this.h) / ((float) this.e)) / 102400.0f) * 102400;
                    while (i < this.h) {
                        i3 = i + 1;
                        if (i + round < this.h) {
                        }
                        i2++;
                        arrayList.add(new h(i2, url, str, i3, i, 0));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(new h(1, url, str, 0, this.h, 0));
                    list = arrayList;
                }
            }
            for (h hVar222 : r2) {
                aVar2 = new a(this, hVar222.c(), this.c, hVar222.f(), hVar222.d(), hVar222.e(), hVar222.a());
                if (hVar222.d() == 0 && hVar222.a() == 0) {
                    aVar2.a(httpURLConnection);
                }
                this.l.add(aVar2);
            }
        }
        if (this.f.booleanValue()) {
            i3 = 0;
            for (i2 = 0; i2 < this.l.size(); i2++) {
                i3 += ((a) this.l.get(i2)).f;
            }
        } else {
            i3 = 0;
        }
        this.j = i3;
        this.k = (int) getProgress();
        a(DownloadStatus.DOWNLOADING);
        m.a().f().d("Downloader", "Downloader starts unfinished threads and waits threads end");
        for (i2 = 0; i2 < this.l.size(); i2++) {
            if (((a) this.l.get(i2)).a()) {
                ((a) this.l.get(i2)).b();
            }
        }
        for (i2 = 0; i2 < this.l.size(); i2++) {
            if (((a) this.l.get(i2)).a()) {
                ((a) this.l.get(i2)).d();
            }
        }
        if (this.i != DownloadStatus.DOWNLOADING) {
            for (i2 = 0; i2 < this.l.size(); i2++) {
                if (((a) this.l.get(i2)).a()) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                a(DownloadStatus.ERROR);
            } else {
                a(this.l);
                a(DownloadStatus.COMPLETED);
            }
        } else if (this.i != DownloadStatus.ERROR) {
            a(DownloadStatus.ERROR);
        } else if (this.i != DownloadStatus.CANCELLED) {
            m.a().f().d("Downloader", "Downloader is cancelled");
        } else if (this.i == DownloadStatus.PAUSED) {
            m.a().f().d("Downloader", "Downloader is paused");
        }
        if (this.i == DownloadStatus.COMPLETED) {
            m.a().f().d("Downloader", "save database now");
            if (!this.f.booleanValue()) {
                if (this.m == null) {
                    this.m = new g(this.a);
                }
                arrayList2 = new ArrayList();
                it = this.l.iterator();
                while (it.hasNext()) {
                    aVar = (a) it.next();
                    arrayList2.add(new h(aVar.a, url, str, aVar.d, aVar.e, aVar.f));
                    m.a().f().d("Downloader", "save to db: start=" + aVar.d + ";end =" + aVar.e + ";complete=" + aVar.f);
                }
                if (this.m.a(url, str)) {
                    this.m.b(arrayList2);
                } else {
                    this.m.a(arrayList2);
                }
            }
        }
    }

    protected void a(ArrayList arrayList) {
        m.a().k().renameFile(this.d + this.g + ".tmp", this.d + this.g);
    }

    protected synchronized void b() {
        this.i = DownloadStatus.ERROR;
        for (int i = 0; i < this.l.size(); i++) {
            if (!((a) this.l.get(i)).a()) {
                ((a) this.l.get(i)).c();
            }
        }
    }

    public void cancel() {
        try {
            m.a().f().d("Downloader", "execute Cancel; state = " + this.i);
            if (this.i == DownloadStatus.PAUSED || this.i == DownloadStatus.DOWNLOADING) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!((a) this.l.get(i)).a()) {
                            ((a) this.l.get(i)).c();
                        }
                    }
                }
                a(DownloadStatus.CANCELLED);
            }
        } catch (Exception e) {
            m.a().f().d("Downloader", "cancel exception");
            com.baidu.mobads.c.a.a().a("apk download cancel failed: " + e.toString());
        }
    }

    public int getFileSize() {
        return this.h;
    }

    public String getOutputPath() {
        return this.d + this.g;
    }

    public String getPackageName() {
        return this.o;
    }

    public float getProgress() {
        return Math.abs((((float) this.j) / ((float) this.h)) * 100.0f);
    }

    public DownloadStatus getState() {
        return this.i;
    }

    public String getTargetURL() {
        return this.c == null ? null : this.c.toString();
    }

    public String getTitle() {
        return this.n;
    }

    public String getURL() {
        return this.b.toString();
    }

    public void pause() {
        try {
            m.a().f().d("Downloader", "execute Pause; state = " + this.i);
            if (this.i == DownloadStatus.DOWNLOADING || this.i == DownloadStatus.ERROR || this.i == DownloadStatus.NONE) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!((a) this.l.get(i)).a()) {
                            ((a) this.l.get(i)).c();
                        }
                    }
                }
                a(DownloadStatus.PAUSED);
            }
        } catch (Exception e) {
            m.a().f().d("Downloader", "pause exception");
            com.baidu.mobads.c.a.a().a("apk download pause failed: " + e.toString());
        }
    }

    public void removeObservers() {
        deleteObservers();
    }

    public void resume() {
        try {
            m.a().f().d("Downloader", "execute Resume; state = " + this.i);
            if (this.i == DownloadStatus.PAUSED || this.i == DownloadStatus.ERROR || this.i == DownloadStatus.CANCELLED) {
                a(DownloadStatus.INITING);
                new Thread(this).start();
            }
        } catch (Exception e) {
            m.a().f().d("Downloader", "resume exception");
            com.baidu.mobads.c.a.a().a("apk download resume failed: " + e.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
        r0 = 0;
        r3 = 1;
        r1 = r5.c;
        if (r1 == 0) goto L_0x000a;
    L_0x0006:
        r1 = r5.h;
        if (r1 >= r3) goto L_0x00d5;
    L_0x000a:
        r1 = com.baidu.mobads.j.m.a();	 Catch:{ Exception -> 0x00c1, all -> 0x00cb }
        r1 = r1.i();	 Catch:{ Exception -> 0x00c1, all -> 0x00cb }
        r2 = r5.b;	 Catch:{ Exception -> 0x00c1, all -> 0x00cb }
        r0 = r1.getHttpURLConnection(r2);	 Catch:{ Exception -> 0x00c1, all -> 0x00cb }
        r1 = "Range";
        r2 = "bytes=0-";
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x00c1 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x00c1 }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ Exception -> 0x00c1 }
        r0.connect();	 Catch:{ Exception -> 0x00c1 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00c1 }
        r1 = r1 / 100;
        r2 = 2;
        if (r1 == r2) goto L_0x0041;
    L_0x0036:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00c1 }
        r5.a(r1);	 Catch:{ Exception -> 0x00c1 }
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r0.disconnect();
    L_0x0040:
        return;
    L_0x0041:
        r1 = r0.getContentType();	 Catch:{ Exception -> 0x00c1 }
        r2 = "text/html";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x00c1 }
        if (r1 == 0) goto L_0x0056;
    L_0x004e:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00c1 }
        r5.a(r1);	 Catch:{ Exception -> 0x00c1 }
        if (r0 == 0) goto L_0x0040;
    L_0x0055:
        goto L_0x003d;
    L_0x0056:
        r1 = r0.getContentLength();	 Catch:{ Exception -> 0x00c1 }
        if (r1 >= r3) goto L_0x0064;
    L_0x005c:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00c1 }
        r5.a(r1);	 Catch:{ Exception -> 0x00c1 }
        if (r0 == 0) goto L_0x0040;
    L_0x0063:
        goto L_0x003d;
    L_0x0064:
        r2 = 5120000; // 0x4e2000 float:7.174648E-39 double:2.529616E-317;
        if (r1 >= r2) goto L_0x006c;
    L_0x0069:
        r2 = 1;
        r5.e = r2;	 Catch:{ Exception -> 0x00c1 }
    L_0x006c:
        r2 = r0.getURL();	 Catch:{ Exception -> 0x00c1 }
        r5.c = r2;	 Catch:{ Exception -> 0x00c1 }
        r2 = "mounted";
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x00c1 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00c1 }
        if (r2 != 0) goto L_0x0087;
    L_0x007f:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x00c1 }
        r5.a(r1);	 Catch:{ Exception -> 0x00c1 }
        if (r0 == 0) goto L_0x0040;
    L_0x0086:
        goto L_0x003d;
    L_0x0087:
        r2 = "Content-Range";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00c1 }
        if (r2 != 0) goto L_0x00b3;
    L_0x0090:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00c1 }
        if (r2 == 0) goto L_0x00a9;
    L_0x0099:
        r2 = "Accept-Ranges";
        r2 = r0.getHeaderField(r2);	 Catch:{ Exception -> 0x00c1 }
        r3 = "none";
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x00c1 }
        if (r2 == 0) goto L_0x00b3;
    L_0x00a9:
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00c1 }
        r5.f = r2;	 Catch:{ Exception -> 0x00c1 }
        r2 = 1;
        r5.e = r2;	 Catch:{ Exception -> 0x00c1 }
    L_0x00b3:
        r2 = r5.h;	 Catch:{ Exception -> 0x00c1 }
        r3 = -1;
        if (r2 != r3) goto L_0x00ba;
    L_0x00b8:
        r5.h = r1;	 Catch:{ Exception -> 0x00c1 }
    L_0x00ba:
        r5.a(r0);	 Catch:{ Exception -> 0x00c1 }
        if (r0 == 0) goto L_0x0040;
    L_0x00bf:
        goto L_0x003d;
    L_0x00c1:
        r1 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ all -> 0x00f1 }
        r5.a(r1);	 Catch:{ all -> 0x00f1 }
        if (r0 == 0) goto L_0x0040;
    L_0x00c9:
        goto L_0x003d;
    L_0x00cb:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x00cf:
        if (r1 == 0) goto L_0x00d4;
    L_0x00d1:
        r1.disconnect();
    L_0x00d4:
        throw r0;
    L_0x00d5:
        r0 = 0;
        r5.a(r0);	 Catch:{ Exception -> 0x00db }
        goto L_0x0040;
    L_0x00db:
        r0 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r5.a(r1);
        r1 = com.baidu.mobads.j.m.a();
        r1 = r1.f();
        r2 = "Downloader";
        r1.d(r2, r0);
        goto L_0x0040;
    L_0x00f1:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x00cf;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.c.a.run():void");
    }

    public void start() {
        m.a().f().d("Downloader", "execute Start; state = " + this.i);
        if (this.i == DownloadStatus.NONE) {
            a(DownloadStatus.INITING);
            new Thread(this).start();
        }
    }
}
