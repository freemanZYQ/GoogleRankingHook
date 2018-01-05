package com.vlocker.msg.b;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.view.GifImageView;

public class m extends a {
    public m(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        int i = 0;
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
        if (BatteryChargeView.c) {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_light));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
        } else {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_dark));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
        }
        if (akVar.G != null) {
            while (i < akVar.G.length && i <= 5) {
                if (akVar.G[i] != null) {
                    this.j[i].setImageBitmap(akVar.G[i]);
                }
                i++;
            }
            if (akVar.G.length < this.j.length) {
                for (i = akVar.G.length; i < this.j.length; i++) {
                    this.j[i].setImageBitmap(null);
                }
            }
        }
        if (akVar.d) {
            this.e.setText(Html.fromHtml(akVar.c));
        } else {
            this.e.setText(akVar.c);
        }
        this.g.setText(a(akVar.g));
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_theme);
        b.setLayoutParams(new LayoutParams(-1, this.v));
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.d = (GifImageView) b.findViewById(R.id.l_msg_img_gif);
        this.j = new ImageView[6];
        this.j[0] = (ImageView) b.findViewById(R.id.t_push_smallicon1);
        this.j[1] = (ImageView) b.findViewById(R.id.t_push_smallicon2);
        this.j[2] = (ImageView) b.findViewById(R.id.t_push_smallicon3);
        this.j[3] = (ImageView) b.findViewById(R.id.t_push_smallicon4);
        this.j[4] = (ImageView) b.findViewById(R.id.t_push_smallicon5);
        this.j[5] = (ImageView) b.findViewById(R.id.t_push_smallicon6);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.g = (TextView) b.findViewById(R.id.l_msg_time);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_outer_layout);
        return b;
    }
}
