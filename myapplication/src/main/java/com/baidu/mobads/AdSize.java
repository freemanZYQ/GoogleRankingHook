package com.baidu.mobads;

public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13);
    
    private int a;

    private AdSize(int i) {
        this.a = i;
    }

    public int getValue() {
        return this.a;
    }
}
