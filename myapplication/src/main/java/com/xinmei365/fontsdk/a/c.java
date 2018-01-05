package com.xinmei365.fontsdk.a;

import android.database.Cursor;
import android.net.Uri;
import com.xinmei365.fontsdk.FontCenter;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.c.f;

public class c {
    public static final Uri aa = Uri.parse("content://com.ningso.easyfont.provider/authfont");

    public static boolean p(String str) {
        try {
            e.a("fontId: " + str + "key " + f.A(str + FontCenter.context.getPackageName()));
            Cursor query = FontCenter.context.getContentResolver().query(aa, new String[]{"_key", "value"}, "_key=?", new String[]{r5}, null);
            if (query != null) {
                boolean z = query.getCount() > 0;
                query.close();
                return z;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean q(String str) {
        String A = f.A(str + FontCenter.context.getPackageName());
        int delete = FontCenter.context.getContentResolver().delete(aa, "_key=?", new String[]{A, str, FontCenter.context.getPackageName()});
        e.a("fontId: " + str + "result: " + delete);
        return delete > 0;
    }
}
