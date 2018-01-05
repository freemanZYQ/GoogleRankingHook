package com.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mx.http.download.a;

class c extends BroadcastReceiver {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("com.moxiu.http.action.promotion.filedownload.downloading".equals(intent.getAction())) {
                    a aVar = (a) intent.getSerializableExtra("itemdata");
                    com.moxiu.b.d.c.a("download353", "receiver adid-->" + this.a.B + " receive-->" + aVar.j() + " package-->" + aVar.c());
                    if (aVar != null) {
                        try {
                            if (this.a.b != null && this.a.b.equals(aVar.c())) {
                                switch (intent.getIntExtra("type", -1)) {
                                    case 9001:
                                        this.a.y = 16;
                                        com.moxiu.b.d.c.a("download353", "cancel");
                                        if (this.a.W != null) {
                                            context.unregisterReceiver(this.a.W);
                                            this.a.W = null;
                                            return;
                                        }
                                        return;
                                    case 9002:
                                        this.a.y = 8;
                                        com.moxiu.b.d.c.a("download353", "finish");
                                        if (this.a.W != null) {
                                            context.unregisterReceiver(this.a.W);
                                            this.a.W = null;
                                            return;
                                        }
                                        return;
                                    case 9003:
                                        this.a.y = 3;
                                        com.moxiu.b.d.c.a("download353", "pause");
                                        return;
                                    case 9004:
                                        this.a.y = 16;
                                        com.moxiu.b.d.c.a("download353", "fail");
                                        if (this.a.W != null) {
                                            context.unregisterReceiver(this.a.W);
                                            this.a.W = null;
                                            return;
                                        }
                                        return;
                                    case 9005:
                                        this.a.x = 0;
                                        com.moxiu.b.d.c.a("download353", "start");
                                        Toast.makeText(context, "开始下载", 0).show();
                                        return;
                                    case 9006:
                                        this.a.x = (int) aVar.x();
                                        this.a.y = 4;
                                        com.moxiu.b.d.c.a("download353", "downloading-->" + this.a.x);
                                        return;
                                    case 9007:
                                        com.moxiu.b.d.c.a("download353", "9007");
                                        return;
                                    default:
                                        return;
                                }
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
