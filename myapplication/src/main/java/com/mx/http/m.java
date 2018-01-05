package com.mx.http;

import android.content.Intent;
import android.os.Bundle;
import com.mx.http.download.DownloadService;
import java.io.IOException;
import java.util.Iterator;

class m implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ g b;

    m(l lVar, g gVar) {
        this.a = lVar;
        this.b = gVar;
    }

    public void run() {
        Exception e;
        while (true) {
            try {
                j jVar = (j) this.a.a.take();
                this.a.b.put(jVar);
                Iterator it = this.a.b.iterator();
                while (it.hasNext()) {
                    j jVar2 = (j) it.next();
                    if (jVar2.h() || jVar2.b()) {
                        this.a.b.remove(jVar2);
                    }
                }
                if (jVar.d()) {
                    b bVar = (b) jVar;
                    Intent intent = new Intent(jVar.c(), DownloadService.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("itemdata", bVar.a());
                    intent.putExtras(bundle);
                    jVar.c().startService(intent);
                } else {
                    this.a.e.a(jVar, this.b);
                }
            } catch (InterruptedException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
        }
        e.printStackTrace();
    }
}
