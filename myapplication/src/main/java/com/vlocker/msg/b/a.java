package com.vlocker.msg.b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.msg.as;
import com.vlocker.ui.view.AdTagView;
import com.vlocker.ui.view.GifImageView;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class a {
    protected Context a;
    protected View b;
    public ImageView c;
    public GifImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public ImageView i;
    protected ImageView[] j = null;
    public Button k;
    public Button l;
    public View m;
    public int n;
    public AdTagView o;
    public RelativeLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public String u;
    protected int v;

    public a(Context context) {
        this.a = context;
        this.v = (int) this.a.getResources().getDimension(R.dimen.l_msg_item_height);
        this.b = b();
        if (this.b != null) {
            this.b.setTag(this);
        }
    }

    public View a() {
        return this.b;
    }

    public String a(long j) {
        boolean a = as.a(j, System.currentTimeMillis());
        boolean is24HourFormat = DateFormat.is24HourFormat(this.a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date(j);
        return !a ? new SimpleDateFormat("MM-dd").format(date) : !is24HourFormat ? new SimpleDateFormat("hh:mm").format(date) : simpleDateFormat.format(date);
    }

    public void a(Object obj) {
    }

    protected abstract View b();

    public void c() {
        if (this.d != null && this.d.getVisibility() == 0) {
            this.d.a();
        }
    }
}
