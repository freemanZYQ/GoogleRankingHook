package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;
import java.util.Map;

class p implements OnClickListener {
    final /* synthetic */ SearchActivity a;

    p(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    public void onClick(View view) {
        int intValue = Integer.valueOf(view.getId()).intValue();
        for (int i = 0; i < this.a.l.size(); i++) {
            if (((TextView) this.a.l.get(i)).getId() == intValue) {
                com.vlocker.b.p.a(this.a, "Vlocker_Click_Hot_Tag_Theme_PPC_TF", "name", (String) ((Map) this.a.c.get(i)).get("tagname"));
                if (e.c(this.a)) {
                    try {
                        Bundle bundle = new Bundle();
                        Intent intent = new Intent();
                        intent.setClass(this.a, SearchResultActivity.class);
                        bundle.putString("keyword", (String) ((Map) this.a.c.get(i)).get("tagname"));
                        bundle.putString("from", "listkeytag");
                        intent.putExtras(bundle);
                        this.a.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
                }
            }
        }
    }
}
