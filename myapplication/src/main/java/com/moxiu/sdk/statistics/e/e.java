package com.moxiu.sdk.statistics.e;

public enum e {
    noNetStatus(0),
    wifiNetStatus(1),
    twoGNetStatus(2),
    threeGNetStatus(3),
    fourNetStatus(4);
    
    private int f;

    private e(int i) {
        this.f = i;
    }
}
