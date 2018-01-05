package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;

final class d implements Runnable {
    private /* synthetic */ c a;
    private final /* synthetic */ FingerprintEvent b;

    d(c cVar, FingerprintEvent fingerprintEvent) {
        this.a = cVar;
        this.b = fingerprintEvent;
    }

    public final void run() {
        if (this.a.a != null) {
            switch (this.b.eventId) {
                case 11:
                    this.a.a.onReady();
                    return;
                case 12:
                    this.a.a.onStarted();
                    return;
                default:
                    return;
            }
        }
    }
}
