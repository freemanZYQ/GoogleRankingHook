package com.vlocker.ui.widget;

import com.qq.e.comm.constants.ErrorCode.AdError;

class m implements Runnable {
    final /* synthetic */ MusicLrcView a;

    m(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
    }

    public void run() {
        if (MusicLrcView.a) {
            if (this.a.i.size() > 0 && this.a.x && !MusicLrcView.b && System.currentTimeMillis() - this.a.h > 2000) {
                this.a.l.smoothScrollToPositionFromTop(this.a.getIndex(), 0, AdError.PLACEMENT_ERROR);
            }
            this.a.C.notifyDataSetChanged();
            this.a.y.postDelayed(this.a.k, 500);
        }
    }
}
