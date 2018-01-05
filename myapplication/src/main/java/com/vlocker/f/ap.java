package com.vlocker.f;

import android.os.Handler.Callback;
import android.os.Message;
import android.widget.Toast;

class ap implements Callback {
    final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    public boolean handleMessage(Message message) {
        this.a.a.dismiss();
        Toast.makeText(this.a.b, "指纹验证成功", 1).show();
        return false;
    }
}
