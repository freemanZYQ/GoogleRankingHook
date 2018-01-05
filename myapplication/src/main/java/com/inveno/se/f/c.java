package com.inveno.se.f;

import android.os.StatFs;
import java.io.File;

public class c {
    public static long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return statFs != null ? ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
