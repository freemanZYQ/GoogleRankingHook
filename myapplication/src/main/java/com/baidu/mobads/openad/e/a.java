package com.baidu.mobads.openad.e;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.openad.b.b;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.openad.d.c;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends c {
    public static int a = IXAdIOUtils.BUFFER_SIZE;
    protected static com.baidu.mobads.openad.b.a b;
    private String d;
    private AtomicBoolean e;
    private Boolean f;
    private HttpURLConnection g;
    private AtomicBoolean h;

    static {
        try {
            b = new b();
        } catch (ClassNotFoundException e) {
            b = new d();
        }
        b.a();
    }

    public a() {
        this(null);
    }

    public a(String str) {
        this.e = new AtomicBoolean(false);
        this.f = Boolean.valueOf(false);
        this.h = new AtomicBoolean();
        this.d = str;
    }

    private static String b(InputStream inputStream) {
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str2 = "";
        while (true) {
            str2 = bufferedReader.readLine();
            if (str2 == null) {
                return str;
            }
            str = str + str2 + "\n";
        }
    }

    public void a() {
        new Thread(new c(this)).start();
    }

    public void a(com.baidu.mobads.openad.b.a aVar) {
        b = aVar;
    }

    public void a(d dVar) {
        a(dVar, 20000.0d);
    }

    public void a(d dVar, double d) {
        new b(this, dVar, d).start();
    }

    public void a(d dVar, Boolean bool) {
        this.f = bool;
        a(dVar, 20000.0d);
    }

    public void dispose() {
        this.h.set(true);
        a();
        super.dispose();
    }
}
