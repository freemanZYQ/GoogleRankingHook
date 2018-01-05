package com.vlocker.new_theme.activity;

import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.a.i;
import com.vlocker.new_theme.b.d;
import com.vlocker.new_theme.beans.f;
import com.vlocker.theme.f.e;

class h extends i {
    final /* synthetic */ DigSingleItemActivity a;

    h(DigSingleItemActivity digSingleItemActivity) {
        this.a = digSingleItemActivity;
    }

    public void a(f fVar) {
        super.a(fVar);
        if (this.a.q != null) {
            this.a.q.setVisibility(8);
        }
        if (fVar != null && fVar.b() != null) {
            if (this.a.m.size() != 0) {
                this.a.m.addAll(fVar.b());
            } else {
                this.a.m = fVar.b();
            }
            if (this.a.v == null) {
                this.a.v = new d(this.a, this.a.m, this.a.x);
                this.a.r.setAdapter(this.a.v);
            }
            if (this.a.C != null) {
                if (this.a.y) {
                    this.a.C.clear();
                }
                if (this.a.C.size() == 0) {
                    this.a.C.clear();
                    this.a.C = fVar.a();
                } else {
                    try {
                        this.a.C.addAll(fVar.a());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.a.v.a(this.a.m);
            this.a.u.a(fVar.c);
            this.a.u.a(false);
            this.a.u.b(false);
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        if (this.a.q != null) {
            this.a.q.setVisibility(8);
        }
        TextView textView = (TextView) this.a.q.findViewById(R.id.theme_fetch_loading);
        ImageView imageView = (ImageView) this.a.q.findViewById(R.id.theme_fetch_loading_imageView1);
        imageView.setVisibility(0);
        if (e.c(this.a)) {
            imageView.setVisibility(0);
            textView.setText(R.string.t_market_listloading_fail);
        } else {
            textView.setText(R.string.t_market_listloading_fail);
        }
        this.a.q.setOnClickListener(new i(this, textView, imageView));
    }
}
