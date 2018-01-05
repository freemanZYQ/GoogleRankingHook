package com.vlocker.weather.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.weather.a;
import com.vlocker.weather.e.d;

class az implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ aw f;

    az(aw awVar, String str, String str2, String str3, String str4, String str5) {
        this.f = awVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public void onClick(View view) {
        d.b(this.f.a, this.a, this.b);
        a.a(this.f.a);
        this.f.a(this.c, this.d, "weather_webview", this.a, this.b, this.e);
    }
}
