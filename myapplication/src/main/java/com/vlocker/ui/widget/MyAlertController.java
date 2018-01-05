package com.vlocker.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.sdk.modelbase.BaseResp.ErrCode;
import com.vlocker.locker.R;
import com.vlocker.m.l;

public class MyAlertController {
    private Button A;
    private CharSequence B;
    private Message C;
    private boolean D = true;
    private Button E;
    private CharSequence F;
    private Message G;
    private ScrollView H;
    private HorizontalScrollView I;
    private TextView J;
    private TextView K;
    private View L;
    private View M;
    private TextView N;
    private View O;
    private boolean P;
    private ListAdapter Q;
    private int R = -1;
    private Handler S;
    private boolean T = true;
    private boolean U = false;
    private boolean V = false;
    public boolean a = false;
    OnClickListener b = new o(this);
    private final Context c;
    private final DialogInterface d;
    private final Window e;
    private LinearLayout f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private CharSequence j;
    private ListView k;
    private View l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u = false;
    private boolean v = true;
    private Button w;
    private CharSequence x;
    private Message y;
    private boolean z = true;

    public class RecycleListView extends ListView {
        boolean a = true;

        public RecycleListView(Context context) {
            super(context);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecycleListView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        protected boolean recycleOnMeasure() {
            return this.a;
        }
    }

    public MyAlertController(Context context, DialogInterface dialogInterface, Window window) {
        this.c = context;
        this.d = dialogInterface;
        this.e = window;
        this.S = new y(dialogInterface);
    }

    private void a(Button button) {
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.width = -1;
        button.setLayoutParams(layoutParams);
        if (button == this.w) {
            button.setBackgroundResource(this.p ? R.drawable.l_dialog_right_button_warning_bg : R.drawable.l_dialog_right_button_bg);
        } else if (button == this.A) {
            button.setBackgroundResource(R.drawable.l_dialog_left_button_bg);
        }
        this.e.findViewById(R.id.btn2_solid_split_line).setVisibility(8);
        this.e.findViewById(R.id.btn3_solid_split_line).setVisibility(8);
    }

