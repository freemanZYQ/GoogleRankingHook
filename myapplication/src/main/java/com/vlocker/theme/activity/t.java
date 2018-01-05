package com.vlocker.theme.activity;

import com.xinmei365.fontsdk.callback.IHttpCallBack;
import java.util.ArrayList;

class t implements IHttpCallBack {
    final /* synthetic */ UnlockTextEditActivity a;

    t(UnlockTextEditActivity unlockTextEditActivity) {
        this.a = unlockTextEditActivity;
    }

    public void a(ArrayList arrayList) {
        this.a.a(arrayList, true);
        this.a.i.a(this.a.j);
        this.a.j();
    }

    public void onErr(int i, String str) {
        this.a.a(null, false);
        this.a.i.a(this.a.j);
        this.a.j();
    }

    public /* synthetic */ void onSuccess(Object obj) {
        a((ArrayList) obj);
    }
}
