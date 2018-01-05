package com.vlocker.theme.a;

import android.support.v7.widget.ak;
import android.support.v7.widget.bj;
import android.view.View;
import android.view.ViewGroup;
import com.vlocker.locker.R;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.c.b;
import java.util.ArrayList;
import java.util.List;

public class d extends ak {
    private List a = new ArrayList();
    private e b;
    private int c = -1;

    public int a() {
        return this.a.size();
    }

    public /* synthetic */ bj a(ViewGroup viewGroup, int i) {
        return c(viewGroup, i);
    }

    public void a(e eVar) {
        this.b = eVar;
    }

    public void a(f fVar, int i) {
        b bVar = (b) this.a.get(i);
        boolean z = i == this.c;
        fVar.l.setText(bVar.c());
        fVar.l.setTextSize(bVar.b() == 2 ? 14.0f : 12.0f);
        if (bVar.b() == 2 || bVar.b() == 1) {
            fVar.l.setTextColor(MoSecurityApplication.a().getResources().getColor(z ? R.color.oksetting_task_text_black : R.color.white));
        } else {
            fVar.l.setTextColor(MoSecurityApplication.a().getResources().getColor(R.color.v2_setting_item_title_des));
        }
        fVar.m.setSelected(z);
    }

    public void a(List list) {
        this.a = list;
        c();
    }

    public long b(int i) {
        return (long) i;
    }

    public f c(ViewGroup viewGroup, int i) {
        return new f(View.inflate(MoSecurityApplication.a(), R.layout.l_theme_unlock_font_item, null), this.b);
    }

    public void c(int i) {
        this.c = i;
        c();
    }
}
