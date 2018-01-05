package com.vlocker.b;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class g {
    private byte[] a;

    public g(String str) {
        this.a = str.getBytes();
    }

    public static synchronized byte[] a(String str, String str2) {
        byte[] bArr;
        synchronized (g.class) {
            bArr = null;
            try {
                bArr = new g(str2).a(str.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bArr;
    }

    public byte[] a(byte[] bArr) {
        SecureRandom secureRandom = new SecureRandom();
        Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.a));
        Cipher instance = Cipher.getInstance("DES/ECB/PKCS5Padding");
        instance.init(1, generateSecret, secureRandom);
        return instance.doFinal(bArr);
    }
}
