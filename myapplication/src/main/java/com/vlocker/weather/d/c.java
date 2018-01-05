package com.vlocker.weather.d;

import android.os.Message;
import com.vlocker.weather.model.f;

class c implements f {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void a() {
        this.a.g.sendEmptyMessage(2);
    }

    public void a(String str) {
        Message obtainMessage = this.a.g.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.a.g.sendMessage(obtainMessage);
    }
}
