package com.vlocker.setting.ui.a;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.vlocker.c.a;
import com.vlocker.setting.a.a.e;

public class b {
    public TextView a = null;
    public TextView b = null;
    public TextView c = null;
    final /* synthetic */ a d;
    private Button e = null;

    public b(a aVar) {
        this.d = aVar;
    }

    private void a(e eVar, int i) {
        if (!a.a(this.d.b).bQ() && eVar.getmFollowUp() != null && eVar.getmFollowUp().contains("manual")) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setText("去开启");
        } else if (eVar.finished()) {
            this.e.setVisibility(8);
            this.c.setVisibility(0);
        } else {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setText("去开启");
        }
        if (!TextUtils.isEmpty(eVar.getGuideUrl())) {
            this.e.setVisibility(0);
            this.c.setVisibility(8);
            this.e.setText("查看教程");
        }
        if (this.e.getVisibility() == 0) {
            this.e.setOnClickListener(new c(this, eVar));
        }
    }
}
