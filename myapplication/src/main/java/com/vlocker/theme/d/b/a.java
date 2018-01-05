package com.vlocker.theme.d.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a {
    private static a a = null;
    private static File b = null;
    private static FileOutputStream c = null;

    private a() {
        try {
            b = new File("/sdcard/moxiu_neterr.txt");
            if (b.exists() && b.length() > 10485760) {
                b.delete();
                b.createNewFile();
            }
            c = new FileOutputStream(b);
        } catch (Exception e) {
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public static synchronized boolean a(Exception exception, String str) {
        boolean z = false;
        synchronized (a.class) {
            System.currentTimeMillis();
            String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            for (Throwable cause = exception.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            try {
                String str2 = stringWriter.toString() + "==============" + exception.toString() + "=======time====" + format + "=====typetag======" + str;
                a();
                try {
                    if (c != null) {
                        c.write(str2.getBytes());
                        c.write("\n".getBytes());
                    }
                    z = true;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
        return z;
    }
}
