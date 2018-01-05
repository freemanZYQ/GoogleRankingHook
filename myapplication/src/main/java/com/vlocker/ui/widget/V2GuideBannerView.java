package com.vlocker.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v4.view.do;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.location.LocationClientOption;
import com.moxiu.b.a.a;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.BuildConfig;
import com.vlocker.locker.R;
import com.vlocker.m.a.b;
import com.vlocker.m.aj;
import com.vlocker.m.h;
import com.vlocker.m.o;
import com.vlocker.msg.an;
import com.vlocker.msg.ao;
import com.vlocker.msg.as;
import com.vlocker.new_theme.activity.SpecialSingleItemActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.OneKeySettingActivity;
import com.vlocker.setting.SettingService;
import com.vlocker.settings.NotificationSettingActivity;
import com.vlocker.settings.QuestionActivity;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.f.e;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.update.i;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class V2GuideBannerView extends RelativeLayout implements do {
    public static a c;
    private boolean A = false;
    private long B = 0;
    private AtomicBoolean C = new AtomicBoolean(false);
    private boolean D = false;
    boolean a = false;
    UpdateApkParamBean b;
    private ViewPager d;
    private V2IndicatorViewGroup e;
    private SettingsActivity f;
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private bd i;
    private LayoutInflater j;
    private az k;
    private String l;
    private com.vlocker.c.a m;
    private final int n = 1;
    private final int o = 2;
    private final int p = 3;
    private final int q = -1;
    private final int r = 1;
    private final int s = 2;
    private final int t = 3;
    private boolean u = false;
    private boolean v = false;
    private int w;
    private int x;
    private Handler y = new ao(this);
    private AtomicBoolean z = new AtomicBoolean(false);

    public V2GuideBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            this.f = (SettingsActivity) context;
            this.m = com.vlocker.c.a.a(this.f);
            e.d(this.f);
            if (h.c() == null) {
                String str = "cn";
            }
            this.l = "json.php?do=Vlocker.Main&app=vlocker" + j.n(MoSecurityApplication.a().getApplicationContext());
            i();
        }
    }

    private bc a(ba baVar) {
        if (baVar == null || TextUtils.isEmpty(baVar.d)) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_net, null);
        ImageView imageView = (ImageView) v2BannerPage.findViewById(R.id.tuiguang);
        if (baVar.a().equals("apps") || baVar.a().equals("ade")) {
            imageView.setVisibility(0);
        }
        v2BannerPage.setTag(baVar.b());
        v2BannerPage.setOnClickListener(new as(this, baVar));
        bc bcVar = new bc(this);
        bcVar.b = baVar;
        bcVar.a = v2BannerPage;
        return bcVar;
    }

    private void a(String str) {
        if (VERSION.SDK_INT >= 9) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", str, null));
            intent.setFlags(276824064);
            this.f.startActivity(intent);
            return;
        }
        String str2 = VERSION.SDK_INT == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
        intent2.putExtra(str2, str);
        this.f.startActivity(intent2);
    }

    private void h() {
        Collection arrayList = new ArrayList();
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            bc bcVar = (bc) it.next();
            if ("topic".equals(bcVar.b.d) || "url".equals(bcVar.b.d) || "index".equals(bcVar.b.d) || "app".equals(bcVar.b.d) || "update".equals(bcVar.b.d) || "site".equals(bcVar.b.d) || "ade".equals(bcVar.b.d) || "apps".equals(bcVar.b.d)) {
                arrayList.add(bcVar);
            }
        }
        this.g.removeAll(arrayList);
    }

    private void i() {
        this.j = LayoutInflater.from(this.f);
        this.j.inflate(R.layout.l_v2_guide_banner_layout, this, true);
        this.d = (ViewPager) findViewById(R.id.banner_viewpager);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("m");
            declaredField.setAccessible(true);
            declaredField.set(this.d, new bb(this, this.f, new DecelerateInterpolator(4.0f)));
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e2) {
        } catch (IllegalAccessException e3) {
        }
        this.e = (V2IndicatorViewGroup) findViewById(R.id.banner_indicator);
        this.i = new bd(this);
        this.d.setOnPageChangeListener(this);
    }

    private bc j() {
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_main_page, null);
        bc bcVar = new bc(this, v2BannerPage, new ba(true, "type_main"));
        v2BannerPage.findViewById(R.id.l_v2_banner_main_click_tv).setOnClickListener(new at(this));
        return bcVar;
    }

    private bc k() {
        if (!SettingService.a(this.f) || this.m.y()) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setDescription((int) R.string.v2_banner_fix_lock_des);
        v2BannerPage.setBtnText((int) R.string.v2_banner_fix_lock);
        bc bcVar = new bc(this, v2BannerPage, new ba(true, "type_fix_lock"));
        OnClickListener auVar = new au(this);
        v2BannerPage.setOnClickListener(auVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(auVar);
        return bcVar;
    }

    private bc l() {
        if (this.m.aR()) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setDescription((int) R.string.v2_banner_close_sys_lock_des);
        v2BannerPage.setBtnText((int) R.string.v2_banner_close_sys_lock);
        OnClickListener avVar = new av(this);
        v2BannerPage.setOnClickListener(avVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(avVar);
        return new bc(this, v2BannerPage, new ba(true, "type_close_sys_lock"));
    }

    private bc m() {
        if (!MoSecurityApplication.b) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setDescription((int) R.string.v2_banner_move_app_des);
        v2BannerPage.setBtnText((int) R.string.v2_banner_move_app);
        bc bcVar = new bc(this, v2BannerPage, new ba(true, "type_move_app"));
        OnClickListener awVar = new aw(this);
        v2BannerPage.setOnClickListener(awVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(awVar);
        return bcVar;
    }

    private void n() {
        a(BuildConfig.APPLICATION_ID);
    }

    private bc o() {
        if ((!this.m.Q() && !this.m.S()) || this.m.v()) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setDescription((int) R.string.v2_banner_pwd_qes_des);
        v2BannerPage.setBtnText((int) R.string.v2_banner_pwd_qes);
        OnClickListener axVar = new ax(this);
        v2BannerPage.setOnClickListener(axVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(axVar);
        return new bc(this, v2BannerPage, new ba(true, "type_pwd"));
    }

    private bc p() {
        if (!an.a(this.f) || an.b(this.f)) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setCenterImg(R.drawable.l_v2_banner_msg);
        v2BannerPage.setDescription((int) R.string.v2_banner_exp_msg_des);
        v2BannerPage.setBtnText((int) R.string.v2_banner_exp_msg);
        OnClickListener ayVar = new ay(this);
        v2BannerPage.setOnClickListener(ayVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(ayVar);
        return new bc(this, v2BannerPage, new ba(true, "type_msg"));
    }

    private bc q() {
        if (i.b(this.f).getInt("update_service_ver", 0) <= o.b(this.f)) {
            return null;
        }
        V2BannerPage v2BannerPage = (V2BannerPage) this.j.inflate(R.layout.l_v2_guide_banner_local_layout, null);
        v2BannerPage.setCenterImg(R.drawable.l_v2_banner_update);
        v2BannerPage.setDescription(String.format(getResources().getString(R.string.v2_banner_new_ver_des), new Object[]{r1.getString("version_name", r1.getInt("update_service_ver", 0) + "")}));
        v2BannerPage.setBtnText((int) R.string.v2_banner_new_ver);
        OnClickListener apVar = new ap(this);
        v2BannerPage.setOnClickListener(apVar);
        v2BannerPage.findViewById(R.id.banner_local_click_btn).setOnClickListener(apVar);
        return new bc(this, v2BannerPage, new ba(true, "type_new_version"));
    }

    private void r() {
        p.a(getContext(), "Vlocker_Click_Update_PPC_TF", "status", "banner");
        this.f.a();
    }

    private void s() {
        p.a(getContext(), "Vlocker_Click_Rescue_Locker_B_PPC_TF", new String[0]);
        Intent intent = new Intent(this.f, OneKeySettingActivity.class);
        intent.putExtra("from", "from_SettingsActivity");
        this.f.startActivityForResult(intent, 1);
    }

    private void setJumpActivityByTag(ba baVar) {
        if (baVar != null && !baVar.a) {
            String str = baVar.d;
            String str2 = "";
            if (baVar.c() != null) {
                baVar.c();
            }
            if (str.equals("topic")) {
            }
            if (baVar.e() != null) {
                p.a(getContext(), "Vlocker_Click_ServiceAd_Banner_PPC_TF", "Topic", baVar.e());
            }
            Intent intent;
            if (str.equals("topic")) {
                if (com.vlocker.b.o.noNetStatus == j.b(getContext().getApplicationContext())) {
                    Toast.makeText(getContext(), getContext().getString(R.string.vlocker_setting_update_app_nonetdip), 2000).show();
                    return;
                }
                intent = new Intent(getContext(), SpecialSingleItemActivity.class);
                try {
                    int parseInt;
                    Bundle bundle = new Bundle();
                    bundle.putString("from", "banner");
                    bundle.putString("dataurl", baVar.h);
                    try {
                        parseInt = Integer.parseInt(baVar.f);
                    } catch (Exception e) {
                        parseInt = ((int) (Math.random() * 1000.0d)) + LocationClientOption.MIN_SCAN_SPAN;
                    }
                    bundle.putInt("position", parseInt);
                    bundle.putString("title", baVar.g);
                    intent.putExtras(bundle);
                    this.f.startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (str.equals("url")) {
                str = baVar.h;
                try {
                    str2 = "com.taobao.taobao";
                    if (!"taobao".equals(baVar.h())) {
                        r0 = as.a(this.f, str);
                        r0.setFlags(268435456);
                        this.f.startActivity(r0);
                    } else if (!j.a(this.f, "com.taobao.taobao") || aj.b(this.f, "com.taobao.taobao") < 123) {
                        as.a(this.f, baVar.f(), baVar.e(), baVar.d());
                    } else {
                        ao.a(this.f, str, "banner");
                    }
                } catch (Exception e3) {
                }
            } else if (str.equals("index")) {
                if (aj.a("com.moxiu.launcher")) {
                    r0 = new Intent();
                    r0.setClassName("com.moxiu.launcher", "com.moxiu.launcher.manager.activity.MainActivity");
                    r0.setFlags(268435456);
                    try {
                        this.f.startActivity(r0);
                        return;
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        return;
                    }
                }
                new com.vlocker.e.e(this.f).a();
            } else if ("app".equals(str)) {
                if ("com.moxiu.launcher".equals(baVar.d())) {
                    if (com.vlocker.b.o.noNetStatus == j.b(getContext().getApplicationContext())) {
                        Toast.makeText(getContext(), getContext().getString(R.string.vlocker_setting_update_app_nonetdip), 2000).show();
                        return;
                    } else {
                        new com.vlocker.e.e(this.f).a("banner");
                        return;
                    }
                }
                try {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(baVar.h));
                    intent.setFlags(268435456);
                    this.f.startActivity(intent);
                } catch (Exception e4) {
                }
            } else if ("update".equals(str)) {
                r();
            } else if ("site".equals(str)) {
                str = "com.taobao.taobao";
                if ("taobao".equals(baVar.h()) && j.a(this.f, "com.taobao.taobao") && aj.b(this.f, "com.taobao.taobao") >= 123) {
                    ao.a(this.f, baVar.f(), "banner");
                } else {
                    as.a(this.f, baVar.f(), baVar.e(), baVar.d());
                }
            } else if ("ade".equals(str)) {
                if (j.g(this.f)) {
                    try {
                        str = baVar.f();
                        if (c != null) {
                            com.vlocker.b.a.a(this.f, c, this, "", null, false, null);
                            if (!this.D) {
                                p.b(getContext(), c.m(), c.n(), p.a(this.w));
                                this.D = true;
                                return;
                            }
                            return;
                        }
                        getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        return;
                    } catch (Exception e5) {
                        try {
                            getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://util.moxiu.net/misc/?do=App.Channel.Soft.List&channel=digest")));
                            return;
                        } catch (Exception e6) {
                            return;
                        }
                    }
                }
                Toast.makeText(getContext(), getContext().getString(R.string.M_bd_net_set), 1).show();
            } else if ("apps".equals(str)) {
                try {
                    ArrayList g = baVar.g();
                    if (g != null && g.size() > 0) {
                        this.b = (UpdateApkParamBean) g.get(0);
                        str = this.b.h();
                        this.b.h();
                        p.c(getContext(), p.a("app", this.b.l(), ""), "AA_SELFRUN", p.a(this.x));
                        try {
                            File file = new File(com.vlocker.b.i.g + this.b.h() + ".apk");
                            if (aj.a(str)) {
                                PackageManager packageManager = getContext().getPackageManager();
                                Intent intent2 = new Intent();
                                getContext().startActivity(packageManager.getLaunchIntentForPackage(str));
                            } else if (file.exists()) {
                                com.vlocker.update.a.a(this.f, file);
                            } else {
                                new com.vlocker.e.e(this.f).a(this.b);
                            }
                        } catch (Exception e7) {
                        }
                    }
                } catch (Exception e8) {
                    getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://util.moxiu.net/misc/?do=App.Channel.Soft.List&channel=digest")));
                }
            }
        }
    }

    private void t() {
        p.a(getContext(), "Vlocker_Click_LockSec_Banner_PPC_TF", new String[0]);
        this.f.startActivityForResult(new Intent(this.f, QuestionActivity.class), 2);
    }

    private void u() {
        p.a(getContext(), "Vlocker_Click_Practice_MsgNotify_PPC_TF", new String[0]);
        this.f.startActivityForResult(new Intent(this.f, NotificationSettingActivity.class), 3);
    }

    private void v() {
        try {
            if (this.y != null) {
                this.y.removeMessages(3);
                this.y.removeMessages(2);
                this.y.removeMessages(1);
                this.y = null;
            }
        } catch (Exception e) {
        }
    }

    private void w() {
        int i;
        bc m;
        int i2;
        int i3;
        String str;
        Boolean valueOf;
        Object obj = (!SettingService.a(this.f) || this.m.y() || MoSecurityApplication.a) ? null : 1;
        Object obj2 = !this.m.aR() ? 1 : null;
        Object obj3 = ((this.m.Q() || this.m.S()) && !this.m.v()) ? 1 : null;
        Object obj4 = (!an.a(this.f) || an.b(this.f)) ? null : 1;
        boolean z = MoSecurityApplication.b;
        int size = this.g.size();
        Collection arrayList = new ArrayList();
        int i4 = 0;
        Object obj5 = obj4;
        boolean z2 = z;
        Object obj6 = obj;
        Object obj7 = obj3;
        obj3 = null;
        Object obj8 = obj2;
        obj2 = null;
        while (i4 < size) {
            boolean z3;
            ba baVar = ((bc) this.g.get(i4)).b;
            String a = baVar.a();
            Object obj9;
            if ("type_fix_lock".equals(a)) {
                if (obj6 == null) {
                    arrayList.add(this.g.get(i4));
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                } else {
                    obj9 = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = null;
                    obj = obj9;
                }
            } else if ("type_close_sys_lock".equals(a)) {
                if (obj8 == null) {
                    arrayList.add(this.g.get(i4));
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                } else {
                    obj8 = obj6;
                    obj9 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = null;
                    obj = obj2;
                    obj2 = obj9;
                }
            } else if ("type_pwd".equals(a)) {
                if (obj7 == null) {
                    arrayList.add(this.g.get(i4));
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                } else {
                    obj7 = obj8;
                    obj8 = obj6;
                    boolean z4 = z2;
                    obj4 = obj5;
                    obj5 = null;
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z4;
                }
            } else if ("type_msg".equals(a)) {
                if (obj5 == null) {
                    arrayList.add(this.g.get(i4));
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                } else {
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = null;
                }
            } else if ("type_move_app".equals(a)) {
                if (z2) {
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                    obj9 = obj3;
                    z3 = false;
                    obj = obj2;
                    obj2 = obj9;
                } else {
                    arrayList.add(this.g.get(i4));
                    obj = obj2;
                    obj2 = obj3;
                    z3 = z2;
                    obj4 = obj5;
                    obj5 = obj7;
                    obj7 = obj8;
                    obj8 = obj6;
                }
            } else if ("type_main".equals(a)) {
                obj = 1;
                obj2 = obj3;
                z3 = z2;
                obj4 = obj5;
                obj5 = obj7;
                obj7 = obj8;
                obj8 = obj6;
            } else if ("ade".equals(a)) {
                if (!j.g(this.f)) {
                    arrayList.add(this.g.get(i4));
                }
                z3 = z2;
                obj4 = obj5;
                obj5 = obj7;
                obj7 = obj8;
                obj8 = obj6;
                obj = obj2;
                i = 1;
            } else {
                if ("app".equals(a) && aj.a(baVar.f)) {
                    arrayList.add(this.g.get(i4));
                }
                obj = obj2;
                obj2 = obj3;
                z3 = z2;
                obj4 = obj5;
                obj5 = obj7;
                obj7 = obj8;
                obj8 = obj6;
            }
            i4++;
            obj6 = obj8;
            obj8 = obj7;
            obj7 = obj5;
            obj5 = obj4;
            z2 = z3;
            obj3 = obj2;
            obj2 = obj;
        }
        Object obj10 = null;
        obj = null;
        if (arrayList.size() > 0) {
            obj10 = 1;
            this.g.removeAll(arrayList);
        }
        if (obj6 != null) {
            bc k = k();
            if (k != null) {
                obj = 1;
                this.g.add(k);
            }
        }
        if (obj8 != null) {
            bc l = l();
            if (l != null) {
                obj = 1;
                this.g.add(l);
            }
        }
        if (obj7 != null) {
            bc o = o();
            if (o != null) {
                obj = 1;
                this.g.add(o);
            }
        }
        if (obj5 != null) {
            bc p = p();
            if (p != null) {
                obj = 1;
                this.g.add(p);
            }
        }
        if (z2) {
            m = m();
            if (m != null) {
                obj = 1;
                this.g.add(m);
            }
        }
        if (obj2 == null && !this.u) {
            m = j();
            if (m != null) {
                obj2 = 1;
                this.g.add(m);
                if (obj3 == null && this.k != null && j.g(this.f)) {
                    obj3 = obj2;
                    for (i = 0; i < this.k.a().size(); i++) {
                        if ("ade".equals(((ba) this.k.a().get(i)).d)) {
                            this.g.add(a((ba) this.k.a().get(i)));
                            obj3 = 1;
                        }
                    }
                    obj2 = obj3;
                }
                if (!(obj2 == null && r8 == null && this.g.size() != 0)) {
                    this.h.clear();
                    this.e.a(false);
                    if (this.g.size() > 1) {
                        Collections.sort(this.g);
                    }
                    i = this.g.size();
                    for (i2 = 0; i2 < i; i2++) {
                        this.h.add(this.g.get(i2));
                    }
                    obj = null;
                    if (this.h.size() == 2) {
                        for (i3 = 0; i3 < 2; i3++) {
                            ba baVar2;
                            baVar2 = ((bc) this.h.get(i3)).b;
                            str = baVar2.d;
                            obj = null;
                            if (baVar2.a) {
                                obj = a(baVar2);
                            } else if ("type_fix_lock".equals(str)) {
                                obj = k();
                            } else if ("type_close_sys_lock".equals(str)) {
                                obj = l();
                            } else if ("type_pwd".equals(str)) {
                                obj = o();
                            } else if ("type_msg".equals(str)) {
                                obj = p();
                            } else if ("type_new_version".equals(str)) {
                                obj = q();
                            } else if ("type_main".equals(str)) {
                                obj = j();
                            }
                            if (obj != null) {
                                this.h.add(obj);
                            }
                        }
                        obj = 1;
                    }
                    i = this.h.size();
                    if (i > 1) {
                        i2 = obj == null ? 2 : i;
                        for (i = 0; i < i2; i++) {
                            this.e.a(i, new be(), true);
                        }
                    }
                    this.d.setAdapter(null);
                    this.d.setAdapter(this.i);
                    this.d.setCurrentItem(this.h.size() * LocationClientOption.MIN_SCAN_SPAN);
                }
                if (!(this.v || MoSecurityApplication.a)) {
                    this.v = true;
                    x();
                }
                valueOf = Boolean.valueOf(j.g(this.f));
                if (!"100C".equals(Build.MODEL) && this.v && valueOf.booleanValue() && SettingsActivity.b && !MoSecurityApplication.a) {
                    p.a(getContext(), "1011");
                    y();
                }
                if (this.h.size() <= 1) {
                    e();
                } else {
                    f();
                }
            }
        }
        obj2 = obj;
        obj3 = obj2;
        for (i = 0; i < this.k.a().size(); i++) {
            if ("ade".equals(((ba) this.k.a().get(i)).d)) {
                this.g.add(a((ba) this.k.a().get(i)));
                obj3 = 1;
            }
        }
        obj2 = obj3;
        this.h.clear();
        this.e.a(false);
        if (this.g.size() > 1) {
            Collections.sort(this.g);
        }
        i = this.g.size();
        for (i2 = 0; i2 < i; i2++) {
            this.h.add(this.g.get(i2));
        }
        obj = null;
        if (this.h.size() == 2) {
            for (i3 = 0; i3 < 2; i3++) {
                baVar2 = ((bc) this.h.get(i3)).b;
                str = baVar2.d;
                obj = null;
                if (baVar2.a) {
                    obj = a(baVar2);
                } else if ("type_fix_lock".equals(str)) {
                    obj = k();
                } else if ("type_close_sys_lock".equals(str)) {
                    obj = l();
                } else if ("type_pwd".equals(str)) {
                    obj = o();
                } else if ("type_msg".equals(str)) {
                    obj = p();
                } else if ("type_new_version".equals(str)) {
                    obj = q();
                } else if ("type_main".equals(str)) {
                    obj = j();
                }
                if (obj != null) {
                    this.h.add(obj);
                }
            }
            obj = 1;
        }
        i = this.h.size();
        if (i > 1) {
            if (obj == null) {
            }
            for (i = 0; i < i2; i++) {
                this.e.a(i, new be(), true);
            }
        }
        this.d.setAdapter(null);
        this.d.setAdapter(this.i);
        this.d.setCurrentItem(this.h.size() * LocationClientOption.MIN_SCAN_SPAN);
        this.v = true;
        x();
        valueOf = Boolean.valueOf(j.g(this.f));
        p.a(getContext(), "1011");
        y();
        if (this.h.size() <= 1) {
            f();
        } else {
            e();
        }
    }

    private void x() {
        new Thread(new aq(this)).start();
    }

    private void y() {
        c = null;
        new com.b.b.a(getContext()).a(com.b.d.a.b(getContext(), "setting_banner"), 5, new ar(this)).a();
    }

    protected void a() {
        this.m.N(true);
        p.a(getContext(), "Vlocker_Click_Disable_SystemLocker_B_PPC_TF", new String[0]);
        b.a(this.f).a(1);
    }

    public void a(int i) {
        try {
            int size = this.h.size();
            int i2 = i % size;
            size = i2 < 0 ? i2 + size : i2;
            if (this.h != null && this.h.size() >= size - 1) {
                bc bcVar = (bc) this.h.get(size);
                if (bcVar != null && bcVar.b.a().equals("ade")) {
                    this.w = size;
                    if (!(c == null || this.d == null)) {
                        c.b((View) this);
                        p.c(getContext(), c.m(), c.n(), p.a(size));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.z.get()) {
            this.B = SystemClock.elapsedRealtime();
            i2 = this.e.getSize();
            if (i2 != 0) {
                this.e.setActiveMarker(i % i2);
            }
        }
    }

    public void a(int i, float f, int i2) {
    }

    public void b() {
        if (SettingService.a(this.f) && (this.m.y() || com.vlocker.setting.a.a.getInstance().isEmpty())) {
            com.vlocker.setting.a.a.getInstance(this.f.getApplicationContext()).init();
        }
        w();
        d();
    }

    public void b(int i) {
        p.b("102000", "");
        if (i == 0) {
            this.z.set(false);
        } else if (1 == i) {
            this.z.set(true);
            this.y.removeMessages(2);
        } else if (2 == i) {
            this.z.set(false);
        }
    }

    public void c() {
        if (!SettingService.a(this.f)) {
            return;
        }
        if (this.m.y() || com.vlocker.setting.a.a.getInstance().isEmpty()) {
            com.vlocker.setting.a.a.getInstance(this.f.getApplicationContext()).init();
            this.y.sendEmptyMessageDelayed(3, 6000);
        }
    }

    public void d() {
        try {
            if (this.d != null) {
                int currentItem = this.d.getCurrentItem();
                int size = this.h.size();
                currentItem %= size;
                size = currentItem < 0 ? currentItem + size : currentItem;
                if (this.h != null && this.h.size() >= size - 1) {
                    bc bcVar = (bc) this.h.get(size);
                    if (bcVar != null && bcVar.b.a().equals("ade") && c != null && this.d != null) {
                        c.b(this.d);
                        p.c(getContext(), c.m(), c.n(), p.a(size));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            f();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.h != null && this.h.size() > 1) {
            e();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public synchronized void e() {
        if (!this.C.get()) {
            this.C.set(true);
            if (this.y != null) {
                this.y.sendEmptyMessageDelayed(2, 3000);
            }
        }
    }

    public synchronized void f() {
        if (this.y != null) {
            this.y.removeMessages(2);
        }
        this.C.set(false);
    }

    public void g() {
        c = null;
        this.D = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v();
    }
}
