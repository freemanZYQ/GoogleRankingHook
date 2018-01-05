package com.baidu.mobads.production;

import com.baidu.mobads.h.g;

public class BaiduXAdSDKContext {
    protected static Boolean isRemoteLoadSuccess = Boolean.valueOf(false);
    protected static g mApkLoader;

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = Boolean.valueOf(false);
    }
}
