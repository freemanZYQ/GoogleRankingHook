package com.moxiu.sdk.statistics.b;

import com.moxiu.sdk.statistics.e.f;

/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[f.values().length];

    static {
        try {
            a[f.normal.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[f.debug.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[f.formal.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[f.check.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
