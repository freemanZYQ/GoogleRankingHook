package com.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;

class f extends Handler {
    final /* synthetic */ a a;

    public f(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        boolean z = true;
        Log.i(a.c, "Message     what  " + message.what);
        switch (message.what) {
            case 1:
                if (this.a.h != null) {
                    this.a.h.a();
                }
                if (this.a.n != null) {
                    this.a.n.a(1, this.a.b);
                    return;
                }
                return;
            case 2:
                if (this.a.h != null) {
                    this.a.h.b();
                }
                if (this.a.i != null) {
                    sendMessageDelayed(obtainMessage(26), 3000);
                }
                if (this.a.n != null) {
                    this.a.n.a(2, this.a.b);
                    removeMessages(21);
                    return;
                }
                return;
            case 3:
                if (this.a.h != null) {
                    this.a.h.c();
                }
                if (this.a.i != null) {
                    removeMessages(26);
                }
                if (this.a.n != null) {
                    this.a.n.a(3, this.a.b);
                    return;
                }
                return;
            case 4:
                if (this.a.i == null) {
                    return;
                }
                return;
            case 5:
                if (this.a.i != null) {
                    this.a.i.a(message.arg1);
                    if (this.a.d) {
                        this.a.d = false;
                        this.a.i = null;
                        return;
                    }
                    return;
                }
                return;
            case 6:
                if (this.a.j != null) {
                    l e = this.a.j;
                    int i = message.arg1;
                    if (message.arg2 != 1) {
                        z = false;
                    }
                    e.a(i, z);
                }
                if (this.a.n != null) {
                    this.a.n.a(6, message.arg1, this.a.b);
                    return;
                }
                return;
            case 7:
                if (this.a.j != null) {
                    this.a.j.a();
                }
                if (this.a.n != null) {
                    this.a.n.a(7, message.arg1, this.a.b);
                    return;
                }
                return;
            case 8:
                if (this.a.i != null) {
                    this.a.i.a();
                    return;
                }
                return;
            case 10:
                if (this.a.i != null) {
                    this.a.g();
                    return;
                }
                return;
            case 11:
                if (this.a.i != null) {
                    a.l.putIntArray("lastTouch", message.getData().getIntArray("lastTouch"));
                    return;
                }
                return;
            case 12:
                if (this.a.i != null) {
                    a.l.putIntArray("nextTouch", message.getData().getIntArray("nextTouch"));
                    return;
                }
                return;
            case 13:
                if (this.a.i != null) {
                    a.l.putIntArray("maskList", message.getData().getIntArray("maskList"));
                    a.l.putInt("maskNumber", message.arg1);
                    return;
                }
                return;
            case IMediaObject.TYPE_OLD_TV /*14*/:
                if (this.a.i != null) {
                    a.l.putInt("acceptance", message.arg1);
                    a.l.putInt("reject_reason", message.arg2);
                    return;
                }
                return;
            case 15:
                if (this.a.i != null) {
                    a.l.putInt("immobile", message.arg1);
                    return;
                }
                return;
            case 16:
                if (this.a.i != null) {
                    a.l.putInt("next_direction", message.arg1);
                    return;
                }
                return;
            case IMediaObject.TYPE_LOCATION_SHARE /*17*/:
                if (this.a.i != null) {
                    a.l.putInt("progress", message.arg1);
                    if (message.arg1 == 100) {
                        this.a.d = true;
                        return;
                    }
                    return;
                }
                return;
            case 18:
                if (this.a.i != null) {
                    a.l.putInt("stitched", message.arg1);
                    return;
                }
                return;
            case IMediaObject.TYPE_RECORD /*19*/:
                if (this.a.h != null) {
                    this.a.h.a(message.arg1);
                }
                if (this.a.n != null) {
                    this.a.n.a(19, message.arg1, this.a.b);
                    return;
                }
                return;
            case 21:
                if (this.a.n != null) {
                    this.a.n.a(21, message.arg1, this.a.b);
                    return;
                }
                return;
            case 24:
                if (this.a.n != null) {
                    this.a.n.a(24, message.arg1, this.a.b);
                    return;
                }
                return;
            case 26:
                if (this.a.i != null) {
                    this.a.i.b();
                    return;
                }
                return;
            case 30:
                if (this.a.m != null) {
                    Log.d(a.c, " MSG_DELETE_RESULT    msg.arg1:  " + message.arg1);
                    d h = this.a.m;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    h.a(z);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
