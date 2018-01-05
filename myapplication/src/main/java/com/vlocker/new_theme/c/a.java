package com.vlocker.new_theme.c;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.new_theme.b.m;
import com.vlocker.new_theme.beans.T_SpecialThemePageInfo;
import com.vlocker.new_theme.d.g;
import com.vlocker.new_theme.e.b;
import com.vlocker.new_theme.view.T_MyListView;
import com.vlocker.theme.f.e;
import com.vlocker.theme.model.d;
import java.util.concurrent.RejectedExecutionException;

public class a extends Fragment {
    OnClickListener aa = new e(this);
    private LinearLayout ab;
    private LinearLayout ac;
    private ProgressBar ad;
    private View ae;
    private TextView af;
    private T_MyListView ag;
    private m ah;
    private b ai;
    private boolean aj = true;
    private View ak;
    private final com.vlocker.new_theme.e.a al = new c(this);
    private final OnItemClickListener am = new d(this);
    private T_SpecialThemePageInfo an;
    private d ao;

    private void K() {
        this.ac = (LinearLayout) this.ab.findViewById(R.id.allthemes_wait_layout);
        this.ac.setVisibility(0);
        this.ac.setOnClickListener(this.aa);
        this.ae = View.inflate(c(), R.layout.t_market_listview_footer, null);
        this.ad = (ProgressBar) this.ae.findViewById(R.id.footer_progress_bar);
        this.ad.setIndeterminate(true);
        this.af = (TextView) this.ae.findViewById(R.id.footer_textview);
        this.af.setTextColor(-1);
        this.af.setTextSize(15.0f);
        this.ae.setVisibility(8);
        this.ac.setVisibility(0);
        this.ag = (T_MyListView) this.ab.findViewById(R.id.themetab_homecate_listview);
        this.ag.addFooterView(this.ae, null, false);
        this.ag.setDivider(null);
        this.ag.setDescendantFocusability(393216);
        if (e.c(c())) {
            if (this.ac != null) {
                this.ac.setVisibility(0);
            }
            L();
            b(e.b());
            return;
        }
        if (this.ac != null) {
            this.ac.setVisibility(0);
        }
        TextView textView = (TextView) this.ab.findViewById(R.id.theme_fetch_loading);
        ImageView imageView = (ImageView) this.ab.findViewById(R.id.theme_fetch_loading_imageView1);
        imageView.setVisibility(0);
        textView.setText(R.string.t_market_listloading_fail);
        textView.setVisibility(0);
        imageView.setOnClickListener(this.aa);
        this.ac.setOnClickListener(this.aa);
        textView.setOnClickListener(this.aa);
    }

    private void L() {
        this.ah = new m(c());
        this.ag.setOnItemClickListener(this.am);
        this.ai = new b(c(), this.al, (LinearLayout) this.ae.findViewById(R.id.listwait_layout3));
        this.ag.setOnScrollListener(this.ai);
        this.ag.setAdapter(this.ah);
    }

    private void M() {
        T_SpecialThemePageInfo b = com.vlocker.theme.c.a.b().b(String.valueOf(8201));
        if (b != null && b.a() != null && b.a().size() > 0) {
            b.a().removeAll(b.a);
        }
    }

    private void a(String str, LinearLayout linearLayout) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    this.ai.a(true);
                    this.ai.b(true);
                    b(str);
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
        this.ai.a(false);
        this.ai.b(false);
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.ak = layoutInflater.inflate(R.layout.t_market_main_home_special, null);
        this.ab = (LinearLayout) this.ak.findViewById(R.id.main_home_special);
        if (this.aj) {
            this.aj = false;
            K();
        }
        return this.ak;
    }

    protected void b(String str) {
        try {
            new com.vlocker.new_theme.a.d().a(str + e.g(c()), new g(), new b(this));
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o() {
        super.o();
        T_SpecialThemePageInfo b = com.vlocker.theme.c.a.b().b(String.valueOf(8201));
        if (b != null && b.a() != null) {
            b.a().clear();
        }
    }
}
