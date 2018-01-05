package com.vlocker.e;

import android.content.Context;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.update.g;
import com.vlocker.update.i;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class o extends Thread {
    private l a;
    private d b;
    private Context c;
    private String d;
    private n e;

    public o(l lVar, d dVar, String str) {
        if (lVar == null || dVar == null) {
            throw new IllegalArgumentException("cb=null or model=null error!");
        }
        this.a = lVar;
        this.b = dVar;
        this.c = MoSecurityApplication.a();
        this.d = str;
        this.e = new n();
    }

    private boolean a(File file, String str) {
        String str2 = "";
        try {
            str2 = g.a(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return !str2.equals("") && str2.equals(str);
    }

    private boolean b() {
        if (new File((this.b.e() + this.b.f()) + ".apk").exists()) {
            this.a.b(this.d);
            return false;
        }
        c();
        return true;
    }

    private void c() {
        File file = new File(this.b.e());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.getAbsolutePath().contains(this.b.a())) {
                    file2.delete();
                }
            }
        }
    }

    private boolean d() {
        String a = i.a(this.c);
        String b = this.b.b();
        i.a(this.c, b);
        boolean equals = a.equals(b);
        String str = this.b.e() + this.b.f();
        File file = new File(str + ".apk");
        File file2 = new File(str + ".tmp");
        if (file2.exists()) {
            if (!equals) {
                file2.delete();
            }
            if (file.exists()) {
                file.delete();
            }
        } else if (file.exists() && equals) {
            if (a(file, b)) {
                this.a.b(this.d);
                return false;
            }
            file.delete();
        }
        return true;
    }

    private boolean e() {
        try {
            HttpResponse a = r.a(this.b.c());
            i.c(this.c);
            if (a.getStatusLine().getStatusCode() == 200) {
                String a2 = r.a(a.getEntity().getContent());
                if (!(a2 == null || a2.equals(""))) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (Integer.parseInt(jSONObject.getString("code")) == InitError.INVALID_REQUEST_ERROR) {
                        this.b.a(0);
                        return false;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    this.b.a(jSONObject2.getInt("version_code"));
                    this.b.c(jSONObject2.getString("notification"));
                    this.b.d(jSONObject2.getString("type"));
                    this.b.b(jSONObject2.getString("md5"));
                    this.b.g(jSONObject2.getString("url"));
                    try {
                        this.b.e(jSONObject2.getString("markets"));
                        this.b.a(jSONObject2.getBoolean("third"));
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } catch (Exception e2) {
            this.a.a(this.d);
            e2.printStackTrace();
            return false;
        }
    }

    public void a() {
        this.e.a = true;
    }

    public void run() {
        try {
            if (!"1".equals(this.d) || e()) {
                File file = new File(this.b.e());
                if (!file.exists()) {
                    file.mkdirs();
                }
                if ("1".equals(this.d) && !d()) {
                    return;
                }
                if (!"2".equals(this.d) || b()) {
                    if (this.e.a(this.b.e() + this.b.f(), this.b.d())) {
                        this.a.b(this.d);
                        if ("1".endsWith(this.d)) {
                            a.a(this.c).i(System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                    this.a.a(this.d);
                }
            }
        } catch (Exception e) {
            this.a.a(this.d);
        }
    }
}
