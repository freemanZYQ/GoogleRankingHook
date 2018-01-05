package com.inveno.se.d.a;

import com.inveno.se.d.ab;
import com.inveno.se.d.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class g {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public Map g;

    private g() {
    }

    public g(String str, c cVar) {
        this.b = str;
        this.a = (long) cVar.a.length;
        this.c = cVar.b;
        this.d = cVar.c;
        this.e = cVar.d;
        this.f = cVar.e;
        this.g = cVar.f;
    }

    public static g a(InputStream inputStream) {
        g gVar = new g();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        if (objectInputStream.readByte() != (byte) 2) {
            throw new IOException();
        }
        gVar.b = objectInputStream.readUTF();
        gVar.c = objectInputStream.readUTF();
        if (gVar.c.equals("")) {
            gVar.c = null;
        }
        gVar.d = objectInputStream.readLong();
        gVar.e = objectInputStream.readLong();
        gVar.f = objectInputStream.readLong();
        gVar.g = a(objectInputStream);
        return gVar;
    }

    private static Map a(ObjectInputStream objectInputStream) {
        int readInt = objectInputStream.readInt();
        Map emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            emptyMap.put(objectInputStream.readUTF().intern(), objectInputStream.readUTF().intern());
        }
        return emptyMap;
    }

    private static void a(Map map, ObjectOutputStream objectOutputStream) {
        if (map != null) {
            objectOutputStream.writeInt(map.size());
            for (Entry entry : map.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeUTF((String) entry.getValue());
            }
            return;
        }
        objectOutputStream.writeInt(0);
    }

    public c a(byte[] bArr) {
        c cVar = new c();
        cVar.a = bArr;
        cVar.b = this.c;
        cVar.c = this.d;
        cVar.d = this.e;
        cVar.e = this.f;
        cVar.f = this.g;
        return cVar;
    }

    public boolean a(OutputStream outputStream) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeByte(2);
            objectOutputStream.writeUTF(this.b);
            objectOutputStream.writeUTF(this.c == null ? "" : this.c);
            objectOutputStream.writeLong(this.d);
            objectOutputStream.writeLong(this.e);
            objectOutputStream.writeLong(this.f);
            a(this.g, objectOutputStream);
            objectOutputStream.flush();
            return true;
        } catch (IOException e) {
            ab.b("%s", e.toString());
            return false;
        }
    }
}
