package com.vlocker.new_theme.activity;

import android.os.Message;
import com.vlocker.theme.f.e;

class n implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ SearchActivity b;

    n(SearchActivity searchActivity, int i) {
        this.b = searchActivity;
        this.a = i;
    }

    public void run() {
        if (this.b.c != null) {
            this.b.c.clear();
        }
        this.b.c = e.b(this.b, this.a);
        Message message = new Message();
        if (this.b.c == null || this.b.c.size() <= 0) {
            try {
                this.b.e = false;
                message.what = 280;
                this.b.n.sendMessage(message);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        message.what = 281;
        this.b.n.sendMessage(message);
    }
}
