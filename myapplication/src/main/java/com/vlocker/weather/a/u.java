package com.vlocker.weather.a;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.vlocker.theme.imageloader.y;

class u implements OnScrollListener {
    final /* synthetic */ q a;

    u(q qVar) {
        this.a = qVar;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.a.h != null) {
            this.a.h.a(absListView, i2);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            if (i == 0) {
                y.a().a(2).a(false);
                if (this.a.l.getLastVisiblePosition() < this.a.j.size() - 7 && !this.a.z) {
                    this.a.d();
                } else if (this.a.c() == 0) {
                    q.b = false;
                    this.a.z();
                    this.a.n.z();
                }
            }
        } else if (i == 0) {
            y.a().a(2).a(false);
            if (this.a.l.getLastVisiblePosition() < this.a.j.size() - 7) {
            }
            if (this.a.c() == 0) {
                q.b = false;
                this.a.z();
                this.a.n.z();
            }
        }
    }
}
