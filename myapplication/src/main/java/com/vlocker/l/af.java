package com.vlocker.l;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.vlocker.b.p;

class af implements OnSeekBarChangeListener {
    final /* synthetic */ j a;
    final /* synthetic */ c b;
    final /* synthetic */ ae c;

    af(ae aeVar, j jVar, c cVar) {
        this.c = aeVar;
        this.a = jVar;
        this.b = cVar;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            int i2 = i + 26;
            if (this.c.h != null) {
                this.c.h.setLevel(i2 * 35);
            }
            this.c.a.r.a((float) i2);
            this.b.b(i2);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        p.a(this.c.a.b, "Vlocker_Slide_Brightness_PPC_TF", new String[0]);
        if (this.c.f.a(b.SWITCH_OFF)) {
            this.c.a(b.SWITCH_OFF);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.c.f.a(seekBar.getProgress());
    }
}
