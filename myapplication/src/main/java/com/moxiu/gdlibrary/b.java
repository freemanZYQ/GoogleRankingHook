package com.moxiu.gdlibrary;

import com.moxiu.b.b.a;
import com.qq.e.ads.nativ.NativeAD.NativeAdListener;
import com.qq.e.ads.nativ.NativeADDataRef;
import java.util.ArrayList;
import java.util.List;

final class b implements NativeAdListener {
    final /* synthetic */ a a;
    final /* synthetic */ com.moxiu.b.a.a b;

    b(a aVar, com.moxiu.b.a.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public void onADLoaded(List list) {
        if (list != null && list.size() > 0) {
            List arrayList = new ArrayList();
            int i = 0;
            while (i < list.size()) {
                if ("url".equals(this.b.D)) {
                    if (((NativeADDataRef) list.get(i)).isAPP()) {
                    }
                    arrayList.add(new e((NativeADDataRef) list.get(i), this.b));
                } else {
                    if ("app".equals(this.b.D) && !((NativeADDataRef) list.get(i)).isAPP()) {
                    }
                    arrayList.add(new e((NativeADDataRef) list.get(i), this.b));
                }
                i++;
            }
            if (this.a != null) {
                this.a.a(arrayList);
            }
        }
    }

    public void onADStatusChanged(NativeADDataRef nativeADDataRef) {
        if (this.a != null) {
            this.a.a(new e(nativeADDataRef, this.b));
        }
    }

    public void onNoAD(int i) {
        if (this.a != null) {
            this.a.a(i, "gdt load fail");
        }
    }
}
