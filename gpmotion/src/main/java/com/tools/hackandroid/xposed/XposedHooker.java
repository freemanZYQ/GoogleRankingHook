package com.tools.hackandroid.xposed;

import android.app.Application;
import android.webkit.WebView;

import com.tools.hackandroid.gp.GMSHooker;
import com.tools.hackandroid.tv.IqiyiAdHooker;
import com.tools.hackandroid.tv.MiuiSystemAdHooker;
import com.tools.hackandroid.xposed.hooker.global.GlobalHookerManager;

import net.luna.common.debug.LunaLog;

import java.util.List;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedHooker implements IXposedHookZygoteInit, IXposedHookLoadPackage {

    /**
     * 钩子管理器
     */
    private GlobalHookerManager mGlobalHookerManager;


    /**
     * Called very early during startup of Zygote.
     *
     * @param startupParam Details about the module itself and the started process.
     * @throws Throwable everything is caught, but will prevent further initialization of the module.
     */
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        mGlobalHookerManager = new GlobalHookerManager();
        mGlobalHookerManager.initXSharedPreferences();

    }

    /**
     * This method is called when an app is loaded. It's called very early, even before
     * {@link Application#onCreate} is called.
     * Modules can set up their app-specific hooks here.
     *
     * @param lpparam Information about the app.
     * @throws Throwable Everything the callback throws is caught and logged.
     */
    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

        //只针对苏宁
//        if (Constants.PKG_NAME_SUNING.equals(lpparam.packageName)
////                || BuildConfig.APPLICATION_ID.equals(lpparam.packageName)
//                ) {
//            DLog.i("HackAndroid is ready to hook %s ", lpparam.packageName);

//        }

//        if (lpparam.packageName != null && !("com.android.vending".equals(lpparam.packageName)
//                || lpparam.packageName.contains("com.google.android") || "com.tools.hackandroid".equals(lpparam.packageName)
//                || "com.android.browser".equals(lpparam.packageName))) {
//            return;
//        }
        if(lpparam.packageName !=null
//               && !("com.miui.systemAdSolution".equals(lpparam.packageName))
                 && !("com.xiaomi.mitv.player".equals(lpparam.packageName))
                ){
            return;
        }
//
//        if (lpparam.packageName.contains("com.google.android.inputmethod")) {
//            return;
//        }

        LunaLog.d("初始化hook住:"+lpparam.packageName);
            mGlobalHookerManager.hook(lpparam);
        IqiyiAdHooker iqiyiAdHooker = new IqiyiAdHooker();
        try {
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer", lpparam.classLoader, "GetADSDKInfo", iqiyiAdHooker);
        }catch (Exception e){
            LunaLog.e("getAdSdkInfo hook住失败");
        }
        try {
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer", lpparam.classLoader, "GetDomain", iqiyiAdHooker);
        }catch (Exception e){
            LunaLog.e("getDomain hook住失败");
        }
        try{
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer",lpparam.classLoader,"InitilizeP2PModule",Class.forName("com.iqiyi.player.nativemediaplayer.P2PEnvironment"),iqiyiAdHooker);
        }catch (Exception e){
            e.printStackTrace();
            LunaLog.e("InitilizeP2PModule hook住失败");
        }
        try{
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer",lpparam.classLoader,"SetADSDKState",String.class,iqiyiAdHooker);
        }catch (Exception e){
            LunaLog.e("SetADSDKState hook住失败");
        }
        try{
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer",lpparam.classLoader,"AdCommand",Class.forName("com.iqiyi.player.nativemediaplayer.ADCommand"),String.class,iqiyiAdHooker);
        }catch (Exception e){
            e.printStackTrace();
            LunaLog.e("AdCommand hook住失败:"+e.getMessage());
        }
        try{
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer",lpparam.classLoader,"GetAdCountDown",iqiyiAdHooker);
        }catch (Exception e){
            LunaLog.e("GetAdCountDown hook住失败");
        }
        try{
            XposedHelpers.findAndHookMethod("com.iqiyi.player.nativemediaplayer.NativeMediaPlayer",lpparam.classLoader,"GetLog",iqiyiAdHooker);
        }catch (Exception e){
            LunaLog.e("GetLog hook失败");
        }




//        final MiuiSystemAdHooker miuiSystemAdHooker = new MiuiSystemAdHooker();
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.j",lpparam.classLoader,"a",String.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.j",lpparam.classLoader,"b",String.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.j",lpparam.classLoader,"c",String.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.j",lpparam.classLoader,"d",String.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.j",lpparam.classLoader,"e",String.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.analytics.a.b",lpparam.classLoader,"a",String.class,String.class, List.class,String.class,miuiSystemAdHooker);
//        XposedHelpers.findAndHookMethod("com.xiaomi.ad.internal.a.d.q",lpparam.classLoader,"a",String.class,miuiSystemAdHooker);

        //用于hook住webview相关逻辑
        //            final GMSHooker gmsHooker = new GMSHooker();
////        XposedHelpers.findAndHookMethod("com.android.webview.chromium.WebViewContentsClientAdapter", lpparam.classLoader, "onPageFinished", String.class, gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView",lpparam.classLoader,"loadUrl",String.class,gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView",lpparam.classLoader,"loadUrl",String.class,Map.class,gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView",lpparam.classLoader,"postUrl",String.class,byte[].class,gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebViewClient",lpparam.classLoader,"onPageFinished",WebView.class,String.class,gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView.WebViewTransport",lpparam.classLoader,"setWebView",WebView.class,gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView.WebViewTransport",lpparam.classLoader,"getWebView",gmsHooker);
//        XposedHelpers.findAndHookMethod("android.webkit.WebView",lpparam.classLoader,"findHierarchyView",String.class,int.class,gmsHooker);
//            XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager", lpparam.classLoader, "getPackageInfo", String.class, int.class, gmsHooker);
//            XposedHelpers.findAndHookMethod("com.android.server.pm.PackageManagerService", lpparam.classLoader, "getPackageInfo", String.class, int.class, int.class, gmsHooker);

    }
}
