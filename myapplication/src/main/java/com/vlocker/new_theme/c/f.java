package com.vlocker.new_theme.c;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.vlocker.locker.R;
import com.vlocker.theme.f.e;
import java.util.List;

public class f extends Fragment {
    protected List aa;
    private LinearLayout ab;
    private LinearLayout ac;
    private final int ad = 0;
    private boolean ae;
    private View af;
    private h ag;

    private void K() {
        this.ac = (LinearLayout) this.ab.findViewById(R.id.allthemes_wait_layout);
        if (e.c(c())) {
            b(0);
            return;
        }
        this.ac.setVisibility(0);
        Message message = new Message();
        message.what = 264;
        this.ag.sendMessage(message);
    }

    private void b(int i) {
        new Thread(new g(this, i)).start();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.af = layoutInflater.inflate(R.layout.t_market_main_home_category, null);
        this.ab = (LinearLayout) this.af.findViewById(R.id.main_home_category);
        if (!this.ae) {
            this.ae = true;
            this.ag = new h(this, c());
            K();
        }
        return this.af;
    }

    public void c(boolean z) {
        super.c(z);
        if (z && !this.ae && this.ab != null) {
            this.ae = true;
            try {
                this.ag = new h(this, c());
                K();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
