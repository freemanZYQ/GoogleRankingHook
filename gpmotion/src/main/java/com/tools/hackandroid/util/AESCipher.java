package com.tools.hackandroid.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher
{
	/**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "AES";

    /**
     * 模式/填充
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

	public static byte[] encrypt(byte[] data, byte[] keyData, byte[] ivData)
            throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyData, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(ivData);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, byte[] keyData, byte[] ivData)
            throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyData, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(ivData);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(data);
    }
}