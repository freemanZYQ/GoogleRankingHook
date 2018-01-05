package com.vlocker.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class ay implements OnClickListener {
    final /* synthetic */ V2GuideBannerView a;

    ay(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void onClick(View view) {
        this.a.u();
        p.b("102000", "");
    }
}
