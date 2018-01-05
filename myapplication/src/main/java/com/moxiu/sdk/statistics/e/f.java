package com.moxiu.sdk.statistics.e;

public enum f {
    normal(0),
    debug(1),
    formal(2),
    check(3);
    
    private int e;

    private f(int i) {
        this.e = i;
    }

    public static f a(int i) {
        for (f fVar : values()) {
            if (fVar.a() == i) {
                return fVar;
            }
        }
        return normal;
    }

    public int a() {
        return this.e;
    }
}
