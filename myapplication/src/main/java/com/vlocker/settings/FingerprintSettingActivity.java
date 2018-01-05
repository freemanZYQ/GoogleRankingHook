package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.f.b;
import com.vlocker.f.i;
import com.vlocker.f.j;
import com.vlocker.f.s;
import com.vlocker.locker.R;
import com.vlocker.m.a.d;
import com.vlocker.ui.cover.k;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class FingerprintSettingActivity extends Activity implements OnClickListener {
    s a = new ag(this);
    boolean b;
    private a c = null;
    private V2SettingHeaderBar d;
    private ImageView e;
    private View f;

    private void a() {
        this.d = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.d.setTitle(getString(R.string.v2_setting_fingerprint));
        this.d.setBackOnClickListener(new af(this));
        findViewById(R.id.setting_fingerprint_layout).setOnClickListener(this);
        this.e = (ImageView) findViewById(R.id.setting_show_fingerprint_img);
        this.e.setOnClickListener(this);
        this.f = findViewById(R.id.setting_fingerprint_layout);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, FingerprintSettingActivity.class);
        intent.putExtra("tip", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void a(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (!z) {
            if (this.b) {
                p.a((Context) this, "Vlocker_Switch_FingerprintUnlock_Password_PPC_ZJ", "status", "close");
            }
            imageView.setImageResource(R.drawable.l_setting_off);
            this.f.setClickable(false);
            ((TextView) findViewById(R.id.setting_fingerprint_tv)).setTextColor(getResources().getColor(R.color.v2_setting_item_title_des));
            this.c.aC(false);
        } else if (this.b) {
            j.a().b(this, this.a);
            this.c.aQ(true);
            if (this.c.dc()) {
                p.a((Context) this, "Vlocker_Switch_FingerprintUnlock_Password_PPC_ZJ", "status", "first_open");
                this.c.aR(false);
                return;
            }
            p.a((Context) this, "Vlocker_Switch_FingerprintUnlock_Password_PPC_ZJ", "status", "none_first_open");
        } else {
            imageView.setImageResource(R.drawable.l_setting_on);
            this.f.setClickable(true);
            ((TextView) findViewById(R.id.setting_fingerprint_tv)).setTextColor(-1);
            this.c.aC(true);
        }
    }

    private void b() {
        this.b = false;
        a(this.e, this.c.cg());
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.setting_show_fingerprint_img:
                this.b = true;
                ImageView imageView = (ImageView) view;
                if (this.c.cg()) {
                    z = false;
                }
                a(imageView, z);
                return;
            case R.id.setting_fingerprint_layout:
                try {
                    j.a().c(this);
                    return;
                } catch (Exception e) {
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.l_activity_fingerprint_setting);
        getWindow().setBackgroundDrawable(null);
        this.c = a.a((Context) this);
        a();
        b();
        this.c.az(false);
        if (getIntent() != null) {
            CharSequence stringExtra = getIntent().getStringExtra("tip");
            if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
                Toast.makeText(this, stringExtra, 1).show();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected void onResume() {
        super.onResume();
        if (b.a) {
            b.a().d();
        }
        if (!d.b || k.a(this)) {
            if (!(i.c || i.d || j.a().b())) {
                this.c.aC(false);
                b();
            }
            if (!i.c && i.d) {
                j.a().a(this, this.a);
                i.d = false;
            }
            if (!i.c) {
                return;
            }
            if (!j.a().b()) {
                this.c.aC(false);
                b();
                i.c = false;
                return;
            } else if (k.a(this)) {
                j.a().c(this, this.a);
                i.c = false;
                return;
            } else {
                j.a().a(this, this.a);
                i.c = false;
                return;
            }
        }
        com.vlocker.m.a.b.a(this).a(3);
        d.b = false;
    }
}
