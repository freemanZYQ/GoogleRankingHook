package com.vlocker.ui.widget.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.vlocker.b.j;
import com.vlocker.ui.widget.c.d;
import java.io.InputStream;

public class a {
    public static final DrawFilter a = new PaintFlagsDrawFilter(0, 3);

    public static float a(Context context, int[] iArr) {
        try {
            float f = (float) context.getResources().getDisplayMetrics().densityDpi;
            return iArr.length == 1 ? ((float) iArr[0]) * (f / 320.0f) : iArr.length == 2 ? f <= 320.0f ? ((float) iArr[0]) * (f / 320.0f) : ((float) iArr[1]) * (f / 480.0f) : iArr.length == 3 ? f <= 240.0f ? ((float) iArr[0]) * (f / 240.0f) : f == 320.0f ? ((float) iArr[1]) * (f / 320.0f) : f == 480.0f ? ((float) iArr[2]) * (f / 480.0f) : f > 480.0f ? ((float) iArr[2]) * (f / 640.0f) : f > 640.0f ? ((float) iArr[2]) * (f / 720.0f) : 0.0f : iArr.length == 4 ? f <= 240.0f ? ((float) iArr[0]) * (f / 240.0f) : f == 320.0f ? ((float) iArr[1]) * (f / 320.0f) : f == 480.0f ? ((float) iArr[2]) * (f / 480.0f) : f > 480.0f ? ((float) iArr[3]) * (f / 640.0f) : f > 640.0f ? ((float) iArr[3]) * (f / 720.0f) : 0.0f : 0.0f;
        } catch (Exception e) {
            return 0.0f;
        }
    }

    public static int a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap a(Context context, int i) {
        Bitmap bitmap = null;
        if (i != 0) {
            try {
                bitmap = BitmapFactory.decodeResource(context.getResources(), i);
            } catch (Exception e) {
            }
        }
        return bitmap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.Context r6, java.lang.String r7, int r8) {
        /*
        r1 = 0;
        r0 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x000c }
        r0 = a(r6, r0);	 Catch:{ Exception -> 0x000c }
    L_0x0009:
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0009;
    L_0x000f:
        r2 = com.vlocker.c.a.a(r6);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2 = r2.o();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        if (r2 == 0) goto L_0x00ab;
    L_0x0019:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r3.<init>();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r4 = r6.getFilesDir();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r4 = r4.getPath();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r4 = "/theme/";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r3 = "/xhdpi/";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2 = r3.exists();	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        if (r2 == 0) goto L_0x00ab;
    L_0x004f:
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0091, all -> 0x009c }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0091, all -> 0x009c }
    L_0x0054:
        if (r2 == 0) goto L_0x0060;
    L_0x0056:
        r3 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x0068, Exception -> 0x00a8, all -> 0x00a5 }
        r4 = 0;
        r5 = 0;
        r0 = a(r3, r8, r2, r4, r5);	 Catch:{ OutOfMemoryError -> 0x0068, Exception -> 0x00a8, all -> 0x00a5 }
    L_0x0060:
        if (r2 == 0) goto L_0x000b;
    L_0x0062:
        r2.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x000b;
    L_0x0066:
        r1 = move-exception;
        goto L_0x000b;
    L_0x0068:
        r3 = move-exception;
        r3 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x00a8, all -> 0x00a5 }
        r3.<init>();	 Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x00a8, all -> 0x00a5 }
        r4 = 2;
        r3.inSampleSize = r4;	 Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x00a8, all -> 0x00a5 }
        r4 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x00a8, all -> 0x00a5 }
        r5 = 0;
        r0 = a(r4, r8, r2, r5, r3);	 Catch:{ OutOfMemoryError -> 0x007b, Exception -> 0x00a8, all -> 0x00a5 }
        goto L_0x0060;
    L_0x007b:
        r3 = move-exception;
        r3 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x008e, Exception -> 0x00a8, all -> 0x00a5 }
        r3.<init>();	 Catch:{ OutOfMemoryError -> 0x008e, Exception -> 0x00a8, all -> 0x00a5 }
        r4 = 4;
        r3.inSampleSize = r4;	 Catch:{ OutOfMemoryError -> 0x008e, Exception -> 0x00a8, all -> 0x00a5 }
        r4 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x008e, Exception -> 0x00a8, all -> 0x00a5 }
        r5 = 0;
        r0 = a(r4, r8, r2, r5, r3);	 Catch:{ OutOfMemoryError -> 0x008e, Exception -> 0x00a8, all -> 0x00a5 }
        goto L_0x0060;
    L_0x008e:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0060;
    L_0x0091:
        r2 = move-exception;
    L_0x0092:
        if (r1 == 0) goto L_0x000b;
    L_0x0094:
        r1.close();	 Catch:{ IOException -> 0x0099 }
        goto L_0x000b;
    L_0x0099:
        r1 = move-exception;
        goto L_0x000b;
    L_0x009c:
        r0 = move-exception;
    L_0x009d:
        if (r1 == 0) goto L_0x00a2;
    L_0x009f:
        r1.close();	 Catch:{ IOException -> 0x00a3 }
    L_0x00a2:
        throw r0;
    L_0x00a3:
        r1 = move-exception;
        goto L_0x00a2;
    L_0x00a5:
        r0 = move-exception;
        r1 = r2;
        goto L_0x009d;
    L_0x00a8:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0092;
    L_0x00ab:
        r2 = r1;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.ui.widget.view.a.a(android.content.Context, java.lang.String, int):android.graphics.Bitmap");
    }

    public static Bitmap a(Resources resources, int i, InputStream inputStream, Rect rect, Options options) {
        if (options == null) {
            options = new Options();
        }
        if (options.inDensity == 0) {
            if (i == 0) {
                options.inDensity = 160;
            } else if (i != 65535) {
                options.inDensity = i;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Drawable a(Context context, String str, float f, float f2) {
        try {
            return new BitmapDrawable(context.getResources(), b(context, str, f, f2));
        } catch (Exception e) {
            return null;
        }
    }

    public static StateListDrawable a(Context context, int i, Drawable drawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, context.getResources().getDrawable(i));
        stateListDrawable.addState(new int[]{16842910}, drawable);
        return stateListDrawable;
    }

    public static StateListDrawable a(Context context, Drawable drawable, int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable);
        stateListDrawable.addState(new int[]{16842910}, context.getResources().getDrawable(i));
        return stateListDrawable;
    }

    public static StateListDrawable a(Context context, Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable);
        stateListDrawable.addState(new int[]{16842910}, drawable2);
        return stateListDrawable;
    }

    public static void a(Context context, d dVar, boolean z) {
        float f = (float) context.getResources().getDisplayMetrics().widthPixels;
        float f2 = (float) context.getResources().getDisplayMetrics().heightPixels;
        if (!z) {
            f2 = (float) (context.getResources().getDisplayMetrics().heightPixels + j.g());
        }
        if (f <= f2) {
            float f3 = f2;
            f2 = f;
            f = f3;
        }
        f2 /= 720.0f;
        f /= 1280.0f;
        d.a = f2;
        d.c = f;
        if (f2 < f) {
            d.a = f;
        }
    }

    public static int b(Context context) {
        return a(context) - c(context);
    }

    public static Bitmap b(Context context, String str, float f, float f2) {
        try {
            Bitmap a = a(context, str, 320);
            if (a != null) {
                return (((float) a.getWidth()) == f && ((float) a.getHeight()) == f2) ? a : a(a, f / ((float) a.getWidth()), f2 / ((float) a.getHeight()));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
