package com.moxiu.b.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class s implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    s() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "NetWork #" + this.a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
