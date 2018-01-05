package com.vlocker.g;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import com.vlocker.m.l;
import com.vlocker.ui.cover.LockerService;

public class j extends t implements OnClickListener {
    private View c;
    private ViewGroup d = b.a().a;

    public j(a aVar) {
        super(aVar);
    }

    private void d() {
        if (this.c == null) {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.c = LayoutInflater.from(this.a).inflate(R.layout.icon_download_dialog_layout, null);
            this.d.addView(this.c, layoutParams);
            if (this.b.k != null) {
                ImageView imageView = (ImageView) this.c.findViewById(R.id.top_img);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.height = l.a((float) ((int) ((((float) this.b.k.getHeight()) / ((float) this.b.k.getWidth())) * 300.0f)));
                imageView.setLayoutParams(layoutParams2);
                imageView.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), this.b.k));
            }
            if (this.b.j != null) {
                ((ImageView) this.c.findViewById(R.id.download_icon_img)).setImageBitmap(this.b.j);
            } else {
                ((ImageView) this.c.findViewById(R.id.download_icon_img)).setVisibility(8);
            }
            if (TextUtils.isEmpty(this.b.l)) {
                ((TextView) this.c.findViewById(R.id.tv_download_title)).setVisibility(8);
            } else {
                ((TextView) this.c.findViewById(R.id.tv_download_title)).setText(this.b.l);
            }
            if (TextUtils.isEmpty(this.b.m)) {
                ((TextView) this.c.findViewById(R.id.tv_download_des)).setVisibility(8);
            } else {
                ((TextView) this.c.findViewById(R.id.tv_download_des)).setText(this.b.m);
            }
            if (!TextUtils.isEmpty(this.b.n)) {
                ((Button) this.c.findViewById(R.id.btn_download)).setText(this.b.n);
            }
            this.c.setOnClickListener(this);
            this.c.findViewById(R.id.close_img).setOnClickListener(this);
            this.c.findViewById(R.id.btn_download).setOnClickListener(this);
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.b.g)) {
            b.a().f();
        } else if (this.b.p) {
            b();
        } else {
            d();
        }
    }

    public void b() {
        super.b();
        new k(this).run();
        LockerService.a().a(null, 2);
    }

    public void c() {
        if (this.c != null && this.c.getParent() != null) {
            this.c.setVisibility(4);
            this.d.removeView(this.c);
            this.c = null;
            b.a().b = null;
            System.gc();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_download:
                c();
                b();
                return;
            case R.id.close_img:
                c();
                b.a().f();
                return;
            default:
                return;
        }
    }
}
