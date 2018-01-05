package com.vlocker.weather.c.c;

import com.inveno.se.model.d;
import com.inveno.se.model.multimedia.Imgs;
import java.util.ArrayList;
import java.util.List;

public class c extends b {
    private d a;
    private String b = ("热度" + j() + "℃");

    public c(d dVar, boolean z) {
        this.a = dVar;
        int i = (!z || dVar.f() == null || dVar.f().size() < 3) ? 1 : 2;
        a(i);
    }

    private int j() {
        return (int) (3000.0d + (Math.random() * 27000.0d));
    }

    public d a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a.b();
    }

    public String d() {
        return this.a.d();
    }

    public List e() {
        List arrayList = new ArrayList();
        if (this.a.f() != null && this.a.f().size() > 0) {
            for (int i = 0; i < this.a.f().size(); i++) {
                Imgs imgs = (Imgs) this.a.f().get(i);
                if ("gif".equalsIgnoreCase(imgs.a())) {
                    arrayList.add(imgs.c());
                } else {
                    arrayList.add(imgs.b());
                }
            }
        }
        return arrayList;
    }

    public String f() {
        return this.a.c();
    }
}
