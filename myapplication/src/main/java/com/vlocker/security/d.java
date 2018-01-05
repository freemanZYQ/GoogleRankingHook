package com.vlocker.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class d implements Runnable {
    final /* synthetic */ MoSecurityApplication a;

    d(MoSecurityApplication moSecurityApplication) {
        this.a = moSecurityApplication;
    }

    public void run() {
        Throwable th;
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream()));
            try {
                String str = "";
                do {
                    str = bufferedReader2.readLine();
                    if (str == null) {
                        break;
                    }
                } while (!str.contains("ro.yunos"));
                MoSecurityApplication.e = true;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedReader = bufferedReader2;
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
