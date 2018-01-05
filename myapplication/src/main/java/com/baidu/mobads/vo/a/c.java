package com.baidu.mobads.vo.a;

import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class c extends a {
    public long A = 0;
    public int B = 0;
    public int C = 0;
    public int D = 0;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public int H = 0;
    public String n;
    public int o;
    public int p;
    public int q;
    public AtomicInteger r = new AtomicInteger(0);
    public int s;
    public int t;
    public long u;
    public int v;
    public int w;
    public int x;
    public int y;
    public long z = 0;

    public c(XAdCommandExtraInfo xAdCommandExtraInfo) {
        super(xAdCommandExtraInfo);
    }

    protected HashMap b() {
        HashMap hashMap = new HashMap();
        if (this.n.length() > IXAdIOUtils.BUFFER_SIZE) {
            hashMap.put("obj", this.n.substring(0, 1023));
        } else {
            hashMap.put("obj", this.n);
        }
        hashMap.put("order", "" + this.o);
        hashMap.put("height", "" + this.p);
        hashMap.put("progress", "" + this.q);
        hashMap.put("moves", "" + this.r.get());
        hashMap.put("clicks", "" + this.s);
        hashMap.put("urlclicks", "" + this.s);
        hashMap.put("lploadtime", "" + this.t);
        hashMap.put("duration", "" + this.u);
        hashMap.put("_lpWebStartLoad", "" + this.z);
        hashMap.put("_lpWebFinishLoad", "" + this.A);
        hashMap.put("e75", "" + this.v);
        hashMap.put("e75_3", "" + this.w);
        hashMap.put("from", "" + this.x);
        hashMap.put("maxTabs", "" + this.y);
        hashMap.put("b_cancel", "" + this.F);
        hashMap.put("b_refresh", "" + this.D);
        hashMap.put("b_copy", "" + this.E);
        hashMap.put("b_goback", "" + this.B);
        hashMap.put("b_threeP", "" + this.C);
        hashMap.put("b_home", "" + this.H);
        hashMap.put("b_osgoback", "" + this.G);
        return hashMap;
    }
}
