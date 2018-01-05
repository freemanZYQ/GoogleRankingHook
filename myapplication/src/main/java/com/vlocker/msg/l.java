package com.vlocker.msg;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.battery.clean.y;
import com.vlocker.battery.saver.b;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.be;
import com.vlocker.msg.a.a;
import com.vlocker.setting.a.a.e;
import com.vlocker.settings.RedPacketActivity;
import com.vlocker.settings.SettingsActivity;
import com.vlocker.theme.activity.LocationThemeActivity;
import org.json.JSONObject;

class l implements Runnable {
    private ak a;
    private Context b;
    private View c;
    private String d;

    public l(Context context, ak akVar, View view, String str) {
        this.b = context;
        this.c = view;
        this.a = akVar;
        this.d = str;
    }

    private void a() {
        if (this.a.b.endsWith("114") && ao.a != null) {
            ao.a.a();
            p.a(this.b, "Vlocker_Open_FingerprintUnlock_Password_PPC_ZJ", new String[0]);
        }
    }

    private void a(String str, int i) {
        if (i != -1) {
            if (i == 4) {
                ao.a();
            } else if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Intent intent = new Intent();
                    String a;
                    Intent a2;
                    switch (i) {
                        case 1:
                            ao.b(this.b, str);
                            break;
                        case 2:
                            a = ao.a(jSONObject, "url", null);
                            if (a != null) {
                                a2 = ao.a(this.b, a);
                                a2.addFlags(268435456);
                                this.b.startActivity(a2);
                                return;
                            }
                            return;
                        case 3:
                            a = ao.a(jSONObject, "url", null);
                            if (a != null) {
                                a2 = as.a(this.b, a);
                                a2.addFlags(268435456);
                                this.b.startActivity(a2);
                                return;
                            }
                            return;
                        case 4:
                            break;
                        case 5:
                            ao.d(this.b, str);
                            return;
                        case 7:
                            a2 = ao.a(this.b);
                            a2.addFlags(268435456);
                            this.b.startActivity(a2);
                            return;
                        case 8:
                            ao.e(this.b, str);
                            return;
                        case 9:
                            a2 = ao.c(this.b, str);
                            a2.addFlags(268435456);
                            this.b.startActivity(a2);
                            return;
                        case 10:
                            a2 = new Intent(this.b, RedPacketActivity.class);
                            a2.putExtra("from", e.ACTION_MAIN);
                            a2.addFlags(268435456);
                            this.b.startActivity(a2);
                            return;
                        default:
                            return;
                    }
                    ao.a();
                } catch (Exception e) {
                }
            }
        }
    }

    public void run() {
        if (this.a != null && !TextUtils.isEmpty(this.a.b)) {
            if ("mx_clean".equals(this.a.b)) {
                y.a().j();
                y.a().k();
            }
            Intent intent;
            if ("red_packet_msg".equals(this.a.b)) {
                intent = new Intent(this.b, RedPacketActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("from", e.ACTION_MAIN);
                this.b.startActivity(intent);
            } else if ("mx_ad".equals(this.a.b)) {
                b.a(this.b).a(this.a, "ad_open_slide");
                b.a(this.b).a(this.a, "ad_download");
                b.a(this.b).a("Vlock_Charge_Adopen_slide_LZS");
                b.a(this.b).a(this.c);
                b.a(this.b).c();
            } else if ("mx_update".equals(this.a.b)) {
                intent = new Intent(this.b, SettingsActivity.class);
                intent.putExtra("forceUpdateDialog", true);
                intent.setFlags(268435456);
                this.b.startActivity(intent);
            } else {
                int b = as.b(this.a.b);
                if (this.a.b.startsWith("msg_ad")) {
                    as.a(this.b, b);
                    ab.e(this.b.getPackageName() + "|" + this.a.F + "|" + b);
                    a.a(this.b).a(this.d);
                    return;
                }
                if (this.a.r && !TextUtils.isEmpty(this.a.q)) {
                    if (!(this.a == null || this.a.m == null)) {
                        p.d(this.b, "url|" + this.a.c + "|" + this.a.m.getStringExtra("url"), "yesad".equals(this.a.m.getStringExtra("adtype")) ? "AA_SELFRUN_Y" : "AA_SELFRUN_N", "");
                    }
                    mcm.sdk.a.b(this.b, this.a.q, "2.1");
                    if (this.a.c != null) {
                        p.a(this.b, "Vlocker_Open_PushMessage_PPC_TF", "location", this.d, "name", this.a.c);
                    } else {
                        p.a(this.b, "Vlocker_Open_PushMessage_PPC_TF", "location", this.d, "name", "kong");
                    }
                    if (com.vlocker.c.a.a(this.b).g().equals(this.a.b)) {
                        com.vlocker.c.a.a(this.b).a("");
                        com.vlocker.c.a.a(this.b).b("");
                    }
                }
                if ("red_packet_share".equals(this.a.b)) {
                    p.a(this.b, "Vlocker_Open_Hongbao_Push_PPC_XXB", new String[0]);
                }
                as.a(this.b, b);
                ab.e(this.b.getPackageName() + "|" + this.a.F + "|" + b);
                if (this.a.b.startsWith(this.b.getPackageName())) {
                    intent = this.a.m;
                    if (intent == null) {
                        intent = as.d(this.b, this.a.D);
                        a();
                    }
                    if (intent != null) {
                        intent.addFlags(268435456);
                        if (TextUtils.isEmpty(this.a.D) || this.a.F != 7 || com.vlocker.theme.f.e.c(this.b)) {
                            Object b2 = be.b(this.b, intent);
                            if (!TextUtils.isEmpty(b2)) {
                                intent.putExtra("url", b2);
                            }
                            String str = "com.taobao.taobao";
                            if ("taobao".equals(intent.getStringExtra("sub_type")) && j.b(this.b, str) && aj.b(this.b, str) >= 123) {
                                ao.a(this.b, intent.getStringExtra("url"), XAdErrorCode.ERROR_CODE_MESSAGE);
                                return;
                            }
                            this.b.startActivity(intent);
                            if (this.a.b.equals("com.vlocker.locker|-1|115")) {
                                new com.vlocker.m.a.a(this.b).a(1);
                                return;
                            }
                            return;
                        }
                        Toast.makeText(this.b, R.string.vlocker_setting_update_app_nonetdip, 1).show();
                        intent = new Intent(this.b, LocationThemeActivity.class);
                        intent.addFlags(268435456);
                        this.b.startActivity(intent);
                        return;
                    }
                    a(this.a.D, this.a.F);
                    return;
                }
                try {
                    this.a.h.send();
                } catch (Exception e) {
                    intent = ao.a(this.a.b);
                    if (intent != null) {
                        this.b.startActivity(intent);
                    }
                }
                if (this.a.j != null && !this.a.j.isEmpty()) {
                    p.a(this.b, "Vlocker_MsgName_Unlock_PPC_TF", "app_name", this.a.j);
                }
            }
        }
    }
}
