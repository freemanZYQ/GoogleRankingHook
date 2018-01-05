package net.luna.common.download.model;

import net.luna.common.debug.LunaLog;
import net.luna.common.util.DigestUtils;

import java.io.File;
import java.io.Serializable;
import java.util.Locale;

/**
 * 下载任务描述
 *
 * @author zhitaocai edit on 2014-5-29
 */
public class FileDownloadTask implements Serializable {

    /**
     * 下载ID
     */
    private long downloadId;

    /**
     * 文件最终下载地址
     */
    private String mDestUrl;


    /**
     * 由文件最终下载地址生成的hashcode
     */
    private int mHashCode;

    /**
     * 下载任务是否可用，一般是检查url是否正常
     */
    private boolean mIsAvailable = false;

    /**
     * 最终存储文件的长度
     */
    private long mContentLength = 0;

    /**
     * 原始文件下载链接
     */
    private String mRawUrl;

    /**
     * md5校验码
     */
    private String mMd5sum;

    /**
     * 文件的最终保存位置，创建对象的时候传入
     */
    private File mStoreFile;

    public String getIdentity() {
        return identity;
    }

    private String identity;

    /**
     * 缓存文件位置，进入下载之前创建，不在创建对象的时候传入
     */
    private File mTempFile;

    public FileDownloadTask(String rawUrl) {
        if (rawUrl == null) {
            mIsAvailable = false;
            return;
        }

        rawUrl = rawUrl.trim();
        if (rawUrl.length() <= 0) {
            mIsAvailable = false;
            return;
        }

        mDestUrl = rawUrl;

        mRawUrl = mDestUrl;

        mHashCode = mDestUrl.hashCode();
        identity = DigestUtils.md5(mDestUrl);
        mIsAvailable = true;

    }

    /**
     * 获取文件下载地址(最终下载地址)
     *
     * @return
     */
    public String getDestUrl() {
        return mDestUrl;
    }


    /**
     * 获取原始的url
     *
     * @return
     */
    public String getRawUrl() {
        return mRawUrl;
    }


    /**
     * 下载任务是否可用，一般是检查url是否正常
     *
     * @return
     */
    public boolean isAvailable() {
        return mIsAvailable;
    }

    /**
     * 设置长度
     *
     * @param contentLength
     */
    public void setContentLength(long contentLength) {
        this.mContentLength = contentLength;
    }

    /**
     * 获取长度
     *
     * @return
     */
    public long getContentLength() {
        return mContentLength;
    }

    protected void setMd5sum(String md5sum) {
        try {
            if (md5sum == null) {
                return;
            }
            md5sum = md5sum.trim().toLowerCase(Locale.getDefault());
            if (md5sum.length() <= 0) {
                return;
            }

            // 最好能检查到32位hex字符
            this.mMd5sum = md5sum;

        } catch (Throwable e) {
            LunaLog.e(e);
        }
    }

    /**
     * 获取md5校验码
     *
     * @return
     */
    public String getMd5sum() {
        return mMd5sum;
    }

    /**
     * 设置原始下载链接
     *
     * @param rawUrl
     */
    public void setRawUrl(String rawUrl) {
        try {
            if (rawUrl == null) {
                return;
            }
            rawUrl = rawUrl.trim();
            if (rawUrl.length() <= 0) {
                return;
            }
            this.mRawUrl = rawUrl;
        } catch (Throwable e) {
            LunaLog.e(e);
        }
    }

    /**
     * 获取最终存储的文件地址
     *
     * @return
     */
    public File getStoreFile() {
        return mStoreFile;
    }

    /**
     * 设置最终存储的文件地址
     *
     * @param storeFile
     */
    public void setStoreFile(File storeFile) {
        mStoreFile = storeFile;
    }

    /**
     * 获取缓存文件的地址，可能为空，只有在开始下载和下载过程中，才会可能获取到真实的缓存地址
     *
     * @return
     */
    public File getTempFile() {
        return mTempFile;
    }

    /**
     * 设置缓存文件的地址，在下载开始的时候才设置
     *
     * @param mTempFile
     */
    public void setTempFile(File mTempFile) {
        this.mTempFile = mTempFile;
    }

    @Override
    public int hashCode() {
        return mHashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.hashCode() == this.hashCode()) {
            return true;
        }

        return false;
    }

    public long getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(long downloadId) {
        this.downloadId = downloadId;
    }

    @Override
    public String toString() {
        try {
            return "FileDownloadTask [" + "\n mDestUrl=" + mDestUrl + ", " + ", "
                    + "\n mHashCode=" + mHashCode + ", \n mIsAvailable=" + mIsAvailable + ", \n mContentLength="
                    + mContentLength + ", \n mRawUrl=" + mRawUrl
                    + ", \n mMd5sum=" + mMd5sum + ", \n mStoreFile=" + mStoreFile + ", \n mTempFile=" + mTempFile
                    + "\n]";
        } catch (Throwable e) {
            LunaLog.e(e);
        }
        return super.toString();
    }

}
