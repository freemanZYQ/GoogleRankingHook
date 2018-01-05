package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import com.vlocker.b.j;
import com.vlocker.b.o;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class V2SettingThankActivity extends Activity {
    String a;
    private V2SettingHeaderBar b;
    private WebView c;
    private TextView d;

    private void b() {
        this.b = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.c = (WebView) findViewById(R.id.thanks_letter_webview);
        this.d = (TextView) findViewById(R.id.loading_des_txt);
    }

    final boolean a() {
        return j.b((Context) this) != o.noNetStatus;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_v2_activity_setting_thanks);
        b();
        this.a = j.c();
        if (a()) {
            this.d.setText(getString(R.string.l_vlocker_loading));
            this.c.loadUrl(this.a);
        } else {
            this.d.setText(getString(R.string.l_link_network));
        }
        this.c.setWebViewClient(new ct());
        this.b.setBackOnClickListener(new cs(this));
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
