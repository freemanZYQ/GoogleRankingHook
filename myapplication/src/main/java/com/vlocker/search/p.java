package com.vlocker.search;

import android.view.View;
import java.util.LinkedList;
import java.util.List;

public abstract class p {
    protected BaiduSearchActivity e;
    protected Object f;
    protected List g;
    protected View h = a();
    protected at i;

    public p(BaiduSearchActivity baiduSearchActivity) {
        this.e = baiduSearchActivity;
        this.h.setTag(this);
    }

    public p(BaiduSearchActivity baiduSearchActivity, at atVar) {
        this.e = baiduSearchActivity;
        this.i = atVar;
        this.h.setTag(this);
    }

    protected abstract View a();

    protected void a(Object obj) {
    }

    public void a(List list) {
    }

    public void b(Object obj) {
        this.f = obj;
        a(obj);
    }

    public void b(List list) {
        if (this.g == null || this.g.size() <= 0) {
            this.g = new LinkedList();
        } else {
            this.g.clear();
        }
        this.g.addAll(list);
        a(list);
    }

    public View c() {
        return this.h;
    }
}
