package com.vlocker.ui.view;

class ai implements Runnable {
    final /* synthetic */ MaskTextView a;

    ai(MaskTextView maskTextView) {
        this.a = maskTextView;
    }

    public void run() {
        if (this.a.c != null) {
            this.a.e = this.a.e + (((float) MaskTextView.h) * MaskTextView.i);
            this.a.a(this.a.e, 0.0f);
            if (this.a.e < ((float) (this.a.f + (this.a.c.getWidth() / 2)))) {
                MaskTextView.a.postDelayed(this.a.j, (long) MaskTextView.h);
                return;
            }
            this.a.e = (float) ((-this.a.c.getWidth()) / 2);
            MaskTextView.a.postDelayed(this.a.j, (long) MaskTextView.h);
        }
    }
}
