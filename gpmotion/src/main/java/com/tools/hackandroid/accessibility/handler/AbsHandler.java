package com.tools.hackandroid.accessibility.handler;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.tools.hackandroid.accessibility.IAccessibilityServiceHandler;
import com.tools.hackandroid.accessibility.util.AccessibilityNodeHelper;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.UIHandler;

import java.util.List;

/**
 * @author zhitao
 * @since 2016-08-04 14:57
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public abstract class AbsHandler implements IAccessibilityServiceHandler {

	private AccessibilityService mAccessibilityService;

	/**
	 * 设置服务
	 *
	 * @param service
	 */
	@Override
	public void setAccessibilityService(AccessibilityService service) {
		mAccessibilityService = service;
	}

	/**
	 * 获取服务
	 *
	 * @return
	 */
	@Override
	public AccessibilityService getAccessibilityService() {
		return mAccessibilityService;
	}

	/**
	 * 输入内容到EditText中
	 *
	 * @param resId EditText的resid
	 * @param text  待输入的内容
	 */
	protected void performInputText(String resId, String text) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		if (nodeInfo == null) {
			return;
		}

		//              List<AccessibilityNodeInfo> list = null;
		//				if (Build.VERSION.SDK_INT >= 18) {
		//                  list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
		//				} else if (Build.VERSION.SDK_INT >= 14) {
		//					list = nodeInfo.findAccessibilityNodeInfosByText()
		//				}

		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
		nodeInfo.recycle();
		DLog.i("resid: %s 有%d个node", resId, list == null ? 0 : list.size());
		if (list == null) {
			return;
		}
		for (AccessibilityNodeInfo item : list) {
			AccessibilityNodeHelper.inputText(getAccessibilityService().getApplicationContext(), item, text);
		}
	}

	/**
	 * 模拟点击,从提供的event中的节点开始查找
	 *
	 * @param event 点击的节点,从节点开始找匹配的子节点
	 * @param resId 组件的资源id
	 */
	protected void performClickByResId(AccessibilityEvent event, String resId) {
		List<AccessibilityNodeInfo> list = event.getSource().findAccessibilityNodeInfosByViewId(resId);
		DLog.i("resid: %s 有%d个node", resId, list == null ? 0 : list.size());
		if (list == null) {
			return;
		}
		for (AccessibilityNodeInfo item : list) {
			item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
		}
	}

	/**
	 * 模拟点击,从当前激活的界面中开始查找
	 *
	 * @param resId 组件的资源id
	 */

	protected void performClickByResId(String resId) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		if (nodeInfo == null) {
			return;
		}
		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
		nodeInfo.recycle();
		DLog.i("resid: %s 有%d个node", resId, list == null ? 0 : list.size());
		if (list == null) {
			return;
		}
		for (AccessibilityNodeInfo item : list) {
			//			if (item.getClassName().equals("android.widget.Button") && item.isEnabled()) {
			//
			//			}
			item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
		}
	}

	/**
	 * 模拟点击,从当前激活的界面中开始查找
	 *
	 * @param text 要点击的按钮之类所用的文字
	 */
	protected void performClickByText(String text) {
		performClickByText(text, null);
	}

	/**
	 * 模拟点击,从当前激活的界面中开始查找
	 *
	 * @param text        要点击的按钮之类所用的文字
	 * @param sourceClass 指定最终的子节点的对象类型 (TextView.class 之类)
	 */
	protected void performClickByText(String text, Class sourceClass) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		if (nodeInfo == null) {
			return;
		}
		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText(text);
		nodeInfo.recycle();
		DLog.i("text: %s 有%d个node", text, list == null ? 0 : list.size());
		if (list == null) {
			return;
		}
		for (AccessibilityNodeInfo item : list) {
			if (sourceClass != null) {
				if (item.getClassName().toString().equals(sourceClass.getName())) {
					item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
				}
			} else {
				item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
			}
		}
	}

	/**
	 * 模拟点击,从提供的event中的节点开始查找
	 *
	 * @param event 点击的节点,从节点开始找匹配的子节点
	 * @param text  要点击的按钮之类所用的文字
	 */
	protected void performClickByText(AccessibilityEvent event, String text) {
		performClickByText(event, text, null);
	}

	/**
	 * 模拟点击,从提供的event中的节点开始查找
	 *
	 * @param event       点击的节点,从节点开始找匹配的子节点
	 * @param text        要点击的按钮之类所用的文字
	 * @param sourceClass 指定最终的子节点的对象类型 (TextView.class 之类)
	 */
	protected void performClickByText(AccessibilityEvent event, String text, Class sourceClass) {
		List<AccessibilityNodeInfo> list = event.getSource().findAccessibilityNodeInfosByText(text);
		DLog.i("text: %s 有%d个node", text, list == null ? 0 : list.size());
		if (list == null) {
			return;
		}
		for (AccessibilityNodeInfo item : list) {
			if (sourceClass != null) {
				if (item.getClassName().toString().equals(sourceClass.getName())) {
					item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
				}
			} else {
				item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
			}
		}
	}

	/**
	 * 获取指定resId所在组件的txt
	 *
	 * @param resId
	 *
	 * @return
	 */
	protected String getText(String resId) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		if (nodeInfo == null) {
			return null;
		}
		List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
		nodeInfo.recycle();
		DLog.i("resid: %s 有%d个node", resId, list == null ? 0 : list.size());
		if (list == null) {
			return null;
		}
		for (AccessibilityNodeInfo item : list) {
			return item.getText() == null ? null : item.getText().toString();
		}
		return null;
	}

	protected List<AccessibilityNodeInfo> getNodeByResIdFromRootInActiveWindow(String resId) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		List<AccessibilityNodeInfo> temp = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
		DLog.i("resid: %s 有%d个node", resId, temp == null ? 0 : temp.size());
		nodeInfo.recycle();
		return temp;
	}

	protected List<AccessibilityNodeInfo> getNodeByTextFromRootInActiveWindow(String text) {
		AccessibilityNodeInfo nodeInfo = getAccessibilityService().getRootInActiveWindow();
		List<AccessibilityNodeInfo> temp = nodeInfo.findAccessibilityNodeInfosByText(text);
		DLog.i("text: %s 有%d个node", text, temp == null ? 0 : temp.size());
		nodeInfo.recycle();
		return temp;
	}

	protected List<AccessibilityNodeInfo> getNodeByResIdFromEventSource(AccessibilityEvent event, String resId) {
		List<AccessibilityNodeInfo> temp = event.getSource().findAccessibilityNodeInfosByViewId(resId);
		DLog.i("resid: %s 有%d个node", resId, temp == null ? 0 : temp.size());
		return temp;
	}

	protected List<AccessibilityNodeInfo> getNodeByTextFromEventSource(AccessibilityEvent event, String text) {
		List<AccessibilityNodeInfo> temp = event.getSource().findAccessibilityNodeInfosByText(text);
		DLog.i("text: %s 有%d个node", text, temp == null ? 0 : temp.size());
		return temp;
	}

	protected void toast(final String format, final Object... args) {
		UIHandler.runInUiThread(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(getAccessibilityService().getApplicationContext(), String.format(format, args), Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
