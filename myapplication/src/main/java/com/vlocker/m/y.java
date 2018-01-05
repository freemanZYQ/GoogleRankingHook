package com.vlocker.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.vlocker.c.a;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class y {
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static int d = 0;
    public static final String e = (Environment.getExternalStorageDirectory().toString() + "/vlocker/themes/");

    public static int a(InputStream inputStream, int i) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((((read | read2) | read3) | read4) >= 0) {
            return i == 0 ? ((((read & 255) << 24) | ((read2 & 255) << 16)) | ((read3 & 255) << 8)) | ((read4 & 255) << 0) : ((((read & 255) << 0) | ((read2 & 255) << 8)) | ((read3 & 255) << 16)) | ((read4 & 255) << 24);
        } else {
            throw new EOFException();
        }
    }

    public static Resources a(Context context, String str) {
        if (str == null) {
            return null;
        }
        String str2 = "android.content.pm.PackageParser";
        String str3 = "android.content.res.AssetManager";
        try {
            Resources resources = context.getResources();
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            Exception exception = e;
            try {
                Class cls = Class.forName(str2);
                Object newInstance = cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
                new DisplayMetrics().setToDefaults();
                Object invoke = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE}).invoke(newInstance, new Object[]{new File(str), str, r5, Integer.valueOf(0)});
                ApplicationInfo applicationInfo = (ApplicationInfo) invoke.getClass().getDeclaredField("applicationInfo").get(invoke);
                Class cls2 = Class.forName(str3);
                invoke = cls2.getConstructor((Class[]) null).newInstance((Object[]) null);
                cls2.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(invoke, new Object[]{str});
                Resources resources2 = context.getResources();
                return (Resources) Resources.class.getConstructor(new Class[]{invoke.getClass(), resources2.getDisplayMetrics().getClass(), resources2.getConfiguration().getClass()}).newInstance(new Object[]{invoke, resources2.getDisplayMetrics(), resources2.getConfiguration()});
            } catch (Exception e2) {
                exception.printStackTrace();
                return null;
            }
        }
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
        options.inPreferredConfig = Config.RGB_565;
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    private static Bitmap a(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null;
    }

    public static InputStream a(Context context, Resources resources, String str) {
        InputStream byteArrayInputStream;
        OutOfMemoryError e;
        Throwable th;
        IOException e2;
        InputStream inputStream = null;
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            int identifier = resources.getIdentifier(str, "drawable", a);
            if (identifier == 0) {
                return null;
            }
            TypedValue typedValue = new TypedValue();
            resources.getValue(identifier, typedValue, true);
            if (!typedValue.string.toString().endsWith(".ic")) {
                return resources.openRawResource(identifier);
            }
            InputStream openRawResource = resources.openRawResource(identifier);
            try {
                openRawResource.read();
                identifier = openRawResource.read();
                openRawResource.skip((long) (openRawResource.available() - a(openRawResource, 0)));
                byte[] bArr = new byte[openRawResource.available()];
                byteArrayInputStream = openRawResource.read(bArr) == -1 ? new ByteArrayInputStream(a(bArr, bArr.length, identifier)) : new ByteArrayInputStream(a(bArr, bArr.length, identifier));
                try {
                    openRawResource.close();
                    if (openRawResource == null) {
                        return byteArrayInputStream;
                    }
                    try {
                        openRawResource.close();
                        return byteArrayInputStream;
                    } catch (Exception e3) {
                        return byteArrayInputStream;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        if (openRawResource != null) {
                            return byteArrayInputStream;
                        }
                        openRawResource.close();
                        return byteArrayInputStream;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        inputStream = byteArrayInputStream;
                        th = th3;
                        if (openRawResource != null) {
                            try {
                                openRawResource.close();
                            } catch (Exception e5) {
                                return inputStream;
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (openRawResource != null) {
                        return byteArrayInputStream;
                    }
                    openRawResource.close();
                    return byteArrayInputStream;
                }
            } catch (OutOfMemoryError e7) {
                OutOfMemoryError outOfMemoryError = e7;
                byteArrayInputStream = null;
                e = outOfMemoryError;
                e.printStackTrace();
                if (openRawResource != null) {
                    return byteArrayInputStream;
                }
                openRawResource.close();
                return byteArrayInputStream;
            } catch (IOException e8) {
                IOException iOException = e8;
                byteArrayInputStream = null;
                e2 = iOException;
                e2.printStackTrace();
                if (openRawResource != null) {
                    return byteArrayInputStream;
                }
                openRawResource.close();
                return byteArrayInputStream;
            } catch (Throwable th4) {
                th = th4;
                if (openRawResource != null) {
                    openRawResource.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            return null;
        }
    }

    public static String a(Context context) {
        if (a == null) {
            a = a.a(context).o();
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.res.Resources r10, java.lang.String r11, java.lang.String r12) {
        /*
        r3 = 0;
        r0 = 0;
        r1 = r10.getAssets();	 Catch:{ IOException -> 0x01ba }
        r5 = r1.list(r11);	 Catch:{ IOException -> 0x01ba }
        r6 = new java.io.File;
        r6.<init>(r12);
        r1 = r6.exists();
        if (r1 != 0) goto L_0x001b;
    L_0x0015:
        r1 = r6.mkdirs();
        if (r1 != 0) goto L_0x001b;
    L_0x001b:
        r1 = r5.length;
        if (r0 >= r1) goto L_0x01bb;
    L_0x001e:
        r7 = r5[r0];	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = ".";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 != 0) goto L_0x00a1;
    L_0x0029:
        r1 = "fonts";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 != 0) goto L_0x0044;
    L_0x0032:
        r1 = "xhdpi";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 != 0) goto L_0x0044;
    L_0x003b:
        r1 = "hdpi";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x0065;
    L_0x0044:
        r1 = r11.length();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 != 0) goto L_0x0068;
    L_0x004a:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.append(r12);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.append(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.toString();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        a(r10, r7, r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
    L_0x0065:
        r0 = r0 + 1;
        goto L_0x001b;
    L_0x0068:
        r1 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1.<init>();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.append(r11);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = "/";
        r1 = r1.append(r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.append(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.toString();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r12);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r4 = "/";
        r2 = r2.append(r4);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        a(r10, r1, r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0065;
    L_0x009c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0065;
    L_0x00a1:
        r1 = ".idf";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 != 0) goto L_0x0065;
    L_0x00aa:
        r1 = ".png";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x0152;
    L_0x00b3:
        r1 = ".png";
        r1 = r7.lastIndexOf(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = 0;
        r1 = r7.substring(r2, r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r1;
    L_0x00c0:
        if (r2 == 0) goto L_0x01c3;
    L_0x00c2:
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1.<init>(r6, r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
    L_0x00c7:
        if (r1 != 0) goto L_0x01c0;
    L_0x00c9:
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1.<init>(r6, r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r4 = r1;
    L_0x00cf:
        r1 = r4.exists();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d5:
        r4.delete();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
    L_0x00d8:
        r1 = ".ic";
        r1 = r7.endsWith(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x0182;
    L_0x00e1:
        r1 = r11.length();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x016a;
    L_0x00e7:
        r1 = r10.getAssets();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r11);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r8 = "/";
        r2 = r2.append(r8);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.open(r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r1;
    L_0x0108:
        r2.read();	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r1 = r2.read();	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r7 = 0;
        r7 = a(r2, r7);	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r8 = r2.available();	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r7 = r8 - r7;
        r8 = (long) r7;	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r2.skip(r8);	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r7 = r2.available();	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r7 = new byte[r7];	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r8 = r2.read(r7);	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r9 = -1;
        if (r8 != r9) goto L_0x012b;
    L_0x012b:
        r8 = r7.length;	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r7 = a(r7, r8, r1);	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r1.<init>(r7);	 Catch:{ OutOfMemoryError -> 0x0174, IOException -> 0x017b, FileNotFoundException -> 0x009c }
        r2.close();	 Catch:{ OutOfMemoryError -> 0x01be, IOException -> 0x01bc, FileNotFoundException -> 0x009c }
    L_0x0138:
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2.<init>(r4);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r4];	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
    L_0x0141:
        r7 = r1.read(r4);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r7 <= 0) goto L_0x01b2;
    L_0x0147:
        r8 = 0;
        r2.write(r4, r8, r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0141;
    L_0x014c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0065;
    L_0x0152:
        r1 = ".jpg";
        r1 = r7.contains(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x01c6;
    L_0x015b:
        r1 = ".jpg";
        r1 = r7.lastIndexOf(r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = 0;
        r1 = r7.substring(r2, r1);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r1;
        goto L_0x00c0;
    L_0x016a:
        r1 = r10.getAssets();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.open(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r1;
        goto L_0x0108;
    L_0x0174:
        r1 = move-exception;
        r2 = r1;
        r1 = r3;
    L_0x0177:
        r2.printStackTrace();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0138;
    L_0x017b:
        r1 = move-exception;
        r2 = r1;
        r1 = r3;
    L_0x017e:
        r2.printStackTrace();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0138;
    L_0x0182:
        r1 = r11.length();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        if (r1 == 0) goto L_0x01a9;
    L_0x0188:
        r1 = r10.getAssets();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r11);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r8 = "/";
        r2 = r2.append(r8);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.append(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2 = r2.toString();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.open(r2);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0138;
    L_0x01a9:
        r1 = r10.getAssets();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r1 = r1.open(r7);	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0138;
    L_0x01b2:
        r1.close();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        r2.close();	 Catch:{ FileNotFoundException -> 0x009c, IOException -> 0x014c }
        goto L_0x0065;
    L_0x01ba:
        r0 = move-exception;
    L_0x01bb:
        return;
    L_0x01bc:
        r2 = move-exception;
        goto L_0x017e;
    L_0x01be:
        r2 = move-exception;
        goto L_0x0177;
    L_0x01c0:
        r4 = r1;
        goto L_0x00cf;
    L_0x01c3:
        r1 = r3;
        goto L_0x00c7;
    L_0x01c6:
        r2 = r3;
        goto L_0x00c0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.m.y.a(android.content.res.Resources, java.lang.String, java.lang.String):void");
    }

    private static void a(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        a(listFiles[i]);
                    } else {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        int i3 = (i2 * 2) + (i / 2);
        if (i3 <= 40 || i3 >= i) {
            return bArr;
        }
        for (int i4 = 0; i4 < 20; i4++) {
            byte b = bArr[i4];
            bArr[i4] = bArr[i3];
            bArr[i3] = b;
            i3 -= 2;
        }
        return bArr;
    }

    public static Bitmap b(Context context, String str) {
        String b = b(context);
        if (b == null) {
            return null;
        }
        int i = 0;
        if (b.equals("drawable-xdpi")) {
            i = 320;
        } else if (b.equals("drawable-hdpi")) {
            i = 240;
        }
        try {
            b = a(context);
            if (b == null) {
                return null;
            }
            Bitmap c;
            if (b.equals(IXAdSystemUtils.NT_NONE)) {
                c = c(context, str);
            } else {
                Resources h = h(context);
                InputStream a = a(context, h, str);
                if (a != null) {
                    try {
                        c = a(h, i, a, null, null);
                    } catch (OutOfMemoryError e) {
                        Options options;
                        try {
                            options = new Options();
                            options.inSampleSize = 2;
                            c = a(h, i, a, null, options);
                        } catch (OutOfMemoryError e2) {
                            try {
                                options = new Options();
                                options.inSampleSize = 4;
                                c = a(h, i, a, null, options);
                            } catch (OutOfMemoryError e3) {
                                c = null;
                            }
                        }
                    }
                } else {
                    c = null;
                }
            }
            return c != null ? c : null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        if (b == null) {
            b = a.a(context).m();
        }
        return b;
    }

    public static Bitmap c(Context context, String str) {
        String a = a(context);
        Resources resources = f(context).getResources();
        Bitmap bitmap = null;
        if (a.equals(IXAdSystemUtils.NT_NONE)) {
            int identifier = resources.getIdentifier(str, "drawable", f(context).getPackageName());
            if (identifier != 0) {
                try {
                    bitmap = a(resources.getDrawable(identifier));
                } catch (OutOfMemoryError e) {
                } catch (Exception e2) {
                }
            }
        }
        return bitmap;
    }

    public static boolean c(Context context) {
        String a = a(context);
        if (a == null || "".equals(a)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(a, 8192);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(a(context));
        } catch (Exception e) {
            return null;
        }
    }

    public static String d(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageManager packageManager = context.getPackageManager();
        Resources a = a(context, str);
        try {
            packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        } catch (Exception e) {
            packageArchiveInfo = null;
        }
        try {
            return packageArchiveInfo.applicationInfo.labelRes != 0 ? a.getText(packageArchiveInfo.applicationInfo.labelRes).toString() : packageManager.getApplicationLabel(packageArchiveInfo.applicationInfo).toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static String e(Context context) {
        if (c == null) {
            c = a.a(context).n();
        }
        return c;
    }

    public static void e(Context context, String str) {
        PackageInfo packageArchiveInfo;
        String str2 = null;
        PackageManager packageManager = context.getPackageManager();
        Resources a = a(context, str);
        try {
            packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        } catch (Exception e) {
            packageArchiveInfo = null;
        }
        f(context, str);
        try {
            str2 = packageArchiveInfo.packageName;
            if (packageArchiveInfo.applicationInfo.labelRes != 0) {
                a.getText(packageArchiveInfo.applicationInfo.labelRes).toString();
            } else {
                packageManager.getApplicationLabel(packageArchiveInfo.applicationInfo).toString();
            }
        } catch (Exception e2) {
        }
        if (str2 != null && str2.length() > 0) {
            a.a(context);
        }
    }

    public static Context f(Context context) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext("com.moxiu.launcher", 2);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return context2;
    }

    public static ApplicationInfo f(Context context, String str) {
        String str2 = "android.content.pm.PackageParser";
        String str3 = "android.content.res.AssetManager";
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            return packageArchiveInfo != null ? packageArchiveInfo.applicationInfo : null;
        } catch (Exception e) {
            Exception exception = e;
            try {
                Class cls = Class.forName(str2);
                Object newInstance = cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
                new DisplayMetrics().setToDefaults();
                Object invoke = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE}).invoke(newInstance, new Object[]{new File(str), str, r3, Integer.valueOf(0)});
                return (ApplicationInfo) invoke.getClass().getDeclaredField("applicationInfo").get(invoke);
            } catch (Exception e2) {
                exception.printStackTrace();
                return null;
            }
        }
    }

    public static int g(Context context) {
        if (d == 0) {
            d = a.a(context).l();
        }
        return d;
    }

    public static void g(Context context, String str) {
        String str2 = context.getFilesDir().getPath() + "/theme/" + a.a(context).o() + "/";
        a(new File(context.getFilesDir().getPath() + "/theme/"));
        Resources a = a(context, str);
        if (a != null) {
            a(a, "", str2);
        }
    }

    private static Resources h(Context context) {
        Resources d = c(context) ? d(context) : a(context, e(context));
        if (d == null) {
            try {
                d = context.getPackageManager().getResourcesForApplication("com.moxiu.launcher");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return d;
    }
}
