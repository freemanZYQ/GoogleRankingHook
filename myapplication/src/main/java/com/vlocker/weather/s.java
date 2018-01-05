package com.vlocker.weather;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.b.p;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.search.ap;

class s implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ r c;

    s(r rVar, String str, String str2) {
        this.c = rVar;
        this.a = str;
        this.b = str2;
    }

    public void run() {
        Intent intent = new Intent(this.c.b, FlowWebViewActivity.class);
        intent.putExtra("url", this.a);
        intent.putExtra("title", "");
        intent.putExtra("tag", "search_weather");
        intent.putExtra("hotkey", "" + this.c.c());
        intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.addFlags(268435456);
        this.c.b.startActivity(intent);
        CharSequence d = ap.d(this.c.b);
        if (TextUtils.isEmpty(d)) {
            d = "default";
        }
        p.a(this.c.b, "Vlock_Done_Search_PPC_TF", "word", this.b, "search_engine", d, "from", "outWeather");
    }
}
