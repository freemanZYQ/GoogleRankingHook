package com.baidu.location.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import com.baidu.location.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class d {
    public static String a = (a().b() + "/baidu/tempdata");
    private static volatile d c = null;
    private final List b = new ArrayList();
    private Context d;

    private d(Context context) {
        this.d = context;
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(f.getServiceContext());
                }
            }
        }
        return c;
    }

    private boolean a(String str) {
        boolean createNewFile;
        Exception e;
        try {
            File file = new File(str, "test.0");
            if (file.exists()) {
                file.delete();
            }
            createNewFile = file.createNewFile();
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return createNewFile;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            createNewFile = false;
            e = exception;
            e.printStackTrace();
            return createNewFile;
        }
        return createNewFile;
    }

    private List d() {
        try {
            StorageManager storageManager = (StorageManager) this.d.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class});
            Class cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Method method4 = cls.getMethod("getPath", new Class[0]);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    Object obj2;
                    String str = (String) method4.invoke(obj2, new Object[0]);
                    if (str != null && str.length() > 0) {
                        if ("mounted".equals(method2.invoke(storageManager, new Object[]{str}))) {
                            obj2 = !((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() ? 1 : null;
                            if (VERSION.SDK_INT <= 19 && a(str)) {
                                this.b.add(new a(str, obj2 == null, obj2 != null ? "Internal Storage" : "External Storage"));
                            }
                        }
                    }
                }
                if (VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = this.d.getExternalFilesDirs(null);
                    Collection arrayList = new ArrayList();
                    arrayList.addAll(this.b);
                    int i = 0;
                    while (i < externalFilesDirs.length && externalFilesDirs[i] != null) {
                        Object obj3;
                        String absolutePath = externalFilesDirs[i].getAbsolutePath();
                        for (a a : this.b) {
                            if (absolutePath.startsWith(a.a())) {
                                obj3 = 1;
                                break;
                            }
                        }
                        obj3 = null;
                        if (obj3 == null && absolutePath.indexOf(this.d.getPackageName()) != -1) {
                            arrayList.add(new a(absolutePath, true, "External Storage"));
                        }
                        i++;
                    }
                    this.b.clear();
                    this.b.addAll(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List e() {
        /*
        r9 = this;
        r2 = 0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1 = "/proc/mounts";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r1 == 0) goto L_0x005b;
    L_0x0019:
        r1 = new java.util.Scanner;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
    L_0x001e:
        r0 = r1.hasNext();	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        if (r0 == 0) goto L_0x0058;
    L_0x0024:
        r0 = r1.nextLine();	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        r5 = "/dev/block/vold/";
        r5 = r0.startsWith(r5);	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        if (r5 == 0) goto L_0x001e;
    L_0x0031:
        r5 = 9;
        r6 = 32;
        r0 = r0.replace(r5, r6);	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        r5 = " ";
        r0 = r0.split(r5);	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        if (r0 == 0) goto L_0x001e;
    L_0x0042:
        r5 = r0.length;	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        if (r5 <= 0) goto L_0x001e;
    L_0x0045:
        r5 = 1;
        r0 = r0[r5];	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        r3.add(r0);	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
        goto L_0x001e;
    L_0x004c:
        r0 = move-exception;
    L_0x004d:
        r0.printStackTrace();	 Catch:{ all -> 0x0124 }
        if (r1 == 0) goto L_0x0055;
    L_0x0052:
        r1.close();
    L_0x0055:
        r0 = r9.b;
        return r0;
    L_0x0058:
        r1.close();	 Catch:{ Exception -> 0x004c, all -> 0x0121 }
    L_0x005b:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1 = "/system/etc/vold.fstab";
        r0.<init>(r1);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1 = r0.exists();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r1 == 0) goto L_0x00bc;
    L_0x0069:
        r1 = new java.util.Scanner;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
    L_0x006e:
        r0 = r1.hasNext();	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        if (r0 == 0) goto L_0x00b9;
    L_0x0074:
        r0 = r1.nextLine();	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        r5 = "dev_mount";
        r5 = r0.startsWith(r5);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        if (r5 == 0) goto L_0x006e;
    L_0x0081:
        r5 = 9;
        r6 = 32;
        r0 = r0.replace(r5, r6);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        r5 = " ";
        r0 = r0.split(r5);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        if (r0 == 0) goto L_0x006e;
    L_0x0092:
        r5 = r0.length;	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        if (r5 <= 0) goto L_0x006e;
    L_0x0095:
        r5 = 2;
        r0 = r0[r5];	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        r5 = ":";
        r5 = r0.contains(r5);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        if (r5 == 0) goto L_0x00ad;
    L_0x00a1:
        r5 = 0;
        r6 = ":";
        r6 = r0.indexOf(r6);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        r0 = r0.substring(r5, r6);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
    L_0x00ad:
        r4.add(r0);	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
        goto L_0x006e;
    L_0x00b1:
        r0 = move-exception;
        r2 = r1;
    L_0x00b3:
        if (r2 == 0) goto L_0x00b8;
    L_0x00b5:
        r2.close();
    L_0x00b8:
        throw r0;
    L_0x00b9:
        r1.close();	 Catch:{ Exception -> 0x004c, all -> 0x00b1 }
    L_0x00bc:
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r1 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r0 = r9.b;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r5 = new com.baidu.location.b.a;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r6 = 0;
        r7 = "Auto";
        r5.<init>(r1, r6, r7);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r0.add(r5);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
    L_0x00d6:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r0 == 0) goto L_0x0118;
    L_0x00dc:
        r0 = r3.next();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r5 = r4.contains(r0);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r5 == 0) goto L_0x00d6;
    L_0x00e8:
        r5 = r0.equals(r1);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r5 != 0) goto L_0x00d6;
    L_0x00ee:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r6 = r5.exists();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r6 == 0) goto L_0x00d6;
    L_0x00f9:
        r6 = r5.isDirectory();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r6 == 0) goto L_0x00d6;
    L_0x00ff:
        r5 = r5.canWrite();	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        if (r5 == 0) goto L_0x00d6;
    L_0x0105:
        r5 = r9.b;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r6 = new com.baidu.location.b.a;	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r7 = 0;
        r8 = "Auto";
        r6.<init>(r0, r7, r8);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        r5.add(r6);	 Catch:{ Exception -> 0x0114, all -> 0x011f }
        goto L_0x00d6;
    L_0x0114:
        r0 = move-exception;
        r1 = r2;
        goto L_0x004d;
    L_0x0118:
        if (r2 == 0) goto L_0x0055;
    L_0x011a:
        r2.close();
        goto L_0x0055;
    L_0x011f:
        r0 = move-exception;
        goto L_0x00b3;
    L_0x0121:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b3;
    L_0x0124:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.d.e():java.util.List");
    }

    public String b() {
        List c = c();
        return (c == null || c.size() == 0) ? null : ((a) c.get(0)).a();
    }

    public List c() {
        List list = null;
        if (VERSION.SDK_INT >= 14) {
            list = d();
        }
        return (list == null || list.size() <= 0) ? e() : list;
    }
}
