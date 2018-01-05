package com.vlocker.msg.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.moxiu.b.a.a;
import com.vlocker.msg.McmPushWidget;
import com.vlocker.msg.ak;

public class c {
    public static void a(Context context, a aVar) {
        if (aVar != null) {
            ak akVar = new ak();
            akVar.C = 1;
            if (!aVar.f() && "baidu".equals(aVar.C)) {
                akVar.y = true;
            }
            akVar.F = 13;
            akVar.b = "msg_ad";
            akVar.n = aVar.d();
            akVar.c = aVar.h();
            akVar.e = aVar.c();
            akVar.g = System.currentTimeMillis();
            akVar.E = false;
            View view = new View(context);
            view.setLayoutParams(new LayoutParams(200, 200));
            aVar.b(view);
            McmPushWidget.getInstance(context).sendVlickerNotification(context, akVar, null);
        }
    }
}
