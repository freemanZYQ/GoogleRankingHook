package com.vlocker.new_theme.activity;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import java.util.TimerTask;

class s extends TimerTask {
    final /* synthetic */ SearchResultActivity a;

    s(SearchResultActivity searchResultActivity) {
        this.a = searchResultActivity;
    }

    public void run() {
        Context context = this.a.v.getContext();
        SearchResultActivity searchResultActivity = this.a;
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
