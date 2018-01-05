package com.tencent.open.a;

import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class k implements Iterable {
    private ConcurrentLinkedQueue a;
    private AtomicInteger b;

    public k() {
        this.a = null;
        this.b = null;
        this.a = new ConcurrentLinkedQueue();
        this.b = new AtomicInteger(0);
    }

    public int a() {
        return this.b.get();
    }

    public int a(String str) {
        int length = str.length();
        this.a.add(str);
        return this.b.addAndGet(length);
    }

    public void a(Writer writer, char[] cArr) {
        if (writer != null && cArr != null && cArr.length != 0) {
            int length = cArr.length;
            Iterator it = iterator();
            int i = 0;
            int i2 = length;
            while (it.hasNext()) {
                String str = (String) it.next();
                int length2 = str.length();
                int i3 = 0;
                while (length2 > 0) {
                    int i4 = i2 > length2 ? length2 : i2;
                    str.getChars(i3, i3 + i4, cArr, i);
                    i2 -= i4;
                    i += i4;
                    length2 -= i4;
                    i4 += i3;
                    if (i2 == 0) {
                        writer.write(cArr, 0, length);
                        i = 0;
                        i2 = length;
                        i3 = i4;
                    } else {
                        i3 = i4;
                    }
                }
            }
            if (i > 0) {
                writer.write(cArr, 0, i);
            }
            writer.flush();
        }
    }

    public void b() {
        this.a.clear();
        this.b.set(0);
    }

    public Iterator iterator() {
        return this.a.iterator();
    }
}
