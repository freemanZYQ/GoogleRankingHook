package com.vlocker.weather.e;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.vlocker.b.i;
import com.vlocker.locker.R;
import com.vlocker.new_theme.d.f;
import com.vlocker.theme.f.a;
import com.vlocker.weather.b.b;
import com.vlocker.weather.b.c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class j {
    public static String a = "http://weather.ksmobile.com/api/city/locate?f=moxiu";
    public static String b = "http://weather.ksmobile.com/api/forecasts/cm?f=moxiu";
    public static String c = "http://weather.ksmobile.com/api/city/search?f=moxiu";

    public static double a(double d, double d2, double d3, double d4) {
        double toRadians = Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d4);
        double toRadians3 = Math.toRadians(d) - Math.toRadians(d3);
        return ((Math.asin(Math.sqrt(((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.pow(Math.sin(toRadians3 / 2.0d), 2.0d)) + Math.pow(Math.sin((toRadians - toRadians2) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 1000.0d;
    }

    public static int a(int i, int i2, Context context) {
        Long b = a.b("weathersunrise", context);
        Long b2 = a.b("weathersunset", context);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(11, 18);
        instance2.set(13, 0);
        instance2.set(12, 0);
        instance.set(11, 6);
        instance.set(12, 0);
        instance.set(13, 0);
        long currentTimeMillis = System.currentTimeMillis();
        switch (i) {
            case 0:
                return (b.longValue() == 0 || currentTimeMillis >= b.longValue() + 86400000) ? ((currentTimeMillis < instance.getTimeInMillis() || currentTimeMillis > instance2.getTimeInMillis() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_qingnight : R.drawable.mx_weather_detail_kind_qing : ((currentTimeMillis < b.longValue() || currentTimeMillis >= b2.longValue() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_qingnight : R.drawable.mx_weather_detail_kind_qing;
            case 1:
                return (b.longValue() == 0 || currentTimeMillis >= b.longValue() + 86400000) ? ((currentTimeMillis < instance.getTimeInMillis() || currentTimeMillis > instance2.getTimeInMillis() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_yunnight : R.drawable.mx_weather_kind_detail_yun : ((currentTimeMillis < b.longValue() || currentTimeMillis >= b2.longValue() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_yunnight : R.drawable.mx_weather_kind_detail_yun;
            case 2:
                return R.drawable.mx_weather_kind_detail_yin;
            case 4:
                return R.drawable.mx_weather_kind_detail_leizhenyu;
            case 6:
                return R.drawable.mx_weather_kind_detail_yujiaxue;
            case 7:
                return R.drawable.mx_weather_kind_detail_xiaoyu;
            case 8:
                return R.drawable.mx_weather_kind_detail_zhongyu;
            case 9:
                return R.drawable.mx_weather_kind_detail_dayu;
            case 13:
                return (b.longValue() == 0 || currentTimeMillis >= b.longValue() + 86400000) ? ((currentTimeMillis < instance.getTimeInMillis() || currentTimeMillis > instance2.getTimeInMillis() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_zhenyunight : R.drawable.mx_weather_kind_detail_zhenyu : ((currentTimeMillis < b.longValue() || currentTimeMillis >= b2.longValue() || i2 == 2) && i2 != 1) ? R.drawable.mx_weather_kind_detail_zhenyunight : R.drawable.mx_weather_kind_detail_zhenyu;
            case IMediaObject.TYPE_OLD_TV /*14*/:
                return R.drawable.mx_weather_kind_detail_xiaoxue;
            case 15:
                return R.drawable.mx_weather_kind_detail_zhongxue;
            case 16:
                return R.drawable.mx_weather_kind_detail_daxue;
            case 18:
                return R.drawable.mx_weather_detail_kind_wu;
            case 30:
                return R.drawable.mx_weather_detail_kind_shachenbao;
            case 53:
                return R.drawable.mx_weather_kind_detail_mai;
            default:
                return R.drawable.mx_weather_detail_kind_qing;
        }
    }

    public static long a() {
        return (long) LocationClientOption.MIN_SCAN_SPAN;
    }

    public static String a(int i) {
        return new SimpleDateFormat("yyyy-M-d").format(new Date(System.currentTimeMillis() + ((long) (86400000 * i))));
    }

    public static String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new SimpleDateFormat("M/d").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, boolean z) {
        return z ? str + "°C" : str + "°";
    }

    public static ArrayList a(String str, Context context) {
        if (str == null) {
            return new ArrayList(0);
        }
        Object replaceAll = str.toString().trim().replaceAll(" ", "");
        if (TextUtils.isEmpty(replaceAll)) {
            return new ArrayList(0);
        }
        com.vlocker.c.a.a(context).au(true);
        try {
            return new b().a(f.a(i.e + "json.php?do=City.Search&app=vlocker&q=" + replaceAll));
        } catch (Exception e) {
            return new ArrayList(0);
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("com.vlocker.service.ACTION_WEATHER_UPDATE");
        intent.putExtra("push", str);
        context.sendBroadcast(intent);
    }

    public static boolean a(Context context) {
        long f = com.vlocker.c.a.a(context).f(0);
        long currentTimeMillis = System.currentTimeMillis();
        return f > currentTimeMillis || currentTimeMillis - f >= 10800000;
    }

    public static boolean a(BDLocation bDLocation, Context context) {
        if (bDLocation == null) {
            return false;
        }
        com.vlocker.c.a.a(context).e(System.currentTimeMillis());
        try {
            String cityCode = bDLocation.getCityCode();
            if (cityCode == null || cityCode.length() == 0) {
                return false;
            }
            com.vlocker.c.a.a(context).h("000");
            if (!bDLocation.getCity().equals(com.vlocker.c.a.a(context).C())) {
                context.sendBroadcast(new Intent("com.vlocker.app.msgcount.remove.weahter"));
            }
            com.vlocker.c.a.a(context).i(bDLocation.getCity());
            com.vlocker.c.a.a(context).k(bDLocation.getProvince());
            com.vlocker.c.a.a(context).l(bDLocation.getDistrict());
            com.vlocker.c.a.a(context).a(Double.valueOf(bDLocation.getLatitude()));
            com.vlocker.c.a.a(context).b(Double.valueOf(bDLocation.getLongitude()));
            com.vlocker.c.a.a(context).j(bDLocation.getAddrStr());
            if (com.vlocker.c.a.a(context).G()) {
                com.vlocker.c.a.a(context).m(bDLocation.getCountryCode());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("com.vlocker.WEATHER_ALARM_SELECT");
        intent.putExtra("pushjson", str);
        context.sendBroadcast(intent);
    }

    public static boolean b(Context context) {
        long f = com.vlocker.c.a.a(context).f(0);
        long currentTimeMillis = System.currentTimeMillis();
        return f > currentTimeMillis || currentTimeMillis - f >= 3600000;
    }

    public static boolean c(Context context) {
        long cM = com.vlocker.c.a.a(context).cM();
        long currentTimeMillis = System.currentTimeMillis();
        return cM > currentTimeMillis || currentTimeMillis - cM >= 3600000;
    }

    public static boolean d(Context context) {
        return com.vlocker.c.a.a(context).W();
    }

    public static void e(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.vlocker.service.ACTION_WEATHER_UPDATE");
        context.sendBroadcast(intent);
    }

    public static void f(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.vlocker.ACTION_WEATHER_UI_UPDATE");
        context.sendBroadcast(intent);
    }

    public static void g(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.vlocker.ACTION_WALLPAPER_UI_UPDATE");
        context.sendBroadcast(intent);
    }

    public static void h(Context context) {
        new Thread(new k(context)).start();
    }

    public static void i(Context context) {
        try {
            CharSequence B = com.vlocker.c.a.a(context).B();
            CharSequence C = com.vlocker.c.a.a(context).C();
            if (com.vlocker.c.a.a(context).I() || TextUtils.isEmpty(B) || TextUtils.isEmpty(C)) {
                com.vlocker.c.a.a(context).k(true);
                if (com.vlocker.c.a.a(context).x()) {
                    c.a(context).a(true);
                    return;
                } else {
                    c.a(context).a(false);
                    return;
                }
            }
            if (com.vlocker.c.a.a(context).x()) {
                com.vlocker.c.a.a(context).g(0);
            }
            e(context);
        } catch (Exception e) {
        }
    }

    public static boolean j(Context context) {
        try {
            CharSequence C = com.vlocker.c.a.a(context).C();
            String B = com.vlocker.c.a.a(context).B();
            if (B == null || B.length() == 0 || B.equals("null")) {
                return false;
            }
            if ((System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1) || !com.vlocker.b.j.i(context)) {
                return false;
            }
            if (Boolean.valueOf(com.vlocker.c.a.a(context).at(false)).booleanValue() && C != null) {
                Intent intent = new Intent("com.vlocker.update_weather_from_locker");
                intent.putExtra("cityname", C);
                intent.putExtra("citycode", B.replace("w-", ""));
                context.sendBroadcast(intent);
                com.vlocker.c.a.a(context).au(false);
            }
            return !TextUtils.isEmpty(C);
        } catch (Exception e) {
            return false;
        }
    }
}
