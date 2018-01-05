package com.vlocker.b;

public enum o {
    noNetStatus(0),
    wifiNetStatus(1),
    threeGNetStatus(2),
    twoGNetStatus(3),
    fourNetStatus(4);
    
    private int f;

    private o(int i) {
        this.f = i;
    }
}
