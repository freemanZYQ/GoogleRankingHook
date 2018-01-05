package com.vlocker.msg.b;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.theme.imageloader.RecyclingImageView;
import com.vlocker.ui.view.BatteryChargeView;

public class e extends a {
    public e(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        ((RecyclingImageView) this.c).setIsCircle(true);
        if (akVar.n != null) {
            ((RecyclingImageView) this.c).a(akVar.n, 2, 0);
        } else {
            this.c.setImageResource(R.drawable.l_msg_img_holder);
        }
        if (BatteryChargeView.c) {
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_light));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
        } else {
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
        }
        this.e.setText(akVar.c);
        this.f.setText(akVar.e);
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_news);
        this.m = b.findViewById(R.id.msg_outer_layout);
        this.c = (RecyclingImageView) b.findViewById(R.id.l_msg_img);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.h = b.findViewById(R.id.l_msg_pkg);
        return b;
    }
}
