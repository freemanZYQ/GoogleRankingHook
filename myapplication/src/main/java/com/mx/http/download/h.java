package com.mx.http.download;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class h {
    public static void a(Context context) {
        Intent intent = new Intent("com.moxiu.http.download.task.restart");
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void a(Context context, int i, a aVar) {
        Log.e("ZGP", "sendBroadcastToUI:" + i);
        Intent intent = new Intent("com.moxiu.http.action.promotion.filedownload.downloading");
        intent.putExtra("type", i);
        intent.putExtra("itemdata", aVar);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void a(Context context, String str, a aVar) {
        try {
            Intent intent = new Intent(str);
            intent.putExtra("itemdata", aVar);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Exception e) {
        }
    }

    public static void a(Handler handler, int i, Object obj) {
        if (handler != null) {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            handler.sendMessage(message);
        }
    }
}
