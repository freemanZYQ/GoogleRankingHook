package com.vlocker.new_theme.c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.c.a;
import com.vlocker.theme.f.e;

class r implements OnItemClickListener {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (e.c(this.a.c())) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.a.c(), ThemeDetailActivity.class);
            a.b().a(this.a.ah.get(i));
            bundle.putInt("position", i);
            if (this.a.aq.equals("new")) {
                bundle.putString("tag", "Newest");
            } else if (this.a.aq.endsWith("fenlei")) {
                bundle.putString("tag", "Classify");
                bundle.putString("tag_title", this.a.ak);
            }
            intent.putExtras(bundle);
            this.a.a(intent);
            return;
        }
        e.a(this.a.c(), this.a.a((int) R.string.t_market_net_set), 0);
    }
}
