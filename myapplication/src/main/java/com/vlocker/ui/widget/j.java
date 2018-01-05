package com.vlocker.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.vlocker.b.p;

class j implements OnTouchListener {
    final /* synthetic */ MusicLrcView a;

    j(MusicLrcView musicLrcView) {
        this.a = musicLrcView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.a.A = System.currentTimeMillis();
                MusicLrcView.b = true;
                break;
            case 1:
            case 3:
                if (System.currentTimeMillis() - this.a.A < 200) {
                    p.a(this.a.getContext(), "Vlocker_Doing_MusicLrc_PPC_TF", "music_action_2", "Click_Lrc");
                } else {
                    p.a(this.a.getContext(), "Vlocker_Doing_MusicLrc_PPC_TF", "music_action_2", "Drag_Lrc");
                }
                MusicLrcView.b = false;
                this.a.h = System.currentTimeMillis();
                break;
        }
        return false;
    }
}
