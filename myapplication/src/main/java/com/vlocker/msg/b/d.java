package com.vlocker.msg.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.msg.ak;
import com.vlocker.ui.view.BatteryChargeView;
import com.vlocker.ui.view.GifImageView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d extends a {
    public d(Context context) {
        super(context);
    }

    private final int a(String str) {
        int i = 0;
        if (str.contains("条")) {
            int indexOf = str.indexOf("条");
            i = indexOf >= 3 ? a(str.substring(indexOf - 3, indexOf), str, indexOf) : a(str.substring(0, indexOf), str, indexOf);
        }
        return i == 0 ? 1 : i;
    }

    private final int a(String str, String str2, int i) {
        if (!b(str)) {
            return i < str2.length() + -1 ? a(str2.substring(i + 1)) : 0;
        } else {
            Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
            return matcher.find() ? Integer.parseInt(matcher.group(1)) : 0;
        }
    }

    private final boolean b(String str) {
        return Pattern.compile(".*\\d+.*").matcher(str).matches();
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
        if (BatteryChargeView.c) {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_light));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_light));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_light));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg_blur));
        } else {
            this.g.setTextColor(this.a.getResources().getColor(R.color.msg_time_dark));
            this.e.setTextColor(this.a.getResources().getColor(R.color.msg_title_dark));
            this.f.setTextColor(this.a.getResources().getColor(R.color.msg_content_dark));
            this.m.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.l_msg_bg));
        }
        if (a.a(this.a).aD()) {
            this.e.setText(akVar.j);
            this.f.setText("收到" + a(akVar.c + akVar.e) + "条新消息");
        } else {
            this.e.setText(akVar.c);
            this.f.setText(akVar.e);
        }
        this.g.setText(a(akVar.g));
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
