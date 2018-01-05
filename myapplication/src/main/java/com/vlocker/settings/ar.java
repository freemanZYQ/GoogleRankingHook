package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;

class ar implements OnClickListener {
    private GuideWindowActivity a;

    public ar(GuideWindowActivity guideWindowActivity) {
        this.a = guideWindowActivity;
    }

    public void onClick(View view) {
        this.a.finish();
    }
}
