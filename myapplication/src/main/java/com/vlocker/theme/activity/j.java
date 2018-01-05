package com.vlocker.theme.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class j extends Handler {
    final /* synthetic */ ThemeDetailActivity a;

    j(ThemeDetailActivity themeDetailActivity) {
        this.a = themeDetailActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 275:
                this.a.D = 0;
                break;
            case 1280:
                int i = message.arg1;
                if (this.a.d == null) {
                    return;
                }
                if (this.a.D == 0) {
                    this.a.d.setProgress(100);
                    return;
                } else {
                    this.a.d.setProgress(i);
                    return;
                }
            case 4493:
                try {
                    Toast.makeText(e.a, this.a.getString(R.string.l_theme_download_failed_network), 0).show();
                    this.a.i();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            case 4509:
                try {
                    e.a(e.a, e.a.getString(R.string.t_market_no_space));
                    this.a.i();
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    break;
                }
        }
        if (this.a.h != null) {
            this.a.k();
        }
    }
}
