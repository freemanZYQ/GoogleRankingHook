package com.vlocker.ui.view;

class ac implements Runnable {
    final /* synthetic */ MaskImageView a;

    ac(MaskImageView maskImageView) {
        this.a = maskImageView;
    }

    public void run() {
        if (this.a.d != null && this.a.e != null) {
            this.a.g = this.a.g + (((float) MaskImageView.m) * MaskImageView.n);
            this.a.a(this.a.g, 0.0f);
            if (this.a.g < ((float) (this.a.h + (this.a.e.getWidth() / 2)))) {
                MaskImageView.b.postDelayed(this.a.o, (long) MaskImageView.m);
                return;
            }
            this.a.g = (float) ((-this.a.e.getWidth()) / 2);
            MaskImageView.b.postDelayed(this.a.o, (long) MaskImageView.m);
        }
    }
}
