package com.vlocker.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class as implements OnClickListener {
    final /* synthetic */ ba a;
    final /* synthetic */ V2GuideBannerView b;

    as(V2GuideBannerView v2GuideBannerView, ba baVar) {
        this.b = v2GuideBannerView;
        this.a = baVar;
    }

    public void onClick(View view) {
        this.b.setJumpActivityByTag(this.a);
        p.b("102000", "");
    }
}
