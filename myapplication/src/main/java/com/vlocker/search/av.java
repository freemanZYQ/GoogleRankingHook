package com.vlocker.search;

import com.moxiu.b.b.a;
import java.util.ArrayList;
import java.util.List;

class av implements a {
    final /* synthetic */ aw a;
    final /* synthetic */ at b;

    av(at atVar, aw awVar) {
        this.b = atVar;
        this.a = awVar;
    }

    public void a(int i, String str) {
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        new ArrayList().addAll(list);
        if (list != null && list.size() > 0) {
            ac acVar = new ac();
            acVar.a(this.b.a(list));
            acVar.a("chars");
            acVar.b("热门标签");
            if (!(this.a == null || this.a.a() == null)) {
                this.a.a().add(acVar);
                this.b.b.add(acVar);
            }
        }
        this.b.notifyDataSetChanged();
    }
}
