package com.vlocker.ui.cover;

import android.content.Context;
import android.os.FileObserver;
import com.vlocker.c.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class l {
    public static long a;
    private static File b;
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static FileObserver d;

    public static String a(List list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            p pVar = (p) list.get(i);
            bArr[i] = (byte) (pVar.b() + (pVar.a() * 3));
        }
        return new String(bArr);
    }

    public static List a(String str) {
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(p.a(b / 3, b % 3));
        }
        return arrayList;
    }

    public static void a(Context context) {
        if (b == null) {
            try {
                String absolutePath = context.getFilesDir().getAbsolutePath();
                b = new File(absolutePath, "gesture.key");
                c.set(b.length() > 0);
                d = new m(absolutePath, 904);
                d.startWatching();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(List list, Context context) {
        a(context);
        byte[] c = c(list);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(b, "rwd");
            if (list == null) {
                randomAccessFile.setLength(0);
            } else {
                randomAccessFile.write(c, 0, c.length);
            }
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
    }

    public static String b(List list) {
        if (list == null) {
            return null;
        }
        String str = "";
        int size = list.size();
        for (int i = 0; i < size; i++) {
            p pVar = (p) list.get(i);
            str = str + "" + ((pVar.b() + (pVar.a() * 3)) + 1);
        }
        return str;
    }

    public static boolean b(List list, Context context) {
        try {
            a(context);
            RandomAccessFile randomAccessFile = new RandomAccessFile(b, "r");
            byte[] bArr = new byte[((int) randomAccessFile.length())];
            int read = randomAccessFile.read(bArr, 0, bArr.length);
            randomAccessFile.close();
            return read <= 0 ? c(list, context) : Arrays.equals(bArr, c(list));
        } catch (FileNotFoundException e) {
            return c(list, context);
        } catch (IOException e2) {
            return c(list, context);
        } catch (Exception e3) {
            return c(list, context);
        }
    }

    public static boolean c(List list, Context context) {
        return a.a(context).T().equals(b(list));
    }

    private static byte[] c(List list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            p pVar = (p) list.get(i);
            bArr[i] = (byte) (pVar.b() + (pVar.a() * 3));
        }
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            return bArr;
        }
    }
}
