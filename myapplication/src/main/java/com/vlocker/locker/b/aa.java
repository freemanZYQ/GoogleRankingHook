package com.vlocker.locker.b;

import android.support.v4.view.bb;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vlocker.locker.c.a;

class aa extends bb {
    final /* synthetic */ p a;

    private aa(p pVar) {
        this.a = pVar;
    }

    public Object a(ViewGroup viewGroup, int i) {
        int size = this.a.c.size();
        int i2 = i % size;
        if (i2 < 0) {
            i2 += size;
        }
        View a = ((a) this.a.c.get(i2)).a(LayoutInflater.from(this.a.i), null, null);
        if (a.getParent() == null) {
            viewGroup.addView(a);
        }
        return a;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public boolean a(View view, Object obj) {
        return view == obj;
    }

    public int b() {
        return this.a.c.size();
    }
}
