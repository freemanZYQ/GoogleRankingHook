package com.vlocker.ui.widget.a;

public class s extends q {
    public int a;

    public void a(String str) {
        if (str == null) {
            return;
        }
        if ("Sun".equals(str)) {
            this.a = 5;
        } else if ("SUN".equals(str)) {
            this.a = 1;
        } else if ("Sunday".equals(str)) {
            this.a = 4;
        } else if ("SUNDAY".equals(str)) {
            this.a = 2;
        } else if ("zhou".equals(str)) {
            this.a = 3;
        } else if ("xingqi".equals(str)) {
            this.a = 7;
        } else if ("libai".equals(str)) {
            this.a = 8;
        } else {
            this.a = Integer.parseInt(str);
        }
    }
}
