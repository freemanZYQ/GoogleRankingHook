package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class PM {
    private static final Map i = new HashMap() {
        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };
    private final Context a;
    private String b;
    private File c;
    private int d;
    private DexClassLoader e;
    private RandomAccessFile f;
    private FileLock g;
    private boolean h = b();

    public PM(Context context) {
        this.a = context.getApplicationContext();
        if (a()) {
            GDTLogger.d("PluginFile:\t" + (this.c == null ? "null" : this.c.getAbsolutePath()));
            if (this.b != null) {
                try {
                    this.e = new DexClassLoader(this.c.getAbsolutePath(), this.a.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
                    return;
                } catch (Throwable th) {
                    GDTLogger.e("exception while init plugin class loader", th);
                    return;
                }
            }
            this.e = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
        r7 = this;
        r6 = 520; // 0x208 float:7.29E-43 double:2.57E-321;
        r1 = 1;
        r0 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fa }
        r3 = "TimeStap_BEFORE_PLUGIN_INIT:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00fa }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00fa }
        com.qq.e.comm.util.GDTLogger.d(r2);	 Catch:{ Throwable -> 0x00fa }
        r2 = r7.h;	 Catch:{ Throwable -> 0x00fa }
        if (r2 == 0) goto L_0x0059;
    L_0x001f:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00fa }
        r3 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r3 = com.qq.e.comm.managers.plugin.c.b(r3);	 Catch:{ Throwable -> 0x00fa }
        r4 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r4 = com.qq.e.comm.managers.plugin.c.d(r4);	 Catch:{ Throwable -> 0x00fa }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00fa }
        r3 = r2.a();	 Catch:{ Throwable -> 0x00fa }
        if (r3 == 0) goto L_0x0059;
    L_0x0036:
        r3 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r3 = com.qq.e.comm.managers.plugin.c.a(r3);	 Catch:{ Throwable -> 0x00fa }
        r4 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r4 = com.qq.e.comm.managers.plugin.c.c(r4);	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.a(r3, r4);	 Catch:{ Throwable -> 0x00fa }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fa }
        r4 = "NextExist,Updated=";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00fa }
        r2 = r3.append(r2);	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00fa }
        com.qq.e.comm.util.GDTLogger.d(r2);	 Catch:{ Throwable -> 0x00fa }
    L_0x0059:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00fa }
        r3 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r3 = com.qq.e.comm.managers.plugin.c.a(r3);	 Catch:{ Throwable -> 0x00fa }
        r4 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r4 = com.qq.e.comm.managers.plugin.c.c(r4);	 Catch:{ Throwable -> 0x00fa }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00fa }
        r3 = r2.a();	 Catch:{ Throwable -> 0x00fa }
        if (r3 == 0) goto L_0x0092;
    L_0x0070:
        r3 = r2.b();	 Catch:{ Throwable -> 0x00fa }
        if (r3 >= r6) goto L_0x00b5;
    L_0x0076:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fa }
        r3 = "last updated plugin version =";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00fa }
        r3 = r7.d;	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00fa }
        r3 = ";asset plugin version=520";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00fa }
        com.qq.e.comm.util.GDTLogger.d(r2);	 Catch:{ Throwable -> 0x00fa }
    L_0x0092:
        r2 = r0;
    L_0x0093:
        if (r2 != 0) goto L_0x009c;
    L_0x0095:
        r2 = r7.h;	 Catch:{ Throwable -> 0x00fa }
        if (r2 != 0) goto L_0x00cb;
    L_0x0099:
        r2 = r0;
    L_0x009a:
        if (r2 == 0) goto L_0x009d;
    L_0x009c:
        r0 = r1;
    L_0x009d:
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.e.comm.util.GDTLogger.d(r1);
    L_0x00b4:
        return r0;
    L_0x00b5:
        r3 = r2.c();	 Catch:{ Throwable -> 0x00fa }
        r7.b = r3;	 Catch:{ Throwable -> 0x00fa }
        r2 = r2.b();	 Catch:{ Throwable -> 0x00fa }
        r7.d = r2;	 Catch:{ Throwable -> 0x00fa }
        r2 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r2 = com.qq.e.comm.managers.plugin.c.a(r2);	 Catch:{ Throwable -> 0x00fa }
        r7.c = r2;	 Catch:{ Throwable -> 0x00fa }
        r2 = r1;
        goto L_0x0093;
    L_0x00cb:
        r2 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r3 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r3 = com.qq.e.comm.managers.plugin.c.a(r3);	 Catch:{ Throwable -> 0x00fa }
        r4 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r4 = com.qq.e.comm.managers.plugin.c.c(r4);	 Catch:{ Throwable -> 0x00fa }
        r2 = com.qq.e.comm.a.a(r2, r3, r4);	 Catch:{ Throwable -> 0x00fa }
        if (r2 == 0) goto L_0x00f2;
    L_0x00df:
        r2 = "JuIpG070LoNY6cdUxFQdZ8KVnByI9Vd7Rh0vEyAUOPTLwgI+GZy7iBWO7nEbJHj/thDWyzLLzpxiZW86NSWn65A1YN9r0ez5UjQp5aTeURTNpBfmbCdLs3zyl5k6zIr9gppmLv1SOU/8n+CJYSm77J+lPsk0ChJ4me7Dq/CEMts=";
        r7.b = r2;	 Catch:{ Throwable -> 0x00fa }
        r2 = r7.a;	 Catch:{ Throwable -> 0x00fa }
        r2 = com.qq.e.comm.managers.plugin.c.a(r2);	 Catch:{ Throwable -> 0x00fa }
        r7.c = r2;	 Catch:{ Throwable -> 0x00fa }
        r2 = 520; // 0x208 float:7.29E-43 double:2.57E-321;
        r7.d = r2;	 Catch:{ Throwable -> 0x00fa }
        r2 = r1;
        goto L_0x009a;
    L_0x00f2:
        r2 = "Fail to prepair Defult plugin ";
        com.qq.e.comm.util.GDTLogger.e(r2);	 Catch:{ Throwable -> 0x00fa }
        r2 = r0;
        goto L_0x009a;
    L_0x00fa:
        r1 = move-exception;
        r2 = "Exception while init plugin manager";
        com.qq.e.comm.util.GDTLogger.report(r2, r1);	 Catch:{ all -> 0x0119 }
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.e.comm.util.GDTLogger.d(r1);
        goto L_0x00b4;
    L_0x0119:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.qq.e.comm.util.GDTLogger.d(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.a():boolean");
    }

    private boolean b() {
        try {
            File file = new File(this.a.getDir("e_qq_com_plugin", 0), "update_lc");
            if (!file.exists()) {
                file.createNewFile();
                StringUtil.writeTo("lock", file);
            }
            if (!file.exists()) {
                return false;
            }
            this.f = new RandomAccessFile(file, "rw");
            this.g = this.f.getChannel().tryLock();
            if (this.g == null) {
                return false;
            }
            this.f.writeByte(37);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public Object getFactory(Class cls) {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = this.e;
        if (classLoader == null) {
            throw new b("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = (String) i.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new b("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class loadClass = classLoader.loadClass(str);
            return cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (Throwable th) {
            b bVar = new b("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return this.b;
    }

    public POFactory getPOFactory() {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.d;
    }

    public void update(String str, String str2) {
        if (this.h) {
            new a(this.a).a(str, str2);
        }
    }
}
