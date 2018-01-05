package com.vlocker.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.locker.R;
import com.vlocker.msg.an;
import com.vlocker.settings.GuideWindowActivity;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.k;

public class d extends a {
    public static boolean b = false;

    public d(Context context) {
        super(context);
    }

    private static void a(Context context) {
        Toast toast = new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.guide_setting_window_disable_sys_locker_default, null);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_tips);
        CharSequence spannableString = new SpannableString(context.getResources().getString(R.string.setting_miui_colse_syspwd));
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.theme_v3_text_blue)), 14, 18, 33);
        textView.setText(spannableString);
        toast.setGravity(87, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    public void a() {
        if (an.a(this.a)) {
            super.a();
        } else {
            GuideWindowActivity.a(this.a, 2);
        }
    }

    public void a(int i) {
        if (k.a(this.a)) {
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings"));
                intent.putExtra(":android:show_fragment_args", 0);
                intent.putExtra(":android:no_headers", true);
                intent.putExtra(":android:show_fragment_short_title", 0);
                intent.putExtra(":android:show_fragment_title", 2131362197);
                intent.putExtra(":android:show_fragment", "com.android.settings.MiuiSecurityCommonSettings$MiuiSecurityCommonSettingsFragment");
                this.a.startActivity(intent);
                b = true;
                if (i == 1) {
                    a(this.a);
                }
            } catch (Exception e) {
                try {
                    this.a.startActivity(new Intent("android.app.action.SET_NEW_PASSWORD"));
                    GuideWindowActivity.b(this.a, i);
                } catch (Exception e2) {
                }
            }
        } else if (b.u()) {
            GuideWindowActivity.a(this.a, 3);
        } else {
            super.a(1);
        }
    }
}
