package com.vlocker.theme.imageloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.StatFs;
import android.support.v4.c.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class r {
    private static final CompressFormat c = CompressFormat.JPEG;
    public l a;
    public g b;
    private t d;
    private final Object e = new Object();
    private boolean f = true;
    private Set g;

    public r(t tVar) {
        a(tVar);
    }

    public static int a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 > i2 && i7 / i5 > i) {
                i5 *= 2;
            }
            long j = (long) ((i3 * i4) / i5);
            while (j > ((long) ((i * i2) * 2))) {
                j /= 2;
                i5 *= 2;
            }
        }
        return i5;
    }

    @TargetApi(19)
    public static int a(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (aa.d()) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        } else if (aa.c()) {
            return bitmap.getByteCount();
        } else {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    @TargetApi(9)
    public static long a(File file) {
        if (aa.a()) {
            return file.getUsableSpace();
        }
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 209715200;
        }
    }

    public static Bitmap a(int i, Context context, r rVar) {
        try {
            Resources resources = context.getResources();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(resources, i, options);
            options.inSampleSize = 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeResource(resources, i, options);
        } catch (OutOfMemoryError e) {
            try {
                rVar.b.a();
                rVar.a.c();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2, r rVar, int i3) {
        Bitmap bitmap = null;
        try {
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.outWidth = i;
            options.outHeight = i2;
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                rVar.b.a();
                rVar.a.c();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (OutOfMemoryError e3) {
            try {
                rVar.b.a();
                rVar.a.c();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        }
        return bitmap;
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private void a(t tVar) {
        this.d = tVar;
        if (this.d.g) {
            if (aa.b()) {
                this.g = Collections.synchronizedSet(new HashSet());
            }
            this.b = new s(this, this.d.a);
        }
        if (tVar.i) {
            a();
        }
    }

    public static Bitmap b(FileDescriptor fileDescriptor, int i, int i2, r rVar, int i3) {
        Bitmap bitmap = null;
        try {
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            options.inJustDecodeBounds = true;
            if (i3 == 13) {
                options.outMimeType = "image/png";
            }
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.outWidth = i;
            options.outHeight = i2;
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                rVar.b.a();
                rVar.a.c();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (OutOfMemoryError e3) {
            try {
                rVar.b.a();
                rVar.a.c();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
        }
        return bitmap;
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    private void f() {
        for (Entry key : this.b.b().entrySet()) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.b.a(key.getKey());
            if (bitmapDrawable != null) {
                bitmapDrawable.getBitmap().recycle();
            }
        }
    }

    Bitmap a(l lVar, String str, int i) {
        Throwable th;
        Bitmap bitmap = null;
        String b = b(str);
        synchronized (this.e) {
            while (this.f) {
                try {
                    this.e.wait();
                } catch (InterruptedException e) {
                }
            }
            if (lVar != null) {
                InputStream a;
                try {
                    q a2 = lVar.a(b);
                    if (a2 != null) {
                        a = a2.a(0);
                        if (a != null) {
                            try {
                                bitmap = a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this, i);
                            } catch (IOException e2) {
                                if (a != null) {
                                    try {
                                        a.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                return bitmap;
                            } catch (Throwable th2) {
                                th = th2;
                                if (a != null) {
                                    try {
                                        a.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    Object obj = bitmap;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (IOException e6) {
                    a = bitmap;
                    if (a != null) {
                        a.close();
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    a = bitmap;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    public BitmapDrawable a(String str) {
        return this.b != null ? (BitmapDrawable) this.b.a((Object) str) : null;
    }

    public void a() {
        synchronized (this.e) {
            if (this.a == null || this.a.a()) {
                File file = this.d.d;
                if (this.d.h && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (a(file) > ((long) this.d.b)) {
                        try {
                            this.a = l.a(file, 1, 1, (long) this.d.b);
                        } catch (IOException e) {
                            this.d.d = null;
                        }
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    void a(l lVar, String str, InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2 = null;
        synchronized (this.e) {
            while (this.f) {
                try {
                    this.e.wait();
                } catch (InterruptedException e) {
                }
            }
            if (lVar != null) {
                String b = b(str);
                try {
                    BufferedInputStream bufferedInputStream2;
                    q a = lVar.a(b);
                    if (a == null) {
                        n b2 = lVar.b(b);
                        if (b2 != null) {
                            bufferedInputStream = new BufferedInputStream(inputStream);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(b2.a(0));
                                while (true) {
                                    try {
                                        int read = bufferedInputStream.read();
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(read);
                                    } catch (Exception e2) {
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    } catch (Throwable th2) {
                                        Throwable th3 = th2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        th = th3;
                                    }
                                }
                                b2.a();
                                bufferedInputStream2 = bufferedInputStream;
                            } catch (Exception e3) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e4) {
                                    }
                                }
                                if (bufferedOutputStream2 != null) {
                                    bufferedOutputStream2.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e5) {
                                        throw th;
                                    }
                                }
                                if (bufferedOutputStream2 != null) {
                                    bufferedOutputStream2.close();
                                }
                                throw th;
                            }
                        }
                        bufferedOutputStream = null;
                    } else {
                        a.a(0).close();
                        bufferedOutputStream = null;
                    }
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                } catch (Exception e7) {
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    throw th;
                }
            }
        }
    }

    public void a(String str, BitmapDrawable bitmapDrawable, int i) {
        if (str != null && bitmapDrawable != null && this.b != null) {
            if (z.class.isInstance(bitmapDrawable)) {
                ((z) bitmapDrawable).b(true);
            }
            this.b.a(str, bitmapDrawable);
        }
    }

    public void b() {
        if (this.b != null) {
            f();
            this.b.a();
        }
    }

    public void c() {
        synchronized (this.e) {
            if (this.a != null) {
                try {
                    this.a.b();
                } catch (IOException e) {
                }
            }
        }
    }

    public void d() {
        synchronized (this.e) {
            if (this.a != null) {
                try {
                    if (!this.a.a()) {
                        this.a.close();
                        this.a = null;
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
