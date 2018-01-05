package com.tools.hackandroid.util;

import android.support.annotation.NonNull;

import net.luna.common.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author zhitao
 * @since 2016-08-05 09:45
 */
public class FileUtil {

    /**
     * 获取指定的路径的文件，如果没有会创建(支持自动补全所有父目录)
     *
     * @param file 文件
     */
    public static File getVaildFile(File file) {
        try {
            if (file == null) {
                return null;
            }
            // 先检查是不是目录，如果是的话就没办法啦，返回null
            if (file.exists()) {
                if (file.isDirectory()) {
                    return null;
                }
                // 如果不是目录也不能立即返回，需要检查父目录
            }

            // 如果不存在父目录的话, 自动补全所有的根目录,然后创建
            if (!file.getParentFile().exists()) {
                DLog.i("当前文件：%s不存在父目录，将补全", file.getAbsoluteFile());
                String[] filePathParts = file.getPath().split(File.separator);
                StringBuilder parentDirPath = new StringBuilder();
                for (int i = 0; i < filePathParts.length - 1; ++i) {
                    parentDirPath.append(File.separator).append(filePathParts[i]);
                    // File parentDirFile = new File(parentDirPath.toString());
                    // if (!parentDirFile.exists()) {
                    // if (Debug_SDK.isUtilLog) {
                    // DLog.te(DLog.mUtilTag, Util_Zip.class, "路径:%s 不存在任何内容",
                    // parentDirFile.getAbsoluteFile());
                    // }
                    // // boolean chmodResult = chmod(parentDirFile.getParentFile(), "777");
                    // // if (Debug_SDK.isUtilLog) {
                    // // DLog.te(DLog.mUtilTag, Util_Zip.class, "修改 %s 权限 %s", parentDirFile.getParent(),
                    // // chmodResult ? "成功" : "失败");
                    // // }
                    // boolean result = parentDirFile.mkdir();
                    // if (Debug_SDK.isUtilLog) {
                    // DLog.te(DLog.mUtilTag, Util_Zip.class, "目录%s 创建 %s",
                    // parentDirFile.getAbsoluteFile(), result ? "成功" : "失败");
                    // }
                    // } else {
                    // // boolean chmodResult = chmod(parentDirFile, "777");
                    // // if (Debug_SDK.isUtilLog) {
                    // // DLog.te(DLog.mUtilTag, Util_Zip.class, "修改 %s 权限 %s", parentDirFile.getParent(),
                    // // chmodResult ? "成功" : "失败");
                    // // }
                    // if (Debug_SDK.isUtilLog) {
                    // DLog.te(DLog.mUtilTag, Util_Zip.class, "路径:%s 存在 是%s",
                    // parentDirFile.getAbsoluteFile(),
                    // parentDirFile.isFile() ? "文件" : parentDirFile.isDirectory() ? "目录" : "其他");
                    // }
                    // }
                }
                File parentDirFile = new File(parentDirPath.toString());
                if (!parentDirFile.exists()) {
                    DLog.i("路径:%s,不存在任何内容", parentDirFile.getAbsoluteFile());
                }
                boolean result = parentDirFile.mkdirs();
                DLog.i("补全父目录%s %s", parentDirFile.getAbsoluteFile(), result ? "成功" : "失败");
            }
            file.createNewFile();
            return file;
        } catch (Throwable e) {
            DLog.e(e);
        }
        return null;
    }

