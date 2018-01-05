package com.vlocker.msg.b;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;

public class j extends a {
    public j(Context context) {
        super(context);
    }

    public void a(ak akVar) {
    }

    protected View b() {
        View b = com.vlocker.b.j.b(this.a, (int) R.layout.l_msg_redpacket_open);
        this.c = (ImageView) b.findViewById(R.id.l_msg_img);
        this.e = (TextView) b.findViewById(R.id.l_msg_title);
        this.f = (TextView) b.findViewById(R.id.l_msg_content);
        this.g = (TextView) b.findViewById(R.id.l_msg_time);
        this.h = b.findViewById(R.id.l_msg_pkg);
        this.l = (Button) b.findViewById(R.id.btn_open);
        this.k = (Button) b.findViewById(R.id.btn_close);
        return b;
    }
}
