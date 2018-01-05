package com.vlocker.locker.b;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.c;
import com.vlocker.m.f;
import com.vlocker.m.h;
import com.vlocker.m.p;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.theme.f.b;
import java.io.File;

public class am {
    private static am a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private Context e = MoSecurityApplication.a();
    private Bitmap f;
    private Bitmap g;

    private am() {
    }

    public static Bitmap a(Context context) {
        WallpaperManager instance = WallpaperManager.getInstance(context);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        Drawable drawable = instance.getDrawable();
        if (drawable == null) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() <= i) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (int) ((float) ((bitmap.getWidth() - i) / 2)), 0, i, bitmap.getHeight() < i2 ? bitmap.getHeight() : i2);
        bitmap.recycle();
        instance.forgetLoadedWallpaper();
        return createBitmap;
    }

    private Bitmap a(a aVar) {
        Bitmap bitmap;
        String ad = aVar.ad();
        if (TextUtils.isEmpty(ad) || !new File(ad).exists()) {
            bitmap = null;
        } else {
            DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
            try {
                bitmap = f.a(ad, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } catch (Error e) {
                bitmap = null;
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (b.f() && VERSION.SDK_INT == 22) {
            try {
                bitmap = a(this.e);
            } catch (Exception e2) {
            }
        } else {
            bitmap = a(this.e);
        }
        return bitmap == null ? null : bitmap;
    }

    public static am a() {
        if (a == null) {
            a = new am();
        }
        return a;
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null) {
            c.a(new ao(this, bitmap));
        }
    }

    private Bitmap b(a aVar) {
        if (aVar.ag()) {
            return null;
        }
        try {
            String ad = aVar.ad();
            File b = h.b(this.e);
            if (!(b == null || b.getAbsolutePath().equals(ad) || !p.a(new File(ad), b))) {
                aVar.q(b.getAbsolutePath());
                aVar.v(true);
            }
        } catch (Exception e) {
        }
        return a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap g() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = r6.e;
        r1 = com.vlocker.c.a.a(r0);
        r0 = r1.af();	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x0041;
    L_0x000e:
        r0 = com.vlocker.locker.b.ap.a();	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x002d;
    L_0x0014:
        r0 = com.vlocker.locker.b.ap.a();	 Catch:{ Exception -> 0x003d }
        r0 = r0.e;	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x002d;
    L_0x001c:
        r0 = r6.e;	 Catch:{ Exception -> 0x003d }
        r2 = com.vlocker.locker.b.ap.a();	 Catch:{ Exception -> 0x003d }
        r2 = r2.e;	 Catch:{ Exception -> 0x003d }
        r3 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        r0 = com.vlocker.ui.widget.b.c.a(r0, r2, r3);	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x00a2;
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = r6.e;	 Catch:{ Exception -> 0x003d }
        r2 = "moxiu_lock_custom_bg";
        r0 = com.vlocker.m.y.b(r0, r2);	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x009e;
    L_0x0038:
        r2 = 1;
        r1.w(r2);	 Catch:{ Exception -> 0x003d }
        goto L_0x002c;
    L_0x003d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0041:
        r0 = r1.ah();
        if (r0 == 0) goto L_0x0058;
    L_0x0047:
        r0 = r6.e;	 Catch:{ Exception -> 0x0057 }
        r2 = "moxiu_lock_custom_bg";
        r0 = com.vlocker.m.y.b(r0, r2);	 Catch:{ Exception -> 0x0057 }
        if (r0 == 0) goto L_0x00a7;
    L_0x0052:
        r2 = 1;
        r1.w(r2);	 Catch:{ Exception -> 0x0057 }
        goto L_0x002c;
    L_0x0057:
        r0 = move-exception;
    L_0x0058:
        r0 = r1.ae();
        if (r0 != 0) goto L_0x0074;
    L_0x005e:
        r0 = r6.e;	 Catch:{ Exception -> 0x00c8 }
        r2 = "moxiu_lock_custom_bg";
        r0 = com.vlocker.m.y.b(r0, r2);	 Catch:{ Exception -> 0x00c8 }
        if (r0 != 0) goto L_0x002c;
    L_0x0069:
        r0 = r6.e;	 Catch:{ Exception -> 0x00c8 }
        r2 = "pattern_carbon_fiber_dark";
        r0 = com.vlocker.m.y.b(r0, r2);	 Catch:{ Exception -> 0x00c8 }
        if (r0 != 0) goto L_0x002c;
    L_0x0074:
        r0 = r1.ae();
        if (r0 == r5) goto L_0x0080;
    L_0x007a:
        r0 = r1.ae();
        if (r0 != 0) goto L_0x00b2;
    L_0x0080:
        r0 = r1.ag();
        if (r0 != 0) goto L_0x0089;
    L_0x0086:
        r1.v(r5);
    L_0x0089:
        r0 = r1.as();
        if (r0 == 0) goto L_0x00b2;
    L_0x008f:
        r0 = r6.e;
        r2 = "wallpaper";
        r0 = com.vlocker.m.y.b(r0, r2);
        if (r0 == 0) goto L_0x00ac;
    L_0x009a:
        r1.w(r5);
        goto L_0x002c;
    L_0x009e:
        r0 = 0;
        r1.w(r0);	 Catch:{ Exception -> 0x003d }
    L_0x00a2:
        r0 = 0;
        r1.i(r0);	 Catch:{ Exception -> 0x003d }
        goto L_0x0041;
    L_0x00a7:
        r0 = 0;
        r1.w(r0);	 Catch:{ Exception -> 0x0057 }
        goto L_0x0058;
    L_0x00ac:
        r1.w(r4);
        r1.D(r4);
    L_0x00b2:
        r0 = r1.ag();
        if (r0 == 0) goto L_0x00c0;
    L_0x00b8:
        r0 = r6.a(r1);
        if (r0 == 0) goto L_0x002c;
    L_0x00be:
        goto L_0x002c;
    L_0x00c0:
        r0 = r6.b(r1);
        if (r0 == 0) goto L_0x002c;
    L_0x00c6:
        goto L_0x002c;
    L_0x00c8:
        r0 = move-exception;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.locker.b.am.g():android.graphics.Bitmap");
    }

    public void a(float f, boolean z) {
        float f2 = 1.0f;
        if (f <= 1.0f) {
            f2 = f;
        }
        if (f2 < 0.05f) {
            f2 = 0.0f;
        }
        if (z) {
            this.c.setAlpha(f2);
        } else {
            this.d.setAlpha(f2);
        }
    }

    public void a(float f, boolean z, long j) {
        float f2 = 1.0f;
        if (f <= 1.0f) {
            f2 = f;
        }
        if (f2 < 0.05f) {
            f2 = 0.0f;
        }
        if (z) {
            this.c.animate().alpha(f2).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(j).start();
        } else {
            this.d.animate().alpha(f2).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(j).start();
        }
    }

    public void a(View view) {
        this.b = (ImageView) view.findViewById(R.id.iv_main_bg);
        this.c = (ImageView) view.findViewById(R.id.iv_main_bg_blur);
        this.d = (ImageView) view.findViewById(R.id.iv_main_bg_alpha);
    }

    public void a(boolean z) {
        if (z) {
            this.c.animate().alpha(0.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        } else {
            this.d.animate().alpha(0.0f).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(300).start();
        }
    }

    public Bitmap b() {
        return this.g;
    }

    public Bitmap c() {
        return this.f;
    }

    public void d() {
        c.a(new an(this));
    }

    public void e() {
        if (this.c.isHardwareAccelerated()) {
            this.c.setLayerType(2, null);
        }
        if (this.d.isHardwareAccelerated()) {
            this.d.setLayerType(2, null);
        }
    }

    public void f() {
        if (this.c.isHardwareAccelerated()) {
            this.c.setLayerType(0, null);
        }
        if (this.d.isHardwareAccelerated()) {
            this.d.setLayerType(0, null);
        }
    }
}
