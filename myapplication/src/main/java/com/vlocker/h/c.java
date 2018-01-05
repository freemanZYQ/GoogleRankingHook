package com.vlocker.h;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import com.vlocker.m.h;
import com.vlocker.security.MoSecurityApplication;

public class c extends a {
    private static final String[][] f;
    private boolean a = false;
    private Camera b;
    private Context c;
    private Object d = new Object();
    private Boolean e = null;
    private d g = d.Ready;

    static {
        r0 = new String[2][];
        r0[0] = new String[]{"sony", "c2105"};
        r0[1] = new String[]{"google", "nexus 7"};
        f = r0;
    }

    public c(Context context) {
        this.c = context;
    }

    private static final boolean d() {
        FeatureInfo[] systemAvailableFeatures = MoSecurityApplication.a().getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return false;
        }
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if (featureInfo != null && "android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return Build.MODEL.toLowerCase().contains("vivo x3t");
    }

    private boolean e() {
        boolean z = true;
        int i = 0;
        while (i < f.length) {
            try {
                if (Build.BRAND.equalsIgnoreCase(f[i][0]) && h.d().equalsIgnoreCase(f[i][1])) {
                    z = true;
                    break;
                }
                i++;
            } catch (Exception e) {
            }
        }
        return z;
    }

    public boolean a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        r2 = 0;
        r1 = r3.e;
        if (r1 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r3.e;
        r0 = r0.booleanValue();
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = 0;
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r3.e = r1;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1 = d();	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
    L_0x001a:
        r1 = r3.e();	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        if (r1 != 0) goto L_0x0039;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
    L_0x0020:
        r1 = 1;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
    L_0x0021:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r3.e = r1;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1 = r3.e;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r0 = r1.booleanValue();	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1 = r3.b;
        if (r1 == 0) goto L_0x000c;
    L_0x0031:
        r1 = r3.b;
        r1.release();
        r3.b = r2;
        goto L_0x000c;
    L_0x0039:
        r1 = r0;
        goto L_0x0021;
    L_0x003b:
        r1 = move-exception;
        r1 = r3.b;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        if (r1 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
    L_0x0040:
        r1 = r3.b;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1.release();	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1 = 0;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r3.b = r1;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
    L_0x0048:
        r1 = 0;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r3.e = r1;	 Catch:{ Exception -> 0x003b, all -> 0x0057 }
        r1 = r3.b;
        if (r1 == 0) goto L_0x000c;
    L_0x004f:
        r1 = r3.b;
        r1.release();
        r3.b = r2;
        goto L_0x000c;
    L_0x0057:
        r0 = move-exception;
        r1 = r3.b;
        if (r1 == 0) goto L_0x0063;
    L_0x005c:
        r1 = r3.b;
        r1.release();
        r3.b = r2;
    L_0x0063:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.h.c.a():boolean");
    }

    public boolean a(b bVar) {
        if (this.g == d.Ready) {
            this.g = d.Opening;
            try {
                bVar.a(true);
                b(bVar);
                super.a(this.c);
            } catch (Exception e) {
                if (this.b != null) {
                    this.b.release();
                    this.b = null;
                    super.c();
                }
                throw e;
            }
        } else if (d.Opened == this.g) {
            try {
                super.c();
                bVar.a(false);
                c(bVar);
                this.g = d.Ready;
            } catch (Exception e2) {
                this.g = d.Ready;
                if (this.b != null) {
                    this.b.release();
                    this.b = null;
                    super.c();
                }
                throw e2;
            }
        }
        return this.a;
    }

    public void b(b bVar) {
        try {
            if (this.g == d.Opening) {
                if (this.b == null) {
                    this.b = Camera.open();
                    this.b.setPreviewTexture(new SurfaceTexture(0));
                }
                if (this.b == null) {
                    this.g = d.Ready;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                Parameters parameters = this.b.getParameters();
                parameters.setFlashMode("torch");
                this.b.setParameters(parameters);
                this.b.startPreview();
                this.g = d.Opened;
                this.a = true;
                if (bVar != null) {
                    bVar.a(true);
                }
            }
        } catch (Exception e) {
            this.g = d.Ready;
            if (bVar != null) {
                bVar.a(false);
            }
            if (this.b != null) {
                this.b.stopPreview();
                this.b.release();
                this.b = null;
            }
        }
    }

    public boolean b() {
        return this.g != d.Ready;
    }

    public void c(b bVar) {
        synchronized (this.d) {
            try {
                if (this.b != null) {
                    if (this.g != d.Opened) {
                        return;
                    }
                    Parameters parameters = this.b.getParameters();
                    parameters.setFlashMode("off");
                    this.b.setParameters(parameters);
                    this.b.stopPreview();
                    this.b.release();
                    this.b = null;
                    this.a = false;
                    if (bVar != null) {
                        bVar.a(false);
                    }
                }
            } catch (Exception e) {
                if (bVar != null) {
                    bVar.a(false);
                }
                this.g = d.Ready;
                if (this.b != null) {
                    this.b.stopPreview();
                    this.b.release();
                    this.b = null;
                }
            }
        }
    }
}
