package com.vlocker.theme.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.InputStream;

public class c {
    private static String a = null;

    private static Bitmap a(Context context, Resources resources, int i, String str) {
        InputStream openRawResource;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            openRawResource = resources.openRawResource(i);
        } catch (NotFoundException e) {
            try {
                openRawResource = resources.openRawResource(resources.getIdentifier("moxiu_preview", "drawable", str));
            } catch (NotFoundException e2) {
                return null;
            }
        } catch (Exception e3) {
            openRawResource = null;
        }
        BitmapFactory.decodeStream(openRawResource, null, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (e.a == null) {
            e.a(context.getApplicationContext());
        }
        SharedPreferences sharedPreferences = e.a.getSharedPreferences("moxiu_theme_config", 1);
        int i4 = sharedPreferences.getInt("moble_screen_width", 320);
        int i5 = sharedPreferences.getInt("moble_screen_heigth", 480);
        options.inSampleSize = 1;
        if (i2 > i3) {
            if (i2 > i4) {
                options.inSampleSize = i2 / i4;
            }
        } else if (i3 > i5) {
            options.inSampleSize = i3 / i5;
        }
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
        return decodeStream == null ? null : decodeStream;
    }

    public static Bitmap a(Context context, String str, int i) {
        Bitmap bitmap = null;
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        if (l != null) {
            String str2 = l.packageName;
        } else {
            Object obj = bitmap;
        }
        String str3 = i == 1 ? "moxiu_preview" : i == 2 ? "moxiu_mainmenu" : i == 3 ? "vlocker_widget_preview" : i == 4 ? "moxiu_preview_thumbnail" : "vlocker_widget_preview";
        if (m != null) {
            int identifier = m.getIdentifier(str3, "drawable", str2);
            if (identifier == 0) {
                identifier = m.getIdentifier(str3, "drawable", str2);
            }
            if (identifier != 0) {
                try {
                    bitmap = a(context, m, identifier, str2);
                } catch (OutOfMemoryError e) {
                }
            }
        }
        return bitmap;
    }

    public static Drawable a(Context context, String str) {
        return c(context, str, 0);
    }

    public static boolean a(Context context, String str, String str2) {
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        String str3 = l != null ? l.packageName : null;
        if (m != null) {
            int identifier = m.getIdentifier(str2, "drawable", str3);
            if (identifier == 0) {
                identifier = m.getIdentifier(str2, "drawable", str3);
            }
            if (identifier != 0) {
                return true;
            }
        }
        return false;
    }

    public static Drawable b(Context context, String str) {
        return c(context, str, 1);
    }

    public static String b(Context context, String str, int i) {
        String str2;
        String str3 = null;
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        String str4 = l != null ? l.packageName : str3;
        String str5 = "moxiu_theme_name";
        switch (i) {
            case 1:
                str2 = "moxiu_theme_name";
                break;
            case 2:
                str2 = "isLockerWidget";
                break;
            default:
                str2 = str5;
                break;
        }
        if (m != null) {
            int identifier = str3 == null ? m.getIdentifier(str2, "string", str4) : m.getIdentifier(str2, "string", str4);
            if (identifier != 0) {
                try {
                    str3 = m.getString(identifier);
                } catch (OutOfMemoryError e) {
                }
            }
        }
        return str3;
    }

    public static Drawable c(Context context, String str) {
        return c(context, str, 2);
    }

    private static Drawable c(Context context, String str, int i) {
        try {
            Bitmap a = a(context, str, i);
            if (a == null) {
                return null;
            }
            Drawable bitmapDrawable = new BitmapDrawable(a);
            return bitmapDrawable != null ? bitmapDrawable : bitmapDrawable;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    public static Drawable d(Context context, String str) {
        return c(context, str, 3);
    }

    public static Drawable e(Context context, String str) {
        return c(context, str, 4);
    }

    public static int f(Context context, String str) {
        String str2 = null;
        int color = context.getResources().getColor(17170443);
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        if (l != null) {
            str2 = l.packageName;
        }
        if (m == null) {
            return color;
        }
        int identifier = m.getIdentifier("moxiu_color", "color", str2);
        return identifier != 0 ? m.getColor(identifier) : color;
    }

    public static String g(Context context, String str) {
        String str2 = null;
        String str3 = "drawable-xdpi";
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        if (l != null) {
            str2 = l.packageName;
        }
        return m != null ? m.getIdentifier("drawable_level", "string", str2) != 0 ? "drawable-xdpi" : "drawable-hdpi" : str3;
    }

    public static String h(Context context, String str) {
        String str2 = null;
        try {
            Resources m = m(context, str);
            ApplicationInfo l = l(context, str);
            if (l != null) {
                a = l.packageName;
            }
            if (m != null) {
                str2 = m.getString(m.getIdentifier("vlocker_need_num_pwd_hint", "string", a));
            }
        } catch (NotFoundException e) {
        }
        return str2;
    }

    public static Drawable i(Context context, String str) {
        Resources m = m(context, str);
        ApplicationInfo l = l(context, str);
        String str2 = l != null ? l.packageName : null;
        if (m != null) {
            int identifier = m.getIdentifier("moxiu_preview", "drawable", str2);
            if (identifier == 0) {
                identifier = m.getIdentifier("moxiu_preview", "drawable", str2);
            }
            if (identifier != 0) {
                try {
                    Drawable bitmapDrawable = new BitmapDrawable(a(context, m, identifier, str2));
                    return bitmapDrawable != null ? bitmapDrawable : bitmapDrawable;
                } catch (OutOfMemoryError e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static Drawable j(Context context, String str) {
        Resources k = k(context, str);
        str + "_moxiu_preview_thumb.jpg";
        if (k != null) {
            int identifier = k.getIdentifier("moxiu_preview", "drawable", str);
            if (identifier == 0) {
                identifier = k.getIdentifier("moxiu_preview", "drawable", str);
            }
            if (identifier != 0) {
                try {
                    Drawable bitmapDrawable = new BitmapDrawable(a(context, k, identifier, str));
                    return bitmapDrawable != null ? bitmapDrawable : bitmapDrawable;
                } catch (OutOfMemoryError e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static Resources k(Context context, String str) {
        try {
            return context.getPackageManager().getResourcesForApplication(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static ApplicationInfo l(Context context, String str) {
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

    public static Resources m(Context context, String str) {
        String str2 = "android.content.pm.PackageParser";
        String str3 = "android.content.res.AssetManager";
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                a = packageArchiveInfo.applicationInfo.packageName;
            }
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
                a = ((ApplicationInfo) invoke.getClass().getDeclaredField("applicationInfo").get(invoke)).packageName;
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
}
