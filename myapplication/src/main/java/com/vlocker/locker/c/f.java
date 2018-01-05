package com.vlocker.locker.c;

import android.graphics.Typeface;
import com.xinmei365.fontsdk.bean.FailureInfo;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;

class f implements FontTypefaceCallBack {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public void onFailure(FailureInfo failureInfo) {
        this.a.u.setTypeface(null);
    }

    public void onSuccess(String str, Typeface typeface) {
        this.a.u.setTypeface(typeface);
    }
}
