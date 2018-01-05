package com.vlocker.ui.cover;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import com.vlocker.ui.graphic.LShapeHolder;
import java.util.ArrayList;

public class q {
    private ArrayList a = new ArrayList();
    private ArrayList b = new ArrayList();
    private int c = 0;

    public Path a() {
        return ((s) this.a.get(this.a.size() - 1)).a();
    }

    public s a(int i) {
        return (s) this.a.get(i);
    }

    public void a(ArrayList arrayList, int i, int i2) {
        if (i < 0 || i > 2 || i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("row must range from 0 to 2, and column also must range from 0 to 2");
        }
        LShapeHolder lShapeHolder = (LShapeHolder) arrayList.get((i * 3) + i2);
        float width = lShapeHolder.getmOriginalX() + (lShapeHolder.getWidth() / 2.0f);
        float height = lShapeHolder.getmOriginalY() + (lShapeHolder.getHeight() / 2.0f);
        s sVar = new s(new Path());
        sVar.a(lShapeHolder.getColor());
        sVar.a().moveTo(width, height);
        sVar.a(width);
        sVar.b(height);
        if (this.c > 0) {
            LShapeHolder lShapeHolder2 = (LShapeHolder) this.b.get(this.c - 1);
            s sVar2 = (s) this.a.get(this.c - 1);
            float width2 = lShapeHolder2.getmOriginalX() + (lShapeHolder.getWidth() / 2.0f);
            float height2 = (lShapeHolder.getHeight() / 2.0f) + lShapeHolder2.getmOriginalY();
            Path a = sVar2.a();
            a.moveTo(width2, height2);
            sVar2.a(width2);
            sVar2.b(height2);
            a.lineTo(width, height);
            sVar2.c(width);
            sVar2.d(height);
            sVar2.a(new LinearGradient(width2, height2, width, height, sVar2.g(), sVar.g(), TileMode.CLAMP));
        }
        this.c++;
        this.a.add(sVar);
        this.b.add(lShapeHolder);
    }

    public int b() {
        return this.c;
    }

    public void c() {
        this.c = 0;
        this.a.clear();
        this.b.clear();
    }
}
