package com.vlocker.security;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.openad.d.b;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.b.j;
import com.vlocker.m.h;
import com.vlocker.m.o;
import com.vlocker.m.p;
import com.vlocker.n.a;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

public class e implements UncaughtExceptionHandler {
    private static UncaughtExceptionHandler a;
    private static boolean b = false;
    private static e c;
    private static String d;
    private static int e = 0;
    private static String f = "0";
    private static boolean g = false;
    private static String h = null;
    private static int i = 3600000;

    private String a(Throwable th, String str) {
        Exception exception;
        String str2 = "";
        try {
            a(false, a(b().a(), "err_"));
            try {
                f = a.a(th);
            } catch (Exception e) {
                f = "1000";
            }
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File file = new File(a());
            if (!(file == null || file.exists())) {
                file.mkdir();
            }
            file = new File(a() + "err_" + d + "_" + format + ".txt");
            if (file != null) {
                Writer fileWriter = new FileWriter(file);
                if (fileWriter != null) {
                    try {
                        format = e() + "\n\n----exception localized message----\n";
                        str2 = th.getLocalizedMessage();
                        if (str2 != null) {
                            format = format + str2;
                        }
                        format = format + "\n\n----exception stack trace----\n";
                        fileWriter.write(format);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        if (printWriter != null) {
                            while (th != null) {
                                th.printStackTrace(printWriter);
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                PrintWriter printWriter2 = new PrintWriter(byteArrayOutputStream);
                                th.printStackTrace(printWriter2);
                                printWriter2.flush();
                                format = (format + new String(byteArrayOutputStream.toByteArray())) + "\n";
                                th = th.getCause();
                            }
                            fileWriter.write("-----dumpkey----");
                            fileWriter.write("\ndumpkey=" + f + "\n\n");
                            if (!TextUtils.isEmpty(str)) {
                                String str3 = "\n\n----attachinfo----\n" + str;
                                format = format + str3;
                                fileWriter.write(str3);
                            }
                            printWriter.close();
                        }
                        str2 = format;
                        fileWriter.close();
                    } catch (Exception e2) {
                        Exception exception2 = e2;
                        str2 = format;
                        exception = exception2;
                        exception.printStackTrace();
                        return str2;
                    }
                }
            }
        } catch (Exception e3) {
            exception = e3;
            exception.printStackTrace();
            return str2;
        }
        return str2;
    }

