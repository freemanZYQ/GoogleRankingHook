package com.vlocker.model;

import java.util.Comparator;

public class j implements Comparator {
    public int a(e eVar, e eVar2) {
        return (eVar.a().equals("@") || eVar2.a().equals("#")) ? 1 : (eVar.a().equals("#") || eVar2.a().equals("@")) ? -1 : eVar.a().compareTo(eVar2.a());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((e) obj, (e) obj2);
    }
}
