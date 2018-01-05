package com.vlocker.theme.imageloader;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class l implements Closeable {
    private static final Charset a = Charset.forName("UTF-8");
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private final long f;
    private final int g;
    private long h = 0;
    private Writer i;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    private int k;
    private long l = 0;
    private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable n = new m(this);

    private l(File file, int i, int i2, long j) {
        this.b = file;
        this.e = i;
        this.c = new File(file, "journal");
        this.d = new File(file, "journal.tmp");
        this.g = i2;
        this.f = j;
    }

    public static l a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            l lVar = new l(file, i, i2, j);
            if (lVar.c.exists()) {
                try {
                    lVar.e();
                    lVar.f();
                    lVar.i = new BufferedWriter(new FileWriter(lVar.c, true), 8192);
                    return lVar;
                } catch (IOException e) {
                    try {
                        lVar.d();
                    } catch (Exception e2) {
                    }
                }
            }
            file.mkdirs();
            lVar = new l(file, i, i2, j);
            lVar.g();
            return lVar;
        }
    }

    private synchronized n a(String str, long j) {
        n nVar;
        i();
        e(str);
        p pVar = (p) this.j.get(str);
        if (j == -1 || (pVar != null && pVar.f == j)) {
            p pVar2;
            if (pVar == null) {
                pVar = new p(this, str);
                this.j.put(str, pVar);
                pVar2 = pVar;
            } else if (pVar.e != null) {
                nVar = null;
            } else {
                pVar2 = pVar;
            }
            nVar = new n(this, pVar2);
            pVar2.e = nVar;
            this.i.write("DIRTY " + str + '\n');
            this.i.flush();
        } else {
            nVar = null;
        }
        return nVar;
    }

    public static String a(InputStream inputStream) {
        int read;
        StringBuilder stringBuilder = new StringBuilder(80);
        while (true) {
            read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                break;
            } else {
                stringBuilder.append((char) read);
            }
        }
        read = stringBuilder.length();
        if (read > 0 && stringBuilder.charAt(read - 1) == '\r') {
            stringBuilder.setLength(read - 1);
        }
        return stringBuilder.toString();
    }

    private synchronized void a(n nVar, boolean z) {
        int i = 0;
        synchronized (this) {
            p a = nVar.b;
            if (a.e != nVar) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.d) {
                    int i2 = 0;
                    while (i2 < this.g) {
                        if (a.b(i2).exists()) {
                            i2++;
                        } else {
                            nVar.b();
                            throw new IllegalStateException("edit didn't create file " + i2);
                        }
                    }
                }
            }
            while (i < this.g) {
                File b = a.b(i);
                if (!z) {
                    b(b);
                } else if (b.exists()) {
                    File a2 = a.a(i);
                    b.renameTo(a2);
                    long j = a.c[i];
                    long length = a2.length();
                    a.c[i] = length;
                    this.h = (this.h - j) + length;
                }
                i++;
            }
            this.k++;
            a.e = null;
            if ((a.d | z) != 0) {
                a.d = true;
                this.i.write("CLEAN " + a.b + a.a() + '\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    a.f = j2;
                }
            } else {
                this.j.remove(a.b);
                this.i.write("REMOVE " + a.b + '\n');
            }
            if (this.h > this.f || h()) {
                this.m.submit(this.n);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException("not a directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private static Object[] a(Object[] objArr, int i, int i2) {
        int length = objArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3);
            System.arraycopy(objArr, i, objArr2, 0, min);
            return objArr2;
        }
    }

    private static void b(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private void d(String str) {
        Object[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = split[1];
        if (split[0].equals("REMOVE") && split.length == 2) {
            this.j.remove(str2);
            return;
        }
        p pVar;
        p pVar2 = (p) this.j.get(str2);
        if (pVar2 == null) {
            pVar2 = new p(this, str2);
            this.j.put(str2, pVar2);
            pVar = pVar2;
        } else {
            pVar = pVar2;
        }
        if (split[0].equals("CLEAN") && split.length == this.g + 2) {
            pVar.d = true;
            pVar.e = null;
            pVar.a((String[]) a(split, 2, split.length));
        } else if (split[0].equals("DIRTY") && split.length == 2) {
            pVar.e = new n(this, pVar);
        } else if (!split[0].equals("READ") || split.length != 2) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void e() {
        Closeable bufferedInputStream = new BufferedInputStream(new FileInputStream(this.c), 8192);
        try {
            String a = a((InputStream) bufferedInputStream);
            String a2 = a((InputStream) bufferedInputStream);
            String a3 = a((InputStream) bufferedInputStream);
            String a4 = a((InputStream) bufferedInputStream);
            String a5 = a((InputStream) bufferedInputStream);
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.e).equals(a3) && Integer.toString(this.g).equals(a4) && "".equals(a5)) {
                while (true) {
                    try {
                        d(a((InputStream) bufferedInputStream));
                    } catch (EOFException e) {
                        a(bufferedInputStream);
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (Throwable th) {
            a(bufferedInputStream);
        }
    }

    private void e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    private void f() {
        b(this.d);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            int i;
            if (pVar.e == null) {
                for (i = 0; i < this.g; i++) {
                    this.h += pVar.c[i];
                }
            } else {
                pVar.e = null;
                for (i = 0; i < this.g; i++) {
                    b(pVar.a(i));
                    b(pVar.b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void g() {
        if (this.i != null) {
            this.i.close();
        }
        Writer bufferedWriter = new BufferedWriter(new FileWriter(this.d), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (p pVar : this.j.values()) {
            if (pVar.e != null) {
                bufferedWriter.write("DIRTY " + pVar.b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + pVar.b + pVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.d.renameTo(this.c);
        this.i = new BufferedWriter(new FileWriter(this.c, true), 8192);
    }

    private boolean h() {
        return this.k >= 2000 && this.k >= this.j.size();
    }

    private void i() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized q a(String str) {
        q qVar = null;
        synchronized (this) {
            i();
            e(str);
            p pVar = (p) this.j.get(str);
            if (pVar != null) {
                if (pVar.d) {
                    InputStream[] inputStreamArr = new InputStream[this.g];
                    int i = 0;
                    while (i < this.g) {
                        try {
                            inputStreamArr[i] = new FileInputStream(pVar.a(i));
                            i++;
                        } catch (FileNotFoundException e) {
                        }
                    }
                    this.k++;
                    this.i.append("READ " + str + '\n');
                    if (h()) {
                        this.m.submit(this.n);
                    }
                    qVar = new q(this, str, pVar.f, inputStreamArr);
                }
            }
        }
        return qVar;
    }

    public boolean a() {
        return this.i == null;
    }

    public n b(String str) {
        return a(str, -1);
    }

    public synchronized void b() {
        i();
        c();
        this.i.flush();
    }

    public void c() {
        while (this.h > this.f) {
            c((String) ((Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized boolean c(String str) {
        boolean z;
        int i = 0;
        synchronized (this) {
            i();
            e(str);
            p pVar = (p) this.j.get(str);
            if (pVar == null || pVar.e != null) {
                z = false;
            } else {
                while (i < this.g) {
                    File a = pVar.a(i);
                    if (a.delete()) {
                        this.h -= pVar.c[i];
                        pVar.c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.k++;
                this.i.append("REMOVE " + str + '\n');
                this.j.remove(str);
                if (h()) {
                    this.m.submit(this.n);
                }
                z = true;
            }
        }
        return z;
    }

    public synchronized void close() {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar.e != null) {
                    pVar.e.b();
                }
            }
            c();
            this.i.close();
            this.i = null;
        }
    }

    public void d() {
        close();
        a(this.b);
    }
}
