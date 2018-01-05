package net.luna.common.download.model;

import java.io.Serializable;

/**
 * @author bintou
 * @version 创建时间：2015年7月21日 下午4:47:29
 */
public class AppModel implements Serializable {


    private FileDownloadTask task;

    private String apkFilePath;

    private String packageName;

    private String appName;

    private String iconUrl;

    private String versionName;

    private String downloadUrl;

    private String md5Sum;

    private int apkSize;

    private int versionCode;


    public AppModel() {
    }

    public String getPackageName() {
        return packageName;
    }

    public String getAppName() {
        return appName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getMd5Sum() {
        return md5Sum;
    }

    public int getApkSize() {
        return apkSize;
    }

    public int getVersionCode() {
        return versionCode;
    }


    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public void setDownloadUrl(String dlUrl) {
        this.downloadUrl = dlUrl;
    }

    public void setMd5Sum(String md5Sum) {
        this.md5Sum = md5Sum;
    }

    public void setApkSize(int apkSize) {
        this.apkSize = apkSize;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }


    public FileDownloadTask getFileDownloadTask() {
        return task;
    }

    public void setFileDownloadTask(FileDownloadTask task) {
        this.task = task;
    }


    public String getApkFilePath() {
        return apkFilePath;
    }

    public void setApkFilePath(String apkFilePath) {
        this.apkFilePath = apkFilePath;
    }

}
