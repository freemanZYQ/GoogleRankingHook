package com.vlocker.ui.widget;

import android.support.v4.view.bb;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.update.UpdateApkParamBean;
import java.util.ArrayList;

class bd extends bb {
    final /* synthetic */ V2GuideBannerView a;

    bd(V2GuideBannerView v2GuideBannerView) {
        this.a = v2GuideBannerView;
    }

    public Object a(ViewGroup viewGroup, int i) {
        int size = this.a.h.size();
        int i2 = i % size;
        int i3 = i2 < 0 ? i2 + size : i2;
        bc bcVar = (bc) this.a.h.get(i3);
        View view = bcVar.a;
        ViewParent parent = view.getParent();
        ba baVar = bcVar.b;
        if (parent != null) {
            ((ViewGroup) parent).removeView(view);
        }
        if (!baVar.a) {
            RecyclingImageView recyclingImageView = (RecyclingImageView) view.findViewById(R.id.banner_img);
            RecyclingImageView recyclingImageView2 = (RecyclingImageView) view.findViewById(R.id.banner_adlabel);
            try {
                if (V2GuideBannerView.c != null && baVar.a().equals("ade")) {
                    recyclingImageView.a(V2GuideBannerView.c.d(), 1, 0);
                    if (TextUtils.isEmpty(V2GuideBannerView.c.w())) {
                        recyclingImageView2.setVisibility(8);
                    } else {
                        recyclingImageView2.a(V2GuideBannerView.c.w(), 1, 0);
                        recyclingImageView2.setVisibility(0);
                    }
                } else if (baVar.a().equals("apps")) {
                    ArrayList g = baVar.g();
                    if (g == null || g.size() <= 0) {
                        recyclingImageView.a(baVar.e, 1, 0);
                    } else {
                        UpdateApkParamBean updateApkParamBean = (UpdateApkParamBean) g.get(0);
                        if (updateApkParamBean != null) {
                            recyclingImageView.a(updateApkParamBean.o(), 1, 0);
                            p.c(this.a.getContext(), p.a("app", updateApkParamBean.l(), ""), "AA_SELFRUN", p.a(i3));
                            this.a.x = i3;
                        } else {
                            recyclingImageView.a(baVar.e, 1, 0);
                        }
                        if (TextUtils.isEmpty(V2GuideBannerView.c.w())) {
                            recyclingImageView2.setVisibility(8);
                        } else {
                            recyclingImageView2.a(V2GuideBannerView.c.w(), 1, 0);
                            recyclingImageView2.setVisibility(0);
                        }
                    }
                } else {
                    recyclingImageView.a(baVar.e, 1, 0);
                }
            } catch (Exception e) {
                recyclingImageView.a(baVar.e, 1, 0);
            }
        }
        if (view.getParent() == null) {
            viewGroup.addView(view);
        }
        return view;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
    }

    public boolean a(View view, Object obj) {
        return view == obj;
    }

    public int b() {
        return this.a.h.size() > 2 ? Integer.MAX_VALUE : this.a.h.size();
    }
}
