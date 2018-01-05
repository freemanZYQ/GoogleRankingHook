package com.vlocker.ui.widget;

class h implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ MusicLrcView b;

    h(MusicLrcView musicLrcView, boolean z) {
        this.b = musicLrcView;
        this.a = z;
    }

    public void run() {
        int i = 0;
        this.b.l.setVisibility(this.a ? 0 : 4);
        AlwaysMarqueeTextView f = this.b.o;
        if (this.a) {
            i = 8;
        }
        f.setVisibility(i);
    }
}
