package com.vlocker.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.vlocker.locker.R;

class u implements OnClickListener {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public void onClick(View view) {
        try {
            if (view.getId() == R.id.his_touch_pad) {
                if (this.a.i.b != null && this.a.i.b.size() > 0) {
                    for (int i = 0; i < this.a.i.b.size(); i++) {
                        if ("his".equals(((ac) this.a.i.b.get(i)).b())) {
                            this.a.i.b.remove(i);
                            break;
                        }
                    }
                }
                this.a.i.notifyDataSetChanged();
                this.a.b();
                return;
            }
            M_bd_BaiduHintsInfo m_bd_BaiduHintsInfo = (M_bd_BaiduHintsInfo) view.getTag();
            String charSequence = ((TextView) view).getText().toString();
            this.a.e.h = true;
            ap.a(this.a.e, view);
            BaiduSearchActivity baiduSearchActivity = this.a.e;
            String str = this.a.e.f;
            BaiduSearchActivity baiduSearchActivity2 = this.a.e;
            baiduSearchActivity.a(charSequence, str, "HistorySearch");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
