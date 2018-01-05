package com.vlocker.new_theme.c;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.x;
import com.vlocker.new_theme.e.a;
import com.vlocker.new_theme.e.b;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import com.vlocker.theme.model.d;
import java.util.concurrent.RejectedExecutionException;

public class q extends Fragment {
    protected String aa;
    private GridView ab;
    private LinearLayout ac;
    private x ad;
    private b ae;
    private final int af = 8195;
    private T_ThemeListPageInfo ag;
    private d ah = new d();
    private boolean ai = true;
    private LinearLayout aj;
    private String ak;
    private final OnItemClickListener al = new r(this);
    private String am;
    private String an;
    private final a ao = new v(this);
    private w ap;
    private String aq;
    private View ar;

    private void K() {
        ((TextView) this.ac.findViewById(R.id.theme_fetch_loading)).setText(R.string.t_market_listloading_fail);
        ((ImageView) this.ac.findViewById(R.id.theme_fetch_loading_imageView1)).setVisibility(0);
        this.ac.setOnClickListener(new s(this));
    }

    private void L() {
        if (e.c(c())) {
            a(8195, 0);
            return;
        }
        this.ac.setVisibility(0);
        Message message = new Message();
        message.what = 277;
        this.ap.sendMessage(message);
    }

    private void a(int i, int i2) {
        new t(this).start();
    }

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.ae.a(true);
                    this.ae.b(true);
                    a(str, 8195);
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
        e.a(e.a, (CharSequence) "没有更多了~", 0);
        this.ae.a(false);
        this.ae.b(false);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ar = layoutInflater.inflate(R.layout.t_market_themelist_child_gridview_commen, null);
        this.ab = (GridView) this.ar.findViewById(R.id.gridview);
        this.ac = (LinearLayout) this.ar.findViewById(R.id.allthemes_wait_layout);
        this.aj = (LinearLayout) this.ar.findViewById(R.id.listwait_layout3);
        return this.ar;
    }

    protected void a(String str, int i) {
        try {
            new com.vlocker.new_theme.a.d().a(str + e.g(c()), new com.vlocker.new_theme.d.d(), new u(this));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }

    public void c(boolean z) {
        super.c(z);
        if (i() != null && z && this.ai) {
            this.ai = false;
            this.ap = new w(this, c());
            this.ad = new x(c(), this);
            this.ab.setAdapter(this.ad);
            this.ab.setOnItemClickListener(this.al);
            this.ae = new b(c(), this.ao, this.aj);
            this.ab.setOnScrollListener(this.ae);
            this.ac = (LinearLayout) this.ar.findViewById(R.id.allthemes_wait_layout);
            L();
        }
    }

    public void d(Bundle bundle) {
        super.d(bundle);
        Bundle b = b();
        if (b != null) {
            this.ak = b.getString("title");
            this.aq = b.getString("type");
            this.an = b.getString("url");
            b.getString("tag");
            b.getString("tab");
        }
    }
}
