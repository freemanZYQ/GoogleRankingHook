package com.vlocker.search;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import com.vlocker.m.l;
import com.vlocker.m.x;
import com.vlocker.settings.DismissActivity;
import com.vlocker.theme.model.d;
import com.vlocker.ui.cover.LockerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class BaiduSearchActivity extends Activity {
    private Handler A = new e(this);
    private n B;
    public EditText a;
    public ao b;
    public boolean c = false;
    public ListView d;
    public ListView e;
    public String f;
    public String g = "";
    public boolean h = true;
    public int i;
    public a j;
    com.vlocker.c.a k;
    OnScrollListener l = new k(this);
    public ArrayList m = new ArrayList();
    private ImageView n;
    private ImageView o;
    private ac p;
    private d q;
    private at r;
    private ah s;
    private View t;
    private LinearLayout u;
    private int v = 0;
    private int w = -1;
    private int x;
    private HomeWatcherReceiver y;
    private boolean z = true;

    public class HomeWatcherReceiver extends BroadcastReceiver {
        final /* synthetic */ BaiduSearchActivity a;

        public HomeWatcherReceiver(BaiduSearchActivity baiduSearchActivity) {
            this.a = baiduSearchActivity;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                if ("homekey".equals(intent.getStringExtra("reason"))) {
                    x.a((byte) 2);
                    this.a.finish();
                }
            } else if (action.equals("action_close_activity")) {
                this.a.finish();
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                ap.a(this.a, this.a.getCurrentFocus());
            }
        }
    }

    private d a(String str, List list, List list2) {
        this.m.clear();
        d dVar = new d();
        if (list2 != null) {
            try {
                if (list2.size() > 0) {
                    ac acVar = new ac();
                    acVar.a(list2);
                    acVar.a("baidu");
                    dVar.add(acVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dVar;
    }

    private void a(View view, int i) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        Throwable th;
        File file = new File(ap.c(this), "vague" + i);
        if (file != null) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                    if (decodeStream != null) {
                        view.setBackgroundDrawable(new BitmapDrawable(getResources(), decodeStream));
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream = null;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
    }

    private String b(String str) {
        return "InnerBarSearch".equals(str) ? "inner_bar_search" : "ButtonSearch".equals(str) ? "word_search" : "HintSearch".equals(str) ? "word_recommend" : "HistorySearch".equals(str) ? "history" : ("NoTyping".equals(str) || "HotwordSearch".equals(str)) ? "hot" : "word_search";
    }

    private void b(String str, String str2) {
        this.A.removeMessages(0);
        if (str2 == null || str2.length() == 0) {
            this.A.sendEmptyMessageDelayed(0, 300);
        } else {
            new com.vlocker.new_theme.a.d().a(str, new ag(), new l(this, str2));
        }
    }

    private void c() {
        boolean z = true;
        if (!ap.b()) {
            String str = Build.MANUFACTURER;
            int i = VERSION.SDK_INT;
            if (i < 11) {
                return;
            }
            View view;
            if ("HUAWEI".equalsIgnoreCase(str)) {
                view = this.t;
                if (i > 23) {
                    z = false;
                }
                view.setFitsSystemWindows(z);
                return;
            }
            view = this.t;
            if (i > 23) {
                z = false;
            }
            view.setFitsSystemWindows(z);
        }
    }

    private void d() {
        try {
            String d = ap.d(this);
            if (d == null || d.length() <= 0) {
                this.f = "default";
                p.a((Context) this, "Vlock_Enter_Search_PPC_TF", "search_engine", this.f, "location", a());
            } else if (d.equals("sogou") || d.equals("shenma") || d.equals("littleboy") || d.equals("fatboy") || d.equals("baidu")) {
                this.f = d;
                p.a((Context) this, "Vlock_Enter_Search_PPC_TF", "search_engine", this.f, "location", a());
            } else {
                this.f = "default";
                p.a((Context) this, "Vlock_Enter_Search_PPC_TF", "search_engine", this.f, "location", a());
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f = "default";
        }
    }

    private void e() {
        this.a = (EditText) j.a(this.t, (int) R.id.switch_baidusb_et);
        this.a.requestFocus();
        if (!(this.j == null || TextUtils.isEmpty(this.j.c()))) {
            this.a.setHint(b());
        }
        this.n = (ImageView) j.a(this.t, (int) R.id.switch_baidusb_button);
        this.o = (ImageView) j.a(this.t, (int) R.id.switch_delet_button);
        this.d = (ListView) j.a(this.t, (int) R.id.cards_list);
        this.e = (ListView) j.a(this.t, (int) R.id.hitviewdip);
        this.n.setOnClickListener(new f(this));
        this.o.setOnClickListener(new g(this));
        this.a.setOnKeyListener(new h(this));
        this.a.addTextChangedListener(new i(this));
        this.e.setOnScrollListener(new j(this));
        this.d.setDescendantFocusability(393216);
        this.d.setTag("BaiduSearchActivity");
        this.x = ap.b((Context) this);
        this.d.setOnScrollListener(this.l);
    }

    public String a() {
        return !TextUtils.isEmpty(this.g) ? "search_box".equals(this.g) ? "weather" : this.g : "error";
    }

    public void a(Context context, String str) {
        M_bd_BaiduHintsInfo m_bd_BaiduHintsInfo = new M_bd_BaiduHintsInfo();
        m_bd_BaiduHintsInfo.a(ap.a(str));
        this.b.a(m_bd_BaiduHintsInfo);
    }

    public void a(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    boolean g = ap.g(this);
                    String d = ap.d(this);
                    String e = ap.e(this);
                    if (!g) {
                        try {
                            this.q = a(str, null, null);
                            if (this.s == null) {
                                this.s = new ah(this, this.q);
                                this.e.setAdapter(this.s);
                            } else {
                                this.s.a(this.q);
                            }
                            this.e.setVisibility(0);
                            this.d.setVisibility(8);
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } else if (d == null || d.length() <= 0 || e == null || e.length() <= 16) {
                        a("http://m.baidu.com/su?from=1001706a&ie=utf-8&action=opensearch&wd=" + str, str);
                        return;
                    } else {
                        a(e + str, str);
                        return;
                    }
                }
            } catch (Exception e22) {
                e22.printStackTrace();
                return;
            }
        }
        this.e.setVisibility(8);
        this.d.setVisibility(0);
    }

    protected void a(String str, String str2) {
        b(str, str2);
    }

    public void a(String str, String str2, String str3) {
        try {
            if (str != "" && str.length() > 0) {
                String b = ap.b(str);
                if (!TextUtils.isEmpty(b)) {
                    this.b.a(b);
                    a((Context) this, b);
                }
                if (ap.g(this)) {
                    String encode;
                    try {
                        encode = URLEncoder.encode(b, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        encode = "";
                    }
                    if (encode != null) {
                        if (encode.length() > 0) {
                            b = ap.h(this);
                            if (b.equals("") || b.length() < 8) {
                                b = "https://m.baidu.com/s?from=1001706a&word=";
                            }
                            try {
                                ap.a(this, b + encode, "", "search", ap.e);
                                ap.a(this, encode, str2, str3, "search_bar", "user");
                                p.a((Context) this, "Vlock_Done_Search_PPC_TF", "word", str, "search_engine", str2, "from", b(str3), "location", a());
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                    }
                    if (this.a != null) {
                        this.A.postDelayed(new m(this), 20);
                        return;
                    }
                    return;
                }
                Toast.makeText(this, getString(R.string.M_bd_net_set), 0).show();
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }

    public Spanned b() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.j == null || this.j.c() == null || this.j.c().length() <= 0) {
            return Html.fromHtml("<span><span>");
        }
        stringBuilder.append(this.j.c()).append("<span>");
        return Html.fromHtml(stringBuilder.toString());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a((Activity) this);
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.k = com.vlocker.c.a.a((Context) this);
        x.a((byte) 0);
        this.z = true;
        this.y = new HomeWatcherReceiver(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("action_close_activity");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.y, intentFilter);
        this.j = x.a((Context) this).c;
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.g = extras.getString("comefrom");
                this.i = extras.getInt("index", 0);
            }
            d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.t = j.b((Context) this, (int) R.layout.m_bd_card_layout);
        com.vlocker.c.a a = com.vlocker.c.a.a((Context) this);
        if (("pull_down".equals(this.g) || "pull_down_guide".equals(this.g)) && a.cI() < 2) {
            this.t.findViewById(R.id.search_from_main_tip).setVisibility(0);
            a.ac(a.cI() + 1);
        }
        requestWindowFeature(1);
        if (!ap.b()) {
            String str = Build.MANUFACTURER;
            int i = VERSION.SDK_INT;
            if (i >= 11) {
                View view;
                if ("HUAWEI".equalsIgnoreCase(str)) {
                    view = this.t;
                    if (i > 23) {
                        z = false;
                    }
                    view.setFitsSystemWindows(z);
                } else {
                    view = this.t;
                    if (i > 20) {
                        z = false;
                    }
                    view.setFitsSystemWindows(z);
                }
            }
        }
        setContentView(this.t);
        LayoutParams layoutParams = (LayoutParams) this.t.findViewById(R.id.search_et_layout).getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = h.d(this) + l.a(this, 5.0f);
        }
        a(this.t, this.i);
        try {
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.b = ao.a((Context) this);
            e();
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        if (LockerService.a() != null) {
            LockerService.a().a(18, 100);
        }
    }

    protected void onDestroy() {
        try {
            this.z = false;
            if (this.y != null) {
                unregisterReceiver(this.y);
            }
            if (this.r != null) {
                this.r.c();
                this.r = null;
            }
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(8);
                this.d.setVisibility(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.a((byte) 0);
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        try {
            x.a((byte) 1);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        try {
            if (!this.c || this.r == null) {
                if (this.r == null) {
                    this.r = new at(this);
                    this.d.setAdapter(this.r);
                } else {
                    this.r.a();
                }
                if (this.a != null) {
                    this.a.requestFocus();
                }
                DismissActivity.b(this);
                super.onResume();
            }
            this.c = false;
            this.r.a();
            if (this.a != null) {
                this.a.requestFocus();
            }
            DismissActivity.b(this);
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
