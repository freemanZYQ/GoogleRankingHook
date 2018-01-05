package com.vlocker.settings;

class s implements Runnable {
    final /* synthetic */ CustomWallPaperActivity a;

    s(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public void run() {
        this.a.setResult(-1);
        this.a.b();
    }
}
