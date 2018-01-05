package com.vlocker.theme.model.a;

import android.content.Intent;
import com.vlocker.theme.b.a;

class e implements a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void a(int i) {
        switch (i) {
            case 272:
                this.a.b = f.Err;
                break;
            case 273:
                this.a.b = f.DownloadNotInstall;
                Intent intent = new Intent();
                intent.setAction("DOWNLOADTHREAD_DOWNLOAD_DONE");
                this.a.e.sendBroadcast(intent);
                break;
            case 274:
                this.a.b = f.Pause;
                break;
            case 275:
                this.a.b = f.Err;
                break;
            case 4493:
                this.a.b = f.Err;
                break;
            case 4509:
                this.a.b = f.Err;
                break;
        }
        if (this.a.g != null) {
            this.a.g.a(i);
        }
    }
}
