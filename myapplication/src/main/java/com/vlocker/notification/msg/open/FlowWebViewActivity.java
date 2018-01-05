package com.vlocker.notification.msg.open;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.moxiu.b.a.a;
import com.moxiu.b.d.c;
import com.vlocker.b.p;
import com.vlocker.locker.BuildConfig;
import com.vlocker.locker.R;
import com.vlocker.m.bb;
import com.vlocker.search.ap;
import com.vlocker.search.x;
import com.vlocker.share.ShareActivity;
import com.vlocker.share.ShareUtil;
import com.vlocker.theme.f.e;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.view.ObservableWebView;
import com.vlocker.ui.view.al;
import java.util.List;

public class FlowWebViewActivity extends Activity implements OnClickListener, al {
    private ObservableWebView a;
    private String b;
    private TextView c;
    private String d;
    private String e;
    private String f;
    private ProgressBar g;
    private RelativeLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private FrameLayout k;
    private ImageView l;
    private Intent m;
    private boolean n;
    private boolean o;
    private boolean p;
    private a q;
    private WebChromeClient r = new b(this);
    private DownloadListener s = new c(this);
    private Handler t = new Handler();
    private boolean u = false;
    private ActivityManager v = null;
    private Runnable w = new e(this);
    private WatcherReceiver x;

    public class WatcherReceiver extends BroadcastReceiver {
        final /* synthetic */ FlowWebViewActivity a;

