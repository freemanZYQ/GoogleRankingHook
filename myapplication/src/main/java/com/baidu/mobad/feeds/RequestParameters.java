package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class RequestParameters implements IXAdFeedsRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    private final String a;
    private int b;
    private boolean c;
    private Map d;
    private int e;
    private int f;
    private int g;
    protected String mPlacementId;

    public class Builder {
        private String a;
        private Map b = new HashMap();
        private int c = 3;
        private boolean d = false;
        private int e = 640;
        private int f = 480;
        private int g = 1;

        public final Builder addExtra(String str, String str2) {
            this.b.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters();
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i) {
            this.g = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f = i;
            return this;
        }

        public final Builder setWidth(int i) {
            this.e = i;
            return this;
        }
    }

    private RequestParameters(Builder builder) {
        this.e = 0;
        this.f = 0;
        this.a = builder.a;
        this.b = builder.c;
        this.e = builder.e;
        this.f = builder.f;
        this.c = builder.d;
        this.g = builder.g;
        setExtras(builder.b);
    }

    public int getAPPConfirmPolicy() {
        return this.g;
    }

    public String getAdPlacementId() {
        return this.mPlacementId;
    }

    public int getAdsType() {
        return this.b;
    }

    public Map getExtras() {
        return this.d;
    }

    public int getHeight() {
        return this.f;
    }

    public final String getKeywords() {
        return this.a;
    }

    public int getWidth() {
        return this.e;
    }

    public boolean isConfirmDownloading() {
        return this.c;
    }

    public void setAdsType(int i) {
        this.b = i;
    }

    public void setExtras(Map map) {
        this.d = map;
    }

    public HashMap toHashMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("mKeywords", this.a);
        hashMap.put("adsType", Integer.valueOf(this.b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.c));
        HashMap hashMap2 = new HashMap();
        if (this.d != null) {
            for (Entry entry : this.d.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }
}
