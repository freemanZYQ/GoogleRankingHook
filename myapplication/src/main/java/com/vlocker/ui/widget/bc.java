package com.vlocker.ui.widget;

class bc implements Comparable {
    V2BannerPage a;
    ba b;
    final /* synthetic */ V2GuideBannerView c;

    public bc(V2GuideBannerView v2GuideBannerView) {
        this.c = v2GuideBannerView;
    }

    public bc(V2GuideBannerView v2GuideBannerView, V2BannerPage v2BannerPage, ba baVar) {
        this.c = v2GuideBannerView;
        this.a = v2BannerPage;
        this.b = baVar;
    }

    public int a(bc bcVar) {
        return bcVar.b.c - this.b.c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((bc) obj);
    }
}
