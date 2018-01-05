package com.vlocker.theme.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.au;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.d.c;
import com.vlocker.locker.R;
import com.vlocker.locker.b.am;
import com.vlocker.m.aj;
import com.vlocker.m.ay;
import com.vlocker.m.az;
import com.vlocker.m.g;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.theme.a.d;
import com.vlocker.theme.a.e;
import com.vlocker.theme.c.b;
import com.vlocker.theme.view.VerticalColorSeekBar;
import com.vlocker.theme.view.a;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.view.ap;
import com.xinmei365.fontsdk.FontCenter;
import com.xinmei365.fontsdk.bean.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnlockTextEditActivity extends Activity implements TextWatcher, OnClickListener, e, a {
    private ImageView a;
    private ImageView b;
    private View c;
    private RelativeLayout d;
    private LinearLayout e;
    private RecyclerView f;
    private EditText g;
    private VerticalColorSeekBar h;
    private d i;
    private List j = new ArrayList();
    private int k = -1;
    private int l = -16777216;
    private com.vlocker.c.a m;
    private int n;
    private v o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private ap t;
    private InputMethodManager u;
    private float v;
    private boolean w;
    private long x;

    private void a(int i) {
        this.g.setCursorVisible(true);
        this.d.scrollTo(0, i);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
    }

    private void a(ArrayList arrayList, boolean z) {
        this.j.add(new b(1, null));
        if (!z) {
            this.j.add(new b(3, null));
        } else if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.j.add(new b(2, (Font) it.next()));
            }
            if (com.vlocker.theme.f.e.b((Context) this).booleanValue() && !aj.a("com.xinmei365.font")) {
                this.j.add(new b(4, null));
            }
        }
    }

    private static boolean a(char c) {
        return c == '\u0000' || c == '\t' || c == '\n' || c == '\r' || ((c >= ' ' && c <= '퟿') || ((c >= '' && c <= '�') || (c >= '\u0000' && c <= '￿')));
    }

    public static boolean a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!a(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private int b(String str) {
        if (str.length() > 2 && a(str.substring(str.length() - 2, str.length()))) {
            return this.g.getPaint().measureText(str.substring(0, str.length() + -2)) > this.v ? b(str.substring(0, str.length() - 2)) : str.length() - 2;
        } else {
            for (int i = 1; i < str.length() + 1; i++) {
                if (this.g.getPaint().measureText(str.substring(0, i)) > this.v) {
                    return i;
                }
            }
            return 0;
        }
    }

    private void b(int i) {
        b bVar = (b) this.j.get(i);
        if (bVar.b() != 3) {
            if (bVar.b() == 4) {
                k();
                return;
            }
            this.k = i;
            this.i.c(this.k);
            if (bVar.b() == 2) {
                FontCenter.getInstance().startAutoCloudText(((b) this.j.get(this.k)).a(), this.g);
            } else {
                this.g.setTypeface(null);
            }
        }
    }

    private void c() {
        this.d = (RelativeLayout) findViewById(R.id.root_view);
        this.e = (LinearLayout) findViewById(R.id.layout_recyclerview_font);
        this.a = (ImageView) findViewById(R.id.view_bg);
        this.b = (ImageView) findViewById(R.id.view_bg_blur);
        this.c = findViewById(R.id.view_bg_alpha);
        this.a.setImageBitmap(am.a().c());
        this.b.setImageBitmap(am.a().b());
        this.l = this.m.dn();
        e();
        d();
        this.h = (VerticalColorSeekBar) findViewById(R.id.view_color_seekbar);
        this.h.setOnStateChangeListener(this);
        this.h.setProgressByColor(this.l);
        findViewById(R.id.btn_edit).setOnClickListener(this);
        findViewById(R.id.btn_sure).setOnClickListener(this);
        this.d.setOnClickListener(this);
        b();
        f();
        if (VERSION.SDK_INT >= 19) {
            int d = h.d(this);
            if (this.m.ai() == 0) {
                LayoutParams layoutParams = (LayoutParams) this.q.getLayoutParams();
                layoutParams.topMargin = d + layoutParams.topMargin;
                this.q.setLayoutParams(layoutParams);
            }
        }
    }

    private void d() {
        this.f = (RecyclerView) findViewById(R.id.recyclerview_font);
        au linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.b(0);
        this.f.setLayoutManager(linearLayoutManager);
        this.f.a(new w(this, l.a(3.0f)));
        this.i = new d();
        this.i.a((e) this);
        this.f.setAdapter(this.i);
    }

    private void e() {
        CharSequence dm = this.m.dm();
        this.g = (EditText) findViewById(R.id.view_edittext);
        if (!TextUtils.isEmpty(dm)) {
            this.g.setText(dm);
        }
        this.g.addTextChangedListener(this);
        this.g.setTextColor(this.l);
        this.g.setSelection(this.g.getText().length());
        this.g.setOnEditorActionListener(new q(this));
    }

    private void f() {
        this.p = (TextView) findViewById(R.id.date_textview);
        this.q = (TextView) findViewById(R.id.time_textview);
        this.r = (TextView) findViewById(R.id.curr_temp_textview);
        this.s = (ImageView) findViewById(R.id.weather_icon);
        this.q.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/time.ttf"));
        if (!g()) {
            a();
        }
    }

    private boolean g() {
        if (com.vlocker.locker.b.ap.a() == null || com.vlocker.locker.b.ap.a().u == null || !this.m.p()) {
            return false;
        }
        this.t = com.vlocker.locker.b.ap.a((Context) this).d();
        com.vlocker.locker.b.ap.a((Context) this).a(this.d, this.t);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.s.setVisibility(8);
        this.r.setVisibility(8);
        return true;
    }

    private void h() {
        this.g.setCursorVisible(false);
        this.d.scrollTo(0, 0);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    private void i() {
        if (j.f(this)) {
            FontCenter.getInstance().getAllFontList(1, 20, new t(this));
            return;
        }
        FontCenter.getInstance().getCloudTypeface(this.m.dp(), this.m.dm(), new s(this));
        a(null, false);
        this.i.a(this.j);
    }

    private void j() {
        Object dp = this.m.dp();
        if (TextUtils.isEmpty(dp)) {
            b(0);
            return;
        }
        int i = 0;
        while (i < this.j.size()) {
            b bVar = (b) this.j.get(i);
            if (bVar.a() == null || !dp.equals(bVar.a().getFontIdNo())) {
                i++;
            } else {
                b(i);
                return;
            }
        }
    }

    private void k() {
        if (this.w) {
            this.u.toggleSoftInput(1, 2);
        }
        c cVar = new c(this, false, R.style.ShowDialog, "是否下载字体管家？", "否", "是", new u(this));
        cVar.setCanceledOnTouchOutside(true);
        cVar.show();
    }

    public void a() {
        int j = this.m.j();
        float k = ((float) this.m.k()) / 255.0f;
        if (this.p != null) {
            this.p.setText(ay.b((Context) this).toUpperCase());
            this.p.setTextColor(j);
            this.p.setAlpha(k);
        }
        if (this.q != null) {
            this.q.setText(ay.a((Context) this));
            this.q.setTextColor(j);
            this.q.setAlpha(k);
        }
        this.r = (TextView) findViewById(R.id.curr_temp_textview);
        this.s = (ImageView) findViewById(R.id.weather_icon);
        this.s.setAlpha(k);
        this.r.setAlpha(k);
        String F = this.m.F("");
        if (!TextUtils.isEmpty(F)) {
            int L = this.m.L(0);
            if (L == 0) {
                L = com.vlocker.weather.e.j.a(0, 0, this);
                this.m.M(L);
            }
            this.r.setText(com.vlocker.weather.e.j.a(F, false));
            Drawable a = j != -1 ? g.a(new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L)), com.vlocker.c.a.a(com.vlocker.theme.f.e.a).j()) : new BitmapDrawable(BitmapFactory.decodeResource(getResources(), L));
            this.r.setTextColor(j);
            this.s.setBackgroundDrawable(a);
            this.r.setVisibility(0);
            this.s.setVisibility(0);
        }
    }

    public void a(View view, float f, int i) {
        this.l = i;
        this.g.setTextColor(i);
    }

    public void a(View view, int i) {
        b(i);
    }

    public void afterTextChanged(Editable editable) {
        if (this.g.getPaint().measureText(editable.toString()) > this.v) {
            this.g.removeTextChangedListener(this);
            editable.delete(b(editable.toString()), editable.length());
            this.g.setText(editable);
            this.g.setSelection(editable.length());
            this.g.addTextChangedListener(this);
        }
    }

    public final void b() {
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(new r(this));
    }

    public void b(View view, float f, int i) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() - this.x < 5000) {
            p.a((Context) this, "Vlocker_DIYUnlock_GiveUpEdit_PPC_RR", new String[0]);
            super.onBackPressed();
            return;
        }
        az.a(getString(R.string.unlock_edit_close_toast));
        this.x = System.currentTimeMillis();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.root_view:
                if (this.w) {
                    this.g.clearFocus();
                    this.u.toggleSoftInput(1, 2);
                    return;
                }
                return;
            case R.id.btn_sure:
                String obj = this.g.getText().toString();
                String str = "";
                if (TextUtils.isEmpty(obj)) {
                    az.a(getString(R.string.unlock_edit_empty_toast));
                    return;
                }
                if (this.k == 0) {
                    this.m.R("");
                    str = "defaultFont";
                } else if (this.k > 0) {
                    this.m.R(((b) this.j.get(this.k)).a().getFontIdNo());
                    str = ((b) this.j.get(this.k)).a().getFontName();
                }
                this.m.aj(this.l);
                this.m.Q(obj);
                this.m.aU(true);
                sendBroadcast(new Intent("action_reset_unlock"));
                p.a((Context) this, "Vlocker_DIYUnlock_FinishEdit_PPC_RR", "font", str, "content", obj);
                finish();
                return;
            case R.id.btn_edit:
                this.g.requestFocus();
                this.u.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_theme_unlock_edit);
        this.m = com.vlocker.c.a.a((Context) this);
        this.u = (InputMethodManager) getSystemService("input_method");
        FontCenter.getInstance().onUse();
        c();
        i();
        if (LockerService.a() != null) {
            LockerService.a().a(19, 100);
        }
        this.o = new v();
        registerReceiver(this.o, new IntentFilter("action_finish_unlock_edit_activity"));
        if (!this.m.dr()) {
            this.m.aW(true);
        }
        this.v = (float) (getResources().getDisplayMetrics().widthPixels - l.a(120.0f));
        p.a((Context) this, "Vlocker_DIYUnlock_BeginEdit_PPC_RR", new String[0]);
    }

    protected void onDestroy() {
        if (this.w) {
            this.u.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        }
        LockerService.a().b();
        super.onDestroy();
        unregisterReceiver(this.o);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
