package com.vlocker.settings;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.msg.as;

class bx implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ PasswordSettingsActivity b;

    bx(PasswordSettingsActivity passwordSettingsActivity, Dialog dialog) {
        this.b = passwordSettingsActivity;
        this.a = dialog;
    }

    public void onClick(View view) {
        Intent a = as.a(this.b, "http://mp.weixin.qq.com/s?__biz=MzA3NjA5OTY2MA==&mid=2650756176&idx=1&sn=5fe989fd8a287a5426c1de325db81f74");
        a.setFlags(268435456);
        this.b.startActivity(a);
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
