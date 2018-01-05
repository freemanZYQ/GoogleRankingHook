package com.vlocker.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;

public class V2SettingHeaderBar extends LinearLayout {
    private TextView a;
    private bg b;

    public V2SettingHeaderBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        this.a = (TextView) findViewById(R.id.my_back);
        if (this.a != null) {
            this.a.setOnClickListener(new bf(this));
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    public void setBackOnClickListener(bg bgVar) {
        this.b = bgVar;
    }

    public void setTitle(String str) {
        this.a.setText(str);
    }
}
