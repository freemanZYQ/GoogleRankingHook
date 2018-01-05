package com.xinmei365.fontsdk.callback;

import java.util.List;

public interface FontScanCallBack {
    void onFailure(String str);

    void onSuccess(List list);
}
