package com.vlocker.new_theme.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.ak;

public class i extends ak {
    final /* synthetic */ TabFragmentIndicator a;

    public i(TabFragmentIndicator tabFragmentIndicator, aa aaVar) {
        this.a = tabFragmentIndicator;
        super(aaVar);
    }

    public Fragment a(int i) {
        return (Fragment) this.a.r.get(i);
    }

    public int b() {
        return this.a.r.size();
    }
}
