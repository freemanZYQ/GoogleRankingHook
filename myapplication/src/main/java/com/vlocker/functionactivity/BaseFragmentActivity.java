package com.vlocker.functionactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.vlocker.security.MoSecurityApplication;

public class BaseFragmentActivity extends FragmentActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MoSecurityApplication.a().a(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        MoSecurityApplication.a().b(this);
    }
}
