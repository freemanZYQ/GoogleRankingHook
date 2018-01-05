package com.vlocker.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vlocker.msg.an;

class h extends BroadcastReceiver {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a.q.ap()) {
            String action = intent.getAction();
            this.a.E = System.currentTimeMillis();
            if (!an.c(this.a.c) && "android.intent.action.SCREEN_ON".equals(action)) {
                this.a.i();
            }
            if ("com.tencent.qqmusic.ACTION_META_CHANGED.QQMusicPhone".equals(action)) {
                this.a.y();
            } else if ("com.miui.player.playstatechanged".equals(action)) {
                this.a.b(intent);
            } else if ("com.android.music.metachanged".equals(action) || "com.kugou.android.music.playstatechanged".equals(action)) {
                if ("com.kugou.android.music.playstatechanged".equals(action)) {
                    a.e.a = "com.kugou.android";
                    this.a.o = "com.kugou.android";
                }
                this.a.a(intent);
            }
        }
    }
}
