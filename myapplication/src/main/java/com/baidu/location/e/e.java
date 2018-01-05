package com.baidu.location.e;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.d;
import com.baidu.location.b.h;
import com.baidu.location.b.j;
import com.baidu.location.b.p;
import com.baidu.location.f;
import com.baidu.location.h.m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class e extends j {
    private static e p = null;
    String a;
    String k;
    String l;
    String m;
    int n;
    Handler o;

    private e() {
        this.a = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = 1;
        this.o = null;
        this.o = new Handler();
    }

    public static void a(File file, File file2) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[5120];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                file.delete();
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2) {
        File file = new File(h.g() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            file.renameTo(new File(h.g() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    public static e b() {
        if (p == null) {
            p = new e();
        }
        return p;
    }

    private Handler j() {
        return this.o;
    }

    private void k() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(d.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(d.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(200);
            randomAccessFile.writeBoolean(true);
            if (this.n == 1) {
                randomAccessFile.writeBoolean(true);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            if (this.m != null) {
                byte[] bytes2 = this.m.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else {
                randomAccessFile.writeInt(0);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void l() {
        if (this.a != null && m.a().g()) {
            new h(this).start();
        }
    }

    private boolean m() {
        return (this.l == null || new File(h.g() + File.separator + this.l).exists()) ? true : a("http://" + this.a + "/" + this.l, this.l);
    }

    private void n() {
        if (this.k != null) {
            File file = new File(h.g() + File.separator + this.k);
            if (!file.exists() && a("http://" + this.a + "/" + this.k, this.k)) {
                String a = h.a(file);
                if (this.m != null && a != null && this.m.equals(a)) {
                    File file2 = new File(h.g() + File.separator + f.replaceFileName);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        a(file, file2);
                    } catch (Exception e) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public void a() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(6.05f);
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (b.a().b == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(b.a().a);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(b.a().b);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str = VERSION.RELEASE;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        stringBuffer.append("&pack=");
        stringBuffer.append(b.g);
        this.c = h.d() + "?&it=" + Jni.F(stringBuffer.toString());
    }

    public void a(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.e, "utf-8"));
                if ("up".equals(jSONObject.getString("res"))) {
                    this.a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.k = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.l = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_md5")) {
                        this.m = jSONObject.getString("u1_md5");
                    }
                    j().post(new g(this));
                }
                if (jSONObject.has("ison")) {
                    this.n = jSONObject.getInt("ison");
                }
                k();
            } catch (Exception e) {
            }
        }
        p.a().a(System.currentTimeMillis());
    }

    public void c() {
        if (System.currentTimeMillis() - p.a().b() > 86400000) {
            j().postDelayed(new f(this), 10000);
        }
    }
}
