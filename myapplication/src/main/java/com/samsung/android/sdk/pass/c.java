package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint.IdentifyListener;

final class c implements Runnable {
    private /* synthetic */ b a;
    private final /* synthetic */ FingerprintEvent b;
    private final /* synthetic */ IdentifyListener c;

    c(b bVar, FingerprintEvent fingerprintEvent, IdentifyListener identifyListener) {
        this.a = bVar;
        this.b = fingerprintEvent;
        this.c = identifyListener;
    }

    public final void run() {
        switch (this.b.eventId) {
            case 11:
                this.c.onReady();
                return;
            case 12:
                this.c.onStarted();
                return;
            case 13:
                this.a.b.c = this.b.getFingerIndex();
                if (this.b.eventStatus == 12) {
                    this.a.b.d = this.b.getImageQualityFeedback();
                }
                IdentifyListener identifyListener = this.c;
                this.a.b;
                identifyListener.onFinished(SpassFingerprint.a(this.b.eventStatus));
                this.a.b.c = -1;
                this.a.b.d = null;
                if (!this.a.b.p) {
                    this.a.b.p = true;
                    try {
                        SpassFingerprint.b(this.a.b, "IdentifyListener.onFinished");
                        return;
                    } catch (SecurityException e) {
                        throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
                    }
                }
                return;
            default:
                return;
        }
    }
}
