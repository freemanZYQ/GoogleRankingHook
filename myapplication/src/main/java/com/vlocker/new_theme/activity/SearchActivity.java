package com.vlocker.new_theme.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.new_theme.view.T_MyLinearLayout;
import com.vlocker.theme.f.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchActivity extends Activity {
    protected String a;
    protected boolean b;
    protected List c;
    protected String d;
    public boolean e;
    OnClickListener f = new p(this);
    private LinearLayout g;
    private T_MyLinearLayout h;
    private LinearLayout i;
    private TextView j;
    private EditText k;
    private List l = new ArrayList();
    private final OnClickListener m = new o(this);
    private q n;
    private String o;

    private void a(int i) {
        new Thread(new n(this, i)).start();
    }

    private void b() {
        this.i = (LinearLayout) this.g.findViewById(R.id.search_guess_layout);
        this.j = (TextView) this.g.findViewById(R.id.tv_search);
        this.k = (EditText) this.g.findViewById(R.id.auto_search);
        this.k.setText(this.o);
        this.k.setOnEditorActionListener(new l(this));
        this.j.setOnClickListener(this.m);
        findViewById(R.id.themetab_searchdetail_back).setOnClickListener(this.m);
        if (e.c((Context) this)) {
            a(0);
            return;
        }
        Message message = new Message();
        message.what = 280;
        this.n.sendMessage(message);
    }

    private void c() {
        if (this.k != null) {
            this.k.setFocusable(true);
            this.k.setFocusableInTouchMode(true);
            this.k.requestFocus();
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.k, 2);
        }
    }

    private void d() {
        if (this.k != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(this.k.getApplicationWindowToken(), 0);
            }
        }
    }

    private void e() {
        int i = 0;
        while (i < this.c.size()) {
            try {
                View linearLayout = new LinearLayout(this);
                linearLayout.setLayoutParams(new LayoutParams(-1, -2));
                linearLayout.setId(i);
                linearLayout.setTag(Integer.valueOf(i));
                View textView = new TextView(this);
                textView.setId(i);
                textView.setTag(Integer.valueOf(i));
                textView.setTextSize(2, 14.0f);
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
                int width = e.f(this).getWidth();
                if (width == 320) {
                    layoutParams.setMargins(10, 8, 10, 8);
                } else if (width == 480) {
                    layoutParams.setMargins(15, 9, 15, 9);
                } else if (width == 720) {
                    layoutParams.setMargins(25, 10, 25, 10);
                } else {
                    layoutParams.setMargins(25, 15, 25, 15);
                }
                textView.setLayoutParams(layoutParams);
                textView.setText((CharSequence) ((Map) this.c.get(i)).get("tagname"));
                textView.setTextColor(-1);
                try {
                    linearLayout.setBackgroundResource(R.drawable.theme_search_hot_selector);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                linearLayout.setGravity(16);
                textView.setGravity(16);
                this.l.add(textView);
                textView.setDuplicateParentStateEnabled(true);
                textView.setOnClickListener(this.f);
                linearLayout.setOnClickListener(this.f);
                linearLayout.addView(textView);
                this.h.addView(linearLayout);
                i++;
            } catch (Exception e22) {
                e22.printStackTrace();
                return;
            }
        }
    }

    private void f() {
        if ("mcm".equals(getIntent().getStringExtra("from"))) {
            startActivity(new Intent(this, ThemeMainActivity.class));
            overridePendingTransition(R.anim.l_activity_slide_left_in, R.anim.l_activity_slide_right_out);
        }
        finish();
    }

    public void a() {
        this.i = (LinearLayout) this.g.findViewById(R.id.search_guess_layout);
        this.i.setVisibility(0);
        if (this.c != null && this.c.size() > 0) {
            e();
        }
        this.n.postDelayed(new m(this), 300);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.a((Context) this, "Vlocker_Click_Search_Theme_PPC_TF", new String[0]);
        this.n = new q(this, this);
        setContentView(R.layout.t_market_main_home_search_keytaglayout);
        this.g = (LinearLayout) findViewById(R.id.main_search_layout);
        this.h = (T_MyLinearLayout) findViewById(R.id.main_searchkeytag_listview_linearlayout);
        b();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        f();
        return true;
    }

    protected void onPause() {
        super.onPause();
        d();
    }
}
