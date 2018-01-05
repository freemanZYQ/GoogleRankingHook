package com.moxiu.sdk.statistics.b;

import android.text.TextUtils;
import com.moxiu.sdk.statistics.a.a;
import com.moxiu.sdk.statistics.b;
import com.moxiu.sdk.statistics.e.i;
import com.moxiu.sdk.statistics.e.k;
import com.moxiu.sdk.statistics.e.l;
import com.moxiu.sdk.statistics.manager.h;
import java.net.HttpURLConnection;
import java.net.URL;

public class c {
    public static boolean a(a aVar) {
        boolean z = false;
        byte[] c = c(aVar);
        switch (d.a[aVar.b().ordinal()]) {
            case 1:
                z = a(c, b.c());
                break;
            case 2:
                z = a(c, b.a(true));
                break;
            case 3:
                z = a(c, b.a(false));
                break;
            case 4:
                z = a(c, b.c());
                b(aVar);
                break;
        }
        i.a("postData success = " + z);
        return z;
    }

    private static boolean a(byte[] bArr, String str) {
        try {
            i.a("doPost start");
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            httpURLConnection.setRequestProperty("Content-Length", bArr.length + "");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(bArr);
            int responseCode = httpURLConnection.getResponseCode();
            String responseMessage = httpURLConnection.getResponseMessage();
            httpURLConnection.disconnect();
            i.a("doPost responseCode = " + responseCode + " url = " + url + " resMessage = " + responseMessage);
            return responseCode == 200;
        } catch (Exception e) {
            i.b("doPost Exception");
            return false;
        }
    }

    private static void b(a aVar) {
        Object c = aVar.c();
        if (!TextUtils.isEmpty(c)) {
            byte[] bArr = new byte[2];
            a(bArr, b.a(k.b(h.a().b())) + c);
        }
    }

    private static byte[] c(a aVar) {
        byte[] a = b.a();
        return com.moxiu.sdk.statistics.e.b.a(l.a(com.moxiu.sdk.statistics.e.c.a(a.a(aVar), a), a));
    }
}
