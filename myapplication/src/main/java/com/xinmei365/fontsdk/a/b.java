package com.xinmei365.fontsdk.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.UnknownHostException;

public class b implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler Z;

    private void a(Throwable th) {
        if (th != null) {
            String stackTraceString = getStackTraceString(th);
            if (stackTraceString.contains("com.qisi.datacollect")) {
                e.v();
            } else if (stackTraceString.contains("com.xinmei365.fontsdk") || stackTraceString.contains("com.xinmei365.download")) {
                e.u();
            }
        }
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void p() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.Z = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.Z != null) {
            this.Z.uncaughtException(thread, th);
        }
    }
}
