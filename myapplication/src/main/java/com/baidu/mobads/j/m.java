package com.baidu.mobads.j;

import android.content.Context;
import com.baidu.mobads.am;
import com.baidu.mobads.e.a;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;

public class m {
    private static final m o = new m();
    private g a;
    private l b = new l();
    private IBase64 c = new a();
    private IXAdLogger d = j.a();
    private IXAdViewUtils e = new s();
    private IXAdBitmapUtils f = new c();
    private IXAdURIUitls g = new r();
    private IXAdIOUtils h = new i();
    private IXAdPackageUtils i = new k();
    private IXAdActivityUtils j = new b();
    private IXAdSystemUtils k = new n();
    private d l = new d();
    private IXAdConstants m = new am();
    private IXAdErrorCode n = new a(this.d);
    private Context p;
    private IXAdContainerFactory q;

    private m() {
    }

    public static m a() {
        return o;
    }

    public void a(Context context) {
        if (this.p == null) {
            this.p = context;
        }
        this.a = new g(this.p);
    }

    public void a(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.q = iXAdContainerFactory;
        }
    }

    public g b() {
        return this.a;
    }

    public IOAdDownloaderManager b(Context context) {
        return d.a(context);
    }

    public IXAdContainerFactory c() {
        return this.q;
    }

    public Context d() {
        return this.p;
    }

    public IBase64 e() {
        return this.c;
    }

    public IXAdLogger f() {
        return this.d;
    }

    public l g() {
        return this.b;
    }

    public IXAdBitmapUtils h() {
        return this.f;
    }

    public IXAdURIUitls i() {
        return this.g;
    }

    public IXAdViewUtils j() {
        return this.e;
    }

    public IXAdIOUtils k() {
        return this.h;
    }

    public IXAdPackageUtils l() {
        return this.i;
    }

    public d m() {
        return this.l;
    }

    public IXAdSystemUtils n() {
        return this.k;
    }

    public IXAdActivityUtils o() {
        return this.j;
    }

    public IXAdConstants p() {
        return this.m;
    }

    public IXAdErrorCode q() {
        return this.n;
    }
}
