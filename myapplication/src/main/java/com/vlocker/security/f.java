package com.vlocker.security;

import java.io.File;
import java.util.Comparator;

class f implements Comparator {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public int a(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }
}
