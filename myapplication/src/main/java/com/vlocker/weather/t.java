package com.vlocker.weather;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.b.p;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.search.ap;

class t implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ r d;

    t(r rVar, int i, String str, String str2) {
        this.d = rVar;
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        String str = "weatherLocal";
        if (this.a == 1) {
            str = "todayWeather";
        } else if (this.a == 2) {
            str = "calendarWeather";
        } else if (this.a == 3) {
            str = "weatherAlarm";
        }
        Intent intent = new Intent(this.d.b, FlowWebViewActivity.class);
        intent.putExtra("url", this.b);
        intent.putExtra("title", "");
        intent.putExtra("tag", "search_weather");
        intent.putExtra("hotkey", "" + this.d.c());
        intent.putExtra("from", str);
        intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.addFlags(268435456);
        this.d.b.startActivity(intent);
        CharSequence d = ap.d(this.d.b);
        if (TextUtils.isEmpty(d)) {
            d = "default";
        }
        p.a(this.d.b, "Vlock_Done_Search_PPC_TF", "word", this.c, "search_engine", d, "from", str);
    }
}
