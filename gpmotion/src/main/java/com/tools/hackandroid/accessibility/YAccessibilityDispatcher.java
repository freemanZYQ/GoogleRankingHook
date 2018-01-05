package com.tools.hackandroid.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

import com.tools.hackandroid.BuildConfig;
import com.tools.hackandroid.Constants;
import com.tools.hackandroid.accessibility.handler.gp.GooglePlayHandler;
import com.tools.hackandroid.accessibility.handler.suning.SNHandler;
import com.tools.hackandroid.util.DLog;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 辅助功能事件分发器
 *
 * @author zhitao
 * @since 2016-08-03 17:27
 */
public class YAccessibilityDispatcher extends AccessibilityService {

    /**
     * 主要用来输出log
     * <p/>
     * key : eventType
     * value : eventTypeDesc
     */
    private static SparseArray<String> sEventNameArray;

    /**
     * 支持的子业务
     * <p/>
     * * 苏宁激活
     */
    private static DispatcherModel[] sHandlerArray = new DispatcherModel[]{
//			new DispatcherModel(Constants.PKG_NAME_JD, new JdHandler()),
//            new DispatcherModel(Constants.PKG_NAME_SUNING, new SNHandler()),
            //			new DispatcherModel("com.android.settings", new AndroidSettingsHandler())
            new DispatcherModel("com.google.android.gms",new GooglePlayHandler())

    };

    /**
     * This method is a part of the {@link AccessibilityService} lifecycle and is
     * called after the system has successfully bound to the service. If is
     * convenient to use this method for setting the {@link AccessibilityServiceInfo}.
     *
     * @see AccessibilityServiceInfo
     * @see #setServiceInfo(AccessibilityServiceInfo)
     */
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        // 可以通过<meta-data>配置服务相关信息
        // 也可以在这里通过setServiceInfo(AccessibilityServiceInfo)为其配置信息
        // 除此之外,通过该方法可以在运行期间动态修改服务配置.需要注意,该方法只能用来配置动态属性:
        // eventTypes,　feedbackType,　flags,　notificaionTimeout, packageNames

        // accessibilityEventTypes:表示该服务对界面中的哪些变化感兴趣,即哪些事件通知,比如窗口打开,滑动,焦点变化,长按等.具体的值可以在AccessibilityEvent类中查到,
        // 如typeAllMask表示接受所有的事件通知.
        // accessibilityFeedbackType:表示反馈方式,比如是语音播放,还是震动
        // canRetrieveWindowContent:表示该服务能否访问活动窗口中的内容.也就是如果你希望在服务中获取窗体内容的化,则需要设置其值为true.
        // notificationTimeout:接受事件的时间间隔,通常将其设置为100即可.
        // packageNames:表示对该服务是用来监听哪个包的产生的事件

        AccessibilityServiceInfo serviceInfo = new AccessibilityServiceInfo();
        serviceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        ArrayList<String> targetPkgList = new ArrayList<>();
        targetPkgList.add(BuildConfig.APPLICATION_ID);
        for (DispatcherModel model : sHandlerArray) {
            targetPkgList.add(model.pkgName);
        }
        serviceInfo.packageNames = targetPkgList.toArray(new String[targetPkgList.size()]);
        serviceInfo.notificationTimeout = 100;
        setServiceInfo(serviceInfo);

        // 初始化并下发通知各个业务
        DLog.i(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        DLog.i("onServiceConnected");
        for (String str : serviceInfo.packageNames) {
            DLog.i("  support : %s", str);
        }

        for (DispatcherModel temp : sHandlerArray) {
            temp.handler.setAccessibilityService(this);
            temp.handler.onServiceConnected();
        }
    }

    /**
     * Callback for interrupting the accessibility feedback.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onInterrupt() {

        DLog.e(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        DLog.e("onInterrupt");

        // 分发到各个子业务中进行处理
        for (DispatcherModel temp : sHandlerArray) {
            temp.handler.onInterrupt();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            // 返回桌面
            performGlobalAction(GLOBAL_ACTION_HOME);
        }
        Toast.makeText(getApplicationContext(), "hackandroid辅助服务已经中断", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }

//		DLog.i("-------------------------------------------------------------");
//		DLog.i("包名: %s\n事件源类名: %s\n事件类型描述: %s\n事件类型: %d\n事件源: %s", event.getPackageName(), event.getClassName(),
//				getEventTypeNameByTypeId(event.getEventType()), event.getEventType(), event.getSource());

        // 分发到各个子业务中进行处理
        for (DispatcherModel temp : sHandlerArray) {
            if (event.getPackageName().equals(temp.pkgName)) {
                temp.handler.onAccessibilityEvent(event);
                break;
            }
        }

        

    }

    private String getEventTypeNameByTypeId(int typeId) {
        if (sEventNameArray == null) {
            sEventNameArray = new SparseArray<>();
            Field[] fields = AccessibilityEvent.class.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isPublic(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) &&
                        Modifier.isFinal(field.getModifiers()) && field.getName().startsWith("TYPE_")) {
                    try {
                        sEventNameArray.put(field.getInt(AccessibilityEvent.class), field.getName());
                    } catch (Exception e) {
                        DLog.i(e);
                    }
                }
            }
        }
        return sEventNameArray.get(typeId);
    }

    public static class DispatcherModel {

        String pkgName;

        IAccessibilityServiceHandler handler;

        public DispatcherModel(String pkgName, IAccessibilityServiceHandler handler) {
            this.handler = handler;
            this.pkgName = pkgName;
        }
    }
}


