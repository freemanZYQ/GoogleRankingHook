package com.vlocker.ui.cover;

import android.os.FileObserver;
import android.util.Log;

class m extends FileObserver {
    public m(String str, int i) {
        super(str, i);
    }

    public void onEvent(int i, String str) {
        Log.d("LockPatternUtils", "file path" + str);
        if ("gesture.key".equals(str)) {
            Log.d("LockPatternUtils", "lock pattern file changed");
            l.c.set(l.b.length() > 0);
        }
    }
}