        public WatcherReceiver(FlowWebViewActivity flowWebViewActivity) {
            this.a = flowWebViewActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("action_close_activity")) {
                this.a.finish();
            }
        }
    }

    private void a(Intent intent) {
        if (intent != null && "weather_webview".equals(this.e)) {
            Object stringExtra = intent.getStringExtra("channel");
            Object stringExtra2 = intent.getStringExtra("channel_category");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                this.n = true;
                com.vlocker.n.a.a().postDelayed(new f(this, stringExtra, stringExtra2), 3000);
            }
        }
    }

    private void a(View view) {
        if (this.q != null) {
            String h = ap.h(this);
            if (h.equals("") || h.length() < 8) {
                h = "https://m.baidu.com/s?from=1001706a&word=";
            }
            CharSequence d = ap.d(this);
            if (TextUtils.isEmpty(d)) {
                d = "default";
            }
            p.a((Context) this, "Vlock_Done_Search_PPC_TF", "word", this.q.c(), "search_engine", d, "from", "webviewhot");
            x.a((Context) this).a(view, (a) view.getTag());
            findViewById(R.id.web_search_hot).setVisibility(8);
        }
    }

    private void a(String str) {
        try {
            if (XAdErrorCode.ERROR_CODE_MESSAGE.equals(str)) {
                this.k.setBackgroundColor(getResources().getColor(R.color.flow_web_title_juhe));
            } else if ("weather".equals(str)) {
                this.k.setBackgroundColor(getResources().getColor(R.color.flow_web_title_taobao_tianqi));
            } else if ("icon".equals(str)) {
                this.k.setBackgroundColor(getResources().getColor(R.color.flow_web_title_taobao_tianqi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e() {
        this.v = (ActivityManager) getSystemService("activity");
        g();
        if ("weather_webview".equals(this.e)) {
            setContentView(R.layout.if_weather_webview);
        } else if ("red_packet".equals(this.e) || "normal_question".equals(this.e) || "meizu_syslock".equals(this.e) || "private".equals(this.e)) {
            setContentView(R.layout.if_flow_webview);
        } else {
            setContentView(R.layout.if_bd_webview);
            if ("weather".equals(this.e) || "search_ad".equals(this.e) || "search_site".equals(this.e)) {
                findViewById(R.id.btn_webview_back).setVisibility(8);
                findViewById(R.id.btn_webview_share).setVisibility(8);
            } else if ("search_weather".equals(this.e) || "search".equals(this.e)) {
                findViewById(R.id.btn_webview_back).setVisibility(8);
                findViewById(R.id.btn_webview_share).setVisibility(8);
                findViewById(R.id.web_search_hot).setVisibility(0);
                TextView textView = (TextView) findViewById(R.id.tx_webview_hot);
                this.q = x.a((Context) this).a("from_search");
                if (this.q != null) {
                    textView.setText(this.q.c());
                    textView.setTag(this.q);
                    this.q.b((View) textView);
                } else {
                    textView.setVisibility(8);
                }
                findViewById(R.id.tx_webview_hot).setOnClickListener(this);
            } else {
                findViewById(R.id.btn_webview_back).setVisibility(0);
                findViewById(R.id.btn_webview_share).setVisibility(0);
                findViewById(R.id.btn_webview_back).setOnClickListener(this);
                findViewById(R.id.btn_webview_share).setOnClickListener(this);
            }
            if ("weather_dianshang".equals(this.e) || "weather_flow".equals(this.e) || "search".equals(this.e) || "netService_weather".equals(this.e)) {
                findViewById(R.id.btn_webview_share).setVisibility(8);
            }
        }
        this.i = (LinearLayout) findViewById(R.id.root_layout);
        this.j = (LinearLayout) findViewById(R.id.web_layout);
        this.a = (ObservableWebView) findViewById(R.id.webview);
        this.a.setLayerType(2, null);
        if ("weather".equals(this.e) || "weather_webview".equals(this.e)) {
            this.c = (TextView) findViewById(R.id.moxiu_text_title);
            this.h = (RelativeLayout) findViewById(R.id.moxiu_title_back);
        } else {
            this.c = (TextView) findViewById(R.id.moxiu_text_title);
            this.h = (RelativeLayout) findViewById(R.id.moxiu_title_back);
        }
        if (this.h != null) {
            this.l = (ImageView) findViewById(R.id.back_image);
            if ("weather_webview".equals(this.e)) {
                this.l.setOnClickListener(this);
            } else if (this.h != null) {
                this.h.setOnClickListener(this);
            }
        }
        this.k = (FrameLayout) findViewById(R.id.web_title);
        overridePendingTransition(R.anim.fade_in_fast, R.anim.fade_out_fast);
        f();
        if ("weather_webview".equals(this.e) || "weather".equals(this.e)) {
            b();
        }
    }

    private void f() {
        try {
            if (!("".equals(this.e) || this.e == null)) {
                a(this.e);
            }
            this.g = (ProgressBar) findViewById(R.id.loading_process);
            if (this.c != null) {
                this.c.setText(this.d);
            }
            this.a.setWebViewClient(new g());
            this.a.requestFocusFromTouch();
            WebSettings settings = this.a.getSettings();
            settings.setCacheMode(2);
            if ("weather_webview".equals(this.e) || "red_packet".equals(this.e) || "normal_question".equals(this.e) || "private".equals(this.e)) {
                settings.setUseWideViewPort(false);
            } else {
                settings.setUseWideViewPort(true);
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            }
            settings.setUserAgentString(c.l(this));
            settings.setPluginState(PluginState.ON);
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setLoadWithOverviewMode(true);
            settings.setGeolocationEnabled(true);
            settings.setDomStorageEnabled(!"meizu_syslock".equals(this.e));
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setSaveFormData(true);
            settings.setSavePassword(true);
            this.a.requestFocus();
            this.a.setScrollBarStyle(0);
            if ("游戏".equals(this.d)) {
                this.a.setScrollBarStyle(33554432);
            }
            this.a.setDownloadListener(this.s);
            this.a.setWebChromeClient(this.r);
            this.a.setOnScrollChangedCallback(this);
            a();
            this.a.addJavascriptInterface(ShareUtil.getInstance(), "ShareUtil");
            this.a.loadUrl(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        Intent intent = getIntent();
        this.m = intent;
        if (intent != null) {
            this.b = intent.getStringExtra("url");
            this.d = intent.getStringExtra("title");
            this.e = intent.getStringExtra("tag");
            if ("search_weather".equals(this.e)) {
                this.f = intent.getStringExtra("hotkey");
            }
        }
    }

    private void h() {
        LockerService.a().b();
    }

    public void a() {
        if (VERSION.SDK_INT >= 19) {
            this.a.getSettings().setLoadsImagesAutomatically(true);
        } else {
            this.a.getSettings().setLoadsImagesAutomatically(false);
        }
        if ("weather_webview".equals(this.e) && VERSION.SDK_INT >= 11) {
            this.l.setAlpha(0.0f);
            this.c.setAlpha(0.0f);
        }
    }

    public void a(int i, int i2) {
        if (!"weather_webview".equals(this.e) && !"red_packet".equals(this.e) && !"normal_question".equals(this.e) && !"meizu_syslock".equals(this.e) && !"private".equals(this.e)) {
            if (i2 >= 0) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
        }
    }

    public void b() {
        new Thread(new d(this)).start();
    }

    public boolean c() {
        return !bb.a(this) || bb.b(this).contains(BuildConfig.APPLICATION_ID);
    }

    public boolean d() {
        if (VERSION.SDK_INT >= 20 && bb.a(this)) {
            return c();
        }
        try {
            List runningTasks = this.v.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0 && ((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName().equals(FlowWebViewActivity.class.getName())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_webview_back:
                finish();
                return;
            case R.id.btn_webview_share:
                Intent intent = new Intent(this, ShareActivity.class);
                intent.putExtra("url", this.b);
                intent.putExtra("title", this.d);
                intent.putExtra("from", "webview");
                intent.addFlags(268435456);
                startActivity(intent);
                return;
            case R.id.tx_webview_hot:
                a(view);
                return;
            case R.id.moxiu_title_back:
            case R.id.back_image:
                if ("weather_webview".equals(this.e) || "weather".equals(this.e)) {
                    h();
                    this.u = true;
                }
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = new WatcherReceiver(this);
        registerReceiver(this.x, new IntentFilter("action_close_activity"));
        if (!e.c((Context) this)) {
            Toast.makeText(this, R.string.vlocker_setting_update_app_nonetdip, 1).show();
        }
        e();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.x != null) {
            unregisterReceiver(this.x);
        }
        if (this.a != null) {
            try {
                this.a.removeAllViews();
                this.i.removeView(this.a);
                this.a.setVisibility(8);
                this.a.post(new a(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            System.gc();
            if (this.a.canGoBack()) {
                this.a.goBack();
                return true;
            } else if ("weather_webview".equals(this.e) || "weather".equals(this.e)) {
                h();
                this.u = true;
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.b != null && intent != null) {
            String stringExtra = intent.getStringExtra("url");
            if (stringExtra != null && !this.b.equals(stringExtra)) {
                this.b = stringExtra;
                this.d = intent.getStringExtra("title");
                this.e = intent.getStringExtra("tag");
                f();
            }
        }
    }

    protected void onPause() {
        super.onPause();
        try {
            this.n = false;
            this.a.pauseTimers();
            this.a.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
        this.n = true;
        this.o = false;
        this.p = false;
        try {
            this.a.resumeTimers();
            this.a.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(this.m);
    }
}
