package com.moxiu.b.d;

import android.content.Context;
import android.text.TextUtils;
import com.moxiu.b.a.a;
import com.moxiu.b.c.r;

public class f {
    public static String a(int i, Context context, a aVar) {
        String str = "";
        switch (i) {
            case 0:
                str = a.f(context);
                break;
            case 1:
                str = a.g(context);
                break;
            case 2:
                str = a.h(context);
                break;
            case 3:
                str = a.i(context);
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        str = c.b(context);
        stringBuffer.append("&adid=").append(aVar.B);
        stringBuffer.append("&adsid=").append(aVar.H);
        stringBuffer.append("&type=").append(aVar.C);
        stringBuffer.append("&subtype=").append(aVar.D);
        stringBuffer.append("&source=").append(aVar.P);
        stringBuffer.append("&package=").append(aVar.l());
        stringBuffer.append("&click=").append(aVar.t());
        stringBuffer.append("&title=").append(aVar.u());
        stringBuffer.append("&summary=").append(aVar.v());
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static void b(int i, Context context, a aVar) {
        try {
            if (!TextUtils.isEmpty(aVar.B) && !TextUtils.isEmpty(aVar.H) && !TextUtils.isEmpty(aVar.C) && !TextUtils.isEmpty(aVar.P)) {
                new r().b(a(i, context, aVar), new g());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
