package com.vlocker.settings;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

class ca implements OnItemSelectedListener {
    boolean a = true;
    final /* synthetic */ QuestionActivity b;

    ca(QuestionActivity questionActivity) {
        this.b = questionActivity;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        TextView textView = (TextView) view;
        if (i == 1) {
            textView.setTextColor(0);
        } else {
            textView.setTextColor(-1);
        }
        if (this.a) {
            this.a = false;
            return;
        }
        this.b.o = i;
        if (i != this.b.s.aM()) {
            this.b.c();
        }
        this.b.a(i);
        switch (i) {
            case 0:
                this.b.l.setVisibility(8);
                this.b.t.setVisibility(8);
                this.b.k.setVisibility(8);
                this.b.n.setVisibility(0);
                return;
            case 1:
                this.b.n.setVisibility(8);
                this.b.l.setVisibility(0);
                this.b.t.setVisibility(0);
                this.b.k.setVisibility(0);
                return;
            default:
                this.b.l.setVisibility(0);
                this.b.t.setVisibility(0);
                this.b.k.setVisibility(8);
                this.b.n.setVisibility(8);
                return;
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
