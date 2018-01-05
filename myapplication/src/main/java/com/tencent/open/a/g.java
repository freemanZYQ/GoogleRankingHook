package com.tencent.open.a;

import android.os.StatFs;
import java.io.File;

public class g {
    private File a;
    private long b;
    private long c;

    public static g b(File file) {
        g gVar = new g();
        gVar.a(file);
        StatFs statFs = new StatFs(file.getAbsolutePath());
        long blockSize = (long) statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        gVar.a(((long) statFs.getBlockCount()) * blockSize);
        gVar.b(blockSize * availableBlocks);
        return gVar;
    }

    public File a() {
        return this.a;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(File file) {
        this.a = file;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public String toString() {
        return String.format("[%s : %d / %d]", new Object[]{a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())});
    }
}
