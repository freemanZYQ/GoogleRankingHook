package com.vlocker.locker.c;

import com.vlocker.m.r;

public class az implements Runnable {
    int a;

    public az(int i) {
        this.a = i;
    }

    public void run() {
        r.a().a(this.a, new ba(this));
    }
}
