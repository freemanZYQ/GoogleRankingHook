package com.tencent.wxop.stat;

public enum w {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int h;

    private w(int i) {
        this.h = i;
    }

    public static w a(int i) {
        for (w wVar : values()) {
            if (i == wVar.h) {
                return wVar;
            }
        }
        return null;
    }
}
