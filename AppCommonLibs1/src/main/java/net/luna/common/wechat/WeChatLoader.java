package net.luna.common.wechat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import net.luna.common.debug.LunaLog;
import net.luna.common.util.ImageUtils;

import java.io.ByteArrayOutputStream;

public class WeChatLoader implements Runnable {

    private Context mContext;
    private String mAppid = "";
    private IWXAPI api;
    private boolean isSupportTimeline = false;
    private ShareModel mModel;

    public WeChatLoader(Context context, String appId) {
        mContext = context;
        mAppid = appId;
        try {
            api = WXAPIFactory.createWXAPI(mContext, mAppid, false);

            int version = api.getWXAppSupportAPI();

            api.registerApp(mAppid);
            // 判断开发者的版本是否支持微信朋友圈分享。
            if (version > 0x21020001) {
                isSupportTimeline = true;
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public void handIntent(IWXAPIEventHandler context, Intent intent) {
        api.handleIntent(intent, context);
    }

    public boolean isSupportTimeline() {
        return isSupportTimeline;
    }

    public void setShareModel(ShareModel model) {
        mModel = model;
    }

    private void shareIWXAP() {
        if (mModel == null) {
            return;
        }
        if (!isSupportTimeline) {
            LunaLog.d("hasn't wechat sdk,can not share");
            return;
        }
        try {
            // 传入URL

            WXWebpageObject webpage = new WXWebpageObject();
            webpage.webpageUrl = mModel.url;
            WXMediaMessage msg = new WXMediaMessage(webpage);
            msg.title = mModel.title;
            msg.description = mModel.description;
            try {
                Bitmap iconImage = ImageUtils.drawableToBitmap(mContext.getResources().getDrawable(mModel.iconId));
                byte[] iconByte = wxIconBmpToByteArray(iconImage, false);
                if (iconByte != null) {
                    msg.thumbData = iconByte;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = buildTransaction("webpage");
            req.message = msg;
            req.scene = mModel.isTimeLine ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
            api.sendReq(req);

            if (mContext instanceof Activity) {
                ((Activity) mContext).finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    // 定制微信图标。
    public byte[] wxIconBmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        if (bmp == null) {
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int quality = 50;
        byte[] result = null;
        long length = 100000;
        while (length > 32768) {
            if (quality < 0) {
                return null;
            }
            bmp.compress(CompressFormat.JPEG, quality, output);
            quality -= 10;
            result = output.toByteArray();
            length = result.length;
        }
        if (needRecycle) {
            if (!bmp.isRecycled())
                bmp.recycle();
        }
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void run() {
        shareIWXAP();
    }
}
