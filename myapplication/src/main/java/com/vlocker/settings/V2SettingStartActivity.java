package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.i;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.service.NotificationListener;
import com.vlocker.setting.a.b;
import com.vlocker.ui.cover.LockerService;

public class V2SettingStartActivity extends Activity implements OnClickListener {
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_lock:
                a.a((Context) this).m(true);
                LockerService.a((Context) this);
                startActivity(new Intent(this, SettingsActivity.class));
                if (VERSION.SDK_INT >= 18 && b.CheckNotifiServiceValid(this)) {
                    startService(new Intent(this, NotificationListener.class));
                }
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.setting_float);
        findViewById(R.id.start_lock).setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("from");
        if (stringExtra != null && stringExtra.equals("close")) {
            Toast.makeText(this, getResources().getString(R.string.v2_lock_close_tip), 0).show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!a.a((Context) this).O()) {
            i.c();
            Process.killProcess(Process.myPid());
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyUp(i, keyEvent);
        }
        MoSecurityApplication.a().e();
        Process.killProcess(Process.myPid());
        return true;
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
