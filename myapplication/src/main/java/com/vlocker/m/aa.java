package com.vlocker.m;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;

public class aa {
    public static MediaPlayer a = null;
    public static boolean b = false;

    public static void a(Context context) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            long[] jArr = new long[]{250, 300};
            if (vibrator != null) {
                vibrator.vibrate(jArr, -1);
            }
        } catch (Exception e) {
        }
    }
}
