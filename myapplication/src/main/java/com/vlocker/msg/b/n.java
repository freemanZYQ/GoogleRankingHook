package com.vlocker.msg.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;

public class n extends a {
    private int w;

    public n(Context context) {
        super(context);
        this.w = context.getResources().getDisplayMetrics().widthPixels;
    }

    public void a(ak akVar) {
        int i = 8;
        try {
            if (BatteryChargeView.c) {
                this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
                this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
                this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
            } else {
                this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
                this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
                this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_v2_msg_item_update_bg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e.setText(akVar.c);
        this.f.setText(akVar.e);
        this.c.setImageBitmap(akVar.k);
        if ("mx_update".equals(akVar.b)) {
            this.g.setText(this.a.getString(R.string.update));
            this.g.setBackgroundResource(R.drawable.msg_update_btn_bg);
        } else {
            Object obj = this.w <= 480 ? 1 : null;
            a().findViewById(R.id.l_msg_btn_mini).setVisibility(obj != null ? 0 : 8);
            TextView textView = this.g;
            if (obj == null) {
                i = 0;
            }
            textView.setVisibility(i);
            this.g.setText(this.a.getString(R.string.repair));
            this.g.setBackgroundResource(R.drawable.msg_repair_btn_bg);
        }
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_update);
        this.i = (ImageView) b.findViewById(R.id.l_msg_bg);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.g = (TextView) b.findViewById(R.id.l_msg_btn);
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        return b;
    }
}
