package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.common.AssistActivity;
import com.tencent.open.a.j;
import com.tencent.open.d.p;
import com.tencent.open.d.u;

public class AuthActivity extends Activity {
    private static int a = 0;

    private void a(Uri uri) {
        j.c("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri == null || uri.toString() == null || uri.toString().equals("")) {
            j.d("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
            finish();
            return;
        }
        String uri2 = uri.toString();
        Bundle a = u.a(uri2.substring(uri2.indexOf("#") + 1));
        if (a == null) {
            j.d("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
            finish();
            return;
        }
        String string = a.getString("action");
        j.c("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
        if (string == null) {
            a(a, uri2);
        } else if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("addToQQFavorites") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
            if (string.equals("shareToQzone") && p.a((Context) this, "com.tencent.mobileqq") != null && p.b(this, "5.2.0") < 0) {
                a++;
                if (a == 2) {
                    a = 0;
                    finish();
                    return;
                }
            }
            j.c("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
            Intent intent = new Intent(this, AssistActivity.class);
            intent.putExtras(a);
            intent.setFlags(603979776);
            startActivity(intent);
            finish();
        } else if (string.equals("sharePrize")) {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            Object obj = "";
            try {
                obj = u.c(a.getString("response")).getString("activityid");
            } catch (Throwable e) {
                j.a("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
            }
            if (!TextUtils.isEmpty(obj)) {
                launchIntentForPackage.putExtra("sharePrize", true);
                a = new Bundle();
                a.putString("activityid", obj);
                launchIntentForPackage.putExtras(a);
            }
            startActivity(launchIntentForPackage);
            finish();
        } else {
            a(a, uri2);
        }
    }

    private void a(Bundle bundle, String str) {
        j.a("openSDK_LOG.AuthActivity", "execAuthCallback url = " + str);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            j.d("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            return;
        }
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e) {
            j.e("openSDK_LOG.AuthActivity", "-->onCreate, getIntent().getData() has exception! " + e.getMessage());
        }
        j.a("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        a(uri);
    }
}
