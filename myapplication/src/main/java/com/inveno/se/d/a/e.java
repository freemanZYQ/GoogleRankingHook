package com.inveno.se.d.a;

import android.os.SystemClock;
import com.inveno.se.d.ab;
import com.inveno.se.d.b;
import com.inveno.se.d.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class e implements b {
    private Map a;
    private long b;
    private final File c;
    private final int d;
    private boolean e;

    public e(File file) {
        this(file, 5242880);
    }

    public e(File file, int i) {
        this.a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0;
        this.c = file;
        this.d = i;
    }

    private void a(int i) {
        if (!this.e && this.b + ((long) i) >= ((long) this.d)) {
            int i2;
            ab.a("Pruning old cache entries.", new Object[0]);
            long j = this.b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                g gVar = (g) ((Entry) it.next()).getValue();
                if (c(gVar.b).delete()) {
                    this.b -= gVar.a;
                } else {
                    ab.b("Could not delete cache entry for key=%s, filename=%s", gVar.b, d(gVar.b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.b + ((long) i))) < ((float) this.d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            ab.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void a(String str, g gVar) {
        if (!this.e) {
            if (this.a.containsKey(str)) {
                g gVar2 = (g) this.a.get(str);
                this.b = (gVar.a - gVar2.a) + this.b;
            } else {
                this.b += gVar.a;
            }
            this.a.put(str, gVar);
        }
    }

    private static byte[] a(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        g gVar = (g) this.a.get(str);
        if (gVar != null) {
            this.b -= gVar.a;
            this.a.remove(str);
        }
    }

    public synchronized c a(String str) {
        c cVar;
        h hVar;
        IOException e;
        Throwable th;
        g gVar = (g) this.a.get(str);
        if (gVar == null) {
            cVar = null;
        } else {
            File c = c(str);
            try {
                hVar = new h(new FileInputStream(c));
                try {
                    g.a((InputStream) hVar);
                    cVar = gVar.a(a((InputStream) hVar, (int) (c.length() - ((long) hVar.a))));
                    if (hVar != null) {
                        try {
                            hVar.close();
                        } catch (IOException e2) {
                            cVar = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ab.b("%s: %s", c.getAbsolutePath(), e.toString());
                        b(str);
                        if (hVar != null) {
                            try {
                                hVar.close();
                            } catch (IOException e4) {
                                cVar = null;
                            }
                        }
                        cVar = null;
                        return cVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (hVar != null) {
                            try {
                                hVar.close();
                            } catch (IOException e5) {
                                cVar = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                hVar = null;
                ab.b("%s: %s", c.getAbsolutePath(), e.toString());
                b(str);
                if (hVar != null) {
                    hVar.close();
                }
                cVar = null;
                return cVar;
            } catch (Throwable th3) {
                th = th3;
                hVar = null;
                if (hVar != null) {
                    hVar.close();
                }
                throw th;
            }
        }
        return cVar;
    }

    public synchronized void a() {
        FileInputStream fileInputStream;
        Throwable th;
        if (this.c.exists()) {
            File[] listFiles = this.c.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    FileInputStream fileInputStream2 = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            g a = g.a((InputStream) fileInputStream);
                            a.a = file.length();
                            a(a.b, a);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (IOException e2) {
                            if (file != null) {
                                try {
                                    file.delete();
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    fileInputStream2 = fileInputStream;
                                    th = th3;
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } catch (IOException e4) {
                        fileInputStream = null;
                        if (file != null) {
                            file.delete();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
        } else if (!this.c.mkdirs()) {
            ab.c("Unable to create cache dir %s", this.c.getAbsolutePath());
        }
        return;
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
            }
        }
        throw th;
        throw th;
    }

    public synchronized void a(String str, c cVar) {
        a(cVar.a.length);
        File c = c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            g gVar = new g(str, cVar);
            gVar.a(fileOutputStream);
            fileOutputStream.write(cVar.a);
            fileOutputStream.close();
            a(str, gVar);
        } catch (IOException e) {
            if (!c.delete()) {
                ab.b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void b(String str) {
        boolean delete = c(str).delete();
        e(str);
        if (!delete) {
            ab.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.c, d(str));
    }
}
