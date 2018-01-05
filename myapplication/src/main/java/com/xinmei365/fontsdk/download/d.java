package com.xinmei365.fontsdk.download;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.e.comm.constants.ErrorCode.NetWorkError;
import com.xinmei365.fontsdk.c.e;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class d {
    private volatile boolean b;
    private Handler mHandler;
    private int priority;
    private int q;
    private DownloadInfo r;
    private g s;
    private c t;
    private int u;
    private List v;
    private e w;
    private List x;
    private boolean y;

    class a extends Handler {
        final /* synthetic */ d z;

        private a(d dVar, Looper looper) {
            this.z = dVar;
            super(looper);
        }

        private void a(Message message, DownloadListener downloadListener) {
            if (downloadListener != null) {
                switch (this.z.r.getStatus()) {
                    case 0:
                        downloadListener.prepared(this.z.r);
                        return;
                    case 1:
                        downloadListener.waited(this.z.r);
                        return;
                    case 2:
                        downloadListener.processing(this.z.r);
                        return;
                    case 3:
                        downloadListener.paused(this.z.r);
                        return;
                    case 4:
                        this.z.delete();
                        downloadListener.canceled(this.z.r);
                        return;
                    case 5:
                        if (!this.z.y) {
                            this.z.y = true;
                            this.z.a(downloadListener);
                            return;
                        }
                        return;
                    case 6:
                        this.z.delete();
                        downloadListener.failed(this.z.r, message.what);
                        return;
                    case 8:
                        downloadListener.failed(this.z.r, message.what);
                        return;
                    default:
                        return;
                }
            }
        }

        public void dispatchMessage(Message message) {
            if (message.what == 100) {
                a(message, (DownloadListener) message.obj);
                return;
            }
            for (int i = 0; i < this.z.x.size(); i++) {
                a(message, (DownloadListener) this.z.x.get(i));
            }
        }
    }

    class b extends Thread {
        private f A;
        final /* synthetic */ d z;

        private b(d dVar, f fVar) {
            this.z = dVar;
            this.A = fVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r9 = this;
            r7 = 6;
            r1 = 0;
            r0 = new java.net.URL;	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r2 = r9.A;	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r2 = r2.getUrl();	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r0.<init>(r2);	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r0 = r0.openConnection();	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x01a8, all -> 0x0174 }
            r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = "GET";
            r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = "Accept-Encoding";
            r3 = "identity";
            r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = r9.z;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = r2.r;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = r2.getTempPath();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = com.xinmei365.fontsdk.download.a.a.h(r2);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            if (r2 != 0) goto L_0x003d;
        L_0x0037:
            r2 = r9.A;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = 0;
            r2.a(r3);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
        L_0x003d:
            r2 = "Range";
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3.<init>();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = "bytes=";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = r9.A;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = r4.getStartPosition();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r5 = r9.A;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r5 = r5.k();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = r4 + r5;
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = "-";
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = r9.A;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = r4.j();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r3.append(r4);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r0.setRequestProperty(r2, r3);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r2 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r9.z;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r3.r;	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r3.getTempPath();	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r4 = "rwd";
            r2.<init>(r3, r4);	 Catch:{ Exception -> 0x01ad, all -> 0x0197 }
            r3 = r9.A;	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r3 = r3.getStartPosition();	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r4 = r9.A;	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r4 = r4.k();	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r3 = r3 + r4;
            r4 = (long) r3;	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r2.seek(r4);	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r1 = r0.getInputStream();	 Catch:{ Exception -> 0x01b2, all -> 0x019c }
            r3 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
            r3 = new byte[r3];	 Catch:{ Exception -> 0x0121, all -> 0x019c }
        L_0x00a1:
            r4 = r1.read(r3);	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = -1;
            if (r4 == r5) goto L_0x00bd;
        L_0x00a8:
            r5 = r9.z;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r5.r;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r5.getStatus();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r6 = 3;
            if (r5 >= r6) goto L_0x00bd;
        L_0x00b5:
            r5 = r9.z;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r5.b;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            if (r5 != 0) goto L_0x00d8;
        L_0x00bd:
            r3 = r9.z;
            r3 = r3.s;
            r4 = r9.A;
            r3.a(r4);
            if (r1 == 0) goto L_0x00cd;
        L_0x00ca:
            r1.close();	 Catch:{ Exception -> 0x016e }
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2;
        L_0x00cf:
            r2.close();	 Catch:{ Exception -> 0x016e }
        L_0x00d2:
            if (r0 == 0) goto L_0x00d7;
        L_0x00d4:
            r0.disconnect();	 Catch:{ Exception -> 0x016e }
        L_0x00d7:
            return;
        L_0x00d8:
            r5 = 0;
            r2.write(r3, r5, r4);	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r6 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r6 = r6.k();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r4 + r6;
            r5.a(r4);	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r4.k();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r5.j();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r6 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r6 = r6.getStartPosition();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r5 - r6;
            if (r4 < r5) goto L_0x0103;
        L_0x00fd:
            r4 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = 5;
            r4.b(r5);	 Catch:{ Exception -> 0x0121, all -> 0x019c }
        L_0x0103:
            r4 = r9.z;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r4.s;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = r9.A;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4.a(r5);	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r9.z;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r4.r;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4 = r4.getStatus();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r5 = 2;
            if (r4 != r5) goto L_0x00a1;
        L_0x011b:
            r4 = r9.z;	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            r4.notifyChanged();	 Catch:{ Exception -> 0x0121, all -> 0x019c }
            goto L_0x00a1;
        L_0x0121:
            r3 = move-exception;
            r8 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r8;
        L_0x0126:
            r3 = r9.z;	 Catch:{ all -> 0x01a1 }
            r3.delete();	 Catch:{ all -> 0x01a1 }
            r3 = r9.z;	 Catch:{ all -> 0x01a1 }
            r3 = r3.r;	 Catch:{ all -> 0x01a1 }
            r3 = r3.getStatus();	 Catch:{ all -> 0x01a1 }
            if (r3 == r7) goto L_0x014c;
        L_0x0137:
            r3 = r9.z;	 Catch:{ all -> 0x01a1 }
            r3 = r3.r;	 Catch:{ all -> 0x01a1 }
            r4 = 6;
            r3.setStatus(r4);	 Catch:{ all -> 0x01a1 }
            r3 = r9.z;	 Catch:{ all -> 0x01a1 }
            r3 = r3.mHandler;	 Catch:{ all -> 0x01a1 }
            r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
            r3.sendEmptyMessage(r4);	 Catch:{ all -> 0x01a1 }
        L_0x014c:
            r3 = r9.z;
            r3 = r3.s;
            r4 = r9.A;
            r3.a(r4);
            if (r0 == 0) goto L_0x015c;
        L_0x0159:
            r0.close();	 Catch:{ Exception -> 0x0168 }
        L_0x015c:
            if (r1 == 0) goto L_0x0161;
        L_0x015e:
            r1.close();	 Catch:{ Exception -> 0x0168 }
        L_0x0161:
            if (r2 == 0) goto L_0x00d7;
        L_0x0163:
            r2.disconnect();	 Catch:{ Exception -> 0x0168 }
            goto L_0x00d7;
        L_0x0168:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x00d7;
        L_0x016e:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x00d7;
        L_0x0174:
            r0 = move-exception;
            r2 = r1;
            r3 = r1;
        L_0x0177:
            r4 = r9.z;
            r4 = r4.s;
            r5 = r9.A;
            r4.a(r5);
            if (r1 == 0) goto L_0x0187;
        L_0x0184:
            r1.close();	 Catch:{ Exception -> 0x0192 }
        L_0x0187:
            if (r2 == 0) goto L_0x018c;
        L_0x0189:
            r2.close();	 Catch:{ Exception -> 0x0192 }
        L_0x018c:
            if (r3 == 0) goto L_0x0191;
        L_0x018e:
            r3.disconnect();	 Catch:{ Exception -> 0x0192 }
        L_0x0191:
            throw r0;
        L_0x0192:
            r1 = move-exception;
            r1.printStackTrace();
            goto L_0x0191;
        L_0x0197:
            r2 = move-exception;
            r3 = r0;
            r0 = r2;
            r2 = r1;
            goto L_0x0177;
        L_0x019c:
            r3 = move-exception;
            r8 = r3;
            r3 = r0;
            r0 = r8;
            goto L_0x0177;
        L_0x01a1:
            r3 = move-exception;
            r8 = r3;
            r3 = r2;
            r2 = r1;
            r1 = r0;
            r0 = r8;
            goto L_0x0177;
        L_0x01a8:
            r0 = move-exception;
            r0 = r1;
            r2 = r1;
            goto L_0x0126;
        L_0x01ad:
            r2 = move-exception;
            r2 = r0;
            r0 = r1;
            goto L_0x0126;
        L_0x01b2:
            r3 = move-exception;
            r8 = r1;
            r1 = r2;
            r2 = r0;
            r0 = r8;
            goto L_0x0126;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xinmei365.fontsdk.download.d.b.run():void");
        }
    }

    d(String str, String str2) {
        this(str, str2, 1, -1);
    }

    private d(String str, String str2, int i, int i2) {
        this.q = 1;
        this.priority = 1;
        this.u = 0;
        this.v = new ArrayList();
        this.b = false;
        this.x = new ArrayList();
        this.y = false;
        this.r = new DownloadInfo(i2, 0, str, str2, 0);
        this.q = i;
        this.mHandler = new a(Looper.getMainLooper());
        this.s = g.n();
        this.t = c.b();
    }

    private void a(DownloadListener downloadListener) {
        new AsyncTask(this) {
            final /* synthetic */ d z;

            {
                this.z = r1;
            }

            protected Boolean a(Void... voidArr) {
                try {
                    boolean z;
                    File file = new File(this.z.r.getTempPath());
                    File file2 = new File(this.z.r.getSavePath());
                    if (file2.exists()) {
                        if (file.exists()) {
                            file.delete();
                        }
                        z = true;
                    } else {
                        z = file.renameTo(file2);
                    }
                    if (z) {
                        this.z.delete();
                        if (this.z.w != null) {
                            this.z.w.i();
                        }
                    }
                    return Boolean.valueOf(z);
                } catch (Exception e) {
                    e.c(e.getMessage());
                    return Boolean.valueOf(false);
                }
            }

            protected void a(Boolean bool) {
                if (bool.booleanValue()) {
                    for (int i = 0; i < this.z.x.size(); i++) {
                        ((DownloadListener) this.z.x.get(i)).successed(this.z.r);
                    }
                    return;
                }
                this.z.y = false;
                this.z.r.setStatus(8);
                this.z.mHandler.sendEmptyMessage(NetWorkError.RESOURCE_LOAD_FAIL_ERROR);
            }

            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return a((Void[]) objArr);
            }

            protected /* synthetic */ void onPostExecute(Object obj) {
                a((Boolean) obj);
            }
        }.execute(new Void[0]);
    }

    private void d(DownloadListener downloadListener) {
        if (downloadListener != null) {
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = downloadListener;
            this.mHandler.sendMessage(obtain);
            return;
        }
        this.mHandler.sendEmptyMessage(0);
    }

    private synchronized void delete() {
        this.v.clear();
        this.t.b(this.r);
        this.s.e(this.r.getUrlStr());
        com.xinmei365.fontsdk.download.a.a.i(this.r.getTempPath());
        this.b = false;
    }

    private boolean e() {
        return new File(this.r.getSavePath()).exists();
    }

    private synchronized boolean f() {
        boolean z = false;
        synchronized (this) {
            this.v.clear();
            int i;
            if (!isFirst()) {
                if (this.r != null && this.v.size() < 1) {
                    this.v.addAll(this.s.g(this.r.getUrlStr()));
                    this.r.setFileSize(0);
                    i = 0;
                    for (f fVar : this.v) {
                        this.r.setFileSize(((this.r.getFileSize() + fVar.j()) - fVar.getStartPosition()) + 1);
                        i += fVar.k();
                        if (fVar.l() >= 2) {
                            fVar.b(3);
                            this.s.a(fVar);
                        }
                    }
                    this.r.setComplete(i);
                    this.r.setStatus(3);
                }
                z = true;
            } else if (g()) {
                int fileSize = this.r.getFileSize() / this.q;
                for (i = 0; i < this.q - 1; i++) {
                    this.v.add(new f(i, i * fileSize, ((i + 1) * fileSize) - 1, 0, this.r.getUrlStr(), 0, this.r.getTempPath()));
                }
                this.v.add(new f(this.q - 1, (this.q - 1) * fileSize, this.r.getFileSize() - 1, 0, this.r.getUrlStr(), 0, this.r.getTempPath()));
                this.s.a(this.v);
                this.t.a(this.r);
                notifyChanged();
                z = true;
            }
        }
        return z;
    }

    private boolean g() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.r.getUrlStr()).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            this.r.setFileSize(httpURLConnection.getContentLength());
            File file = new File(this.r.getTempPath());
            com.xinmei365.fontsdk.download.a.a.a(file);
            if (this.r.getFileSize() > 0) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                randomAccessFile.setLength((long) this.r.getFileSize());
                randomAccessFile.close();
            }
            httpURLConnection.disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isFirst() {
        boolean f = this.s.f(this.r.getUrlStr());
        File file = new File(this.r.getTempPath());
        if (f) {
            if (file.exists()) {
                return false;
            }
            delete();
            return true;
        } else if (!file.exists()) {
            return true;
        } else {
            file.delete();
            return true;
        }
    }

    private synchronized void notifyChanged() {
        int i = 0;
        synchronized (this) {
            if (this.r.getStatus() == 5) {
                h();
            } else if (!(this.v.size() < 1 || this.r.getStatus() == 3 || this.r.getStatus() == 4)) {
                int l = ((f) this.v.get(0)).l();
                for (f fVar : this.v) {
                    int l2 = fVar.l();
                    if (fVar.l() == 6 || fVar.l() == 4) {
                        l = l2;
                        break;
                    } else if (fVar.l() == 2) {
                        l = l2;
                        break;
                    } else {
                        l = l2;
                    }
                }
                this.r.setStatus(l);
                if (this.r.getStatus() < 4) {
                    for (f fVar2 : this.v) {
                        i = fVar2.k() + i;
                    }
                    this.r.setComplete(i);
                    if (this.r.getComplete() - this.r.getLastComplete() > 102400) {
                        this.r.setLastComplete(this.r.getComplete());
                        this.mHandler.sendEmptyMessage(0);
                    }
                } else {
                    this.mHandler.sendEmptyMessage(0);
                }
            }
        }
    }

    private synchronized void resume() {
        try {
            for (f fVar : this.v) {
                if (fVar.l() == 0) {
                    fVar.b(1);
                    this.s.a(fVar);
                }
                this.r.setStatus(2);
                if (fVar.l() != 2) {
                    fVar.b(2);
                    Thread bVar = new b(fVar);
                    bVar.setPriority(this.priority);
                    bVar.start();
                }
            }
            notifyChanged();
        } catch (Exception e) {
        }
    }

    public void a(e eVar) {
        this.w = eVar;
    }

    public void b(DownloadListener downloadListener) {
        if (downloadListener != null && !this.x.contains(downloadListener)) {
            this.x.add(downloadListener);
            d(downloadListener);
        }
    }

    public void c(DownloadListener downloadListener) {
        if (downloadListener != null && this.x.contains(downloadListener)) {
            this.x.remove(downloadListener);
        }
    }

    synchronized void cancel() {
        if (!this.y) {
            for (f fVar : this.v) {
                fVar.b(4);
                this.s.a(fVar);
            }
            this.r.setStatus(4);
            h();
        }
    }

    public DownloadInfo d() {
        return this.r;
    }

    public int getPriority() {
        return this.priority;
    }

    void h() {
        d(null);
    }

    synchronized void pause() {
        if (!this.y) {
            for (f fVar : this.v) {
                fVar.b(3);
                this.s.a(fVar);
            }
            this.r.setStatus(3);
            h();
        }
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    synchronized void start() {
        if (!this.y) {
            if (e()) {
                File file = new File(this.r.getSavePath());
                this.r.setStatus(5);
                this.r.setFileSize((int) file.length());
                this.r.setComplete(this.r.getFileSize());
                h();
            } else if (this.b) {
                resume();
            } else {
                new AsyncTask(this) {
                    final /* synthetic */ d z;

                    {
                        this.z = r1;
                    }

                    protected Boolean a(Void... voidArr) {
                        return Boolean.valueOf(this.z.f());
                    }

                    protected void a(Boolean bool) {
                        if (!bool.booleanValue()) {
                            this.z.r.setStatus(6);
                            this.z.mHandler.sendEmptyMessage(NetWorkError.IMG_LOAD_ERROR);
                        } else if (this.z.r.getFileSize() <= 0) {
                            this.z.r.setStatus(6);
                            this.z.mHandler.sendEmptyMessage(NetWorkError.HTTP_STATUS_ERROR);
                        } else {
                            this.z.b = true;
                            this.z.resume();
                        }
                    }

                    protected /* synthetic */ Object doInBackground(Object[] objArr) {
                        return a((Void[]) objArr);
                    }

                    protected /* synthetic */ void onPostExecute(Object obj) {
                        a((Boolean) obj);
                    }
                }.execute(new Void[0]);
            }
        }
    }
}
