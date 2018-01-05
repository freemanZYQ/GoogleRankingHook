package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.ui.cover.LockPatternView;
import com.vlocker.ui.cover.LockerPatternSmallView;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.cover.l;
import com.vlocker.ui.cover.r;
import java.util.ArrayList;
import java.util.List;

public class CreateGesturePasswordActivity extends Activity implements OnClickListener {
    protected TextView a;
    protected TextView b;
    protected List c = null;
    protected r d = new i(this);
    private LockPatternView e;
    private LockerPatternSmallView f;
    private Toast g;
    private m h = m.Introduction;
    private final List i = new ArrayList();
    private Runnable j = new h(this);

    private void a() {
        if (this.c != null) {
            this.f.setPattern(this.c);
        }
    }

    private void a(int i) {
        if (this.g == null) {
            this.g = Toast.makeText(this, i, 0);
        } else {
            this.g.setText(i);
        }
        this.g.show();
    }

    private void a(m mVar) {
        this.h = mVar;
        if (mVar == m.ChoiceTooShort) {
            this.a.setText(getResources().getString(mVar.h, new Object[]{Integer.valueOf(4)}));
        } else {
            this.a.setText(mVar.h);
        }
        if (mVar.l) {
            this.e.d();
        } else {
            this.e.c();
        }
        this.e.setDisplayMode(0);
        switch (j.a[this.h.ordinal()]) {
            case 1:
                this.e.b();
                return;
            case 2:
                this.e.a(1, this.i);
                return;
            case 3:
                this.e.setDisplayMode(2);
                b();
                return;
            case 5:
                this.e.b();
                a();
                return;
            case 6:
                this.e.setDisplayMode(2);
                b();
                return;
            default:
                return;
        }
    }

    private void b() {
        this.e.removeCallbacks(this.j);
        this.e.postDelayed(this.j, 600);
    }

    private void c() {
        a.a((Context) this).o(true);
        a.a((Context) this).q(false);
        f.j = true;
        p.a((Context) this, "Vlocker_PatternPasswordSum_PPC_TF", new String[0]);
        p.a((Context) this, "Vlocker_Done_PatternPassword_PPC_TF", new String[0]);
        l.a(this.c, this);
        a((int) R.string.settings_pattern_success);
        ThemeColorSettingsActivity.a((Context) this);
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back_pattern_tx:
                finish();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_gesturepassword_create);
        this.e = (LockPatternView) findViewById(R.id.gesturepwd_create_lockview);
        this.a = (TextView) findViewById(R.id.gesturepwd_create_text);
        this.e.setOnPatternListener(this.d);
        this.e.setTactileFeedbackEnabled(true);
        this.b = (TextView) findViewById(R.id.btn_back_pattern_tx);
        this.b.setOnClickListener(this);
        this.f = (LockerPatternSmallView) findViewById(R.id.gesturepwd_small_lockview);
        this.e.b();
        this.e.setDisplayMode(0);
        a(m.Introduction);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f != null) {
            this.f.a();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("uiStage", this.h.ordinal());
        if (this.c != null) {
            bundle.putString("chosenPattern", l.a(this.c));
        }
    }
}
