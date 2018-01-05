package com.vlocker.e;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.vlocker.b.p;
import com.vlocker.battery.clean.y;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;

class b extends Handler {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    private void a(Message message) {
        switch (message.what) {
            case 272:
            case 274:
                a.c = false;
                this.a.a.cancel(this.a.j.n());
                this.a.b();
                return;
            case 1280:
                Bundle data = message.getData();
                data.getInt("DOWNLOAD");
                if (data.getBoolean("isFinish")) {
                    String r = this.a.j.r();
                    if ("detail_image".equals(r)) {
                        p.a(this.a.h, "Vlocker_Success_Download_LauncherGuide_PPC_RR", "source", "viewPage");
                    } else if ("detail_button".equals(r)) {
                        p.a(this.a.h, "Vlocker_Success_Download_LauncherGuide_PPC_RR", "source", "redPoint");
                    } else if ("setting_view".equals(r)) {
                        p.a(this.a.h, "Vlocker_Success_Download_LauncherGuide_PPC_RR", "source", "set");
                    }
                    if ("1012".equals(this.a.j.e())) {
                        p.a(MoSecurityApplication.a(), "Vlocker_Install_Ad_SavePower_PPC_RR", "package", "not", "from", y.a().h(), "times", a.a(this.a.h).cs() + "");
                    }
                    if ("icon".equals(r)) {
                        p.a(this.a.h, "Vlocker_Done_IconDownload_PPC_RR", new String[0]);
                    }
                    this.a.a.cancel(this.a.j.n());
                    a.c = false;
                    this.a.b();
                    this.a.a();
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
