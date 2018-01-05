package com.inveno.se.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebSettings;

@TargetApi(17)
class f {
    static String a(Context context) {
        try {
            return WebSettings.getDefaultUserAgent(context);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
