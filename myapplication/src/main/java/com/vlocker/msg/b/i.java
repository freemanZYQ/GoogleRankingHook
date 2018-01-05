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

public class i extends a {
    public i(Context context) {
        super(context);
    }

    public void a(ak akVar) {
        if (akVar.k != null) {
            this.c.setImageBitmap(akVar.k);
        } else {
            this.c.setImageResource(R.drawable.l_msg_img_holder);
        }
        if (akVar.t != null) {
            this.i.setImageBitmap(akVar.t);
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
        View b = j.b(this.a, (int) R.layout.l_msg_item_red_share);
        b.setLayoutParams(new LayoutParams(-1, this.v));
        this.i = (ImageView) b.findViewById(R.id.l_msg_bg);
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.h = b.findViewById(R.id.l_msg_pkg);
        return b;
    }
}
