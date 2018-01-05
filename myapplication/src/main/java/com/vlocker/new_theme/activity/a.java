package com.vlocker.new_theme.activity;

import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.comm.constants.ErrorCode.NetWorkError;
import com.vlocker.locker.R;
import com.vlocker.new_theme.a.i;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_ThemeListPageInfo;

class a extends i {
    final /* synthetic */ CateSingleItemActivity a;

    a(CateSingleItemActivity cateSingleItemActivity) {
        this.a = cateSingleItemActivity;
    }

    public void a(T_ThemeListPageInfo t_ThemeListPageInfo) {
        super.a(t_ThemeListPageInfo);
        if (!(t_ThemeListPageInfo == null || t_ThemeListPageInfo.a == null)) {
            this.a.p.setVisibility(8);
            this.a.m.addAll(t_ThemeListPageInfo.h());
            this.a.w.a(this.a.m);
            this.a.v.a(t_ThemeListPageInfo.c);
        }
        this.a.i();
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        TextView textView = (TextView) this.a.p.findViewById(R.id.theme_fetch_loading);
        ImageView imageView = (ImageView) this.a.p.findViewById(R.id.theme_fetch_loading_imageView1);
        imageView.setVisibility(0);
        if (e.c(this.a)) {
            switch (this.a.y) {
                case 2:
                    if (th == null || this.a.x.u != NetWorkError.HTTP_STATUS_ERROR) {
                        if (th != null && this.a.x.a == null) {
                            textView.setText(R.string.t_market_listloading_specialtheme_notheme);
                            break;
                        }
                    }
                    textView.setText(R.string.t_market_listloading_specialtheme_cancel);
                    break;
                    break;
                default:
                    if (this.a.w.a() == null || this.a.w.a().size() == 0) {
                        imageView.setVisibility(0);
                        textView.setText(R.string.t_market_listloading_fail);
                        break;
                    }
                    imageView.setVisibility(0);
                    textView.setText(R.string.t_market_listloading_fail);
                    break;
            }
        }
        textView.setText(R.string.t_market_listloading_fail);
        this.a.p.setOnClickListener(new b(this, textView, imageView));
        this.a.i();
    }
}
