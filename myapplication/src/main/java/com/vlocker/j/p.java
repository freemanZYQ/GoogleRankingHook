package com.vlocker.j;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.text.TextUtils;
import java.util.ArrayList;

public class p {
    private static p b;
    private ArrayList a = new ArrayList();

    private p() {
        this.a.add("com.tencent.qqmusic");
        this.a.add("com.kugou.android");
        this.a.add("cn.kuwo.player");
        this.a.add("com.meizu.media.music");
        this.a.add("com.sds.android.ttpod");
        this.a.add("fm.xiami.main");
        this.a.add("com.miui.player");
        this.a.add("com.ximalaya.ting.android");
        this.a.add("com.ting.mp3.android");
        this.a.add("com.android.mediacenter");
        this.a.add("com.duomi.android");
    }

    public static p a() {
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    b = new p();
                }
            }
        }
        return b;
    }

    @SuppressLint({"NewApi"})
    public static boolean a(Notification notification, String str) {
        if (notification != null) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            if ("com.android.bbkmusic".equals(str)) {
                if (notification.flags == 2) {
                    return true;
                }
            } else if ("com.meizu.media.music".equals(str)) {
                if (notification.flags == 0) {
                    return true;
                }
                if (notification.flags == 32) {
                    return true;
                }
            } else if (notification.flags == 98) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        return str == null || str.contains("点击") || str.contains("桌面") || str.contains("歌词") || str.contains("正在运行") || str.contains("“音乐”正在运行") || str.contains("触摸即可了解详情或停止应用。") || str.contains("下载");
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || "cmccwm.mobilemusic".equals(str)) ? false : str.contains("music") ? true : this.a.contains(str);
    }
}
