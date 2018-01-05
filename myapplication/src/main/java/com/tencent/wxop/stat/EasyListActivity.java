package com.tencent.wxop.stat;

import android.app.ListActivity;
import android.content.Context;

public class EasyListActivity extends ListActivity {
    protected void onPause() {
        super.onPause();
        x.b((Context) this);
    }

    protected void onResume() {
        super.onResume();
        x.a((Context) this);
    }
}
