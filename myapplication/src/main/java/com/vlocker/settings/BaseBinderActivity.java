package com.vlocker.settings;

import android.app.Activity;
import android.os.Bundle;
import com.vlocker.security.MoSecurityApplication;

public class BaseBinderActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MoSecurityApplication.a().a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        MoSecurityApplication.a().b(this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
