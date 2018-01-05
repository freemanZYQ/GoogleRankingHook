package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.locker.b.ap;
import com.vlocker.ui.cover.f;
import com.vlocker.ui.widget.a.j;
import com.vlocker.ui.widget.a.m;
import com.vlocker.ui.widget.a.n;
import com.vlocker.ui.widget.c.b;
import com.vlocker.ui.widget.c.d;
import com.vlocker.ui.widget.view.LockNumberPointView;
import com.vlocker.ui.widget.view.a;
import com.vlocker.ui.widget.view.u;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class LockNumberActivityNew extends Activity {
    private float A;
    private float B;
    private boolean C = false;
    boolean a = true;
    String b;
    u c = new av(this);
    OnTouchListener d = new aw(this);
    private TextView e;
    private TextView f;
    private FrameLayout g;
    private ArrayList h;
    private ArrayList i = new ArrayList();
    private j j;
    private n k;
    private boolean l = false;
    private d m;
    private TextView n;
    private LinearLayout o;
    private String[] p;
    private RelativeLayout[] q = new RelativeLayout[10];
    private ImageView[] r = new ImageView[10];
    private RelativeLayout s;
    private NumberPicker t;
    private TextView u;
    private RelativeLayout v;
    private int w = 4;
    private boolean x = false;
    private boolean y = false;
    private float z;

    private void a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.q[i2].setVisibility(0);
        }
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

    private void a(String str) {
        int i = 0;
        if (this.y) {
            while (i < this.p.length) {
                if (TextUtils.isEmpty(this.p[i])) {
                    this.p[i] = str;
                    b(i);
                    if (this.b != null && i == this.b.length() - 1) {
                        b();
                        return;
                    }
                    return;
                }
                i++;
            }
            return;
        }
        while (i < this.p.length) {
            if (TextUtils.isEmpty(this.p[i])) {
                this.p[i] = str;
                b(i);
                if (i == this.w - 1) {
                    this.x = true;
                    return;
                }
                return;
            }
            i++;
        }
    }

    private void a(boolean z) {
        if (!this.C) {
            this.C = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.l_shake_x);
            this.e.postDelayed(new ax(this, z), 400);
            loadAnimation.setAnimationListener(new ay(this, z));
            this.o.startAnimation(loadAnimation);
        }
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

    private void b(int i) {
        if (this.r != null && this.q != null) {
            if (this.y) {
                this.r[i].setSelected(true);
            } else if (i < 10) {
                this.r[i].setSelected(true);
                this.e.setText(getString(R.string.v3_pwd_input_number, new Object[]{(i + 1) + ""}));
            }
            if (i == 0) {
                this.n.setTextColor(getResources().getColor(R.color.flow_word_text));
            }
        }
    }

    private void c() {
        this.r[0] = (ImageView) findViewById(R.id.point1);
        this.r[1] = (ImageView) findViewById(R.id.point2);
        this.r[2] = (ImageView) findViewById(R.id.point3);
        this.r[3] = (ImageView) findViewById(R.id.point4);
        this.r[4] = (ImageView) findViewById(R.id.point5);
        this.r[5] = (ImageView) findViewById(R.id.point6);
        this.r[6] = (ImageView) findViewById(R.id.point7);
        this.r[7] = (ImageView) findViewById(R.id.point8);
        this.r[8] = (ImageView) findViewById(R.id.point9);
        this.r[9] = (ImageView) findViewById(R.id.point10);
        this.q[0] = (RelativeLayout) findViewById(R.id.pwd_rl1);
        this.q[1] = (RelativeLayout) findViewById(R.id.pwd_rl2);
        this.q[2] = (RelativeLayout) findViewById(R.id.pwd_rl3);
        this.q[3] = (RelativeLayout) findViewById(R.id.pwd_rl4);
        this.q[4] = (RelativeLayout) findViewById(R.id.pwd_rl5);
        this.q[5] = (RelativeLayout) findViewById(R.id.pwd_rl6);
        this.q[6] = (RelativeLayout) findViewById(R.id.pwd_rl7);
        this.q[7] = (RelativeLayout) findViewById(R.id.pwd_rl8);
        this.q[8] = (RelativeLayout) findViewById(R.id.pwd_rl9);
        this.q[9] = (RelativeLayout) findViewById(R.id.pwd_rl10);
        this.p = new String[10];
        this.v = (RelativeLayout) findViewById(R.id.relativeLayout1);
        this.e = (TextView) findViewById(R.id.tip);
        this.e.setText(getString(R.string.v3_pwd_input_number, new Object[]{Integer.valueOf(0)}));
        this.o = (LinearLayout) findViewById(R.id.passwordfild);
        this.n = (TextView) findViewById(R.id.del);
        this.n.setOnTouchListener(this.d);
        this.u = (TextView) findViewById(R.id.next);
        this.u.setOnTouchListener(this.d);
        this.f = (TextView) findViewById(R.id.tip_limit);
        this.s = (RelativeLayout) findViewById(R.id.layout_number_pwd_limit_select);
        this.t = (NumberPicker) findViewById(R.id.np_number_pwd_limit);
        this.t.setMinValue(2);
        this.t.setMaxValue(10);
        this.t.setValue(4);
        this.t.setDescendantFocusability(393216);
        a(this.t);
        a(this.t, getResources().getDrawable(R.color.textColorPrimary));
        a(this.t, -1);
        findViewById(R.id.btn_back_main).setOnClickListener(new au(this));
    }

    private void d() {
        int i = 0;
        this.h = new ArrayList();
        this.A = ((m) this.i.get(0)).f;
        this.B = ((m) this.i.get(0)).g;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            float f = ((m) this.i.get(i2)).f;
            float f2 = ((m) this.i.get(i2)).g;
            if (this.A > f) {
                this.A = f;
            }
            if (this.B > f2) {
                this.B = f2;
            }
        }
        while (i < this.i.size()) {
            View lockNumberPointView = new LockNumberPointView(this);
            lockNumberPointView.setPointData((m) this.i.get(i));
            lockNumberPointView.setBankData(this.j);
            lockNumberPointView.setTipData(this.k);
            lockNumberPointView.setTouchListener(this.c);
            this.g.addView(lockNumberPointView, lockNumberPointView.a(this.A, this.B));
            this.h.add(lockNumberPointView);
            i++;
        }
    }

    private void e() {
        this.w = this.t.getValue();
        this.s.setVisibility(8);
        this.g.setVisibility(0);
        a(this.w);
        this.n.setVisibility(0);
        this.u.setVisibility(8);
        this.f.setText(this.w + getString(R.string.number_pws_type_hint_right));
        this.v.setVisibility(0);
        p.a((Context) this, "Vlock_PwDigit_NumberPw_PPC_TF", "num", this.w + "");
    }

    private void f() {
        this.p = new String[10];
        for (ImageView selected : this.r) {
            selected.setSelected(false);
        }
        this.n.setTextColor(getResources().getColor(R.color.l_v3_pwd_gray));
    }

    private void g() {
        Log.i("as", "1");
        int length = this.p.length - 1;
        while (length >= 0) {
            if (TextUtils.isEmpty(this.p[length])) {
                length--;
            } else {
                this.p[length] = null;
                this.r[length].setSelected(false);
                if (!this.y) {
                    this.e.setText(getString(R.string.v3_pwd_input_number, new Object[]{length + ""}));
                    this.x = false;
                }
                if (length == 0) {
                    this.n.setTextColor(getResources().getColor(R.color.l_v3_pwd_gray));
                    return;
                }
                return;
            }
        }
    }

    public void a() {
        this.m = ap.a();
        if (this.m == null || this.m.A == null) {
            this.m = new d();
            b.a((Context) this, this.m);
        }
        if (this.m != null) {
            this.i.addAll(this.m.x);
            this.j = this.m.z;
            this.k = this.m.A;
            a.a((Context) this, this.m, true);
        }
    }

    public void b() {
        String str = "";
        for (int i = 0; i < this.p.length; i++) {
            if (this.p[i] != null) {
                str = str + this.p[i];
            }
        }
        if (!TextUtils.isEmpty(str) && str.length() <= 10 && str.length() >= 2) {
            boolean z;
            if (this.b == null) {
                this.b = str;
                z = true;
            } else {
                z = false;
            }
            com.vlocker.c.a a = com.vlocker.c.a.a((Context) this);
            if (z) {
                this.y = true;
                this.e.setText(getString(R.string.password_check_again_txt));
                f();
                this.x = false;
            } else if (str.equals(this.b)) {
                a.p(str);
                a.q(true);
                a.o(false);
                f.j = true;
                p.a((Context) this, "Vlocker_NumPasswordSum_PPC_TF", new String[0]);
                p.a((Context) this, "Vlocker_Done_NumPassword_PPC_TF", "num", this.w + "", "password", str);
                this.b = null;
                Toast.makeText(this, R.string.settings_pattern_success, 0).show();
                finish();
                if (!a.v()) {
                    QuestionActivity.a((Context) this);
                }
            } else {
                a(false);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(IXAdIOUtils.BUFFER_SIZE, IXAdIOUtils.BUFFER_SIZE);
        setContentView(R.layout.l_locker_number_create2);
        this.g = (FrameLayout) findViewById(R.id.locknum);
        a();
        d();
        c();
        this.b = null;
        this.z = getResources().getDimension(R.dimen.lk_all_pwd_size) / 10.0f;
    }

    protected void onDestroy() {
        int i;
        if (findViewById(R.id.setting_activity_root) != null) {
            findViewById(R.id.setting_activity_root).setBackgroundDrawable(null);
        }
        if (this.h != null && this.h.size() > 0) {
            for (i = 0; i < this.h.size(); i++) {
                ((LockNumberPointView) this.h.get(i)).e();
            }
            this.h.clear();
        }
        if (this.i != null) {
            this.i.clear();
        }
        for (ImageView imageView : this.r) {
            if (imageView != null) {
                imageView.setBackgroundDrawable(null);
            }
        }
        for (RelativeLayout relativeLayout : this.q) {
            if (relativeLayout != null) {
                int childCount = relativeLayout.getChildCount();
                for (i = 0; i < childCount; i++) {
                    relativeLayout.getChildAt(i).setBackgroundDrawable(null);
                }
            }
            relativeLayout.removeAllViews();
        }
        this.g.removeAllViews();
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }
}
