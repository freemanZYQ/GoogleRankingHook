package com.tools.hackandroid.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;

/**
 * {@link YAccessibilityDispatcher} 分发器分发出来的各个通知都有这个接口去完成,即新的业务必须实现这个接口,然后在 {@link YAccessibilityDispatcher} 中注册即可
 *
 * @author zhitao
 * @since 2016-08-04 10:59
 */
public interface IAccessibilityServiceHandler {

	/**
	 * 设置服务
	 *
	 * @param service
	 */
	void setAccessibilityService(AccessibilityService service);

	/**
	 * 获取服务
	 *
	 * @return
	 */
	AccessibilityService getAccessibilityService();

	/**
	 * This method is a part of the {@link AccessibilityService} lifecycle and is
	 * called after the system has successfully bound to the service. If is
	 * convenient to use this method for setting the {@link AccessibilityServiceInfo}.
	 *
	 * @see AccessibilityServiceInfo
	 * @see #setServiceInfo(AccessibilityServiceInfo)
	 */
	void onServiceConnected();

	void onInterrupt();

	void onAccessibilityEvent(AccessibilityEvent event);
}
