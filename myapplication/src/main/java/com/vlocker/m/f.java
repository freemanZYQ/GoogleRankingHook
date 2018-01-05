package com.vlocker.m;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public final class f {
    public static Bitmap a(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int ceil = (int) Math.ceil((double) (((float) options.outWidth) / ((float) i)));
        int ceil2 = (int) Math.ceil((double) (((float) options.outHeight) / ((float) i2)));
        if (ceil > 1 && ceil2 > 1) {
            if (ceil > ceil2) {
                options.inSampleSize = ceil;
            } else {
                options.inSampleSize = ceil2;
            }
        }
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Config.RGB_565;
        return BitmapFactory.decodeFile(str, options);
    }
}
