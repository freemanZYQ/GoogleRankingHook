package com.vlocker.setting;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.setting.a.a;
import com.vlocker.setting.a.a.e;
import com.vlocker.setting.a.a.j;
import com.vlocker.setting.ui.HexagonContentView;
import com.vlocker.setting.ui.HexagonView;
import com.vlocker.setting.ui.y;
import java.util.ArrayList;
import java.util.List;

public class aa implements z {
    private TextView A;
    private HexagonView B;
    private HexagonContentView C;
    private TextView D;
    private TextView E;
    private RelativeLayout F;
    private LinearLayout G;
    private TextView H;
    private RelativeLayout I;
    private j J;
    private ScrollView K;
    private int L = 1;
    private int M = 1;
    private y N = new ad(this);
    private h O = new ae(this);
    private View a;
    private Context b;
    private List c;
    private List d;
    private List e;
    private List f;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public aa(Context context) {
        this.b = context;
        this.c = a.getInstance().getSettingTasks();
        this.J = new j(this);
        m();
        k();
    }

    private void a(int i, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        view.setLayoutParams(layoutParams);
    }

    private void a(int i, TextView textView, TextView textView2, int i2, TextView textView3, TextView textView4, ImageView imageView) {
        if (i <= 0 || i >= i2) {
            textView.setText("" + i2);
            textView2.setText(this.b.getString(R.string.one_key_setting_rapaired));
            this.J.stopPercent();
            e();
            if (this.L < this.M) {
                n();
                this.J.startPercent();
                f();
                return;
            }
            return;
        }
        this.J.setProgress(((float) i) / ((float) i2), (((float) i) + 1.0f) / ((float) i2));
        if (textView3.getVisibility() != 0) {
            textView3.setVisibility(0);
            textView4.setVisibility(0);
            imageView.setVisibility(8);
        }
        textView.setText("" + i);
        textView2.setText(this.b.getString(R.string.one_key_setting_rapairing));
    }

    private void a(TextView textView, boolean z) {
        textView.animate().alpha(1.0f).setStartDelay(400).setInterpolator(new DecelerateInterpolator()).setDuration(z ? 300 : 500).setListener(null).start();
    }

    private void k() {
        this.a = LayoutInflater.from(this.b).inflate(R.layout.setting_progress, null);
        this.I = (RelativeLayout) this.a.findViewById(R.id.ball_layout);
        Display defaultDisplay = ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        LayoutParams layoutParams = (LayoutParams) this.I.getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (i * 39) / 64;
        this.I.setLayoutParams(layoutParams);
        this.j = (TextView) this.a.findViewById(R.id.task_float_num_left);
        this.k = (TextView) this.a.findViewById(R.id.task_float_num_right);
        this.n = (TextView) this.a.findViewById(R.id.task_clean_num_left);
        this.o = (TextView) this.a.findViewById(R.id.task_clean_num_right);
        this.l = (TextView) this.a.findViewById(R.id.task_start_num_left);
        this.m = (TextView) this.a.findViewById(R.id.task_start_num_right);
        this.p = (TextView) this.a.findViewById(R.id.task_float_status);
        this.q = (TextView) this.a.findViewById(R.id.task_start_status);
        this.r = (TextView) this.a.findViewById(R.id.task_clean_status);
        this.s = (ImageView) this.a.findViewById(R.id.task_image_1);
        this.t = (ImageView) this.a.findViewById(R.id.task_image_2);
        this.u = (ImageView) this.a.findViewById(R.id.task_image_3);
        this.v = (TextView) this.a.findViewById(R.id.task_percent_1);
        this.w = (TextView) this.a.findViewById(R.id.task_percent_2);
        this.x = (TextView) this.a.findViewById(R.id.task_percent_3);
        this.y = (TextView) this.a.findViewById(R.id.task_symbol_1);
        this.z = (TextView) this.a.findViewById(R.id.task_symbol_2);
        this.A = (TextView) this.a.findViewById(R.id.task_symbol_3);
        this.B = (HexagonView) this.a.findViewById(R.id.setting_hexagon_view);
        this.C = (HexagonContentView) this.a.findViewById(R.id.setting_hexagon_content_view);
        this.D = (TextView) this.a.findViewById(R.id.setting_hexagon_content_title);
        this.E = (TextView) this.a.findViewById(R.id.setting_hexagon_content_des);
        Typeface createFromAsset = Typeface.createFromAsset(this.b.getAssets(), "fonts/setting_font.otf");
        this.E.setTypeface(createFromAsset);
        this.v.setTypeface(createFromAsset);
        this.w.setTypeface(createFromAsset);
        this.x.setTypeface(createFromAsset);
        this.y.setTypeface(createFromAsset);
        this.z.setTypeface(createFromAsset);
        this.A.setTypeface(createFromAsset);
        this.C.setCallback(this.N);
        this.B.setCallback(this.O);
        this.F = (RelativeLayout) this.a.findViewById(R.id.layout_setting_hexagon);
        this.G = (LinearLayout) this.a.findViewById(R.id.layout_task);
        this.H = (TextView) this.a.findViewById(R.id.setting_please_wait);
        this.K = (ScrollView) this.a.findViewById(R.id.layout_task_scroll);
        b();
    }

