package com.xinmei365.fontsdk.callback;

import android.graphics.Typeface;
import com.xinmei365.fontsdk.bean.FailureInfo;

public interface FontTypefaceCallBack {
    void onFailure(FailureInfo failureInfo);

    void onSuccess(String str, Typeface typeface);
}
