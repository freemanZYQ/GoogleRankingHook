package com.c.a.e;

public class a extends Exception {
    public a(b bVar) {
        super(a(bVar));
    }

    private static String a(b bVar) {
        return bVar == null ? "AppLinkSDK error!" : "AppLinkSDK error! code: " + bVar.f;
    }
}
