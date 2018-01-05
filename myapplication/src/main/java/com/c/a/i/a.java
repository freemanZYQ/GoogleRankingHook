package com.c.a.i;

public class a {
    private static com.c.a.j.a a;

    public static synchronized com.c.a.j.a a() {
        com.c.a.j.a aVar;
        synchronized (a.class) {
            aVar = a;
        }
        return aVar;
    }

    public static synchronized void a(com.c.a.j.a aVar) {
        synchronized (a.class) {
            a = aVar;
        }
    }
}
