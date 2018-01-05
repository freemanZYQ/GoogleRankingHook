package com.baidu.mobads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.g.d;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.j;
import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.vo.a.c;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppActivity extends Activity {
    protected static final int ACTIONBAR_VIEW_ID = 1001;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    private static int G = 39;
    private static ActionBarColorTheme J = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private static final String o = AppActivity.class.getSimpleName();
    private static AtomicBoolean p = new AtomicBoolean(false);
    private c A;
    private XAdLandingPageExtraInfo B;
    private View C;
    private final IXAdLogger D = m.a().f();
    private IXAdCommonUtils E;
    private boolean F = true;
    private PageFinishedListener H;
    private boolean I = true;
    float a = 1.0f;
    public Handler actionBarHandler;
    float b = 1.0f;
    com.baidu.mobads.g.a c = null;
    public ac curWebview;
    RelativeLayout d;
    int e = 0;
    int f = 0;
    int g = -1;
    int h = 0;
    int i = 0;
    int j = 1;
    String k = "barC";
    String l = "";
    View m = null;
    protected d mBottomView;
    protected boolean mBottomViewIsShowing = false;
    HandlerThread n = new HandlerThread("handler_thread");
    private Handler q = null;
    private int r = 0;
    private long s = 0;
    private String t;
    private boolean u = false;
    private int v = 1;
    private int w = 0;
    private int x = -1;
    private boolean y = false;
    private boolean z = false;

    public class ActionBarColorTheme {
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        private int a;
        private int b;
        private int c;
        private int d;

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.a = actionBarColorTheme.a;
            this.b = actionBarColorTheme.b;
            this.c = actionBarColorTheme.c;
            this.d = actionBarColorTheme.d;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.d == actionBarColorTheme.d && this.b == actionBarColorTheme.b && this.a == actionBarColorTheme.a && this.c == actionBarColorTheme.c;
        }

        public int getBackgroundColor() {
            return this.d;
        }

        public int getCloseColor() {
            return this.a;
        }

        public int getProgressColor() {
            return this.c;
        }

        public int getTitleColor() {
            return this.b;
        }

        public void setBackgroundColor(int i) {
            this.d = i;
        }

        public void setCloseColor(int i) {
            this.a = i;
        }

        public void setProgressColor(int i) {
            this.c = i;
        }

        public void setTitleColor(int i) {
            this.b = i;
        }
    }

    public interface PageFinishedListener {
        void onPageFinished(WebView webView);
    }

    class a extends View {
        final /* synthetic */ AppActivity a;
        private Paint b = new Paint();
        private int c = 0;
        private int d = 0;

        public a(AppActivity appActivity, Context context) {
            this.a = appActivity;
            super(context);
            this.b.setColor(AppActivity.J.getProgressColor());
            this.d = appActivity.E.getScreenRect(appActivity.getApplicationContext()).width();
        }

        public void a(int i) {
            if (i != this.c) {
                this.c = i;
                postInvalidate();
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(0.0f, 0.0f, (float) ((this.d * this.c) / 100), (float) getLayoutParams().height, this.b);
        }
    }

    class b {
        boolean a = false;
        String b = "";
        boolean c = false;
        boolean d = true;
        final /* synthetic */ AppActivity e;

        b(AppActivity appActivity) {
            this.e = appActivity;
        }
    }

    @TargetApi(3)
    private RelativeLayout a(String str) {
        View aVar = new a(this, this);
        this.curWebview = new ac(this, true, true);
        b bVar = new b(this);
        this.curWebview.a = str;
        this.curWebview.getSettings().setUseWideViewPort(true);
        this.curWebview.getSettings().setBuiltInZoomControls(true);
        try {
            WebSettings.class.getMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE}).invoke(this.curWebview.getSettings(), new Object[]{Boolean.valueOf(false)});
        } catch (Exception e) {
            this.D.d(o, e.getMessage());
        }
        this.curWebview.setWebChromeClient(new d(this, aVar));
        this.curWebview.setOnTouchListener(new i(this));
        this.curWebview.setWebViewClient(new j(this, bVar));
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.m = d();
        relativeLayout.addView(this.m);
        relativeLayout.addView(this.curWebview, new LayoutParams(-1, -1));
        relativeLayout.addView(aVar, new LayoutParams(-1, this.E.getPixel(getApplicationContext(), 2)));
        return relativeLayout;
    }

    @TargetApi(12)
    private void a(View view) {
        try {
            view.animate().setDuration(700);
            view.setTranslationX((float) view.getWidth());
            view.animate().setDuration(700).translationX(0.0f);
        } catch (Throwable e) {
            this.D.e(e);
        }
    }

    private void a(WebView webView, String str, Runnable runnable, Runnable runnable2) {
        try {
            com.baidu.mobads.j.d m = m.a().m();
            if (this.F ? ac.a(str) : ac.b(str)) {
                Intent intent;
                if (ac.i(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "audio/*");
                    webView.getContext().startActivity(intent);
                } else if (ac.h(str)) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(str), "video/*");
                    webView.getContext().startActivity(intent);
                } else {
                    m.browserOutside(webView.getContext(), str);
                }
                if (runnable != null) {
                    runnable.run();
                }
            } else if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Exception e) {
            this.D.d(o, e.getMessage());
        }
    }

    private void a(WebView webView, String str, boolean z, String str2) {
        if (webView != null) {
            com.baidu.mobads.j.d m = m.a().m();
            if (this.z) {
                this.f++;
                this.A.r.decrementAndGet();
                this.z = false;
            }
            if (z && str2.equals("ignore")) {
                try {
                    this.curWebview.loadUrl(str);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            try {
                Map hashMap = new HashMap();
                if (str2.equals("ignore")) {
                    hashMap.put("Referer", "http://mobads.baidu.com/" + m.getAppPackage(this));
                } else {
                    hashMap.put("Referer", str2);
                }
                this.curWebview.getClass().getMethod("loadUrl", new Class[]{String.class, Map.class}).invoke(this.curWebview, new Object[]{str, hashMap});
            } catch (Exception e2) {
                try {
                    this.curWebview.loadUrl(str);
                } catch (Exception e3) {
                    this.D.d(o, e2.getMessage());
                }
            }
        }
    }

    private void b(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable e) {
                this.D.e(e);
            }
        }
    }

    private void b(String str) {
        this.d = new RelativeLayout(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, m.a().m().getPixel(this, 46));
        layoutParams.addRule(10);
        this.c.setId(1001);
        this.d.addView(this.c, layoutParams);
        View a = a(str);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.addRule(3, 1001);
        this.d.addView(a, layoutParams2);
        if (this.u && canSupportAnimate()) {
            this.d.getViewTreeObserver().addOnPreDrawListener(new p(this));
        }
    }

    private View d() {
        View aeVar = new ae(this);
        int pixel = m.a().m().getPixel(this, 38);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, pixel);
        layoutParams.addRule(13);
        aeVar.setLayoutParams(layoutParams);
        return aeVar;
    }

    private void e() {
        f();
        initBottomView();
        this.d.addView(this.C);
        this.d.addView(this.mBottomView);
        if (canSupportAnimate()) {
            this.mBottomView.getViewTreeObserver().addOnPreDrawListener(new r(this));
        }
    }

    @TargetApi(11)
    private void f() {
        this.C = new View(this);
        this.C.setOnClickListener(new s(this));
        if (canSupportAnimate()) {
            this.C.setBackgroundColor(-16777216);
            this.C.setAlpha(0.0f);
        }
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    private void g() {
        if (this.curWebview != null) {
            this.curWebview.reload();
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return J;
    }

    @TargetApi(16)
    private void h() {
        if (canSupportAnimate()) {
            try {
                View view = this.d;
                if (this.u) {
                    view.setTranslationX(0.0f);
                    ViewPropertyAnimator translationX = view.animate().setDuration(300).translationX((float) view.getWidth());
                    if (VERSION.SDK_INT >= 16) {
                        translationX.withEndAction(new f(this));
                        return;
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new g(this), 300);
                        return;
                    }
                }
                finish();
                return;
            } catch (Throwable e) {
                this.D.e(e);
                return;
            }
        }
        finish();
    }

    private void i() {
        if (this.m != null) {
            b(this.m);
            this.m = null;
        }
    }

    public static boolean isAppActivityOpening() {
        return p.get();
    }

    private int j() {
        try {
            Method method = Context.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(this, new Object[0])).intValue();
        } catch (Throwable e) {
            j.a().e(e);
            return -1;
        }
    }

    private boolean k() {
        try {
            return 16973840 == j();
        } catch (Throwable e) {
            j.a().e(e);
            return false;
        }
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            J = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    protected boolean canSupportAnimate() {
        try {
            return VERSION.SDK_INT >= 12;
        } catch (Throwable e) {
            j.a().e(e);
            return false;
        }
    }

    @TargetApi(11)
    protected void copyCurrentPageUrl() {
        if (VERSION.SDK_INT < 11) {
            Toast.makeText(this, "系统版本不支持", 0).show();
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.curWebview.getUrl())) {
                ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("网页链接", this.curWebview.getUrl()));
                Toast.makeText(this, "已复制到剪切板", 0).show();
            }
        } catch (Throwable e) {
            this.D.e(e);
        }
    }

    protected void initActionBar() {
        this.c = new com.baidu.mobads.g.a(this, J);
        this.c.setId(1001);
        this.c.a(new q(this));
    }

    @TargetApi(11)
    protected void initBottomView() {
        this.mBottomView = new d(this);
        this.mBottomView.a(new t(this));
        if (canSupportAnimate()) {
            this.mBottomView.setAlpha(0.0f);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.mBottomView.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.set(true);
        this.u = k();
        this.E = m.a().m();
        Intent intent = getIntent();
        String stringExtra;
        if (intent.getBooleanExtra("dealWithDownload", false)) {
            try {
                int intExtra = intent.getIntExtra("status", -1);
                String stringExtra2 = intent.getStringExtra(IXAdRequestInfo.PACKAGE);
                IOAdDownloader adsApkDownloader = com.baidu.mobads.openad.c.d.a(getApplicationContext()).getAdsApkDownloader(stringExtra2);
                this.D.d(o, "dealWithDownload now: status=" + intExtra + ";pk=" + stringExtra2 + ";downloader=" + adsApkDownloader);
                if (intExtra == DownloadStatus.COMPLETED.getCode()) {
                    stringExtra = intent.getStringExtra("localApkPath");
                    if (m.a().l().isInstalled(this, stringExtra2)) {
                        m.a().l().openApp(this, stringExtra2);
                    } else {
                        File file = new File(stringExtra);
                        if (!file.exists() || file.length() <= 0) {
                            this.D.i(o, "文件[" + stringExtra + "] 已经被删除");
                        } else {
                            startActivity(m.a().l().getInstallIntent(stringExtra));
                        }
                    }
                } else if (intExtra == DownloadStatus.ERROR.getCode() || intExtra == DownloadStatus.PAUSED.getCode()) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0) {
                        com.baidu.mobads.openad.c.b a = com.baidu.mobads.openad.c.b.a(stringExtra2);
                        if (a != null) {
                            com.baidu.mobads.command.a a2 = a.a();
                            if (a2 != null) {
                                a2.r = true;
                            }
                        }
                    }
                    if (adsApkDownloader != null) {
                        adsApkDownloader.resume();
                    }
                }
            } catch (Throwable e) {
                this.D.d(o, e);
            }
            finish();
            return;
        }
        this.F = intent.getBooleanExtra("canOpenAppForAPO", this.F);
        com.baidu.mobads.j.d m = m.a().m();
        this.B = (XAdLandingPageExtraInfo) getIntent().getParcelableExtra(EXTRA_DATA);
        this.A = new c(this.B);
        Rect windowRect = m.getWindowRect(this);
        this.b = (float) ((((double) windowRect.width()) * 1.0d) / 640.0d);
        this.a = (float) ((((double) windowRect.height()) * 1.0d) / 960.0d);
        requestWindowFeature(1);
        this.t = this.B.title;
        if (this.B.orientation == 1) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        this.s = System.currentTimeMillis();
        try {
            if (this.B.isFullScreen) {
                getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
            }
        } catch (Exception e2) {
            this.D.d(o, "exception when getIntent");
        }
        this.e = this.B.from;
        stringExtra = this.B.url;
        if (ac.a(stringExtra)) {
            this.D.d(o, "AppActivity.browser external");
            Intent intent2;
            if (ac.i(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "audio/*");
                startActivity(intent2);
            } else if (ac.h(stringExtra)) {
                intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(stringExtra), "video/*");
                startActivity(intent2);
            } else {
                m.browserOutside(this, stringExtra);
            }
            finish();
            return;
        }
        this.q = startUrlHandler(this);
        initActionBar();
        b(stringExtra);
        a(this.curWebview, stringExtra, false, "http://mobads.baidu.com/" + m.getAppPackage(this));
        this.d.setBackgroundColor(-1);
        setContentView(this.d);
    }

    public void onDestroy() {
        int i = 0;
        super.onDestroy();
        p.set(false);
        if (this.q != null) {
            this.A.n = this.k;
            c cVar = this.A;
            int i2 = this.r;
            this.r = i2 + 1;
            cVar.o = i2;
            this.A.p = this.curWebview != null ? this.curWebview.getContentHeight() : 0;
            cVar = this.A;
            if (this.curWebview != null) {
                i = this.curWebview.getProgress();
            }
            cVar.q = i;
            this.A.s = this.f;
            this.A.t = this.g;
            this.A.u = System.currentTimeMillis() - this.s;
            this.A.v = this.v;
            this.A.w = this.w;
            this.A.x = this.e;
            this.A.y = this.j;
            Message obtain = Message.obtain();
            obtain.what = G;
            obtain.obj = this.A;
            this.q.sendMessage(obtain);
            try {
                this.curWebview.setVisibility(8);
                this.D.d(o, "onDestroy");
                this.curWebview.stopLoading();
                this.curWebview.destroy();
            } catch (Exception e) {
                this.D.d(o, e.getMessage());
            }
        }
        i();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.mBottomViewIsShowing) {
                    runBottomViewExitAnimation(this.C, this.mBottomView);
                } else if (this.curWebview.canGoBack()) {
                    this.curWebview.goBack();
                } else {
                    this.k = "backC";
                    h();
                }
                c cVar = this.A;
                cVar.G++;
                return true;
            } catch (Exception e) {
                this.D.d(o, e.getMessage());
            }
        } else {
            if (i == 46) {
                this.curWebview.reload();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.I) {
            this.I = false;
            return;
        }
        c cVar = this.A;
        cVar.H++;
    }

    @TargetApi(12)
    protected void runBottomViewEnterAnimation(View view, View view2) {
        this.mBottomViewIsShowing = true;
        try {
            view.animate().setDuration(500).alpha(0.5f);
            view2.setTranslationY((float) view2.getHeight());
            view2.animate().setDuration(500).alpha(1.0f).translationY(0.0f);
        } catch (Throwable e) {
            this.D.e(e);
        }
    }

    @TargetApi(16)
    protected void runBottomViewExitAnimation(View view, View view2) {
        this.mBottomViewIsShowing = false;
        if (canSupportAnimate()) {
            try {
                view.clearAnimation();
                view.animate().setDuration(250).alpha(0.0f);
                view2.setTranslationY(0.0f);
                ViewPropertyAnimator translationY = view2.animate().setDuration(250).alpha(0.0f).translationY((float) view2.getHeight());
                if (VERSION.SDK_INT >= 16) {
                    translationY.withEndAction(new u(this, view2, view));
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new e(this, view2, view), 250);
                    return;
                }
            } catch (Throwable e) {
                this.D.e(e);
                return;
            }
        }
        b(view2);
        b(view);
    }

    public void setPageFinishedListener(PageFinishedListener pageFinishedListener) {
        this.H = pageFinishedListener;
    }

    public Handler startUrlHandler(Context context) {
        this.n.start();
        return new h(this, this.n.getLooper());
    }
}
