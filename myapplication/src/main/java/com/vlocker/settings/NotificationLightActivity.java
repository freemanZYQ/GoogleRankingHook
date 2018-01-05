package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.SettingService;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import java.lang.reflect.Field;

public class NotificationLightActivity extends Activity implements OnClickListener {
    private a a = null;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private V2SettingHeaderBar g;
    private String[] h = new String[24];
    private String[] i = new String[60];
    private RelativeLayout j;
    private ao k;
    private NumberPicker l;
    private NumberPicker m;
    private NumberPicker n;
    private NumberPicker o;
    private OnValueChangeListener p = new bk(this);

    private String a(int i) {
        return i < 6 ? getString(R.string.dawn) : i < 12 ? getString(R.string.morning) : i < 18 ? getString(R.string.afternoon) : getString(R.string.night);
    }

    private void a() {
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                this.h[i] = "0" + i;
                this.i[i] = "0" + i;
            } else {
                if (i < 24) {
                    this.h[i] = Integer.toString(i);
                }
                this.i[i] = Integer.toString(i);
            }
        }
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, NotificationLightActivity.class));
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageResource(R.drawable.l_setting_on);
        } else {
            imageView.setImageResource(R.drawable.l_setting_off);
        }
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
        this.g = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.g.setTitle(getString(R.string.setting_notify_show_title));
        this.g.setBackOnClickListener(new bh(this));
        this.b = (ImageView) findViewById(R.id.notify_light_enable_img);
        this.c = (ImageView) findViewById(R.id.notify_se_img);
        a(this.b, this.a.aS());
        a(this.c, this.a.aY());
        this.d = (TextView) findViewById(R.id.notify_time_tv_des);
        c();
        findViewById(R.id.notify_time_layout).setOnClickListener(this);
        findViewById(R.id.notify_light_enable_layout).setOnClickListener(this);
        findViewById(R.id.notify_se_layout).setOnClickListener(this);
        this.j = (RelativeLayout) findViewById(R.id.notify_app_select);
        this.j.setOnClickListener(this);
    }

    private void c() {
        if (this.a.aU() == this.a.aW() && this.a.aV() == this.a.aX()) {
            this.d.setText(getString(R.string.nothing));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(this.a.aU()));
        if (this.a.aU() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.a.aU());
        stringBuilder.append(":");
        if (this.a.aV() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.a.aV());
        stringBuilder.append("~");
        stringBuilder.append(a(this.a.aW()));
        if (this.a.aW() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.a.aW());
        stringBuilder.append(":");
        if (this.a.aX() < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(this.a.aX());
        this.d.setText(stringBuilder.toString());
    }

    private void d() {
        try {
            if (this.k != null) {
                if (this.k.isShowing()) {
                    this.k.dismiss();
                }
                this.k = null;
            }
            this.k = new ao(this, R.style.aiVlockerTimeDialog);
            this.k.setCanceledOnTouchOutside(true);
            this.k.c(R.layout.l_dialog_notify_time);
            this.e = (TextView) this.k.findViewById(R.id.tv_notify_time_des_1);
            this.f = (TextView) this.k.findViewById(R.id.tv_notify_time_des_2);
            this.e.setText(a(this.a.aU()));
            this.f.setText(a(this.a.aW()));
            this.l = (NumberPicker) this.k.findViewById(R.id.picker_notify_time_dialog_1);
            this.m = (NumberPicker) this.k.findViewById(R.id.picker_notify_time_dialog_2);
            this.n = (NumberPicker) this.k.findViewById(R.id.picker_notify_time_dialog_3);
            this.o = (NumberPicker) this.k.findViewById(R.id.picker_notify_time_dialog_4);
            a(this.l);
            a(this.m);
            a(this.n);
            a(this.o);
            a(this.l, getResources().getDrawable(R.color.white));
            a(this.m, getResources().getDrawable(R.color.white));
            a(this.n, getResources().getDrawable(R.color.white));
            a(this.o, getResources().getDrawable(R.color.white));
            a(this.l, -1);
            a(this.m, -1);
            a(this.n, -1);
            a(this.o, -1);
            this.l.setDescendantFocusability(393216);
            this.m.setDescendantFocusability(393216);
            this.n.setDescendantFocusability(393216);
            this.o.setDescendantFocusability(393216);
            this.l.setMinValue(0);
            this.l.setMaxValue(23);
            this.m.setMinValue(0);
            this.m.setMaxValue(59);
            this.n.setMinValue(0);
            this.n.setMaxValue(23);
            this.o.setMinValue(0);
            this.o.setMaxValue(59);
            this.l.setDisplayedValues(this.h);
            this.n.setDisplayedValues(this.h);
            this.m.setDisplayedValues(this.i);
            this.o.setDisplayedValues(this.i);
            this.l.setValue(this.a.aU());
            this.m.setValue(this.a.aV());
            this.o.setValue(this.a.aX());
            this.n.setValue(this.a.aW());
            this.l.setOnValueChangedListener(this.p);
            this.m.setOnValueChangedListener(this.p);
            this.n.setOnValueChangedListener(this.p);
            this.o.setOnValueChangedListener(this.p);
            this.k.e.setText(R.string.btn_cancel);
            this.k.d.setText(R.string.btn_ok);
            this.k.d.setOnClickListener(new bi(this));
            this.k.e.setOnClickListener(new bj(this));
        } catch (Exception e) {
            e.printStackTrace();
            if (this.k != null && this.k.isShowing()) {
                this.k.dismiss();
            }
        }
    }

    public void onClick(View view) {
        boolean z;
        switch (view.getId()) {
            case R.id.notify_light_enable_layout:
                z = !this.a.aS();
                String str = "Vlocker_Open_Light_Msg_PPC_TF";
                String[] strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = z ? "On" : "Off";
                p.a((Context) this, str, strArr);
                this.a.O(z);
                if (z) {
                    this.a.K(true);
                } else if (this.a.aY()) {
                    this.a.P(false);
                    a(this.c, false);
                }
                a(this.b, z);
                return;
            case R.id.notify_se_layout:
                z = !this.a.aY();
                String str2 = "Vlocker_Open_EnergySave_LightMsg_PPC_TF";
                String[] strArr2 = new String[2];
                strArr2[0] = "status";
                strArr2[1] = z ? "On" : "Off";
                p.a((Context) this, str2, strArr2);
                this.a.P(z);
                if (z) {
                    this.a.O(true);
                    this.a.K(true);
                    a(this.b, true);
                }
                a(this.c, z);
                return;
            case R.id.notify_time_layout:
                d();
                return;
            case R.id.notify_app_select:
                startActivity(new Intent(this, NotifyLightAppsSelectActivity.class));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        setContentView(R.layout.l_notification_light_settings);
        this.a = a.a((Context) this);
        b();
        a();
        if (VERSION.SDK_INT < 18) {
            return;
        }
        if (!MoSecurityApplication.e || SettingService.b((Context) this)) {
            this.j.setVisibility(0);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
