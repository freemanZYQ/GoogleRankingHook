package com.vlocker.m;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

class aq implements OnLoadCompleteListener {
    final /* synthetic */ ap a;

    aq(ap apVar) {
        this.a = apVar;
    }

    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        if (this.a.e != null) {
            this.a.e.a();
        }
    }
}
