package com.vlocker.ui.widget.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import com.vlocker.c.a;
import com.vlocker.ui.widget.a.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class c {
    public static final DrawFilter f = new PaintFlagsDrawFilter(0, 3);
    public Context d;
    public d e;

    public c(Context context, d dVar) {
        this.d = context;
        this.e = dVar;
    }

    public static float a(Context context, int[] iArr) {
        try {
            float f = (float) context.getResources().getDisplayMetrics().densityDpi;
            return iArr.length == 1 ? ((float) iArr[0]) * (f / 320.0f) : iArr.length == 2 ? f <= 320.0f ? ((float) iArr[0]) * (f / 320.0f) : ((float) iArr[1]) * (f / 480.0f) : iArr.length == 3 ? f <= 240.0f ? ((float) iArr[0]) * (f / 240.0f) : f == 320.0f ? ((float) iArr[1]) * (f / 320.0f) : f == 480.0f ? ((float) iArr[2]) * (f / 480.0f) : f > 480.0f ? ((float) iArr[2]) * (f / 640.0f) : f > 640.0f ? ((float) iArr[2]) * (f / 720.0f) : 0.0f : iArr.length == 4 ? f <= 240.0f ? ((float) iArr[0]) * (f / 240.0f) : f == 320.0f ? ((float) iArr[1]) * (f / 320.0f) : f == 480.0f ? ((float) iArr[2]) * (f / 480.0f) : f > 480.0f ? ((float) iArr[3]) * (f / 640.0f) : f > 640.0f ? ((float) iArr[3]) * (f / 720.0f) : 0.0f : 0.0f;
        } catch (Exception e) {
            return 0.0f;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.Context r6, java.lang.String r7, int r8) {
        /*
        r0 = 0;
        r1 = com.vlocker.c.a.a(r6);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1 = r1.o();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        if (r1 == 0) goto L_0x009c;
    L_0x000b:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r2.<init>();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r3 = r6.getFilesDir();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r3 = r3.getPath();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r3 = "/theme/";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1 = r2.append(r1);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r2 = "/xhdpi/";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1 = r2.exists();	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        if (r1 == 0) goto L_0x009c;
    L_0x0041:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x007e, all -> 0x0088 }
    L_0x0046:
        if (r1 == 0) goto L_0x0052;
    L_0x0048:
        r2 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x0098, all -> 0x0096 }
        r3 = 0;
        r4 = 0;
        r0 = a(r2, r8, r1, r3, r4);	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x0098, all -> 0x0096 }
    L_0x0052:
        if (r1 == 0) goto L_0x0057;
    L_0x0054:
        r1.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0057:
        return r0;
    L_0x0058:
        r2 = move-exception;
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x006b, Exception -> 0x0098, all -> 0x0096 }
        r2.<init>();	 Catch:{ OutOfMemoryError -> 0x006b, Exception -> 0x0098, all -> 0x0096 }
        r3 = 2;
        r2.inSampleSize = r3;	 Catch:{ OutOfMemoryError -> 0x006b, Exception -> 0x0098, all -> 0x0096 }
        r3 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x006b, Exception -> 0x0098, all -> 0x0096 }
        r4 = 0;
        r0 = a(r3, r8, r1, r4, r2);	 Catch:{ OutOfMemoryError -> 0x006b, Exception -> 0x0098, all -> 0x0096 }
        goto L_0x0052;
    L_0x006b:
        r2 = move-exception;
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        r2.<init>();	 Catch:{ OutOfMemoryError -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        r3 = 4;
        r2.inSampleSize = r3;	 Catch:{ OutOfMemoryError -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        r3 = r6.getResources();	 Catch:{ OutOfMemoryError -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        r4 = 0;
        r0 = a(r3, r8, r1, r4, r2);	 Catch:{ OutOfMemoryError -> 0x009a, Exception -> 0x0098, all -> 0x0096 }
        goto L_0x0052;
    L_0x007e:
        r1 = move-exception;
        r1 = r0;
    L_0x0080:
        if (r1 == 0) goto L_0x0057;
    L_0x0082:
        r1.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x0057;
    L_0x0086:
        r1 = move-exception;
        goto L_0x0057;
    L_0x0088:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x008c:
        if (r1 == 0) goto L_0x0091;
    L_0x008e:
        r1.close();	 Catch:{ IOException -> 0x0094 }
    L_0x0091:
        throw r0;
    L_0x0092:
        r1 = move-exception;
        goto L_0x0057;
    L_0x0094:
        r1 = move-exception;
        goto L_0x0091;
    L_0x0096:
        r0 = move-exception;
        goto L_0x008c;
    L_0x0098:
        r2 = move-exception;
        goto L_0x0080;
    L_0x009a:
        r2 = move-exception;
        goto L_0x0052;
    L_0x009c:
        r1 = r0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.ui.widget.b.c.a(android.content.Context, java.lang.String, int):android.graphics.Bitmap");
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
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    public Bitmap a(String str) {
        Throwable th;
        Bitmap bitmap = null;
        InputStream fileInputStream;
        try {
            String o = a.a(this.d).o();
            if (o != null) {
                File file = new File(this.d.getFilesDir().getPath() + "/theme/" + o + "/xhdpi/" + str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    if (fileInputStream != null) {
                        try {
                            bitmap = BitmapFactory.decodeStream(fileInputStream);
                            if (com.vlocker.ui.widget.c.d.b != 1.0f) {
                                bitmap = a(bitmap, com.vlocker.ui.widget.c.d.b * this.e.p, com.vlocker.ui.widget.c.d.b * this.e.p);
                            }
                        } catch (Exception e) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            return bitmap;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return bitmap;
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                bitmap = BitmapFactory.decodeStream(fileInputStream);
                if (com.vlocker.ui.widget.c.d.b != 1.0f) {
                    bitmap = a(bitmap, com.vlocker.ui.widget.c.d.b * this.e.p, com.vlocker.ui.widget.c.d.b * this.e.p);
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return bitmap;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = null;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return bitmap;
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public abstract int b();

    public abstract float c();

    public float d() {
        return this.e == null ? 0.0f : this.e.f * com.vlocker.ui.widget.c.d.b;
    }

    public float e() {
        return this.e == null ? 0.0f : this.e.g * com.vlocker.ui.widget.c.d.b;
    }
}
