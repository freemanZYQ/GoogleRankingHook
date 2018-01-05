package net.luna.common.download.interfaces;


import net.luna.common.download.model.FileDownloadTask;

public interface FileDownloadListener {

    public void onDownloadStart(FileDownloadTask task);

    public void onDownloadSuccess(FileDownloadTask task);

    public void onDownloadFailed(FileDownloadTask task);

    public void onDownloadStop(FileDownloadTask task);

    /**
     * @param task
     * @param contentLength
     * @param completeLength 已经完成的长度
     * @param percent        当前完成百分比
     */
    public void onDownloadProgressUpdate(FileDownloadTask task, long contentLength, long completeLength, int percent);

    public void onDownloadPrepare(FileDownloadTask task);
}
