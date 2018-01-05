package com.vlocker.setting.a.a;

import android.os.Handler;
import com.vlocker.setting.OneKeySettingActivity;
import com.vlocker.setting.a.a;
import com.vlocker.setting.r;
import java.text.DecimalFormat;

public class c {
    private static final DecimalFormat a = new DecimalFormat("<big>0.0%</small>");
    private boolean b = false;
    private int c = -1;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private int g = -1;
    private r h;
    private Handler i = new Handler(new d(this));

    public c(r rVar) {
        this.h = rVar;
    }

    private void a() {
        this.c = a.getInstance().getTotalTime();
        this.d = 0.0f;
        setProgress(0.0f, 1.0f);
    }

    public int resetProgress() {
        int i = 200;
        int i2 = this.g;
        if (this.d < 1.0f) {
            float f = 0.001f;
            if (this.g < 200) {
                f = 0.001f * (200.0f / ((float) this.g));
            } else {
                i = i2;
            }
            this.d = f + this.d;
            if (this.d >= 1.0f) {
                if (OneKeySettingActivity.a() != null) {
                    OneKeySettingActivity.a().a(11);
                }
                this.d = 1.0f;
            }
            this.h.a(this.d);
        } else {
            i = i2;
        }
        return this.d < this.e ? i >> 2 : this.d > this.f ? i << 1 : i;
    }

    public void setProgress(float f, float f2) {
        this.e = f;
        this.f = f2;
        if (f != 1.0f) {
            this.g = (int) ((((float) this.c) * (1.0f - f)) / (1000.0f * (1.0f - this.d)));
        } else {
            this.g = (int) (3.0f / (1.0f - this.d));
        }
    }

    public void startPercent() {
        a();
        if (!this.b) {
            this.b = true;
            this.i.sendEmptyMessageDelayed(241, (long) this.g);
        }
    }

    public void stopPercent() {
        this.b = false;
    }
}
