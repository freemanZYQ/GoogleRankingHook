package com.vlocker.security;

import java.io.File;
import java.io.FilenameFilter;

class g implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    g(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
