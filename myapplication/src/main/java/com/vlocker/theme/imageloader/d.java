package com.vlocker.theme.imageloader;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class d extends FutureTask {
    final /* synthetic */ a a;

    d(a aVar, Callable callable) {
        this.a = aVar;
        super(callable);
    }

    protected void done() {
        try {
            this.a.c(get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.a.c(null);
        }
    }
}
