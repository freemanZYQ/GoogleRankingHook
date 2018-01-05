package com.vlocker.theme.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class q implements OnEditorActionListener {
    final /* synthetic */ UnlockTextEditActivity a;

    q(UnlockTextEditActivity unlockTextEditActivity) {
        this.a = unlockTextEditActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 66;
    }
}
