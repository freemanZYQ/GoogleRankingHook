package com.vlocker.new_theme.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class e implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    e() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "NetWork #" + this.a.getAndIncrement());
        thread.setPriority(4);
        return thread;
    }
}
