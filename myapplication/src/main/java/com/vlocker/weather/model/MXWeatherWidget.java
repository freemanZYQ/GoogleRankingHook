package com.vlocker.weather.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.vlocker.c.a;
import com.vlocker.locker.d.c;
import com.vlocker.locker.d.d;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.bean.MXOneDayWeatherBean;
import com.vlocker.weather.bean.MXWeatherBean;
import com.vlocker.weather.e.j;
import java.net.URLDecoder;
import java.util.Iterator;

public class MXWeatherWidget implements a {
    private static final String ADDR = "addr";
    private static final String AUTO_POSITION = "auto";
    private static final String CITY = "city";
    private static final String CITY_CODE = "code";
    private static final String CITY_NAME = "city_name";
    private static final String DATE = "date";
    private static final String DAY_IMG = "day_img";
    private static final String DISTRICT = "district";
    private static final String HIGH = "high";
    private static final String IMEI = "imei";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String LOW = "low";
    private static final String NET_KIND = "net_kind";
    private static final String NIGHT_IMG = "night_img";
    private static final String PROVINCE = "province";
    private static final String RADIUS = "radius";
    private static final String SYS_CODE = "sys_code";
    private static final String TEXT = "text";
    private static final String TEXT_IMG = "text_img";
    private static final String TIME = "time";
    private static final String UPDATE_TIME = "update_time";
    private static final String VERSION_CODE = "version_code";
    public static final String WEATHER_CONFIG = "weather_config";
    public static final String WEATHER_CONFIG_GET_TIME = "weather_config_get_time";
    private static final int WEATHER_COUNTS = 7;
    private static final String WEATHER_PREFIX = "weather_";
    public static final String WEATHER_TOAST_6HOUR_TIME = "weather_toast_hour_time";
    private static final String WEEK = "week";
    private boolean isfreshsuccess;
    private Context mContext;
    private String pushBid;
    private String pushId;
    private String readStrConfig;
    private int textIconTag = 0;

    public MXWeatherWidget(Context context) {
        this.mContext = context;
    }

