package com.vlocker.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.common.receiver.b;
import com.vlocker.setting.common.receiver.c;
import com.vlocker.setting.common.receiver.e;
import com.vlocker.setting.common.receiver.f;
import com.vlocker.setting.common.receiver.h;
import com.vlocker.setting.common.receiver.i;
import com.vlocker.setting.ui.a;
import java.util.List;

public class s implements c, f, i {
    public static int a = 0;
    public boolean b;
    private h c = null;
    private e d = null;
    private b e = null;
    private View f = null;
    private OneKeySettingActivity g;
    private View[] h = null;
    private WindowManager i;
    private r j;
    private int k = 0;
    private long l = -1;
    private com.vlocker.setting.a.a.c m;
    private Handler n = new Handler(new t(this));

    public s(OneKeySettingActivity oneKeySettingActivity, View view) {
        this.g = oneKeySettingActivity;
        this.j = oneKeySettingActivity;
        this.f = view;
        this.i = (WindowManager) this.g.getApplication().getSystemService("window");
        Rect rect = new Rect();
        this.g.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        this.k = rect.height();
        this.m = new com.vlocker.setting.a.a.c(this.j);
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, OneKeySettingActivity.class);
        intent.setFlags(603979776);
        context.startActivity(intent);
    }

    private void a(Rect rect) {
        if (this.h == null) {
            LayoutInflater from = LayoutInflater.from(this.g);
            this.h = new View[3];
            this.h[0] = from.inflate(R.layout.setting_alert_cover_view, null);
            this.h[1] = from.inflate(R.layout.setting_alert_tips_view, null);
            this.h[2] = from.inflate(R.layout.setting_alert_cover_view, null);
        }
        a.a(this.i, this.h[0], rect.top - (rect.height() / 2));
        a.b(this.i, this.h[2], (this.k - rect.bottom) - (rect.height() / 2), rect.bottom + (rect.height() / 2));
        int intrinsicHeight = this.h[1].getBackground().getIntrinsicHeight() / 2;
        a.a(this.i, this.h[1], (rect.height() * 2) + intrinsicHeight, (rect.top - (rect.height() / 2)) - intrinsicHeight);
        a.b(this.i, this.f);
    }

    private void a(WindowManager windowManager) {
        if (this.h != null) {
            for (int i = 0; i < this.h.length; i++) {
                a.b(windowManager, this.h[i]);
                this.h[i] = null;
            }
            this.h = null;
        }
    }

    public static boolean g() {
        return a == 1;
    }

    public static boolean h() {
        return a == 4;
    }

    private void k() {
        if (!OneKeySettingActivity.a) {
            a(this.g);
        }
        a = 3;
        com.vlocker.setting.a.a.getInstance(this.g).init();
        this.n.postDelayed(new u(this), 500);
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.l) / 1000);
        if ("A_tengxun".equals(j.p(this.g))) {
            p.a(this.g, "Vlocker_Time_Of_Rescue_Locker_PPC_TF", "time", "" + currentTimeMillis, "RescueName", "0", "RescueTime", "0");
        }
    }

    private void l() {
        if (this.f != null && this.f.getParent() == null) {
            this.j.m();
            a.a(this.i, this.f);
            this.m.startPercent();
        }
    }

    private void m() {
        if (this.f != null) {
            a.b(this.i, this.f);
        }
        com.vlocker.setting.a.b.checkFloatWindowAllowShow(MoSecurityApplication.a(), new x(this));
    }

    private void n() {
        try {
            a.b(this.i, this.f);
        } catch (Exception e) {
        }
        a.a(this.i, this.f);
        a(this.i);
    }

    private final void o() {
        if (this.c == null) {
            this.c = new h(this.g);
            this.d = new e(this.g);
            this.e = new b(this.g);
            this.c.a(this);
            this.c.a();
            this.d.a(this);
            this.d.a();
            this.e.a(this);
            this.e.a();
        }
    }

    private final void p() {
        if (this.c != null) {
            try {
                this.c.b();
                this.d.b();
                this.e.b();
                this.c = null;
                this.d = null;
                this.e = null;
            } catch (Exception e) {
            }
        }
    }

    public void a() {
        com.vlocker.setting.a.a.getInstance(this.g).init();
    }

    public void a(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        if (obj != null) {
            message.obj = obj;
        }
        this.n.sendMessage(message);
    }

    public void a(int i, Object obj, long j) {
        Message message = new Message();
        message.what = i;
        if (obj != null) {
            message.obj = obj;
        }
        this.n.postDelayed(new v(this, message), j);
    }

    public void a(boolean z, boolean z2) {
        if (!(this.f == null || this.f.getParent() == null)) {
            this.j.a(z2);
            this.m.stopPercent();
            this.n.postDelayed(new w(this), z ? 2400 : 0);
        }
        a(this.i);
        p();
        this.h = null;
    }

    protected boolean a(Message message) {
        switch (message.what) {
            case 1:
                n();
                break;
            case 2:
                a((Rect) message.obj);
                break;
            case 3:
                Float[] fArr = (Float[]) message.obj;
                if (fArr != null) {
                    this.m.setProgress(fArr[0].floatValue(), fArr[1].floatValue());
                    break;
                }
                break;
            case 4:
                k();
                break;
            case 5:
                this.j.a((com.vlocker.setting.a.a.e) message.obj);
                break;
            case 6:
                a.a(this.g, (String) message.obj);
                break;
            case 7:
                this.j.l();
                break;
            case 9:
                m();
                break;
            case 10:
                a.b(this.g, (String) message.obj);
                break;
        }
        return false;
    }

    public void b() {
        com.vlocker.c.a.a(this.g).an(false);
        if (SettingService.c(this.g)) {
            this.g.a("Vlocker_Click_OneTouchRescue_PPC_TF");
            a = 1;
            this.l = System.currentTimeMillis();
            o();
            l();
            com.vlocker.setting.a.a.getInstance().update(this.n, 4);
            return;
        }
        List settingTasks = com.vlocker.setting.a.a.getInstance().getSettingTasks();
        if (settingTasks != null && settingTasks.size() == 1 && ((com.vlocker.setting.a.a.e) settingTasks.get(0)).isNotificationListenerSetting()) {
            new com.vlocker.m.a.a(this.g).a();
            this.b = true;
            return;
        }
        a = 2;
        SettingService.d(this.g);
    }

    public void c() {
        com.vlocker.setting.a.a.getInstance().resetFinished();
        if (SettingService.c(this.g)) {
            this.g.a("Vlocker_Click_OneTouchRescue_PPC_TF");
            a = 1;
            this.l = System.currentTimeMillis();
            o();
            l();
            com.vlocker.setting.a.a.getInstance().update(this.n, 4);
            return;
        }
        List settingTasks = com.vlocker.setting.a.a.getInstance().getSettingTasks();
        if (settingTasks != null && settingTasks.size() == 1 && ((com.vlocker.setting.a.a.e) settingTasks.get(0)).isNotificationListenerSetting()) {
            new com.vlocker.m.a.a(this.g).a();
            this.b = true;
            return;
        }
        a = 2;
        SettingService.d(this.g);
    }

    public void d() {
        a = 4;
        a(false, true);
    }

    public void e() {
        OneKeySettingActivity.a = true;
        a = 4;
        com.vlocker.setting.a.a.getInstance().stop();
        RecentShowActivity.a();
        a(false, true);
        this.g.finish();
        if (com.vlocker.setting.a.a.getInstance().getCurrentTask() != null) {
            p.a(this.g, "Vlocker_Success_Name_Rescue_Locker_PPC_TF", "rescue_name", com.vlocker.setting.a.a.getInstance().getCurrentTask().getTaskName(), "ActionName", "0", "Do", "Stop");
        }
    }

    public void f() {
    }

    public void i() {
        a = 4;
        com.vlocker.setting.a.a.getInstance().stop();
        RecentShowActivity.a();
        a(false, true);
        OneKeySettingActivity.a(this.g, "from_break");
        if (com.vlocker.setting.a.a.getInstance().getCurrentTask() != null) {
            p.a(this.g, "Vlocker_Success_Name_Rescue_Locker_PPC_TF", "rescue_name", com.vlocker.setting.a.a.getInstance().getCurrentTask().getTaskName(), "ActionName", "0", "Do", "Stop");
        }
    }

    public void j() {
        a = 4;
        com.vlocker.setting.a.a.getInstance().stop();
        RecentShowActivity.a();
        a(false, true);
        OneKeySettingActivity.a(this.g, "from_break");
        if (com.vlocker.setting.a.a.getInstance().getCurrentTask() != null) {
            p.a(this.g, "Vlocker_Success_Name_Rescue_Locker_PPC_TF", "rescue_name", com.vlocker.setting.a.a.getInstance().getCurrentTask().getTaskName(), "ActionName", "0", "Do", "Stop");
        }
    }
}
