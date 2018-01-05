package com.vlocker.theme.a;

import android.support.v7.widget.bj;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.vlocker.locker.R;

public class f extends bj implements OnClickListener {
    public TextView l;
    public View m;
    private e n;

    public f(View view, e eVar) {
        super(view);
        this.m = view;
        this.m.setOnClickListener(this);
        this.l = (TextView) view.findViewById(R.id.item_text);
        this.n = eVar;
    }

    public void onClick(View view) {
        if (this.n != null && e() >= 0) {
            this.n.a(view, e());
        }
    }
}
