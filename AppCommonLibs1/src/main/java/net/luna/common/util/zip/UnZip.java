package net.luna.common.util.zip;

import net.luna.common.basic.GlobalCharsets;
import net.luna.common.debug.LunaLog;
import net.luna.common.util.FileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZip {

    private final static int BUFF_SIZE = 2048;

    private File mZipFile;

    private String mDestDirPath;

    private Interface_UnZipListener mListener;

    private boolean mIsCallBackInUiThread;

    /**
     * @param zipFile              zip文件
     * @param destDirPath          解压目录路径
     * @param unZipListener        解压过程中的回调监听
     * @param isCallBackInUiThread 监听的各个回调是否执行在 UI线程中
     *                             <ul>
     *                             <li>true ： 是</li>
     *                             <li>false： 否</li>
     *                             </ul>
     */
    public UnZip(File zipFile, String destDirPath, Interface_UnZipListener unZipListener, boolean isCallBackInUiThread) {
        super();
        this.mZipFile = zipFile;
        if (destDirPath != null) {
            this.mDestDirPath = destDirPath;
        } else {
            try {
                this.mDestDirPath = zipFile.getParent() + File.separator + zipFile.getName().split("\\.")[0];
            } catch (Throwable e) {
                this.mDestDirPath = zipFile.getParent() + File.separator + System.currentTimeMillis();
            }
        }
        this.mListener = unZipListener;
        this.mIsCallBackInUiThread = isCallBackInUiThread;
    }

    /**
     * 回调执行在UI线程中
     *
     * @param zipFile       zip文件
     * @param destDirPath   解压目录路径
     * @param unZipListener 解压过程中的回调监听
     */
    public UnZip(File zipFile, String destDirPath, Interface_UnZipListener unZipListener) {
        super();
        this.mZipFile = zipFile;
        if (destDirPath != null) {
            this.mDestDirPath = destDirPath;
        } else {
            try {
                this.mDestDirPath = zipFile.getParent() + File.separator + zipFile.getName().split("\\.")[0];
            } catch (Throwable e) {
                this.mDestDirPath = zipFile.getParent() + File.separator + System.currentTimeMillis();
            }
        }
        this.mListener = unZipListener;
        this.mIsCallBackInUiThread = true;
    }

    public boolean unZip() {
        ZipFile zfile = null;
        boolean isError = false;
        int totalCount = 0; // 解压的总条目数量
        int failCount = 0; // 解压过程中解压失败的条目计数器
        try {
            File destDir = new File(mDestDirPath);
            // 然后尝试清空解压缩目录，然后最后需要重新创建这个目录
            FileUtils.deleteFile(destDir);
            destDir.mkdir();

            // 获取zip文件里面的所有条目，然后遍历判断是否
            zfile = new ZipFile(mZipFile);
            Enumeration<? extends ZipEntry> zList = zfile.entries();
            ZipEntry ze = null;
            int currentIndex = 0;

            if (zfile.size() > 0) {
                totalCount = zfile.size();
            }
            while (zList.hasMoreElements()) {
                ze = (ZipEntry) zList.nextElement();

                // 这里先将条目转码
                String zeName = new String(ze.getName().getBytes(GlobalCharsets.GBK));
                File file = new File(mDestDirPath, zeName);

                // if (Debug_SDK.isUtilLog) {
                // Debug_SDK.td(Debug_SDK.mUtilTag, this,
                // "条目：%s %s， 条目最后存放的位置：%s", ze.getName(),
                // ze.isDirectory() ? "是目录" : "不是目录", file.getPath());
                // }
                if (ze.isDirectory()) {
                    boolean isSuccess = file.mkdir();
                    if (!isSuccess) {
                        ++failCount;
                    }
                    continue;
                }
                InputStream is = null;
                OutputStream os = null;
                try {
                    File temp = FileUtils.getVaildFile(file);
                    if (temp != null && temp.exists() && temp.isFile()) {
                        // if (Debug_SDK.isUtilLog) {
                        // Debug_SDK.td(Debug_SDK.mUtilTag, this,
                        // "  == 创建文件成功");
                        // }
                        os = new BufferedOutputStream(new FileOutputStream(temp));
                        is = new BufferedInputStream(zfile.getInputStream(ze)); // 获取条目的stream
                        // 然后写入打上面的文件
                        int readLen = 0;
                        byte[] buf = new byte[BUFF_SIZE];
                        while ((readLen = is.read(buf, 0, 1024)) != -1) {
                            os.write(buf, 0, readLen);
                        }
                    } else {
                        // if (Debug_SDK.isUtilLog) {
                        // Debug_SDK.te(Debug_SDK.mUtilTag, this,
                        // "  == 创建文件失败");
                        // }
                    }
                } catch (Exception e) {
                    LunaLog.e(e);
                    ++failCount;
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (Throwable e2) {
                        LunaLog.e(e2);
                    }
                    try {
                        if (os != null) {
                            os.close();
                        }
                    } catch (Throwable e2) {
                        LunaLog.e(e2);
                    }
                }
            }
        } catch (Throwable e) {
            LunaLog.e(e);
            isError = true;
        } finally {
            try {
                if (zfile != null) {
                    zfile.close();
                }
            } catch (Throwable e2) {
                LunaLog.e(e2);
            }
            if (!isError) {
                if (failCount > 0) {
                    isError = true;
                }
            }
        }
        return !isError;

    }

}
