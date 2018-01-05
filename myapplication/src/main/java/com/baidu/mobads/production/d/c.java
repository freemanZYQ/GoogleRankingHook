package com.baidu.mobads.production.d;

import android.view.View;
import android.view.View.OnTouchListener;

class c implements OnTouchListener {
    int a;
    int b;
    int c;
    int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ View g;
    final /* synthetic */ int h;
    final /* synthetic */ int i;
    final /* synthetic */ b j;

    c(b bVar, int i, int i2, View view, int i3, int i4) {
        this.j = bVar;
        this.e = i;
        this.f = i2;
        this.g = view;
        this.h = i3;
        this.i = i4;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
        r8 = this;
        r4 = 15;
        r1 = 0;
        r0 = r8.j;
        r3 = r0.z;
        r0 = r10.getAction();	 Catch:{ Exception -> 0x0028 }
        switch(r0) {
            case 0: goto L_0x0011;
            case 1: goto L_0x00d3;
            case 2: goto L_0x0031;
            default: goto L_0x0010;
        };	 Catch:{ Exception -> 0x0028 }
    L_0x0010:
        return r1;
    L_0x0011:
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0028 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0028 }
        r8.a = r0;	 Catch:{ Exception -> 0x0028 }
        r0 = r10.getRawY();	 Catch:{ Exception -> 0x0028 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0028 }
        r8.b = r0;	 Catch:{ Exception -> 0x0028 }
        r0 = r8.a;	 Catch:{ Exception -> 0x0028 }
        r8.c = r0;	 Catch:{ Exception -> 0x0028 }
        r0 = r8.b;	 Catch:{ Exception -> 0x0028 }
        r8.d = r0;	 Catch:{ Exception -> 0x0028 }
        goto L_0x0010;
    L_0x0028:
        r0 = move-exception;
        r2 = com.baidu.mobads.j.j.a();
        r2.e(r0);
        goto L_0x0010;
    L_0x0031:
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0028 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.a;	 Catch:{ Exception -> 0x0028 }
        r0 = r0 - r2;
        r2 = r10.getRawY();	 Catch:{ Exception -> 0x0028 }
        r2 = (int) r2;	 Catch:{ Exception -> 0x0028 }
        r3 = r8.b;	 Catch:{ Exception -> 0x0028 }
        r5 = r2 - r3;
        r2 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.z;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.getLeft();	 Catch:{ Exception -> 0x0028 }
        r4 = r2 + r0;
        r2 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.z;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.getTop();	 Catch:{ Exception -> 0x0028 }
        r2 = r2 + r5;
        r3 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.z;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.getRight();	 Catch:{ Exception -> 0x0028 }
        r3 = r3 + r0;
        r0 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.z;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.getBottom();	 Catch:{ Exception -> 0x0028 }
        r0 = r0 + r5;
        if (r4 >= 0) goto L_0x007d;
    L_0x0071:
        r3 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.z;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.getWidth();	 Catch:{ Exception -> 0x0028 }
        r3 = r3 + r1;
        r4 = r1;
    L_0x007d:
        r5 = r8.e;	 Catch:{ Exception -> 0x0028 }
        if (r3 <= r5) goto L_0x008f;
    L_0x0081:
        r3 = r8.e;	 Catch:{ Exception -> 0x0028 }
        r4 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r4 = r4.z;	 Catch:{ Exception -> 0x0028 }
        r4 = r4.getWidth();	 Catch:{ Exception -> 0x0028 }
        r4 = r3 - r4;
    L_0x008f:
        r5 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r5 = r5.E;	 Catch:{ Exception -> 0x0028 }
        if (r2 >= r5) goto L_0x00a8;
    L_0x0097:
        r0 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r2 = r0.E;	 Catch:{ Exception -> 0x0028 }
        r0 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.z;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.getHeight();	 Catch:{ Exception -> 0x0028 }
        r0 = r0 + r2;
    L_0x00a8:
        r5 = r8.f;	 Catch:{ Exception -> 0x0028 }
        if (r0 <= r5) goto L_0x00ba;
    L_0x00ac:
        r0 = r8.f;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.z;	 Catch:{ Exception -> 0x0028 }
        r2 = r2.getHeight();	 Catch:{ Exception -> 0x0028 }
        r2 = r0 - r2;
    L_0x00ba:
        r5 = r8.j;	 Catch:{ Exception -> 0x0028 }
        r5 = r5.z;	 Catch:{ Exception -> 0x0028 }
        r5.layout(r4, r2, r3, r0);	 Catch:{ Exception -> 0x0028 }
        r0 = r10.getRawX();	 Catch:{ Exception -> 0x0028 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0028 }
        r8.a = r0;	 Catch:{ Exception -> 0x0028 }
        r0 = r10.getRawY();	 Catch:{ Exception -> 0x0028 }
        r0 = (int) r0;	 Catch:{ Exception -> 0x0028 }
        r8.b = r0;	 Catch:{ Exception -> 0x0028 }
        goto L_0x0010;
    L_0x00d3:
        r0 = r8.c;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.a;	 Catch:{ Exception -> 0x0028 }
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);	 Catch:{ Exception -> 0x0028 }
        if (r0 >= r4) goto L_0x00e9;
    L_0x00de:
        r0 = r8.d;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.b;	 Catch:{ Exception -> 0x0028 }
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);	 Catch:{ Exception -> 0x0028 }
        if (r0 >= r4) goto L_0x00e9;
    L_0x00e9:
        r0 = r3.getLeft();	 Catch:{ Exception -> 0x0028 }
        r2 = r3.getWidth();	 Catch:{ Exception -> 0x0028 }
        r2 = r2 / 2;
        r0 = r0 + r2;
        r2 = r8.e;	 Catch:{ Exception -> 0x0028 }
        r2 = r2 / 2;
        if (r0 >= r2) goto L_0x0131;
    L_0x00fa:
        r0 = 1;
        r2 = r0;
    L_0x00fc:
        if (r2 == 0) goto L_0x0133;
    L_0x00fe:
        r0 = r1;
    L_0x00ff:
        r4 = new android.view.animation.TranslateAnimation;	 Catch:{ Exception -> 0x0028 }
        r5 = r3.getLeft();	 Catch:{ Exception -> 0x0028 }
        r5 = (float) r5;	 Catch:{ Exception -> 0x0028 }
        r0 = (float) r0;	 Catch:{ Exception -> 0x0028 }
        r6 = 0;
        r7 = 0;
        r4.<init>(r5, r0, r6, r7);	 Catch:{ Exception -> 0x0028 }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r4.setDuration(r6);	 Catch:{ Exception -> 0x0028 }
        r0 = r8.g;	 Catch:{ Exception -> 0x0028 }
        r0.startAnimation(r4);	 Catch:{ Exception -> 0x0028 }
        r0 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ Exception -> 0x0028 }
        r4 = r8.h;	 Catch:{ Exception -> 0x0028 }
        r5 = r8.i;	 Catch:{ Exception -> 0x0028 }
        r0.<init>(r4, r5);	 Catch:{ Exception -> 0x0028 }
        if (r2 == 0) goto L_0x013b;
    L_0x0121:
        r2 = 0;
        r0.leftMargin = r2;	 Catch:{ Exception -> 0x0028 }
        r2 = r3.getTop();	 Catch:{ Exception -> 0x0028 }
        r0.topMargin = r2;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.g;	 Catch:{ Exception -> 0x0028 }
        r2.setLayoutParams(r0);	 Catch:{ Exception -> 0x0028 }
        goto L_0x0010;
    L_0x0131:
        r2 = r1;
        goto L_0x00fc;
    L_0x0133:
        r0 = r8.e;	 Catch:{ Exception -> 0x0028 }
        r4 = r3.getWidth();	 Catch:{ Exception -> 0x0028 }
        r0 = r0 - r4;
        goto L_0x00ff;
    L_0x013b:
        r2 = 0;
        r0.rightMargin = r2;	 Catch:{ Exception -> 0x0028 }
        r2 = r3.getTop();	 Catch:{ Exception -> 0x0028 }
        r0.topMargin = r2;	 Catch:{ Exception -> 0x0028 }
        r2 = r8.g;	 Catch:{ Exception -> 0x0028 }
        r2.setLayoutParams(r0);	 Catch:{ Exception -> 0x0028 }
        r2 = new android.os.Handler;	 Catch:{ Exception -> 0x0028 }
        r2.<init>();	 Catch:{ Exception -> 0x0028 }
        r4 = new com.baidu.mobads.production.d.d;	 Catch:{ Exception -> 0x0028 }
        r4.<init>(r8, r0, r3);	 Catch:{ Exception -> 0x0028 }
        r6 = 501; // 0x1f5 float:7.02E-43 double:2.475E-321;
        r2.postDelayed(r4, r6);	 Catch:{ Exception -> 0x0028 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.d.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