    /**
     * （同步）支持删除文件或者文件夹，使用时请注意启用线程
     * <p/>
     * 使用时<strong>请注意启用线程</strong>
     *
     * @param file 要删除的文件或者目录
     * @return true or false
     */
    public static boolean delete(final File file) {
        try {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                if (file.isFile()) {
                    boolean isSuccess = file.delete();
                    if (isSuccess) {
                        DLog.i("删除成功： %s", file.getAbsolutePath());
                    } else {
                        DLog.e("删除失败： %s", file.getAbsolutePath());
                    }
                    return isSuccess;
                } else if (file.isDirectory()) {
                    for (File f : file.listFiles()) {
                        if (!delete(f)) {
                            return false;
                        }
                    }
                    boolean isSuccess = file.delete();
                    if (isSuccess) {
                        DLog.i("删除成功： %s", file.getAbsolutePath());
                    } else {
                        DLog.e("删除失败： %s", file.getAbsolutePath());
                    }
                    return isSuccess;
                }
            } else {
                // 因为最终目的是令该文件不存在，所以如果文件一开始就不存在，那么也就意味着删除成功
                DLog.i("删除成功(可能本来就不存在)： %s", file.getAbsolutePath());
                return true;
            }
        } catch (Throwable e) {
            DLog.e(e);
        }
        return false;
    }

    public static String getStringFromFileWithSpecLineNumber(@NonNull String filePath, int lineNumber) {
        return getStringFromFileWithSpecLineNumber(new File(filePath), lineNumber);
    }

    /**
     * 写入list中的数据到文件中
     *
     * @param file
     * @param list
     * @return
     */
    public static boolean writeList2File(File file, ArrayList<String> list) {
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        boolean isSuccess = false;
        try {
            fos = new FileOutputStream(file);
            writer = new BufferedWriter(new OutputStreamWriter(fos));
            for (String line : list) {
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
            isSuccess = true;
        } catch (Exception e) {
            DLog.e(e);
        } finally {
            closeWriter(writer);
            closeOutputStream(fos);
            DLog.i("写入list到文件[%s]中 %s", file.getAbsolutePath(), isSuccess ? "成功" : "失败");
        }
        return isSuccess;
    }

    public static boolean writeLine2File(File file, String line) {
        if (StringUtils.isEmpty(line)) {
            return false;
        }
        BufferedWriter writer = null;
        FileWriter fileWriter;
        boolean isSuccess = false;
        try {
            fileWriter = new FileWriter(file.getAbsolutePath(), true);
            writer = new BufferedWriter(fileWriter);
            writer.write(line);
            writer.newLine();
            writer.flush();
            isSuccess = true;
        } catch (Exception e) {
            DLog.e(e);
        } finally {
            closeWriter(writer);
            DLog.i("写入一行到文件[%s]中 %s", file.getAbsolutePath(), isSuccess ? "成功" : "失败");
        }
        return isSuccess;
    }

    /**
     * 从文件中读取所有行的数据,并且保存到list中
     *
     * @param file
     * @return
     */
    public static ArrayList<String> getAllLineStringFromFile(File file) {
        FileInputStream fis = null;
        BufferedReader reader = null;
        ArrayList<String> list = null;
        try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));
            String tempLine;
            list = new ArrayList<>();
            while ((tempLine = reader.readLine()) != null) {
                list.add(tempLine);
            }
        } catch (Exception e) {
            DLog.e(e);
        } finally {
            closeReader(reader);
            closeInputStream(fis);
            DLog.i("读取文件[%s]到list中", file.getAbsolutePath());
        }
        return list;
    }

    /**
     * 获取文件中，指定行的数据
     *
     * @param file
     * @param lineNumber 行号
     * @return
     */
    public static String getStringFromFileWithSpecLineNumber(@NonNull File file, int lineNumber) {
        InputStream is = null;
        LineNumberReader reader = null;
        String finalLineString = null;
        try {
            if (lineNumber != 0) {
                is = new FileInputStream(file);
                //			reader = new BufferedReader(new InputStreamReader(is));
                reader = new LineNumberReader(new InputStreamReader(is));
                String tempLine;
                while ((tempLine = reader.readLine()) != null) {
                    if (reader.getLineNumber() == lineNumber) {
                        finalLineString = tempLine;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            DLog.e(e);
        } finally {
            closeReader(reader);
            closeInputStream(is);
            DLog.i("读取文件[%s]第%d行,获得[%s]", file.getAbsolutePath(), lineNumber, finalLineString);
        }
        return finalLineString;
    }

    /**
     * 从文件中获取序列化对象
     *
     * @param file 存储位置
     * @return
     */
    public static Object readSerializableObjectFromFile(String path) {
        return readSerializableObjectFromFile(new File(path));
    }

    /**
     * 从文件中获取序列化对象
     *
     * @param file 存储位置
     * @return
     */
    public static Object readSerializableObjectFromFile(File file) {
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            DLog.e(e);
            return null;
        } finally {
            closeInputStream(fileInputStream);
            closeInputStream(objectInputStream);
        }
    }

    /**
     * 写入序列化对象到文件中
     *
     * @param path
     * @param serializable
     * @return
     */
    public static boolean writeSerializableObject2File(String path, Serializable serializable) {
        return writeSerializableObject2File(new File(path), serializable);
    }

    /**
     * 写入序列化对象到文件中
     *
     * @param file         保存位置
     * @param serializable 保存对象
     * @return
     */
    public static boolean writeSerializableObject2File(File file, Serializable serializable) {
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            DLog.e(e);
            return false;
        } finally {
            closeOutputStream(fileOutputStream);
            closeOutputStream(objectOutputStream);
        }
    }

    private static void closeOutputStream(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable throwable) {
            DLog.e(throwable);
        }
    }

    private static void closeInputStream(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable throwable) {
            DLog.e(throwable);
        }
    }

    private static void closeReader(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (Throwable throwable) {
            DLog.e(throwable);
        }
    }

    private static void closeWriter(Writer writer) {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (Throwable throwable) {
            DLog.e(throwable);
        }
    }

}
