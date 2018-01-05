package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class l implements OnEditorActionListener {
    final /* synthetic */ SearchActivity a;

    l(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.a.a = this.a.k.getText().toString().trim();
        if (this.a.a == null || this.a.a.length() == 0) {
            e.a(this.a, this.a.getString(R.string.t_market_moxiu_search_no_input), 0);
            return true;
        } else if (!e.c(this.a)) {
            e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
            return true;
        } else if (this.a.b || this.a.a.equals(this.a.d)) {
            return true;
        } else {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.setClass(this.a, SearchResultActivity.class);
            bundle.putString("keyword", e.b(this.a.a));
            bundle.putString("from", "enterbtn");
            intent.putExtras(bundle);
            this.a.startActivity(intent);
            return true;
        }
    }
}
