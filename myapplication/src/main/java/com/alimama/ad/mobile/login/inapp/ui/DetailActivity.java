package com.alimama.ad.mobile.login.inapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alimama.ad.mobile.a.a;
import java.lang.reflect.Method;

public class DetailActivity extends Activity {
    private Object a;
    private Method b;
    private DetailWebView c;

    private void a() {
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        this.c = new DetailWebView(this);
        this.a = a.b("com.alibaba.sdk.android.ui.support.WebViewActivitySupport");
        this.c.setTaeSupport(this.a);
        linearLayout.addView(this.c, new LayoutParams(-1, -1));
        setContentView(linearLayout);
    }

    private void a(String str) {
        this.c.loadUrl(str);
    }

    public boolean a(int i, int i2, Intent intent, Activity activity) {
        Method a;
        if (this.b == null) {
            a = a.a(this.a, "onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class, Activity.class, a.a("com.alibaba.sdk.android.ui.support.OnActivityResultCallback")});
        } else {
            a = this.b;
        }
        this.b = a;
        return a.b(this.a, this.b, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, activity, null});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!a(i, i2, intent, this)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("url");
        a();
        a(stringExtra);
    }

    protected void onDestroy() {
        this.c.removeAllViews();
        this.c.destroy();
        super.onDestroy();
    }
}
