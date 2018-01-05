package com.vlocker.ui.widget;

class i implements Runnable {
    final /* synthetic */ MusicLrcView a;

    i(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
    }

    public void run() {
        this.a.l.setAdapter(this.a.C);
        this.a.y.post(this.a.k);
    }
}