    private void a(int i, String str, String str2) {
        Throwable th;
        FileWriter fileWriter = null;
        FileWriter fileWriter2;
        try {
            File file = new File(a());
            if (!(file == null || file.exists())) {
                file.mkdir();
            }
            fileWriter2 = new FileWriter(new File(a() + ".crash_statistic"));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "exc");
                jSONObject.put(IXAdRequestInfo.ACT, "crash");
                jSONObject.put(b.EVENT_MESSAGE, str2);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put("ver", str);
                jSONObject.put("vcode", i);
                jSONObject.put("net", j.b(MoSecurityApplication.a()));
                jSONObject.put("androidsdk", VERSION.SDK_INT);
                jSONObject.put("ipaddr", j.f());
                fileWriter2.write(jSONObject.toString());
                fileWriter2.flush();
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileWriter2 = null;
            th = th4;
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
            throw th;
        }
    }

    private void a(Throwable th) {
        NameNotFoundException e;
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        Object obj = stringWriter.toString();
        if (!TextUtils.isEmpty(obj)) {
            int i;
            String str = null;
            try {
                PackageInfo packageInfo = MoSecurityApplication.a().getPackageManager().getPackageInfo(MoSecurityApplication.a().getPackageName(), 0);
                i = packageInfo.versionCode;
                try {
                    str = packageInfo.versionName;
                } catch (NameNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    a(i, str, obj);
                }
            } catch (NameNotFoundException e3) {
                NameNotFoundException nameNotFoundException = e3;
                i = 0;
                e = nameNotFoundException;
                e.printStackTrace();
                a(i, str, obj);
            }
            a(i, str, obj);
        }
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (c == null) {
                c = new e();
            }
            eVar = c;
        }
        return eVar;
    }

    public static void b(Context context) {
        Throwable th;
        if (j.i(context)) {
            File file = new File(h.a() + "err/" + ".crash_statistic");
            if (file.exists()) {
                BufferedReader bufferedReader = null;
                BufferedReader bufferedReader2;
                try {
                    bufferedReader2 = new BufferedReader(new FileReader(file));
                    try {
                        char[] cArr = new char[4096];
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            int read = bufferedReader2.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            stringBuffer.append(cArr, 0, read);
                        }
                        Object stringBuffer2 = stringBuffer.toString();
                        if (TextUtils.isEmpty(stringBuffer2)) {
                            file.delete();
                        } else {
                            a.a().post(new i(stringBuffer2, context, file));
                        }
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (OutOfMemoryError e2) {
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Exception e4) {
                        try {
                            file.delete();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e32) {
                                    e32.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            bufferedReader = bufferedReader2;
                            th = th3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (OutOfMemoryError e6) {
                    bufferedReader2 = null;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Exception e7) {
                    bufferedReader2 = null;
                    file.delete();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        }
    }

    private static String c() {
        MemoryInfo memoryInfo = new MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        StringBuffer stringBuffer = new StringBuffer(128);
        try {
            Field declaredField = memoryInfo.getClass().getDeclaredField("otherStats");
            declaredField.setAccessible(true);
            int[] iArr = (int[]) declaredField.get(memoryInfo);
            if (iArr != null && iArr.length > 0) {
                for (int i = 0; i < iArr.length; i++) {
                    stringBuffer.append(iArr[i]);
                    if (i < iArr.length - 1) {
                        stringBuffer.append(',');
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memoryInfo.getTotalPss() + "/" + memoryInfo.dalvikPss + "/" + memoryInfo.nativePss + "/" + memoryInfo.otherPss + "/" + Runtime.getRuntime().maxMemory() + "/" + stringBuffer.toString();
    }

    private static int d() {
        try {
            File file = new File("/proc/self/fd");
            if (file.exists() && file.isDirectory()) {
                return file.listFiles().length;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    private String e() {
        return "-----infromation----\n" + "me=" + d + "\nappflags=" + String.valueOf(e) + "\ndebug=" + String.valueOf((e & 2) != 0) + "\nboard=" + SystemProperties.get("ro.product.board", IXAdSystemUtils.NT_UNKNOWN) + "\nbootloader=" + SystemProperties.get("ro.bootloader", IXAdSystemUtils.NT_UNKNOWN) + "\nbrand=" + SystemProperties.get("ro.product.brand", IXAdSystemUtils.NT_UNKNOWN) + "\ncpu_abi=" + SystemProperties.get("ro.product.cpu.abi", IXAdSystemUtils.NT_UNKNOWN) + "\ncpu_abi2=" + SystemProperties.get("ro.product.cpu.abi2", IXAdSystemUtils.NT_UNKNOWN) + "\ndevice=" + SystemProperties.get("ro.product.device", IXAdSystemUtils.NT_UNKNOWN) + "\ndisplay=" + SystemProperties.get("ro.build.display.id", IXAdSystemUtils.NT_UNKNOWN) + "\nfingerprint=" + SystemProperties.get("ro.build.fingerprint", IXAdSystemUtils.NT_UNKNOWN) + "\nhardware=" + SystemProperties.get("ro.hardware", IXAdSystemUtils.NT_UNKNOWN) + "\nhost=" + SystemProperties.get("ro.build.host", IXAdSystemUtils.NT_UNKNOWN) + "\nid=" + SystemProperties.get("ro.build.id", IXAdSystemUtils.NT_UNKNOWN) + "\nmanufacturer=" + SystemProperties.get("ro.product.manufacturer", IXAdSystemUtils.NT_UNKNOWN) + "\nmodel=" + SystemProperties.get("ro.product.model", IXAdSystemUtils.NT_UNKNOWN) + "\nproduct=" + SystemProperties.get("ro.product.name", IXAdSystemUtils.NT_UNKNOWN) + "\nradio=" + SystemProperties.get("gsm.version.baseband", IXAdSystemUtils.NT_UNKNOWN) + "\ntags=" + SystemProperties.get("ro.build.tags", IXAdSystemUtils.NT_UNKNOWN) + "\ntype=" + SystemProperties.get("ro.build.type", IXAdSystemUtils.NT_UNKNOWN) + "\nuser=" + SystemProperties.get("ro.build.user", IXAdSystemUtils.NT_UNKNOWN) + "\ncodename=" + SystemProperties.get("ro.build.version.codename", IXAdSystemUtils.NT_UNKNOWN) + "\nincremental=" + SystemProperties.get("ro.build.version.incremental", IXAdSystemUtils.NT_UNKNOWN) + "\nrelease=" + SystemProperties.get("ro.build.version.release", IXAdSystemUtils.NT_UNKNOWN) + "\nsdk=" + SystemProperties.get("ro.build.version.sdk", IXAdSystemUtils.NT_UNKNOWN) + "\nlanguage=" + Locale.getDefault().getLanguage() + "\nmeminfo=" + c() + "\nnativefd=" + d();
    }

    private String f() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        File file = new File(MoSecurityApplication.a().getCacheDir(), "logcat_txt.temp");
        if (file.exists()) {
            file.delete();
        }
        try {
            Process exec = Runtime.getRuntime().exec("logcat -d -f " + file.getAbsolutePath());
            exec.waitFor();
            exec.destroy();
        } catch (IOException e) {
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (arrayList.size() > InitError.INIT_AD_ERROR) {
                    arrayList.remove(0);
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            file.delete();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                stringBuilder.append("\t" + ((String) it.next()) + "\n");
            }
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }

    public String a() {
        if (!g) {
            h = h.a() + "err/";
            g = true;
        }
        return h;
    }

    public void a(Context context) {
        if (!b) {
            b = true;
            d = "";
            e = 0;
            try {
                a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
                d = o.a(context);
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo != null) {
                    e = applicationInfo.flags;
                }
            } catch (Exception e) {
                d = "";
            }
        }
    }

    public void a(boolean z, File[] fileArr) {
        int i = 0;
        if (fileArr == null) {
            return;
        }
        if (z) {
            while (i < fileArr.length) {
                fileArr[i].delete();
                i++;
            }
        } else if (fileArr.length > 3) {
            Arrays.sort(fileArr, new f(this));
            int length = fileArr.length - 3;
            while (i < length) {
                fileArr[i].delete();
                i++;
            }
        }
    }

    public File[] a(String str, String str2) {
        File file = new File(str);
        if (file != null && file.exists()) {
            String[] list = file.list(new g(this, str2));
            if (!(list == null || list.length == 0)) {
                Arrays.sort(list, new h(this));
                File[] fileArr = new File[list.length];
                for (int i = 0; i < list.length; i++) {
                    fileArr[i] = new File(p.a(str) + list[i]);
                }
                return fileArr;
            }
        }
        return null;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        com.vlocker.c.a.a(MoSecurityApplication.a()).j(System.currentTimeMillis());
        String str = null;
        try {
            if (j.b(th)) {
                str = j.c(th);
            } else if (j.a(th)) {
                str = f();
            }
        } catch (Throwable th2) {
        }
        long z = com.vlocker.c.a.a(MoSecurityApplication.a()).z();
        if (z == 0 || System.currentTimeMillis() - z > ((long) i)) {
            com.vlocker.c.a.a(MoSecurityApplication.a()).c(System.currentTimeMillis());
            a(th);
        }
        a(th, str);
        if (a != null && thread != null) {
            a.uncaughtException(thread, th);
        }
    }
}
