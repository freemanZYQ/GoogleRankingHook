package com.vlocker.settings;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.vlocker.locker.R;

class ad extends Handler {
    final /* synthetic */ FeedBackActivity a;

    ad(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.a.k.setVisibility(8);
                Toast.makeText(this.a, this.a.getString(R.string.feedback_fail), 0).show();
                return;
            default:
                return;
        }
    }
}
