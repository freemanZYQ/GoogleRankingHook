package com.vlocker.locker.d;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class l {
    public Object a(HttpEntity httpEntity, a aVar, String str) {
        if (httpEntity == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        long contentLength = httpEntity.getContentLength();
        long j = 0;
        InputStream content = httpEntity.getContent();
        while (true) {
            int read = content.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j += (long) read;
            if (aVar != null) {
                aVar.a(contentLength, j, false);
            }
        }
        if (aVar != null) {
            aVar.a(contentLength, j, true);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        content.close();
        return new String(toByteArray, str);
    }
}
