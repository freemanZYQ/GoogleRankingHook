package com.vlocker.msg.b;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.b.j;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;

public class k extends a {
    public k(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.j.contains(WXApp.WXAPP_PACKAGE_NAME)) {
            this.c.setImageResource(R.drawable.weixin_icon);
        } else if (akVar.j.contains("com.tencent.mobileqq")) {
            this.c.setImageResource(R.drawable.qq_icon);
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
        this.g.setText(a(akVar.g));
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_redpacket);
        b.setLayoutParams(new LayoutParams(-1, this.v));
        ((RelativeLayout) b.findViewById(R.id.msg_outer_layout)).setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.red_pocket_msg_bg));
        this.c = (ImageView) b.findViewById(R.id.l_msg_img_icon);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.e.setTextColor(this.a.getResources().getColor(R.color.l_rea_pocket_title_text));
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.f.setTextColor(-1);
        this.g = (TextView) b.findViewById(R.id.l_msg_time);
        this.g.setVisibility(8);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_outer_layout);
        return b;
    }
}
