package com.vlocker.ui.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.qq.e.comm.constants.ErrorCode.AdError;

class bb extends Scroller {
    final /* synthetic */ V2GuideBannerView a;
    private int b = AdError.PLACEMENT_ERROR;

    public bb(V2GuideBannerView v2GuideBannerView, Context context, Interpolator interpolator) {
        this.a = v2GuideBannerView;
        super(context, interpolator);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.b);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.b);
    }
}
