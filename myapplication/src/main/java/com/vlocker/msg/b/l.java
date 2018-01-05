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

public class l extends a {
    public l(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.k != null) {
            this.c.setImageBitmap(akVar.k);
        } else {
            this.c.setImageResource(R.drawable.l_msg_img_holder);
        }
        this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
        this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
        if (akVar.d) {
            this.e.setText(Html.fromHtml(akVar.c));
        } else {
            this.e.setText(akVar.c);
        }
        if (akVar.t != null) {
            this.i.setImageBitmap(akVar.t);
        } else {
            this.i.setImageBitmap(null);
        }
        this.h.setTag(akVar.b);
    }

    protected View b() {
        View b = j.b(this.a, (int) R.layout.l_msg_item_theme_custom);
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.i = (ImageView) b.findViewById(R.id.t_push_smallicon1);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.m = b.findViewById(R.id.msg_outer_layout);
        b.setLayoutParams(new LayoutParams(-1, this.v));
        return b;
    }
}
