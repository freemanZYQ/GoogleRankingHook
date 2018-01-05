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

public class o extends a {
    public o(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.k != null) {
            this.c.setImageBitmap(akVar.k);
        } else {
            this.c.setImageResource(R.drawable.l_msg_img_holder);
        }
        if (BatteryChargeView.c) {
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_light));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
            ((TextView) a().findViewById(R.id.l_msg_chick)).setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
        } else {
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
            ((TextView) a().findViewById(R.id.l_msg_chick)).setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
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
        String str = akVar.b;
        a().setOnClickListener(new p(this, akVar.D, str));
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_weather);
        b.setLayoutParams(new LayoutParams(-1, this.v));
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_outer_layout);
        return b;
    }
}
