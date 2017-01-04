package com.substrate.java.gp;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/12/12.
 */
public class FileUtils {

    public static String TAG = "mainClass";
    public static  void createFile(String path, byte[] content) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        fos.write(content);
        fos.close();
    }
    public static byte[] toByteArray(File f) throws IOException {
        long size = f.length();
        if (size > 2147483647L) {
            throw new OutOfMemoryError("Too large to fit in a byte array: " + size);
        } else if (size == 0) {
            return new byte[0];
        } else {
            FileInputStream fis = new FileInputStream(f);
            try {
                byte[] data = new byte[((int) size)];
                int totalBytesRead = 0;
                while (totalBytesRead < data.length) {
                    int bytesRead = fis.read(data, totalBytesRead, data.length - totalBytesRead);
                    if (bytesRead == -1) {
                        throw new IOException("Unexpected EOS: " + data.length + ", " + totalBytesRead);
                    }
                    totalBytesRead += bytesRead;
                }
                return data;
            } finally {
                fis.close();
            }
        }
    }




    public synchronized static  boolean writeFile(String filePath, String content, boolean append) {

        if (TextUtils.isEmpty(content)) {
            return false;
        }

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            makeDirs(filePath);
            fileWriter = new FileWriter(filePath, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred. ", e);
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException("IOException occurred. ", e);
                }
            }
        }
    }

    public synchronized static boolean makeDirs(String filePath) {
        String folderName = getFolderName(filePath);
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }

        File folder = new File(folderName);
        return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
    }

    public static String getFolderName(String filePath) {

        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }

        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? "" : filePath.substring(0, filePosi);
    }

    public static List<String> readDataFromFile(String filePath){
        List<String> result = new ArrayList<>();
        File file = new File(filePath);
        if(!file.exists()) return null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            int index = 0;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String readFromFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()) return null;
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static void replaceLineFromFile(String file,String lineToReplace,String replace){
        try {
            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

//Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
//Read from the original file and write to the new
//unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.trim().contains(lineToReplace)) {
                    pw.println(line);
                    pw.flush();
                }else{
                    pw.println(replace);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

//Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
//Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeLineFromFile(String file, String lineToRemove) {
        try {
            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.trim().contains(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static String MESSAGE = "";

    /**
     * 复制单个文件
     *
     * @param srcFileName
     *            待复制的文件名
     * @param descFileName
     *            目标文件名
     * @param overlay
     *            如果目标文件存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyFile(String srcFileName, String destFileName,
                                   boolean overlay) {
        File srcFile = new File(srcFileName);

        // 判断源文件是否存在
        if (!srcFile.exists()) {
            MESSAGE = "源文件：" + srcFileName + "不存在！";
            Log.d(TAG,MESSAGE);
            return false;
        } else if (!srcFile.isFile()) {
            MESSAGE = "复制文件失败，源文件：" + srcFileName + "不是一个文件！";
            Log.d(TAG,MESSAGE);
            return false;
        }

        // 判断目标文件是否存在
        File destFile = new File(destFileName);
        if (destFile.exists()) {
            // 如果目标文件存在并允许覆盖
            if (overlay) {
                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件
                new File(destFileName).delete();
            }
        } else {
            // 如果目标文件所在目录不存在，则创建目录
            if (!destFile.getParentFile().exists()) {
                // 目标文件所在目录不存在
                if (!destFile.getParentFile().mkdirs()) {
                    // 复制文件失败：创建目标文件所在目录失败
                    return false;
                }
            }
        }

        // 复制文件
        int byteread = 0; // 读取的字节数
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];

            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 复制整个目录的内容
     *
     * @param srcDirName
     *            待复制目录的目录名
     * @param destDirName
     *            目标目录名
     * @param overlay
     *            如果目标目录存在，是否覆盖
     * @return 如果复制成功返回true，否则返回false
     */
    public static boolean copyDirectory(String srcDirName, String destDirName,
                                        boolean overlay) {
        // 判断源目录是否存在
        File srcDir = new File(srcDirName);
        if (!srcDir.exists()) {
            MESSAGE = "复制目录失败：源目录" + srcDirName + "不存在！";
            Log.d(TAG,MESSAGE);
            return false;
        } else if (!srcDir.isDirectory()) {
            MESSAGE = "复制目录失败：" + srcDirName + "不是目录！";
            Log.d(TAG,MESSAGE);
            return false;
        }

        // 如果目标目录名不是以文件分隔符结尾，则加上文件分隔符
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        File destDir = new File(destDirName);
        // 如果目标文件夹存在
        if (destDir.exists()) {
            // 如果允许覆盖则删除已存在的目标目录
            if (overlay) {
                new File(destDirName).delete();
            } else {
                MESSAGE = "复制目录失败：目的目录" + destDirName + "已存在！";
                Log.d(TAG,MESSAGE);
                return false;
            }
        } else {
            // 创建目的目录
            System.out.println("目的目录不存在，准备创建。。。");
            if (!destDir.mkdirs()) {
                System.out.println("复制目录失败：创建目的目录失败！");
                return false;
            }
        }

        boolean flag = true;
        File[] files = srcDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 复制文件
            if (files[i].isFile()) {
                flag = copyFile(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            } else if (files[i].isDirectory()) {
                flag = copyDirectory(files[i].getAbsolutePath(),
                        destDirName + files[i].getName(), overlay);
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            MESSAGE = "复制目录" + srcDirName + "至" + destDirName + "失败！";
            Log.d(TAG,MESSAGE);
            return false;
        } else {
            return true;
        }
    }


}
