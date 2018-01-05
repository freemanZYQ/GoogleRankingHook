package com.tools.hackandroid.accessibility.handler.gp;

import android.view.accessibility.AccessibilityEvent;

import com.tools.hackandroid.accessibility.handler.AbsHandler;

import net.luna.common.debug.LunaLog;

/**
 * Created by apple on 17/3/2.
 * googlePlay自动点击
 */
public class GooglePlayHandler extends AbsHandler{

    @Override
    public void onServiceConnected() {

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        switch (event.getEventType()) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                LunaLog.d(event.getClassName().toString());
                switch (event.getClassName().toString()) {
                    // 打开设置页面的时候,会开始计算该应用占用多少空间,完毕就会更新内容,回调textview更新
                    case "android.webkit.WebView":
                        // 针对京东处理
                        LunaLog.d("webview内容发生了变化");

                        break;
                }
                break;
        }
    }

    @Override
    public void onInterrupt() {

    }
}
