package com.xinmei365.fontsdk.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.xinmei365.fontsdk.bean.FailureInfo;
import com.xinmei365.fontsdk.c.a;
import com.xinmei365.fontsdk.c.b;
import com.xinmei365.fontsdk.c.d;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.c.g;
import com.xinmei365.fontsdk.callback.IHttpCallBack;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public abstract class c {
    private static Handler handler = new Handler();
    protected String E;
    private IHttpCallBack ah;
    protected Context ai;
    protected String aj = "";
    boolean ak = false;
    protected String al = "catch.dat";
    protected long am = 86400000;
    private boolean an = true;
    protected int errorCode = -1;
    protected Object obj;

    private void B() {
        handler.post(new Runnable(this) {
            final /* synthetic */ c ao;

            {
                this.ao = r1;
            }

            public void run() {
                if (this.ao.ah == null) {
                    return;
                }
                if (this.ao.obj == null) {
                    if (TextUtils.isEmpty(this.ao.aj)) {
                        this.ao.ah.onErr(this.ao.errorCode, FailureInfo.valueOf(this.ao.errorCode));
                    } else {
                        this.ao.ah.onErr(this.ao.errorCode, this.ao.aj);
                    }
                    this.ao.error();
                    return;
                }
                this.ao.ah.onSuccess(this.ao.obj);
                this.ao.x();
            }
        });
    }

    void A() {
        B();
    }

    void C() {
        File file = new File(a.as + this.al);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(IHttpCallBack iHttpCallBack) {
        this.ah = iHttpCallBack;
    }

    public void a(String str, long j) {
        this.al = str;
        this.am = j;
    }

    void a(byte[] bArr) {
        Closeable fileOutputStream;
        Exception e;
        Throwable th;
        if (bArr == null) {
            C();
        } else if (bArr.length <= 30) {
            C();
        } else {
            File file = new File(a.as);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(a.as + this.al);
            file.deleteOnExit();
            try {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 8);
                    allocate.put(b.a(currentTimeMillis));
                    allocate.put(bArr);
                    fileOutputStream.write(allocate.array());
                    fileOutputStream.flush();
                    d.a(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C();
                        e.c(e.getMessage());
                        d.a(fileOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        d.a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                C();
                e.c(e.getMessage());
                d.a(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                d.a(fileOutputStream);
                throw th;
            }
        }
    }

    public byte[] c(boolean z) {
        Exception e;
        Throwable th;
        boolean z2 = true;
        int i = 0;
        byte[] bArr = null;
        File file = new File(a.as + this.al);
        if (file.exists()) {
            this.ak = true;
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr2 = new byte[8];
                    fileInputStream.read(bArr2);
                    if (b.b(bArr2) + this.am <= System.currentTimeMillis()) {
                        z2 = false;
                    }
                    if (!this.an || r1 || z) {
                        byte[] bArr3 = new byte[((int) file.length())];
                        while (i < bArr3.length) {
                            int read = fileInputStream.read(bArr3, i, bArr3.length - i);
                            if (read < 0) {
                                break;
                            }
                            i += read;
                        }
                        if (i != bArr3.length - 8) {
                            throw new IOException("Could not completely read file ");
                        }
                        bArr = bArr3;
                    }
                    d.a(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C();
                        e.c(e.getMessage());
                        d.a(fileInputStream);
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        d.a(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                C();
                e.c(e.getMessage());
                d.a(fileInputStream);
                return bArr;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                d.a(fileInputStream);
                throw th;
            }
        }
        this.ak = false;
        return bArr;
    }

    public abstract void error();

    void onSuccess() {
        B();
    }

    public abstract void x();

    public abstract void x(String str);

    public void y(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("errorMsg") ? jSONObject.getString("errorMsg") : "";
            int i = jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : -1;
            if ("ok".equalsIgnoreCase(string) && i == 0) {
                String string2 = jSONObject.getString("data");
                if (string2 != null && !"".equals(string2)) {
                    x(string2);
                    return;
                }
                return;
            }
            e.a("error_Code: " + i + "\nerror_Message: " + string);
            if (i != -1) {
                this.errorCode = i;
                this.aj = string;
                return;
            }
            this.errorCode = 1007;
            this.aj = jSONObject.toString();
        } catch (Exception e) {
            this.errorCode = 1008;
            this.aj = e.getMessage();
        }
    }

    public void z() {
        if (g.d(this.ai) == -1) {
            this.an = false;
        }
        com.xinmei365.fontsdk.a.e.r();
        new b(this).start();
    }
}
