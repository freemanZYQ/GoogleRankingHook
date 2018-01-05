package com.vlocker.new_theme.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.new_theme.activity.DigSingleItemActivity;
import com.vlocker.new_theme.beans.e;

class o implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ n b;

    o(n nVar, e eVar) {
        this.b = nVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        if (com.vlocker.theme.f.e.c(this.b.d)) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.b.d, DigSingleItemActivity.class);
            bundle.putString("dataurl", this.a.f());
            bundle.putString("title", this.a.d());
            intent.putExtras(bundle);
            if (this.b.d != null) {
                this.b.d.startActivity(intent);
                return;
            }
            return;
        }
        com.vlocker.theme.f.e.a(this.b.d, this.b.d.getResources().getString(R.string.t_market_net_set));
    }
}
