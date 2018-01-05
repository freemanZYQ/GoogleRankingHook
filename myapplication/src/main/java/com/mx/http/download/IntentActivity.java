package com.mx.http.download;

import android.app.Activity;
import android.content.Context;

public class IntentActivity extends Activity {
    private Context a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r6 = 0;
        super.onCreate(r9);
        r8.a = r8;
        r0 = r8.getIntent();	 Catch:{ Exception -> 0x006f }
        r1 = r0.getExtras();	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x0011:
        if (r1 == 0) goto L_0x002e;
    L_0x0013:
        r0 = "tag";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x006f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x006f }
        if (r0 != 0) goto L_0x002e;
    L_0x0020:
        r0 = "tag";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x006f }
        r2 = r0.hashCode();	 Catch:{ Exception -> 0x006f }
        switch(r2) {
            case -1690519110: goto L_0x0032;
            case -785075440: goto L_0x0074;
            case 31448181: goto L_0x0096;
            default: goto L_0x002e;
        };
    L_0x002e:
        r8.finish();
        return;
    L_0x0032:
        r2 = "download_complete_notification";
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x003b:
        r0 = "ZGP";
        r2 = "通知栏点击";
        android.util.Log.e(r0, r2);	 Catch:{ Exception -> 0x006f }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x006f }
        r0.<init>();	 Catch:{ Exception -> 0x006f }
        r2 = "com.moxiu.http.download.task.click";
        r0.setAction(r2);	 Catch:{ Exception -> 0x006f }
        r2 = r8.getApplicationContext();	 Catch:{ Exception -> 0x006f }
        r2.sendBroadcast(r0);	 Catch:{ Exception -> 0x006f }
        r0 = "filePath";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x006f }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x006f }
        if (r1 == 0) goto L_0x0121;
    L_0x0063:
        r0 = "文件路径为空";
        r1 = 0;
        r0 = android.widget.Toast.makeText(r8, r0, r1);	 Catch:{ Exception -> 0x006f }
        r0.show();	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x006f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x002e;
    L_0x0074:
        r2 = "download_complete";
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x007d:
        r0 = "filePath";
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x006f }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x006f }
        if (r1 == 0) goto L_0x00ed;
    L_0x008a:
        r0 = "文件路径为空";
        r1 = 0;
        r0 = android.widget.Toast.makeText(r8, r0, r1);	 Catch:{ Exception -> 0x006f }
        r0.show();	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x0096:
        r2 = "download_fail";
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x009f:
        r0 = "data";
        r0 = r1.getSerializable(r0);	 Catch:{ Exception -> 0x006f }
        r0 = (com.mx.http.download.a) r0;	 Catch:{ Exception -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x00aa:
        r2 = r0.x();	 Catch:{ Exception -> 0x006f }
        r4 = r0.e();	 Catch:{ Exception -> 0x006f }
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x00c6;
    L_0x00b6:
        r2 = r0.x();	 Catch:{ Exception -> 0x006f }
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x002e;
    L_0x00be:
        r2 = r0.e();	 Catch:{ Exception -> 0x006f }
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x002e;
    L_0x00c6:
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x006f }
        r2 = r8.getApplicationContext();	 Catch:{ Exception -> 0x006f }
        r3 = com.mx.http.download.DownloadService.class;
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x006f }
        r2 = new android.os.Bundle;	 Catch:{ Exception -> 0x006f }
        r2.<init>();	 Catch:{ Exception -> 0x006f }
        r3 = com.mx.http.download.i.DOWNLOAD_PENDING;	 Catch:{ Exception -> 0x006f }
        r0.a(r3);	 Catch:{ Exception -> 0x006f }
        r3 = "itemdata";
        r2.putSerializable(r3, r0);	 Catch:{ Exception -> 0x006f }
        r1.putExtras(r2);	 Catch:{ Exception -> 0x006f }
        r0 = r8.getApplicationContext();	 Catch:{ Exception -> 0x006f }
        r0.startService(r1);	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x00ed:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x006f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x006f }
        r0 = r1.exists();	 Catch:{ Exception -> 0x006f }
        if (r0 != 0) goto L_0x0105;
    L_0x00f8:
        r0 = "文件不存在";
        r1 = 0;
        r0 = android.widget.Toast.makeText(r8, r0, r1);	 Catch:{ Exception -> 0x006f }
        r0.show();	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x0105:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x006f }
        r2 = "android.intent.action.VIEW";
        r0.<init>(r2);	 Catch:{ Exception -> 0x006f }
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r2);	 Catch:{ Exception -> 0x006f }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x006f }
        r2 = "application/vnd.android.package-archive";
        r0.setDataAndType(r1, r2);	 Catch:{ Exception -> 0x006f }
        r8.startActivity(r0);	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x0121:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x006f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x006f }
        r0 = r1.exists();	 Catch:{ Exception -> 0x006f }
        if (r0 != 0) goto L_0x0139;
    L_0x012c:
        r0 = "文件不存在";
        r1 = 0;
        r0 = android.widget.Toast.makeText(r8, r0, r1);	 Catch:{ Exception -> 0x006f }
        r0.show();	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
    L_0x0139:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x006f }
        r2 = "android.intent.action.VIEW";
        r0.<init>(r2);	 Catch:{ Exception -> 0x006f }
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r2);	 Catch:{ Exception -> 0x006f }
        r1 = android.net.Uri.fromFile(r1);	 Catch:{ Exception -> 0x006f }
        r2 = "application/vnd.android.package-archive";
        r0.setDataAndType(r1, r2);	 Catch:{ Exception -> 0x006f }
        r8.startActivity(r0);	 Catch:{ Exception -> 0x006f }
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mx.http.download.IntentActivity.onCreate(android.os.Bundle):void");
    }
}
