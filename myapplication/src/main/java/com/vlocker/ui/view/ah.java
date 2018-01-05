package com.vlocker.ui.view;

class ah implements Runnable {
    final /* synthetic */ MaskImageView a;

    ah(MaskImageView maskImageView) {
        this.a = maskImageView;
    }

    public void run() {
        this.a.f();
        this.a.q.start();
    }
}
