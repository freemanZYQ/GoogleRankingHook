package com.vlocker.msg;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.app.bj;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.location.LocationClientOption;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.k.d;
import com.vlocker.locker.R;
import com.vlocker.m.be;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.setting.a.a.e;
import com.vlocker.settings.FingerprintSettingActivity;
import com.vlocker.settings.NotificationSettingActivity;
import com.vlocker.settings.RedPacketActivity;
import com.vlocker.ui.cover.k;
import com.vlocker.weather.e.j;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class McmPushWidget {
    private static McmPushWidget sSingleton = null;
    Context context;
    k handler;
    int[] push_icon = new int[]{R.id.t_push_smallicon1, R.id.t_push_smallicon2, R.id.t_push_smallicon3, R.id.t_push_smallicon4, R.id.t_push_smallicon5, R.id.t_push_smallicon6};

    private McmPushWidget(Context context) {
        this.context = context;
        this.handler = new k(this);
    }

    private void factoryJson(ak akVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "from");
            jSONObject2.put("value", e.ACTION_MAIN);
            jSONObject2.put("type", "String");
            jSONArray.put(jSONObject2);
            jSONObject.put("extras", jSONArray);
            akVar.D = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Bitmap getBitmapFromURL(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized McmPushWidget getInstance(Context context) {
        McmPushWidget mcmPushWidget;
        synchronized (McmPushWidget.class) {
            if (sSingleton == null) {
                sSingleton = new McmPushWidget(context);
            }
            mcmPushWidget = sSingleton;
        }
        return mcmPushWidget;
    }

    private void sendHasFingerprintMsg(ak akVar) {
        akVar.c = "微锁屏支持指纹解锁啦";
        akVar.e = "右滑设置，解锁更方便更酷炫";
        akVar.b = getSpecialPackage(this.context, -1, 116);
        akVar.C = 1;
        akVar.F = -1;
        Intent intent = new Intent();
        if (k.a(this.context)) {
            intent.putExtra("from", "notification");
            intent.setAction("android.app.action.SET_NEW_PASSWORD");
            akVar.b = getSpecialPackage(this.context, -1, 115);
        } else {
            intent.setClass(this.context, FingerprintSettingActivity.class);
            intent.putExtra("from", "notification");
        }
        akVar.m = intent;
        akVar.k = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.l_fingerprint_enable);
        akVar.g = System.currentTimeMillis();
        factoryJson(akVar);
    }

    private void sendNoFingerprintMsg(ak akVar) {
        akVar.b = getSpecialPackage(this.context, -1, 114);
        akVar.C = 2;
        akVar.F = -1;
        akVar.t = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.l_fingerprint_unenable);
        akVar.g = System.currentTimeMillis();
        factoryJson(akVar);
    }

    public int getId() {
        Random random = new Random();
        random.nextInt();
        return random.nextInt(4000) + LocationClientOption.MIN_SCAN_SPAN;
    }

    public String getSpecialPackage(Context context, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName()).append("|").append(i).append("|").append(i2);
        return stringBuilder.toString();
    }

    public synchronized void handleMsgTypeAppOpenAlarm(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("timing");
            int id = getId();
            if (optJSONObject == null) {
                try {
                    as.a(this.context, jSONObject, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    SharedPreferences sharedPreferences = this.context.getSharedPreferences("Alarm", 0);
                    jSONObject.put("time", optJSONObject.getString("stime"));
                    Editor edit = sharedPreferences.edit();
                    edit.putString(id + ":star", jSONObject.toString());
                    edit.commit();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("time", optJSONObject.getString("etime"));
                    edit.putString(id + ":end", jSONObject2.toString());
                    edit.commit();
                    Intent intent = new Intent();
                    intent.setAction("AlarmChange");
                    this.context.sendBroadcast(intent);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized void handleMsgTypeOpen(JSONObject jSONObject, Intent intent, int i) {
        handleMsgTypeOpen(jSONObject, intent, i, 0);
    }

    public synchronized void handleMsgTypeOpen(JSONObject jSONObject, Intent intent, int i, int i2) {
        int i3 = 0;
        synchronized (this) {
            if (intent != null) {
                JSONObject jSONObject2;
                JSONObject jSONObject3 = null;
                try {
                    jSONObject2 = jSONObject.getJSONObject(e.ACTION_NOTIFICATION_LISTENER_SETTINGS);
                } catch (Exception e) {
                    jSONObject2 = jSONObject3;
                }
                if (jSONObject2 != null) {
                    ak akVar = new ak();
                    akVar.p = jSONObject.optString("id");
                    akVar.q = jSONObject.optString("bid");
                    if (TextUtils.isEmpty(ao.a(jSONObject2, "title_html", ""))) {
                        akVar.c = jSONObject2.optString("title");
                        akVar.d = false;
                    } else {
                        akVar.c = ao.a(jSONObject2, "title_html", "");
                        akVar.d = true;
                    }
                    if (TextUtils.isEmpty(ao.a(jSONObject2, "desc_html", ""))) {
                        akVar.e = jSONObject2.optString("desc");
                        akVar.f = false;
                    } else {
                        akVar.e = ao.a(jSONObject2, "desc_html", "");
                        akVar.f = true;
                    }
                    if (TextUtils.isEmpty(ao.a(jSONObject2, "gif", ""))) {
                        akVar.n = jSONObject2.optString("icon");
                        akVar.o = false;
                    } else {
                        akVar.n = ao.a(jSONObject2, "gif", "");
                        akVar.o = true;
                    }
                    akVar.s = jSONObject2.optString("type");
                    akVar.C = 1;
                    if (!TextUtils.isEmpty(akVar.s)) {
                        if (akVar.s.equals("cover")) {
                            akVar.C = 3;
                            akVar.u = jSONObject2.optString("cover");
                        } else if (akVar.s.equals("image")) {
                            akVar.C = 2;
                            akVar.u = jSONObject2.optString("image");
                        } else if (akVar.s.equals("images")) {
                            Vector vector = new Vector();
                            try {
                                JSONArray jSONArray = jSONObject2.getJSONArray("images");
                                if (jSONArray != null) {
                                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                        if (!TextUtils.isEmpty(jSONArray.optString(i4))) {
                                            vector.add(jSONArray.optString(i4));
                                        }
                                    }
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            if (vector.size() > 0) {
                                akVar.H = new String[vector.size()];
                                while (i3 < vector.size()) {
                                    akVar.H[i3] = (String) vector.get(i3);
                                    i3++;
                                }
                            }
                            akVar.C = 4;
                        }
                    }
                    if (i2 == 0) {
                        i2 = getId();
                    }
                    akVar.b = getSpecialPackage(this.context, i, i2);
                    akVar.m = intent;
                    akVar.F = i;
                    akVar.E = false;
                    akVar.r = true;
                    akVar.g = System.currentTimeMillis();
                    akVar.D = jSONObject.toString();
                    sendVlickerNotification(this.context, akVar, jSONObject2.toString());
                }
            }
        }
    }

    public synchronized void handleMsgTypeUriAppOpen(JSONObject jSONObject) {
        if (jSONObject != null) {
            int id = getId();
            try {
                getInstance(this.context).handleMsgTypeOpen(jSONObject, as.d(this.context, jSONObject.getJSONObject("intent").toString()), 1, id);
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized void handleMsgTypeWeatherAlarm(JSONObject jSONObject) {
        String B = a.a(this.context).B();
        if (!(B == null || B.length() == 0 || B.equals("null"))) {
            a.a(this.context).g(0);
            j.a(this.context, jSONObject.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void handleWeather(java.lang.String r13) {
        /*
        r12 = this;
        r8 = 0;
        monitor-enter(r12);
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.<init>(r13);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = 0;
        r2 = "data";
        r0 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x0015, all -> 0x012c }
        r2 = r0;
    L_0x0011:
        if (r2 != 0) goto L_0x0018;
    L_0x0013:
        monitor-exit(r12);
        return;
    L_0x0015:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0011;
    L_0x0018:
        r0 = "id";
        r1 = "";
        r0 = com.vlocker.msg.ao.a(r2, r0, r1);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = r0.isEmpty();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        if (r1 != 0) goto L_0x0013;
    L_0x0028:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        if (r1 != 0) goto L_0x0013;
    L_0x0031:
        r1 = r12.context;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "weatheryujing";
        r4 = 0;
        r3 = r1.getSharedPreferences(r3, r4);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r4 = 0;
        r4 = r3.getLong(r0, r4);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r6 = r1.longValue();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x0013;
    L_0x0051:
        r1 = r3.edit();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.putLong(r0, r4);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.commit();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = r3.getAll();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = r0.entrySet();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r6 = r0.iterator();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
    L_0x0067:
        r0 = r6.hasNext();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        if (r0 == 0) goto L_0x00a4;
    L_0x006d:
        r0 = r6.next();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = r0.getKey();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r8 = 0;
        r8 = r3.getLong(r1, r8);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r8 = r1.longValue();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r10 = 172800000; // 0xa4cb800 float:9.856849E-33 double:8.53745436E-316;
        r10 = r4 - r10;
        r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x0067;
    L_0x0090:
        r1 = r3.edit();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = r0.getKey();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.remove(r0);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.commit();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        goto L_0x0067;
    L_0x00a1:
        r0 = move-exception;
        goto L_0x0013;
    L_0x00a4:
        r0 = com.vlocker.msg.as.a();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        if (r0 != 0) goto L_0x0013;
    L_0x00aa:
        r0 = r12.getId();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = r12.context;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = 8;
        r0 = r12.getSpecialPackage(r1, r3, r0);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1 = new com.vlocker.msg.ak;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.<init>();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "title";
        r3 = r2.optString(r3);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.c = r3;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "id";
        r3 = r2.optString(r3);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.p = r3;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "bid";
        r3 = r2.optString(r3);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.q = r3;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "desc";
        r4 = "";
        r3 = com.vlocker.msg.ao.a(r2, r3, r4);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = r3.trim();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.e = r3;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = "img";
        r3 = r2.optString(r3);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.n = r3;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.g = r4;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        if (r3 == 0) goto L_0x012f;
    L_0x00fb:
        r0 = r12.context;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.b = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
    L_0x0103:
        r0 = r2.toString();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.D = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = 5;
        r1.C = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = "vlocker.MyWeather";
        r1.j = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = 1;
        r1.r = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = 8;
        r1.F = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = "important";
        r0 = r2.optBoolean(r0);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r1.E = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r0 = r12.context;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        r12.sendVlickerNotification(r0, r1, r2);	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        goto L_0x0013;
    L_0x012c:
        r0 = move-exception;
        monitor-exit(r12);
        throw r0;
    L_0x012f:
        r1.b = r0;	 Catch:{ Exception -> 0x00a1, all -> 0x012c }
        goto L_0x0103;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.msg.McmPushWidget.handleWeather(java.lang.String):void");
    }

    public boolean isNeedSendNotifyPermissionMsg() {
        return an.a(this.context) && !an.b(this.context);
    }

    public void removeRedPacketMsg() {
        ((NotificationManager) this.context.getSystemService("notification")).cancel(as.b("red_packet_msg"));
    }

    public synchronized void removeWeather(String[] strArr) {
        if (strArr != null) {
            if (strArr.length > 0) {
                p.a().a(strArr);
            }
        }
    }

    public void sendFingerprintNotifyMsg() {
        a a = a.a(this.context);
        try {
            ak akVar = new ak();
            if (a.ch()) {
                if (new SpassFingerprint(this.context).hasRegisteredFinger()) {
                    p.a(this.context, "Vlocker_Remind_FingerprintUnlock_Password_PPC_ZJ", "way", "Fingerprint");
                    sendHasFingerprintMsg(akVar);
                } else {
                    p.a(this.context, "Vlocker_Remind_FingerprintUnlock_Password_PPC_ZJ", "way", "noFingerprint");
                    sendNoFingerprintMsg(akVar);
                }
                a.aq(true);
                sendVlickerNotification(this.context, akVar, "");
            }
        } catch (Exception e) {
        }
    }

    public void sendNotifyPermissionMsg() {
        a a = a.a(MoSecurityApplication.a());
        if (isNeedSendNotifyPermissionMsg() && a.bU()) {
            ak akVar = new ak();
            akVar.c = "锁屏还能接收通知消息？";
            akVar.e = "—>滑动此消息去开启";
            akVar.b = getSpecialPackage(this.context, -1, 113);
            akVar.C = 1;
            akVar.F = -1;
            Intent intent = new Intent(this.context, NotificationSettingActivity.class);
            intent.putExtra("from", e.ACTION_MAIN);
            akVar.m = intent;
            akVar.k = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.main_icon);
            akVar.g = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("className", "com.vlocker.settings.NotificationSettingActivity");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("key", "from");
                jSONObject2.put("value", e.ACTION_MAIN);
                jSONObject2.put("type", "String");
                jSONArray.put(jSONObject2);
                jSONObject.put("extras", jSONArray);
                akVar.D = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            sendVlickerNotification(this.context, akVar, "");
            a.aq(true);
        }
    }

    public void sendRedPacketMsg() {
        ak akVar = new ak();
        akVar.c = "抢红包新姿势Get！";
        akVar.e = "锁屏红包助手帮你更快抢红包";
        akVar.b = "red_packet_msg";
        akVar.C = 7;
        akVar.F = 10;
        Intent intent = new Intent(this.context, RedPacketActivity.class);
        intent.putExtra("from", e.ACTION_MAIN);
        akVar.m = intent;
        akVar.k = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.l_redpocket_title);
        akVar.g = System.currentTimeMillis();
        akVar.E = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("className", "com.vlocker.settings.RedPacketActivity");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", "from");
            jSONObject2.put("value", e.ACTION_MAIN);
            jSONObject2.put("type", "String");
            jSONArray.put(jSONObject2);
            jSONObject.put("extras", jSONArray);
            akVar.D = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendVlickerNotification(this.context, akVar, "");
    }

    public void sendRedPacketShareMsg() {
        ak akVar = new ak();
        akVar.b = "red_packet_share";
        akVar.j = "红包分享";
        Intent intent = new Intent(this.context, FlowWebViewActivity.class);
        try {
            JSONObject jSONObject = new JSONObject(a.a(this.context).bM()).getJSONObject("data").getJSONObject("packet_notice");
            if (jSONObject != null) {
                String str = jSONObject.getString("url") + d.a(this.context).d(0);
                intent.putExtra("url", str);
                akVar.c = jSONObject.getString("title");
                akVar.e = jSONObject.getString("desc");
                akVar.u = jSONObject.getString("background");
                akVar.n = jSONObject.getString("preview");
                akVar.h = PendingIntent.getActivity(this.context, 0, intent, 134217728);
                akVar.g = System.currentTimeMillis();
                akVar.F = 2;
                akVar.C = 8;
                akVar.m = intent;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("className", "com.vlocker.notification.msg.open.FlowWebViewActivity");
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("key", "url");
                jSONObject3.put("value", str);
                jSONObject3.put("type", "String");
                jSONArray.put(jSONObject3);
                jSONObject2.put("extras", jSONArray);
                akVar.D = jSONObject2.toString();
                sendVlickerNotification(this.context, akVar, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendVlickerNotification(Context context, ak akVar, String str) {
        new Thread(new j(this, akVar, context)).start();
    }

    @SuppressLint({"NewApi"})
    public void shwoNotify(Context context, ak akVar, int i) {
        RemoteViews remoteViews;
        Notification a;
        String str = akVar.D;
        if (!("red_packet_msg".equals(akVar.b) || "red_packet_share".equals(akVar.b) || akVar.b.startsWith("msg_ad"))) {
            try {
                if (new JSONObject(str) == null || str.isEmpty()) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
        if (akVar.r) {
            p.a(context, "Vlock_SendToUser_PushMsg_PPC_TF", "Location", "Notify", "PushName", akVar.c);
        }
        be.a(context, akVar.m);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        bj bjVar = new bj(context);
        Intent intent = new Intent("com.vlocker.open.notification");
        intent.putExtra("extral_pkg_name", akVar.b);
        intent.putExtra("SpecialMsg", str);
        if (akVar.c != null) {
            intent.putExtra("title", akVar.c);
        }
        intent.putExtra("operation", i);
        int b = as.b(akVar.b);
        intent.putExtra("id", b);
        intent.putExtra("bid", akVar.q);
        intent.putExtra("isPush", akVar.r);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, b, intent, 134217728);
        Notification a2;
        RemoteViews remoteViews2;
        switch (akVar.C) {
            case 2:
                RemoteViews remoteViews3 = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_smallimg);
                remoteViews3.setImageViewBitmap(R.id.l_notification_smallimg, akVar.t);
                bjVar.a(remoteViews3).a(broadcast).a(System.currentTimeMillis()).a(akVar.d ? Html.fromHtml(akVar.c) : akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon);
                a2 = bjVar.a();
                a2.contentView = remoteViews3;
                notificationManager.notify(b, a2);
                return;
            case 3:
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_smallimg);
                if (akVar.t != null) {
                    remoteViews.setImageViewBitmap(R.id.l_notification_bigimg, akVar.t);
                } else {
                    remoteViews = null;
                }
                remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_normal);
                remoteViews2.setImageViewBitmap(R.id.l_msg_img, akVar.k);
                remoteViews2.setTextViewText(R.id.l_msg_title, akVar.d ? Html.fromHtml(akVar.c) : akVar.c);
                remoteViews2.setTextViewText(R.id.l_msg_content, akVar.e);
                bjVar.a(remoteViews == null ? remoteViews2 : remoteViews).a(broadcast).a(System.currentTimeMillis()).a(akVar.d ? Html.fromHtml(akVar.c) : akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon);
                a = bjVar.a();
                if (VERSION.SDK_INT >= 16 && remoteViews != null) {
                    try {
                        a.bigContentView = remoteViews;
                    } catch (Exception e2) {
                        a.contentView = remoteViews2;
                    }
                }
                a.contentView = remoteViews2;
                notificationManager.notify(b, a);
                return;
            case 4:
                remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_theme);
                remoteViews2.setImageViewBitmap(R.id.t_push_bigIcon, akVar.k);
                remoteViews2.setTextViewText(R.id.t_notification_title, akVar.d ? Html.fromHtml(akVar.c) : akVar.c);
                if (akVar.G != null && akVar.G.length > 0) {
                    int length = this.push_icon.length;
                    if (akVar.G.length < this.push_icon.length) {
                        length = akVar.G.length;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        remoteViews2.setImageViewBitmap(this.push_icon[i2], akVar.G[i2]);
                    }
                }
                bjVar.a(remoteViews2).a(broadcast).a(System.currentTimeMillis()).a(akVar.d ? Html.fromHtml(akVar.c) : akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon);
                a2 = bjVar.a();
                a2.contentView = remoteViews2;
                notificationManager.notify(b, a2);
                return;
            case 7:
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_redpacket);
                remoteViews.setImageViewBitmap(R.id.l_msg_img, akVar.k);
                remoteViews.setTextViewText(R.id.l_msg_title, akVar.c);
                remoteViews.setTextViewText(R.id.l_msg_content, akVar.e);
                bjVar.a(remoteViews).a(broadcast).a(System.currentTimeMillis()).a(akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon).b(true);
                a = bjVar.a();
                a.contentView = remoteViews;
                notificationManager.notify(b, a);
                return;
            case 8:
                remoteViews = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_normal_share);
                remoteViews.setImageViewBitmap(R.id.l_msg_img, akVar.k);
                remoteViews.setImageViewBitmap(R.id.l_msg_bg, akVar.t);
                remoteViews.setTextViewText(R.id.l_msg_title, akVar.c);
                remoteViews.setTextViewText(R.id.l_msg_content, akVar.e);
                bjVar.a(remoteViews).a(broadcast).a(System.currentTimeMillis()).a(akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon).b(true);
                a = bjVar.a();
                a.contentView = remoteViews;
                notificationManager.notify(b, a);
                return;
            default:
                if (akVar.C == 11) {
                    remoteViews = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_repair);
                } else {
                    remoteViews = new RemoteViews(context.getPackageName(), R.layout.l_notification_type_normal);
                    remoteViews.setImageViewBitmap(R.id.l_msg_img, akVar.k);
                }
                remoteViews.setTextViewText(R.id.l_msg_title, akVar.d ? Html.fromHtml(akVar.c) : akVar.c);
                remoteViews.setTextViewText(R.id.l_msg_content, akVar.f ? Html.fromHtml(akVar.e) : akVar.e);
                bjVar.a(remoteViews).a(broadcast).a(System.currentTimeMillis()).a(akVar.d ? Html.fromHtml(akVar.c) : akVar.c).b(0).a(false).a((int) R.drawable.l_notification_small_icon);
                a = bjVar.a();
                if (VERSION.SDK_INT >= 16 && remoteViews != null) {
                    try {
                        a.bigContentView = remoteViews;
                    } catch (Exception e3) {
                        a.contentView = remoteViews;
                    }
                }
                a.contentView = remoteViews;
                notificationManager.notify(b, a);
                return;
        }
    }
}
