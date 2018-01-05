package com.vlocker.f;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.Toast;

class ag implements Callback {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    public boolean handleMessage(Message message) {
        this.a.b.dismiss();
        Toast.makeText(this.a.a.a, "指纹验证成功", 1).show();
        return false;
    }
}
