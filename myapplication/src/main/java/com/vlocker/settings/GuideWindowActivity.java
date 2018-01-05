package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.e;
import com.vlocker.m.l;
import com.vlocker.theme.f.b;

public class GuideWindowActivity extends Activity {
    public static void a(Context context, int i) {
        Object obj = (b.t() || b.r()) ? 1 : null;
        int i2 = obj != null ? 2 : 1;
        int i3 = i == 1 ? obj != null ? R.layout.guide_setting_window_open_float_window_miui_v6_view : R.layout.guide_setting_window_open_float_window_view : i == 2 ? obj != null ? R.layout.guide_setting_window_auto_launch_miui_v6_view : R.layout.guide_setting_window_auto_launch_view : R.layout.guide_setting_window_disable_sys_locker_miui_view;
        if (i3 != 0) {
            e.a(context, i);
            if (!e.a || i != 2) {
                b(context, i2, i3);
            }
        }
    }

    public static void a(Context context, int i, int i2) {
        int i3 = -1;
        if (1 == i) {
            i3 = R.layout.guide_setting_window_disable_sys_locker_huawei_view;
        } else if (2 == i) {
            i3 = i2 == 1 ? R.layout.guide_setting_window_auto_launch_locker_default : R.layout.guide_setting_window_auto_launch_locker_default_huawei;
        }
        b(context, 3, i3);
    }

    public static void b(Context context, int i) {
        if (1 == i) {
            if (b.e()) {
                if (b.h()) {
                    c(context, 2);
                } else if (b.j()) {
                    c(context, 3);
                }
            } else if (VERSION.SDK_INT >= 21 && b.n()) {
                c(context, 1);
            } else if (b.F()) {
                c(context, 4);
            } else if (b.G()) {
                c(context, 5);
            } else {
                c(context, 0);
            }
        } else if (2 != i) {
        } else {
            if (VERSION.SDK_INT >= 18) {
                View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.guide_setting_manual, null);
                Toast toast = new Toast(context.getApplicationContext());
                toast.setGravity(119, 0, 0);
                toast.setDuration(1);
                toast.setView(inflate);
                toast.show();
                return;
            }
            b(context, 4, R.layout.guide_setting_window_notify_lt_18_view);
        }
    }

    private static void b(Context context, int i, int i2) {
        new Handler(Looper.getMainLooper()).postDelayed(new at(context, i, i2), 500);
    }

    private static void c(Context context, int i) {
        Toast toast = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.guide_setting_window_disable_sys_locker_default, null);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_tips);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txt_tips_sumsung);
        if (a.a(context).ch()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        CharSequence spannableString;
        switch (i) {
            case 0:
                spannableString = new SpannableString(context.getResources().getString(R.string.select_none_locker_default));
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 21, 23, 33);
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 26, 27, 33);
                textView.setText(spannableString);
                break;
            case 1:
                textView.setText(context.getResources().getString(R.string.select_none_locker_coloros3));
                break;
            case 2:
                spannableString = new SpannableString(context.getResources().getString(R.string.select_none_locker_flyme5));
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 5, 9, 33);
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 12, 16, 33);
                textView.setText(spannableString);
                break;
            case 3:
                spannableString = new SpannableString(context.getResources().getString(R.string.select_none_locker_flyme34));
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 5, 9, 33);
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 24, 28, 33);
                textView.setText(spannableString);
                break;
            case 4:
                spannableString = new SpannableString(context.getResources().getString(R.string.select_none_locker_vivo3));
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 5, 11, 33);
                textView.setText(spannableString);
                break;
            case 5:
                spannableString = new SpannableString(context.getResources().getString(R.string.select_none_locker_360));
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 15, 19, 33);
                spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 32, 36, 33);
                textView.setText(spannableString);
                break;
        }
        toast.setGravity(23, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("systype", 0);
        LayoutParams attributes = getWindow().getAttributes();
        if (intExtra == 1) {
            attributes.gravity = 48;
        }
        int intExtra2 = intent.getIntExtra("view_res_id", 0);
        if (intExtra2 > 0) {
            View inflate = View.inflate(this, intExtra2, null);
            setContentView(inflate, attributes);
            int a = l.a();
            if (a <= 480) {
                getWindow().setLayout((int) ((((float) a) * 6.0f) / 7.0f), -2);
            }
            if (intExtra == 1) {
                inflate.post(new as(this));
                inflate.setOnClickListener(new ar(this));
            }
            inflate = findViewById(R.id.btn_guide_confirm);
            if (inflate != null) {
                inflate.setOnClickListener(new ar(this));
            }
            if (b.p()) {
                TextView textView = (TextView) findViewById(R.id.txt_tips);
                if (textView != null && getResources().getString(R.string.select_none_locker).equals(textView.getText())) {
                    if (!b.n() || b.o()) {
                        textView.setText(R.string.select_none_pwd);
                    } else {
                        textView.setText(R.string.close_locker_pwd);
                    }
                }
            }
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
