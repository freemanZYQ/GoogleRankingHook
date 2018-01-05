package com.vlocker.l;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.m.h;

public class f implements OnClickListener {
    private Toast a;
    private View b;
    private TextView c;
    private View d;
    private View e;
    private Context f;
    private g g;

    public f(Context context, View view, boolean z) {
        this.f = context;
        this.e = View.inflate(context, R.layout.l_activity_flashlight, null);
        this.e.setOnClickListener(this);
        this.d = view;
        ((ViewGroup) this.d).addView(this.e);
        a(z);
    }

    private void a(boolean z) {
        this.b = View.inflate(this.f, R.layout.l_cover_toast, null);
        this.c = (TextView) this.b.findViewById(R.id.toast_text);
        this.a = new Toast(this.f);
        this.a.setView(this.b);
        this.a.setGravity(17, 0, h.a(this.f, -30.0f));
        this.a.setDuration(0);
        if (z) {
            this.c.setText(R.string.toast_open_flashlight_activity);
        } else {
            this.c.setText(R.string.toast_open_no_flashlight_activity);
        }
        this.c.setTextColor(this.f.getResources().getColor(R.color.black1));
    }

    private void c() {
        this.a.show();
    }

    public void a() {
        if (this.e.getVisibility() == 8) {
            c();
            this.e.setVisibility(0);
            this.e.bringToFront();
            if (this.g != null) {
                this.g.a();
            }
        }
    }

    public void a(g gVar) {
        this.g = gVar;
    }

    public void b() {
        if (this.e.getVisibility() == 0) {
            this.e.setVisibility(8);
            if (this.g != null) {
                this.g.b();
            }
        }
    }

    public void onClick(View view) {
        b();
    }
}
