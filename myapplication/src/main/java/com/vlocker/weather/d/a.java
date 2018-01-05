package com.vlocker.weather.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.weather.bean.MXOneDayWeatherBean;
import com.vlocker.weather.bean.MXWeatherBean;
import com.vlocker.weather.e.j;
import com.vlocker.weather.model.MXWeatherWidget;
import com.vlocker.weather.model.f;
import com.vlocker.weather.view.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private Context a;
    private String b = "";
    private String c = "";
    private com.vlocker.weather.model.a d;
    private d e;
    private d f;
    private Handler g = new b(this);
    private f h = new c(this);
    private boolean i = false;

    public a(Context context, d dVar) {
        this.a = context;
        this.e = dVar;
        this.d = new MXWeatherWidget(this.a);
        a();
    }

    private MXWeatherBean a(JSONObject jSONObject) {
        MXWeatherBean mXWeatherBean = new MXWeatherBean();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("weather_15d");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                int i2 = jSONObject2.getInt("num");
                String string = jSONObject2.getString("date");
                String string2 = jSONObject2.getString("week");
                String string3 = jSONObject2.getString("high");
                String string4 = jSONObject2.getString("low");
                String string5 = jSONObject2.getString("text");
                String string6 = jSONObject2.getString("text_img");
                MXOneDayWeatherBean mXOneDayWeatherBean = new MXOneDayWeatherBean();
                mXOneDayWeatherBean.a = i2;
                mXOneDayWeatherBean.b = string;
                mXOneDayWeatherBean.i = string2;
                mXOneDayWeatherBean.c = string3;
                mXOneDayWeatherBean.d = string4;
                mXOneDayWeatherBean.e = string5;
                mXOneDayWeatherBean.f = string6;
                try {
                    String string7 = jSONObject2.getString("img_d");
                    string = jSONObject2.getString("img_n");
                    string2 = jSONObject2.getString("text_d");
                    String string8 = jSONObject2.getString("text_n");
                    mXOneDayWeatherBean.g = string7;
                    mXOneDayWeatherBean.h = string;
                    mXOneDayWeatherBean.j = string2;
                    mXOneDayWeatherBean.k = string8;
                } catch (Exception e) {
                }
                mXWeatherBean.a.add(mXOneDayWeatherBean);
            }
        } catch (Exception e2) {
        }
        return mXWeatherBean;
    }

    private void a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("push"));
            this.c = jSONObject.optString("id");
            this.b = jSONObject.optString("bid");
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r8) {
        /*
        r7 = this;
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0083, all -> 0x00a7 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0083, all -> 0x00a7 }
        r2 = "notice";
        r3 = r1.getJSONArray(r2);	 Catch:{ Exception -> 0x0083, all -> 0x00a7 }
        r1 = r3.length();	 Catch:{ Exception -> 0x0083, all -> 0x00a7 }
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x0083, all -> 0x00a7 }
        r0 = 0;
        r2 = r0;
    L_0x0015:
        r0 = r3.length();	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        if (r2 >= r0) goto L_0x006d;
    L_0x001b:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0.<init>();	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = "type";
        r5 = "weather";
        r0.put(r4, r5);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = "data";
        r5 = r3.get(r2);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0.put(r4, r5);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = "data";
        r5 = r3.get(r2);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0.putOpt(r4, r5);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = "id";
        r5 = r7.c;	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0.put(r4, r5);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = "bid";
        r5 = r7.b;	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0.put(r4, r5);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = r7.a;	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4 = com.vlocker.msg.McmPushWidget.getInstance(r4);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r4.handleWeather(r0);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r0 = r3.get(r2);	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r0 = (org.json.JSONObject) r0;	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r4 = "id";
        r0 = r0.getString(r4);	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r1[r2] = r0;	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
    L_0x0069:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0015;
    L_0x006d:
        r0 = "";
        r7.b = r0;
        r0 = "";
        r7.c = r0;
        if (r1 == 0) goto L_0x0082;
    L_0x0079:
        r0 = r7.a;
        r0 = com.vlocker.msg.McmPushWidget.getInstance(r0);
        r0.removeWeather(r1);
    L_0x0082:
        return;
    L_0x0083:
        r1 = move-exception;
    L_0x0084:
        r1 = r7.a;	 Catch:{ all -> 0x00c3 }
        r2 = new android.content.Intent;	 Catch:{ all -> 0x00c3 }
        r3 = "com.vlocker.app.msgcount.remove.weahter";
        r2.<init>(r3);	 Catch:{ all -> 0x00c3 }
        r1.sendBroadcast(r2);	 Catch:{ all -> 0x00c3 }
        r1 = "";
        r7.b = r1;
        r1 = "";
        r7.c = r1;
        if (r0 == 0) goto L_0x0082;
    L_0x009d:
        r1 = r7.a;
        r1 = com.vlocker.msg.McmPushWidget.getInstance(r1);
        r1.removeWeather(r0);
        goto L_0x0082;
    L_0x00a7:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00ab:
        r2 = "";
        r7.b = r2;
        r2 = "";
        r7.c = r2;
        if (r1 == 0) goto L_0x00c0;
    L_0x00b7:
        r2 = r7.a;
        r2 = com.vlocker.msg.McmPushWidget.getInstance(r2);
        r2.removeWeather(r1);
    L_0x00c0:
        throw r0;
    L_0x00c1:
        r0 = move-exception;
        goto L_0x00ab;
    L_0x00c3:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00ab;
    L_0x00c8:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0084;
    L_0x00cb:
        r0 = move-exception;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.weather.d.a.a(java.lang.String):void");
    }

    private void b(Context context) {
        if (context == null) {
            context = MoSecurityApplication.a().getApplicationContext();
        }
        if (!j.d(context)) {
            return;
        }
        if ((j.a(context) || com.vlocker.c.a.a(context).f(0) == 0) && !this.i) {
            this.i = true;
            if (j.j(context)) {
                a(context);
                com.vlocker.c.a.a(context).g(System.currentTimeMillis());
            }
            if (!com.vlocker.c.a.a(context).H() && com.vlocker.c.a.a(context).ac()) {
                com.vlocker.c.a.a(context).u(false);
            }
            this.i = false;
        }
    }

    public void a() {
        Log.e("liu---", "presenter oncreate");
        this.f = new d(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("com.vlocker.ACTION_WEATHER_UI_UPDATE");
        intentFilter.addAction("com.vlocker.WEATHER_ALARM_SELECT");
        this.a.registerReceiver(this.f, intentFilter);
    }

    public void a(Context context) {
        if (j.d(context)) {
            this.d.request(context, this.h);
        }
    }

    public void a(Context context, Intent intent) {
        a(intent);
        b(context);
    }

    public void a(JSONObject jSONObject, ArrayList arrayList, MXWeatherBean mXWeatherBean) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("detail_weathers");
            int i = 0;
            Object obj = null;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                int i2 = jSONObject2.getInt("num");
                String string = jSONObject2.getString("date");
                String string2 = jSONObject2.getString("week");
                String string3 = jSONObject2.getString("high");
                String string4 = jSONObject2.getString("low");
                String string5 = jSONObject2.getString("text");
                String string6 = jSONObject2.getString("text_img");
                MXOneDayWeatherBean mXOneDayWeatherBean = new MXOneDayWeatherBean();
                mXOneDayWeatherBean.a = i2;
                mXOneDayWeatherBean.b = string;
                mXOneDayWeatherBean.i = string2;
                mXOneDayWeatherBean.c = string3;
                mXOneDayWeatherBean.d = string4;
                mXOneDayWeatherBean.e = string5;
                mXOneDayWeatherBean.f = string6;
                try {
                    String string7 = jSONObject2.getString("img_d");
                    string2 = jSONObject2.getString("img_n");
                    string3 = jSONObject2.getString("text_d");
                    String string8 = jSONObject2.getString("text_n");
                    mXOneDayWeatherBean.g = string7;
                    mXOneDayWeatherBean.h = string2;
                    mXOneDayWeatherBean.j = string3;
                    mXOneDayWeatherBean.k = string8;
                } catch (Exception e) {
                }
                if (j.a(-1).equals(string)) {
                    arrayList.add(mXOneDayWeatherBean);
                }
                Object obj2 = j.a(0).equals(string) ? 1 : obj;
                if (obj2 != null) {
                    mXWeatherBean.a.add(mXOneDayWeatherBean);
                }
                i++;
                obj = obj2;
            }
            mXWeatherBean.a.addAll(a(jSONObject).a);
            arrayList.addAll(mXWeatherBean.a);
        } catch (Exception e2) {
        }
    }

    public void b() {
        if (this.f != null) {
            this.a.unregisterReceiver(this.f);
        }
    }

    public void c() {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(MXWeatherWidget.WEATHER_CONFIG, 0);
        long j = sharedPreferences.getLong(MXWeatherWidget.WEATHER_TOAST_6HOUR_TIME, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j >= 21600000) {
            Editor edit = sharedPreferences.edit();
            edit.putLong(MXWeatherWidget.WEATHER_TOAST_6HOUR_TIME, currentTimeMillis);
            edit.commit();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.cover_toast, null);
            Toast toast = new Toast(this.a);
            toast.setGravity(80, 0, 80);
            toast.setDuration(1);
            toast.setView(inflate);
            toast.show();
        }
    }
}
