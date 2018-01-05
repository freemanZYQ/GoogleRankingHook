package com.vlocker.theme.f;

import java.io.File;
import java.io.FileFilter;

final class f implements FileFilter {
    f() {
    }

    public boolean accept(File file) {
        return file.getName().matches("^.*?\\.(mx)$");
    }
}
