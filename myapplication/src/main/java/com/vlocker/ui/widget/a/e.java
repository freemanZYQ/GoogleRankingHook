package com.vlocker.ui.widget.a;

public class e extends q {
    public int a;

    public void a(String str) {
        if (str == null) {
            return;
        }
        if ("M/D".equals(str)) {
            this.a = 1;
        } else if ("Jun.1".equals(str)) {
            this.a = 5;
        } else if ("JUN.1".equals(str)) {
            this.a = 14;
        } else if ("Jun.1st".equals(str)) {
            this.a = 6;
        } else if ("M-D".equals(str)) {
            this.a = 0;
        } else if ("M.D".equals(str)) {
            this.a = 8;
        } else if ("M/D".equals(str)) {
            this.a = 15;
        } else if ("numMD".equals(str)) {
            this.a = 7;
        } else if ("numYMD".equals(str)) {
            this.a = 9;
        } else if ("numMDY".equals(str)) {
            this.a = 10;
        } else if ("nongliY".equals(str)) {
            this.a = 12;
        } else if ("nongliMD".equals(str)) {
            this.a = 13;
        } else if ("Y.M.D".equals(str)) {
            this.a = 16;
        } else if ("Y-M-D".equals(str)) {
            this.a = 17;
        } else if ("Y/M/D".equals(str)) {
            this.a = 18;
        } else {
            this.a = Integer.parseInt(str);
        }
    }
}
