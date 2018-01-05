package com.inveno.a;

import a.f;
import android.content.Context;
import com.inveno.se.f.a;
import java.util.Random;

class av {
    static int a(Context context) {
        int a = f.a(context, "data_sdk", "sid_seq");
        return a <= 0 ? 1 : a;
    }

    static void a(Context context, int i) {
        f.a(context, "data_sdk", "sid_seq", i);
    }

    static int b(Context context) {
        if (c(context)) {
            a.a("DataSDK", "sid已过期");
            int nextInt = new Random().nextInt(1000000000);
            d(context);
            b(context, nextInt);
            a(context, 1);
            return nextInt;
        }
        a.a("DataSDK", "sid未过期");
        return e(context);
    }

    private static void b(Context context, int i) {
        f.a(context, "data_sdk", "sid_name", i);
    }

    private static boolean c(Context context) {
        return System.currentTimeMillis() - f.b(context, "data_sdk", "sid_time") > 30000;
    }

    private static void d(Context context) {
        f.a(context, "data_sdk", "sid_time", System.currentTimeMillis());
    }

    private static int e(Context context) {
        return f.a(context, "data_sdk", "sid_name");
    }
}
