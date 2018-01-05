package com.vlocker.theme.activity;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;

class n extends Handler {
    final /* synthetic */ ThemeDetailActivity a;

    n(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void handleMessage(Message message) {
        this.a.q.setVisibility(0);
        switch (message.what) {
            case LocationClientOption.MIN_SCAN_SPAN /*1000*/:
                if (this.a.C != null) {
                    this.a.k();
                    this.a.c();
                    this.a.f.setText(this.a.C.b());
                    this.a.j.setRating((float) (this.a.C.d() + 1));
                    this.a.k.setText("下载量：" + this.a.C.e());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
