package com.vlocker.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.b.j;
import com.vlocker.m.a;
import com.vlocker.m.h;
import com.vlocker.msg.ao;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.g;
import com.xinmei365.fontsdk.FontCenter;

@SuppressLint({"InlinedApi"})
public class DismissActivity extends Activity implements a {
    private WindowManager a;
    private LinearLayout b;
    private final int c = 67108864;
    private BroadcastReceiver d = new y(this);

    public static void a(Context context) {
        try {
            Intent intent = new Intent(context, DismissActivity.class);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(boolean z) {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    private void b() {
        try {
            if (com.vlocker.c.a.a((Context) this).aj() != 0) {
                this.a = (WindowManager) getApplication().getSystemService("window");
                this.b = new LinearLayout(this);
                this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, h.d(this)));
                this.a.addView(this.b, c());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context) {
        Intent intent = new Intent("com.vlocker.action_hidedismissact");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    private LayoutParams c() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.systemUiVisibility = 1;
        layoutParams.type = 2010;
        layoutParams.gravity = 48;
        layoutParams.format = 1;
        layoutParams.flags = 263944;
        layoutParams.width = -1;
        layoutParams.height = h.d(this);
        return layoutParams;
    }

    private void d() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        if (j.a((WindowManager) getSystemService("window"))) {
            attributes.flags = ((206045184 | attributes.flags) | 4194304) | 524288;
        } else {
            attributes.flags |= 4718592;
        }
        window.setAttributes(attributes);
        if (com.vlocker.c.a.a((Context) this).ai() != 0) {
            getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        }
        if (VERSION.SDK_INT >= 19) {
            a(true);
        }
        if (b.e()) {
            getWindow().getDecorView().setSystemUiVisibility(2);
        }
        window.getDecorView().setOnTouchListener(new x(this));
    }

    public void a() {
        try {
            new SpassFingerprint(this).registerFinger(this, new z(this));
        } catch (Exception e) {
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a((Activity) this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ao.a((a) this);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(null);
        }
        d();
        b();
        FontCenter.getInstance().onUse();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.vlocker.action_hidedismissact");
        intentFilter.addAction("com.vlocker.action_sharetheme");
        registerReceiver(this.d, intentFilter);
        if (!g.a) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.d);
        } catch (Exception e) {
        }
        try {
            if (this.b != null) {
                this.a.removeView(this.b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
