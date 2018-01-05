package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.j.m;

public abstract class b {
    protected Context a;
    protected IXNonLinearAdSlot b;
    protected IXAdInstanceInfo c;
    protected IXAdResource d;
    protected IXAdLogger e = m.a().f();

    public b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.b = iXNonLinearAdSlot;
        this.a = iXNonLinearAdSlot.getApplicationContext();
        this.c = iXAdInstanceInfo;
        this.d = iXAdResource;
    }
}
