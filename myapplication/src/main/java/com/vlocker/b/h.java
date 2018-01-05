package com.vlocker.b;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class h {
    private static String a = "RSA";

    public static PublicKey a(InputStream inputStream) {
        try {
            return a(b(inputStream));
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e2) {
            throw new Exception("公钥输入流为空");
        }
    }

    public static PublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(a).generatePublic(new X509EncodedKeySpec(f.a(str)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e3) {
            throw new Exception("公钥数据为空");
        }
    }

    public static byte[] a(String str, Context context) {
        try {
            InputStream open = context.getResources().getAssets().open("alc_public.pem");
            PublicKey a = a(open);
            RSAPublicKey rSAPublicKey = (RSAPublicKey) a;
            open.close();
            return a(str.getBytes(), a);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String b(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuilder.toString();
            }
            if (readLine.charAt(0) != '-') {
                stringBuilder.append(readLine);
                stringBuilder.append('\r');
            }
        }
    }
}
