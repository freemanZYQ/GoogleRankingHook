package com.vlocker.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.vlocker.b.a;
import com.vlocker.b.p;

class az implements OnItemClickListener {
    final /* synthetic */ ax a;

    az(ax axVar) {
        this.a = axVar;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            this.a.e.h = false;
            ap.a(this.a.e, view);
            if (this.a.j != null) {
                a.a(this.a.e, (com.moxiu.b.a.a) this.a.a.get(i), view, "search_site", null, false, null);
                this.a.j.notifyDataSetInvalidated();
                p.a(this.a.e, "Vlock_Click_Service_Search_PPC_TF", "service_name", ((com.moxiu.b.a.a) this.a.a.get(i)).h());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
