package com.vlocker.new_theme.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.new_theme.activity.CateSingleItemActivity;
import com.vlocker.theme.f.e;
import java.util.List;

class f implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ d b;

    f(d dVar, List list) {
        this.b = dVar;
        this.a = list;
    }

    public void onClick(View view) {
        if (e.c(this.b.c)) {
            System.gc();
            try {
                Bundle bundle = new Bundle();
                Intent intent = new Intent();
                intent.setClass(this.b.c, CateSingleItemActivity.class);
                bundle.putInt("from", 10);
                bundle.putString("dataurl", ((com.vlocker.new_theme.beans.e) this.a.get(1)).f());
                bundle.putString("title", ((com.vlocker.new_theme.beans.e) this.a.get(1)).d());
                intent.putExtras(bundle);
                this.b.c.startActivity(intent);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        e.a(this.b.c, this.b.c.getResources().getString(R.string.t_market_net_set), 0);
    }
}
