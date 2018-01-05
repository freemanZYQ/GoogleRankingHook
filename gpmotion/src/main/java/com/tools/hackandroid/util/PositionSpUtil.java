package com.tools.hackandroid.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author zhitao
 * @since 2016-08-05 09:56
 */
public class PositionSpUtil {

	/**
	 * 保存自身应用的一些数据
	 */
	private static SharedPreferences mModuleSp;

	private static SharedPreferences.Editor mModuleSpEditor;

	private static void initSp(Context context) {
		if (mModuleSp == null) {
			mModuleSp = context.getApplicationContext().getSharedPreferences("position", Context.MODE_PRIVATE);
		}
	}

	private static void initSpEditor(Context context) {
		initSp(context);
		mModuleSpEditor = mModuleSp.edit();
	}

	public static int getInt(Context context, String key, int defValue) {
		initSp(context);
		return mModuleSp.getInt(key, defValue);
	}

	public static void putInt(Context context, String key, int value) {
		initSpEditor(context);
		mModuleSpEditor.putInt(key, value);
		mModuleSpEditor.apply();
	}

	public static String getString(Context context, String key, String defValue) {
		initSp(context);
		return mModuleSp.getString(key, defValue);
	}

	public static void putString(Context context, String key, String value) {
		initSpEditor(context);
		mModuleSpEditor.putString(key, value);
		mModuleSpEditor.apply();
	}

}
