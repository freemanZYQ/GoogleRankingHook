package com.vlocker.setting;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.setting.a.a.e;
import com.vlocker.settings.SettingsActivity;

class i extends Handler {
    final /* synthetic */ ManualRepairActivity a;

    i(ManualRepairActivity manualRepairActivity) {
        this.a = manualRepairActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (!(this.a.m == null || this.a.m.getmFollowUp() == null || !this.a.m.getmFollowUp().contains("open"))) {
                    Context context;
                    String str;
                    String[] strArr;
                    if (this.a.m.finished()) {
                        context = this.a;
                        str = "Vlocker_Manual_Rescue_Locker_PPC_TF";
                        strArr = new String[6];
                        strArr[0] = "rescue_name";
                        strArr[1] = this.a.m.getTaskName();
                        strArr[2] = "Do";
                        strArr[3] = "Success";
                        strArr[4] = "status";
                        strArr[5] = a.a(this.a).bp() ? "F" : "NF";
                        p.a(context, str, strArr);
                    } else {
                        context = this.a;
                        str = "Vlocker_Manual_Rescue_Locker_PPC_TF";
                        strArr = new String[6];
                        strArr[0] = "rescue_name";
                        strArr[1] = this.a.m.getTaskName();
                        strArr[2] = "Do";
                        strArr[3] = "Fail";
                        strArr[4] = "status";
                        strArr[5] = a.a(this.a).bp() ? "F" : "NF";
                        p.a(context, str, strArr);
                    }
                }
                if (!com.vlocker.setting.a.a.getInstance().finished()) {
                    this.a.g.notifyDataSetChanged();
                    return;
                } else if ("from_repair".equals(this.a.i)) {
                    if (this.a.k != null && this.a.k.size() == 1 && !TextUtils.isEmpty(((e) this.a.k.get(0)).getGuideUrl())) {
                        SettingsActivity.a(this.a);
                    } else if (OneKeySettingActivity.a() != null) {
                        OneKeySettingActivity.a().g();
                    }
                    this.a.finish();
                    return;
                } else {
                    this.a.g.notifyDataSetChanged();
                    return;
                }
            default:
                return;
        }
    }
}
