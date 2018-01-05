package com.vlocker.h;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class i extends a {
    boolean a = false;
    private FileWriter b = null;
    private b c = null;
    private Boolean d = null;

    public i(Context context) {
    }

    public boolean a() {
        boolean z = false;
        try {
            if (this.d != null) {
                return this.d.booleanValue();
            }
            File file = new File("/sys/class/leds/flashlight/brightness");
            Boolean valueOf;
            if (!file.exists()) {
                valueOf = Boolean.valueOf(false);
                this.d = valueOf;
                return valueOf.booleanValue();
            } else if (!file.canWrite()) {
                return z;
            } else {
                FileInputStream fileInputStream = new FileInputStream("/sys/class/leds/flashlight/brightness");
                int read = fileInputStream.read();
                fileInputStream.close();
                if (read == -1) {
                    this.d = null;
                    return z;
                }
                valueOf = Boolean.valueOf(true);
                this.d = valueOf;
                return valueOf.booleanValue();
            }
        } catch (Exception e) {
            this.d = null;
            Boolean valueOf2 = Boolean.valueOf(z);
            this.d = valueOf2;
            return valueOf2.booleanValue();
        }
    }

    public boolean a(b bVar) {
        this.c = bVar;
        this.a = !this.a;
        a(this.a);
        if (this.c != null) {
            this.c.a(this.a);
        }
        return true;
    }

    public boolean a(boolean z) {
        try {
            if (this.b == null) {
                this.b = new FileWriter("/sys/class/leds/flashlight/brightness");
            }
            this.b.write(String.valueOf(z ? 1 : 0));
            this.b.flush();
            this.b.close();
            this.b = null;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean b() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/sys/class/leds/flashlight/brightness");
            int read = fileInputStream.read();
            fileInputStream.close();
            return read != 48;
        } catch (Exception e) {
            return false;
        }
    }
}
