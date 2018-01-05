package com.c.a.c;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.c.a.c.a.a;
import com.c.a.k.d;

class c implements Callback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public boolean handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 11802:
                    a aVar = new a();
                    Bundle data = message.getData();
                    if (data != null) {
                        aVar.a = "true".equals(data.getString("result"));
                        if (aVar.a) {
                            aVar.b = data.getString("mixedNick");
                            aVar.c = data.getString("icon");
                            if (this.a.d != null) {
                                this.a.d.a(aVar);
                            }
                        } else if (this.a.d != null) {
                            this.a.d.a();
                        }
                        Log.d("AppLink", aVar.toString());
                    } else if (this.a.d != null) {
                        this.a.d.a();
                    }
                    this.a.d = null;
                    break;
            }
            if (d.a() != null) {
                d.a().unbindService(b.a);
            }
        }
        return false;
    }
}
