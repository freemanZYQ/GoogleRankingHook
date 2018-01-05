package com.tools.hackandroid.accessibility.handler.suning;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.tools.hackandroid.accessibility.handler.AbsHandler;
import com.tools.hackandroid.util.DLog;
import com.tools.hackandroid.util.ShellUtils;


@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class SNHandler extends AbsHandler {

    private int openTime = 0;

    private int targetTag = 0;
    private boolean travelComplete;

    private void reset() {
        travelComplete = false;
        targetTag = 0;
    }

    private static Handler handler;

    public static void setHandler(Handler handler) {
        SNHandler.handler = handler;
    }

    @Override
    public void onServiceConnected() {
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {


        switch (event.getEventType()) {

            case AccessibilityEvent.TYPE_VIEW_SCROLLED:

                break;
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
//                DLog.d("window content changed ");
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                DLog.d("open new window ");
//                targetTag = RandomUtil.getRandomNumber(0, 6);
                targetTag = 0;
                AccessibilityNodeInfo nodeInfo = event.getSource();
                if (nodeInfo != null) {
                    traverseNode(nodeInfo);
                }
                break;
        }
    }


    private void traverseNode(AccessibilityNodeInfo node) {
        if (null == node)
            return;

        if (travelComplete)
            return;
        int count = node.getChildCount();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                AccessibilityNodeInfo childInfo = node.getChild(i);
                traverseNode(childInfo);
            }
        } else {
            CharSequence text = node.getText();
            if (!TextUtils.isEmpty(text)) {
                if (node.getClassName().equals("android.widget.TextView")) {
                    int sortTag = -1;
                    switch (text.toString()) {
                        case "大聚惠":
                            sortTag = 0;
                            break;
                        case "海外购":
                            sortTag = 1;
                            break;
                        case "苏宁超市":
                            sortTag = 2;
                            break;
                        case "母婴玩具":
                            sortTag = 3;
                            break;
                        case "服装城":
                            sortTag = 4;
                            break;
                        case "充值缴费":
                            sortTag = 5;
                            break;
                        case "理财贷款":
                            sortTag = 6;
                            break;
                    }
//                    DLog.d("targetTag: " + targetTag + " sortTag : " + sortTag);
                    if (targetTag == sortTag) {
//                        DLog.d("travel text: " + text);
                        openTime++;
                        AccessibilityNodeInfo pNodeInfo = node.getParent();
                        if (pNodeInfo.getClassName().equals("android.widget.LinearLayout")) {
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            pNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            DLog.d("click tag: " + text);
                            travelComplete = true;
                            ShellUtils.execCommand("sleep 3;", true);
                            ShellUtils.execCommand("input keyevent 4;sleep 4 ;input keyevent 4;input keyevent 4;sleep 3;", true);
                            reset();
                            if (openTime > 1) {
                                openTime = 0;
                                handler.sendEmptyMessage(1);
                            } else {
                                handler.sendEmptyMessage(2);
                            }
                        }
                    }
                }
            }
        }
    }
}

