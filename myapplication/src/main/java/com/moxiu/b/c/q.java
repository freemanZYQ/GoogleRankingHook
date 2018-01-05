package com.moxiu.b.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class q {
    final /* synthetic */ o a;

    public q(o oVar) {
        this.a = oVar;
    }

    public Object a(HttpEntity httpEntity, l lVar, String str) {
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
            if (lVar != null) {
                lVar.a(contentLength, j, false);
            }
        }
        if (lVar != null) {
            lVar.a(contentLength, j, true);
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        content.close();
        return new String(toByteArray, str);
    }
}
