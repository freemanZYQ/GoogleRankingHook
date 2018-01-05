package com.vlocker.setting;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.setting.ui.HexagonContentView;
import com.vlocker.setting.ui.HexagonView;
import com.vlocker.setting.ui.y;

public class a {
    private View a;
    private TextView b;
    private Context c;
    private HexagonView d;
    private HexagonContentView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private Button i;
    private TextView j;
    private RelativeLayout k;
    private y l = new f(this);
    private h m = new g(this);

    public a(Context context) {
        this.c = context;
        k();
    }

    private void a(TextView textView, boolean z) {
        textView.animate().alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(z ? 300 : 500).setStartDelay(400).setListener(null).start();
    }

    private void d(int i) {
        Intent intent = new Intent(this.c, FlowWebViewActivity.class);
        intent.putExtra("tag", "private");
        if (i == 1) {
            intent.putExtra("url", j.l() + "&" + j.d(this.c));
            intent.putExtra("title", this.c.getString(R.string.trems_of_service));
        } else if (i == 2) {
            intent.putExtra("url", j.m() + "&" + j.d(this.c));
            intent.putExtra("title", this.c.getString(R.string.private_policy));
        }
        this.c.startActivity(intent);
    }

    private void k() {
        this.a = LayoutInflater.from(this.c).inflate(R.layout.one_key_setting_main, null);
        this.j = (TextView) this.a.findViewById(R.id.repair_detecting);
        this.b = (TextView) this.a.findViewById(R.id.repair_tips);
        this.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.b.setHighlightColor(0);
        this.d = (HexagonView) this.a.findViewById(R.id.setting_hexagon_view);
        this.e = (HexagonContentView) this.a.findViewById(R.id.setting_hexagon_content_view);
        this.f = (TextView) this.a.findViewById(R.id.setting_hexagon_content_title);
        this.g = (TextView) this.a.findViewById(R.id.setting_hexagon_content_des);
        this.g.setTypeface(Typeface.createFromAsset(this.c.getAssets(), "fonts/setting_font.otf"));
        this.d.setCallback(this.m);
        this.e.setCallback(this.l);
        this.h = (TextView) this.a.findViewById(R.id.manual_set);
        this.i = (Button) this.a.findViewById(R.id.repair_now);
        this.k = (RelativeLayout) this.a.findViewById(R.id.layout_setting_hexagon);
        if (com.vlocker.c.a.a(this.c).bp()) {
            this.b.setVisibility(0);
            this.b.setText(l(), BufferType.SPANNABLE);
            return;
        }
        this.b.setVisibility(4);
    }

    private SpannableStringBuilder l() {
        String string = this.c.getString(R.string.one_key_setting_agree);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(string));
        spannableStringBuilder.setSpan(new b(this), string.indexOf("服"), string.indexOf("款") + 1, 0);
        spannableStringBuilder.setSpan(new c(this), string.indexOf("隐"), string.indexOf("议") + 1, 0);
        return spannableStringBuilder;
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        LayoutParams layoutParams = (LayoutParams) this.k.getLayoutParams();
        layoutParams.topMargin = i;
        this.k.setLayoutParams(layoutParams);
    }

    public void b() {
        this.j.setVisibility(0);
    }

    public void b(int i) {
        this.a.setBackgroundColor(-16532236);
        a(l.a(150.0f));
        this.f.setAlpha(1.0f);
        this.g.setAlpha(1.0f);
        if (i == 4) {
            this.f.setText(R.string.one_key_setting_title_save);
            this.g.setText(R.string.one_key_setting_des_save);
        } else {
            this.f.setText(R.string.one_key_setting_success_title);
            this.g.setText(R.string.one_key_setting_success_des);
        }
        this.d.b();
        this.e.setFinishViewStatus(true);
        this.i.setVisibility(4);
        this.h.setVisibility(4);
        this.b.setVisibility(4);
    }

    public void c() {
        this.d.a(true);
        this.e.c();
    }

    public void c(int i) {
        this.a.setBackgroundColor(-32908);
        a(l.a(80.0f));
        this.f.setAlpha(1.0f);
        this.g.setAlpha(1.0f);
        if (i == 3) {
            this.f.setText(R.string.one_key_setting_title_break);
            this.g.setText(R.string.one_key_setting_des_break);
        } else if (i == 2) {
            this.f.setText(R.string.one_key_setting_title_restart);
            this.g.setText(R.string.one_key_setting_des_restart);
        } else {
            this.f.setText(R.string.one_key_setting_init_title);
            this.g.setText(R.string.one_key_setting_init_des);
        }
        this.d.b();
        this.e.setFinishViewStatus(false);
        this.i.setScaleX(1.0f);
        this.i.setScaleY(1.0f);
        this.h.setAlpha(1.0f);
    }

    public void d() {
        this.d.a();
        this.e.b();
    }

    public void e() {
        a(this.h, false);
    }

    public void f() {
        this.i.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(875).setInterpolator(new DecelerateInterpolator()).setDuration(350).start();
    }

    public void g() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-16532236, -32908});
        ofInt.setDuration(500);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.addUpdateListener(new d(this));
        ofInt.start();
    }

    public void h() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{l.a(150.0f), l.a(80.0f)});
        ofInt.setDuration(500);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new e(this));
        ofInt.start();
    }

    public void i() {
        this.j.animate().alpha(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(300).setStartDelay(100).setListener(null).start();
    }

    public void j() {
        this.e.a();
    }
}
