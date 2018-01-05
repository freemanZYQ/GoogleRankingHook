package com.baidu.mobads.interfaces.feeds;

import java.util.HashMap;
import java.util.Map;

public interface IXAdFeedsRequestParameters {
    int getAPPConfirmPolicy();

    String getAdPlacementId();

    int getAdsType();

    Map getExtras();

    String getKeywords();

    @Deprecated
    boolean isConfirmDownloading();

    HashMap toHashMap();
}
