package net.luna.common.download;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Environment;
import android.util.SparseArray;

import net.luna.common.constant.RString;
import net.luna.common.debug.LunaLog;
import net.luna.common.download.interfaces.ApkDownloadListener;
import net.luna.common.download.model.AppModel;
import net.luna.common.download.model.FileDownloadTask;
import net.luna.common.util.FileUtils;
import net.luna.common.util.NetWorkUtil;
import net.luna.common.util.PackageUtils;
import net.luna.common.util.StringUtils;
import net.luna.common.util.ThreadUtils;
import net.luna.common.util.ToastUtils;
import net.luna.common.util.zip.ZipUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * @author bintou
 * @version 创建时间：2015年7月24日 上午9:28:16
 */
@SuppressLint("HandlerLeak")
public class AppDownloadManager {

    private Context mApplicationContext;

    private static AppDownloadManager mInstance;

    private DownloadManagerPro mDownloadManagerPro;

    private static String fileStoreDirPath;

    private SparseArray<AppModel> appDownloadList = new SparseArray<AppModel>();

    private DownloadChangeObserver downloadObserver;

    private ArrayList<ApkDownloadListener> listenersList;

    private AppDownloadManager(Context context) {
        mApplicationContext = context.getApplicationContext();
        DownloadManager mDownloadManager = (DownloadManager) mApplicationContext
                .getSystemService(Context.DOWNLOAD_SERVICE);
        listenersList = new ArrayList<ApkDownloadListener>();
        mDownloadManagerPro = new DownloadManagerPro(mDownloadManager);
        downloadObserver = new DownloadChangeObserver();

        mApplicationContext.getContentResolver().registerContentObserver(DownloadManagerPro.CONTENT_URI, true,
                downloadObserver);

    }

