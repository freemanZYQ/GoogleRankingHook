package com.vlocker.weather.e;

import android.content.Context;
import android.text.TextUtils;
import com.moxiu.b.a.a;
import java.util.ArrayList;
import java.util.List;

public class f {
    Context a;
    List b = new ArrayList();
    List c = new ArrayList();
    String d;
    public int e;
    public int f;
    public int g;
    public int h;
    String i;
    i j;

    public f(Context context, String str, int i) {
        this.i = str;
        this.a = context;
        this.h = i;
    }

    private void c() {
        if (this.b != null && this.b.size() >= 1) {
            this.c.clear();
            if (this.f >= 1) {
                boolean z = false;
                for (a aVar : this.b) {
                    boolean z2;
                    Object obj;
                    com.vlocker.weather.c.c.a aVar2;
                    com.vlocker.weather.c.c.a aVar3;
                    if (!"xz".equals(aVar.P)) {
                        aVar2 = new com.vlocker.weather.c.c.a(aVar, z);
                        z2 = !z;
                        aVar3 = aVar2;
                    } else if ("5804550b25a6805c7e8b4568".equals(aVar.B) || "58008ec80c04b43f2f8b52cf".equals(aVar.B)) {
                        aVar2 = new com.vlocker.weather.c.c.a(aVar, true);
                        z2 = z;
                        obj = aVar2;
                    } else {
                        aVar2 = new com.vlocker.weather.c.c.a(aVar, false);
                        z2 = z;
                        aVar3 = aVar2;
                    }
                    this.c.add(obj);
                    z = z2;
                }
            } else if (this.c.size() < 1) {
                this.c.add(new com.vlocker.weather.c.c.a((a) this.b.get(0), true));
            }
        }
    }

    private a d() {
        return new h(this);
    }

    public synchronized ArrayList a(ArrayList arrayList) {
        Exception e;
        ArrayList arrayList2 = new ArrayList();
        try {
            if (!(this.b == null || this.b.size() < 1 || arrayList == null)) {
                if (arrayList.size() > 0) {
                    int i = 0;
                    int i2 = 0;
                    while (i < arrayList.size()) {
                        int i3;
                        try {
                            if (this.c != null && this.c.size() > 0) {
                                if (this.f <= 0 || i2 > this.c.size() - 1) {
                                    if (i2 == 0) {
                                        arrayList2.add(this.c.get(0));
                                        i3 = i2 + 1;
                                        arrayList2.add(arrayList.get(i));
                                        i++;
                                        i2 = i3;
                                    }
                                } else if (i == this.e || ((this.e != this.f && i > this.e && i % this.f == this.e % this.f) || (this.e == this.f && i != 0 && i != this.e && i % this.f == this.e % this.f))) {
                                    if (!"empty".equals(((a) this.b.get(i2)).g())) {
                                        arrayList2.add(this.c.get(i2));
                                    }
                                    i3 = i2 + 1;
                                    arrayList2.add(arrayList.get(i));
                                    i++;
                                    i2 = i3;
                                }
                            }
                            i3 = i2;
                            try {
                                arrayList2.add(arrayList.get(i));
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Exception e3) {
                            Exception exception = e3;
                            i3 = i2;
                            e = exception;
                            e.printStackTrace();
                            i++;
                            i2 = i3;
                        }
                        i++;
                        i2 = i3;
                    }
                    if (arrayList2 != null) {
                        if (arrayList2.size() > 0) {
                            arrayList = arrayList2;
                        }
                    }
                }
            }
        } catch (Exception e32) {
            e32.printStackTrace();
        }
        return arrayList;
    }

    public void a() {
        if (this.b != null && this.b.size() > 0) {
            this.b.clear();
        }
    }

    public void a(int i) {
        if (this.b.size() <= 0 || (i + 12) / this.b.size() > 6) {
            new com.b.b.a(this.a).a(this.i, this.h < 1 ? 10 : this.h, new g(this)).a();
        } else {
            this.j.a();
        }
    }

    public void a(i iVar) {
        this.j = iVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(this.d)) {
            this.d = str;
            if (TextUtils.isEmpty(str)) {
                this.e = 3;
                this.f = 7;
                this.g = -1;
            } else {
                try {
                    String[] split = str.split(":");
                    this.e = Integer.parseInt(split[0]);
                    this.f = Integer.parseInt(split[1]);
                    this.g = Integer.parseInt(split[2]);
                } catch (Exception e) {
                    this.e = 3;
                    this.f = 7;
                    this.g = -1;
                }
            }
            if (this.b != null && this.b.size() > 0) {
                c();
            }
        }
    }

    public void b() {
        if (this.b != null && this.b.size() > 2) {
            this.b.subList(0, this.b.size() - 2).clear();
            c();
        }
    }
}
