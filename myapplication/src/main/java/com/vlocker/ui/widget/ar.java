package com.vlocker.ui.widget;

import com.moxiu.b.b.a;
import java.util.List;

class ar implements a {
    final /* synthetic */ V2GuideBannerView a;

    ar(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public void a(int i, String str) {
        V2GuideBannerView.c = null;
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    V2GuideBannerView.c = (com.moxiu.b.a.a) list.get(0);
                    V2GuideBannerView.c.a(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
