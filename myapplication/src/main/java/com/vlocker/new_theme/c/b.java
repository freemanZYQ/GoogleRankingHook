package com.vlocker.new_theme.c;

import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.a.i;
import com.vlocker.new_theme.beans.T_SpecialThemePageInfo;
import com.vlocker.theme.c.a;

class b extends i {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(T_SpecialThemePageInfo t_SpecialThemePageInfo) {
        super.a(t_SpecialThemePageInfo);
        this.a.an = t_SpecialThemePageInfo;
        if (!(t_SpecialThemePageInfo == null || this.a.an.a == null)) {
            try {
                this.a.ac.setVisibility(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.a.ao = this.a.an.a();
            T_SpecialThemePageInfo b = a.b().b(String.valueOf(8201));
            if (b.a() == null || b.a().size() == 0) {
                b.a(this.a.ao);
                this.a.ah.a(b.a());
            } else {
                b.a().addAll(this.a.ao);
                this.a.ah.a(b.a());
            }
            this.a.ai.a(this.a.an.c);
        }
        this.a.ai.a(false);
        this.a.ai.b(false);
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        if (this.a.ah.a() == null || this.a.ah.a().size() == 0) {
            this.a.ac.setVisibility(0);
            TextView textView = (TextView) this.a.ab.findViewById(R.id.theme_fetch_loading);
            ((ImageView) this.a.ab.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(0);
            textView.setText(R.string.t_market_listloading_fail);
            textView.setVisibility(0);
            this.a.ac.setOnClickListener(this.a.aa);
            textView.setOnClickListener(this.a.aa);
        }
        this.a.ai.a(false);
        this.a.ai.b(false);
    }
}
