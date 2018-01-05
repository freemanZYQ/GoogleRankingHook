package com.vlocker.security;

import java.util.Comparator;

class h implements Comparator {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public int a(String str, String str2) {
        return str2.compareTo(str);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((String) obj, (String) obj2);
    }
}
