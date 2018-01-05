package com.vlocker.b;

import android.content.Context;
import com.vlocker.battery.saver.b;
import com.vlocker.c.a;
import com.vlocker.e.j;
import com.vlocker.new_theme.d.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class m extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ Context c;
    final /* synthetic */ int d;

    m(String str, a aVar, Context context, int i) {
        this.a = str;
        this.b = aVar;
        this.c = context;
        this.d = i;
    }

    public void run() {
        boolean z = true;
        boolean z2 = false;
        try {
            String b = f.b(this.a.trim().replaceAll(" ", ""));
            JSONObject jSONObject = new JSONObject(b);
            if (jSONObject.getInt("code") == 200) {
                JSONObject jSONObject2;
                boolean optBoolean;
                boolean optBoolean2;
                boolean optBoolean3;
                boolean optBoolean4;
                boolean optBoolean5;
                boolean optBoolean6;
                this.b.D(b.toString());
                JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                if (jSONObject3.has("switch")) {
                    jSONObject2 = jSONObject3.getJSONObject("switch");
                    optBoolean = jSONObject2.has("vlocker_packet_notice_webview") ? jSONObject2.getJSONObject("vlocker_packet_notice_webview").optBoolean("force") : false;
                    optBoolean2 = jSONObject2.has("vlocker_packet_invite_webview") ? jSONObject2.getJSONObject("vlocker_packet_invite_webview").optBoolean("force") : false;
                    optBoolean3 = jSONObject2.has("vlocker_packet_setting_out") ? jSONObject2.getJSONObject("vlocker_packet_setting_out").optBoolean("force") : false;
                    optBoolean4 = jSONObject2.has("vlocker_packet_setting_in") ? jSONObject2.getJSONObject("vlocker_packet_setting_in").optBoolean("force") : false;
                    optBoolean5 = jSONObject2.has("vlocker_notice_setting") ? jSONObject2.getJSONObject("vlocker_notice_setting").optBoolean("force") : false;
                    optBoolean6 = jSONObject2.has("vlocker_screen_saver") ? jSONObject2.getJSONObject("vlocker_screen_saver").optBoolean("force") : true;
                    if (jSONObject2.has("launcher_ip_location")) {
                        z2 = jSONObject2.getJSONObject("launcher_ip_location").optBoolean("force");
                    }
                    if (jSONObject2.has("vlocker_infoflow_switch")) {
                        z = jSONObject2.getJSONObject("vlocker_infoflow_switch").optBoolean("force");
                    }
                } else {
                    optBoolean6 = true;
                    optBoolean5 = false;
                    optBoolean4 = false;
                    optBoolean3 = false;
                    optBoolean2 = false;
                    optBoolean = false;
                }
                if (jSONObject3.has("scene")) {
                    jSONObject2 = jSONObject3.getJSONObject("scene");
                    if (jSONObject2.has("boost")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("boost");
                        if (jSONArray.length() > 0) {
                            this.b.J(jSONArray.toString());
                            j.a().a("2");
                        }
                    }
                }
                if (jSONObject3.has("infoflow")) {
                    jSONObject2 = jSONObject3.getJSONObject("infoflow");
                    this.b.M(jSONObject2.optString("target"));
                    this.b.N(jSONObject2.optString("rule_push"));
                }
                if (!optBoolean6) {
                    this.b.av(optBoolean6);
                    b.a(this.c).c();
                }
                this.b.aw(optBoolean6);
                this.b.aK(z2);
                this.b.ao(optBoolean3);
                this.b.ap(optBoolean4);
                this.b.ar(optBoolean5);
                this.b.ak(optBoolean);
                this.b.al(optBoolean2);
                this.b.aO(z);
                this.b.H(this.d);
                if (jSONObject3.has("splash_screen")) {
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("splash_screen");
                    if (jSONArray2 == null || jSONArray2.length() <= 0) {
                        this.b.E(null);
                    } else {
                        this.b.E(jSONArray2.toString());
                    }
                }
                if (jSONObject3.has("bucket") && jSONObject3.getJSONObject("bucket").has("mobile")) {
                    this.b.a(jSONObject3.getJSONArray("mobile"));
                }
                j.a(this.c, jSONObject3);
            }
        } catch (JSONException e) {
        } catch (Exception e2) {
        }
    }
}
