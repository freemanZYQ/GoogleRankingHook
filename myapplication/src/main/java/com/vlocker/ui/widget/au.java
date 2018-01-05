package com.vlocker.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class au implements OnClickListener {
    final /* synthetic */ V2GuideBannerView a;

    au(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void onClick(View view) {
        this.a.s();
        p.b("102000", "");
    }
}
