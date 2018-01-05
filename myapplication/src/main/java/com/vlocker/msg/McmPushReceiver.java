package com.vlocker.msg;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.vlocker.g.b;
import mcm.sdk.McmMsgHandle;
import org.json.JSONException;
import org.json.JSONObject;

public class McmPushReceiver extends McmMsgHandle {
    public void getMethod(String str) {
        try {
            this.json = new JSONObject(str);
            getClass().getMethod("handleMsgType" + this.json.optString("type"), new Class[0]).invoke(this, new Object[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void handleMsgTypeCommon() {
        if (getIntentBase() != null) {
            handleMsgTypeOpen();
        }
    }

    public void handleMsgTypeDigestChannel() {
        McmPushWidget.getInstance(this.context).handleMsgTypeOpen(this.json, getIntentBase(), 7);
    }

    public void handleMsgTypeOpen() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeOpen(this.json, getIntentBase(), 7);
    }

    public void handleMsgTypePullUp() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeUriAppOpen(this.json);
    }

    public void handleMsgTypeSearchList() {
        McmPushWidget.getInstance(this.context).handleMsgTypeOpen(this.json, getIntentBase(), 7);
    }

    public void handleMsgTypeTheme() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeOpen(this.json, getIntentBase(), 9);
    }

    public void handleMsgTypeTopic() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeOpen(this.json, getIntentBase(), 7);
    }

    public void handleMsgTypeTopicList() {
        McmPushWidget.getInstance(this.context).handleMsgTypeOpen(this.json, getIntentBase(), 7);
    }

    public void handleMsgTypeTrain() {
        b.a().a(this.json.toString());
    }

    public void handleMsgTypeWakeUp() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeAppOpenAlarm(this.json);
    }

    public void handleMsgTypeWeatherAlarm() {
        McmPushWidget.getInstance(this.context.getApplicationContext()).handleMsgTypeWeatherAlarm(this.json);
    }

    public void handleMsgTypeWebView() {
        McmPushWidget.getInstance(this.context).handleMsgTypeOpen(this.json, getIntentBase(), 2);
    }

    public void onReceive(Context context, Intent intent) {
        this.context = context;
        if (intent.getAction().equals("push_msg")) {
            getMethod(intent.getStringExtra("json"));
        } else {
            super.onReceive(context, intent);
        }
        Log.e("liu---", "McmPushReceiver json=" + this.json);
    }
}
