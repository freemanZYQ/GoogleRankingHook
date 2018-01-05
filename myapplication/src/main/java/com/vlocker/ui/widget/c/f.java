package com.vlocker.ui.widget.c;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class f {
    public static InputStream a(String str) {
        try {
            return new FileInputStream(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public d a(Context context, String str) {
        c cVar = new c();
        InputStream a = a((context.getFilesDir().getPath() + "/theme/" + str + "/") + "widgetcontrol.xml");
        return a != null ? cVar.a(a) : null;
    }
}
