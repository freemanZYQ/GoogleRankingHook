package com.vlocker.locker.c;

import com.qq.e.comm.constants.ErrorCode.AdError;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.settings.QuestionActivity;
import com.vlocker.ui.cover.h;
import com.vlocker.ui.widget.view.k;

class al implements k {
    final /* synthetic */ ai a;

    al(ai aiVar) {
        this.a = aiVar;
    }

    public void a() {
        p.b("101000", "101003");
        this.a.c.f((int) AdError.PLACEMENT_ERROR);
        this.a.e();
        this.a.k();
        this.a.m.aH(true);
        if ("moxiu-launcher".equals(j.p(this.a.a))) {
            p.a(this.a.a, "Vlocker_Times_Unlock_PPC_TF", "unlock_type", "slide");
        }
        p.a(this.a.a, "v_unlock_success", "101000", "101003");
    }

    public void b() {
        if (h.h == 1 && h.a == 1) {
            this.a.c.a("main_page", true);
        } else {
            this.a.c.b(false);
        }
        this.a.f();
    }

    public void c() {
        QuestionActivity.b(this.a.a);
    }

    public void d() {
        if (this.a.m.cz() && (this.a.m.cA() == 0 || this.a.m.cA() == 1)) {
            this.a.k.j();
            if (!this.a.m.cF()) {
                this.a.o.postDelayed(new am(this), 2600);
            }
            if ("moxiu-launcher".equals(j.p(this.a.a))) {
                p.a(this.a.a, "Vlocker_Wrong_Num_Password_PPC_TF", "WordNotice", (this.a.m.cA() + 1) + "");
                return;
            }
            return;
        }
        if ((this.a.m.cA() == 2 || this.a.m.cA() == 3) && !this.a.m.cF()) {
            this.a.j();
        }
        if ("moxiu-launcher".equals(j.p(this.a.a))) {
            p.a(this.a.a, "Vlocker_Wrong_Num_Password_PPC_TF", new String[0]);
        }
    }
}
