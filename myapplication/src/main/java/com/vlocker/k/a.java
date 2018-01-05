package com.vlocker.k;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.b.p;
import com.vlocker.m.aa;
import com.vlocker.m.ap;
import com.vlocker.msg.ak;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.f;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a {
    private static a f;
    public boolean a;
    public long b;
    String[] c = new String[]{"请使用新版手机QQ查收红包", "\n"};
    private Context d;
    private com.vlocker.c.a e;
    private boolean g;
    private ak h = new ak();
    private ak i = new ak();
    private int j;
    private int k;

    public a(Context context) {
        this.d = context;
        this.e = com.vlocker.c.a.a(context);
    }

    public static a a(Context context) {
        if (f == null) {
            f = new a(context);
        }
        return f;
    }

    private void a(int i) {
        if (i == 13) {
            this.e.C(this.e.bB() + 1);
        } else if (i == 14) {
            this.e.F(this.e.bE() + 1);
        }
        if (this.e.bF() == 0) {
            this.e.k(System.currentTimeMillis());
        } else if (System.currentTimeMillis() - this.e.bF() >= 10800000) {
            p.a(this.d, "Vlocker_Remind_Hongbao_PPC_TF", "qq", this.e.bE() + "", "wx", this.e.bB() + "");
            if (this.e.bC() > 0 || this.e.bD() > 0) {
                p.a(this.d, "Vlocker_Get_Hongbao_PPC_TF", "qq", this.e.bD() + "", "wx", this.e.bC() + "");
                this.e.D(0);
                this.e.E(0);
            }
            this.e.C(0);
            this.e.F(0);
            this.e.k(System.currentTimeMillis());
        }
    }

    private void a(Notification notification) {
        if (a()) {
            if (this.e.bx()) {
                aa.a(this.d);
            }
            if (this.e.bw()) {
                ap.a(this.d).a("red_packet_voice_" + (this.e.by() + 1) + ".mp3");
            }
            p.a().a(notification);
        } else if (com.vlocker.m.ak.b(this.d)) {
            p.a().a(notification);
        }
    }

    private void a(String str) {
        d a = d.a(this.d);
        int parseInt = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        if (parseInt > this.e.bO()) {
            a.a();
            this.e.am(false);
            this.e.J(parseInt);
        }
        parseInt = a.a(str, 1);
        if (parseInt > 0) {
            a.a(str, parseInt + 1, 1);
        } else {
            a.a(str);
        }
    }

    private boolean a() {
        Time time = new Time();
        time.setToNow();
        int br = this.e.br();
        int bs = this.e.bs();
        int bt = this.e.bt();
        int bu = this.e.bu();
        return (br < bt || (br == bt && bs < bu)) ? (time.hour > br || (time.hour == br && time.minute >= bs)) ? time.hour >= bt && (time.hour != bt || time.minute > bu) : true : (br > bt || (br == bt && bs > bu)) ? time.hour <= br && ((time.hour != br || time.minute < bs) && time.hour >= bt && (time.hour != bt || time.minute > bu)) : true;
    }

    private void b(Notification notification, String str) {
        String c;
        ak akVar;
        StringBuilder append;
        if (WXApp.WXAPP_PACKAGE_NAME.endsWith(str)) {
            this.h = new ak();
            this.h.C = 6;
            this.h.h = notification.contentIntent;
            this.h.g = notification.when;
            this.h.b = "red_packet";
            this.h.j = "red_packet_" + str;
            this.h.c = "微信发来" + this.j + "个红包！";
            c = c(notification);
            akVar = this.h;
            append = new StringBuilder().append("来自 ");
            if (c == null) {
                c = "右滑查看微信红包消息";
            }
            akVar.e = append.append(c).toString();
        } else if ("com.tencent.mobileqq".equals(str)) {
            this.i = new ak();
            this.i.C = 6;
            this.i.h = notification.contentIntent;
            this.i.g = notification.when;
            this.i.b = "red_packet_QQ";
            this.i.j = "red_packet_QQ" + str;
            this.i.c = "QQ发来" + this.k + "个红包！";
            c = c(notification);
            akVar = this.i;
            append = new StringBuilder().append("来自 ");
            if (c == null) {
                c = "右滑查看QQ红包消息";
            }
            akVar.e = append.append(c).toString();
        }
    }

    private boolean b(Notification notification) {
        if (TextUtils.isEmpty(notification.tickerText)) {
            return false;
        }
        String[] split = notification.tickerText.toString().split(":");
        if (split.length <= 1) {
            return false;
        }
        String str = split[1];
        for (int i = 2; i < split.length; i++) {
            str = str + split[i];
        }
        if (str == null) {
            return false;
        }
        String str2 = null;
        if (str.startsWith(" [QQ红包]")) {
            str2 = str.replace(" [QQ红包]", "");
        } else if (str.startsWith("[QQ红包]")) {
            str2 = str.replace("[QQ红包]", "");
        }
        if (TextUtils.isEmpty(str2) || str2.replaceAll("\\[emoji\\]", " ").length() > 18) {
            return false;
        }
        for (CharSequence contains : this.c) {
            if (str2.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    private String c(Notification notification) {
        if (notification == null || notification.contentIntent == null) {
            return null;
        }
        String charSequence;
        int indexOf;
        int lastIndexOf;
        CharSequence substring;
        if (!TextUtils.isEmpty(notification.tickerText)) {
            charSequence = notification.tickerText.toString();
            indexOf = charSequence.indexOf(":");
            if (indexOf > 0 && indexOf < charSequence.length()) {
                charSequence = charSequence.substring(0, indexOf);
                if (!TextUtils.isEmpty(charSequence)) {
                    return null;
                }
                lastIndexOf = charSequence.lastIndexOf("(");
                indexOf = charSequence.lastIndexOf(")");
                if (lastIndexOf >= 0 && indexOf > lastIndexOf + 1 && indexOf < charSequence.length()) {
                    substring = charSequence.substring(lastIndexOf + 1, indexOf);
                    if (!TextUtils.isEmpty(substring)) {
                        charSequence = substring;
                    }
                }
                return charSequence;
            }
        }
        charSequence = null;
        if (!TextUtils.isEmpty(charSequence)) {
            return null;
        }
        lastIndexOf = charSequence.lastIndexOf("(");
        indexOf = charSequence.lastIndexOf(")");
        substring = charSequence.substring(lastIndexOf + 1, indexOf);
        if (TextUtils.isEmpty(substring)) {
            charSequence = substring;
        }
        return charSequence;
    }

    private void c(Notification notification, String str, int i) {
        try {
            if (this.e.bx()) {
                aa.a(this.d);
            }
            if (this.e.bw()) {
                ap.a(this.d).a("red_packet_voice_" + (this.e.by() + 1) + ".mp3");
            }
            if (f.e) {
                b(notification, str);
                com.vlocker.msg.p.a().a(a(notification, 14));
                e.a().c();
                return;
            }
            notification.contentIntent.send();
            com.vlocker.msg.p.a().a(str);
            LockerService.a().a(2);
            e.a().a(notification, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String d(Notification notification) {
        if (notification == null || notification.contentIntent == null) {
            return null;
        }
        String charSequence;
        int indexOf;
        int lastIndexOf;
        CharSequence substring;
        if (!TextUtils.isEmpty(notification.tickerText)) {
            charSequence = notification.tickerText.toString();
            indexOf = charSequence.indexOf(":");
            if (indexOf > 0 && indexOf < charSequence.length()) {
                charSequence = charSequence.substring(0, indexOf);
                if (!TextUtils.isEmpty(charSequence)) {
                    return null;
                }
                lastIndexOf = charSequence.lastIndexOf("(");
                indexOf = charSequence.lastIndexOf(")");
                if (lastIndexOf >= 0 && indexOf > lastIndexOf + 1 && indexOf < charSequence.length()) {
                    substring = charSequence.substring(lastIndexOf, indexOf + 1);
                    if (!TextUtils.isEmpty(substring)) {
                        charSequence = charSequence.replace(substring, "");
                    }
                }
                return charSequence;
            }
        }
        charSequence = null;
        if (!TextUtils.isEmpty(charSequence)) {
            return null;
        }
        lastIndexOf = charSequence.lastIndexOf("(");
        indexOf = charSequence.lastIndexOf(")");
        substring = charSequence.substring(lastIndexOf, indexOf + 1);
        if (TextUtils.isEmpty(substring)) {
            charSequence = charSequence.replace(substring, "");
        }
        return charSequence;
    }

    public ak a(Notification notification, int i) {
        if (i == 13) {
            if (com.vlocker.msg.p.a().b(WXApp.WXAPP_PACKAGE_NAME)) {
                this.j++;
            } else {
                this.j = 1;
            }
            this.h.c = "微信发来" + this.j + "个红包！";
            if (this.j > 1) {
                this.h.e += "等";
            }
            return this.h;
        } else if (i != 14) {
            return null;
        } else {
            if (com.vlocker.msg.p.a().b("com.tencent.mobileqq")) {
                this.k++;
            } else {
                this.k = 1;
            }
            this.i.c = "QQ发来" + this.k + "个红包！";
            if (this.k > 1) {
                this.i.e += "等";
            }
            return this.i;
        }
    }

    public void a(Notification notification, String str) {
        try {
            PendingIntent pendingIntent;
            if (WXApp.WXAPP_PACKAGE_NAME.equals(str)) {
                if (notification != null && notification.contentIntent != null) {
                    pendingIntent = notification.contentIntent;
                    Intent intent = (Intent) pendingIntent.getClass().getMethod("getIntent", new Class[0]).invoke(pendingIntent, new Object[0]);
                    if (intent != null) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            Object obj = extras.get("MainUI_User_Last_Msg_Type");
                            if (obj != null && obj.toString().equals("436207665")) {
                                a(d(notification));
                                a(13);
                                k.a().b();
                                if (!LockerService.a().c()) {
                                    a(notification);
                                } else if (a()) {
                                    this.a = true;
                                    if (!com.vlocker.m.ak.b(this.d)) {
                                        e.a().b(true);
                                    }
                                    com.vlocker.m.ak.a(this.d);
                                    a(notification, str, 13);
                                    this.b = System.currentTimeMillis();
                                    b(notification, str);
                                }
                            }
                        }
                    }
                }
            } else if ("com.tencent.mobileqq".equals(str) && notification != null && notification.contentIntent != null) {
                p.a().b(notification);
                if (b(notification)) {
                    pendingIntent = notification.contentIntent;
                    if (((Intent) pendingIntent.getClass().getMethod("getIntent", new Class[0]).invoke(pendingIntent, new Object[0])) != null) {
                        a(d(notification));
                        a(14);
                        k.a().b();
                        if (!LockerService.a().c()) {
                            a(notification);
                        } else if (a()) {
                            if (!f.e) {
                                this.a = true;
                            }
                            if (!com.vlocker.m.ak.b(this.d)) {
                                e.a().b(true);
                            }
                            com.vlocker.m.ak.a(this.d);
                            b(notification, str, 14);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Notification notification, String str, int i) {
        this.g = false;
        LockerService.a().a(15, i, new b(this, notification, str, i));
    }

    public void b(Notification notification, String str, int i) {
        if (f.e) {
            c(notification, str, i);
            return;
        }
        LockerService.a().a(15, i, new c(this, notification, str, i));
        b(notification, str);
    }
}
