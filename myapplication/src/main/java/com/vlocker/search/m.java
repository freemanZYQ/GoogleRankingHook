package com.vlocker.search;

class m implements Runnable {
    final /* synthetic */ BaiduSearchActivity a;

    m(BaiduSearchActivity baiduSearchActivity) {
        this.a = baiduSearchActivity;
    }

    public void run() {
        this.a.a.requestFocus();
    }
}
