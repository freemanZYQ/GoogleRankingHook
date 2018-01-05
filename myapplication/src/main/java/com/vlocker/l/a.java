package com.vlocker.l;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ag;
import com.vlocker.m.h;

public abstract class a {
    protected ag a;
    protected Context b;
    private Toast c;
    private View d;
    private TextView e;

    public a(Context context, ag agVar) {
        this.b = context;
        this.a = agVar;
    }

    public abstract void a();

    protected void a(CharSequence charSequence) {
        if (this.d == null) {
            this.d = View.inflate(this.b, R.layout.l_cover_toast, null);
            this.e = (TextView) this.d.findViewById(R.id.toast_text);
        }
        if (this.c == null) {
            this.c = new Toast(this.b);
            this.c.setView(this.d);
            this.c.setGravity(17, 0, h.a(this.b, -30.0f));
            this.c.setDuration(0);
        }
        this.e.setText(charSequence);
        this.c.show();
    }

    protected void a(String str) {
        int i;
        Object obj = null;
        try {
            i = Intent.class.getField("FLAG_ACTIVITY_CLEAR_TASK").getInt(null);
            obj = 1;
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.addFlags(268435456);
        if (obj != null) {
            intent.addFlags(i);
        }
        this.b.startActivity(intent);
    }

    public abstract boolean a(int i);

    public abstract boolean a(b bVar);

    public abstract int b();
}
