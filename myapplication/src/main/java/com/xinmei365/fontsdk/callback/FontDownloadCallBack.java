package com.xinmei365.fontsdk.callback;

public interface FontDownloadCallBack {
    void canceled(String str);

    void onFailed(String str, int i, String str2);

    void onStart(String str);

    void onSuccessed(String str, String str2);

    void onUpgrade(String str, long j, long j2);

    void paused(String str);

    void waited(String str);
}
