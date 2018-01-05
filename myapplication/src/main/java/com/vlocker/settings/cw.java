package com.vlocker.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.vlocker.b.p;

class cw implements OnDismissListener {
    final /* synthetic */ V2SettingToolboxActivity a;

    cw(V2SettingToolboxActivity v2SettingToolboxActivity) {
        this.a = v2SettingToolboxActivity;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.a.i != null && this.a.i.size() == 1) {
            p.a(this.a, "Vlocker_Done_Cam_Select_PPC_TF", "camera", ((dc) this.a.i.get(0)).b);
        }
    }
}