    private void readSavedWeatherDataOfToday(boolean z) {
        for (int i = 0; i < 7; i++) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(WEATHER_PREFIX + i, 0);
            if (sharedPreferences != null) {
                if (j.a(0).equals(sharedPreferences.getString(DATE, ""))) {
                    readWeatherInfoWithSavedData(sharedPreferences, 0);
                    return;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readWeatherInfoWithSavedData(android.content.SharedPreferences r13, int r14) {
        /*
        r12 = this;
        r0 = "tempdata";
        r1 = r12.mContext;
        r0 = com.vlocker.theme.f.a.a(r0, r1);
        r12.readStrConfig = r0;
        r3 = new com.vlocker.weather.bean.MXWeatherBean;
        r3.<init>();
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r1 = r12.readStrConfig;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r1 = "detail_weathers";
        r4 = r0.getJSONArray(r1);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r1 = 0;
        r0 = 0;
        r2 = r0;
    L_0x0021:
        r0 = r4.length();	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        if (r2 >= r0) goto L_0x009d;
    L_0x0027:
        r0 = r4.get(r2);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r5 = "date";
        r5 = r0.getString(r5);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r6 = "week";
        r6 = r0.getString(r6);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r7 = "high";
        r7 = r0.getString(r7);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r8 = "low";
        r8 = r0.getString(r8);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r9 = "text";
        r9 = r0.getString(r9);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r10 = "text_img";
        r10 = r0.getString(r10);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11 = new com.vlocker.weather.bean.MXOneDayWeatherBean;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.<init>();	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.a = r14;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.b = r5;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.i = r6;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.c = r7;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.d = r8;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.e = r9;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r11.f = r10;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r6 = "img_d";
        r6 = r0.getString(r6);	 Catch:{ Exception -> 0x0094, JSONException -> 0x0099 }
        r7 = "img_n";
        r0 = r0.getString(r7);	 Catch:{ Exception -> 0x0094, JSONException -> 0x0099 }
        r11.g = r6;	 Catch:{ Exception -> 0x0094, JSONException -> 0x0099 }
        r11.h = r0;	 Catch:{ Exception -> 0x0094, JSONException -> 0x0099 }
    L_0x007c:
        r0 = 0;
        r0 = com.vlocker.weather.e.j.a(r0);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r0 = r0.equals(r5);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        if (r0 == 0) goto L_0x01eb;
    L_0x0087:
        r0 = 1;
    L_0x0088:
        if (r0 == 0) goto L_0x008f;
    L_0x008a:
        r1 = r3.a;	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        r1.add(r11);	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
    L_0x008f:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
    L_0x0094:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ JSONException -> 0x0099, Exception -> 0x01e8 }
        goto L_0x007c;
    L_0x0099:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x009d:
        r0 = "text_img";
        r1 = "";
        r1 = r13.getString(r0, r1);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = "weathersunrise";
        r2 = r12.mContext;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = com.vlocker.theme.f.a.b(r0, r2);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r2 = "weathersunset";
        r4 = r12.mContext;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r2 = com.vlocker.theme.f.a.b(r2, r4);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r6 = r0.longValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r8 = 0;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 == 0) goto L_0x01cf;
    L_0x00c7:
        r6 = r0.longValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = r6 + r8;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 >= 0) goto L_0x01cf;
    L_0x00d3:
        r6 = r0.longValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 < 0) goto L_0x0120;
    L_0x00db:
        r6 = r2.longValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 >= 0) goto L_0x0120;
    L_0x00e3:
        r0 = r3.a;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = (com.vlocker.weather.bean.MXOneDayWeatherBean) r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.g;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r4 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r2, r4);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
    L_0x00ff:
        r0 = r12.textIconTag;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        if (r0 != 0) goto L_0x0114;
    L_0x0103:
        r0 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r1 = 0;
        r2 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r1, r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
    L_0x0114:
        r0 = r12.mContext;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = com.vlocker.c.a.a(r0);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r1 = r12.textIconTag;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0.M(r1);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
    L_0x011f:
        return;
    L_0x0120:
        r2 = r3.a;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = r2.size();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r4 = 1;
        if (r2 <= r4) goto L_0x01b1;
    L_0x0129:
        r2 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r4 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r6 = r0.longValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r4.setTimeInMillis(r6);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = 6;
        r4 = r4.get(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = 6;
        r5 = r2.get(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = 0;
        r6 = 9;
        r0 = r2.get(r6);	 Catch:{ Exception -> 0x01e2, NullPointerException -> 0x018f }
        if (r0 != 0) goto L_0x0191;
    L_0x014b:
        r0 = 1;
    L_0x014c:
        if (r4 != r5) goto L_0x0193;
    L_0x014e:
        if (r0 != 0) goto L_0x0193;
    L_0x0150:
        r0 = r3.a;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = (com.vlocker.weather.bean.MXOneDayWeatherBean) r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.f;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r4 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r2, r4);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        goto L_0x00ff;
    L_0x016d:
        r0 = move-exception;
        r1 = r0;
        r0 = r3.a;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = (com.vlocker.weather.bean.MXOneDayWeatherBean) r0;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = r0.g;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = r0.intValue();	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r2 = 0;
        r3 = r12.mContext;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r0 = com.vlocker.weather.e.j.a(r0, r2, r3);	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r12.textIconTag = r0;	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        r1.printStackTrace();	 Catch:{ NullPointerException -> 0x018f, Exception -> 0x01e5 }
        goto L_0x0114;
    L_0x018f:
        r0 = move-exception;
        goto L_0x011f;
    L_0x0191:
        r0 = 0;
        goto L_0x014c;
    L_0x0193:
        r0 = r3.a;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = (com.vlocker.weather.bean.MXOneDayWeatherBean) r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.f;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 1;
        r4 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r2, r4);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        goto L_0x00ff;
    L_0x01b1:
        r0 = r3.a;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = (com.vlocker.weather.bean.MXOneDayWeatherBean) r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.f;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r2 = 1;
        r4 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r2, r4);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        goto L_0x00ff;
    L_0x01cf:
        r0 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r1 = 0;
        r2 = r12.mContext;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r0 = com.vlocker.weather.e.j.a(r0, r1, r2);	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        r12.textIconTag = r0;	 Catch:{ Exception -> 0x016d, NullPointerException -> 0x018f }
        goto L_0x0114;
    L_0x01e2:
        r2 = move-exception;
        goto L_0x014c;
    L_0x01e5:
        r0 = move-exception;
        goto L_0x011f;
    L_0x01e8:
        r0 = move-exception;
        goto L_0x009d;
    L_0x01eb:
        r0 = r1;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.weather.model.MXWeatherWidget.readWeatherInfoWithSavedData(android.content.SharedPreferences, int):void");
    }

    private synchronized void saveRefreshWeatherConfig(boolean z, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        Editor edit = this.mContext.getSharedPreferences(WEATHER_CONFIG, 0).edit();
        a.a(this.mContext).h(str2);
        if (str != null) {
            a.a(this.mContext).i(str);
        }
        edit.putLong(WEATHER_CONFIG_GET_TIME, currentTimeMillis);
        edit.commit();
    }

    private void storeWeatherData(MXWeatherBean mXWeatherBean) {
        Iterator it = mXWeatherBean.a.iterator();
        while (it.hasNext()) {
            MXOneDayWeatherBean mXOneDayWeatherBean = (MXOneDayWeatherBean) it.next();
            Editor edit = this.mContext.getSharedPreferences(WEATHER_PREFIX + mXWeatherBean.a.indexOf(mXOneDayWeatherBean), 0).edit();
            edit.putString(CITY_CODE, mXWeatherBean.d);
            edit.putString(CITY_NAME, mXWeatherBean.b);
            edit.putString(UPDATE_TIME, mXWeatherBean.c);
            edit.putString(DATE, mXOneDayWeatherBean.b);
            edit.putString(WEEK, mXOneDayWeatherBean.i);
            edit.putString(HIGH, mXOneDayWeatherBean.c);
            edit.putString(LOW, mXOneDayWeatherBean.d);
            edit.putString(TEXT, mXOneDayWeatherBean.e);
            edit.putString(TEXT_IMG, mXOneDayWeatherBean.f);
            edit.putString(DAY_IMG, mXOneDayWeatherBean.g);
            edit.putString(NIGHT_IMG, mXOneDayWeatherBean.h);
            edit.commit();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parserweatherdata(org.json.JSONObject r20) {
        /*
        r19 = this;
        r2 = "city_name";
        r0 = r20;
        r8 = r0.getString(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = "update_time";
        r0 = r20;
        r2 = r0.getString(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r3 = "current_time";
        r0 = r20;
        r10 = r0.getLong(r3);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r3 = "code";
        r0 = r20;
        r9 = r0.getString(r3);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12 = new com.vlocker.weather.bean.MXWeatherBean;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12.<init>();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12.b = r8;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12.c = r2;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12.d = r9;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = "detail_weathers";
        r0 = r20;
        r13 = r0.getJSONArray(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r4 = 0;
        r6 = 0;
        r2 = "sunrise";
        r0 = r20;
        r4 = r0.getLong(r2);	 Catch:{ Exception -> 0x00f6, JSONException -> 0x016f }
        r2 = "sunset";
        r0 = r20;
        r2 = r0.getLong(r2);	 Catch:{ Exception -> 0x00f6, JSONException -> 0x016f }
    L_0x004e:
        r6 = "weathersunrise";
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r19;
        r5 = r0.mContext;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        com.vlocker.theme.f.a.a(r6, r4, r5);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r4 = "weathersunset";
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r19;
        r3 = r0.mContext;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        com.vlocker.theme.f.a.a(r4, r2, r3);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = 0;
        r3 = r2;
    L_0x006c:
        r2 = r13.length();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        if (r3 >= r2) goto L_0x00fd;
    L_0x0072:
        r2 = r13.get(r3);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = (org.json.JSONObject) r2;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r4 = "num";
        r4 = r2.getInt(r4);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r5 = "date";
        r5 = r2.getString(r5);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r6 = "week";
        r6 = r2.getString(r6);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r7 = "high";
        r7 = r2.getString(r7);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r14 = "low";
        r14 = r2.getString(r14);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r15 = "text";
        r15 = r2.getString(r15);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r16 = "text_img";
        r0 = r16;
        r16 = r2.getString(r0);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r17 = "img_d";
        r0 = r17;
        r17 = r2.getString(r0);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r18 = "img_n";
        r0 = r18;
        r2 = r2.getString(r0);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r18 = new com.vlocker.weather.bean.MXOneDayWeatherBean;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r18.<init>();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.a = r4;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.b = r5;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.i = r6;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.c = r7;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.d = r14;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.e = r15;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r16;
        r1 = r18;
        r1.f = r0;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r17;
        r1 = r18;
        r1.g = r0;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r0.h = r2;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = r12.a;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r18;
        r2.add(r0);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x006c;
    L_0x00f6:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = r6;
        goto L_0x004e;
    L_0x00fd:
        r2 = "weathercurrenttime";
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r19;
        r4 = r0.mContext;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        com.vlocker.theme.f.a.a(r2, r3, r4);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r12.a();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = "tempdata";
        r3 = r20.toString();	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r19;
        r4 = r0.mContext;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        com.vlocker.theme.f.a.a(r2, r3, r4);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r0 = r19;
        r0.storeWeatherData(r12);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = 1;
        r0 = r19;
        r0.saveRefreshWeatherConfig(r2, r8, r9);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = 0;
        r0 = r19;
        r0.readSavedWeatherDataOfToday(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = "icon2v";
        r0 = r20;
        r2 = r0.getJSONObject(r2);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        if (r2 == 0) goto L_0x017a;
    L_0x0138:
        r2 = r2.toString();	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r3 = r2.length();	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r4 = 10;
        if (r3 <= r4) goto L_0x0150;
    L_0x0144:
        r0 = r19;
        r3 = r0.mContext;	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r3 = com.vlocker.c.a.a(r3);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r3.y(r2);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
    L_0x014f:
        return;
    L_0x0150:
        r0 = r19;
        r2 = r0.mContext;	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r2 = com.vlocker.c.a.a(r2);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r3 = "";
        r2.y(r3);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        goto L_0x014f;
    L_0x015f:
        r2 = move-exception;
        r0 = r19;
        r2 = r0.mContext;	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r2 = com.vlocker.c.a.a(r2);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        r3 = "";
        r2.y(r3);	 Catch:{ JSONException -> 0x016f, Exception -> 0x0189 }
        goto L_0x014f;
    L_0x016f:
        r2 = move-exception;
        r3 = 0;
        r0 = r19;
        r0.readSavedWeatherDataOfToday(r3);
        r2.printStackTrace();
        goto L_0x014f;
    L_0x017a:
        r0 = r19;
        r2 = r0.mContext;	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r2 = com.vlocker.c.a.a(r2);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        r3 = "";
        r2.y(r3);	 Catch:{ Exception -> 0x015f, JSONException -> 0x016f }
        goto L_0x014f;
    L_0x0189:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.weather.model.MXWeatherWidget.parserweatherdata(org.json.JSONObject):void");
    }

    boolean preconditionOfRequestData() {
        return com.vlocker.b.j.i(this.mContext);
    }

    public void request(Context context, f fVar) {
        requestWeatherDataWithManualWay(context, fVar);
    }

    public synchronized void requestWeatherDataWithManualWay(Context context, f fVar) {
        String B = a.a(context).B();
        if (!(B == null || B.length() == 0 || B.equals("null"))) {
            String replace = B.replace("w-", "");
            B = a.a(context).C();
            this.isfreshsuccess = false;
            if (preconditionOfRequestData()) {
                String str;
                String E = a.a(this.mContext).E();
                String str2 = E == null ? "" : E;
                CharSequence F = a.a(this.mContext).F();
                if (TextUtils.isEmpty(F)) {
                    str = "";
                } else {
                    CharSequence charSequence = F;
                }
                E = a.a(this.mContext).D();
                if (TextUtils.isEmpty(E)) {
                    E = "";
                }
                if (B == null) {
                    B = "";
                }
                try {
                    c cVar = new c();
                    cVar.a(PROVINCE, URLDecoder.decode(str2, "UTF-8"));
                    cVar.a(CITY, URLDecoder.decode(B, "UTF-8"));
                    cVar.a(DISTRICT, URLDecoder.decode(str, "UTF-8"));
                    cVar.a(ADDR, URLDecoder.decode(E, "UTF-8"));
                    cVar.a(TIME, URLDecoder.decode("", "UTF-8"));
                    cVar.a(LATITUDE, URLDecoder.decode("", "UTF-8"));
                    cVar.a(LONGITUDE, URLDecoder.decode("", "UTF-8"));
                    cVar.a(RADIUS, URLDecoder.decode("", "UTF-8"));
                    if (!"000".equals(replace)) {
                        cVar.a(CITY_CODE, URLDecoder.decode(replace, "UTF-8"));
                    }
                    cVar.a(AUTO_POSITION, URLDecoder.decode("hand", "UTF-8"));
                    cVar.a(IMEI, URLDecoder.decode(com.vlocker.b.j.j(this.mContext), "UTF-8"));
                    cVar.a(VERSION_CODE, URLDecoder.decode(com.vlocker.b.j.k(this.mContext), "UTF-8"));
                    cVar.a(SYS_CODE, URLDecoder.decode(com.vlocker.b.j.l(this.mContext), "UTF-8"));
                    cVar.a(NET_KIND, String.valueOf(com.vlocker.b.j.b(this.mContext)));
                    cVar.a("from", URLDecoder.decode("vlocker", "UTF-8"));
                    a.a(this.mContext).h(replace);
                    a.a(this.mContext).i(B);
                    a.a(this.mContext).g(System.currentTimeMillis());
                    new Handler().postDelayed(new b(this, fVar), 10000);
                    d dVar = new d();
                    E = com.vlocker.b.j.d() + "&" + cVar.toString() + com.vlocker.b.j.o(MoSecurityApplication.a().getApplicationContext());
                    Log.i("cai========", "url=" + E);
                    dVar.a(E.trim().replaceAll(" ", ""), new c(this, fVar));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                saveRefreshWeatherConfig(true, B, replace);
            }
        }
    }

    public void setWeatherPush(String str, String str2) {
        this.pushId = str;
        this.pushBid = str2;
    }
}
