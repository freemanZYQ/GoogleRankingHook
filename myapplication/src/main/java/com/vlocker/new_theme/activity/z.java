package com.vlocker.new_theme.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.locker.R;
import com.vlocker.theme.activity.ThemeDetailActivity;
import com.vlocker.theme.c.a;
import com.vlocker.theme.f.e;

class z implements OnClickListener {
    final /* synthetic */ SpecialSingleItemActivity a;

    z(SpecialSingleItemActivity specialSingleItemActivity) {
        this.a = specialSingleItemActivity;
    }

    public void onClick(View view) {
        String a = this.a.u.a();
        String c = this.a.u.c();
        if (a == null) {
            return;
        }
        if (a.equals("site")) {
            if (c != null) {
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(c)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (a.equals("theme")) {
            Object b = this.a.u.b();
            if (!e.c(this.a)) {
                e.a(this.a, this.a.getString(R.string.t_market_net_set), 0);
            } else if (b != null) {
                System.gc();
                Bundle bundle = new Bundle();
                r2 = new Intent();
                r2.setClass(this.a, ThemeDetailActivity.class);
                a.b().a(b);
                bundle.putString("tag", "Special");
                bundle.putString("tag_title", this.a.v);
                r2.putExtras(bundle);
                this.a.startActivity(r2);
            }
        } else if (a.equals("url")) {
            if (c != null) {
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(c)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else if (a.equals("list") && c != null) {
            if (e.c(e.a)) {
                try {
                    System.gc();
                    Bundle bundle2 = new Bundle();
                    r2 = new Intent();
                    r2.setClass(e.a, CateSingleItemActivity.class);
                    bundle2.putInt("from", 10);
                    bundle2.putString("dataurl", c);
                    r2.putExtras(bundle2);
                    e.a.startActivity(r2);
                    return;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    return;
                }
            }
            e.a(e.a, e.a.getResources().getString(R.string.t_market_net_set), 0);
        }
    }
}
