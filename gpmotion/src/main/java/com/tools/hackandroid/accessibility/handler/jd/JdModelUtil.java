package com.tools.hackandroid.accessibility.handler.jd;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.FileUtil;
import com.tools.hackandroid.util.SelfSpUtil;
import com.tools.hackandroid.util.TimeUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhitao
 * @since 2016-08-05 09:39
 */
public class JdModelUtil {

	private static File getJdModelCacheObjectCache(Context context) {
		return new File(context.getCacheDir(), "JDMODEL.cache");
	}

	public static boolean removeObjectFromCache(Context context) {
		return FileUtil.delete(getJdModelCacheObjectCache(context));
	}

	public static JdModel readObjectFromCache(Context context) {
		if (!getJdModelCacheObjectCache(context).exists()) {
			return null;
		}
		Object obj = FileUtil.readSerializableObjectFromFile(getJdModelCacheObjectCache(context));
		if (obj != null && obj instanceof JdModel) {
			return (JdModel) obj;
		}
		removeObjectFromCache(context);
		return null;
	}

	public static boolean writeObject2Cache(Context context, JdModel jdModel) {
		// 先删除之前的
		removeObjectFromCache(context);
		// 写入新的
		return FileUtil.writeSerializableObject2File(getJdModelCacheObjectCache(context), jdModel);
	}

	public static JdModel newJdModelFromFile(Context context, String fileName) {

		// 从csv解析出需要的内容
		// 读取上一次读取到多少行
		int currentLineNumber = getCurrentUsedPosition(context, fileName);
		int newLineNumber = currentLineNumber + 1;

		// 读取的文件
		File file = getCurrentJdSrcCSVFile(fileName);

		// 读取新的数据
		String newData = FileUtil.getStringFromFileWithSpecLineNumber(file, newLineNumber);
		for (; !TextUtils.isEmpty(newData); newData = FileUtil.getStringFromFileWithSpecLineNumber(file, ++newLineNumber)) {
			// 如果不为空就更新
			// 更新当前读取到多少行
			setCurrentUsedPosition(context, fileName, newLineNumber);

			DLog.i("newdata : %s", newData);
			DLog.i("linenum : %d", newLineNumber);

			// 如果开始是写着商品名就略过
			if (newData.trim().contains("商品名,")) {
				DLog.i("这是第一行内容,跳过");
				continue;
			}

			// 然后检查数据是否为空行
			if (!isEmptyLine(newData)) {
				DLog.i("本行存在内容,直接返回");
				break;
			}
		}
		if (TextUtils.isEmpty(newData)) {
			// 可能已经全部读取完毕了，即数据已经用完，没有返回值，这个时候要提示数据用完了
			setCurrentUsedPosition(context, fileName, -1);
			return null;
		}

		JdModel jdModel = new JdModel();
		jdModel.initFromString(fileName, newData);

		//		JdModel jdModel = new JdModel();
		//		jdModel.productName = "产品11";
		//		jdModel.consignee = "收货人11";
		//		jdModel.phoneNumber = "手机11";
		//		jdModel.address = "地址11";
		//		jdModel.orderId = "订单11";
		//		jdModel.price = "价格11";
		//		jdModel.orderUrl = "购物地址11";
		//		jdModel.accountName = "空洞大风";
		//		jdModel.accountPwd = "226228aa";
		return jdModel;

	}

	private static boolean isEmptyLine(String line) {
		//		// 然后检查数据是否为空行
		//		boolean isEmpty = true;
		//		String[] temp = line.split(",");
		//		for (String str : temp) {
		//			if (!TextUtils.isEmpty(str)) {
		//				isEmpty = false;
		//				break;
		//			}
		//		}
		//		return isEmpty;

		// 全部为"," 并且连续8个以上的","就当为空行
		Pattern pattern = Pattern.compile(",{8,}");
		Matcher matcher = pattern.matcher(line);
		return matcher.matches();
	}

	/**
	 * 获取今天的所有订单csv文件名字
	 *
	 * @return
	 */
	public static String[] getSrcFileNameList() {

		final String date = TimeUtil.getDate("yyyy-MM-dd");
		return new File(Environment.getExternalStorageDirectory(), "123/jd/src").list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				// 格式为 yyyy-MM-dd[-nn]-jd-src.csv的文件
				Pattern pattern = Pattern.compile(String.format("^%s(-\\d{2})?-jd-src.csv", date));
				Matcher matcher = pattern.matcher(filename);
				boolean flag = matcher.matches();
				DLog.i("--文件 %s %s", filename, flag ? "匹配" : "不匹配");
				return flag;
			}
		});
	}

	/**
	 * 获取结果CSV文件列表
	 *
	 * @return
	 */
	public static File[] getResultFileList() {
		final String date = TimeUtil.getDate("yyyy-MM-dd");
		return new File(Environment.getExternalStorageDirectory(), "123/jd/result").listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String filename) {
				// 格式为 yyyy-MM-dd[-nn]-jd-src.csv的文件
				Pattern pattern = Pattern.compile(String.format("^%s(-\\d{2})?-jd-result.csv", date));
				Matcher matcher = pattern.matcher(filename);
				boolean flag = matcher.matches();
				DLog.i("--文件 %s %s", filename, flag ? "匹配" : "不匹配");
				return flag;
			}
		});
	}

	/**
	 * 设置今天当前使用的JD订单文件
	 *
	 * @return
	 */
	public static void setCurrentUsedJDFileName(Context context, String fileName) {
		SelfSpUtil.putString(context, "jd_" + TimeUtil.getDate("yyyy-MM-dd"), fileName);
	}

	/**
	 * 获取今天当前使用的JD订单文件
	 *
	 * @param context
	 *
	 * @return
	 */
	public static String getCurrentUsedJDFileName(Context context) {
		return SelfSpUtil.getString(context, "jd_" + TimeUtil.getDate("yyyy-MM-dd"), null);
	}

	/**
	 * 设置指定的jd文件当前读取到的位置
	 *
	 * @param fileName
	 *
	 * @return
	 */
	public static void setCurrentUsedPosition(Context context, String fileName, int pos) {
		SelfSpUtil.putInt(context, fileName, pos);
	}

	/**
	 * 获取指定的jd文件当前读取到的位置
	 *
	 * @param fileName
	 *
	 * @return
	 */
	public static int getCurrentUsedPosition(Context context, String fileName) {
		return SelfSpUtil.getInt(context, fileName, 0);
	}

	/**
	 * 获取当前使用的CSV订单文件
	 *
	 * @param fileName
	 *
	 * @return
	 */
	public static File getCurrentJdSrcCSVFile(String fileName) {
		return new File(Environment.getExternalStorageDirectory(), String.format("123/jd/src/%s", fileName));
	}

	/**
	 * 获取当前保存使用的CSV订单结果文件
	 *
	 * @param fileName
	 *
	 * @return
	 */
	public static File getCurrentJdResultCSVFile(String fileName) {
		return new File(Environment.getExternalStorageDirectory(), String.format("123/jd/result/%s", fileName));
	}

	//	/**
	//	 * 从原始数据中复制一份到目标数据
	//	 *
	//	 * @return
	//	 */
	//	public static boolean initResultFile() {
	//		ArrayList<String> list = FileUtil.getAllLineStringFromFile(getCurrentJdSrcCSVFile());
	//		return FileUtil.writeList2File(getCurrentJdResultCSVFile(), list);
	//	}
}
