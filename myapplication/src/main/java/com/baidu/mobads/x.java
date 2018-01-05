package com.baidu.mobads;

final class x implements Runnable {
    final /* synthetic */ Runnable a;

    x(Runnable runnable) {
        this.a = runnable;
    }

    public void run() {
        this.a.run();
    }
}
