package com.vlocker.weather.view;

public enum u {
    WAIT_FINISH(0),
    SYNC_DECODER(1),
    COVER(2);
    
    final int d;

    private u(int i) {
        this.d = i;
    }
}
