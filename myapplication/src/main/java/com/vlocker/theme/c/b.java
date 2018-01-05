package com.vlocker.theme.c;

import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.xinmei365.fontsdk.bean.Font;

public class b {
    private Font a;
    private int b;

    public b(int i, Font font) {
        this.b = i;
        this.a = font;
    }

    private String a(int i) {
        int i2 = R.string.unlock_edit_font_item_default;
        switch (i) {
            case 3:
                i2 = R.string.unlock_edit_font_item_network;
                break;
            case 4:
                i2 = R.string.unlock_edit_font_item_ad;
                break;
        }
        return MoSecurityApplication.a().getString(i2);
    }

    public Font a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.b == 2 ? this.a.getFontName() : a(this.b);
    }
}
