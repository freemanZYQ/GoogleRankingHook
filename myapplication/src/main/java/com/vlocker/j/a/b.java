package com.vlocker.j.a;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.vlocker.security.MoSecurityApplication;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class b {
    private static Comparator a = new c();
    private static StringBuilder b;

    private static f a() {
        f fVar = new f();
        fVar.a(" ");
        fVar.a(0);
        return fVar;
    }

    private static BufferedReader a(int i, String str) {
        switch (i) {
            case 1:
                return new BufferedReader(new InputStreamReader(new FileInputStream(str), "UTF-8"));
            case 2:
                try {
                    return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(a.a(str).getBytes()), "UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            case 3:
                return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(d.a(str).getBytes()), "UTF-8"));
            default:
                return null;
        }
        e.printStackTrace();
        return null;
    }

    public static String a(String str) {
        String a = a(str, "/KuwoMusic/.data/LYRICS_CACHE", false);
        return (a == null || "".equals(a)) ? a(str, "/KuwoMusic/lyrics", false) : a;
    }

    public static String a(String str, String str2) {
        File[] listFiles = new File(e.c(str2)).listFiles();
        if (listFiles == null) {
            return "";
        }
        String absolutePath;
        String str3 = "";
        long j = 0;
        int i = 0;
        String str4 = "";
        while (i < listFiles.length) {
            if (j == 0 || listFiles[i].lastModified() > j) {
                j = listFiles[i].lastModified();
                str4 = listFiles[i].getAbsolutePath();
            }
            if (listFiles[i].getAbsolutePath().contains(str)) {
                absolutePath = listFiles[i].getAbsolutePath();
                break;
            }
            i++;
        }
        absolutePath = str3;
        return (!"".equals(absolutePath) || System.currentTimeMillis() - j >= 5000) ? absolutePath : str4;
    }

    public static String a(String str, String str2, boolean z) {
        File[] listFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str2).listFiles();
        String str3 = "";
        String str4 = "";
        if (listFiles == null) {
            return "";
        }
        long j = 0;
        String str5 = str4;
        int i = 0;
        String str6 = str5;
        while (i < listFiles.length) {
            if (j == 0 || listFiles[i].lastModified() > j) {
                j = listFiles[i].lastModified();
                str6 = listFiles[i].getAbsolutePath();
            }
            if (a(listFiles[i], str, z)) {
                str4 = listFiles[i].getAbsolutePath();
                break;
            }
            i++;
        }
        str4 = str3;
        return ("".equals(str4) && !"".equals(str6) && a(new File(str6), str)) ? str6 : str4;
    }

    public static List a(String str, int i) {
        List arrayList = new ArrayList();
        arrayList.add(a());
        BufferedReader a = a(i, str);
        while (true) {
            try {
                String readLine = a.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.length() > 10 && readLine.substring(1, 2).matches("^[0-9]*$")) {
                    a(readLine, i, arrayList);
                }
            } catch (IOException e) {
                e.printStackTrace();
                arrayList = new ArrayList();
                if (a != null) {
                    try {
                        a.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (a != null) {
                    try {
                        a.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
            }
        }
        if (a != null) {
            try {
                a.close();
            } catch (IOException e222) {
                e222.printStackTrace();
            }
        }
        Collections.sort(arrayList, a);
        return arrayList;
    }

    private static void a(String str, int i, List list) {
        while (str.indexOf("[") != -1) {
            f fVar = new f();
            if (i == 2) {
                fVar.a(f(str.substring(str.lastIndexOf("[") + 1, str.lastIndexOf("]"))));
            }
            if (i == 1 || i == 3) {
                fVar.a(g(str.substring(str.lastIndexOf("[") + 1, str.lastIndexOf("]"))));
            }
            fVar.a(l(str.substring(str.lastIndexOf("]") + 1)));
            list.add(fVar);
            str = e(str);
        }
    }

    private static boolean a(File file, String str) {
        Exception e;
        Throwable th;
        boolean z = false;
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));
            String readLine;
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                    }
                    break;
                } catch (Exception e2) {
                    e = e2;
                }
            } while (readLine.indexOf(str) == -1);
            z = true;
            try {
                bufferedReader2.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e3 = e4;
            bufferedReader2 = null;
            try {
                e3.printStackTrace();
                try {
                    bufferedReader2.close();
                } catch (Exception e32) {
                    e32.printStackTrace();
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (Exception e322) {
                    e322.printStackTrace();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader.close();
            throw th;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.io.File r7, java.lang.String r8, boolean r9) {
        /*
        r2 = 0;
        r1 = 0;
        if (r9 == 0) goto L_0x0051;
    L_0x0004:
        r0 = 3;
        r3 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r0 = a(r0, r3);	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
    L_0x000d:
        r1 = r0.readLine();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        if (r1 == 0) goto L_0x00cb;
    L_0x0013:
        if (r9 != 0) goto L_0x0019;
    L_0x0015:
        r1 = l(r1);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
    L_0x0019:
        r3 = "[ti:";
        r3 = r1.indexOf(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = -1;
        if (r3 == r4) goto L_0x0079;
    L_0x0023:
        r1 = r1.trim();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3.<init>();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = "[ti:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = r8.trim();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = "]";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        if (r1 == 0) goto L_0x00cd;
    L_0x004c:
        r0.close();	 Catch:{ Exception -> 0x00ae }
        r0 = r1;
    L_0x0050:
        return r0;
    L_0x0051:
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r5 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r5 = "UTF-8";
        r3.<init>(r4, r5);	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0068, all -> 0x00b4 }
        goto L_0x000d;
    L_0x0068:
        r0 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r6;
    L_0x006d:
        r1.printStackTrace();	 Catch:{ all -> 0x00c3 }
        r2.close();	 Catch:{ Exception -> 0x0074 }
        goto L_0x0050;
    L_0x0074:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0050;
    L_0x0079:
        r3 = r1.length();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = 10;
        if (r3 <= r4) goto L_0x000d;
    L_0x0081:
        r3 = 1;
        r4 = 2;
        r3 = r1.substring(r3, r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r4 = "^[0-9]*$";
        r3 = r3.matches(r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        if (r3 == 0) goto L_0x000d;
    L_0x0090:
        r3 = "]";
        r3 = r1.lastIndexOf(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3 = r3 + 1;
        r4 = r1.length();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r1 = r1.substring(r3, r4);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r1 = r1.trim();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r3 = r8.trim();	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x00c6, all -> 0x00be }
        goto L_0x004c;
    L_0x00ae:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0050;
    L_0x00b4:
        r0 = move-exception;
    L_0x00b5:
        r1.close();	 Catch:{ Exception -> 0x00b9 }
    L_0x00b8:
        throw r0;
    L_0x00b9:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00b8;
    L_0x00be:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00b5;
    L_0x00c3:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b5;
    L_0x00c6:
        r1 = move-exception;
        r6 = r0;
        r0 = r2;
        r2 = r6;
        goto L_0x006d;
    L_0x00cb:
        r1 = r2;
        goto L_0x004c;
    L_0x00cd:
        r2 = r1;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.j.a.b.a(java.io.File, java.lang.String, boolean):boolean");
    }

    public static String b(String str) {
        String a = a(str, "/netease/cloudmusic/Cache/Lyric", true);
        return (a == null || "".equals(a)) ? a(str, "com.netease.cloudmusic") : a;
    }

    public static String b(String str, String str2) {
        File[] listFiles = new File(e.c(str2)).listFiles();
        String str3 = "";
        if (listFiles == null) {
            return "";
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (a(listFiles[i], str, false)) {
                str3 = listFiles[i].getAbsolutePath();
            }
        }
        return str3;
    }

    public static String c(String str) {
        String a = a(str, "com.oppo.music");
        return (a == null || "".equals(a)) ? d(str) : a;
    }

    public static String c(String str, String str2) {
        String a = g.a(MoSecurityApplication.a()).a(str + str2);
        if (!TextUtils.isEmpty(a)) {
            File file = new File(a);
            if (!(file.exists() && a(file, str2))) {
                g.a(MoSecurityApplication.a()).b(a);
            }
            return a;
        }
        if (str != null) {
            if (str.equals("cn.kuwo.player")) {
                a = a(str2);
            }
            if (str.equals("com.oppo.music")) {
                a = c(str2);
            }
            if (str.equals("com.netease.cloudmusic")) {
                a = b(str2);
            }
            if (str.equals("com.tencent.qqmusic") || str.equals("com.duomi.android") || str.equals("fm.xiami.main") || str.equals("com.ting.mp3.android")) {
                a = b(str2, str);
            }
            if (str.equals("com.kugou.android") || str.equals("com.meizu.media.music") || str.equals("com.sds.android.ttpod") || str.equals("com.gwsoft.imusic.controller") || str.equals("com.oppo.music") || str.equals("com.android.bbkmusic") || str.equals("com.android.mediacenter") || str.equals("com.miui.player")) {
                a = a(str2, str);
            }
        }
        if (!TextUtils.isEmpty(a)) {
            g.a(MoSecurityApplication.a()).a(str + str2, a);
        }
        return a;
    }

    public static String d(String str) {
        String absolutePath;
        File[] listFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music").listFiles();
        String str2 = "";
        long j = 0;
        int i = 0;
        String str3 = "";
        while (i < listFiles.length) {
            if (j == 0 || listFiles[i].lastModified() > j) {
                j = listFiles[i].lastModified();
                str3 = listFiles[i].getAbsolutePath();
            }
            if (listFiles[i].getAbsolutePath().contains(str)) {
                absolutePath = listFiles[i].getAbsolutePath();
                break;
            }
            i++;
        }
        absolutePath = str2;
        return (!"".equals(absolutePath) || System.currentTimeMillis() - j >= 10000) ? absolutePath : str3;
    }

    private static String e(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.replace(str.lastIndexOf("["), str.lastIndexOf("]") + 1, "");
        return stringBuilder.toString();
    }

    private static long f(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(",")));
    }

    private static long g(String str) {
        return (long) ((h(str) + i(str)) + j(str));
    }

    private static int h(String str) {
        return (Integer.parseInt(str.substring(0, str.lastIndexOf(":"))) * 60) * LocationClientOption.MIN_SCAN_SPAN;
    }

    private static int i(String str) {
        return (str.indexOf(".") != -1 ? Integer.parseInt(str.substring(str.lastIndexOf(":") + 1, str.lastIndexOf("."))) : Integer.parseInt(str.substring(str.lastIndexOf(":") + 1, str.length()))) * LocationClientOption.MIN_SCAN_SPAN;
    }

    private static int j(String str) {
        if (str.indexOf(".") != -1) {
            int parseInt = Integer.parseInt(str.substring(str.lastIndexOf(".") + 1, str.length()));
            if (parseInt < 10) {
                return parseInt * 100;
            }
            if (parseInt < 100) {
                return parseInt * 10;
            }
            if (parseInt < LocationClientOption.MIN_SCAN_SPAN) {
                return parseInt;
            }
        }
        return 0;
    }

    private static StringBuilder k(String str) {
        if (b == null) {
            b = new StringBuilder();
        }
        b.delete(0, b.length());
        b.append(str);
        return b;
    }

    private static String l(String str) {
        String str2 = str;
        while (str2.lastIndexOf("<") > -1 && str2.lastIndexOf(">") > -1 && str2.lastIndexOf("<") < str2.lastIndexOf(">")) {
            try {
                StringBuilder k = k(str2);
                k.replace(str2.lastIndexOf("<"), str2.lastIndexOf(">") + 1, "");
                str2 = k.toString();
            } catch (OutOfMemoryError e) {
                return str2;
            }
        }
        return (str2 == null || !str2.equals("//")) ? str2 : " ";
    }
}
