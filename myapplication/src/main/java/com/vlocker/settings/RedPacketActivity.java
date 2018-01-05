package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.m.h;
import com.vlocker.m.o;
import com.vlocker.msg.McmPushWidget;
import com.vlocker.msg.an;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.theme.f.e;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import java.lang.reflect.Field;

public class RedPacketActivity extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private CheckBox b;
    private CheckBox c;
    private CheckBox d;
    private a e;
    private ao f;
    private ao g;
    private NumberPicker h;
    private NumberPicker i;
    private NumberPicker j;
    private NumberPicker k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private String[] p = new String[24];
    private String[] q = new String[60];
    private RelativeLayout r;
    private boolean s;
    private OnValueChangeListener t = new ch(this);

    private String a(int i) {
        return i < 6 ? getString(R.string.dawn) : i < 12 ? getString(R.string.morning) : i < 18 ? getString(R.string.afternoon) : getString(R.string.night);
    }

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setTitle(getString(R.string.rob_red_packet_prompt));
        this.a.setBackOnClickListener(new cd(this));
        this.b = (CheckBox) findViewById(R.id.rob_red_packet_check);
        this.c = (CheckBox) findViewById(R.id.voice_prompt_check);
        this.d = (CheckBox) findViewById(R.id.vibrate_prompt_check);
        findViewById(R.id.layout_rob_red_packet).setOnClickListener(this);
        findViewById(R.id.layout_vibrate_prompt).setOnClickListener(this);
        findViewById(R.id.layout_voice_prompt).setOnClickListener(this);
        findViewById(R.id.layout_voice_select).setOnClickListener(this);
        findViewById(R.id.layout_night_not_prompt).setOnClickListener(this);
        findViewById(R.id.layout_strategy_red_packet).setOnClickListener(this);
        this.r = (RelativeLayout) findViewById(R.id.layout_invite_red_packet);
        this.r.setOnClickListener(this);
        if (this.e.bL()) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        this.l = (TextView) findViewById(R.id.tv_night_not_prompt_des);
        this.o = (TextView) findViewById(R.id.tv_voice_select_des);
    }

    private void a(NumberPicker numberPicker) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDividerHeight");
            declaredField.setAccessible(true);
            try {
                declaredField.set(numberPicker, Integer.valueOf((int) (getResources().getDisplayMetrics().density + 0.5f)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(NumberPicker numberPicker, Drawable drawable) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            try {
                declaredField.set(numberPicker, drawable);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(boolean z) {
        boolean z2 = false;
        int i = -1;
        ((TextView) findViewById(R.id.tv_voice_prompt)).setTextColor(z ? -1 : getResources().getColor(R.color.v2_setting_item_title_des));
        ((TextView) findViewById(R.id.tv_vibrate_prompt)).setTextColor(z ? -1 : getResources().getColor(R.color.v2_setting_item_title_des));
        ((TextView) findViewById(R.id.tv_voice_select)).setTextColor(z ? -1 : getResources().getColor(R.color.v2_setting_item_title_des));
        TextView textView = (TextView) findViewById(R.id.tv_night_not_prompt);
        if (!z) {
            i = getResources().getColor(R.color.v2_setting_item_title_des);
        }
        textView.setTextColor(i);
        this.d.setChecked(z ? this.e.bx() : false);
        CheckBox checkBox = this.c;
        if (z) {
            z2 = this.e.bw();
        }
        checkBox.setChecked(z2);
    }

    private boolean a(NumberPicker numberPicker, int i) {
        int childCount = numberPicker.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = numberPicker.getChildAt(i2);
            if (childAt instanceof EditText) {
                try {
                    Field declaredField = numberPicker.getClass().getDeclaredField("mSelectorWheelPaint");
                    declaredField.setAccessible(true);
                    ((Paint) declaredField.get(numberPicker)).setColor(i);
                    ((EditText) childAt).setTextColor(i);
                    numberPicker.invalidate();
                    return true;
                } catch (Throwable e) {
                    Log.w("setNumberPickerTextColor", e);
                } catch (Throwable e2) {
                    Log.w("setNumberPickerTextColor", e2);
                } catch (Throwable e22) {
                    Log.w("setNumberPickerTextColor", e22);
                }
            } else {
                i2++;
            }
        }
        return false;
    }

    private void b() {
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                this.p[i] = "0" + i;
                this.q[i] = "0" + i;
            } else {
                if (i < 24) {
                    this.p[i] = Integer.toString(i);
                }
                this.q[i] = Integer.toString(i);
            }
        }
    }

    private void c() {
        p.a((Context) this, "Vlocker_Help_Hongbao_Settings_PPC_TF", new String[0]);
        Intent intent = new Intent(this, FlowWebViewActivity.class);
        intent.putExtra("tag", "red_packet");
        intent.putExtra("title", "抢红包攻略");
        String d = e.d(this);
        String c = h.c();
        if (c == null) {
            c = "cn";
        }
        intent.putExtra("url", "http://mobile.moxiu.com/misc/?do=Vlocker.Gift&imei=" + d + "&channel=" + j.p(this) + "&language=" + c + "&version=" + o.b(this));
        startActivity(intent);
    }

    private void d() {
        Intent intent = new Intent(this, FlowWebViewActivity.class);
        intent.putExtra("tag", "red_packet");
        intent.putExtra("title", "官方红包群");
        String d = e.d(this);
        String c = h.c();
        if (c == null) {
            c = "cn";
        }
        String str = "";
        d = "url";
        intent.putExtra(d, "http://mobile.moxiu.com/misc/?do=Vlocker.Gift&type=invite" + "&imei=" + d + "&channel=" + j.p(this) + "&language=" + c + "&version=" + o.b(this));
        startActivity(intent);
    }

    private void e() {
        this.e.af(true);
        this.g = new ao(this, R.style.aiVlockerTimeDialog);
        this.g.setCanceledOnTouchOutside(true);
        this.g.b(R.layout.l_dialog_red_packet);
        this.g.d.setOnClickListener(this);
    }

    private void f() {
        int by = this.e.by();
        if (by == 0) {
            this.o.setText(R.string.voice_prompt_1);
        } else if (by == 1) {
            this.o.setText(R.string.voice_prompt_2);
        } else if (by == 2) {
            this.o.setText(R.string.voice_prompt_3);
        } else if (by == 3) {
            this.o.setText(R.string.voice_prompt_4);
        } else if (by == 4) {
            this.o.setText(R.string.voice_prompt_5);
        } else if (by == 5) {
            this.o.setText(R.string.voice_prompt_6);
        } else if (by == 6) {
            this.o.setText(R.string.voice_prompt_7);
        }
    }

    private void g() {
        try {
            if (this.f != null) {
                if (this.f.isShowing()) {
                    this.f.dismiss();
                }
                this.f = null;
            }
            this.f = new ao(this, R.style.aiVlockerTimeDialog);
            this.f.setCanceledOnTouchOutside(true);
            this.f.c(R.layout.l_dialog_notify_time);
            this.m = (TextView) this.f.findViewById(R.id.tv_notify_time_des_1);
            this.n = (TextView) this.f.findViewById(R.id.tv_notify_time_des_2);
            this.m.setText(a(this.e.br()));
            this.n.setText(a(this.e.bt()));
            this.h = (NumberPicker) this.f.findViewById(R.id.picker_notify_time_dialog_1);
            this.i = (NumberPicker) this.f.findViewById(R.id.picker_notify_time_dialog_2);
            this.j = (NumberPicker) this.f.findViewById(R.id.picker_notify_time_dialog_3);
            this.k = (NumberPicker) this.f.findViewById(R.id.picker_notify_time_dialog_4);
            a(this.h);
            a(this.i);
            a(this.j);
            a(this.k);
            a(this.h, getResources().getDrawable(R.color.white));
            a(this.i, getResources().getDrawable(R.color.white));
            a(this.j, getResources().getDrawable(R.color.white));
            a(this.k, getResources().getDrawable(R.color.white));
            a(this.h, -1);
            a(this.i, -1);
            a(this.j, -1);
            a(this.k, -1);
            this.h.setDescendantFocusability(393216);
            this.i.setDescendantFocusability(393216);
            this.j.setDescendantFocusability(393216);
            this.k.setDescendantFocusability(393216);
            this.h.setMinValue(0);
            this.h.setMaxValue(23);
            this.i.setMinValue(0);
            this.i.setMaxValue(59);
            this.j.setMinValue(0);
            this.j.setMaxValue(23);
            this.k.setMinValue(0);
            this.k.setMaxValue(59);
            this.h.setDisplayedValues(this.p);
            this.j.setDisplayedValues(this.p);
            this.i.setDisplayedValues(this.q);
            this.k.setDisplayedValues(this.q);
            this.h.setValue(this.e.br());
            this.i.setValue(this.e.bs());
            this.k.setValue(this.e.bu());
            this.j.setValue(this.e.bt());
            this.h.setOnValueChangedListener(this.t);
            this.i.setOnValueChangedListener(this.t);
            this.j.setOnValueChangedListener(this.t);
            this.k.setOnValueChangedListener(this.t);
            this.f.e.setText(R.string.btn_cancel);
            this.f.d.setText(R.string.btn_ok);
            this.f.d.setOnClickListener(new cf(this));
            this.f.e.setOnClickListener(new cg(this));
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f != null && this.f.isShowing()) {
                this.f.dismiss();
            }
        }
    }

    private void h() {
        if (this.e.br() == this.e.bt() && this.e.bs() == this.e.bu()) {
            this.l.setText(getString(R.string.nothing));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(this.e.br()));
        if (this.e.br() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.e.br());
        stringBuilder.append(":");
        if (this.e.bs() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.e.bs());
        stringBuilder.append("~");
        stringBuilder.append(a(this.e.bt()));
        if (this.e.bt() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.e.bt());
        stringBuilder.append(":");
        if (this.e.bu() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.e.bu());
        this.l.setText(stringBuilder.toString());
    }

    private void i() {
        try {
            p.a((Context) this, "Vlocker_Open_Msg_Service_PPC_TF", new String[0]);
            b.a(this).a();
        } catch (Exception e) {
        }
    }

    public void onClick(View view) {
        boolean z = true;
        if (view.getId() == R.id.layout_rob_red_packet || this.e.bv() || view.getId() == R.id.layout_strategy_red_packet) {
            CheckBox checkBox;
            switch (view.getId()) {
                case R.id.new_sure_btn:
                    c();
                    this.g.dismiss();
                    return;
                case R.id.layout_rob_red_packet:
                    if (this.e.bv() || an.c(this) || !an.a((Context) this) || VERSION.SDK_INT < 18) {
                        this.e.ab(!this.b.isChecked());
                        checkBox = this.b;
                        if (this.b.isChecked()) {
                            z = false;
                        }
                        checkBox.setChecked(z);
                        if (this.e.bv()) {
                            McmPushWidget.getInstance(this).removeRedPacketMsg();
                            com.vlocker.msg.p.a().a("red_packet_msg");
                            if (this.e.bA()) {
                                Toast.makeText(this, getString(R.string.toast_open_red_packet), 0).show();
                            } else {
                                e();
                            }
                        } else {
                            Toast.makeText(this, getString(R.string.toast_close_red_packet), 0).show();
                        }
                        a(this.e.bv());
                        return;
                    }
                    i();
                    this.s = true;
                    return;
                case R.id.layout_voice_prompt:
                    this.e.ac(!this.c.isChecked());
                    checkBox = this.c;
                    if (this.c.isChecked()) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    return;
                case R.id.layout_voice_select:
                    com.vlocker.d.a aVar = new com.vlocker.d.a(this, new ce(this));
                    return;
                case R.id.layout_vibrate_prompt:
                    this.e.ad(!this.d.isChecked());
                    checkBox = this.d;
                    if (this.d.isChecked()) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    return;
                case R.id.layout_night_not_prompt:
                    g();
                    return;
                case R.id.layout_strategy_red_packet:
                    c();
                    return;
                case R.id.layout_invite_red_packet:
                    d();
                    return;
                default:
                    return;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_v3_activity_setting_redpacket);
        this.e = a.a((Context) this);
        b();
        a();
        h();
        f();
        if (!this.e.bz()) {
            this.e.ae(true);
        }
        McmPushWidget.getInstance(this).removeRedPacketMsg();
        CharSequence stringExtra = getIntent().getStringExtra("from");
        if (!TextUtils.isEmpty(stringExtra) && com.vlocker.setting.a.a.e.ACTION_MAIN.equals(stringExtra) && an.c(this)) {
            this.e.ab(true);
            a(this.e.bv());
            if (!this.e.bA()) {
                e();
            }
            McmPushWidget.getInstance(this).removeRedPacketMsg();
            com.vlocker.msg.p.a().a("red_packet_msg");
        } else if (!TextUtils.isEmpty(stringExtra) && com.vlocker.setting.a.a.e.ACTION_MAIN.equals(stringExtra) && !an.c(this)) {
            com.vlocker.msg.p.a().a("red_packet_msg");
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.s && an.c(this)) {
            this.e.ab(true);
            if (!this.e.bA()) {
                e();
            }
        } else if (!an.c(this)) {
            this.e.ab(false);
        }
        if (this.r != null) {
            if (this.e.bL()) {
                this.r.setVisibility(0);
            } else {
                this.r.setVisibility(8);
            }
        }
        this.b.setChecked(this.e.bv());
        this.d.setChecked(this.e.bx());
        this.c.setChecked(this.e.bw());
        a(this.e.bv());
    }
}
