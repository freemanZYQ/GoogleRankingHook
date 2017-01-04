package com.ndk.test;

import android.text.TextUtils;

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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/12/8.
 */
public class FileUtils {

    public static  byte[] readStreamToEnd(final InputStream is) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        if (is != null) {
            final byte[] buff = new byte[1024];
            int read;
            do {
                bos.write(buff, 0, (read = is.read(buff)) < 0 ? 0 : read);
            } while (read >= 0);
            is.close();
        }
        return bos.toByteArray();
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
}
