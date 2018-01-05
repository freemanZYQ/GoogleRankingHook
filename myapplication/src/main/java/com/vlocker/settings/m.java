package com.vlocker.settings;

import com.vlocker.locker.R;

public enum m {
    Introduction(R.string.draw_lock_pattern, k.Cancel, l.ContinueDisabled, -1, true),
    HelpScreen(R.string.lockpattern_settings_help_how_to_record, k.Gone, l.Ok, -1, false),
    ChoiceTooShort(R.string.lockpattern_recording_incorrect_too_short, k.Retry, l.ContinueDisabled, -1, true),
    FirstChoiceValid(R.string.lockpattern_pattern_entered_header, k.Retry, l.Continue, -1, false),
    NeedToConfirm(R.string.lockpattern_need_to_confirm, k.Cancel, l.ConfirmDisabled, -1, true),
    ConfirmWrong(R.string.lockpattern_need_to_unlock_wrong, k.Cancel, l.ConfirmDisabled, -1, true),
    ChoiceConfirmed(R.string.lockpattern_pattern_confirmed_header, k.Cancel, l.Confirm, -1, false);
    
    final int h;
    final k i;
    final l j;
    final int k;
    final boolean l;

    private m(int i, k kVar, l lVar, int i2, boolean z) {
        this.h = i;
        this.i = kVar;
        this.j = lVar;
        this.k = i2;
        this.l = z;
    }
}
