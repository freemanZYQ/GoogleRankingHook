package com.vlocker.m;

import android.content.Context;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.vlocker.c.a;
import com.vlocker.locker.BuildConfig;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.settings.CitySelectActivity;
import com.vlocker.settings.QuestionActivity;
import com.vlocker.weather.Weather2Activity;

public class x {
    private static byte a = (byte) 0;

    public static byte a() {
        return a;
    }

    public static void a(byte b) {
        a = b;
    }

    public static String[] a(int i, Context context) {
        switch (i) {
            case 0:
                return a(context);
            case 1:
                return b();
            case 2:
                return c();
            case 3:
                return f();
            case 4:
                return d();
            case 5:
                return e();
            case 6:
                return j();
            case 13:
                return g();
            case IMediaObject.TYPE_OLD_TV /*14*/:
                return h();
            case 15:
                return i();
            case 16:
                return k();
            case IMediaObject.TYPE_LOCATION_SHARE /*17*/:
                return l();
            case 18:
                return m();
            case IMediaObject.TYPE_RECORD /*19*/:
                return n();
            default:
                return null;
        }
    }

    public static String[] a(Context context) {
        return new String[]{"camera", "com.vlocker.ui.cover.dismissactivity", a.a(context).bb(), "com.android.packageinstaller.permission.ui.grantpermissionsactivity"};
    }

    public static String[] b() {
        return new String[]{"calculator", "com.vlocker.ui.cover.dismissactivity"};
    }

    public static String[] c() {
        return new String[]{"alarm", "xtime", "com.android.internal.app.resolveractivity", "clock", "com.sonyericsson.organizer", "com.vlocker.ui.cover.dismissactivity"};
    }

    public static String[] d() {
        return new String[]{"com.android.phone", "com.lenovo.simsettings", "datausagesummaryactivity"};
    }

    public static String[] e() {
        return new String[]{FlowWebViewActivity.class.getName().toLowerCase()};
    }

    public static String[] f() {
        return new String[]{CitySelectActivity.class.getName().toLowerCase()};
    }

    public static String[] g() {
        return new String[]{WXApp.WXAPP_PACKAGE_NAME, "com.vlocker.ui.cover.dismissactivity"};
    }

    public static String[] h() {
        return new String[]{"com.tencent.mobileqq", "com.vlocker.ui.cover.dismissactivity"};
    }

    public static String[] i() {
        return new String[]{FlowWebViewActivity.class.getName().toLowerCase(), Weather2Activity.class.getName().toLowerCase(), CitySelectActivity.class.getName().toLowerCase()};
    }

    public static String[] j() {
        return new String[]{QuestionActivity.class.getName().toLowerCase()};
    }

    public static String[] k() {
        return new String[]{"com.taobao.tao.detail.activity.detailactivity", "com.taobao.taobao"};
    }

    public static String[] l() {
        return new String[]{"com.baidu.mobads.appactivity", BuildConfig.APPLICATION_ID};
    }

    public static String[] m() {
        return new String[]{"com.vlocker.search.baidusearchactivity", BuildConfig.APPLICATION_ID};
    }

    public static String[] n() {
        return new String[]{"com.vlocker.theme.activity.unlocktexteditactivity"};
    }
}
