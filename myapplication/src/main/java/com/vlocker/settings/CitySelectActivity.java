package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import com.vlocker.weather.b.c;
import com.vlocker.weather.e.d;
import com.vlocker.weather.e.j;

public class CitySelectActivity extends Activity implements OnClickListener, OnItemClickListener {
    private static String a = "extra_from_cover";
    private static String b = "extra_from_cover_error_tip";
    private f c;
    private AutoCompleteTextView d;
    private View e;
    private View f;
    private TextView g;
    private ImageView h;
    private boolean i = false;
    private boolean j;
    private ImageView k;
    private V2SettingHeaderBar l;
    private boolean m;
    private ao n;

    private void a(Context context) {
        a.a(MoSecurityApplication.a()).g(0);
        j.e(context);
    }

    public static void a(Context context, boolean z) {
        try {
            Intent intent = new Intent(context, CitySelectActivity.class);
            intent.putExtra(a, z);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    private void a(com.vlocker.weather.b.a aVar) {
        if (!aVar.b().equals(a.a((Context) this).C())) {
            sendBroadcast(new Intent("com.vlocker.app.msgcount.remove.weahter"));
        }
        a.a((Context) this).k(false);
        this.h.setImageResource(R.drawable.l_setting_off);
        a.a((Context) this).i(aVar.b());
        a.a((Context) this).h(aVar.d());
        a.a((Context) this).k(aVar.a());
        a.a((Context) this).l(aVar.c());
        a.a((Context) this).J();
        a.a((Context) this).s(true);
        a.a((Context) this).l(false);
        mcm.sdk.a.a(this, aVar.d().replace("w-", ""), "");
        if (a.a((Context) this).G()) {
            a.a((Context) this).m(aVar.g());
        }
        try {
            a((Context) this);
        } catch (Exception e) {
        }
        g();
        if (!a.a((Context) this).aa()) {
            a.a((Context) this).Z();
        }
    }

    private void a(boolean z) {
        if (z) {
            this.h.setImageResource(R.drawable.l_setting_on);
            a.a((Context) this).s(true);
        } else {
            this.h.setImageResource(R.drawable.l_setting_off);
            a.a((Context) this).s(false);
        }
        a.a((Context) this).k(z);
        a.a((Context) this).i("");
        a.a((Context) this).h("");
        a.a((Context) this).k("");
        a.a((Context) this).l("");
        a.a((Context) this).J();
        a.a((Context) this).l(false);
        try {
            a((Context) this);
            if (a.a((Context) this).x()) {
                c.a(getApplicationContext()).a(true);
            } else {
                c.a(getApplicationContext()).a(false);
            }
        } catch (Exception e) {
        }
        g();
        if (z) {
            k();
            Toast.makeText(this, R.string.location_set_as_auto, 0).show();
        }
    }

    public static void b(Context context, boolean z) {
        try {
            Intent intent = new Intent(context, CitySelectActivity.class);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.addFlags(268435456);
            intent.putExtra(a, z);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public static void c(Context context, boolean z) {
        try {
            Intent intent = new Intent(context, CitySelectActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(a, z);
            intent.putExtra(b, true);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }

    private void f() {
        this.l = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.l.setTitle(getString(R.string.setting_city_txt));
        this.l.setBackOnClickListener(new d(this));
        this.d = (AutoCompleteTextView) findViewById(R.id.city_auto_complete);
        this.h = (ImageView) findViewById(R.id.auto_location_img);
        this.k = (ImageView) findViewById(R.id.icon_delete);
        this.e = findViewById(R.id.search_no_result_layout);
        this.f = findViewById(R.id.current_location_layout);
        this.g = (TextView) findViewById(R.id.current_location_text);
        this.d.setDropDownBackgroundResource(R.color.l_v3_popwindow_bg);
        g();
        if (a.a((Context) this).I()) {
            this.h.setImageResource(R.drawable.l_setting_on);
        } else {
            this.h.setImageResource(R.drawable.l_setting_off);
        }
        this.k.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    private void g() {
        boolean I = a.a((Context) this).I();
        if (a.a((Context) this).W()) {
            String C = a.a((Context) this).C();
            if (C == null || C.equals("null")) {
                this.g.setText(getString(R.string.location_current, new Object[]{getString(R.string.not_set)}));
                return;
            } else if (I) {
                this.g.setText(getString(R.string.location_current_auto, new Object[]{C}));
                return;
            } else {
                this.g.setText(getString(R.string.location_current, new Object[]{C}));
                return;
            }
        }
        this.g.setText(getString(R.string.location_current, new Object[]{getString(R.string.not_set)}));
    }

    private void h() {
        try {
            if (this.n != null) {
                if (this.n.isShowing()) {
                    this.n.dismiss();
                }
                this.n = null;
            }
            this.n = new ao(this, R.style.aiVlockerFeedbackDialog);
            this.n.b(R.layout.l_dialog_one_button);
            this.n.a.setText(R.string.dialog_weather_enable_remind_title);
            this.n.d.setText(R.string.dialog_weather_enable_remind_negative);
            this.n.d.setOnClickListener(new e(this));
        } catch (Exception e) {
            if (this.n != null && this.n.isShowing()) {
                this.n.dismiss();
            }
        }
    }

    private boolean i() {
        boolean I = a.a((Context) this).I();
        boolean H = a.a((Context) this).H();
        if (I || !H) {
            return false;
        }
        h();
        return true;
    }

    private void j() {
        if (this.d != null) {
            this.d.setText(null);
        }
    }

    private void k() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    protected void a() {
        if (this.d != null) {
            Object obj = this.d.getText().toString();
            if (obj != null) {
                this.d.setText(obj);
                this.d.setSelection(obj.length());
            }
        }
    }

    protected void b() {
        this.e.setVisibility(0);
        this.f.setVisibility(8);
    }

    protected void c() {
        this.e.setVisibility(8);
        this.f.setVisibility(0);
    }

    public void d() {
        this.m = false;
        if (this.j) {
            this.m = true;
            LockerService.a().b();
        }
        if (getIntent().getBooleanExtra(b, false) && !(this.i && a.a((Context) this).H())) {
            a.a((Context) this).X();
        }
        finish();
    }

    public void e() {
        if (!i()) {
            d();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.auto_location_img:
                this.d.setText(null);
                a(!a.a((Context) this).I());
                d.a((Context) this, "Weather(V)_SetLocation_PPC_YZY", "SetLocation", "Autoregistration");
                return;
            case R.id.icon_delete:
                j();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.l_activity_city_select);
        this.j = getIntent().getBooleanExtra(a, false);
        f();
        this.c = new f(this, this);
        this.d.setAdapter(this.c);
        this.d.setOnItemClickListener(this);
        this.d.setOnEditorActionListener(new c(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.m) {
            this.m = false;
        }
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.c != null) {
            com.vlocker.weather.b.a b = this.c.b(i);
            if (b != null) {
                a(b);
                k();
                d.a((Context) this, "Weather(V)_SetLocation_PPC_YZY", "SetLocation", "Search");
                Toast.makeText(this, getString(R.string.location_set_as, new Object[]{b.e()}), 0).show();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            System.gc();
            e();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onStart() {
        super.onStart();
    }
}
