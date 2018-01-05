package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.open.a.j;
import com.tencent.open.b.d;
import com.tencent.open.d.u;
import com.tencent.tauth.b;
import org.json.JSONObject;

public class AssistActivity extends Activity {
    protected Handler a = new a(this);
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;

    private void a(Bundle bundle) {
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString("appId");
        String str = "";
        String str2 = "";
        if ("shareToQQ".equals(string2)) {
            str = "ANDROIDQQ.SHARETOQQ.XX";
            str2 = "10";
        } else if ("shareToQzone".equals(string2)) {
            str = "ANDROIDQQ.SHARETOQZ.XX";
            str2 = "11";
        }
        if (u.a((Context) this, string3)) {
            d.a().a(string4, string5, str, str2, "3", "0", string, "0", "2", "0");
        } else {
            b a = c.a().a(string2);
            if (a != null) {
                a.onError(new com.tencent.tauth.d(-6, "打开浏览器失败!", null));
            }
            d.a().a(string4, string5, str, str2, "3", "1", string, "0", "2", "0");
            finish();
        }
        getIntent().removeExtra("shareH5");
    }

    public void a(int i, Intent intent) {
        if (intent == null) {
            j.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0, intent);
            return;
        }
        try {
            Object stringExtra = intent.getStringExtra("key_response");
            j.b("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- " + stringExtra);
            if (TextUtils.isEmpty(stringExtra)) {
                j.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
                return;
            }
            JSONObject jSONObject = new JSONObject(stringExtra);
            CharSequence optString = jSONObject.optString("openid");
            CharSequence optString2 = jSONObject.optString("access_token");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                j.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                setResult(0, intent);
                return;
            }
            j.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
            setResult(-1, intent);
        } catch (Exception e) {
            j.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        j.c("openSDK_LOG.AssistActivity", "--onActivityResult--requestCode: " + i + " | resultCode: " + i2 + "data = null ? " + (intent == null));
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra("key_action", "action_login");
            }
            a(i2, intent);
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(3);
        j.b("openSDK_LOG.AssistActivity", "--onCreate--");
        if (getIntent() == null) {
            j.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra("openSDK_LOG.AssistActivity.ExtraIntent");
        int intExtra = intent == null ? 0 : intent.getIntExtra("key_request_code", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.b = bundle.getBoolean("RESTART_FLAG");
        }
        if (this.b) {
            j.b("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            j.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            j.c("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
            if (intent.getComponent() != null) {
                this.c = false;
                startActivityForResult(intent, intExtra);
                return;
            }
            this.c = true;
            this.d = false;
            startActivity(intent);
        } else {
            j.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    protected void onDestroy() {
        j.b("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        j.c("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        intent.putExtra("key_action", "action_share");
        setResult(-1, intent);
        if (!isFinishing()) {
            j.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    protected void onPause() {
        j.b("openSDK_LOG.AssistActivity", "-->onPause");
        if (this.c) {
            if (this.d) {
                this.a.removeMessages(0);
            } else {
                this.d = true;
            }
        }
        super.onPause();
    }

    protected void onResume() {
        j.b("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!(intent.getBooleanExtra("is_qq_mobile_share", false) || !this.b || isFinishing())) {
                finish();
            }
            if (this.c && this.d) {
                this.a.sendMessageDelayed(this.a.obtainMessage(0), 200);
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        j.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        j.b("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    protected void onStop() {
        j.b("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }
}
