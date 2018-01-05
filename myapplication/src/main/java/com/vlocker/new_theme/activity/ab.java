package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.c.a;
import com.vlocker.theme.f.e;

class ab implements OnItemClickListener {
    final /* synthetic */ SpecialSingleItemActivity a;

    ab(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (e.c(this.a)) {
            System.gc();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.a, ThemeDetailActivity.class);
            a.b().a(this.a.t.a().get(i));
            bundle.putInt("position", i);
            bundle.putString("tag", "Special");
            bundle.putString("tag_title", this.a.v);
            intent.putExtras(bundle);
            this.a.startActivity(intent);
            return;
        }
        e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
    }
}
