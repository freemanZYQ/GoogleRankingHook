package com.baidu.mobads.openad.c;

import com.baidu.mobads.j.m;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;

class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        try {
            if (this.a.c.g == DownloadStatus.CANCELLED) {
                b.a.cancel(this.a.c.f);
                return;
            }
            b.a.notify(this.a.c.f, this.a.d());
            if (this.a.c.g == DownloadStatus.ERROR) {
                m.a().f().d("OAdApkDownloaderObserver", "status >> error");
            } else if (this.a.c.g == DownloadStatus.INITING && this.a.c.q == 1) {
                this.a.d("开始下载 " + this.a.c.a);
            }
        } catch (Throwable e) {
            m.a().f().d("OAdApkDownloaderObserver", e);
        }
    }
}
