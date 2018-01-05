package com.vlocker.ui.widget.c;

import android.content.Context;
import android.util.DisplayMetrics;
import com.qq.e.comm.constants.ErrorCode.AdError;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ap;
import com.vlocker.m.l;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.k;
import com.vlocker.ui.widget.a.m;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.a.o;

public class b {
    private static int[][] a = new int[][]{new int[]{290, 710}, new int[]{106, 158}, new int[]{290, 158}, new int[]{474, 158}, new int[]{106, 342}, new int[]{290, 342}, new int[]{474, 342}, new int[]{106, 526}, new int[]{290, 526}, new int[]{474, 526}};
    private static int[][] b = new int[][]{new int[]{InitError.INIT_AD_ERROR, 680}, new int[]{136, 158}, new int[]{InitError.INIT_AD_ERROR, 158}, new int[]{464, 158}, new int[]{136, 332}, new int[]{InitError.INIT_AD_ERROR, 332}, new int[]{464, 332}, new int[]{136, AdError.RETRY_LOAD_SUCCESS}, new int[]{InitError.INIT_AD_ERROR, AdError.RETRY_LOAD_SUCCESS}, new int[]{464, AdError.RETRY_LOAD_SUCCESS}};

    private static void a(Context context, j jVar) {
        jVar.h("106");
        jVar.i("44");
        jVar.j("508");
        jVar.k("74");
        jVar.a("2130837572");
        jVar.b("2130837665");
        jVar.c("0");
        if (ap.a() != null && ap.a().w != null) {
            o oVar = ap.a().w;
            if (oVar.b != null) {
                jVar.b(oVar.b);
            }
            if (oVar.a != null) {
                jVar.a(oVar.a);
            }
        }
    }

    private static void a(Context context, k kVar) {
        kVar.h("536");
        kVar.i("924");
        kVar.j("160");
        kVar.k("80");
        kVar.z(context.getResources().getString(R.string.cancel));
        kVar.D("#ffffff");
        kVar.w("" + ((int) context.getResources().getDimension(R.dimen.lk_item_del_txt_size)));
        if (ap.a() != null && ap.a().w != null) {
            o oVar = ap.a().w;
            if (oVar.t != -1) {
                kVar.E = oVar.t;
            }
        }
    }

    private static void a(Context context, m mVar, int i) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context.getResources().getDisplayMetrics().heightPixels > 1920) {
            mVar.j("120");
            mVar.k("120");
            mVar.h("" + b[i][0]);
            mVar.i("" + b[i][1]);
        } else {
            mVar.j("140");
            mVar.k("140");
            mVar.h("" + a[i][0]);
            mVar.i("" + a[i][1]);
        }
        mVar.a("2130837612");
        mVar.b("2130837614");
        mVar.e("" + i);
        mVar.r("" + i);
        mVar.I("true");
        mVar.D("#ffffff");
        mVar.w("50");
        mVar.A("fonts/timeB.ttf");
        if (ap.a() != null && ap.a().w != null) {
            o oVar = ap.a().w;
            if (oVar.d != null) {
                mVar.b(oVar.d);
            }
            if (oVar.c != null) {
                mVar.a(oVar.c);
            }
            if (oVar.e != null) {
                mVar.c(oVar.e);
            }
            if (oVar.r != null) {
                mVar.d(oVar.r);
            }
            if (oVar.s != null) {
                mVar.e(oVar.s);
            }
            if (!oVar.J) {
                mVar.J = false;
            }
            if (oVar.B != null) {
                mVar.B = oVar.B;
            }
            if (oVar.E != -1) {
                mVar.E = oVar.E;
            }
            if (oVar.w != -1) {
                mVar.r = oVar.w;
            }
            if (oVar.x != 24) {
                mVar.x = oVar.x;
            }
            if (oVar.L != null) {
                mVar.L = oVar.L;
            }
        }
    }

    private static void a(Context context, n nVar) {
        nVar.h("0");
        nVar.i("0");
        nVar.j("720");
        nVar.k("48");
        nVar.z(context.getResources().getString(R.string.input_password_txt_number));
        nVar.D("#ffffff");
        nVar.w("" + l.b(16.0f));
        if (ap.a() != null && ap.a().w != null) {
            o oVar = ap.a().w;
            if (oVar.t != -1) {
                nVar.E = oVar.t;
            }
        }
    }

    private static void a(Context context, o oVar) {
        oVar.h("0");
        oVar.i("252");
        oVar.j("720");
        oVar.k("1028");
        oVar.s("#ffffff");
        oVar.t("1");
        if (ap.a() != null && ap.a().w != null) {
            o oVar2 = ap.a().w;
            if (oVar2.t != -1) {
                oVar.t = oVar2.t;
            }
            if (oVar2.u != 1) {
                oVar.u = oVar2.u;
            }
        }
    }

    public static void a(Context context, d dVar) {
        for (int i = 0; i < 10; i++) {
            m mVar = new m();
            a(context, mVar, i);
            dVar.x.add(mVar);
        }
        dVar.w = new o();
        a(context, dVar.w);
        dVar.z = new j();
        a(context, dVar.z);
        dVar.A = new n();
        a(context, dVar.A);
        dVar.B = new k();
        a(context, dVar.B);
    }
}
