package com.xinmei365.fontsdk.c;

import java.io.Closeable;
import java.io.IOException;

public class d {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
