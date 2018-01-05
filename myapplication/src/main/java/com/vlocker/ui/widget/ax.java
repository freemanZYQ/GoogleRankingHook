package com.vlocker.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class ax implements OnClickListener {
    final /* synthetic */ V2GuideBannerView a;

    ax(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void onClick(View view) {
        this.a.t();
        p.b("102000", "");
    }
}
