package com.vlocker.settings;

import com.vlocker.locker.R;

enum l {
    Continue(R.string.lockpattern_continue_button_text, true),
    ContinueDisabled(R.string.lockpattern_continue_button_text, false),
    Confirm(R.string.lockpattern_confirm_button_text, true),
    ConfirmDisabled(R.string.lockpattern_confirm_button_text, false),
    Ok(17039370, true);
    
    final int f;
    final boolean g;

    private l(int i, boolean z) {
        this.f = i;
        this.g = z;
    }
}
