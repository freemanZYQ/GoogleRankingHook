package com.vlocker.new_theme.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class r implements OnEditorActionListener {
    final /* synthetic */ SearchResultActivity a;

    r(SearchResultActivity searchResultActivity) {
        this.a = searchResultActivity;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.a.j();
        return true;
    }
}
