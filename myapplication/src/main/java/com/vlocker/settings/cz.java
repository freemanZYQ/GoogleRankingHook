package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.b.p;

class cz implements OnItemClickListener {
    final /* synthetic */ V2SettingToolboxActivity a;

    cz(V2SettingToolboxActivity v2SettingToolboxActivity) {
        this.a = v2SettingToolboxActivity;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.i.size() > 1) {
            p.a(this.a, "Vlocker_Done_Cam_Select_PPC_TF", "camera", ((dc) this.a.i.get(i)).b);
        }
        this.a.h.z(((dc) this.a.i.get(i)).b);
        this.a.h.B(((dc) this.a.i.get(i)).a);
        String str = ((dc) this.a.i.get(i)).c;
        if (!(str == null || "".equals(str))) {
            this.a.h.A(str);
        }
        this.a.m.notifyDataSetChanged();
        this.a.c();
        this.a.j.postDelayed(new da(this), 200);
    }
}