    private void a(LinearLayout linearLayout) {
        int i = R.id.scrollView2;
        if (this.V) {
            this.e.findViewById(R.id.scrollView).setVisibility(8);
            this.e.findViewById(R.id.scrollView2).setVisibility(0);
        } else {
            this.e.findViewById(R.id.scrollView2).setVisibility(8);
            this.e.findViewById(R.id.scrollView).setVisibility(0);
        }
        this.H = (ScrollView) this.e.findViewById(this.V ? R.id.scrollView2 : R.id.scrollView);
        this.H.setFocusable(false);
        this.H.getViewTreeObserver().addOnGlobalLayoutListener(new q(this));
        this.I = (HorizontalScrollView) this.e.findViewById(R.id.horizontalScrollView);
        this.I.setFocusable(false);
        this.N = (TextView) this.e.findViewById(this.V ? R.id.message2 : R.id.message);
        if (this.N != null) {
            if (this.j != null) {
                this.N.setText(this.j);
                if (this.V) {
                    this.e.findViewById(R.id.horizontalScrollView).setBackgroundDrawable(null);
                    return;
                } else {
                    this.e.findViewById(R.id.scrollView).setBackgroundDrawable(null);
                    return;
                }
            }
            this.N.setVisibility(8);
            if (this.V) {
                this.I.removeView(this.N);
                this.H.removeView(this.I);
            } else {
                this.H.removeView(this.N);
            }
            if (this.k != null) {
                if (this.V) {
                    this.k.setBackgroundDrawable(this.I.getBackground());
                } else {
                    this.k.setBackgroundDrawable(this.H.getBackground());
                }
                Window window = this.e;
                if (!this.V) {
                    i = R.id.scrollView;
                }
                linearLayout.removeView(window.findViewById(i));
                linearLayout.addView(this.k, new LayoutParams(-1, -1));
                linearLayout.setLayoutParams(new LayoutParams(-1, 0, 1.0f));
                return;
            }
            linearLayout.setVisibility(8);
            if (this.e.findViewById(R.id.customPanel).getVisibility() == 8) {
                this.e.findViewById(R.id.centerPanel_dotted_split_line_color).setVisibility(8);
            }
        }
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        a((LinearLayout) this.e.findViewById(R.id.contentPanel));
        e();
        boolean d = d();
        if (this.l != null) {
            FrameLayout frameLayout = (FrameLayout) this.e.findViewById(R.id.customPanel);
            frameLayout.setVisibility(0);
            if (d) {
                this.e.findViewById(R.id.centerPanel_dotted_split_line_color).setVisibility(0);
            } else {
                this.e.findViewById(R.id.centerPanel_dotted_split_line_color).setVisibility(8);
            }
            if (this.U) {
                this.e.findViewById(R.id.parentPanel).setBackgroundColor(this.e.getContext().getResources().getColor(17170445));
            }
            LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.custom_view);
            if (this.m) {
                linearLayout.setPadding(0, 0, 0, 0);
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            linearLayout.addView(this.l, layoutParams);
            if (this.u) {
                linearLayout.setPadding(this.q, this.r, this.s, this.t);
            }
            if (this.k != null) {
                ((LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
        } else {
            this.e.findViewById(R.id.customPanel).setVisibility(8);
            if (this.e.findViewById(R.id.contentPanel).getVisibility() == 8) {
                this.e.findViewById(R.id.centerPanel_dotted_split_line_color).setVisibility(8);
            }
        }
        if (this.n) {
            int a = l.a(this.c, 18.0f);
            int a2 = l.a(this.c, 16.0f);
            this.e.findViewById(R.id.custom_view).setPadding(a, 0, a, a2);
            this.e.findViewById(R.id.contentPanel).setPadding(a, 0, a, a2);
            this.e.findViewById(R.id.centerPanel_dotted_split_line_color).setVisibility(8);
        }
        if (this.k != null && this.Q != null) {
            this.k.setAdapter(this.Q);
            if (this.R > -1) {
                this.k.setItemChecked(this.R, true);
                this.k.setSelection(this.R);
            }
        }
    }

    private boolean d() {
        this.f = (LinearLayout) this.e.findViewById(R.id.topPanel);
        if (this.O != null) {
            this.f.addView(this.O, new LayoutParams(-1, -2));
            this.e.findViewById(R.id.title_template).setVisibility(8);
            return true;
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.J = (TextView) this.e.findViewById(R.id.alertTitle);
            this.J.getPaint().setFakeBoldText(true);
            this.J.setText(this.g);
            if (!TextUtils.isEmpty(this.h)) {
                this.K = (TextView) this.e.findViewById(R.id.alertTitle2);
                this.K.setVisibility(0);
                this.K.getPaint().setFakeBoldText(true);
                this.K.setText(this.h);
            }
            this.L = this.e.findViewById(R.id.logo1);
            this.M = this.e.findViewById(R.id.logo2);
            a(this.i);
            return true;
        }
        this.e.findViewById(R.id.title_template).setVisibility(8);
        this.f.setVisibility(8);
        return false;
    }

    private boolean e() {
        int i;
        int a = l.a(this.c, 6.0f) / 2;
        this.w = (Button) this.e.findViewById(R.id.button1);
        this.w.setOnClickListener(this.b);
        if (TextUtils.isEmpty(this.x)) {
            this.w.setVisibility(8);
            i = 0;
        } else {
            this.w.setText(this.x);
            this.w.setVisibility(0);
            this.w.getPaint().setFakeBoldText(true);
            this.w.setBackgroundResource(this.p ? R.drawable.l_dialog_right_button_warning_bg : R.drawable.l_dialog_right_button_bg);
            l.a(this.w, a, -3, a, -3);
            i = 1;
        }
        this.A = (Button) this.e.findViewById(R.id.button2);
        this.A.setOnClickListener(this.b);
        if (TextUtils.isEmpty(this.B)) {
            this.A.setVisibility(8);
            this.e.findViewById(R.id.btn2_solid_split_line).setVisibility(8);
        } else {
            this.A.setText(this.B);
            this.A.setVisibility(0);
            this.A.getPaint().setFakeBoldText(true);
            this.A.setTextColor(this.c.getResources().getColor(this.o ? R.color.dialog_text_normal : R.color.dialog_text_disable));
            l.a(this.A, a, -3, a, -3);
            i |= 2;
        }
        this.E = (Button) this.e.findViewById(R.id.button3);
        this.E.setOnClickListener(this.b);
        if (TextUtils.isEmpty(this.F)) {
            this.E.setVisibility(8);
            this.e.findViewById(R.id.btn3_solid_split_line).setVisibility(8);
        } else {
            this.E.setText(this.F);
            this.E.setVisibility(0);
            this.E.getPaint().setFakeBoldText(true);
            l.a(this.E, a, -3, a, -3);
            i |= 4;
        }
        if (i == 1) {
            a(this.w);
        } else if (i == 2) {
            a(this.A);
        } else if (i == 4) {
            a(this.E);
        }
        View findViewById = this.e.findViewById(R.id.buttonPanel);
        findViewById.setPadding(l.a(this.c, 1.0f) + a, a, l.a(this.c, 1.0f) + a, l.a(this.c, 3.0f) + a);
        if (i == 0) {
            findViewById.setVisibility(8);
            this.e.findViewById(R.id.bottom_solid_split_line).setVisibility(8);
        }
        return i != 0;
    }

    public void a() {
        this.e.requestFeature(1);
        if (this.l == null || !a(this.l)) {
            this.e.setFlags(131072, 131072);
        }
        this.e.setContentView(R.layout.l_my_alert_dialog);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.e.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        WindowManager.LayoutParams attributes = this.e.getAttributes();
        if (i <= 240 || i2 <= 320) {
            attributes.width = i;
        } else {
            attributes.width = (int) (315.0f * f);
        }
        attributes.gravity = 17;
        attributes.height = -2;
        this.e.setAttributes(attributes);
        this.e.setBackgroundDrawableResource(R.drawable.l_trans_piece);
        c();
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.S.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case ErrCode.ERR_SENT_FAILED /*-3*/:
                this.F = charSequence;
                this.G = message;
                return;
            case ErrCode.ERR_USER_CANCEL /*-2*/:
                this.B = charSequence;
                this.C = message;
                return;
            case -1:
                this.x = charSequence;
                this.y = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.l = view;
        this.u = true;
        this.q = i;
        this.r = i2;
        this.s = i3;
        this.t = i4;
    }

    public void a(CharSequence charSequence) {
        this.g = charSequence;
        if (this.J != null) {
            this.J.setText(charSequence);
        }
    }

    public void a(boolean z) {
        this.i = z;
        if (z) {
            if (this.f != null) {
                this.f.setBackgroundResource(R.drawable.l_dialog_title_bg);
            }
            if (this.J != null) {
                this.J.setVisibility(8);
            }
            if (this.K != null) {
                this.K.setVisibility(8);
            }
            if (this.L != null) {
                this.L.setVisibility(0);
            }
            if (this.M != null) {
                this.M.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f != null) {
            this.f.setBackgroundDrawable(null);
        }
        if (this.J != null) {
            this.J.setVisibility(0);
        }
        if (this.K != null) {
            this.K.setVisibility(0);
        }
        if (this.L != null) {
            this.L.setVisibility(8);
        }
        if (this.M != null) {
            this.M.setVisibility(8);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.H != null && this.H.executeKeyEvent(keyEvent);
    }

    public void b() {
        if (this.a && (this.c instanceof Activity)) {
            int height;
            WindowManager windowManager = ((Activity) this.c).getWindowManager();
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                if (defaultDisplay != null) {
                    height = defaultDisplay.getHeight();
                    if (height > 0 && this.d != null && (this.d instanceof Dialog)) {
                        Window window = ((Dialog) this.d).getWindow();
                        height = (height * 6) / 10;
                        Handler pVar = new p(this);
                        pVar.sendMessage(pVar.obtainMessage(0, height, 0, window));
                        return;
                    }
                    return;
                }
            }
            height = 0;
            if (height > 0) {
            }
        }
    }

    public void b(View view) {
        this.O = view;
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if (this.N != null) {
            this.N.setText(charSequence);
        }
    }

    public void b(boolean z) {
        this.m = z;
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.H != null && this.H.executeKeyEvent(keyEvent);
    }

    public void c(View view) {
        this.l = view;
        this.u = false;
    }

    public void c(CharSequence charSequence) {
        this.h = charSequence;
        if (this.K != null) {
            this.K.setVisibility(0);
            this.K.setText(charSequence);
        }
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void d(boolean z) {
        this.o = z;
        if (this.A != null) {
            this.A.setTextColor(this.c.getResources().getColor(this.o ? R.color.dialog_text_normal : R.color.dialog_text_disable));
        }
    }

    public void e(boolean z) {
        this.p = z;
        if (this.w != null) {
            this.w.setBackgroundResource(this.p ? R.drawable.l_dialog_right_button_warning_bg : R.drawable.l_dialog_right_button_bg);
        }
    }

    public void f(boolean z) {
        this.P = z;
    }
}
