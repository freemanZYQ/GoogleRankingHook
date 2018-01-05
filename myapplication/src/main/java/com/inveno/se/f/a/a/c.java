package com.inveno.se.f.a.a;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class c {
    private final ThreadLocal a = new ThreadLocal();
    private final ThreadLocal b = new ThreadLocal();
    private final e c = new e();

    c() {
    }

    private int a() {
        Integer num = (Integer) this.a.get();
        if (num != null) {
            this.a.remove();
            return num.intValue();
        }
        int h = this.c.h();
        if (h >= 0) {
            return h;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    private int a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 2; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(c.class.getName()) && !className.equals(a.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    private String a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.c.c() && this.c.h() == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 2; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                if (!className.equals(c.class.getName()) && !className.equals(a.class.getName())) {
                    stringBuilder.append(a(className)).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")");
                    break;
                }
            }
            stringBuilder.append(" ==> ");
        }
        if (obj == null) {
            stringBuilder.append("null");
        } else if (!TextUtils.isEmpty(obj.toString())) {
            if (obj instanceof Throwable) {
                stringBuilder.append(Log.getStackTraceString((Throwable) obj));
            } else if (obj instanceof JSONObject) {
                try {
                    stringBuilder.append(((JSONObject) obj).toString(4));
                    stringBuilder.append(System.getProperty("line.separator"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else if (obj instanceof JSONArray) {
                try {
                    stringBuilder.append(((JSONArray) obj).toString(4));
                    stringBuilder.append(System.getProperty("line.separator"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (obj instanceof Map) {
                stringBuilder.append(System.getProperty("line.separator"));
                for (Entry entry : ((Map) obj).entrySet()) {
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(" = ");
                    stringBuilder.append(entry.getValue());
                    stringBuilder.append(System.getProperty("line.separator"));
                }
            } else {
                stringBuilder.append(obj.toString());
            }
        }
        return stringBuilder.toString();
    }

    private String a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private void a(String str, b bVar) {
        b(str, bVar, "╔════════════════════════════════════════════════════════════════════════════════════════");
    }

    private void a(String str, b bVar, int i) {
        b(str, bVar);
        b(str, bVar, i);
    }

    private void a(String str, b bVar, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            if (this.c.d()) {
                b(str, bVar, "║ " + str3);
            } else {
                b(str, bVar, str3);
            }
        }
    }

    private void b(String str) {
        IOException e;
        Throwable th;
        Object f = this.c.f();
        if (!TextUtils.isEmpty(f)) {
            String g = this.c.g();
            if (TextUtils.isEmpty(g)) {
                g = ".log";
            }
            File file = new File(f + System.getProperty("file.separator") + g);
            if (!file.exists()) {
                try {
                    if (!file.createNewFile()) {
                        return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.write(str);
                    fileWriter.write(System.getProperty("line.separator"));
                    fileWriter.flush();
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e22 = e3;
                    try {
                        e22.printStackTrace();
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e222 = e5;
                fileWriter = null;
                e222.printStackTrace();
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        }
    }

    private void b(String str, b bVar) {
        if (this.c.b()) {
            b(str, bVar, "║ Thread: " + Thread.currentThread().getName());
            d(str, bVar);
        }
    }

    private void b(String str, b bVar, int i) {
        if (i > 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String str2 = "";
            int a = a(stackTrace) + this.c.i();
            if (i + a >= stackTrace.length) {
                i = (stackTrace.length - a) - 1;
            }
            while (i > 0) {
                int i2 = i + a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("║ ").append(str2).append(a(stackTrace[i2].getClassName())).append(".").append(stackTrace[i2].getMethodName()).append(" (").append(stackTrace[i2].getFileName()).append(":").append(stackTrace[i2].getLineNumber()).append(")");
                str2 = str2 + "   ";
                b(str, bVar, stringBuilder.toString());
                i--;
            }
            d(str, bVar);
        }
    }

    private void b(String str, b bVar, String str2) {
        switch (d.a[bVar.ordinal()]) {
            case 1:
                Log.e(str, str2);
                break;
            case 2:
                Log.i(str, str2);
                break;
            case 3:
                Log.v(str, str2);
                break;
            case 4:
                Log.w(str, str2);
                break;
            case 5:
                Log.wtf(str, str2);
                break;
            default:
                Log.d(str, str2);
                break;
        }
        if (b()) {
            b(str2);
        }
    }

    private boolean b() {
        Boolean bool = (Boolean) this.b.get();
        return bool != null ? bool.booleanValue() : this.c.e();
    }

    private void c(String str, b bVar) {
        b(str, bVar, "╚════════════════════════════════════════════════════════════════════════════════════════");
    }

    private void d(String str, b bVar) {
        b(str, bVar, "╟────────────────────────────────────────────────────────────────────────────────────────");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void a(java.lang.String r6, com.inveno.se.f.a.a.b r7, java.lang.Object r8) {
        /*
        r5 = this;
        r3 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        monitor-enter(r5);
        r0 = r7.ordinal();	 Catch:{ all -> 0x0053 }
        r1 = r5.c;	 Catch:{ all -> 0x0053 }
        r1 = r1.j();	 Catch:{ all -> 0x0053 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0053 }
        if (r0 >= r1) goto L_0x0015;
    L_0x0013:
        monitor-exit(r5);
        return;
    L_0x0015:
        if (r6 == 0) goto L_0x0021;
    L_0x0017:
        r0 = r6.trim();	 Catch:{ all -> 0x0053 }
        r0 = r0.length();	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0027;
    L_0x0021:
        r0 = r5.c;	 Catch:{ all -> 0x0053 }
        r6 = r0.a();	 Catch:{ all -> 0x0053 }
    L_0x0027:
        r0 = r5.c;	 Catch:{ all -> 0x0053 }
        r0 = r0.d();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0039;
    L_0x002f:
        r5.a(r6, r7);	 Catch:{ all -> 0x0053 }
        r0 = r5.a();	 Catch:{ all -> 0x0053 }
        r5.a(r6, r7, r0);	 Catch:{ all -> 0x0053 }
    L_0x0039:
        r0 = r5.a(r8);	 Catch:{ all -> 0x0053 }
        r1 = r0.getBytes();	 Catch:{ all -> 0x0053 }
        r2 = r1.length;	 Catch:{ all -> 0x0053 }
        if (r2 > r3) goto L_0x0056;
    L_0x0044:
        r5.a(r6, r7, r0);	 Catch:{ all -> 0x0053 }
    L_0x0047:
        r0 = r5.c;	 Catch:{ all -> 0x0053 }
        r0 = r0.d();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0013;
    L_0x004f:
        r5.c(r6, r7);	 Catch:{ all -> 0x0053 }
        goto L_0x0013;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0056:
        r0 = 0;
    L_0x0057:
        if (r0 >= r2) goto L_0x0047;
    L_0x0059:
        r3 = r2 - r0;
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ all -> 0x0053 }
        r4 = new java.lang.String;	 Catch:{ all -> 0x0053 }
        r4.<init>(r1, r0, r3);	 Catch:{ all -> 0x0053 }
        r5.a(r6, r7, r4);	 Catch:{ all -> 0x0053 }
        r0 = r0 + 4000;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inveno.se.f.a.a.c.a(java.lang.String, com.inveno.se.f.a.a.b, java.lang.Object):void");
    }
}
