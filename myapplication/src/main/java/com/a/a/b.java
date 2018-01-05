package com.a.a;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

class b extends o {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, int i2, int i3) {
        Log.i(a.c, " onMessage--------what  " + i);
        this.a.g.sendMessage(this.a.g.obtainMessage(i, i2, i3));
    }

    public void a(int i, int i2, int i3, Bundle bundle) {
        Message obtainMessage = this.a.g.obtainMessage(i, i2, i3);
        obtainMessage.setData(bundle);
        this.a.g.sendMessage(obtainMessage);
    }

    public void a(int i, int i2, int[] iArr) {
        Message obtainMessage = this.a.g.obtainMessage(i, i2, 0);
        switch (i) {
            case 11:
                a.k.putIntArray("lastTouch", iArr);
                obtainMessage.setData(a.k);
                break;
            case 12:
                a.k.putIntArray("nextTouch", iArr);
                obtainMessage.setData(a.k);
                break;
            case 13:
                a.k.putIntArray("maskList", iArr);
                a.k.putInt("maskNumber", i2);
                obtainMessage.setData(a.k);
                break;
        }
        this.a.g.sendMessage(obtainMessage);
    }
}
