package com.vlocker.b;

import android.os.Build.VERSION;
import com.moxiu.sdk.statistics.a;
import com.vlocker.theme.f.b;
import java.util.LinkedHashMap;

final class s extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ LinkedHashMap b;

    s(String str, LinkedHashMap linkedHashMap) {
        this.a = str;
        this.b = linkedHashMap;
    }

    public void run() {
        if (!b.p() || VERSION.SDK_INT <= 18) {
            a.a(this.a, this.b);
            return;
        }
        try {
            a.a(this.a, this.b);
        } catch (Exception e) {
        }
    }
}
