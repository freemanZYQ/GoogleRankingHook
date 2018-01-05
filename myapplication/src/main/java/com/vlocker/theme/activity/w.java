package com.vlocker.theme.activity;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.at;
import android.support.v7.widget.bg;
import android.view.View;

public class w extends at {
    final /* synthetic */ UnlockTextEditActivity a;
    private int b;

    public w(UnlockTextEditActivity unlockTextEditActivity, int i) {
        this.a = unlockTextEditActivity;
        this.b = i;
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, bg bgVar) {
        if (recyclerView.e(view) == 0) {
            rect.left = this.b * 2;
            rect.right = this.b;
        } else if (recyclerView.e(view) == this.a.j.size() - 1) {
            rect.left = this.b;
            rect.right = this.b * 2;
        } else {
            rect.left = this.b;
            rect.right = this.b;
        }
    }
}
