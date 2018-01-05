package com.tencent.wxop.stat;

import android.app.Activity;
import android.content.Context;

public class EasyActivity extends Activity {
    protected void onPause() {
        super.onPause();
        x.b((Context) this);
    }

    protected void onResume() {
        super.onResume();
        x.a((Context) this);
    }
}
