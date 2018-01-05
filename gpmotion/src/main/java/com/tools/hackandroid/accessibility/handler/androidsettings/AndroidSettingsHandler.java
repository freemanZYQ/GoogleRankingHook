package com.tools.hackandroid.accessibility.handler.androidsettings;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

import com.tools.hackandroid.accessibility.handler.AbsHandler;
import com.tools.hackandroid.accessibility.handler.jd.JDView;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.IntentUtil;
import com.tools.hackandroid.util.PackageUtil;
import com.tools.hackandroid.util.UIHandler;

import java.util.List;

/**
 * 支持清空应用数据, Android 原声系统 18 ~ 19 4.4.4
 *
 * @author zhitao
 * @since 2016-08-08 16:02
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class AndroidSettingsHandler extends AbsHandler {

    /**
     * This method is a part of the {@link AccessibilityService} lifecycle and is
     * called after the system has successfully bound to the service. If is
     * convenient to use this method for setting the {@link AccessibilityServiceInfo}.
     *
     * @see AccessibilityServiceInfo
     * @see #setServiceInfo(AccessibilityServiceInfo)
     */
    @Override
    public void onServiceConnected() {

    }

    @Override
    public void onInterrupt() {

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        //		mJdModel = JdModelUtil.readObjectFromCache(getAccessibilityService().getApplicationContext());
        //		if (mJdModel == null) {
        //			return;
        //		}

        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                switch (event.getClassName().toString()) {

                    // 清除数据完毕之后就返回到桌面,然后打开指定的app
                    case "com.android.settings.applications.InstalledAppDetailsTop":
//				goHomeAndStartApp(Constants.PKG_NAME_JD);
                        break;
                    // 在弹出来的对话框中,点击确定清除数据
                    case "android.app.AlertDialog":
                        confirmDelete();
                        break;
                }
                break;
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                switch (event.getClassName().toString()) {
                    // 打开设置页面的时候,会开始计算该应用占用多少空间,完毕就会更新内容,回调textview更新
                    case "android.widget.TextView":
                        // 针对京东处理
                        performClickClearDataBtn("手机京东");
                        break;
                }
                break;
        }
    }

    /**
     * 点击清除数据按钮
     *
     * @param appNames 因为每个应用的设置页面都是相同的,所有需要用app名字来区分究竟是哪个应用的设置页面
     */
    private void performClickClearDataBtn(String... appNames) {
        if (appNames == null || appNames.length == 0) {
            return;
        }
        for (String appName : appNames) {
            if (appName.equals(getText("com.android.settings:id/app_name")) &&
                    "com.android.settings.applications.InstalledAppDetails"
                            .equals(PackageUtil.getTopActivityNameBelowAndroidL(getAccessibilityService().getApplicationContext())
                            )) {
                String versionName = getText("com.android.settings:id/app_size");
                DLog.i("当前京东版本名: %s", versionName);
                if (!TextUtils.isEmpty(versionName)) {
                    String[] temp = versionName.trim().split(" ");
                    versionName = temp[temp.length - 1];
                    // 使用指定版本jd的viewid
                    JDView.initResByAPPVersionName(versionName);
                }

                List<AccessibilityNodeInfo> list = getNodeByTextFromRootInActiveWindow("清除数据");
                DLog.i("text: %s 有%d个node", "清除数据", list == null ? 0 : list.size());
                if (list == null || list.isEmpty()) {
                    return;
                }
                if (list.get(0).getClassName().toString().equals(Button.class.getName()) && list.get(0).isEnabled()) {
                    list.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    /**
     * 在弹出的对话框中点击确定
     */
    private void confirmDelete() {
        String title = getText("android:id/alertTitle");
        String msg = getText("android:id/message");
        String positiveBtnText = getText("android:id/button1");
        if ("要删除应用数据吗？".equals(title) &&
                "系统会永久删除此应用的所有数据。删除的内容包括所有文件、设置、帐户、数据库等。".equals(msg) && "确定".equals(positiveBtnText)) {
            performClickByText("确定");
        }
    }

    /**
     * 清除数据完毕之后就返回到桌面,然后打开指定的app
     */
    private void goHomeAndStartApp(final String pkgName) {

        List<AccessibilityNodeInfo> clearDataNodeList = getNodeByTextFromRootInActiveWindow("清除数据");
        List<AccessibilityNodeInfo> clearCacheNodeList = getNodeByTextFromRootInActiveWindow("清除缓存");

        if (clearCacheNodeList == null || clearCacheNodeList.isEmpty() || clearDataNodeList == null ||
                clearDataNodeList.isEmpty()) {
            return;
        }

        //  如果两个按钮都不能点击的话,就标识已经清空所有数据了,进行跳转
        if (!clearCacheNodeList.get(0).isEnabled() && !clearDataNodeList.get(0).isEnabled()) {

            getAccessibilityService().performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
            DLog.i("点击了返回");

            getAccessibilityService().performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME);
            DLog.i("点击了主页");

            // 延迟1秒打开,有时即时打开是不行的
            UIHandler.runInUiThread(new Runnable() {
                @Override
                public void run() {
                    IntentUtil.startActivityByPackageName(getAccessibilityService().getApplicationContext(), pkgName);
                    DLog.i("开始打开 %s", pkgName);
                }
            }, 1000);
        }
    }

}
