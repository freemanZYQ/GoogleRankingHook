package com.tools.hackandroid.gp;

import android.app.AndroidAppHelper;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import net.luna.common.debug.LunaLog;

import de.robv.android.xposed.XC_MethodHook;

public class GMSHooker extends XC_MethodHook {


    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        String methodName = param.method.getName();
        LunaLog.d("beforeHookedMethod:"+methodName);
        switch (methodName) {
        }
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        String methodName = param.method.getName();
        LunaLog.d("afterHookedMethod: " + methodName);
        switch (methodName) {
            case "loadUrl":
                LunaLog.d("===========GMS load url finish: " + param.args[0]);
                break;
            case "postUrl":
                LunaLog.d("===========GMS post url finish: "+param.args[0]);
                break;
            case "onPageFinished":
                LunaLog.d("===========GMS on page finish: " + param.args[1]);
                String address = param.args[1].toString();
                int step = -1;
//                if (address.startsWith("https://accounts.google.com/embedded/setup/")) {
//                    if (address.split("#").length > 1) {
//                        String suffix = address.split("#")[1];
//                        LunaLog.d("===========================gms=================: " + suffix);
//
//
//                        switch (suffix) {
//                            case "identifier":
//                                step = 0;
//                                break;
//                            case "challengepassword":
//                                step = 1;
//                                break;
//                            case "createaccount":
//                                step = 1;
//                                break;
//                            case "idvbyphone":
//                                step = 2;
//                                break;
//                            case "idvreenablesend":
//                                step = 2;
//                                break;
//                            case "idvreenableverify":
//                                step = 3;
//                                break;
//                            case "verifyidvphone":
//                                step = 3;
//                                break;
//
////                            case "challengeidvanyphonecollect":
////                                step = 15;
////                                break;
////                            case "challengeidvanyphoneverify":
////                                step = 16;
////                                break;
//
//                            case "createusername":
//                                step = 4;
//                                break;
//
//                            case "createpassword":
//                                step = 5;
//                                break;
//
//                            case "addrecoveryphone":
//                                step = 6;
//                                break;
//
//                            case "signinconsent":
//                                step = 7;
//                                break;
//
//                            case "termsofservice":
//                                step = 7;
//                                break;
//
//                            case "done":
//                                step = 8;
//                                break;
//
//                            case "close":
//                                step = 9;
//                                break;
//                            case "challengeknowledgeloginlocation":
//                                step = 12;
//                                break;
//                            case "unknownerror":
//                            case "sessionexpired":
//                                step = 10;
//                                break;
//                            default:
//                                LunaLog.d("can not find page");
//                                step = 14;
//                                break;
//                        }
//                    } else {
//                        step = 14;
//                    }
//
//                    if (step != -1) {
//                        Intent intent = new Intent();
//                        intent.putExtra("lollipop_web_step", step);
//                        ClipboardManager clipboard = (ClipboardManager) AndroidAppHelper.currentApplication()
//                                .getSystemService(Context.CLIPBOARD_SERVICE);
//                        ClipData clip = ClipData.newIntent("intent", intent);
//                        clipboard.setPrimaryClip(clip);
//                    }
//
//                    Log.v("vcode", "^^^^^^^^^^^^^^^^^^^^^^^^^^gms^^^^^^^^^^^^^^ step : " + step);
//                }
                break;
        }
    }

}
