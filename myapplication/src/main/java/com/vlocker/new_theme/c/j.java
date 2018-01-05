package com.vlocker.new_theme.c;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.a.d;
import com.vlocker.new_theme.b.n;
import com.vlocker.new_theme.beans.f;
import com.vlocker.new_theme.e.a;
import com.vlocker.new_theme.e.b;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.e;
import java.util.concurrent.RejectedExecutionException;

public class j extends Fragment {
    private LinearLayout aa;
    private ListView ab;
    private LinearLayout ac;
    private b ad;
    private final int ae = 8194;
    private boolean af;
    private View ag;
    private final a ah = new o(this);
    private int ai;
    private p aj;
    private f ak;
    private n al;
    private int am;

    private void K() {
        ((TextView) this.ac.findViewById(R.id.theme_fetch_loading)).setText(MoSecurityApplication.a().getString(R.string.t_market_listloading_fail));
        ((ImageView) this.ac.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(0);
        this.ac.setOnClickListener(new k(this));
    }

    private void L() {
        this.ac = (LinearLayout) this.aa.findViewById(R.id.allthemes_wait_layout);
        boolean c = e.c(c());
        this.ad = new b(c(), this.ah, (LinearLayout) this.aa.findViewById(R.id.listwait_layout3));
        this.ab.setOnScrollListener(this.ad);
        if (c) {
            a(8194, 0);
            return;
        }
        this.ac.setVisibility(0);
        Message message = new Message();
        message.what = 275;
        this.aj.sendMessage(message);
    }

    private void a(int i, int i2) {
        switch (i) {
            case 8194:
                new Thread(new l(this, i)).start();
                return;
            default:
                return;
        }
    }

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.ad.a(true);
                    this.ad.b(true);
                    this.ai = 1;
                    a(str, 8194);
                    return;
                }
            } catch (RejectedExecutionException e) {
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        e.a(e.a, a((int) R.string.theme_list_atbottom), 0);
        this.ad.a(false);
        this.ad.b(false);
    }

    static /* synthetic */ int g(j jVar) {
        int i = jVar.am + 1;
        jVar.am = i;
        return i;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ag = layoutInflater.inflate(R.layout.t_market_themelist_child_listview_commen, null);
        this.aa = (LinearLayout) this.ag.findViewById(R.id.market_gridlist_themeid);
        this.ab = (ListView) this.ag.findViewById(R.id.gridview);
        this.ac = (LinearLayout) this.ag.findViewById(R.id.allthemes_wait_layout);
        if (!this.af) {
            this.af = true;
            this.aj = new p(this, c());
            L();
        }
        return this.ag;
    }

    protected void a(String str, int i) {
        String str2 = str + e.g(c());
        d dVar = new d();
        switch (i) {
            case 8194:
                if (this.ai == 0) {
                    dVar.a(str2, new com.vlocker.new_theme.d.e(), new m(this));
                    return;
                } else if (this.ai == 1) {
                    dVar.a(str2, new com.vlocker.new_theme.d.d(), new n(this));
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void c(boolean z) {
        super.c(z);
        if (z && !this.af && this.ag != null) {
            this.af = true;
            try {
                this.aj = new p(this, c());
                L();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
