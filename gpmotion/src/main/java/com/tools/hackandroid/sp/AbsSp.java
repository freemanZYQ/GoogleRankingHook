package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;

/**
 * 每个钩子类设计到Android原生的{@link SharedPreferences} 以及 xposed 的 {@link XSharedPreferences}，
 * <p/>
 * <b>注意</b>
 * <p/>
 * <ol>
 * <li>在读写原生的 {@link SharedPreferences} 时，必须要设置为全局可读 {@link Context#MODE_WORLD_READABLE}，如果设置为 {@link Context#MODE_PRIVATE},
 * 那么只能在 {@link IXposedHookZygoteInit#initZygote(IXposedHookZygoteInit.StartupParam)
 * }的时候进行标记可读，但是一旦这个文件被重新读写，就不能reload了，十分不友好</li>
 * <li>内部封装好了 {@link XSharedPreferences}的使用，只对外提供 {@link SharedPreferences}，方便外部填入数据之类的</li>
 * </ol>
 * <p/>
 * //TODO 以后有空实现每个sp文件或者定义很多个sp_{$data}保存所有的替换历史记录
 */
public abstract class AbsSp {

	private SharedPreferences mSp;

	public SharedPreferences getSharedPreferences(Context context) {
		if (mSp == null) {
			mSp = context.getApplicationContext().getSharedPreferences(getSharedPreferencesName(), Context.MODE_WORLD_READABLE);
		}
		return mSp;
	}

	/**
	 * 初始化随机数据
	 */
	public void initRandomData(Context context) {
		resetSpFile();
		inputRandomData(context, getSharedPreferences(context));
	}

	/**
	 * 初始化测试数据
	 *
	 * @param context
	 */
	public void initTestData(Context context) {
		resetSpFile();
		inputTestData(context, getSharedPreferences(context));
	}

	/**
	 * 从StringArray中初始化模拟数据
	 *
	 * @param context
	 * @param keyValueStringArray e.g new String [] {"key1=value1", "key2=value2", "key3=value3"}
	 */
	public void initDataFromKeyValueStringArray(Context context, String[] keyValueStringArray) {
		resetSpFile();
		inputDataFromKeyValueStringArray(context, getSharedPreferences(context), keyValueStringArray);
	}

	private void resetSpFile() {
		if (mSp != null) {
			SharedPreferences.Editor mSpEditor = mSp.edit();
			for (String key : mSp.getAll().keySet()) {
				mSpEditor.remove(key);
			}
			mSpEditor.apply();
		}
	}

	/**
	 * 保存本类的sp文件的名字
	 *
	 * @return
	 */
	public abstract String getSharedPreferencesName();

	/**
	 * 输入测试数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	protected abstract void inputTestData(Context context, SharedPreferences sharedPreferences);

	/**
	 * 输入随机数据
	 *
	 * @param context
	 * @param sharedPreferences 数据所保存到的sp文件
	 */
	protected abstract void inputRandomData(Context context, SharedPreferences sharedPreferences);

	/**
	 * 输入指定的数组数据
	 *
	 * @param context
	 * @param sharedPreferences   数据所保存到的sp文件
	 * @param keyValueStringArray e.g new String [] {"key1=value1", "key2=value2", "key3=value3"}
	 */
	protected abstract void inputDataFromKeyValueStringArray(Context context, SharedPreferences sharedPreferences,
			String[] keyValueStringArray);
}
