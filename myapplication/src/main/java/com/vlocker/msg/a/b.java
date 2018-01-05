package com.vlocker.msg.a;

import com.moxiu.b.b.a;
import com.vlocker.b.p;
import java.util.ArrayList;
import java.util.List;

class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, String str) {
        this.a.b = null;
        this.a.c = null;
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        this.a.c = arrayList;
        if (this.a.c != null && this.a.c.size() > 0) {
            this.a.b = (com.moxiu.b.a.a) this.a.c.get(0);
            this.a.b.a(false);
            this.a.f = 0;
            for (int i = 0; i < this.a.c.size(); i++) {
                if (((com.moxiu.b.a.a) this.a.c.get(i)).h() != null) {
                    p.a(this.a.a, "Vlock_Get_MsgAD_PPC_TF", "msg_name", ((com.moxiu.b.a.a) this.a.c.get(i)).h(), "frequency", this.a.i + "");
                }
            }
        }
        this.a.h = false;
        c.a(this.a.a, this.a.b);
    }
}
