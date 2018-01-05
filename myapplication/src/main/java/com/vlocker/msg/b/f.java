package com.vlocker.msg.b;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;

public class f extends a {
    public f(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.D == null || akVar.t == null) {
            this.c.setImageResource(R.drawable.l_msg_img_holder);
        } else {
            this.c.setImageBitmap(akVar.t);
            ((RelativeLayout) a().findViewById(R.id.msg_bg_layout)).setBackgroundDrawable(null);
        }
        if (BatteryChargeView.c) {
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
        } else {
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
        }
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_type_img);
        b.setLayoutParams(new LayoutParams(-1, this.v * 2));
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_bg_layout);
        return b;
    }
}
