package com.vlocker.weather.view;

import com.vlocker.locker.R;

class i implements Runnable {
    final /* synthetic */ OverScrollView a;

    i(OverScrollView overScrollView) {
        this.a = overScrollView;
    }

    public void run() {
        int scrollY = this.a.getScrollY() + this.a.getHeight();
        if (((float) this.a.getChildAt(0).getMeasuredHeight()) - this.a.getResources().getDimension(R.dimen.t_market_album_margin_2) <= ((float) scrollY)) {
            this.a.c = Math.max(100, this.a.c);
        } else if (scrollY >= (this.a.getChildAt(0).getMeasuredHeight() * 3) / 4) {
            this.a.c = Math.max(75, this.a.c);
        } else if (scrollY >= this.a.getChildAt(0).getMeasuredHeight() / 2) {
            this.a.c = Math.max(50, this.a.c);
        } else if (scrollY >= this.a.getChildAt(0).getMeasuredHeight() / 3) {
            this.a.c = Math.max(33, this.a.c);
        } else if (scrollY >= this.a.getChildAt(0).getMeasuredHeight() / 4) {
            this.a.c = Math.max(25, this.a.c);
        }
    }
}
