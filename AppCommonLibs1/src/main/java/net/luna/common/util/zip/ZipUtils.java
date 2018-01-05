package net.luna.common.util.zip;

import java.io.File;

/**
 * 考虑到sdk大小，这里没有是用zip4j，采用的是jdk里面的zip
 * <p>
 * 因此不支持中文，也不支持密码
 * 
 * @author zhitaocai
 * @since 2014-10-30上午9:15:21
 */
public class ZipUtils {

	/**
	 * （同步）在当前线程中进行解压缩，压缩成功之后，解压缩存放的目录为{$destDir/zipFile.getName()}
	 * <p>
	 * 使用时请注意启用线程
	 * 
	 * @param zipFile
	 *            zip文件
	 * @param destDirPath
	 *            解压后存放的路径 e.g. 如果传入的是"/storage/sdcard0"，那么
	 * @param unZiplistener
	 *            解压缩监听器，支持开始，进行，完成，错误的回调
	 * @return
	 */
	public final static void sync_unZip(File zipFile, String destDirPath, Interface_UnZipListener unZiplistener,
			boolean isCallBackInUiThread) {
		new UnZip(zipFile, destDirPath, unZiplistener, isCallBackInUiThread).unZip();
	}

	/**
	 * （同步）在当前线程中进行解压缩，压缩成功之后，解压缩存放的目录为{$destDir/zipFile.getName()}
	 * <p>
	 * 使用时请注意启用线程
	 * 
	 * @param zipFile
	 *            zip文件
	 * @param destDirPath
	 *            解压后存放的路径 e.g. 如果传入的是"/storage/sdcard0"，那么
	 * @return
	 */
	public final static boolean sync_unZip(File zipFile, String destDirPath) {
		return new UnZip(zipFile, destDirPath, null, false).unZip();
	}

}
