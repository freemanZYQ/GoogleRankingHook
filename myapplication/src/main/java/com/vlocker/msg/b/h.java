package com.vlocker.msg.b;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.view.GifImageView;

public class h extends a {
    public h(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.r) {
            this.f.setMaxLines(4);
        } else {
            this.f.setMaxLines(1);
        }
        if (!akVar.o || akVar.n == null) {
            this.c.setVisibility(0);
            this.d.setVisibility(4);
            if (akVar.k != null) {
                this.c.setImageBitmap(akVar.k);
            } else {
                this.c.setImageResource(R.drawable.l_msg_img_holder);
            }
        } else {
            this.c.setVisibility(4);
            this.d.setVisibility(0);
            this.d.setGifUrl(akVar.n);
        }
        this.g.setBackgroundDrawable(null);
        this.g.setText(a(akVar.g));
        if (BatteryChargeView.c) {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_light));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_light));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
            if (akVar.o) {
                this.d.setVisibility(0);
                this.c.setVisibility(4);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(4);
            }
            this.g.setVisibility(0);
        } else {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_dark));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
            if (akVar.o) {
                this.d.setVisibility(0);
                this.c.setVisibility(4);
            } else {
                this.c.setVisibility(0);
                this.d.setVisibility(4);
            }
            this.g.setVisibility(0);
        }
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
        View b = j.b(this.a, (int) R.layout.l_msg_item);
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.d = (GifImageView) b.findViewById(R.id.l_msg_img_gif);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.g = (TextView) b.findViewById(R.id.l_msg_time);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_outer_layout);
        return b;
    }
}
