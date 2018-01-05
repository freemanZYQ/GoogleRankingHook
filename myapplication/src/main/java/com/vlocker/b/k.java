package com.vlocker.b;

import java.io.File;
import java.io.FileFilter;

final class k implements FileFilter {
    k() {
    }

    public boolean accept(File file) {
        String name = file.getName();
        return (name == null || name.equals("") || name.contains("._") || name.contains(".tmp") || name.contains(".crdownload")) ? false : true;
    }
}
