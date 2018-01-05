package com.vlocker.m;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class q {
    private File a;
    private String b;

    public File a() {
        return this.a;
    }

    public void a(File file) {
        this.a = file;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a.getName();
    }

    public byte[] d() {
        FileInputStream fileInputStream;
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(this.a);
            try {
                byte[] bArr2 = new byte[IXAdIOUtils.BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr2, 0, IXAdIOUtils.BUFFER_SIZE);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileInputStream.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e322 = e5;
                e322.printStackTrace();
                try {
                    fileInputStream.close();
                } catch (IOException e3222) {
                    e3222.printStackTrace();
                }
                return bArr;
            }
        } catch (FileNotFoundException e6) {
            e2 = e6;
            fileInputStream = bArr;
            e2.printStackTrace();
            fileInputStream.close();
            return bArr;
        } catch (IOException e7) {
            e3222 = e7;
            fileInputStream = bArr;
            e3222.printStackTrace();
            fileInputStream.close();
            return bArr;
        } catch (Throwable th3) {
            fileInputStream = bArr;
            th = th3;
            fileInputStream.close();
            throw th;
        }
        return bArr;
    }
}
