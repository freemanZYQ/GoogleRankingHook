package com.baidu.mobads.h;

import android.util.Log;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

class m implements IOAdEventListener {
    final /* synthetic */ double a;
    final /* synthetic */ l b;

    m(l lVar, double d) {
        this.b = lVar;
        this.a = d;
    }

    public void run(IOAdEvent iOAdEvent) {
        boolean z = true;
        this.b.a.b.l();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.b.a.b.j = new e((String) iOAdEvent.getData().get(b.EVENT_MESSAGE));
            double a = com.baidu.mobads.a.b.a();
            float f = this.b.a.b.j().getFloat("__badApkVersion__8.23", 0.0f);
            Boolean valueOf = Boolean.valueOf(((float) this.b.a.b.j.b()) == f);
            if (a >= this.b.a.b.j.b() || Math.floor(a) != Math.floor(this.b.a.b.j.b())) {
                z = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z);
            Log.i("XAdApkLoader", "try to download apk badVer=" + f + ", isBad=" + valueOf + ", compatible=" + valueOf2);
            if (this.a < this.b.a.b.j.b() && this.b.a.b.j != null && this.b.a.b.j.a().booleanValue() && valueOf2.booleanValue() && !valueOf.booleanValue()) {
                this.b.a.b.a(this.b.a.b.j);
            }
        }
    }
}
