package com.vlocker.l;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.vlocker.locker.R;
import com.vlocker.settings.dc;

class n implements OnItemClickListener {
    final /* synthetic */ j a;

    n(j jVar) {
        this.a = jVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if ("vlocker_alarm".equals(((dc) this.a.w.get(i)).b)) {
            this.a.j.b();
        } else if ("vlocker_flashlight".equals(((dc) this.a.w.get(i)).b)) {
            this.a.h.d((ImageView) view.findViewById(R.id.btn_toolbox_item));
        } else if ("vlocker_calculator".equals(((dc) this.a.w.get(i)).b)) {
            this.a.i.b();
        } else if ("vlocker_boost".equals(((dc) this.a.w.get(i)).b)) {
            this.a.k.b();
        }
    }
}
