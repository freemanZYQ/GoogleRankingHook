package com.vlocker.f;

import java.util.Arrays;

public class a {
    public String a;
    public String[] b = new String[3];
    public String[] c = new String[3];
    public String[] d = new String[3];
    public String e;
    public String f;
    public String g;

    public String toString() {
        return "name " + this.a + "\n" + "cls " + Arrays.toString(this.b) + "\n" + "fpwp " + Arrays.toString(this.c) + "\n" + "fpwnp " + Arrays.toString(this.d) + "\n";
    }
}
