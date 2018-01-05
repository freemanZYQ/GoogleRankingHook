package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint.IdentifyListener;

final class e implements Runnable {
    private /* synthetic */ c a;
    private final /* synthetic */ FingerprintEvent b;
    private final /* synthetic */ IdentifyListener c;

    e(c cVar, FingerprintEvent fingerprintEvent, IdentifyListener identifyListener) {
        this.a = cVar;
        this.b = fingerprintEvent;
        this.c = identifyListener;
    }

    public final void run() {
        if (this.b.eventId == 13) {
            this.a.c.c = this.b.getFingerIndex();
            if (this.b.eventStatus == 12) {
                this.a.c.d = this.b.getImageQualityFeedback();
            }
            IdentifyListener identifyListener = this.c;
            this.a.c;
            identifyListener.onFinished(SpassFingerprint.a(this.b.eventStatus));
            this.c.onCompleted();
            this.a.c.c = -1;
            this.a.c.d = null;
            if (this.a.c.u != null) {
                this.a.c.u = null;
            }
            if (!this.a.c.p) {
                this.a.c.p = true;
                try {
                    SpassFingerprint.b(this.a.c, "IdentifyListener.onFinished");
                } catch (SecurityException e) {
                    throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
                }
            }
        }
    }
}
