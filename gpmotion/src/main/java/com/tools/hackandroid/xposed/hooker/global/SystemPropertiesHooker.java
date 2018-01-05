package com.tools.hackandroid.xposed.hooker.global;

import android.content.ContentResolver;

import com.tools.hackandroid.sp.SystemPropertiesSp;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.xposed.hooker.core.AbsHooker;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 没有支持部分api 23的参数
 */
class SystemPropertiesHooker extends AbsHooker<SystemPropertiesSp> {

    /**
     * 返回这个Hook所用的SharePreferencesde的管理类
     *
     * @return
     */
    @Override
    protected SystemPropertiesSp initSp() {
        return new SystemPropertiesSp();
    }

    /**
     * 实现需要hook的各种方法，静态变量等等的钩子
     *
     * @param lpparam Information about the hook app.
     */
    @Override
    protected void handleHook(XC_LoadPackage.LoadPackageParam lpparam) {

        findAndHookMethod(SystemPropertiesSp.HOOK_CLASS_NAME, lpparam.classLoader, "get", String.class, this);
        findAndHookMethod(SystemPropertiesSp.HOOK_CLASS_NAME, lpparam.classLoader, "get", String.class, String.class, this);
        findAndHookMethod(SystemPropertiesSp.HOOK_CLASS_NAME, lpparam.classLoader, "getInt", String.class, int.class, this);
        findAndHookMethod(SystemPropertiesSp.HOOK_CLASS_NAME_FOR_SETTING_SECURE, lpparam.classLoader, "getString", ContentResolver.class, String.class, this);
        findAndHookMethod(SystemPropertiesSp.HOOK_CLASS_NAME_FOR_SETTING_SYSTEM, lpparam.classLoader, "getString", ContentResolver.class, String.class, this);

        //		XposedHelpers.findAndHookMethod(HOOK_CLASS_NAME, lpparam.classLoader, "getLong", String.class, long.class, this);
        //		XposedHelpers.findAndHookMethod(HOOK_CLASS_NAME, lpparam.classLoader, "getBoolean", String.class, boolean.class,
        // this);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);

        String method = param.method.getName();
        switch (method) {
//            case "getString":
//                setStringResult(param, SystemPropertiesSp.RO_SETTING_ANDID);
//                break;
            case "get":
                switch (param.args[0].toString()) {
                    case SystemPropertiesSp.RO_PRODUCT_NAME:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_NAME);
                        break;
                    case SystemPropertiesSp.RO_PRODUCT_MODEL:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_MODEL);
                        break;
                    case SystemPropertiesSp.RO_PRODUCT_BRAND:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_BRAND);
                        break;
                    case SystemPropertiesSp.RO_PRODUCT_BOARD:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_BOARD);
                        break;
                    case SystemPropertiesSp.RO_PRODUCT_DEVICE:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_DEVICE);
                        break;
                    case SystemPropertiesSp.RO_PRODUCT_MANUFACTURER:
                        setStringResult(param, SystemPropertiesSp.RO_PRODUCT_MANUFACTURER);
                        break;
                    case SystemPropertiesSp.RO_BUILD_FINGERPRINT:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_FINGERPRINT);
                        break;
                    case SystemPropertiesSp.RO_BUILD_VERSION_INCREMENTAL:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_VERSION_INCREMENTAL);
                        break;
                    case SystemPropertiesSp.RO_BUILD_VERSION_RELEASE:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_VERSION_RELEASE);
                        break;
                    case SystemPropertiesSp.RO_BUILD_ID:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_ID);
                        break;
                    case SystemPropertiesSp.RO_BUILD_DISPLAY_ID:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_DISPLAY_ID);
                        break;
                    case SystemPropertiesSp.RO_BOOTLOADER:
                        setStringResult(param, SystemPropertiesSp.RO_BOOTLOADER);
                        break;
                    case SystemPropertiesSp.RO_HARDWARE:
                        setStringResult(param, SystemPropertiesSp.RO_HARDWARE);
                        break;
                    case SystemPropertiesSp.RO_SERIALNO:
                        setStringResult(param, SystemPropertiesSp.RO_SERIALNO);
                        break;
                    case SystemPropertiesSp.RO_BUILD_VERSION_CODENAME:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_VERSION_CODENAME);
                        break;
                    case SystemPropertiesSp.RO_BUILD_TYPE:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_TYPE);
                        break;
                    case SystemPropertiesSp.RO_BUILD_TAGS:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_TAGS);
                        break;
                    case SystemPropertiesSp.RO_BUILD_USER:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_USER);
                        break;
                    case SystemPropertiesSp.RO_BUILD_HOST:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_HOST);
                        break;
                    case SystemPropertiesSp.RO_BUILD_DATE_TIME:
                        setStringResult(param, SystemPropertiesSp.RO_BUILD_DATE_TIME);
                        break;
                }
                break;
            case "getInt":
                switch (param.args[0].toString()) {
                    case SystemPropertiesSp.RO_BUILD_VERSION_SDK:
                        setIntResult(param, SystemPropertiesSp.RO_BUILD_VERSION_SDK);
                        break;
                }

        }

    }
}
