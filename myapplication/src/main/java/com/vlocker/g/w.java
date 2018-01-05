package com.vlocker.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.Toast;
import com.vlocker.b.i;
import com.vlocker.b.p;
import com.vlocker.e.e;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.update.a;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class w {
    public static final Bitmap a(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        UpdateApkParamBean updateApkParamBean = new UpdateApkParamBean();
        updateApkParamBean.c(str);
        updateApkParamBean.b(z);
        updateApkParamBean.f(str2);
        updateApkParamBean.g(i.g);
        updateApkParamBean.e(102);
        updateApkParamBean.i(str3);
        updateApkParamBean.h(str3);
        updateApkParamBean.q("icon");
        updateApkParamBean.d((int) R.drawable.l_down_msg_icon);
        try {
            String h = updateApkParamBean.h();
            File file = new File(i.g + updateApkParamBean.h() + ".apk");
            if (TextUtils.isEmpty(h) || !aj.a(h)) {
                if (!file.exists()) {
                    p.a(context, "Vlocker_Click_IconDownload_PPC_RR", new String[0]);
                    new e(context).a(updateApkParamBean);
                } else if (!z) {
                    Toast.makeText(context, context.getString(R.string.vlocker_update_install), 2000).show();
                    a.a(context, file);
                    p.a(context, "Vlocker_Done_IconDownload_PPC_RR", new String[0]);
                }
            } else if (!z) {
                Toast.makeText(context, context.getString(R.string.vlocker_update_apk_installed), 2000).show();
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent();
                context.startActivity(packageManager.getLaunchIntentForPackage(h));
            }
        } catch (Exception e) {
        }
    }
}
