package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;

class o implements OnClickListener {
    final /* synthetic */ SearchActivity a;

    o(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.themetab_searchdetail_back:
                this.a.f();
                return;
            case R.id.tv_search:
                this.a.a = this.a.k.getText().toString().trim();
                if (this.a.a == null || this.a.a.length() == 0) {
                    e.a(this.a, this.a.getString(R.string.t_market_moxiu_search_no_input), 0);
                    return;
                }
                this.a.a = e.b(this.a.a);
                if (this.a.a == null || this.a.a.length() == 0) {
                    e.a(this.a, this.a.getString(R.string.t_market_moxiu_search_input_error), 0);
                    return;
                } else if (!e.c(this.a)) {
                    e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
                    return;
                } else if (!this.a.b && !this.a.a.equals(this.a.d)) {
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent();
                    intent.setClass(this.a, SearchResultActivity.class);
                    bundle.putString("keyword", e.b(this.a.a));
                    bundle.putString("from", "enterbtn");
                    intent.putExtras(bundle);
                    this.a.startActivity(intent);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