    public static AppDownloadManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new AppDownloadManager(context);
        }
        return mInstance;
    }

    public Context getApplicationContext() {
        return mApplicationContext;
    }

    public void downloadApp(AppModel model) {
        try {

            // 不满足条件，无法下载
            if (model == null) {
                return;
            }
            if (StringUtils.isBlank(model.getDownloadUrl())) {
                return;
            }
            FileDownloadTask task = new FileDownloadTask(model.getDownloadUrl());
            // 如果存在，就取消下载
            if (queryModelIfIsExist(task.getRawUrl())) {
                return;
            }

            String fileName;
            if (model.getDownloadUrl().contains(".gpk")) {
                fileName = model.getAppName() + ".zip";
            } else {
                fileName = model.getAppName() + ".apk";
            }
            File storeFile = new File(getStoreDirPath() + File.separator + fileName);
            File gpkFileDir = new File(getStoreDirPath() + File.separator + model.getAppName());
            if (storeFile.exists() || isGPKFileExist(gpkFileDir.getPath())) {
                // 已经有文件了，启动安装
                for (ApkDownloadListener listener : listenersList) {
                    if (listener != null) {
                        listener.onApkDownloadSuccess(model);
                    }
                }
                model.setApkFilePath(storeFile.getPath());
                startInstallLogic(model);
                return;
            }
            DownloadManagerPro.RequestPro request = new DownloadManagerPro.RequestPro(Uri.parse(task.getDestUrl()));
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                    | DownloadManager.Request.NETWORK_MOBILE);
            request.setDestinationInExternalPublicDir(STORE_PATH, fileName);
            request.setVisibleInDownloadsUi(true);
            request.setTitle("《" + model.getAppName() + "》");
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            long downloadId = mDownloadManagerPro.beginDownload(request);
            task.setDownloadId(downloadId);
            task.setStoreFile(storeFile);
            model.setFileDownloadTask(task);
            model.setApkFilePath(storeFile.getAbsolutePath());

            appDownloadList.put((int) downloadId, model);
            ToastUtils.show(mApplicationContext, RString.DOWNLOAD_OPEN + "《" + model.getAppName() + "》");
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public boolean queryModelIfIsExist(String rawUrl) {
        try {
            for (int i = 0; i < appDownloadList.size(); i++) {
                int key = appDownloadList.keyAt(i);
                AppModel temp = appDownloadList.get(key);
                if (temp != null) {
                    if (rawUrl.equals(temp.getFileDownloadTask().getRawUrl())) {
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

    final static String STORE_PATH = "/Luna/downloads/";

    public static String getStoreDirPath() {
        if (StringUtils.isBlank(fileStoreDirPath)) {
            File dir = new File(String.valueOf(Environment.getExternalStoragePublicDirectory(STORE_PATH)));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            fileStoreDirPath = dir.getPath();
        }
        return fileStoreDirPath;
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
                AppModel appModel = queryAppModel((int) downloadId);
                FileDownloadTask task = null;
                if (appModel != null && appModel.getFileDownloadTask() != null) {
                    task = appModel.getFileDownloadTask();
                }
                if (task != null) {
                    switch (status) {
                        case DownloadManager.STATUS_RUNNING:
                            int curbytes = bytesAndStatus[0];
                            int totalbytes = bytesAndStatus[1];
                            int percent = curbytes * 100 / totalbytes;
                            for (ApkDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onApkDownloadProgressUpdate(task, curbytes, totalbytes, percent);
                                }
                            }
                            break;
                        case DownloadManager.STATUS_SUCCESSFUL:
                            for (ApkDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onApkDownloadSuccess(task);
                                }
                            }
                            removeTask(downloadId);
                            // 成功只需要响应一次
                            startInstallLogic(appModel);
                            break;
                        case DownloadManager.STATUS_FAILED:
                            removeTask(downloadId);
                            for (ApkDownloadListener listener : listenersList) {
                                if (listener != null) {
                                    listener.onApkDownloadFailed(task);
                                }
                            }
                            break;
                        case DownloadManager.STATUS_PAUSED:
                            if (!NetWorkUtil.IsNetWorkEnable(mApplicationContext)) {
                                for (ApkDownloadListener listener : listenersList) {
                                    if (listener != null) {
                                        listener.onApkDownloadFailed(task);
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
            if (appDownloadList != null && appDownloadList.size() > 0) {
                AppModel AppModel = appDownloadList.get((int) downloadId);
                if (AppModel != null && AppModel.getFileDownloadTask() != null) {
                    return AppModel.getFileDownloadTask();
                }
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return null;
    }

    public AppModel queryAppModel(int downloadId) {
        try {
            if (appDownloadList != null && appDownloadList.size() > 0 && fileStoreDirPath != null) {
                AppModel AppModel = appDownloadList.get(downloadId);
                return AppModel;
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return null;
    }

    public void removeTask(long downloadId) {
        try {
            if (appDownloadList != null && appDownloadList.size() > 0) {
                appDownloadList.remove((int) downloadId);
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
    }

    public AppModel queryAppModel(FileDownloadTask task) {
        try {
            if (appDownloadList != null && appDownloadList.size() > 0 && fileStoreDirPath != null) {
                AppModel AppModel = appDownloadList.get((int) task.getDownloadId());
                return AppModel;
            }
        } catch (Exception e) {
            LunaLog.e(e);
        }
        return null;
    }


    private void startInstallLogic(final AppModel model) {
        ThreadUtils.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (model.getDownloadUrl().contains(".gpk")) {
                        LunaLog.d("It's gpk file");
                        if (model.getApkFilePath().contains(".zip")) {
                            LunaLog.d("unzip the file : " + model.getApkFilePath());
                            File zipFile = new File(model.getApkFilePath());
                            String destPath = zipFile.getParentFile().getPath() + File.separator + model.getAppName();
                            if (isGPKFileExist(destPath)) {
                                installGPKFile(destPath);
                                return;
                            }
                            if (zipFile.exists()) {
                                LunaLog.d(zipFile.getAbsolutePath() + "   exist");
                                boolean isUnzipSuccess = ZipUtils.sync_unZip(zipFile, destPath);
                                if (isUnzipSuccess) {
                                    LunaLog.d("page unzip complete");
                                    if (zipFile.exists() && !zipFile.isDirectory()) {
                                        FileUtils.deleteFile(zipFile.getPath());
                                    }
                                    installGPKFile(destPath);
                                } else {
                                    FileUtils.deleteFile(destPath);
                                    LunaLog.d("page unzip fail");
                                }
                            }
                        }
                    } else {
                        File installFile = new File(model.getApkFilePath());
                        if (installFile.exists()) {
                            LunaLog.d("install succeed  :" + installFile.getAbsolutePath());
                            PackageUtils.installNormal(mApplicationContext, installFile.getAbsolutePath());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private boolean isGPKFileExist(String path) {
        File dest = new File(path);
        if (dest.exists() && dest.isDirectory()) {
            String apkFilePath = dest.getPath() + File.separator + "application.apk";
            if (new File(apkFilePath).exists()) {
                return true;
            }
        }
        return false;
    }

    private void installGPKFile(String dirStr) {
        try {
            File dir = new File(dirStr);
            if (dir.exists() && dir.isDirectory()) {
                String apkFilePath = dir.getPath() + File.separator + "application.apk";
                File obbFile = null;
                File[] lists = dir.listFiles();
                if (lists != null) {
                    for (int i = 0; i < lists.length; i++) {
                        if (lists[i].getPath().contains(".obb")) {
                            obbFile = lists[i];
                            break;
                        }
                    }
                }
                if (obbFile != null) {
                    String fileText = obbFile.getName();
                    LunaLog.d(fileText);
                    if (!StringUtils.isBlank(fileText)) {
                        fileText = fileText.replaceAll("\\\\", "/");
                        if (!StringUtils.isBlank(fileText)) {
                            File obbDest = Environment.getExternalStoragePublicDirectory("/Android/obb/" + fileText);
                            FileUtils.moveFile(obbFile, obbDest);
                        }
                    }
                }
                PackageUtils.installNormal(mApplicationContext, apkFilePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onAppInstallSuccess(AppModel model) {
        for (ApkDownloadListener listener : listenersList) {
            if (listener != null) {
                listener.onApkInstallSuccess(model);
            }
        }
    }

}
