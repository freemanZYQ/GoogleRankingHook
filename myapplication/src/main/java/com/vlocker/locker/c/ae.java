package com.vlocker.locker.c;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ae implements OnClickListener {
    final /* synthetic */ b a;

    ae(b bVar) {
        this.a = bVar;
    }

    public void onClick(View view) {
        this.a.a.sendBroadcast(new Intent("com.vlocker.action_sharetheme"));
    }
}
