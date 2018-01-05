package com.moxiu.sdk.statistics.e;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

public class b {
    private static void a(InputStream inputStream, OutputStream outputStream) {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
            if (read != -1) {
                deflaterOutputStream.write(bArr, 0, read);
            } else {
                deflaterOutputStream.flush();
                deflaterOutputStream.close();
                return;
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(byteArrayInputStream, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayInputStream.close();
            return toByteArray;
        } catch (Throwable th) {
            i.a("compressData Exception = ", th);
            return null;
        }
    }
}
