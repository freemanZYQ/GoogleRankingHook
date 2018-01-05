package com.vlocker.ui.widget.c;

import java.util.Stack;

public class a {
    String a;

    public a(String str) {
        this.a = str;
    }

    private boolean a(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b() {
        /*
        r9 = this;
        r7 = 46;
        r1 = 0;
        r4 = new java.util.Stack;
        r4.<init>();
        r0 = new java.lang.String;
        r0.<init>();
        r3 = r0;
        r0 = r1;
    L_0x000f:
        r2 = r9.a;
        r2 = r2.length();
        if (r0 >= r2) goto L_0x0186;
    L_0x0017:
        r2 = r9.a;
        r2 = r2.charAt(r0);
        r2 = java.lang.Character.isDigit(r2);
        if (r2 != 0) goto L_0x002b;
    L_0x0023:
        r2 = r9.a;
        r2 = r2.charAt(r0);
        if (r2 != r7) goto L_0x008d;
    L_0x002b:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = "@";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r8 = r0;
        r0 = r2;
        r2 = r8;
    L_0x0042:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r0);
        r5 = r9.a;
        r0 = r2 + 1;
        r2 = r5.charAt(r2);
        r2 = r3.append(r2);
        r2 = r2.toString();
        r3 = r9.a;
        r3 = r3.length();
        if (r0 >= r3) goto L_0x0077;
    L_0x0063:
        r3 = r9.a;
        r3 = r3.charAt(r0);
        r3 = java.lang.Character.isDigit(r3);
        if (r3 != 0) goto L_0x01c2;
    L_0x006f:
        r3 = r9.a;
        r3 = r3.charAt(r0);
        if (r3 == r7) goto L_0x01c2;
    L_0x0077:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r2 = r3.append(r2);
        r3 = "@";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r2;
        goto L_0x000f;
    L_0x008d:
        r5 = r9.a;
        r2 = r0 + 1;
        r5 = r5.charAt(r0);
        switch(r5) {
            case 40: goto L_0x009d;
            case 41: goto L_0x00a5;
            case 42: goto L_0x0141;
            case 43: goto L_0x0104;
            case 44: goto L_0x0098;
            case 45: goto L_0x0104;
            case 46: goto L_0x0098;
            case 47: goto L_0x0141;
            default: goto L_0x0098;
        };
    L_0x0098:
        r0 = r3;
    L_0x0099:
        r3 = r0;
        r0 = r2;
        goto L_0x000f;
    L_0x009d:
        r0 = "(";
        r4.push(r0);
        r0 = r3;
        goto L_0x0099;
    L_0x00a5:
        r0 = r4.peek();
        r5 = "(";
        if (r0 == r5) goto L_0x00eb;
    L_0x00ae:
        r0 = r4.pop();
        r0 = (java.lang.String) r0;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r3 = r5.append(r3);
        r3 = r3.append(r0);
        r3 = r3.toString();
        r5 = r0.length();
        r6 = 1;
        if (r5 != r6) goto L_0x00a5;
    L_0x00cc:
        r0 = r0.charAt(r1);
        r0 = r9.a(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x00d6:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r3);
        r3 = "@";
        r0 = r0.append(r3);
        r3 = r0.toString();
        goto L_0x00a5;
    L_0x00eb:
        r4.pop();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r3);
        r3 = "@";
        r0 = r0.append(r3);
        r3 = r0.toString();
        r0 = r3;
        goto L_0x0099;
    L_0x0104:
        r0 = r4.empty();
        if (r0 != 0) goto L_0x0132;
    L_0x010a:
        r0 = r4.peek();
        r6 = "(";
        if (r0 == r6) goto L_0x0132;
    L_0x0113:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r0.append(r3);
        r0 = r4.pop();
        r0 = (java.lang.String) r0;
        r0 = r3.append(r0);
        r3 = "@";
        r0 = r0.append(r3);
        r3 = r0.toString();
        goto L_0x0104;
    L_0x0132:
        r0 = new java.lang.Character;
        r0.<init>(r5);
        r0 = java.lang.String.valueOf(r0);
        r4.push(r0);
        r0 = r3;
        goto L_0x0099;
    L_0x0141:
        r0 = r4.empty();
        if (r0 != 0) goto L_0x0178;
    L_0x0147:
        r0 = r4.peek();
        r6 = "*";
        if (r0 == r6) goto L_0x0159;
    L_0x0150:
        r0 = r4.peek();
        r6 = "/";
        if (r0 != r6) goto L_0x0178;
    L_0x0159:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r0.append(r3);
        r0 = r4.pop();
        r0 = (java.lang.String) r0;
        r0 = r3.append(r0);
        r3 = "@";
        r0 = r0.append(r3);
        r3 = r0.toString();
        goto L_0x0141;
    L_0x0178:
        r0 = new java.lang.Character;
        r0.<init>(r5);
        r0 = java.lang.String.valueOf(r0);
        r4.push(r0);
        goto L_0x0098;
    L_0x0186:
        r0 = r4.size();
        r1 = r4.listIterator(r0);
    L_0x018e:
        r0 = r1.hasPrevious();
        if (r0 == 0) goto L_0x01b3;
    L_0x0194:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r0.append(r3);
        r0 = r1.previous();
        r0 = (java.lang.String) r0;
        r0 = r2.append(r0);
        r2 = "@";
        r0 = r0.append(r2);
        r3 = r0.toString();
        goto L_0x018e;
    L_0x01b3:
        r0 = r3.trim();
        r1 = "   +\\. ";
        r2 = ". ";
        r0 = r0.replaceAll(r1, r2);
        return r0;
    L_0x01c2:
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.ui.widget.c.a.b():java.lang.String");
    }

    public double a() {
        String b = b();
        Stack stack = new Stack();
        String[] split = b.split("@");
        double d = 0.0d;
        int i = 0;
        while (i < split.length) {
            double d2;
            if (split[i].length() == 0) {
                d2 = d;
            } else {
                char charAt = split[i].charAt(0);
                if (a(charAt)) {
                    d = a(Double.parseDouble((String) stack.pop()), Double.parseDouble((String) stack.pop()), charAt);
                    stack.push(String.valueOf(d));
                    d2 = d;
                } else {
                    stack.push(split[i]);
                    d2 = d;
                }
            }
            i++;
            d = d2;
        }
        return d;
    }

    public double a(double d, double d2, char c) {
        switch (c) {
            case '*':
                return d * d2;
            case '+':
                return d + d2;
            case '-':
                return d - d2;
            case '/':
                return d / d2;
            default:
                return -1.0d;
        }
    }
}
