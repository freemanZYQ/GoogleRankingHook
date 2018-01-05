package com.qq.e.comm.managers.setting;

import com.qq.e.comm.constants.Constants.KEYS;

public final class b extends c {
    public b() {
        a(KEYS.SDKServerGetADReportSamplingRate, Integer.valueOf(1));
        a(KEYS.SDKServerExpReportSamplingRate, Integer.valueOf(1));
        a(KEYS.SDKServerClickReportSamplingRate, Integer.valueOf(100));
        a(KEYS.RequireWindowFocus, Integer.valueOf(1));
        a(KEYS.Banner_RF, Integer.valueOf(30000));
        a(KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(3000));
        a(KEYS.SPLASH_EXPOSURE_TIME, Integer.valueOf(5000));
        a(KEYS.SPLASH_NETWORK_PERMISION, Integer.valueOf(26));
        a(KEYS.SPLASH_MAX_REQUEST_NUM, Integer.valueOf(100));
    }
}
