package com.vlocker.locker.b;

import android.graphics.Bitmap;
import com.vlocker.locker.a.a;
import com.vlocker.search.ap;
import com.vlocker.security.MoSecurityApplication;

class ao extends a {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ am b;

    ao(am amVar, Bitmap bitmap) {
        this.b = amVar;
        this.a = bitmap;
    }

    public void a(Bitmap bitmap) {
        super.a(bitmap);
        this.b.g = bitmap;
        this.b.c.setImageBitmap(this.b.g);
        if (bitmap != null) {
            ap.a(MoSecurityApplication.a(), this.b.g, 0);
        }
    }

    public /* synthetic */ Object b() {
        return d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap d() {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
        r2 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
        r2 = r2.getWidth();	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
        r2 = r2 / 2;
        r3 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
        r3 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
        r3 = r3 / 2;
        r4 = 1;
        r0 = android.graphics.Bitmap.createScaledBitmap(r1, r2, r3, r4);	 Catch:{ OutOfMemoryError -> 0x0023, IllegalArgumentException -> 0x0055 }
    L_0x0018:
        r0 = com.vlocker.m.z.a(r0);
        r1 = -40;
        r0 = com.vlocker.m.z.a(r0, r1);
        return r0;
    L_0x0023:
        r1 = move-exception;
        r1 = r5.a;	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        r2 = r5.a;	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        r2 = r2.getWidth();	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        r2 = r2 / 4;
        r3 = r5.a;	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        r3 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        r3 = r3 / 4;
        r4 = 1;
        r0 = android.graphics.Bitmap.createScaledBitmap(r1, r2, r3, r4);	 Catch:{ OutOfMemoryError -> 0x003c, IllegalArgumentException -> 0x0055 }
        goto L_0x0018;
    L_0x003c:
        r1 = move-exception;
        r1 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        r2 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        r2 = r2.getWidth();	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        r2 = r2 / 8;
        r3 = r5.a;	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        r3 = r3.getHeight();	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        r3 = r3 / 8;
        r4 = 1;
        r0 = android.graphics.Bitmap.createScaledBitmap(r1, r2, r3, r4);	 Catch:{ OutOfMemoryError -> 0x0059, IllegalArgumentException -> 0x0055 }
        goto L_0x0018;
    L_0x0055:
        r0 = move-exception;
        r0 = r5.a;
        goto L_0x0018;
    L_0x0059:
        r1 = move-exception;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.locker.b.ao.d():android.graphics.Bitmap");
    }
}
