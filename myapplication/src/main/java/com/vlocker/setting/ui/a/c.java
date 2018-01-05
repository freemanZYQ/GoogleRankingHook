package com.vlocker.setting.ui.a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.setting.ManualRepairActivity;
import com.vlocker.setting.a.a.e;
import com.vlocker.setting.ui.a;

class c implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ b b;

    c(b bVar, e eVar) {
        this.b = bVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        if (this.b.d.b instanceof ManualRepairActivity) {
            ((ManualRepairActivity) this.b.d.b).a(this.a);
        }
        if (TextUtils.isEmpty(this.a.getGuideUrl())) {
            Intent intent = this.a.getIntent();
            if (intent != null) {
                p.a(this.b.d.b, "Vlocker_Manual_Rescue_Locker_PPC_TF", "rescue_name", this.a.getTaskName());
                this.b.d.b.startActivity(intent);
                a.a(this.b.d.b);
                return;
            }
            return;
        }
        try {
            this.b.d.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a.getGuideUrl())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
