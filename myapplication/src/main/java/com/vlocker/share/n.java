package com.vlocker.share;

import android.content.Intent;

class n implements Runnable {
    final /* synthetic */ h a;

    n(h hVar) {
        this.a = hVar;
    }

    public void run() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.a.m);
            intent.addFlags(268435456);
            intent.setClassName("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity");
            this.a.e.startActivity(intent);
        } catch (Exception e) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.TEXT", this.a.m);
            intent2.addFlags(268435456);
            intent2.setPackage("com.sina.weibo");
            this.a.e.startActivity(intent2);
            e.printStackTrace();
        }
    }
}
