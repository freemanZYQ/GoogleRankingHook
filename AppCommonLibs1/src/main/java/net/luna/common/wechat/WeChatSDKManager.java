package net.luna.common.wechat;

import android.content.Context;
import android.content.Intent;

import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import net.luna.common.util.ThreadUtils;


public class WeChatSDKManager {

    private WeChatLoader loader;
    private static WeChatSDKManager mInstanct;
    private Context mContext;

    public static WeChatSDKManager getInstanct(Context context) {
        if (mInstanct == null) {
            mInstanct = new WeChatSDKManager(context);
        }
        return mInstanct;
    }

    private WeChatSDKManager(Context context) {
        mContext = context;
    }

    public void init(String appid) {
        loader = new WeChatLoader(mContext, appid);
    }

    public boolean isSupportTimeline() {
        return loader.isSupportTimeline();
    }

    public void shareToTimeLine(ShareModel model) {
        loader.setShareModel(model);
        ThreadUtils.execute(loader);
    }

    public void handIntent(IWXAPIEventHandler context, Intent intent) {
        loader.handIntent(context, intent);
    }

}
