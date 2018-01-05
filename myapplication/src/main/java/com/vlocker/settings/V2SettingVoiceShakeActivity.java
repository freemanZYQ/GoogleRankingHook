package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.V2SettingHeaderBar;

public class V2SettingVoiceShakeActivity extends Activity implements OnClickListener {
    private V2SettingHeaderBar a;
    private View b;
    private CheckBox c;
    private View d;
    private CheckBox e;
    private a f = null;

    private void a() {
        this.a = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.a.setTitle(getString(R.string.v2_setting_voice_shake));
        this.a.setBackOnClickListener(new dd(this));
        this.b = findViewById(R.id.switch_unlock_voice);
        this.c = (CheckBox) findViewById(R.id.switch_unlock_voice_check);
        this.d = findViewById(R.id.switch_unlock_error_shake);
        this.e = (CheckBox) findViewById(R.id.switch_unlock_error_shake_check);
        this.c.setChecked(this.f.P());
        this.e.setChecked(this.f.au());
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    private boolean a(CheckBox checkBox) {
        boolean z = !checkBox.isChecked();
        Log.i("kevint", "nowChecked====" + z);
        checkBox.setChecked(z);
        return z;
    }

    public void onClick(View view) {
        boolean a;
        String str;
        String[] strArr;
        switch (view.getId()) {
            case R.id.switch_unlock_voice:
                Log.i("kevint", "switch_unlock_voice====");
                a = a(this.c);
                this.f.n(a);
                str = "Vlocker_Switch_Sound_Unlock_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = a ? "On" : "Off";
                p.a((Context) this, str, strArr);
                if (!a) {
                    return;
                }
                return;
            case R.id.switch_unlock_error_shake:
                Log.i("kevint", "switch_unlock_error_shake====");
                a = a(this.e);
                str = "Vlocker_Switch_Viberate_WrongPw_PPC_TF";
                strArr = new String[2];
                strArr[0] = "status";
                strArr[1] = a ? "On" : "Off";
                p.a((Context) this, str, strArr);
                this.f.H(a);
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = a.a((Context) this);
        setContentView(R.layout.l_v2_activity_setting_voiceshake);
        a();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
