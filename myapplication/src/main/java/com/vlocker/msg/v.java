package com.vlocker.msg;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.search.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;

public class v {
    private static v c;
    private Context a;
    private a b = a.a(this.a);
    private VlockerMsg d;

    public v(Context context) {
        this.a = context;
    }

    public static synchronized v a(Context context) {
        v vVar;
        synchronized (v.class) {
            if (c == null) {
                c = new v(context);
            }
            vVar = c;
        }
        return vVar;
    }

    public void a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this.d);
            this.b.P(new String(o.a(byteArrayOutputStream.toByteArray())));
        } catch (IOException e) {
        }
    }

    public void a(int i) {
        if (i > this.b.dg()) {
            this.b.af(i);
        }
    }

    public void a(String str, boolean z, String str2) {
        if (this.d == null) {
            this.d = new VlockerMsg();
        }
        if (str.startsWith("msg_ad")) {
            this.d.b(this.d.b() + 1);
        } else if ("mx_ad".equals(str)) {
            this.d.c(this.d.c() + 1);
        } else if ("mx_clean".equals(str)) {
            this.d.d(this.d.d() + 1);
        } else if (str.contains("121") || str.contains("122") || str.contains("123")) {
            this.d.e(this.d.e() + 1);
        } else if (str2 != null && str2.equals("vlocker.MyWeather")) {
            this.d.f(this.d.g() + 1);
        } else if ("weather_news".equals(str)) {
            this.d.g(this.d.h() + 1);
        } else if (str.contains("red_packet")) {
            this.d.h(this.d.i() + 1);
        } else if (z) {
            this.d.a(this.d.a() + 1);
        } else if ("com.tencent.mobileqq".equals(str)) {
            this.d.i(this.d.j() + 1);
        } else if (WXApp.WXAPP_PACKAGE_NAME.equals(str)) {
            this.d.j(this.d.k() + 1);
        } else if ("com.sina.weibo".equals(str)) {
            this.d.k(this.d.l() + 1);
        } else if ("com.qzone".equals(str)) {
            this.d.l(this.d.m() + 1);
        } else if ("com.immomo.momo".equals(str)) {
            this.d.m(this.d.n() + 1);
        } else {
            this.d.n(this.d.o() + 1);
        }
    }

    public VlockerMsg b() {
        try {
            VlockerMsg vlockerMsg;
            try {
                vlockerMsg = (VlockerMsg) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(this.b.df().getBytes(), 0))).readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                vlockerMsg = null;
            }
            return vlockerMsg;
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void c() {
        p.a(this.a, "Vlocker_Show_MaxMsgCount_PPC_RR", "count", this.b.dg() + "");
        VlockerMsg b = b();
        if (b != null) {
            if (b.a() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "Push", "count", b.a() + "");
            }
            if (b.b() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "MsgAd", "count", b.b() + "");
            }
            if (b.c() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "BatteryAd", "count", b.c() + "");
            }
            if (b.d() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "BatteryClean", "count", b.d() + "");
            }
            if (b.e() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "Repair", "count", b.e() + "");
            }
            if (b.f() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "Finger", "count", b.f() + "");
            }
            if (b.g() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "WeatherAlarm", "count", b.g() + "");
            }
            if (b.h() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "Information", "count", b.h() + "");
            }
            if (b.i() > 0) {
                p.a(this.a, "Vlocker_Show_MXMsgCount_PPC_RR", "name", "RedPacket", "count", b.i() + "");
            }
            if (b.j() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "Qq", "count", b.j() + "");
            }
            if (b.k() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "WeChat", "count", b.k() + "");
            }
            if (b.l() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "Weibo", "count", b.l() + "");
            }
            if (b.m() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "Qzone", "count", b.m() + "");
            }
            if (b.n() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "Momo", "count", b.n() + "");
            }
            if (b.o() > 0) {
                p.a(this.a, "Vlocker_Show_OtherMsgCount_PPC_RR", "name", "Other", "count", b.o() + "");
            }
            this.d = null;
            this.b.af(0);
            this.b.P("");
        }
    }
}
