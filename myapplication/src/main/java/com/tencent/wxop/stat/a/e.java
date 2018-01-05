package com.tencent.wxop.stat.a;

import com.baidu.location.LocationClientOption;
import com.xinmei365.fontsdk.bean.FailureInfo;

public enum e {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(LocationClientOption.MIN_SCAN_SPAN),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(FailureInfo.ERROR_DOWNLOAD_FAILURE),
    NETWORK_DETECTOR(1005);
    
    private int j;

    private e(int i) {
        this.j = i;
    }

    public final int a() {
        return this.j;
    }
}
