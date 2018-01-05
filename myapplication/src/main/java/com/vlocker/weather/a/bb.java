package com.vlocker.weather.a;

import android.content.Intent;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.vlocker.notification.msg.open.FlowWebViewActivity;

class bb implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ aw f;

    bb(aw awVar, String str, String str2, String str3, String str4, String str5) {
        this.f = awVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public void run() {
        Intent intent = new Intent(this.f.a, FlowWebViewActivity.class);
        intent.putExtra("url", this.a);
        intent.putExtra("title", this.b);
        intent.putExtra("tag", this.c);
        intent.putExtra("channel", this.d);
        intent.putExtra("channel_category", this.e);
        intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
        intent.addFlags(268435456);
        this.f.a.startActivity(intent);
    }
}
