package com.vlocker.h;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import com.vlocker.m.k;

public class e extends a implements AutoFocusCallback {
    private Camera a;
    private boolean b = false;
    private Context c = null;
    private Handler d = new f(this);

    public e(Context context) {
        this.c = context;
    }

    private void f() {
        this.a = Camera.open();
        Parameters parameters = this.a.getParameters();
        parameters.setFlashMode("on");
        this.a.startPreview();
        this.a.stopPreview();
        this.a.setParameters(parameters);
        this.a.startPreview();
        this.a.autoFocus(this);
        this.b = true;
    }

    private void g() {
        this.a = Camera.open();
        Parameters parameters = this.a.getParameters();
        parameters.setFlashMode("on");
        this.a.cancelAutoFocus();
        this.a.startPreview();
        this.a.stopPreview();
        this.a.setParameters(parameters);
        this.a.startPreview();
        this.a.autoFocus(this);
        this.d.sendEmptyMessageDelayed(0, 100);
        this.b = true;
    }

    private void h() {
        if (this.a != null) {
            Parameters parameters = this.a.getParameters();
            parameters.setFlashMode("on");
            this.a.setParameters(parameters);
            this.a.cancelAutoFocus();
            this.a.stopPreview();
            this.a.startPreview();
            parameters.setFlashMode("on");
            this.a.setParameters(parameters);
            this.d.sendEmptyMessageDelayed(1, 100);
        }
    }

    public boolean a() {
        return true;
    }

    public boolean a(b bVar) {
        if (b()) {
            if (bVar != null) {
                try {
                    bVar.a(false);
                } catch (Exception e) {
                    c();
                } catch (Throwable th) {
                    c();
                }
            }
            e();
            c();
        } else {
            if (bVar != null) {
                try {
                    bVar.a(true);
                } catch (Exception e2) {
                    if (bVar != null) {
                        bVar.a(false);
                    }
                    c();
                }
            }
            d();
            a(this.c);
        }
        return true;
    }

    public boolean b() {
        return this.b;
    }

    public void d() {
        if (k.a() || k.b()) {
            f();
        } else {
            g();
        }
    }

    public void e() {
        if (this.a == null) {
            return;
        }
        if (k.c()) {
            h();
            return;
        }
        this.a.release();
        this.b = false;
        this.a = null;
    }

    public void onAutoFocus(boolean z, Camera camera) {
    }
}
