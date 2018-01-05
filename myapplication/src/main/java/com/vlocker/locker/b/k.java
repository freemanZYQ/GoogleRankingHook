package com.vlocker.locker.b;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class k implements OnSeekBarChangeListener {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.a.b(i);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
