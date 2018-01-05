package com.samsung.android.sdk.pass;

public class SpassInvalidStateException extends IllegalStateException {
    public static final int STATUS_OPERATION_DENIED = 1;
    private int a = 0;

    public SpassInvalidStateException(String str, int i) {
        super(str);
        this.a = i;
    }

    public int getType() {
        return this.a;
    }
}
