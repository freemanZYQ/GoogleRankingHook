package com.inveno.se.model;

public class b {
    public static int a(int[] iArr) {
        int i = 0;
        if (iArr == null || iArr.length == 0) {
            throw new RuntimeException("baseType can not be null !");
        }
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }
}
