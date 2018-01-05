package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.notification.msg.open.FlowWebViewActivity;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class AboutActivity extends Activity implements OnClickListener {
    a a;

    private void b() {
        ((V2SettingHeaderBar) findViewById(R.id.settings_head_bar)).setBackOnClickListener(new a(this));
        if (MoSecurityApplication.a) {
            findViewById(R.id.setting_about_thanks_item).setVisibility(8);
        }
        findViewById(R.id.setting_about_weibo).setOnClickListener(this);
        findViewById(R.id.setting_about_private_policy).setOnClickListener(this);
        findViewById(R.id.setting_about_tos).setOnClickListener(this);
        findViewById(R.id.setting_about_comment_item).setOnClickListener(this);
        findViewById(R.id.setting_about_thanks_item).setOnClickListener(this);
    }

    private void c() {
        if (MoSecurityApplication.a) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.vlocker.locker"));
                intent.setPackage("com.android.vending");
                startActivity(intent);
                return;
            } catch (Exception e) {
                return;
            }
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.vlocker.locker"));
        if (j.b((Context) this, "com.tencent.android.qqdownloader")) {
            intent.setPackage("com.tencent.android.qqdownloader");
        } else if (j.b((Context) this, "com.baidu.appsearch")) {
            intent.setPackage("com.baidu.appsearch");
        } else if (j.b((Context) this, "com.wandoujia.phoenix2")) {
            intent.setPackage("com.wandoujia.phoenix2");
        } else if (j.b((Context) this, "com.infinit.wostore.ui")) {
            intent.setPackage("com.infinit.wostore.ui");
        } else if (j.b((Context) this, "com.bbk.appstore")) {
            intent.setPackage("com.bbk.appstore");
        } else if (j.b((Context) this, "com.oppo.market")) {
            intent.setPackage("com.oppo.market");
        } else if (j.b((Context) this, "com.yulong.android.coolmart")) {
            intent.setPackage("com.yulong.android.coolmart");
        } else if (j.b((Context) this, "com.huawei.appmarket")) {
            intent.setPackage("com.huawei.appmarket");
        } else if (j.b((Context) this, "com.lenovo.leos.appstore")) {
            intent.setPackage("com.lenovo.leos.appstore");
        } else if (j.b((Context) this, "com.meizu.mstore")) {
            intent.setPackage("com.meizu.mstore");
        } else if (j.b((Context) this, "com.xiaomi.market")) {
            intent.setPackage("com.xiaomi.market");
        }
        if (TextUtils.isEmpty(intent.getPackage())) {
            Toast.makeText(this, "未安装市场~", 1).show();
            return;
        }
        try {
            startActivity(intent);
            Toast.makeText(this, "点击【评论】按钮，添加精彩评论吧~", 1).show();
        } catch (Exception e2) {
            Toast.makeText(this, "未安装市场~", 1).show();
        }
    }

    final boolean a() {
        return j.b((Context) this) != o.noNetStatus;
    }

    public void onClick(View view) {
        int id = view.getId();
        Intent intent = new Intent(this, FlowWebViewActivity.class);
        switch (id) {
            case R.id.setting_about_weibo:
                p.a((Context) this, "Vlocker_Click_GFWeiBo_PPC_YZY", new String[0]);
                intent.putExtra("title", getString(R.string.official_weibo));
                intent.putExtra("url", "http://m.weibo.cn/n/%E5%BE%AE%E9%94%81%E5%B1%8F%E5%AE%98%E5%8D%9A");
                startActivity(intent);
                return;
            case R.id.setting_about_private_policy:
                p.a((Context) this, "Vlocker_Open_PrivacyPolicy_PPC_YZY", "from", "Setting");
                intent.putExtra("tag", "private");
                intent.putExtra("title", getString(R.string.private_policy));
                intent.putExtra("url", j.m() + "&" + j.d((Context) this));
                startActivity(intent);
                return;
            case R.id.setting_about_tos:
                p.a((Context) this, "Vlocker_Open_TermOfService_PPC_YZY", "from", "Setting");
                intent.putExtra("tag", "private");
                intent.putExtra("title", getString(R.string.trems_of_service));
                intent.putExtra("url", j.l() + "&" + j.d((Context) this));
                startActivity(intent);
                return;
            case R.id.setting_about_comment_item:
                p.a((Context) this, "Vlocker_Click_GoodComment_PPC_TF", new String[0]);
                c();
                return;
            case R.id.setting_about_thanks_item:
                p.a((Context) this, "Vlocker_Click_Thx_PPC_TF", new String[0]);
                if (a()) {
                    startActivity(new Intent(this, V2SettingThankActivity.class));
                    return;
                } else {
                    Toast.makeText(this, R.string.l_link_network, 0).show();
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_activity_about);
        this.a = a.a((Context) this);
        b();
    }
}
