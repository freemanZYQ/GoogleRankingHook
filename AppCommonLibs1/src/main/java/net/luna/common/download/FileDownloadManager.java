package net.luna.common.download;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.util.SparseArray;

import net.luna.common.debug.LunaLog;
import net.luna.common.download.interfaces.FileDownloadListener;
import net.luna.common.download.model.FileDownloadTask;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.StringUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * @author bintou
 * @version 创建时间：2016年1月4日 上午9:28:16
 */
@SuppressLint("HandlerLeak")
public class FileDownloadManager {

    private Context mApplicationContext;

    private static FileDownloadManager mInstance;

    private DownloadManagerPro mDownloadManagerPro;


    private SparseArray<FileDownloadTask> fileDownloadList = new SparseArray<FileDownloadTask>();

    private DownloadChangeObserver downloadObserver;

    private ArrayList<FileDownloadListener> listenersList;

    private FileDownloadManager(Context context) {
        mApplicationContext = context.getApplicationContext();
        DownloadManager mDownloadManager = (DownloadManager) mApplicationContext
                .getSystemService(Context.DOWNLOAD_SERVICE);
        listenersList = new ArrayList<FileDownloadListener>();
        mDownloadManagerPro = new DownloadManagerPro(mDownloadManager);
        downloadObserver = new DownloadChangeObserver();

        mApplicationContext.getContentResolver().registerContentObserver(DownloadManagerPro.CONTENT_URI, true,
                downloadObserver);

    }

    public static FileDownloadManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new FileDownloadManager(context);
        }
        return mInstance;
    }

    public Context getApplicationContext() {
        return mApplicationContext;
    }

    public long download(String downloadUrl, File storeFile) {
        try {

            // 不满足条件，无法下载
            if (StringUtils.isBlank(downloadUrl)) {
                return -1;
            }
            FileDownloadTask task = new FileDownloadTask(downloadUrl);
            // 如果存在，就取消下载
            if (queryTaskIfIsExist(task.getRawUrl())) {
                return -1;
            }

            if (storeFile.exists()) {
                for (FileDownloadListener listener : listenersList) {
                    if (listener != null) {
                        listener.onDownloadSuccess(task);
                    }
                }
                return -1;
            }
            DownloadManagerPro.RequestPro request = new DownloadManagerPro.RequestPro(Uri.parse(task.getDestUrl()));
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                    | DownloadManager.Request.NETWORK_MOBILE);
            request.setDestinationUri(Uri.fromFile(storeFile));
            request.setVisibleInDownloadsUi(true);
            request.setTitle(storeFile.getName());
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            long downloadId = mDownloadManagerPro.beginDownload(request);
            task.setDownloadId(downloadId);
            task.setStoreFile(storeFile);
            fileDownloadList.put((int) downloadId, task);
            return downloadId;
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return -1;
    }

    public boolean queryTaskIfIsExist(String rawUrl) {
        try {
            for (int i = 0; i < fileDownloadList.size(); i++) {
                int key = fileDownloadList.keyAt(i);
                FileDownloadTask temp = fileDownloadList.get(key);
                if (temp != null) {
                    if (rawUrl.equals(temp.getRawUrl())) {
                        // 替换为最新的回调
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return false;
    }

    public void addListener(FileDownloadListener listener) {
        if (listener != null) {
            listenersList.add(listener);
        }
    }

    public void removeListener(FileDownloadListener listener) {
        if (listener != null) {
            listenersList.remove(listener);
        }
    }

    class DownloadChangeObserver extends ContentObserver {

        public DownloadChangeObserver() {
            super(null);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            try {
                String path = uri.getPath();
                long downloadId;
                try {
                    path = path.replace("/my_downloads/", "");
                    downloadId = Long.parseLong(path);
                } catch (Exception e) {
                    return;
                }
                int[] bytesAndStatus = mDownloadManagerPro.getBytesAndStatus(downloadId);

                int status = bytesAndStatus[2];
                FileDownloadTask task = queryTask((int) downloadId);
                if (task != null) {
                    switch (status) {
                        case DownloadManager.STATUS_RUNNING:
                            int curbytes = bytesAndStatus[0];
                            int totalbytes = bytesAndStatus[1];
                            int percent = curbytes * 100 / totalbytes;
                            for (FileDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onDownloadProgressUpdate(task, curbytes, totalbytes, percent);
                                }
                            }
                            break;
                        case DownloadManager.STATUS_SUCCESSFUL:
                            for (FileDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onDownloadSuccess(task);
                                }
                            }
                            removeTask(downloadId);
                            // 成功只需要响应一次
                            break;
                        case DownloadManager.STATUS_FAILED:
                            removeTask(downloadId);
                            for (FileDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onDownloadFailed(task);
                                }
                            }
                            break;
                        case DownloadManager.STATUS_PAUSED:
                            if (!NetWorkUtil.IsNetWorkEnable(mApplicationContext)) {
                                for (FileDownloadListener listener : listenersList) {
                                    if (listener != null) {
                                        listener.onDownloadFailed(task);
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                LunaLog.e(e);
            }
        }
    }

    public FileDownloadTask queryTask(long downloadId) {
        try {
            if (fileDownloadList != null && fileDownloadList.size() > 0) {
                FileDownloadTask task = fileDownloadList.get((int) downloadId);
                if (task != null) {
                    return task;
                }
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return null;
    }


    public void removeTask(long downloadId) {
        try {
            if (fileDownloadList != null && fileDownloadList.size() > 0) {
                fileDownloadList.remove((int) downloadId);
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public void removeAndDeleteTask(long downloadId) {
        try {
            if (fileDownloadList != null && fileDownloadList.size() > 0) {
                fileDownloadList.remove((int) downloadId);
                mDownloadManagerPro.removeTask(downloadId);
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public void pauseTask(long... downloadIds) {
        mDownloadManagerPro.pauseDownload(downloadIds);
    }

    public void resumeTask(long... downloadIds) {
        mDownloadManagerPro.resumeDownload(downloadIds);
    }

}
