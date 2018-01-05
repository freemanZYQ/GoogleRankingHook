package com.vlocker.battery.clean;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ak {
    public static int a = 0;
    private static double b;
    private static int c = 0;

    public static int a(double d) {
        return d < ((double) ((int) d)) + 0.5d ? (int) d : (int) (d + 0.5d);
    }

    public static int a(double d, double d2) {
        double d3 = d / d2;
        double d4 = (1.0d - b) * d2;
        if (d <= d4 || d4 <= 0.0d) {
            a = 0;
        } else {
            a = a(((d - d4) / 1024.0d) / 1024.0d);
        }
        b = 1.0d - d3;
        c = a(b * 100.0d);
        return Math.abs(c);
    }

    public static long a() {
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        try {
            long a;
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            int length = bArr.length;
            int i = 0;
            while (i < read && 0 == 0) {
                if (a(bArr, i, "MemTotal")) {
                    a = a(bArr, i + 8);
                    break;
                }
                while (i < length && bArr[i] != (byte) 10) {
                    i++;
                }
                i++;
            }
            a = 0;
            return Math.abs(a);
        } catch (FileNotFoundException e) {
            return 0;
        } catch (IOException e2) {
            return 0;
        }
    }

    public static long a(Context context) {
        MemoryInfo memoryInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo2 = new MemoryInfo();
            try {
                activityManager.getMemoryInfo(memoryInfo2);
                memoryInfo = memoryInfo2;
            } catch (OutOfMemoryError e) {
                memoryInfo = memoryInfo2;
            } catch (Exception e2) {
                memoryInfo = memoryInfo2;
            }
        } catch (OutOfMemoryError e3) {
            memoryInfo = null;
        } catch (Exception e4) {
            memoryInfo = null;
        }
        return Math.abs(memoryInfo.availMem);
    }

    private static long a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != (byte) 10) {
            if (bArr[i] < (byte) 48 || bArr[i] > (byte) 57) {
                i++;
            } else {
                int i2 = i + 1;
                while (i2 < bArr.length && bArr[i2] >= (byte) 48 && bArr[i2] <= (byte) 57) {
                    i2++;
                }
                return ((long) Integer.parseInt(new String(bArr, 0, i, i2 - i))) * 1024;
            }
        }
        return 0;
    }

    private static boolean a(byte[] bArr, int i, String str) {
        int length = str.length();
        if (i + length >= bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i + i2] != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }
}
