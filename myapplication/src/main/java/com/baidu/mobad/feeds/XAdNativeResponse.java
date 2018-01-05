package com.baidu.mobad.feeds;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.j.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

class XAdNativeResponse implements NativeResponse {
    private IXAdInstanceInfo a;
    private BaiduNative b;
    private boolean c = false;
    private IXAdFeedsRequestParameters d;
    private IXAdContainer e;

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.a = iXAdInstanceInfo;
        this.b = baiduNative;
        this.e = iXAdContainer;
        if (this.a.getActionType() == m.a().p().getActTypeDownload()) {
            this.c = true;
        }
        this.d = iXAdFeedsRequestParameters;
    }

    private void a(Context context) {
        if (m.a().n().is3GConnected(context).booleanValue()) {
            this.a.setActionOnlyWifi(false);
        } else {
            this.a.setActionOnlyWifi(true);
        }
    }

    private void a(final View view, final int i) {
        final Context context = view.getContext();
        Builder builder = new Builder(context);
        builder.setMessage("确认下载\"" + getTitle() + "\"?");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new OnClickListener(this) {
            final /* synthetic */ XAdNativeResponse d;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.d.a(context);
                this.d.b.handleClick(view, this.d.a, i, this.d.d);
            }
        });
        builder.setNegativeButton("取消", new OnClickListener(this) {
            final /* synthetic */ XAdNativeResponse a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public String getAppPackage() {
        return this.a.getAppPackageName();
    }

    public long getAppSize() {
        return this.a.getAppSize();
    }

    public String getBrandName() {
        return this.a.getAppName();
    }

    public String getDesc() {
        return this.a.getDescription();
    }

    public int getDuration() {
        return this.a.getVideoDuration();
    }

    public Map getExtras() {
        return null;
    }

    public String getHtmlSnippet() {
        return this.a.getHtmlSnippet();
    }

    public String getIconUrl() {
        String iconUrl = this.a.getIconUrl();
        return (iconUrl == null || iconUrl.equals("")) ? this.a.getMainPictureUrl() : iconUrl;
    }

    public String getImageUrl() {
        return this.a.getMainPictureUrl();
    }

    public int getMainPicHeight() {
        return this.a.getMainMaterialHeight();
    }

    public int getMainPicWidth() {
        return this.a.getMainMaterialWidth();
    }

    public MaterialType getMaterialType() {
        return this.a.getCreativeType() == CreativeType.VIDEO ? MaterialType.VIDEO : this.a.getCreativeType() == CreativeType.HTML ? MaterialType.HTML : MaterialType.NORMAL;
    }

    public List getMultiPicUrls() {
        try {
            JSONArray optJSONArray = this.a.getOriginJsonObject().optJSONArray("morepics");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            List arrayList = new ArrayList();
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                    i++;
                } catch (Exception e) {
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    public String getTitle() {
        return this.a.getTitle();
    }

    public String getVideoUrl() {
        return this.a.getVideoUrl();
    }

    public WebView getWebView() {
        return (WebView) this.e.getAdView();
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    public void handleClick(View view, int i) {
        if (isDownloadApp()) {
            Context context = view.getContext();
            if (this.d.getAPPConfirmPolicy() == 3) {
                this.a.setActionOnlyWifi(false);
                this.b.handleClick(view, this.a, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 4) {
                a(context);
                this.b.handleClick(view, this.a, i, this.d);
                return;
            } else if (this.d.getAPPConfirmPolicy() == 2) {
                a(view, i);
                return;
            } else if (this.d.getAPPConfirmPolicy() != 1) {
                return;
            } else {
                if (m.a().n().is3GConnected(context).booleanValue()) {
                    a(view, i);
                    return;
                }
                a(context);
                this.b.handleClick(view, this.a, i, this.d);
                return;
            }
        }
        this.b.handleClick(view, this.a, i, this.d);
    }

    public boolean isAdAvailable(Context context) {
        return this.b.isAdAvailable(context, this.a, this.d);
    }

    public boolean isDownloadApp() {
        return this.c;
    }

    public void onClickAd(Context context) {
        this.b.handleOnClickAd(context, this.a, this.d);
    }

    public void onClose(Context context, int i) {
        this.b.handleOnClose(context, i, this.a, this.d);
    }

    public void onComplete(Context context) {
        this.b.handleOnComplete(context, this.a, this.d);
    }

    public void onError(Context context, int i, int i2) {
        this.b.handleOnError(context, i, i2, this.a);
    }

    public void onFullScreen(Context context, int i) {
        this.b.handleOnFullScreen(context, i, this.a, this.d);
    }

    public void onStart(Context context) {
        this.b.handleOnStart(context, this.a, this.d);
    }

    public void recordImpression(View view) {
        this.b.recordImpression(view, this.a, this.d);
    }

    public void setIsDownloadApp(boolean z) {
        this.c = z;
    }
}
