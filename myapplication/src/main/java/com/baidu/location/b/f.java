package com.baidu.location.b;

import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f a = null;
    private static final double[][] b = new double[][]{new double[]{120.0618433387417d, 52.99310228080341d}, new double[]{114.4030602114635d, 47.79652316426919d}, new double[]{119.3643163114595d, 47.0727538006688d}, new double[]{111.7970645774334d, 45.24511711870672d}, new double[]{104.9683464256928d, 41.86250415619769d}, new double[]{97.59908065334047d, 43.22977087596662d}, new double[]{90.17261155579693d, 47.84045461669d}, new double[]{87.0887631003547d, 49.35214107249469d}, new double[]{83.03712288618132d, 47.19159646925913d}, new double[]{72.99264485060895d, 39.20573694893438d}, new double[]{78.45303593116243d, 31.72421462055291d}, new double[]{85.9177987174293d, 27.93063907621388d}, new double[]{92.09912961486889d, 27.71669293109786d}, new double[]{95.27333193620382d, 28.98784762533811d}, new double[]{98.44114544032976d, 27.28076394915907d}, new double[]{97.50681546607404d, 24.71427385929992d}, new double[]{97.52260341956044d, 23.71326829445317d}, new double[]{100.0708944887605d, 21.1767365339876d}, new double[]{101.9206763604854d, 21.13303015980818d}, new double[]{105.2746400703396d, 23.11902125989214d}, new double[]{107.2643282303716d, 21.45413888071461d}, new double[]{108.3761342632019d, 17.31459516935326d}, new double[]{113.0483020881062d, 16.81442875978696d}, new double[]{122.2284167146931d, 21.66374045582697d}, new double[]{123.9556508773411d, 35.66412873804383d}, new double[]{124.2746994608336d, 39.77355430531934d}, new double[]{130.842836734007d, 42.33514430285174d}, new double[]{132.9368688827846d, 44.59499883995769d}, new double[]{135.3461562047301d, 48.60080399436555d}, new double[]{131.7265723825281d, 48.00330291274656d}, new double[]{124.4850194031389d, 54.244770450984d}, new double[]{120.0618433387417d, 52.99310228080341d}};
    private LinkedList c = null;

    class a {
        double a;
        double b;
        final /* synthetic */ f c;

        a(f fVar, double d, double d2) {
            this.c = fVar;
            this.a = d;
            this.b = d2;
        }
    }

    class b {
        a a;
        a b;
        final /* synthetic */ f c;

        b(f fVar, a aVar, a aVar2) {
            this.c = fVar;
            this.a = aVar;
            this.b = aVar2;
        }

        double a(a aVar) {
            a aVar2 = new a(this.c, this.b.a - this.a.a, this.b.b - this.a.b);
            a aVar3 = new a(this.c, aVar.a - this.a.a, aVar.b - this.a.b);
            return (aVar2.a * aVar3.b) - (aVar2.b * aVar3.a);
        }

        boolean b(a aVar) {
            return this.c.a(a(aVar)) == 0 && aVar.a < Math.max(this.a.a, this.b.a) + 1.0E-8d && aVar.a > Math.min(this.a.a, this.b.a) - 1.0E-8d && aVar.b < Math.max(this.a.b, this.b.b) + 1.0E-8d && aVar.b > Math.min(this.a.b, this.b.b) - 1.0E-8d;
        }
    }

    private f() {
        int length = b.length;
        this.c = new LinkedList();
        for (int i = 0; i < length - 1; i++) {
            this.c.add(new b(this, new a(this, b[i][0] * 100000.0d, b[i][1] * 100000.0d), new a(this, b[i + 1][0] * 100000.0d, b[i + 1][1] * 100000.0d)));
        }
    }

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    int a(double d) {
        return d < (-4487126258331716666) ? -1 : d > 1.0E-8d ? 1 : 0;
    }

    public boolean a(double d, double d2) {
        try {
            a aVar = new a(this, 100000.0d * d, 100000.0d * d2);
            int i = 0;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.b(aVar)) {
                    return true;
                }
                int a = a(bVar.a(aVar));
                int a2 = a(bVar.a.b - aVar.b);
                int a3 = a(bVar.b.b - aVar.b);
                int i2 = (a <= 0 || a2 > 0 || a3 <= 0) ? i : i + 1;
                if (a < 0 && a3 <= 0 && a2 > 0) {
                    i2--;
                }
                i = i2;
            }
            return i != 0;
        } catch (Exception e) {
            return true;
        }
    }
}
