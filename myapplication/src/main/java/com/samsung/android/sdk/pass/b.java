package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintManager.EnrollFinishListener;
import com.samsung.android.sdk.pass.SpassFingerprint.RegisterListener;

final class b implements EnrollFinishListener {
    private final /* synthetic */ RegisterListener a;

    b(RegisterListener registerListener) {
        this.a = registerListener;
    }

    public final void onEnrollFinish() {
        this.a.onFinished();
    }
}
