package com.vlocker.g;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.vlocker.b.j;
import com.vlocker.m.aj;
import com.vlocker.m.be;
import com.vlocker.msg.ao;
import com.vlocker.msg.as;
import org.json.JSONException;
import org.json.JSONObject;

class u implements Runnable {
    private a a;
    private Context b;
    private n c;

    public u(Context context, a aVar, n nVar) {
        this.b = context;
        this.a = aVar;
        this.c = nVar;
    }

    public void run() {
        if (this.a == null) {
            this.c.a();
            return;
        }
        Intent intent = this.a.s;
        if (intent == null) {
            try {
                intent = as.d(this.b, new JSONObject(this.a.x).getJSONObject("train").toString());
            } catch (JSONException e) {
            }
        }
        if (intent != null) {
            Object b = be.b(this.b, intent);
            if (!TextUtils.isEmpty(b)) {
                intent.putExtra("url", b);
            }
            intent.addFlags(268435456);
            String str = "com.taobao.taobao";
            if ("taobao".equals(intent.getStringExtra("sub_type")) && j.b(this.b, str) && aj.b(this.b, str) >= 123) {
                ao.a(this.b, intent.getStringExtra("url"), XAdErrorCode.ERROR_CODE_MESSAGE);
            } else {
                this.b.startActivity(intent);
            }
        }
        this.c.a();
    }
}
