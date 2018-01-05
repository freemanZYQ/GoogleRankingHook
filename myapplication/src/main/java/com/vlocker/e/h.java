package com.vlocker.e;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.vlocker.locker.R;

class h extends Handler {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    private void a(Message message) {
        switch (message.what) {
            case 1:
                if (j.a().b("1")) {
                    j.a().c("1");
                    this.a.a.postDelayed(new i(this), 1000);
                    return;
                }
                this.a.a(false);
                return;
            case 2:
                if (this.a.b != null && (this.a.b instanceof Activity)) {
                    Toast.makeText(this.a.b, this.a.b.getResources().getString(R.string.vlocker_setting_update_app_nonetdip), 0).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void handleMessage(Message message) {
        a(message);
    }
}
