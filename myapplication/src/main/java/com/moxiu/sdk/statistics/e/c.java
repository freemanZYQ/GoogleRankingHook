package com.moxiu.sdk.statistics.e;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class c {
    public static synchronized byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        synchronized (c.class) {
            bArr3 = null;
            try {
                bArr3 = b(bArr, bArr2);
            } catch (Throwable e) {
                i.a("getEncryptData Exception = ", e);
            }
        }
        return bArr3;
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        SecureRandom secureRandom = new SecureRandom();
        Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
        Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
        instance.init(1, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }
}
