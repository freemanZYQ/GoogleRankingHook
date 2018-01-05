package net.luna.common.download.interfaces;


import net.luna.common.download.model.AppModel;
import net.luna.common.download.model.FileDownloadTask;

public interface ApkDownloadListener {

    public void onApkDownloadBeforeStart_FileLock(FileDownloadTask task);

    public void onApkDownloadStart(FileDownloadTask task);

    public void onApkDownloadSuccess(FileDownloadTask task);

    public void onApkDownloadSuccess(AppModel model);

    public void onApkDownloadFailed(FileDownloadTask task);

    public void onApkDownloadStop(FileDownloadTask task);


    /**
     * @param task
     * @param contentLength
     * @param completeLength 已经完成的长度
     * @param percent        当前完成百分比
     */
    public void onApkDownloadProgressUpdate(FileDownloadTask task, long contentLength, long completeLength, int percent);

    public void onApkInstallSuccess(AppModel model);

}
