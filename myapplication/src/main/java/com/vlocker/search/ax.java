package com.vlocker.search;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.b.b.a;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import java.util.ArrayList;
import java.util.List;

public class ax extends p {
    List a = new ArrayList();
    boolean b = false;
    OnItemClickListener c = new az(this);
    private GridView d;
    private ai j = null;

    public ax(BaiduSearchActivity baiduSearchActivity, at atVar) {
        super(baiduSearchActivity, atVar);
    }

    private void b() {
        if (!this.b) {
            this.b = true;
            new a(this.e.getApplicationContext()).a(com.b.d.a.b(this.e, "search_net_service"), 8, new ay(this)).a();
        }
    }

    private void d() {
        try {
            if (this.j == null) {
                this.j = new ai(this.e, this.a);
            } else {
                this.j.a(this.a);
            }
            this.d.setAdapter(this.j);
            this.j.notifyDataSetChanged();
            this.d.setOnItemClickListener(this.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected View a() {
        View b = j.b(this.e, (int) R.layout.m_bd_searchgrid_ttcard);
        this.d = (GridView) j.a(b, (int) R.id.GridView1);
        this.d.setSelector(new ColorDrawable(0));
        return b;
    }

    protected void a(ac acVar) {
        b();
    }
}
