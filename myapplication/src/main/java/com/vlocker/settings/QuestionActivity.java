package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.location.BDLocation;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.b.p;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.aa;
import com.vlocker.m.r;
import com.vlocker.ui.cover.f;
import java.lang.reflect.Field;
import java.util.Date;

public class QuestionActivity extends Activity implements OnClickListener {
    OnItemSelectedListener a = new ca(this);
    OnValueChangeListener b = new cb(this);
    private NumberPicker c;
    private NumberPicker d;
    private String[] e = null;
    private String[] f = null;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private EditText k;
    private EditText l;
    private Button m;
    private LinearLayout n;
    private int o = 0;
    private RelativeLayout p;
    private Spinner q;
    private boolean r = false;
    private a s;
    private View t;
    private Animation u;
    private TextWatcher v = new bz(this);
    private boolean w = false;
    private boolean x = false;

    private void a(int i) {
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, QuestionActivity.class));
    }

    private void a(NumberPicker numberPicker) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDividerHeight");
            declaredField.setAccessible(true);
            try {
                declaredField.set(numberPicker, Integer.valueOf((int) (getResources().getDisplayMetrics().density + 0.5f)));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(NumberPicker numberPicker, Drawable drawable) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            try {
                declaredField.set(numberPicker, drawable);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (NotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean a(long j) {
        return new Date().getTime() - j > 600000;
    }

    private boolean a(NumberPicker numberPicker, int i) {
        int childCount = numberPicker.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = numberPicker.getChildAt(i2);
            if (childAt instanceof EditText) {
                try {
                    Field declaredField = numberPicker.getClass().getDeclaredField("mSelectorWheelPaint");
                    declaredField.setAccessible(true);
                    ((Paint) declaredField.get(numberPicker)).setColor(i);
                    ((EditText) childAt).setTextColor(i);
                    numberPicker.invalidate();
                    return true;
                } catch (Throwable e) {
                    Log.w("setNumberPickerTextColor", e);
                } catch (Throwable e2) {
                    Log.w("setNumberPickerTextColor", e2);
                } catch (Throwable e22) {
                    Log.w("setNumberPickerTextColor", e22);
                }
            } else {
                i2++;
            }
        }
        return false;
    }

    private void b() {
        this.h = (TextView) findViewById(R.id.tv_question_hint);
        this.g = (TextView) findViewById(R.id.tv_question_qsforlocker);
        this.l = (EditText) findViewById(R.id.et_question_answer);
        this.t = findViewById(R.id.line_question);
        this.p = (RelativeLayout) findViewById(R.id.layout_question_qs);
        this.l.setHint(getResources().getString(R.string.v2_input_forget_password_tip_left) + this.s.aP().length() + getResources().getString(R.string.v2_input_forget_password_tip_right));
        this.p.setVisibility(4);
        this.g.setVisibility(0);
        this.h.setText(R.string.v2_input_forget_password_check);
        this.j.setVisibility(4);
        findViewById(R.id.tv_question_title).setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.o = this.s.aM();
        if (this.o == 0) {
            this.l.setVisibility(8);
            this.t.setVisibility(8);
            this.g.setText(this.f[0]);
        } else if (this.o != 1) {
            this.l.setVisibility(0);
            this.t.setVisibility(0);
            this.n.setVisibility(8);
            if (this.s.aM() != -1) {
                this.g.setText(this.f[this.s.aM()]);
            }
        } else {
            this.t.setVisibility(0);
            this.l.setVisibility(0);
            this.n.setVisibility(8);
            this.g.setText(this.s.aQ());
        }
        f();
    }

    public static void b(Context context) {
        p.a(context, "Vlocker_Click_Forget_Password_PPC_TF", new String[0]);
        Intent intent = new Intent(context, QuestionActivity.class);
        intent.putExtra("isForLockerView", true);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void c() {
        if (this.s.aM() != -1) {
            this.w = true;
            this.m.setText(getString(R.string.change));
        }
    }

    private void d() {
        this.l = (EditText) findViewById(R.id.et_question_answer);
        this.k = (EditText) findViewById(R.id.et_question_ori);
        this.t = findViewById(R.id.line_question);
        findViewById(R.id.tv_question_title).setOnClickListener(this);
        this.m.setOnClickListener(this);
        findViewById(R.id.btn_question_pop).setOnClickListener(this);
    }

    private void e() {
        this.n = (LinearLayout) findViewById(R.id.layout_question_np);
        this.c = (NumberPicker) findViewById(R.id.np_month);
        this.d = (NumberPicker) findViewById(R.id.np_day);
        this.i = (TextView) findViewById(R.id.tv_question_title);
        this.c.setMinValue(1);
        this.c.setMaxValue(12);
        a(this.d);
        a(this.c);
        a(this.d, getResources().getDrawable(R.color.v2_setting_alph127_black));
        a(this.c, getResources().getDrawable(R.color.v2_setting_alph127_black));
        this.c.setDisplayedValues(this.e);
        this.d.setMinValue(1);
        this.d.setMaxValue(31);
        this.c.setDescendantFocusability(393216);
        this.d.setDescendantFocusability(393216);
        if (!this.r && this.s.aM() == 0) {
            this.c.setValue(this.s.aN());
            this.d.setValue(this.s.aO());
        }
        this.c.setOnValueChangedListener(this.b);
        this.d.setOnValueChangedListener(this.b);
    }

    private void f() {
        this.i.setText("");
        if (!a(f.a)) {
            this.h.setText(getString(R.string.question_wrong_hint));
            this.h.setTextColor(-65536);
        }
        this.t.setBackgroundColor(-1);
        findViewById(R.id.btn_question_ok).setBackgroundDrawable(getResources().getDrawable(R.drawable.l_download_dark_btn));
    }

    private void g() {
        this.q = (Spinner) findViewById(R.id.sp_question);
        this.q.setAdapter(new ArrayAdapter(this, 17367043, this.f));
        this.q.setOnItemSelectedListener(this.a);
        this.q.setSelection(0, true);
        try {
            Field declaredField = Spinner.class.getDeclaredField("mPopup");
            declaredField.setAccessible(true);
            ((ListPopupWindow) declaredField.get(this.q)).setHeight((int) getResources().getDimension(R.dimen.question_spinner_height));
        } catch (Exception e) {
        }
    }

    private void h() {
        f.c = 3;
        f.a = 0;
        if (this.r) {
            m();
            return;
        }
        if (this.o == 1) {
            p.a((Context) this, "Vlocker_Done_Reset_LockSec_PPC_TF", "question", this.s.aQ());
        } else {
            p.a((Context) this, "Vlocker_Done_Reset_LockSec_PPC_TF", "question", this.f[this.s.aM()]);
        }
        Toast.makeText(this, R.string.v2_input_right_forget_password_tip, 0).show();
        finish();
    }

    private void i() {
        if ((f.a != 0 && a(f.a)) || (f.b != 0 && a(f.b))) {
            if (this.h != null) {
                this.h.setText(getString(R.string.v2_input_forget_password_check));
                this.h.setTextColor(-1);
            }
            f.c = 3;
            f.a = 0;
        }
    }

    private void j() {
        if (a(f.a)) {
            if (this.h != null) {
                this.h.startAnimation(this.u);
            }
            if (((AudioManager) getSystemService("audio")).getRingerMode() != 0 && this.s.au()) {
                aa.a(this);
            }
            if (f.c == 1) {
                f.a = new Date().getTime();
                if (this.h != null) {
                    this.h.setText(getString(R.string.setting_question_faild_hint_third));
                    this.h.setTextColor(-65536);
                    return;
                }
                return;
            }
            f.c--;
            if (this.h != null) {
                this.h.setText(getString(R.string.setting_question_faild_hint_left) + f.c + getString(R.string.setting_question_faild_hint_right));
                this.h.setTextColor(-65536);
            }
        }
    }

    private void k() {
        if (this.s.aM() == -1) {
            p.a((Context) this, "Vlocker_Done_LockSec_First_PPC_TF", new String[0]);
        }
    }

    private void l() {
        this.s.p(0);
        this.s.q(0);
    }

    private void m() {
        p.a((Context) this, "Vlocker_Done_Forget_Password_PPC_TF", new String[0]);
        try {
            if (this.s.S()) {
                f.h = 5;
                f.g = false;
                f.d = 0;
            }
            if (this.s.Q()) {
                f.f = 0;
            }
        } catch (Exception e) {
        }
        f.d = 0;
        f.j = true;
        this.s.o(false);
        this.s.q(false);
        f.e = false;
        sendBroadcast(new Intent("action_stop_check"));
    }

    public void a() {
        r.a().a(6, new cc(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 23:
            case BDLocation.TypeOffLineLocation /*66*/:
                if (keyEvent.getAction() == 0) {
                    return true;
                }
                findViewById(R.id.btn_question_ok).performClick();
                return true;
            default:
                return super.dispatchKeyEvent(keyEvent);
        }
    }

    public void onClick(View view) {
        f.b = new Date().getTime();
        i();
        switch (view.getId()) {
            case R.id.tv_question_title:
                finish();
                return;
            case R.id.btn_question_pop:
                if (this.q != null) {
                    this.q.performClick();
                    return;
                }
                return;
            case R.id.btn_question_ok:
                String trim;
                if (this.r) {
                    if (a(f.a)) {
                        switch (this.o) {
                            case 0:
                                if (this.c.getValue() == this.s.aN() && this.d.getValue() == this.s.aO()) {
                                    h();
                                    return;
                                } else {
                                    j();
                                    return;
                                }
                            default:
                                trim = this.l.getText().toString().trim();
                                if (trim == null || "".equals(trim)) {
                                    Toast.makeText(this, R.string.v2_check_forget_password_answer, 0).show();
                                    return;
                                } else if (trim.equals(this.s.aP())) {
                                    h();
                                    return;
                                } else {
                                    j();
                                    return;
                                }
                        }
                    }
                    return;
                } else if (this.w || this.s.aM() == -1) {
                    switch (this.o) {
                        case 0:
                            k();
                            this.s.p(this.c.getValue());
                            this.s.q(this.d.getValue());
                            this.s.o(this.o);
                            h();
                            return;
                        case 1:
                            trim = this.l.getText().toString().trim();
                            String trim2 = this.k.getText().toString().trim();
                            if (trim2 == null || "".equals(trim2)) {
                                Toast.makeText(this, R.string.v2_check_forget_password_question, 0).show();
                                return;
                            } else if (trim == null || "".equals(trim)) {
                                Toast.makeText(this, R.string.v2_check_forget_password_answer, 0).show();
                                return;
                            } else {
                                k();
                                this.s.w(trim);
                                this.s.x(trim2);
                                this.s.o(this.o);
                                l();
                                h();
                                return;
                            }
                        default:
                            trim = this.l.getText().toString().trim();
                            if (trim == null || "".equals(trim)) {
                                Toast.makeText(this, R.string.v2_check_forget_password_answer, 0).show();
                                return;
                            }
                            k();
                            this.s.w(trim);
                            this.s.o(this.o);
                            l();
                            h();
                            return;
                    }
                } else {
                    Toast.makeText(this, R.string.v2_re_setting_locker_tip, 0).show();
                    return;
                }
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        setContentView(R.layout.l_setting_question);
        this.f = getResources().getStringArray(R.array.spinner_array);
        this.e = getResources().getStringArray(R.array.picker_month);
        this.r = getIntent().getBooleanExtra("isForLockerView", false);
        this.s = a.a((Context) this);
        e();
        this.u = AnimationUtils.loadAnimation(this, R.anim.l_shake_x);
        this.m = (Button) findViewById(R.id.btn_question_ok);
        this.j = (TextView) findViewById(R.id.tv_question_main);
        a(this.d, getResources().getDrawable(R.color.textColorPrimary));
        a(this.c, getResources().getDrawable(R.color.textColorPrimary));
        a(this.d, -1);
        a(this.c, -1);
        if (this.r) {
            b();
            a();
        } else if (this.s.aM() == -1) {
            d();
            g();
            this.j.setText(getString(R.string.v2_forget_password_setting_tip));
        } else {
            d();
            g();
            this.j.setText(getString(R.string.v2_rebuild_forget_password_tx));
            switch (this.s.aM()) {
                case 0:
                    this.q.setSelection(0);
                    this.n.setVisibility(0);
                    this.l.setVisibility(8);
                    this.t.setVisibility(8);
                    break;
                case 1:
                    this.q.setSelection(1);
                    this.n.setVisibility(8);
                    this.l.setVisibility(0);
                    this.t.setVisibility(0);
                    this.k.setVisibility(0);
                    this.k.setText(this.s.aQ());
                    this.l.setText(this.s.aP());
                    break;
                default:
                    this.q.setSelection(this.s.aM());
                    this.n.setVisibility(8);
                    this.l.setVisibility(0);
                    this.t.setVisibility(0);
                    this.l.setText(this.s.aP());
                    break;
            }
            this.q.setOnItemSelectedListener(this.a);
            this.l.addTextChangedListener(this.v);
            this.k.addTextChangedListener(this.v);
            this.w = false;
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        i();
        super.onResume();
    }

    protected void onStop() {
        super.onStop();
        if (!this.r) {
            finish();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (!(!z || this.x || this.s == null || this.q == null || this.s.aM() != -1)) {
            this.q.performClick();
        }
        this.x = true;
    }
}
