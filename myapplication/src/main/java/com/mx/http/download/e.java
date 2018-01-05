package com.mx.http.download;

class e extends Thread {
    final /* synthetic */ DownloadService a;
    private final /* synthetic */ a b;

    e(DownloadService downloadService, a aVar) {
        this.a = downloadService;
        this.b = aVar;
    }

    public void run() {
        this.a.e = true;
        this.a.b(this.b);
        this.a.e = false;
    }
}
