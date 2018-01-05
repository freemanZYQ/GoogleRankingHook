package com.vlocker.f;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.Toast;

class y implements Callback {
    final /* synthetic */ x a;

    y(x xVar) {
        this.a = xVar;
    }

    public boolean handleMessage(Message message) {
        this.a.b.dismiss();
        Toast.makeText(this.a.d.b, "指纹验证成功", 1).show();
        return true;
    }
}
