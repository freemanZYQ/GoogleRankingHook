package com.vlocker.msg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.c.a;
import com.vlocker.locker.BuildConfig;
import com.vlocker.model.c;
import com.vlocker.model.e;
import com.vlocker.model.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class al {
    public ArrayList a = new ArrayList();
    public ArrayList b = new ArrayList();
    public ArrayList c = new ArrayList();
    ArrayList d = new ArrayList();
    public ArrayList e = new ArrayList();
    j f;
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private Context i;
    private a j;

    public al(Context context) {
        this.i = context;
        this.j = a.a(context);
        g();
        e();
        f();
        this.e = b(context);
        this.f = new j();
        a(context);
    }

    private void e() {
        this.c.clear();
        this.c.add("com.sohu.inputmethod.sogou");
        this.c.add("com.baidu.input");
        this.c.add("com.iflytek.inputmethod");
        this.c.add("com.iflytek.inputmethod.oem");
        this.c.add("com.tencent.qqpinyin");
        this.c.add("com.google.android.inputmethod.pinyin");
        this.c.add(BuildConfig.APPLICATION_ID);
    }

    private void f() {
        this.d.clear();
        this.d.add("com.tencent.mobileqq");
        this.d.add("com.tencent.qqlite");
        this.d.add(WXApp.WXAPP_PACKAGE_NAME);
        this.d.add("com.qzone");
        this.d.add("com.sina.weibo");
        this.d.add("com.immomo.momo");
        this.d.add("com.moxiu.launcher");
        this.d.add("com.tencent.androidqqmail");
        this.d.add("com.smile.gifmaker");
        this.d.add("com.baidu.tieba");
        this.d.add("com.jiuyan.infashion");
        this.d.add("com.tencent.qqmusic");
        this.d.add("com.kugou.android");
        this.d.add("cn.kuwo.player");
        this.d.add("com.qiyi.video");
        this.d.add("com.tencent.qqlive");
        this.d.add("com.sohu.sohuvideo");
        this.d.add("com.youku.phone");
        this.d.add("com.tudou.android");
        this.d.add("com.hunantv.imgo.activity");
        this.d.add("com.taobao.taobao");
        this.d.add("com.eg.android.AlipayGphone");
        this.d.add("com.sankuai.meituan");
        this.d.add("com.jingdong.app.mall");
        this.d.add("com.tencent.pao");
        this.d.add("com.happyelements.AndroidAnimal");
        this.d.add("com.happyelements.AndroidAnimal.qq");
        this.d.add("com.happyelements.AndroidAnimal.wdj");
        this.d.add("com.tencent.qt.qtl");
        this.d.add("com.supercell.clashofclans");
        this.d.add("com.shuqi.controller");
        this.d.add("com.baidu.homework");
        this.d.add("com.ss.android.article.news");
        this.d.add("com.tencent.news");
        this.d.add("com.tencent.android.qqdownloader");
        this.d.add("com.baidu.appsearch");
        this.d.add("com.tencent.news");
        this.d.add("com.snda.wifilocating");
        this.d.add("com.android.deskclock");
        this.d.add("com.droid27.transparentclockweather");
        this.d.add("net.qihoo.launcher.widget.clock");
        this.d.add("com.android.calendar");
        this.d.add("cn.etouch.ecalendar");
        this.d.add("com.when.coco");
        this.d.add("com.lenovo.calendar");
        this.d.add("com.easyandroid.music");
        this.d.add("com.vivo.game");
        this.d.add("com.xiaomi.gamecenter");
        this.d.add("com.nearme.gamecente");
        this.d.add("com.huawei.gamebox");
        this.d.add("com.sec.android.app.samsungapps");
        this.d.add("com.xiaomi.market");
        this.d.add("com.yulong.android.coolmart");
        this.d.add("com.oppo.market");
        this.d.add("com.taiwanmobile.match.marketapi");
        this.d.add("net.emome.hamiapps.am");
        this.d.add("com.aimi.appstore");
        ResolveInfo a = ap.a(this.i, "phone");
        if (a != null) {
            this.d.add(a.activityInfo.applicationInfo.packageName);
        }
        a = ap.a(this.i, "mms");
        if (a != null) {
            this.d.add(a.activityInfo.applicationInfo.packageName);
        }
    }

    private void g() {
        this.b.clear();
        this.b.add("联系人");
        this.b.add(" 魔秀桌面");
        this.b.add("相机");
        this.b.add("设置");
        this.b.add("音乐");
        this.b.add("计算器");
        this.b.add("视频");
        this.b.add("相册");
        this.b.add("录音机");
        this.b.add("文件管理");
        this.b.add("收音机");
        this.b.add("手电筒");
        this.b.add("便签");
        this.b.add("安全中心");
        this.b.add("搜索");
        this.b.add("记事本");
        this.b.add("一键锁屏");
        this.b.add("互联网");
        this.b.add("下载");
        this.b.add("i 管家");
        this.b.add("备份与恢复");
        this.b.add("备份和恢复");
        this.b.add("语音助手");
        this.b.add("文件管理器");
        this.b.add("指南针");
        this.b.add("下载内容");
        this.b.add("图库");
        this.b.add("浏览器");
    }

    public ArrayList a() {
        return this.a;
    }

    public void a(Context context) {
        this.a.clear();
        this.g.clear();
        this.h.clear();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            com.vlocker.model.a aVar = (com.vlocker.model.a) it.next();
            e eVar = new e();
            String a = aVar.a();
            String str = "";
            String[] split = a.split("\\/");
            String str2 = split.length > 1 ? split[0] : str;
            try {
                str = ((String) c.a(context).a(aVar.b().toString().replaceAll("\\s*", ""), true).get(0)).substring(0, 1);
            } catch (Exception e) {
                str = "#";
            }
            if (str.matches("^[A-Za-z]+$")) {
                eVar.a(str.toUpperCase());
                eVar.a(aVar);
            } else {
                eVar.a("#");
                eVar.a(aVar);
            }
            if (this.j.t(a)) {
                this.a.add(eVar);
            } else if (str2.isEmpty() || !this.d.contains(str2)) {
                this.h.add(eVar);
            } else {
                this.g.add(eVar);
            }
        }
        Collections.sort(this.g, this.f);
        Collections.sort(this.a, this.f);
        Collections.sort(this.h, this.f);
    }

    public ArrayList b() {
        return this.g;
    }

    public ArrayList b(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            try {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                com.vlocker.model.a aVar = new com.vlocker.model.a();
                aVar.a(resolveInfo.activityInfo.applicationInfo.packageName + "/" + resolveInfo.activityInfo.name);
                aVar.a(resolveInfo.loadLabel(packageManager).toString().trim());
                aVar.a(resolveInfo.loadIcon(packageManager));
                if (!(this.b.contains(aVar.b()) || this.c.contains(resolveInfo.activityInfo.applicationInfo.packageName))) {
                    arrayList.add(aVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList c() {
        return this.h;
    }

    public ArrayList d() {
        Collection arrayList = new ArrayList();
        Collection arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            String substring;
            e eVar = (e) it.next();
            String a = eVar.b().a();
            try {
                substring = ((String) c.a(this.i).a(eVar.b().b().toString().replaceAll("\\s*", ""), true).get(0)).substring(0, 1);
            } catch (Exception e) {
                substring = "#";
            }
            if (substring.matches("^[A-Za-z]+$")) {
                eVar.a(substring.toUpperCase());
            } else {
                eVar.a("#");
            }
            if (this.j.s(a)) {
                arrayList.add(eVar);
            } else {
                arrayList2.add(eVar);
            }
        }
        Collections.sort(arrayList, this.f);
        Collections.sort(arrayList2, this.f);
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        return arrayList3;
    }
}
