package com.tools.hackandroid.tv;

import net.luna.common.debug.LunaLog;

import de.robv.android.xposed.XC_MethodHook;

/**
 * @author zhengyuqin
 * @since 18/1/4 18:00:00
 */

public class IqiyiAdHooker extends XC_MethodHook {

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        String methodName = param.method.getName();
        try {
            switch (methodName) {
                case "GetADSDKInfo":
                case "GetDomain":
                case "AdCommand":
                case "GetAdCountDown":
                case "GetLog":
                    if (param.args != null && param.args.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(methodName + ":");
                        for (int i = 0; i < param.args.length; i++) {
                            if (sb.length() > 0) {
                                sb.append(":");
                            }
                            sb.append(param.args[i]);
                        }
                        LunaLog.d(sb.toString());
                    }
                    break;
            }
        }catch (Exception e){
            LunaLog.e(methodName+" beforeRun失败");
        }
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        String methodName = param.method.getName();
        try {
            switch (methodName) {
                case "GetADSDKInfo":
                case "GetDomain":
                case "AdCommand":
                case "GetAdCountDown":
                case "GetLog":
                    if (param.getResult() != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(methodName + " result:");
                        sb.append(String.valueOf(param.getResult()));
                        LunaLog.d(sb.toString());
                    }
                    break;

            }
        }catch (Exception e){
            LunaLog.e(methodName+" hookResult失败");
        }
    }
}
