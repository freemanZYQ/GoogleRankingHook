package com.vlocker.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.LocationClientOption;
import com.vlocker.beans.ThemeItemInfo;
import com.vlocker.i.b;

public class m extends Thread {
    private String a = null;
    private b b = null;
    private String c = null;
    private Handler d = null;
    private ThemeItemInfo e = null;
    private n f = null;
    private int g = 0;

    public m(String str, b bVar, String str2, Handler handler, ThemeItemInfo themeItemInfo) {
        this.a = str;
        this.b = bVar;
        this.c = str2;
        this.d = handler;
        this.e = themeItemInfo;
    }

    public m(String str, b bVar, String str2, Handler handler, ThemeItemInfo themeItemInfo, int i) {
        this.a = str;
        this.b = bVar;
        this.c = str2;
        this.d = handler;
        this.e = themeItemInfo;
        this.g = i;
    }

    public void a() {
        this.f.a = true;
    }

    public void run() {
        super.run();
        this.f = new n();
        Message message;
        long b;
        if (this.g == LocationClientOption.MIN_SCAN_SPAN) {
            message = new Message();
            if (this.a == null || this.a.length() <= 0) {
                message.what = 272;
                this.d.sendMessage(message);
                return;
            }
            b = this.f.b(this.c, this.a, this.b, this.e);
            if (b > 0) {
                message.what = 273;
                this.d.sendMessage(message);
                return;
            } else if (b == -2) {
                message.what = 274;
                this.d.sendMessage(message);
                return;
            } else {
                message.what = 272;
                this.d.sendMessage(message);
                return;
            }
        }
        message = new Message();
        if (this.a == null || this.a.length() <= 0) {
            message.what = 272;
            this.d.sendMessage(message);
            return;
        }
        b = this.f.a(this.c, this.a, this.b, this.e);
        if (b > 0) {
            message.what = 273;
            this.d.sendMessage(message);
        } else if (b == -2) {
            message.what = 274;
            this.d.sendMessage(message);
        } else {
            message.what = 272;
            this.d.sendMessage(message);
        }
    }
}
