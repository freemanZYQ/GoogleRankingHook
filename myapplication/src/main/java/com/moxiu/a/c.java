package com.moxiu.a;

import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.moxiu.b.a.a;
import java.util.ArrayList;
import java.util.List;

final class c implements BaiduNativeNetworkListener {
    final /* synthetic */ a a;
    final /* synthetic */ com.moxiu.b.b.a b;

    c(a aVar, com.moxiu.b.b.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        if (this.b != null) {
            this.b.a(0, nativeErrorCode.toString());
        }
    }

    public void onNativeLoad(List list) {
        if (list != null && list.size() > 0) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new a((NativeResponse) list.get(i), this.a));
            }
            if (this.b != null) {
                this.b.a(arrayList);
            }
        } else if (this.b != null) {
            this.b.a(0, "baidu no ad");
        }
    }
}
