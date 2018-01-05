package com.mx.http.download;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.openad.d.b;
import com.mx.http.a.c;
import com.mx.http.a.d;
import com.mx.http.f;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DownloadNotify extends BroadcastReceiver {
    private static /* synthetic */ int[] e;
    private Context a;
    private NotificationManager b;
    private Map c;
    private f d;

    public DownloadNotify(Context context) {
        this.a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.d = f.a(this.a);
    }

    private void a(List list, String str, int i) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!TextUtils.isEmpty((CharSequence) list.get(i2))) {
                if (!TextUtils.isEmpty((String) list.get(i2))) {
                    this.d.a((String) list.get(i2), i, null, null, new b(this));
                } else {
                    return;
                }
            }
        }
    }

    static /* synthetic */ int[] a() {
        int[] iArr = e;
        if (iArr == null) {
            iArr = new int[i.values().length];
            try {
                iArr[i.DOWNLOADING.ordinal()] = 13;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[i.DOWNLOAD_CANCEL.ordinal()] = 11;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[i.DOWNLOAD_COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[i.DOWNLOAD_FAILED.ordinal()] = 8;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[i.DOWNLOAD_NETWORK_UNAVAILABLE.ordinal()] = 12;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[i.DOWNLOAD_PAUSE.ordinal()] = 9;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[i.DOWNLOAD_PENDING.ordinal()] = 10;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[i.HOPE_INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[i.HOPE_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[i.INSTALLED.ordinal()] = 7;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[i.INSTALL_FAIL.ordinal()] = 14;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[i.UNKNOW.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[i.WAIT_INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[i.WAIT_UPDATE.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            e = iArr;
        }
        return iArr;
    }

    protected PendingIntent a(String str, int i) {
        Intent intent = new Intent("com.moxiu.http.download.notification.cancel");
        intent.putExtra(b.EVENT_MESSAGE, str);
        return PendingIntent.getBroadcast(this.a, i, intent, 134217728);
    }

    public void a(int i, String str) {
        this.b.cancel(i);
        this.c.remove(str);
    }

    public void a(Builder builder, String str) {
        new c(this, builder).execute(new String[]{str});
    }

    public void a(a aVar) {
        try {
            if (Integer.parseInt(VERSION.SDK) >= 11 && aVar.q()) {
                a aVar2;
                Builder builder;
                CharSequence charSequence;
                CharSequence charSequence2;
                Builder builder2 = (Builder) this.c.get(aVar.c());
                a aVar3 = (a) d.a(this.a, aVar.c(), a.class);
                if (aVar3 == null) {
                    d.a(this.a, aVar.c(), (Object) aVar);
                    aVar2 = aVar;
                } else {
                    aVar2 = aVar3;
                }
                if (builder2 == null) {
                    builder2 = new Builder(this.a);
                    if (!(this.c.containsKey(aVar.c()) || aVar2 == null || i.DOWNLOAD_FAILED.equals(aVar2.b()))) {
                        this.c.put(aVar.c(), builder2);
                        a(builder2, aVar.h());
                    }
                    builder = builder2;
                } else {
                    builder = builder2;
                }
                builder.getNotification();
                String str = "精彩推荐";
                str = "";
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                float parseFloat = Float.parseFloat(decimalFormat.format((double) ((((float) aVar.x()) / 1024.0f) / 1024.0f)));
                float parseFloat2 = Float.parseFloat(decimalFormat.format((double) ((((float) aVar.e()) / 1024.0f) / 1024.0f)));
                String stringBuilder = new StringBuilder(String.valueOf(parseFloat)).toString();
                str = new StringBuilder(String.valueOf(parseFloat2)).toString();
                if (parseFloat < 1.0f && !String.valueOf(parseFloat).contains("0.")) {
                    stringBuilder = "0." + parseFloat;
                }
                if (parseFloat2 < 1.0f && !String.valueOf(parseFloat2).contains("0.")) {
                    str = "0." + parseFloat2;
                }
                str = "总大小:" + str + "MB";
                String str2 = "已完成:" + stringBuilder + "MB,";
                long e = aVar.e();
                long x = aVar.x();
                File file = new File(aVar.f());
                Intent intent = new Intent();
                Bundle bundle;
                if (i.DOWNLOAD_FAILED.equals(aVar.b())) {
                    charSequence = aVar.w() + " 下载失败";
                    charSequence2 = "点击重新下载";
                    intent.setClass(this.a, IntentActivity.class);
                    bundle = new Bundle();
                    bundle.putString("tag", "download_fail");
                    bundle.putSerializable("data", aVar);
                    intent.putExtras(bundle);
                } else if (i.WAIT_INSTALL.equals(aVar.b()) || (aVar.x() == aVar.e() && file.exists())) {
                    charSequence = aVar.w() + " 下载完成";
                    builder.setProgress((int) e, (int) e, false);
                    charSequence2 = "点击安装";
                    builder.setSmallIcon(17301634);
                    intent.setClass(this.a, IntentActivity.class);
                    bundle = new Bundle();
                    bundle.putString("filePath", aVar2.f());
                    bundle.putString("tag", "download_complete_notification");
                    intent.putExtras(bundle);
                    builder.setAutoCancel(true);
                } else {
                    charSequence = "正在下载 " + aVar.w();
                    builder.setProgress((int) e, (int) x, false);
                    charSequence2 = new StringBuilder(String.valueOf(str2)).append(str).toString();
                    builder.setAutoCancel(false);
                    builder.setSmallIcon(17301633);
                    intent.setClass(this.a, IntentActivity.class);
                    bundle = new Bundle();
                    bundle.putString("tag", "download_fail");
                    Log.e("ZGP", "downloadNotify:" + aVar);
                    bundle.putSerializable("data", aVar);
                    intent.putExtras(bundle);
                }
                builder.setContentIntent(PendingIntent.getActivity(this.a, aVar2.v(), intent, 134217728));
                builder.setContentTitle(charSequence).setContentText(charSequence2);
                Notification notification = builder.getNotification();
                notification.deleteIntent = a(aVar.c(), aVar2.v());
                this.b.notify(aVar2.v(), notification);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                a aVar;
                if ("com.moxiu.http.download.task.update".equalsIgnoreCase(action)) {
                    aVar = (a) intent.getSerializableExtra("itemdata");
                    if (aVar != null) {
                        a(aVar);
                    }
                } else if ("com.moxiu.http.download.task.state".equalsIgnoreCase(action)) {
                    aVar = (a) intent.getSerializableExtra("itemdata");
                    if (aVar != null) {
                        File file;
                        switch (a()[aVar.b().ordinal()]) {
                            case 5:
                                CharSequence k = aVar.k();
                                r1 = aVar.l();
                                List arrayList = new ArrayList();
                                List arrayList2 = r1 == null ? new ArrayList() : r1;
                                if (!TextUtils.isEmpty(k)) {
                                    arrayList.add(k);
                                }
                                a aVar2 = (a) d.a(this.a, aVar.c(), a.class);
                                String packageName = this.a.getApplicationContext().getPackageName();
                                if (aVar2 != null && aVar2.b() == i.WAIT_INSTALL && packageName != null && packageName.equals(aVar2.y())) {
                                    a(arrayList2, "下载", aVar.C());
                                    a(arrayList, "下载", aVar.B());
                                }
                                file = new File(aVar.f());
                                if (".apk".equals(aVar.g()) && file.exists() && aVar.z()) {
                                    Intent intent2 = new Intent(this.a, IntentActivity.class);
                                    intent2.setClass(this.a, IntentActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("filePath", aVar.f());
                                    bundle.putString("tag", "download_complete");
                                    intent2.addFlags(268435456);
                                    intent2.putExtras(bundle);
                                    this.a.startActivity(intent2);
                                    return;
                                }
                                return;
                            case 6:
                                file = new File(aVar.f());
                                if (".apk".equals(aVar.g()) && file.exists() && aVar.z()) {
                                    r0 = new Intent("android.intent.action.VIEW");
                                    r0.addFlags(268435456);
                                    r0.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                                    this.a.startActivity(r0);
                                    return;
                                }
                                return;
                            case 7:
                                a(aVar.v(), aVar.c());
                                return;
                            case 8:
                                a(aVar);
                                return;
                            case 10:
                            case 11:
                                return;
                            case 13:
                                a(aVar);
                                return;
                            default:
                                return;
                        }
                    }
                } else if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
                    aVar = (a) d.a(this.a, intent.getDataString().substring(8).trim(), a.class);
                    if (aVar != null) {
                        CharSequence m = aVar.m();
                        r1 = aVar.n();
                        List arrayList3 = new ArrayList();
                        if (r1 == null) {
                            r1 = new ArrayList();
                        }
                        if (!TextUtils.isEmpty(m)) {
                            arrayList3.add(m);
                        }
                        try {
                            String packageName2 = this.a.getApplicationContext().getPackageName();
                            if (aVar.b() == i.WAIT_INSTALL && packageName2 != null && packageName2.equals(aVar.y())) {
                                a(r1, "安装", aVar.C());
                                a(arrayList3, "安装", aVar.B());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        a(aVar.v(), aVar.c());
                        File file2 = new File(aVar.f());
                        d.a(this.a, aVar.c());
                        if (file2.exists()) {
                            System.gc();
                            file2.delete();
                        }
                    }
                } else if ("com.moxiu.http.download.notification.cancel".equalsIgnoreCase(action)) {
                    CharSequence stringExtra = intent.getStringExtra(b.EVENT_MESSAGE);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.c.remove(stringExtra);
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(action)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    State state = connectivityManager.getNetworkInfo(1).getState();
                    State state2 = connectivityManager.getNetworkInfo(0).getState();
                    if (state != null && state2 != null && State.CONNECTED == state && State.CONNECTED != state2 && c.a(this.a)) {
                        r0 = d.a(this.a);
                        if (r0 != null && r0.size() > 0) {
                            for (String action2 : r0.keySet()) {
                                Object obj = (a) d.a(this.a, action2, a.class);
                                if (obj != null) {
                                    try {
                                        if (i.DOWNLOAD_FAILED.equals(obj.b()) && this.c.containsKey(action2)) {
                                            obj.a(i.DOWNLOAD_PENDING);
                                            d.a(this.a, obj.c(), obj);
                                            r0 = new Intent(this.a, DownloadService.class);
                                            r3 = new Bundle();
                                            r3.putSerializable("itemdata", obj);
                                            r0.putExtras(r3);
                                            this.a.startService(r0);
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                } else if ("com.moxiu.http.download.task.restart".equalsIgnoreCase(action2) && c.a(this.a)) {
                    r0 = d.a(this.a);
                    if (r0 != null && r0.size() > 0) {
                        for (String action22 : r0.keySet()) {
                            Object obj2 = (a) d.a(this.a, action22, a.class);
                            if (obj2 != null) {
                                try {
                                    if (i.DOWNLOADING.equals(obj2.b())) {
                                        obj2.a(i.DOWNLOAD_PENDING);
                                        d.a(this.a, obj2.c(), obj2);
                                        Intent intent3 = new Intent(this.a, DownloadService.class);
                                        r3 = new Bundle();
                                        r3.putSerializable("itemdata", obj2);
                                        intent3.putExtras(r3);
                                        this.a.startService(intent3);
                                    }
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e222) {
            e222.printStackTrace();
        }
    }
}
