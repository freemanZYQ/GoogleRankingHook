package com.vlocker.theme.activity;

import android.graphics.Typeface;
import com.xinmei365.fontsdk.bean.FailureInfo;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;

class s implements FontTypefaceCallBack {
    final /* synthetic */ UnlockTextEditActivity a;

    s(UnlockTextEditActivity unlockTextEditActivity) {
        this.a = unlockTextEditActivity;
    }

    public void onFailure(FailureInfo failureInfo) {
    }

    public void onSuccess(String str, Typeface typeface) {
        this.a.g.setTypeface(typeface);
    }
}
