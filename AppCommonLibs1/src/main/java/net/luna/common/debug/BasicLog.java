package net.luna.common.debug;

import android.util.Log;

import java.util.Locale;

/**
 * log 基本输出类 使用注意事项
 * <hr>
 * 1、如果是测试时打印的log应该是调用这个类的方法<br>
 * 2、如果是给给开发者的log提示的话应该是继承这个类来实现跟更丰富的log
 * 
 * @author zhitaocai create on 2014-7-10
 */
public class BasicLog {

	/**
	 * 是否显示log 正式版发布务必为 true
	 */
	protected static boolean mIsEnableLog = true;

	/**
	 * 打印log
	 */
	protected synchronized static void printLog(int level, String tag, Throwable tr, String msg, Object... args) {
		if (mIsEnableLog) {
			try {
				if (tag == null || "".equals(tag.trim())) {
					// if (tag == null || 0 == tag.trim().length()) {
					tag = "debug";
				}
				if (args.length != 0) {
					msg = String.format(Locale.getDefault(), msg, args);
				}
				switch (level) {
				case Log.DEBUG:
					Log.d(tag, msg, tr);
					break;
				case Log.ERROR:
					Log.e(tag, msg, tr);
					break;
				case Log.INFO:
					Log.i(tag, msg, tr);
					break;
				case Log.WARN:
					Log.w(tag, msg, tr);
					break;
				default:
					Log.v(tag, msg, tr);
					break;
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 打印log 调用时的详细信息
	 * 
	 * @param invokeInfoColor
	 *            显示log详细信息的文字的颜色
	 *            <ul>
	 *            <li>{@code Log.DEBUG} : 蓝色</li>
	 *            <li>{@code Log.ERROR} : 红色</li>
	 *            <li>{@code Log.INFO} : 绿色</li>
	 *            <li>{@code Log.VERBOSE} : 黑色</li>
	 *            <li>{@code Log.WARN} : 黄色</li>
	 *            </ul>
	 * @param tag
	 */
	protected synchronized static void printInvokeInfo(int invokeInfoColor, String tag) {
		if (mIsEnableLog) {
			try {
				StackTraceElement[] elements = Thread.currentThread().getStackTrace();
				if (elements.length > 5) {
					StackTraceElement element = elements[5];
					String txt = String.format("FileName:[ %s ] Method:( %s )  Line:( %d )", element.getFileName(),
							element.getMethodName(), element.getLineNumber());
					// String txt = String.format("Time:[ %d ] Thread:[ %d ] Method:( %s ) FileName:[ %s ] Line:( %d )",
					// System.currentTimeMillis(), Thread.currentThread().getId(), element.getMethodName(),
					// element.getFileName(), element.getLineNumber());
					printLog(invokeInfoColor, tag, null, txt);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	// /**
	// * 获取当前类的名称
	// *
	// * @param object
	// * 当前类对象，一般为this指针，若是静态类，请传递静态类class
	// * @return
	// */
	// protected synchronized static String getClassNameForTag(Object object) {
	// return object.getClass().getSimpleName();
	// }

	/**
	 * 获取最后的tag
	 * 
	 * @param preTag
	 *            模块的tag
	 * @param object
	 *            模块里面的某个类对象，传入可以是this指针，若是静态类，请传递静态类class
	 * @return
	 */
	protected synchronized static String getFinalTag(String preTag, Object object) {
		if (object instanceof Class) {
			return preTag + ((Class) object).getSimpleName();
		} else {
			return preTag + object.getClass().getSimpleName();
		}
	}

	/**
	 * 获取调用时的方法名
	 * 
	 * @return
	 */
	protected synchronized static String getMethodName() {
		final Thread current = Thread.currentThread();
		final StackTraceElement trace = current.getStackTrace()[4];
		return trace.getMethodName();
	}

	protected synchronized static String getLogText(String methodName, Object... params) {

		if (mIsEnableLog) {
			try {
				final StringBuilder sb = new StringBuilder();
				sb.append(methodName).append(":\t");
				for (int i = 0, size = params.length; i < size; i++) {
					final Object obj = params[i];
					sb.append('[').append(obj).append("]");
					if (i != size - 1) {
						sb.append(", ");
					}
				}
				return sb.toString();
			} catch (Throwable e) {
				e.printStackTrace();

			}
		}
		return null;
	}
}
