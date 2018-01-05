package com.vlocker.search;

import android.view.View;
import android.view.View.OnClickListener;

class s implements OnClickListener {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void onClick(View view) {
        try {
            ap.a(this.a.e, view);
            M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = (M_bd_BaiduNewsInfo) view.getTag();
            if (m_bd_BaiduNewsInfo != null && m_bd_BaiduNewsInfo.a() != null) {
                this.a.e.a(m_bd_BaiduNewsInfo.a(), this.a.e.f, "HintSearch");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
