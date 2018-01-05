package com.vlocker.theme.model.a;

import com.vlocker.theme.b.a;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.i;

public class c extends Thread {
    private String a = null;
    private i b = null;
    private String c = null;
    private T_ThemeItemInfo d = null;
    private g e = null;
    private a f;

    public c(String str, i iVar, String str2, a aVar, T_ThemeItemInfo t_ThemeItemInfo) {
        this.a = str;
        this.b = iVar;
        this.c = str2;
        this.f = aVar;
        this.d = t_ThemeItemInfo;
    }

    public void a() {
        if (this.e != null) {
            this.e.a = true;
        }
    }

    public void run() {
        int i = 272;
        super.run();
        this.e = new g();
        if (this.a != null && this.a.length() > 0) {
            long a = this.e.a(this.c, this.a, this.b, this.d);
            if (a > 0) {
                i = 273;
            } else if (a == -2) {
                i = 274;
            } else if (a == -4) {
                i = 4493;
            } else if (a == -3) {
                i = 4509;
            }
        }
        if (this.f != null) {
            this.f.a(i);
        }
    }
}
