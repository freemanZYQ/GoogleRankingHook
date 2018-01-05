package com.tools.hackandroid.accessibility.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

import com.tools.hackandroid.util.ClipboardManagerUtil;

/**
 * Node 节点助手
 *
 * @author zhitao
 * @since 2016-08-04 12:02
 */
public class AccessibilityNodeHelper {

	/**
	 * 向指定的节点输入文字
	 *
	 * @param context
	 * @param node
	 * @param text
	 *
	 * @return
	 *
	 * @since api 18
	 */
	public static boolean inputText(Context context, AccessibilityNodeInfo node, String text) {
		if (Build.VERSION.SDK_INT >= 21) {
			//android>=21 = 5.0时可以用ACTION_SET_TEXT

			Bundle arg = new Bundle();
			arg.putString(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, text);
			return node.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arg);
		} else if (Build.VERSION.SDK_INT >= 18) {

			//android>=18 可以通过复制的手段,先确定焦点，再粘贴ACTION_PASTE
			// 选择一整页，然后粘贴我们的内容，算是一种绕路吧

			// 默认粘贴是仅仅append到edittext,所以我们需要清空原有的内容先,但是没有方法,所以我们只能绕路,将当前所有的文字选择在粘贴,算是一种清空(替换)方案
			Bundle arguments = new Bundle();
			arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
					AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PAGE);
			arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN, true);
			node.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY, arguments);

			ClipboardManagerUtil.setText(context, text);
			node.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
			return node.performAction(AccessibilityNodeInfo.ACTION_PASTE);
		}
		return false;
	}
	
}
