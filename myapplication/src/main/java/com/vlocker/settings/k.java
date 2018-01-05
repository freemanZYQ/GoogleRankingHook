package com.vlocker.settings;

import com.vlocker.locker.R;

enum k {
    Cancel(17039360, true),
    CancelDisabled(17039360, false),
    Retry(R.string.lockpattern_retry_button_text, true),
    RetryDisabled(R.string.lockpattern_retry_button_text, false),
    Gone(-1, false);
    
    final int f;
    final boolean g;

    private k(int i, boolean z) {
        this.f = i;
        this.g = z;
    }
}
