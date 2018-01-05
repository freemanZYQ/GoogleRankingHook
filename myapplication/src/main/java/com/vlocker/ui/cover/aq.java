package com.vlocker.ui.cover;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.b.j;
import com.vlocker.m.aj;

public class aq {
    private boolean a;
    private AudioManager b;
    private Handler c;

    public aq(Context context) {
        this.b = (AudioManager) context.getSystemService("audio");
        this.a = j.e(context);
        c();
    }

    private void c() {
        this.c = new ar(this);
    }

    public void a() {
        this.b = null;
    }

    public boolean b() {
        if (this.b == null || !this.a) {
            return false;
        }
        if (!aj.a(WXApp.WXAPP_PACKAGE_NAME, 2) && !aj.a("com.tencent.mobileqq", 2)) {
            return false;
        }
        if (this.b.getMode() == 3 || this.b.getMode() == 2) {
            return true;
        }
        this.c.sendEmptyMessageDelayed(0, 200);
        return false;
    }
}
