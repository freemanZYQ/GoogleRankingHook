package com.vlocker.m.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.vlocker.msg.an;
import com.vlocker.settings.GuideWindowActivity;

public class c extends a {
    public c(Context context) {
        super(context);
    }

    public void a() {
        try {
            if (an.a(this.a)) {
                super.a();
                return;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity"));
            if (this.a.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
                this.a.startActivity(intent);
                GuideWindowActivity.a(this.a, 2, 1);
                return;
            }
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.StartupSpeedActivity"));
            this.a.startActivity(intent);
            GuideWindowActivity.a(this.a, 2, 2);
        } catch (Exception e) {
            Toast.makeText(this.a, "当前设置项不支持你的手机", 0).show();
            e.printStackTrace();
        }
    }
}
