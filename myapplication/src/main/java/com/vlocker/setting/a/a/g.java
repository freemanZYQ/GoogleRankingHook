package com.vlocker.setting.a.a;

import com.vlocker.setting.a.a;

final class g {
    final /* synthetic */ e a;
    private String b;
    private boolean c;
    private boolean d;

    private g(e eVar, String str) {
        this.a = eVar;
        this.b = null;
        this.c = false;
        this.d = false;
        this.b = str;
    }

    public b getAction() {
        return a.getInstance().getSettingAction(this.b);
    }

    public void init() {
        this.c = false;
        this.d = false;
    }
}
