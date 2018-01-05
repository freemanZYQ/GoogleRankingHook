package com.vlocker.ui.view;

class ag implements Runnable {
    final /* synthetic */ MaskImageView a;

    ag(MaskImageView maskImageView) {
        this.a = maskImageView;
    }

    public void run() {
        this.a.e();
        this.a.p.start();
    }
}
