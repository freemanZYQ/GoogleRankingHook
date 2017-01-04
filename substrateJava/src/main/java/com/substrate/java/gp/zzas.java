package com.substrate.java.gp;

import android.util.Base64;
import android.util.Log;

import java.nio.ByteBuffer;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by apple on 16/12/13.
 */
public class zzas {

    public String run(String input){
        byte[] zzl = null;
        try {
            zzl  = zzl("jSo0IjLj1COFscfE+lbeS9vfvy751HSygbsf8jP3feI=");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        try {
            byte[] data = zzc(zzl, input);
            String result = new String(data, "UTF-8");
            Log.d("result","input:"+input+"  result:"+result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    public final byte[] zzl(String str) throws zza {
        try {
            byte[] zza = this.zza(str, false);
            if (zza.length != 32) {
                throw new zza(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(zza, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            return bArr;
        } catch (Throwable e) {
            throw new zza(this, e);
        }
    }
    public class zza extends Exception {
        final /* synthetic */ zzas zzol;

        public zza(zzas com_google_android_gms_internal_zzas) {
            this.zzol = com_google_android_gms_internal_zzas;
        }

        public zza(zzas com_google_android_gms_internal_zzas, Throwable th) {
            this.zzol = com_google_android_gms_internal_zzas;
        }
    }

    public final byte[] zza(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }

    private  String zzb(byte[] bArr, String str) throws zza {
        try {
            return new String(zzc(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new zza(this,e);
        }
    }

    public final byte[] zzc(byte[] bArr, String str) throws zza {
        if (bArr.length != 16) {
            throw new zza(this);
        }
        try {
            byte[] zza = zza(str, false);
            if (zza.length <= 16) {
                throw new zza(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(zza.length);
            allocate.put(zza);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            zza = new byte[(zza.length - 16)];
            allocate.get(bArr2);
            allocate.get(zza);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(zza);
        } catch (Throwable e) {
            throw new zza(this, e);
        }
    }
}
