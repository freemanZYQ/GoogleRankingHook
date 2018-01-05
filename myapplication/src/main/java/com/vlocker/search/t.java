package com.vlocker.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import java.util.List;

public class t extends p {
    protected TextView[] a;
    protected TextView[] b;
    protected RelativeLayout c;
    public boolean d = false;
    int j;
    OnClickListener k = new u(this);

    public t(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
    }

    private void b() {
        try {
            ao.a(this.e).b();
            if (this.j != 0) {
                p.a(this.e, "Vlock_Clean_History_Search_PPC_TF", "number", "" + this.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 4; i++) {
            this.a[i].setText("");
            this.a[i].setTag(null);
            this.a[i].setVisibility(8);
        }
        this.c.setVisibility(8);
        this.e.c = false;
    }

    protected View a() {
        View b = j.b(this.e, (int) R.layout.m_bd_search_history);
        this.a = new TextView[4];
        this.b = new TextView[4];
        this.c = (RelativeLayout) j.a(b, (int) R.id.his_touch_pad);
        this.a[0] = (TextView) j.a(b, (int) R.id.his_tv1);
        this.a[1] = (TextView) j.a(b, (int) R.id.his_tv2);
        this.a[2] = (TextView) j.a(b, (int) R.id.his_tv3);
        this.a[3] = (TextView) j.a(b, (int) R.id.his_tv4);
        this.b[0] = (TextView) j.a(b, (int) R.id.his_tvl1);
        this.b[1] = (TextView) j.a(b, (int) R.id.his_tvl2);
        this.b[2] = (TextView) j.a(b, (int) R.id.his_tvl3);
        this.b[3] = (TextView) j.a(b, (int) R.id.his_tvl4);
        return b;
    }

    public void a(List list) {
        super.a(this.g);
        int i = 0;
        while (i < 4) {
            try {
                this.a[i].setText("");
                this.a[i].setTag(null);
                this.a[i].setVisibility(8);
                this.b[i].setVisibility(8);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.j = list.size();
        for (i = 0; i < this.j; i++) {
            this.a[i].setText(((M_bd_BaiduHintsInfo) list.get(i)).b());
            this.a[i].setTag(list.get(i));
            this.a[i].setVisibility(0);
            this.b[i].setVisibility(0);
            this.a[i].setOnClickListener(this.k);
        }
        if (this.j == 0) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.c.setOnClickListener(this.k);
    }
}
