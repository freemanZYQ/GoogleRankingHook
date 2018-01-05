package com.vlocker.m;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class ao {
    public static void a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
