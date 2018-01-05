package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class cg implements OnClickListener {
    final /* synthetic */ RedPacketActivity a;

    cg(RedPacketActivity redPacketActivity) {
        this.a = redPacketActivity;
    }

    public void onClick(View view) {
        this.a.f.dismiss();
    }
}
