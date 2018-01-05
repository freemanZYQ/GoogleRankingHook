package com.vlocker.locker.c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.location.LocationClientOption;
import com.vlocker.locker.R;
import com.vlocker.ui.widget.MsgListView;
import com.vlocker.ui.widget.MusicLrcView;

class p implements AnimatorListener {
    final /* synthetic */ b a;

    p(b bVar) {
        this.a = bVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (MusicLrcView.a) {
            ((LayoutParams) this.a.al.getLayoutParams()).topMargin = 0;
            this.a.al.requestLayout();
            this.a.al.setTranslationY(0.0f);
        }
        MsgListView msgListView = (MsgListView) this.a.b.findViewById(R.id.msg_list);
        LayoutParams layoutParams = (LayoutParams) msgListView.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.height = -2;
        msgListView.requestLayout();
        msgListView.setTranslationY(0.0f);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        MsgListView msgListView = (MsgListView) this.a.w.findViewById(R.id.msg_list);
        ((LayoutParams) msgListView.getLayoutParams()).height = LocationClientOption.MIN_SCAN_SPAN;
        msgListView.requestLayout();
    }
}
