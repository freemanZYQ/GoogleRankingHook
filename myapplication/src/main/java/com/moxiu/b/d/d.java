package com.moxiu.b.d;

public enum d {
    noNetStatus(0),
    wifiNetStatus(1),
    threeGNetStatus(2),
    twoGNetStatus(3),
    fourNetStatus(4);
    
    private int f;

    private d(int i) {
        this.f = i;
    }
}
