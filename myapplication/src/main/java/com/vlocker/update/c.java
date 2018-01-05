package com.vlocker.update;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.vlocker.c.a;
import com.vlocker.locker.R;

class c extends Handler {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    private void a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 1:
                boolean e = this.a.g();
                if (this.a.f()) {
                    a aVar = this.a;
                    if (a.a(this.a.b).cW()) {
                        z = false;
                    }
                    aVar.a(z);
                    return;
                } else if (e && this.a.d == 1) {
                    this.a.a(false);
                    this.a.b(e);
                    return;
                } else {
                    this.a.a(false);
                    return;
                }
            case 2:
                this.a.a(false);
                return;
            case 3:
                if (this.a.b != null && (this.a.b instanceof Activity) && !this.a.g()) {
                    Toast.makeText(this.a.b, message.what == 3 ? this.a.b.getResources().getString(R.string.vlocker_setting_update_app_nonetdip) : this.a.b.getResources().getString(R.string.version_newest), 0).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void handleMessage(Message message) {
        a(message);
        super.handleMessage(message);
    }
}
