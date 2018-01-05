package com.vlocker.theme.activity;

import android.os.Message;
import com.vlocker.b.i;

class c implements Runnable {
    final /* synthetic */ LocationThemeActivity a;

    c(LocationThemeActivity locationThemeActivity) {
        this.a = locationThemeActivity;
    }

    public void run() {
        this.a.g.clear();
        this.a.g = this.a.b(i.j);
        this.a.h.clear();
        this.a.h = this.a.b(i.i);
        int size = this.a.g.size() + this.a.h.size();
        Message message = new Message();
        if (size == 1) {
            message.what = 1;
            this.a.a.sendMessage(message);
        } else if (size > 1) {
            message.what = 2;
            this.a.a.sendMessage(message);
        }
    }
}
