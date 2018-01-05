package com.vlocker.search;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.moxiu.b.a.a;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class w implements OnClickListener {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public void onClick(View view) {
        try {
            this.a.e.h = false;
            this.a.e.c = true;
            ap.a(this.a.e, view);
            a aVar = (a) view.getTag();
            if (e.c(this.a.e)) {
                try {
                    x.a(this.a.e).a(view, aVar);
                    Context context = this.a.e;
                    String str = aVar.c().toString();
                    String str2 = this.a.e.f;
                    BaiduSearchActivity baiduSearchActivity = this.a.e;
                    ap.a(context, str, str2, "HotwordSearch", "search_bar", "user");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (aVar.c().toString().length() > 0) {
                    p.a(this.a.e, "Vlock_Done_Search_PPC_TF", "word", aVar.c().toString(), "search_engine", this.a.e.f, "from", "hot", "location", this.a.e.a());
                    return;
                }
                return;
            }
            try {
                Toast.makeText(this.a.e, this.a.e.getString(R.string.M_bd_net_set), 0).show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
    }
}
