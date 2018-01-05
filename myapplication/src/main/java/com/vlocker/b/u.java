package com.vlocker.b;

import android.content.Context;
import java.io.File;

final class u extends Thread {
    final /* synthetic */ File a;
    final /* synthetic */ Context b;

    u(File file, Context context) {
        this.a = file;
        this.b = context;
    }

    public void run() {
        try {
            j.a(this.b, j.a(this.a), j.a(8), this.a);
        } catch (Exception e) {
        }
    }
}
