package com.vlocker.setting;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.msg.an;
import com.vlocker.setting.a.a;
import com.vlocker.setting.common.receiver.e;
import com.vlocker.setting.common.receiver.f;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.f.b;
import java.util.List;

public class OneKeySettingActivity extends Activity implements OnClickListener, f, r {
    public static boolean a = false;
    public static boolean b = true;
    public static String d;
    private static OneKeySettingActivity g = null;
    public String c;
    private int e = 0;
    private e f = null;
    private s h;
    private aa i;
    private a j;
    private Button k;
    private TextView l;
    private Handler m;
    private Dialog n;
    private LinearLayout o;
    private Runnable p = new k(this);

    public static OneKeySettingActivity a() {
        return g;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, OneKeySettingActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent(context, OneKeySettingActivity.class);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    private void n() {
        if (a.getInstance().isEmpty()) {
            h();
            return;
        }
        if ("from_StartGuideActivity".equals(this.c)) {
            this.m.sendEmptyMessageDelayed(1, 500);
            this.m.sendEmptyMessageDelayed(2, 3150);
            this.e = 0;
            d = c();
            this.j.b();
        } else if ("from_break".equals(this.c)) {
            i();
        } else if (!"from_service".equals(this.c)) {
            if (a.getInstance().finished()) {
                j();
            } else {
                k();
            }
            d = c();
        } else if (a.getInstance().finished()) {
            j();
        } else {
            k();
        }
        if (!"from_service".equals(this.c) && SettingService.f(this)) {
            com.vlocker.setting.a.a.a.post(this);
        }
    }

    private void o() {
        this.m = new l(this);
    }

    private void p() {
        this.o = (LinearLayout) getLayoutInflater().inflate(R.layout.interrupt_repair_dialog, null);
        this.o.findViewById(R.id.dialog_give_up).setOnClickListener(this);
        this.o.findViewById(R.id.dialog_go_on).setOnClickListener(this);
        this.k = (Button) findViewById(R.id.repair_now);
        this.k.setOnClickListener(this);
        this.l = (TextView) findViewById(R.id.manual_set);
        this.l.setOnClickListener(this);
    }

    private void q() {
        if (this.n == null) {
            this.n = new Builder(this).create();
        }
        this.n.show();
        this.n.getWindow().setGravity(16);
        this.n.getWindow().setContentView(this.o);
        p.a((Context) this, "Vlocker_QuitPopup_Rescue_PPC_TF", new String[0]);
    }

    private void r() {
        List maunalTasks = a.getInstance().getMaunalTasks(true);
        if (maunalTasks == null || maunalTasks.size() <= 0 || com.vlocker.c.a.a((Context) this).bp() || this.e == 1 || this.e == 4) {
            this.l.setVisibility(4);
        } else {
            this.l.setVisibility(0);
        }
    }

    private void s() {
        List maunalTasks = a.getInstance().getMaunalTasks(true);
        if (maunalTasks != null && maunalTasks.size() > 0) {
            ManualRepairActivity.a(this, true, "from_click");
        }
    }

    private final void t() {
        if (this.f == null) {
            this.f = new e(this);
            this.f.a(this);
            this.f.a();
        }
    }

    private final void u() {
        if (this.f != null) {
            try {
                this.f.b();
                this.f = null;
            } catch (Exception e) {
            }
        }
    }

    public void a(float f) {
    }

    public void a(int i) {
        a(i, null);
    }

    public void a(int i, Object obj) {
        if (this.h != null) {
            this.h.a(i, obj);
        }
    }

    public void a(int i, Object obj, long j) {
        if (this.h != null) {
            this.h.a(i, obj, j);
        }
    }

    public void a(com.vlocker.setting.a.a.e eVar) {
        this.i.a(eVar);
    }

    public void a(String str) {
        if (SettingService.f(this) && !a.getInstance().isEmpty()) {
            p.a((Context) this, str, "status", d, "Pause", b());
        }
    }

    public void a(boolean z) {
        Log.e("liu---", "--------------onHideFloatView");
        if (!z) {
            List maunalTasks = a.getInstance().getMaunalTasks(false);
            if (maunalTasks == null || maunalTasks.size() <= 0) {
                this.i.h();
                g();
            } else {
                ManualRepairActivity.a(this, false, "from_repair");
                this.i.i();
            }
        }
        this.i.d();
    }

    public String b() {
        return this.e == 3 ? "On" : "Off";
    }

    public String c() {
        com.vlocker.c.a a = com.vlocker.c.a.a((Context) this);
        return a.bq() ? a.bp() ? "First_1" : "NotFirst_1" : this.e == 2 ? "Retry" : "NewRescue";
    }

    protected void d() {
        this.m.removeCallbacks(this.p);
        SettingsActivity.b((Context) this);
        this.h.d();
        finish();
    }

    public void e() {
        if (s.a != 1) {
            if (this.n == null || !this.n.isShowing()) {
                p.a((Context) this, "Vlocker_Quit_Rescue_PPC_TF", "way", "Home");
            } else {
                p.a((Context) this, "Vlocker_Quit_Rescue_PPC_TF", "way", "Popup_Home");
            }
            finish();
        }
    }

    public void f() {
    }

    public void g() {
        this.e = 1;
        this.j.b(this.e);
        this.m.postDelayed(this.p, 2400);
    }

    public void h() {
        this.e = 4;
        this.j.b(this.e);
        if (b.D()) {
            this.m.postDelayed(this.p, 2400);
        }
    }

    public void i() {
        this.e = 3;
        this.k.setText(R.string.one_key_setting_repair_continue);
        this.j.c(this.e);
    }

    public void j() {
        this.e = 2;
        this.k.setText(R.string.one_key_setting_repair_agin);
        this.j.c(this.e);
    }

    public void k() {
        this.e = 0;
        this.k.setText(R.string.one_key_setting_repair);
        this.j.c(this.e);
    }

    public void l() {
        Log.e("liu---", "------------onInitComplete");
        r();
    }

    public void m() {
        Log.e("liu---", "-----------onshowFloatView");
        this.i.b();
        this.i.g();
        this.i.c();
    }

    public void onBackPressed() {
        if (this.e == 0 || this.e == 3) {
            q();
        } else {
            d();
        }
        if (s.a == 1 && a.getInstance().getCurrentTask() != null) {
            p.a((Context) this, "Vlocker_Success_Name_Rescue_Locker_PPC_TF", "rescue_name", a.getInstance().getCurrentTask().getTaskName(), "ActionName", "0", "Do", "Stop");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_give_up:
                p.a((Context) this, "Vlocker_Quit_Rescue_PPC_TF", "way", "Popup_quit");
                d();
                return;
            case R.id.dialog_go_on:
                this.n.dismiss();
                break;
            case R.id.repair_now:
                break;
            case R.id.manual_set:
                s();
                return;
            default:
                return;
        }
        if (a.getInstance().isEmpty()) {
            h();
        } else if (!a.getInstance().finished() || com.vlocker.c.a.a((Context) this).bQ()) {
            this.h.b();
        } else {
            this.h.c();
        }
        a("Vlocker_Click_OneKey_Rescue_PPC_TF");
        p.a((Context) this, "Vlocker_Number_Rescue_Locker_PPC_TF", "Show_Lock", "" + a.getInstance().getTaskNumByType(1), "Start_Boot", "" + a.getInstance().getTaskNumByType(2), "Clear_Memory", "" + a.getInstance().getTaskNumByType(3));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g = this;
        a = false;
        b = false;
        this.c = getIntent().getStringExtra("from");
        a.getInstance(this);
        if ("from_SettingsActivity".equals(this.c) || "from_locker".equals(this.c)) {
            com.vlocker.c.a.a((Context) this).Z(false);
        }
        this.i = new aa(this);
        this.j = new a(this);
        this.h = new s(this, this.i.a());
        setContentView(this.j.a());
        p();
        o();
        if (s.a != 1) {
            this.h.a();
        }
        n();
        t();
    }

    protected void onDestroy() {
        super.onDestroy();
        b = true;
        if (s.a != 2) {
            this.h.d();
        }
        if (this.n != null) {
            this.n.dismiss();
        }
        if (this.i != null) {
            this.i.j();
        }
        if (this.j != null) {
            this.j.j();
        }
        u();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if ("360UI".equals(Build.BRAND)) {
            com.vlocker.setting.a.b.checkFloatWindowAllowShow(this, new m(this));
        }
        if (s.a == 2 && SettingService.c((Context) this)) {
            this.h.b();
        }
        if (this.h.b && an.b(this)) {
            g();
        }
        com.vlocker.setting.ui.b.a().b();
        r();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
