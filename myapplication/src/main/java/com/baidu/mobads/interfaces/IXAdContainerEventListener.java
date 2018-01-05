package com.baidu.mobads.interfaces;

import java.util.HashMap;

public interface IXAdContainerEventListener {
    void onAdClicked(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap);

    void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap);

    void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap);

    void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap);

    void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap hashMap);

    void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap hashMap);

    void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);

    void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap hashMap);
}
