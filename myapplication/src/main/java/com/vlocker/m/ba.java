package com.vlocker.m;

import android.content.Context;
import android.graphics.Typeface;
import com.vlocker.c.a;
import java.io.File;
import java.util.Hashtable;

public class ba {
    private static final Hashtable a = new Hashtable();

    public static Typeface a(Context context, String str, boolean z) {
        Typeface typeface;
        synchronized (a) {
            if (!a.containsKey(str)) {
                Object createFromFile;
                if (z) {
                    try {
                        String o = a.a(context).o();
                        if (o != null) {
                            File file = new File(context.getFilesDir().getPath() + "/theme/" + o + "/" + str);
                            if (file.exists()) {
                                createFromFile = Typeface.createFromFile(file);
                            }
                        }
                        createFromFile = null;
                    } catch (Exception e) {
                        return null;
                    }
                }
                createFromFile = Typeface.createFromAsset(context.getAssets(), str);
                if (createFromFile != null) {
                    a.put(str, createFromFile);
                }
            }
            typeface = (Typeface) a.get(str);
        }
        return typeface;
    }
}
