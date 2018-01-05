package com.xinmei365.fontsdk.download;

public class DownloadInfo {
    private volatile int complete;
    private Object downloadObj;
    private volatile int fileSize;
    private volatile int lastComplete;
    private final String savePath;
    private volatile int status;
    private final String tempPath = (this.savePath + ".tmp");
    private int type;
    private final String urlStr;

    DownloadInfo(int i, int i2, String str, String str2, int i3) {
        this.fileSize = i;
        this.complete = i2;
        this.urlStr = str;
        this.savePath = str2;
        this.status = i3;
    }

    public int getComplete() {
        return this.complete;
    }

    public Object getDownloadObj() {
        return this.downloadObj;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    int getLastComplete() {
        return this.lastComplete;
    }

    public int getPercent() {
        return (int) ((((float) getComplete()) / ((float) getFileSize())) * 100.0f);
    }

    public String getSavePath() {
        return this.savePath;
    }

    public int getStatus() {
        return this.status;
    }

    String getTempPath() {
        return this.tempPath;
    }

    public int getType() {
        return this.type;
    }

    public String getUrlStr() {
        return this.urlStr;
    }

    void setComplete(int i) {
        this.complete = i;
    }

    public void setDownloadObj(Object obj) {
        this.downloadObj = obj;
    }

    void setFileSize(int i) {
        this.fileSize = i;
    }

    void setLastComplete(int i) {
        this.lastComplete = i;
    }

    void setStatus(int i) {
        this.status = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "LoadInfo [fileSize=" + this.fileSize + ", complete=" + this.complete + ", urlStr=" + this.urlStr + ", savePath=" + this.savePath + ", status=" + this.status + ", tempPath=" + this.tempPath + "]";
    }
}