    private void l() {
        if (this.d.size() != 0) {
            this.L = 1;
        } else if (this.e.size() != 0) {
            this.L = 2;
        } else if (this.f.size() != 0) {
            this.L = 3;
        }
    }

    private void m() {
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        for (int i = 0; i < this.c.size(); i++) {
            e eVar = (e) this.c.get(i);
            if (eVar.getGroup() == 1) {
                this.d.add(eVar);
            } else if (eVar.getGroup() == 2) {
                this.e.add(eVar);
            } else {
                this.f.add(eVar);
            }
        }
        if (this.f.size() > 0) {
            this.M = 3;
        } else if (this.e.size() > 0) {
            this.M = 2;
        } else if (this.d.size() > 0) {
            this.M = 1;
        } else {
            this.M = 0;
        }
    }

    private void n() {
        if (this.L == 1) {
            if (this.e.size() > 0) {
                this.L = 2;
            } else if (this.f.size() > 0) {
                this.L = 3;
            }
        } else if (this.L == 2 && this.f.size() > 0) {
            this.L = 3;
        }
    }

    private void o() {
        this.H.animate().setStartDelay(300).alpha(0.0f).setDuration(400).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        p();
    }

    private void p() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(400);
        ofFloat.setStartDelay(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ab(this));
        ofFloat.start();
    }

    private void q() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-32908, -16532236});
        ofInt.setDuration(500);
        ofInt.setStartDelay(300);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.addUpdateListener(new ac(this));
        ofInt.start();
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        switch (this.L) {
            case 1:
                this.v.setText("" + i);
                return;
            case 2:
                this.w.setText("" + i);
                return;
            case 3:
                this.x.setText("" + i);
                return;
            default:
                return;
        }
    }

    public void a(e eVar) {
        if (eVar.getGroup() == 1) {
            this.g++;
            this.L = 1;
            a(this.g, this.j, this.p, this.d.size(), this.v, this.y, this.s);
        } else if (eVar.getGroup() == 2) {
            this.h++;
            this.L = 2;
            a(this.h, this.l, this.q, this.e.size(), this.w, this.z, this.t);
        } else {
            this.i++;
            this.L = 3;
            a(this.i, this.n, this.r, this.f.size(), this.x, this.A, this.u);
        }
    }

    public void b() {
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j.setText("0");
        this.k.setText("/" + this.d.size());
        this.l.setText("0");
        this.m.setText("/" + this.e.size());
        this.n.setText("0");
        this.o.setText("/" + this.f.size());
        this.p.setText(this.b.getString(R.string.one_key_setting_waiting));
        this.q.setText(this.b.getString(R.string.one_key_setting_waiting));
        this.r.setText(this.b.getString(R.string.one_key_setting_waiting));
        if (this.d.size() == 0) {
            this.a.findViewById(R.id.task_ll_1).setVisibility(8);
        }
        if (this.e.size() == 0) {
            this.a.findViewById(R.id.task_ll_2).setVisibility(8);
        }
        if (this.f.size() == 0) {
            this.a.findViewById(R.id.task_ll_3).setVisibility(8);
        }
        l();
    }

    public void c() {
        this.J.startPercent();
        f();
    }

    public void d() {
        this.J.stopPercent();
        e();
    }

    public void e() {
        if (this.L == 1) {
            this.v.setVisibility(8);
            this.y.setVisibility(8);
            this.s.setVisibility(0);
        } else if (this.L == 2) {
            this.w.setVisibility(8);
            this.z.setVisibility(8);
            this.t.setVisibility(0);
        } else {
            this.x.setVisibility(8);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
        }
    }

    public void f() {
        if (this.L == 1) {
            this.v.setVisibility(0);
            this.y.setVisibility(0);
            this.s.setVisibility(8);
            this.J.setProgress(0.0f, 1.0f / ((float) this.d.size()));
        } else if (this.L == 2) {
            this.w.setVisibility(0);
            this.z.setVisibility(0);
            this.t.setVisibility(8);
            this.J.setProgress(0.0f, 1.0f / ((float) this.e.size()));
        } else {
            this.x.setVisibility(0);
            this.A.setVisibility(0);
            this.u.setVisibility(8);
            this.J.setProgress(0.0f, 1.0f / ((float) this.f.size()));
        }
    }

    public void g() {
        this.D.setAlpha(0.0f);
        this.E.setAlpha(0.0f);
        this.a.setBackgroundColor(-32908);
        this.H.setTranslationY(0.0f);
        this.H.setAlpha(1.0f);
        a(0, this.I);
        a(0, this.I);
        this.B.a(false);
        this.C.d();
    }

    public void h() {
        this.B.a();
        this.C.a(true);
        o();
        q();
    }

    public void i() {
        this.B.a();
        this.C.a(false);
    }

    public void j() {
        this.C.a();
    }
}
