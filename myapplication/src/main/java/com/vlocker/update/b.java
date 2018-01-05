package com.vlocker.update;

import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.qq.e.comm.constants.ErrorCode.InitError;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.e.r;
import com.vlocker.m.o;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

class b extends Thread {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            HttpResponse a = r.a(j.a(this.a.b, this.a.d));
            Editor c = i.c(this.a.b);
            if (a.getStatusLine().getStatusCode() == 200) {
                c.putInt("send", 1);
                c.commit();
                String a2 = r.a(a.getEntity().getContent());
                if (a2 != null && !a2.equals("")) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (Integer.parseInt(jSONObject.optString("code")) == InitError.INVALID_REQUEST_ERROR) {
                        this.a.c.c(0);
                        this.a.c.a(o.b(this.a.b));
                    } else {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        this.a.c.a(optJSONObject.optInt("version_code"));
                        this.a.c.p(optJSONObject.optString("version_name", "UNKNOWN"));
                        this.a.c.a(optJSONObject.optString("notification"));
                        this.a.c.e(optJSONObject.optString("type"));
                        this.a.c.b(optJSONObject.optString("md5"));
                        this.a.c.c(optJSONObject.optString("url"));
                        this.a.c.o(optJSONObject.optString("markets"));
                        this.a.c.a(optJSONObject.optBoolean("third"));
                        i.a(this.a.b, this.a.c);
                    }
                    if (this.a.c.f() == 3) {
                        a.a(this.a.b).aM(true);
                    } else if (this.a.c.f() == 2) {
                        a.a(this.a.b).aL(true);
                    }
                    Message message;
                    if (this.a.c.f() > 1 || (this.a.c.f() == 1 && this.a.d == 0)) {
                        message = new Message();
                        message.what = 1;
                        this.a.a.sendMessage(message);
                        return;
                    }
                    message = new Message();
                    message.what = 2;
                    this.a.a.sendMessage(message);
                    return;
                }
                return;
            }
            c.putInt("send", 0);
            c.commit();
        } catch (ClientProtocolException e) {
            this.a.e();
        } catch (IOException e2) {
            this.a.e();
        } catch (JSONException e3) {
            this.a.e();
        } catch (Exception e4) {
            this.a.e();
        }
    }
}
