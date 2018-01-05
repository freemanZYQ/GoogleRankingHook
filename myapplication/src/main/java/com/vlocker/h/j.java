package com.vlocker.h;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class j extends a {
    private static String a = "/sys/class/leds/spotlight/brightness";
    private Boolean b = null;

    public j(Context context) {
    }

    public boolean a() {
        boolean z = false;
        try {
            if (this.b != null) {
                return this.b.booleanValue();
            }
            File file = new File(a);
            Boolean valueOf;
            if (!file.exists()) {
                valueOf = Boolean.valueOf(false);
                this.b = valueOf;
                return valueOf.booleanValue();
            } else if (!file.canWrite()) {
                return z;
            } else {
                FileInputStream fileInputStream = new FileInputStream(a);
                int read = fileInputStream.read();
                fileInputStream.close();
                if (read == -1) {
                    this.b = null;
                    return z;
                }
                valueOf = Boolean.valueOf(true);
                this.b = valueOf;
                return valueOf.booleanValue();
            }
        } catch (Exception e) {
            this.b = null;
            return z;
        }
    }

    public boolean a(b bVar) {
        return b() ? a(false) : a(true);
    }

    public boolean a(boolean z) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(a);
            byte[] bArr = new byte[2];
            bArr[0] = (byte) (z ? 49 : 48);
            bArr[1] = (byte) 10;
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean b() {
        try {
            FileInputStream fileInputStream = new FileInputStream(a);
            int read = fileInputStream.read();
            fileInputStream.close();
            return read != 48;
        } catch (Exception e) {
            return false;
        }
    }
}
