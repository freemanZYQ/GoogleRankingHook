package com.vlocker.setting.a.a;

import android.os.Handler;
import com.vlocker.setting.z;

public class j {
    private boolean a = false;
    private int b = -1;
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private int f = -1;
    private z g;
    private Handler h = new Handler(new k(this));

    public j(z zVar) {
        this.g = zVar;
    }

    private void a() {
        this.b = 30000;
        this.c = 0.0f;
        setProgress(0.0f, 0.25f);
    }

    public int resetProgress() {
        int i = 200;
        int i2 = this.f;
        if (this.c < 1.0f) {
            float f = 0.001f;
            if (this.f < 200) {
                f = 0.001f * (200.0f / ((float) this.f));
            } else {
                i = i2;
            }
            this.c = f + this.c;
            if (this.c > this.e) {
                this.c = this.e;
            }
            if (((double) this.c) >= 0.95d) {
                this.c = 0.95f;
            }
            this.g.a((int) (this.c * 100.0f));
        } else {
            i = i2;
        }
        return this.c < this.d ? i >> 2 : this.c > this.e ? i << 1 : i;
    }

    public void setProgress(float f, float f2) {
        this.d = f;
        this.e = f2;
        if (this.c == 1.0f) {
            return;
        }
        if (f != 1.0f) {
            this.f = (int) ((((float) this.b) * (1.0f - f)) / (1000.0f * (1.0f - this.c)));
        } else {
            this.f = (int) (3.0f / (1.0f - this.c));
        }
    }

    public void startPercent() {
        a();
        if (!this.a) {
            this.a = true;
            this.h.sendEmptyMessageDelayed(241, (long) this.f);
        }
    }

    public void stopPercent() {
        this.a = false;
    }
}
