package com.vlocker.locker.b;

import android.media.AudioManager;
import android.os.Handler;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.c.a;
import com.vlocker.m.ap;
import com.vlocker.ui.cover.ag;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.g;

public class y implements ag {
    final /* synthetic */ p a;

    public y(p pVar) {
        this.a = pVar;
    }

    public void a() {
        if (!f.i && f.f != 5) {
            if (g.c()) {
                this.a.e.a();
            } else if (g.d()) {
                this.a.f.a();
            } else {
                this.a.f((int) AdError.PLACEMENT_ERROR);
            }
        }
    }

    public void a(int i) {
        if (!f.i && f.f != 5) {
            if (i > 0) {
                if (f.e) {
                    if (g.c()) {
                        this.a.e.a(i);
                    } else if (g.d()) {
                        this.a.f.a(i);
                    } else {
                        this.a.a(null, 2, "指纹验证失败，请重试");
                        new Handler().postDelayed(new z(this, i), 200);
                    }
                } else if (((AudioManager) this.a.i.getSystemService("audio")).getRingerMode() != 0 && a.a(this.a.i).au()) {
                    ap.b(this.a.i);
                }
            } else if (g.c()) {
                this.a.e.a(i);
            } else if (g.d()) {
                this.a.f.a(i);
            } else if (((AudioManager) this.a.i.getSystemService("audio")).getRingerMode() != 0 && a.a(this.a.i).au()) {
                ap.b(this.a.i);
            }
        }
    }

    public void a(CharSequence charSequence) {
        if (!f.i && f.f != 5) {
            if (g.c()) {
                this.a.e.a(charSequence);
            } else if (g.d()) {
                this.a.f.a(charSequence);
            }
        }
    }
}
