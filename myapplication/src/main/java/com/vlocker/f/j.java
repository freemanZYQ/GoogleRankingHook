package com.vlocker.f;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.ag;
import com.vlocker.ui.cover.g;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
    public static String d = " ";
    private static j e;
    m a;
    h b;
    a c;

    private j() {
    }

    public static j a() {
        if (e == null) {
            m a = g.a(MoSecurityApplication.a());
            if (a != null) {
                e = new j();
                e.a(a);
                e.a(g.a());
                e.d();
            }
        }
        return e;
    }

    private java.lang.String a(java.io.InputStream r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r5);
        r2 = new java.io.BufferedReader;
        r2.<init>(r1);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
    L_0x000f:
        r3 = r2.readLine();	 Catch:{ IOException -> 0x0019, all -> 0x0038 }
        if (r3 == 0) goto L_0x0029;	 Catch:{ IOException -> 0x0019, all -> 0x0038 }
    L_0x0015:
        r0.append(r3);	 Catch:{ IOException -> 0x0019, all -> 0x0038 }
        goto L_0x000f;
    L_0x0019:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x0019, all -> 0x0038 }
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();
    L_0x0022:
        if (r2 == 0) goto L_0x0027;
    L_0x0024:
        r2.close();
    L_0x0027:
        r0 = 0;
    L_0x0028:
        return r0;
    L_0x0029:
        r0 = r0.toString();	 Catch:{ IOException -> 0x0019, all -> 0x0038 }
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();
    L_0x0032:
        if (r2 == 0) goto L_0x0028;
    L_0x0034:
        r2.close();
        goto L_0x0028;
    L_0x0038:
        r0 = move-exception;
        if (r1 == 0) goto L_0x003e;
    L_0x003b:
        r1.close();
    L_0x003e:
        if (r2 == 0) goto L_0x0043;
    L_0x0040:
        r2.close();
    L_0x0043:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.f.j.a(java.io.InputStream):java.lang.String");
    }

    private void d() {
        InputStream inputStream = null;
        try {
            inputStream = MoSecurityApplication.a().getResources().getAssets().open("fp.txt");
            JSONArray jSONArray = new JSONArray(a(inputStream));
            this.c = new a();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (d.equals(jSONObject.getString("name"))) {
                    this.c.a = d;
                    this.c.b[0] = jSONObject.getJSONObject("cls").getString("one");
                    this.c.b[1] = jSONObject.getJSONObject("cls").getString("two");
                    this.c.b[2] = jSONObject.getJSONObject("cls").getString("three");
                    this.c.c[0] = jSONObject.getJSONObject("fpwp").getString("one");
                    this.c.c[1] = jSONObject.getJSONObject("fpwp").getString("two");
                    this.c.c[2] = jSONObject.getJSONObject("fpwp").getString("three");
                    this.c.d[0] = jSONObject.getJSONObject("fpwnp").getString("one");
                    this.c.d[1] = jSONObject.getJSONObject("fpwnp").getString("two");
                    this.c.d[2] = jSONObject.getJSONObject("fpwnp").getString("three");
                    this.c.e = jSONObject.optString("intent");
                    this.c.f = jSONObject.optString(IXAdRequestInfo.ACT);
                    this.c.g = jSONObject.optString("data");
                    break;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void a(Context context) {
        p.a(context, "Vlock_Show_FingerP_guide_PPC_TF", "type", "FP_verify");
        this.a.a(context);
    }

    public void a(Context context, s sVar) {
        p.a(context, "Vlock_Show_FingerP_guide_PPC_TF", "type", "FP_verify");
        this.a.a(context, sVar);
    }

    public void a(h hVar) {
        this.b = hVar;
    }

    public void a(m mVar) {
        this.a = mVar;
    }

    public void a(ag agVar) {
        if (!a.a(MoSecurityApplication.a()).dd() && !g.a()) {
            try {
                this.a.a(agVar);
                this.a.a();
                a.a(MoSecurityApplication.a()).t(System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(Context context) {
        this.b.a(context);
    }

    public void b(Context context, s sVar) {
        this.b.a(context, sVar);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c() {
        this.a.c();
    }

    public void c(Context context) {
        this.b.a(context, this.c);
    }

    public void c(Context context, s sVar) {
        Dialog create = new Builder(context).create();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(context, R.layout.fingerprint_dialog_with_x, null);
        relativeLayout.findViewById(R.id.fp_dialog_show_btn).setOnClickListener(new k(this, context, create));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.fp_dialog_show_tv);
        Button button = (Button) relativeLayout.findViewById(R.id.fp_dialog_show_btn);
        create.setOnCancelListener(new l(this, context, sVar));
        p.a(context, "Vlock_Show_FingerP_guide_PPC_TF", "type", "FP_nosystemlock");
        create.show();
        create.getWindow().setGravity(16);
        create.setCanceledOnTouchOutside(false);
        create.setContentView(relativeLayout);
    }
}
