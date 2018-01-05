package com.vlocker.d;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;

public class c extends Dialog implements OnClickListener {
    private LinearLayout a;
    private LinearLayout b;
    private d c;

    public c(Context context, boolean z, int i, String str, String str2, String str3, d dVar) {
        super(context, i);
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(R.layout.t_market_center_save, null);
        this.c = dVar;
        setContentView(inflate);
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.85d);
        if (displayMetrics.heightPixels == 1800) {
            attributes.height = (int) (((double) displayMetrics.widthPixels) * 0.31d);
        } else {
            attributes.height = (int) (((double) displayMetrics.widthPixels) * 0.38d);
        }
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        this.b = (LinearLayout) inflate.findViewById(R.id.t_close_feedback);
        this.a = (LinearLayout) inflate.findViewById(R.id.t_close_back);
        TextView textView = (TextView) inflate.findViewById(R.id.t_exit_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.seemoretime);
        TextView textView3 = (TextView) inflate.findViewById(R.id.t_exit);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setText(str);
        textView.setTextColor(context.getResources().getColor(R.color.t_market_detail_themename));
        if (z) {
            textView2.setTextColor(context.getResources().getColor(R.color.t_market_detail_themename));
        }
        textView2.setText(str3);
        textView3.setText(str2);
        this.b.setOnClickListener(this);
        this.a.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.t_close_back:
                this.c.b(this);
                return;
            case R.id.t_close_feedback:
                this.c.a(this);
                return;
            default:
                return;
        }
    }
}
