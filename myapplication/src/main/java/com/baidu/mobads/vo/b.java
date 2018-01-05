package com.baidu.mobads.vo;

import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;

public class b implements IXAdProdInfo {
    private d a;
    private SlotType b;
    private boolean c = false;

    public b(d dVar, SlotType slotType) {
        this.a = dVar;
        this.b = slotType;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public String getAdPlacementId() {
        return this.a.getApid();
    }

    public String getAdRequestURL() {
        return this.a.b();
    }

    public int getApt() {
        return this.a.getApt();
    }

    public JSONObject getAttribute() {
        return new JSONObject();
    }

    public int getInstanceCount() {
        return 0;
    }

    public String getProdType() {
        return this.a.getProd();
    }

    public int getRequestAdHeight() {
        return this.a.getH();
    }

    public int getRequestAdWidth() {
        return this.a.getW();
    }

    public SlotType getType() {
        return this.b;
    }

    public boolean isAutoPlay() {
        return this.c;
    }

    public boolean isMsspTagAvailable() {
        return false;
    }
}
