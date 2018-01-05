package com.vlocker.m;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;

public class m implements OnClickListener {
    private n a;
    private Activity b;
    private boolean c;
    private a d;
    private AlertDialog e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;

    public m(Activity activity, n nVar) {
        this.b = activity;
        this.a = nVar;
        this.d = a.a(this.b);
        this.e = new Builder(this.b).create();
        this.e.show();
        this.e.setCanceledOnTouchOutside(true);
        Window window = this.e.getWindow();
        window.setContentView(View.inflate(activity, R.layout.l_lockertime_select_dialog, null), new LayoutParams((int) ((((float) this.b.getResources().getDisplayMetrics().widthPixels) * 7.0f) / 9.0f), -2));
        window.findViewById(R.id.setting_lockertime_now_layout).setOnClickListener(this);
        window.findViewById(R.id.setting_lockertime_first_layout).setOnClickListener(this);
        window.findViewById(R.id.setting_lockertime_second_layout).setOnClickListener(this);
        window.findViewById(R.id.setting_lockertime_third_layout).setOnClickListener(this);
        window.findViewById(R.id.setting_lockertime_four_layout).setOnClickListener(this);
        window.findViewById(R.id.setting_lockertime_five_layout).setOnClickListener(this);
        this.h = (ImageView) window.findViewById(R.id.setting_lockertime_now_img);
        this.i = (ImageView) window.findViewById(R.id.setting_lockertime_first_img);
        this.j = (ImageView) window.findViewById(R.id.setting_lockertime_second_img);
        this.k = (ImageView) window.findViewById(R.id.setting_lockertime_third_img);
        this.l = (ImageView) window.findViewById(R.id.setting_lockertime_four_img);
        this.m = (ImageView) window.findViewById(R.id.setting_lockertime_five_img);
        b();
    }

    public m(Activity activity, boolean z, n nVar) {
        this.b = activity;
        this.c = z;
        this.a = nVar;
        this.e = new Builder(this.b).create();
        this.e.show();
        this.e.setCanceledOnTouchOutside(z);
        Window window = this.e.getWindow();
        window.setContentView(View.inflate(activity, R.layout.l_emergency_select_dialog, null), new LayoutParams((int) ((((float) this.b.getResources().getDisplayMetrics().widthPixels) * 7.0f) / 9.0f), -2));
        this.f = (ImageView) window.findViewById(R.id.setting_enable_forbidden_img);
        this.g = (ImageView) window.findViewById(R.id.setting_enable_back_voice_img);
        this.d = a.a(this.b);
        a();
        window.findViewById(R.id.setting_forbidden_layout).setOnClickListener(this);
        window.findViewById(R.id.l_emergency_back_voice_layout).setOnClickListener(this);
    }

    private void a() {
        if (this.d.at()) {
            a(this.g, true);
            a(this.f, false);
            return;
        }
        a(this.g, false);
        a(this.f, true);
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.l_theme_color_selected);
        } else {
            imageView.setImageResource(R.drawable.l_v2_checkbox_circle_normal);
        }
    }

    private void b() {
        int an = this.d.an();
        a(this.h, false);
        a(this.i, false);
        a(this.j, false);
        a(this.k, false);
        a(this.l, false);
        a(this.m, false);
        if (an == 0) {
            a(this.h, true);
        } else if (an == 1) {
            a(this.i, true);
        } else if (an == 2) {
            a(this.j, true);
        } else if (an == 3) {
            a(this.k, true);
        } else if (an == 4) {
            a(this.l, true);
        } else if (an == 5) {
            a(this.m, true);
        }
        this.a.a(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_forbidden_layout:
                this.d.G(false);
                a();
                this.a.a(false);
                break;
            case R.id.l_emergency_back_voice_layout:
                this.d.G(true);
                a();
                this.a.a(true);
                break;
            case R.id.setting_lockertime_now_layout:
                this.d.l(0);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "0");
                b();
                break;
            case R.id.setting_lockertime_first_layout:
                this.d.l(1);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "5");
                b();
                break;
            case R.id.setting_lockertime_second_layout:
                this.d.l(2);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "15");
                b();
                break;
            case R.id.setting_lockertime_third_layout:
                this.d.l(3);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "30");
                b();
                break;
            case R.id.setting_lockertime_four_layout:
                this.d.l(4);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "60");
                b();
                break;
            case R.id.setting_lockertime_five_layout:
                this.d.l(5);
                p.a(this.b, "Vlocker_Done_DelayLock_PPC_TF", "time", "300");
                b();
                break;
        }
        this.e.dismiss();
    }
}
