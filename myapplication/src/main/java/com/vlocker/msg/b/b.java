package com.vlocker.msg.b;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.view.AdTagView;
import com.vlocker.ui.view.BatteryChargeView;

public class b extends a {
    private float w;

    public b(Context context) {
        super(context);
        this.w = 0.49115f * ((float) context.getResources().getDisplayMetrics().widthPixels);
    }

    public void a(ak akVar) {
        com.vlocker.battery.saver.b.a(this.a).a(a(), true);
        try {
            if (!TextUtils.isEmpty(akVar.u)) {
                ((RecyclingImageView) this.i).b(akVar.u, 2, 30);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (TextUtils.isEmpty(akVar.n)) {
                this.c.setVisibility(8);
            } else {
                ((RecyclingImageView) this.c).setIsCircle(true);
                ((RecyclingImageView) this.c).a(akVar.n, 2, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (!TextUtils.isEmpty(akVar.B)) {
                ((RecyclingImageView) this.t).a(akVar.B, 2, 0);
                this.t.setVisibility(0);
            }
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        try {
            if (TextUtils.isEmpty(akVar.v)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(akVar.v);
            }
        } catch (Exception e222) {
            e222.printStackTrace();
        }
        try {
            if (!TextUtils.isEmpty(akVar.w)) {
                this.q.setText(akVar.w);
            }
        } catch (Exception e2222) {
            e2222.printStackTrace();
        }
        try {
            if (!TextUtils.isEmpty(akVar.x)) {
                this.s.setText(akVar.x);
                this.r.setText("原价:");
            }
        } catch (Exception e22222) {
            e22222.printStackTrace();
        }
        try {
            if (TextUtils.isEmpty(akVar.w) && TextUtils.isEmpty(akVar.x)) {
                this.p.setVisibility(8);
            }
        } catch (Exception e222222) {
            e222222.printStackTrace();
        }
        try {
            if (BatteryChargeView.c) {
                this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
                this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_light));
                this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
            } else {
                this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
                this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
                this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
            }
        } catch (Exception e2222222) {
            e2222222.printStackTrace();
        }
        this.n = 9;
        if (akVar.d) {
            this.e.setText(Html.fromHtml(akVar.c));
        } else {
            this.e.setText(akVar.c);
        }
        if (akVar.f) {
            this.f.setText(Html.fromHtml(akVar.e));
        } else {
            this.f.setText(akVar.e);
        }
        this.h.setTag(akVar.b);
    }

    protected View b() {
        return null;
    }

    public View b(ak akVar) {
        View view;
        View inflate;
        if (akVar.y || akVar.z) {
            inflate = LayoutInflater.from(this.a).inflate(R.layout.l_battery_saver_adbox_item_baiduurl, null);
            this.u = "url";
            view = inflate;
        } else {
            inflate = LayoutInflater.from(this.a).inflate(R.layout.l_batter_saver_adbox_item, null);
            this.u = "app";
            view = inflate;
        }
        this.c = (ImageView) view.findViewById(R.id.battery_saver_ad_icon);
        this.i = (ImageView) view.findViewById(R.id.img_poster_w);
        this.i.getLayoutParams().height = (int) this.w;
        this.h = view.findViewById(R.id.l_msg_pkg);
        this.e = (TextView) view.findViewById(R.id.weather_ad_title_tx);
        this.f = (TextView) view.findViewById(R.id.text_status_dadesc);
        this.o = (AdTagView) view.findViewById(R.id.large_poster_sell_tag);
        this.p = (RelativeLayout) view.findViewById(R.id.large_poster_shadow);
        this.q = (TextView) view.findViewById(R.id.large_poster_price);
        this.r = (TextView) view.findViewById(R.id.large_poster_strike_desc_title);
        this.s = (TextView) view.findViewById(R.id.large_poster_strike_desc);
        this.t = (ImageView) view.findViewById(R.id.battery_ad_label);
        try {
            this.s.getPaint().setFlags(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.m = view.findViewById(R.id.msg_outer_layout);
        view.setTag(this);
        return view;
    }
}
