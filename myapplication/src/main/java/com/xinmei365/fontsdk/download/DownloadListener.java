package com.xinmei365.fontsdk.download;

public interface DownloadListener {
    void canceled(DownloadInfo downloadInfo);

    void failed(DownloadInfo downloadInfo, int i);

    void paused(DownloadInfo downloadInfo);

    void prepared(DownloadInfo downloadInfo);

    void processing(DownloadInfo downloadInfo);

    void successed(DownloadInfo downloadInfo);

    void waited(DownloadInfo downloadInfo);
}
