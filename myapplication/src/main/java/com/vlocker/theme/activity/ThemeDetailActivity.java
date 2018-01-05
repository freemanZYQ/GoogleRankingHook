package com.vlocker.theme.activity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.l;
import com.vlocker.m.o;
import com.vlocker.m.y;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.a.c;
import com.vlocker.theme.f.e;
import com.vlocker.theme.imageloader.r;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.a.b;
import com.vlocker.theme.model.a.d;
import com.vlocker.theme.model.i;
import com.vlocker.theme.view.T_OnlineDetailLayout;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.view.ImageScrollView;
import com.vlocker.ui.view.ao;
import com.vlocker.ui.view.q;
import com.vlocker.update.g;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class ThemeDetailActivity extends ThemeBaseActivity implements OnClickListener, i, q {
    private int A;
    private String B;
    private T_ThemeItemInfo C;
    private int D = 0;
    private OnClickListener E = new p(this);
    private a F = null;
    private boolean G = false;
    private ao H;
    private View I;
    private T_OnlineDetailLayout a;
    private c b;
    private com.vlocker.theme.a.a c;
    private ProgressBar d;
    private ImageScrollView e;
    private TextView f;
    private TextView g;
    private d h;
    private String i;
    private RatingBar j;
    private TextView k;
    private LinearLayout l;
    private CheckBox m;
    private CheckBox n;
    private ImageView o;
    private String p = null;
    private LinearLayout q;
    private int r;
    private int s;
    private String t = com.vlocker.b.i.j;
    private com.vlocker.theme.b.a u = new e(this);
    private ReceiveBroadCast v;
    private boolean w;
    private Handler x;
    private Handler y;
    private String z;

    public class ReceiveBroadCast extends BroadcastReceiver {
        final /* synthetic */ ThemeDetailActivity a;

        public ReceiveBroadCast(ThemeDetailActivity themeDetailActivity) {
            this.a = themeDetailActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.k();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r4) {
        /*
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r4);
        r0.<init>(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x000f:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x002d }
        if (r2 == 0) goto L_0x0039;
    L_0x0015:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002d }
        r3.<init>();	 Catch:{ IOException -> 0x002d }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x002d }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x002d }
        r2 = r2.toString();	 Catch:{ IOException -> 0x002d }
        r1.append(r2);	 Catch:{ IOException -> 0x002d }
        goto L_0x000f;
    L_0x002d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0047 }
        r4.close();	 Catch:{ IOException -> 0x0042 }
    L_0x0034:
        r0 = r1.toString();
        return r0;
    L_0x0039:
        r4.close();	 Catch:{ IOException -> 0x003d }
        goto L_0x0034;
    L_0x003d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0034;
    L_0x0042:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0034;
    L_0x0047:
        r0 = move-exception;
        r4.close();	 Catch:{ IOException -> 0x004c }
    L_0x004b:
        throw r0;
    L_0x004c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.theme.activity.ThemeDetailActivity.a(java.io.InputStream):java.lang.String");
    }

    private void a() {
        this.m.setOnCheckedChangeListener(new l(this));
        this.n.setOnCheckedChangeListener(new m(this));
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.t_detail_downloading_process).setOnClickListener(this);
    }

    private void a(File file) {
        this.C = new T_ThemeItemInfo();
        this.C.b(com.vlocker.theme.f.c.b(this, file.getPath(), 1));
        if (this.C != null) {
            k();
        }
    }

    private void a(String str) {
        if (this.c == null) {
            this.c = new com.vlocker.theme.a.a(this, str);
        }
        this.a.setOnClickListener(this.E);
        this.a.a(this.c, 1, this.A, this.C);
        this.c.notifyDataSetChanged();
    }

    private void a(String str, int i) {
        this.C = (T_ThemeItemInfo) com.vlocker.theme.c.a.b().a();
        if (this.C != null) {
            k();
        }
    }

    private void a(JSONObject jSONObject) {
        if (com.vlocker.msg.ao.a(jSONObject, "code", "").equals("200")) {
            this.C = e.a(jSONObject.getJSONObject("data").getJSONObject("theme"));
        }
    }

    private void a(boolean z) {
        p.a((Context) this, "Vlock_Bombboxshow_Onlywsp_PPC_CY", new String[0]);
        new com.vlocker.d.c(this, false, R.style.ShowDialog, "美化桌面需安装魔秀桌面，是否安装？", "否", "是", new f(this, z)).show();
    }

    private boolean a(String str, String str2) {
        return new File(e.c(str, str2, com.vlocker.b.i.i)).exists();
    }

    private void b() {
        this.C = new T_ThemeItemInfo();
        this.C.b("默认主题");
    }

    private void b(String str) {
        if (str != null && !str.isEmpty()) {
            Intent intent;
            Bundle bundle;
            c(true);
            String b = com.vlocker.theme.f.c.b(this, str, 2);
            ApplicationInfo l = com.vlocker.theme.f.c.l(this, str);
            int f = com.vlocker.theme.f.c.f(this, str);
            String g = com.vlocker.theme.f.c.g(this, str);
            String str2 = null;
            if (l != null) {
                str2 = l.packageName;
            }
            if (this.n.isChecked()) {
                intent = new Intent();
                bundle = new Bundle();
                bundle.putString("theme_package", str2);
                bundle.putString("current_theme_path", str);
                bundle.putBoolean("isLocker", false);
                intent.putExtras(bundle);
                intent.setAction("vlocker_change_theme_for_launcher");
                sendBroadcast(intent);
            }
            if (this.m.isChecked()) {
                intent = new Intent();
                bundle = new Bundle();
                bundle.putString("theme_package", str2);
                bundle.putString("current_theme_path", str);
                if (b != null) {
                    bundle.putInt("isLockerWidget", Integer.parseInt(b));
                }
                bundle.putString("local", "local");
                bundle.putInt("vlocker_color", f);
                bundle.putString("drawable_level", g);
                intent.putExtras(bundle);
                intent.setAction(LockerService.a);
                sendBroadcast(intent);
            }
        }
    }

    private void b(boolean z) {
        File file = new File(com.vlocker.b.i.g + "vlocker_launcher" + ".apk");
        if (file.exists()) {
            try {
                Object a = g.a(file);
                if (!TextUtils.isEmpty(a) && a.equals(com.vlocker.update.i.a((Context) this))) {
                    String str = "Vlocker_GetMoxiu_LauncherGuide_ThemeDetail_PPC_RR";
                    String[] strArr = new String[4];
                    strArr[0] = "from";
                    strArr[1] = z ? "viewPage" : "redPoint";
                    strArr[2] = "download";
                    strArr[3] = "done";
                    p.a((Context) this, str, strArr);
                    str = "Vlocker_GetMoxiu_LauncherGuide_Test_PPC_RR";
                    strArr = new String[4];
                    strArr[0] = "from";
                    strArr[1] = z ? "viewPage" : "redPoint";
                    strArr[2] = "download";
                    strArr[3] = "done";
                    p.a((Context) this, str, strArr);
                    if (z) {
                        p.a((Context) this, "Vlock_Bombbox_Yesclick_PPC_CY", "download", "done");
                    }
                    Uri fromFile = Uri.fromFile(file);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str2 = "Vlocker_GetMoxiu_LauncherGuide_ThemeDetail_PPC_RR";
        String[] strArr2 = new String[4];
        strArr2[0] = "from";
        strArr2[1] = z ? "viewPage" : "redPoint";
        strArr2[2] = "download";
        strArr2[3] = "not";
        p.a((Context) this, str2, strArr2);
        str2 = "Vlocker_GetMoxiu_LauncherGuide_Test_PPC_RR";
        strArr2 = new String[4];
        strArr2[0] = "from";
        strArr2[1] = z ? "viewPage" : "redPoint";
        strArr2[2] = "download";
        strArr2[3] = "not";
        p.a((Context) this, str2, strArr2);
        com.vlocker.e.e eVar = new com.vlocker.e.e(this);
        if (z) {
            p.a((Context) this, "Vlock_Bombbox_Yesclick_PPC_CY", "download", "not");
            eVar.a("detail_image");
            return;
        }
        eVar.a("detail_button");
    }

    private void c() {
        if (this.b != null) {
            this.b.a(this.C, true);
        } else {
            this.b = new c(this, this.C);
        }
        this.a.setOnClickListener(this.E);
        this.a.a(this.b, 1, this.A, this.C);
        this.b.notifyDataSetChanged();
    }

    private void c(boolean z) {
        try {
            if (this.H != null) {
                if (this.H.isShowing()) {
                    this.H.dismiss();
                }
                this.H = null;
            }
            this.H = new ao(this, R.style.aiVlockerFeedbackDialog);
            this.H.setCanceledOnTouchOutside(true);
            this.H.a(R.layout.l_theme_dialog, z);
            if (z) {
                this.H.a.setText(R.string.v3_theme_apply_loading);
                this.H.g.setImageResource(R.drawable.l_v3_theme_apply_loading);
                this.H.d.setVisibility(8);
                return;
            }
            this.H.a.setText(R.string.v3_theme_apply_fail);
            this.H.g.setImageResource(R.drawable.l_v3_theme_apply_fail);
            this.H.d.setVisibility(0);
            this.H.d.setText(R.string.v3_theme_open_moxiu);
            this.H.d.setOnClickListener(new h(this));
        } catch (Exception e) {
            if (this.H != null && this.H.isShowing()) {
                this.H.dismiss();
            }
        }
    }

    private void d() {
        if (this.z != null) {
            p.a((Context) this, "Vlocker_View_Theme_PPC_TF", "from", this.z, "moxiu", j.a((Context) this));
        }
    }

    private void e() {
        if (this.m.isChecked() && this.n.isChecked()) {
            p.a((Context) this, "Vlocker_Apply_Theme_PPC_TF", "apply", "all");
        } else if (this.m.isChecked()) {
            p.a((Context) this, "Vlocker_Apply_Theme_PPC_TF", "apply", "locker");
        } else if (this.n.isChecked()) {
            p.a((Context) this, "Vlocker_Apply_Theme_PPC_TF", "apply", "launcher");
        }
    }

    private void f() {
        if ("push".equals(this.z) || "mcm".equals(this.z)) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("tag", this.z);
        intent.putExtra("position", this.A);
        setResult(1, intent);
        finish();
    }

    private void g() {
        if (this.C != null && this.C.i() <= o.b(MoSecurityApplication.a())) {
            e();
            b(e.c(this.C.b(), this.C.a(), this.t));
        }
    }

    private void h() {
        if (this.C != null) {
            b a = b.a();
            d dVar = null;
            String a2 = this.C.a();
            if (!(a2 == null || a2.length() == 0)) {
                dVar = a.a(a2);
            }
            if (dVar != null) {
                if (dVar.f() == null) {
                    dVar.a(this.u);
                }
                dVar.b();
                return;
            }
            j();
        }
    }

    private void i() {
        if (this.C != null && this.h != null) {
            this.h.d();
            b.a().b(this.h);
            this.D = 0;
            this.d.setProgress(100);
        }
    }

    private void j() {
        long a = r.a(Environment.getDataDirectory());
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Toast.makeText(this, getString(R.string.t_market_download_sdcard), 0).show();
        } else if (!e.c((Context) this)) {
            e.a((Context) this, getString(R.string.l_check_network));
        } else if (this.C != null && a < ((long) this.C.c())) {
            e.a((Context) this, getString(R.string.t_market_no_space));
        } else if (Environment.getExternalStorageState().equals("mounted_ro")) {
            Toast.makeText(this, getString(R.string.l_sdcard_read_only), 0).show();
        } else {
            this.G = true;
            File file = new File(com.vlocker.b.i.j);
            if (!file.exists()) {
                file.mkdirs();
            }
            b a2 = b.a();
            d dVar = null;
            if (this.C != null) {
                String a3 = this.C.a();
                if (!(a3 == null || a3.length() == 0)) {
                    dVar = a2.a(a3);
                }
                if (dVar == null) {
                    dVar = new d(this, this.C, com.vlocker.b.i.j, this.u);
                    a2.a(dVar);
                    dVar.a();
                    return;
                }
                if (dVar.f() == null) {
                    dVar.a(this.u);
                }
                dVar.b();
            }
        }
    }

    private void k() {
        int i = 0;
        try {
            this.h = p();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String a;
        if (this.h != null) {
            switch (i.a[this.h.c().ordinal()]) {
                case 1:
                    if (new File(e.c(this.C.b(), this.C.a(), this.t)).exists()) {
                        this.D = 3;
                        m();
                        b a2 = b.a();
                        a = this.C.a();
                        if (a != null && a.length() != 0) {
                            a2.a(a);
                            return;
                        }
                        return;
                    }
                    l();
                    return;
                case 2:
                case 3:
                    this.D = 2;
                    int e2 = (int) this.h.e();
                    if (this.h.a <= 0) {
                        this.h.a = 2097152;
                    }
                    if (e2 != -1) {
                        i = (e2 * 100) / this.h.a;
                    }
                    this.d.setProgress(i);
                    o();
                    return;
                case 4:
                    this.D = 1;
                    try {
                        this.h.a((i) this);
                        n();
                        return;
                    } catch (Exception e3) {
                        return;
                    }
                case 5:
                    this.D = 3;
                    l();
                    return;
                default:
                    return;
            }
        } else if (this.C != null && !"locklocaltheme".equals(this.z)) {
            a = this.C.b();
            String a3 = this.C.a();
            if (a(a, a3)) {
                this.t = com.vlocker.b.i.i;
                this.D = 3;
                m();
                return;
            }
            String c = e.c(a, a3, this.t);
            a = e.b(a, a3, this.t);
            File file = new File(c);
            File file2 = new File(a);
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                this.D = 3;
                m();
            } else if (file2.exists()) {
                this.D = 0;
                file2.delete();
                l();
            } else {
                l();
            }
        }
    }

    private void l() {
        this.D = 0;
        this.d.setProgress(100);
        this.g.setText(getString(R.string.v2_dialog_download_btn_single));
    }

    private void m() {
        this.l.setVisibility(0);
        this.g.setText(getString(R.string.l_theme_cancle_apply));
        this.d.setProgress(100);
        if (this.G) {
            this.G = false;
        }
    }

    private void n() {
        this.D = 1;
        this.g.setText(getString(R.string.l_theme_cancle_download));
    }

    private void o() {
        this.D = 2;
        this.g.setText(getString(R.string.l_theme_cancle_continue));
    }

    private d p() {
        return b.a().a(this.C.a());
    }

    private void q() {
        this.F.e(true);
        this.F.d(false);
        this.F.E(true);
        this.F.h(1);
        this.F.D(false);
        this.F.aG(false);
        this.F.aH(false);
        this.F.X(-1);
        this.F.w(false);
        this.F.i(0);
        this.F.R("");
        this.F.aj(-1);
        this.F.Q("");
        this.F.aU(false);
        this.F.aV(false);
        this.F.e(0);
        this.F.b(-1);
        this.F.aj(-1);
        this.F.d(-1);
        this.F.c(255);
        this.F.f(false);
        a.a((Context) this).e(null);
        a.a((Context) this).d(null);
        if (this.n.isChecked()) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("theme_package", IXAdSystemUtils.NT_NONE);
            bundle.putString("current_theme_path", IXAdSystemUtils.NT_NONE);
            bundle.putBoolean("isLocker", false);
            intent.putExtras(bundle);
            intent.setAction("vlocker_change_theme_for_launcher");
            sendBroadcast(intent);
        }
        if (this.m.isChecked()) {
            if (!(y.a == null || "null".equals(y.a) || IXAdSystemUtils.NT_NONE.equals(y.a))) {
                p.a((Context) this, "Vlocker_DefaultThemeSum_PPC_TF", new String[0]);
            }
            LockerService.d((Context) this);
        }
    }

    private void r() {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            String str2 = resolveInfo.activityInfo.name;
            if (str.equals("com.moxiu.launcher")) {
                ComponentName componentName = new ComponentName(str, str2);
                intent = new Intent();
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                startActivity(intent);
            }
        }
    }

    public void a(long j, long j2, boolean z, T_ThemeItemInfo t_ThemeItemInfo) {
        if (t_ThemeItemInfo.a().equals(this.C.a()) && this.x != null) {
            Message obtainMessage = this.x.obtainMessage();
            obtainMessage.what = 1280;
            obtainMessage.arg1 = (int) j;
            this.x.sendMessage(obtainMessage);
        }
    }

    public void a(ImageScrollView imageScrollView, int i, int i2, int i3, int i4) {
        if (!j.a((Context) this, "com.moxiu.launcher")) {
            int[] iArr = new int[2];
            if (this.a.getChildCount() > 2) {
                this.I = this.a.getChildAt(2);
                this.I.getLocationInWindow(iArr);
                if (iArr[0] <= 0 || iArr[0] >= this.s || this.r >= this.s) {
                    this.r = iArr[0];
                } else {
                    this.r = iArr[0];
                }
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.t_detail_downloading_process:
                if (this.D == 0) {
                    p.a((Context) this, "Vlocker_Download_Theme_PPC_TF", "from", this.z, "moxiu", j.a((Context) this));
                    this.d.setProgress(0);
                    j();
                    k();
                    return;
                } else if (this.D == 1) {
                    Toast.makeText(e.a, getString(R.string.l_theme_download_cancle), 0).show();
                    i();
                    k();
                    return;
                } else if (this.D == 2) {
                    this.D = 1;
                    h();
                    n();
                    k();
                    return;
                } else if (this.D != 3) {
                    return;
                } else {
                    if (this.m.isChecked() || this.n.isChecked()) {
                        if (!this.m.isChecked() && this.n.isChecked()) {
                            new Handler().postDelayed(new g(this), 5000);
                        }
                        if (!"locklocaltheme".equals(this.z)) {
                            g();
                            return;
                        } else if ("default".equals(this.p)) {
                            q();
                            return;
                        } else {
                            b(this.p);
                            return;
                        }
                    }
                    return;
                }
            case R.id.back:
                f();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_theme_online_detail);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.s = displayMetrics.widthPixels;
        this.r = this.s;
        this.F = a.a((Context) this);
        Bundle extras = getIntent().getExtras();
        this.z = extras.getString("tag");
        this.i = extras.getString("tag_title");
        d();
        this.A = extras.getInt("position");
        this.B = extras.getString("url");
        Object string = extras.getString("from");
        if (!TextUtils.isEmpty(string) && string.equals("mcm")) {
            this.B = extras.getString("dataurl");
            this.z = extras.getString("from");
        } else if (TextUtils.isEmpty(this.z)) {
            Object string2 = extras.getString("dataurl");
            if (!TextUtils.isEmpty(string2)) {
                this.B = string2;
                this.z = "mcm";
            }
        }
        this.e = (ImageScrollView) findViewById(R.id.moxiu_detail_towimage_scrollview);
        this.e.setOnScrollChangedListener(this);
        this.d = (ProgressBar) findViewById(R.id.t_detail_downloading_process);
        this.d.setMax(100);
        this.d.setProgress(100);
        this.g = (TextView) findViewById(R.id.t_detail_click_download);
        this.f = (TextView) findViewById(R.id.l_theme_title);
        this.j = (RatingBar) findViewById(R.id.l_theme_ratingbar);
        this.k = (TextView) findViewById(R.id.l_theme_downloadcount);
        this.l = (LinearLayout) findViewById(R.id.t_detail_select_launcher);
        this.m = (CheckBox) findViewById(R.id.t_detail_click_apply_locker);
        this.n = (CheckBox) findViewById(R.id.t_detail_click_apply_launcher);
        this.o = (ImageView) findViewById(R.id.guide_launcher_hint);
        this.a = (T_OnlineDetailLayout) findViewById(R.id.online_detail_layout);
        this.q = (LinearLayout) findViewById(R.id.themes_detail_layout);
        a();
        this.x = new j(this);
        this.v = new ReceiveBroadCast(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("DOWNLOADTHREAD_DOWNLOAD_DONE");
        registerReceiver(this.v, intentFilter);
        if (!j.a((Context) this, "com.moxiu.launcher") && this.F.ci()) {
            this.F.aE(false);
            this.a.animate().translationX((float) (-l.a(78.0f))).setDuration(400).setInterpolator(new AccelerateDecelerateInterpolator()).setStartDelay(600).setListener(new k(this)).start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.v);
        } catch (Exception e) {
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if ("push".equals(this.z) || "mcm".equals(this.z)) {
            finish();
        } else {
            finish();
        }
        return true;
    }

    protected void onStart() {
        super.onStart();
        if (!j.a((Context) this, "com.moxiu.launcher") || aj.b(this, "com.moxiu.launcher") < 533 || MoSecurityApplication.a) {
            this.o.setVisibility(0);
            this.n.setChecked(false);
            return;
        }
        this.o.setVisibility(4);
        if (this.b != null) {
            this.b.notifyDataSetChanged();
        }
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (!this.w) {
                this.w = true;
                if ("locklocaltheme".equals(this.z)) {
                    this.p = getIntent().getExtras().getString("filePath");
                    if (this.p != null) {
                        if ("default".equals(this.p)) {
                            b();
                        } else {
                            File file = new File(this.p);
                            if (file.exists()) {
                                a(file);
                                this.c = new com.vlocker.theme.a.a(this, this.p);
                            } else {
                                finish();
                            }
                        }
                        if (this.C != null) {
                            this.D = 3;
                            a(this.p);
                            m();
                        }
                    } else {
                        finish();
                    }
                } else if (!"push".equals(this.z) && !"mcm".equals(this.z)) {
                    a(this.z, this.A);
                    if (this.C != null) {
                        c();
                    }
                } else if (e.c((Context) this)) {
                    this.q.setVisibility(8);
                    this.y = new n(this);
                    new Thread(new o(this)).start();
                } else {
                    Toast.makeText(this, R.string.t_market_vlocker_give_net_dip, 0).show();
                    f();
                    return;
                }
            }
            if (this.C != null && !MoSecurityApplication.a) {
                this.f.setText(this.C.b());
                if ("locklocaltheme".equals(this.z)) {
                    this.j.setVisibility(4);
                    this.k.setVisibility(4);
                    return;
                }
                this.j.setRating((float) (this.C.d() + 1));
                this.k.setText("下载量：" + this.C.e());
            }
        }
    }
}
