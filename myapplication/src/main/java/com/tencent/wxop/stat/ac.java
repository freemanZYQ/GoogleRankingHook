package com.tencent.wxop.stat;

final /* synthetic */ class ac {
    static final /* synthetic */ int[] a = new int[w.values().length];

    static {
        try {
            a[w.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[w.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[w.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[w.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[w.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[w.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[w.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
