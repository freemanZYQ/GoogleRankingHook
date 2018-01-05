package com.vlocker.update;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class g {
    protected static char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest b;

    static {
        b = null;
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(g.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    public static String a(File file) {
        InputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                b.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return a(b.digest());
            }
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char c = a[(b & 240) >> 4];
        char c2 = a[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
