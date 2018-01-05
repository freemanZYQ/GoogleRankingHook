package com.tools.hackandroid.tv;

import net.luna.common.debug.LunaLog;

import java.util.Arrays;

import de.robv.android.xposed.XC_MethodHook;

/**
 * @author zhengyuqin
 * @since 18/1/3 11:00:00
 */

public class MiuiSystemAdHooker extends XC_MethodHook {

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        try {

            String methodName = param.method.getName();
            LunaLog.d("beforeHookedMethod:" + methodName);
            switch (methodName) {
                case "b":
                case "c":
                case "d":
                case "e":
                case "a":
                    if (param.args != null && param.args.length > 0) {
                        StringBuilder sb = new StringBuilder();
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
            LunaLog.e(e);
        }
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        String methodName = param.method.getName();

        try {
            LunaLog.d("afterHookedMethod:" + methodName);
            switch (methodName) {
                case "a":
                    if (param.args != null && param.args.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < param.args.length; i++) {
                            if (sb.length() > 0) {
                                sb.append(":");
                            }
                            sb.append(param.args[i]);
                        }
                        LunaLog.d("after params:" + sb.toString());
                    }
                case "b":
                case "c":
                case "d":
                case "e":
                    LunaLog.d("result:" + param.getResult());
                    break;

            }
        }catch (Exception e){
            LunaLog.e(e);
        }
    }
}
