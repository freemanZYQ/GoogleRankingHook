package com.vlocker.settings;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.notification.msg.open.FlowWebViewActivity;

class ac implements OnClickListener {
    final /* synthetic */ FeedBackActivity a;

    ac(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.add_image:
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                this.a.startActivityForResult(intent, 1);
                return;
            case R.id.btn_commit:
                if (!this.a.n) {
                    if (FeedBackActivity.a) {
                        p.a(this.a, "Vlocker_Click_Send_Feedback_PPC_TF", "status", "Out");
                    } else {
                        p.a(this.a, "Vlocker_Click_Send_Feedback_PPC_TF", "status", "In_Help");
                    }
                }
                this.a.f();
                return;
            case R.id.delete_img:
                this.a.e();
                return;
            case R.id.join_qq_group_number:
                p.a(this.a, "Vlocker_Click_QQ_Group_PPC_TF", new String[0]);
                this.a.b();
                return;
            case R.id.tv_feedback_question:
                p.a(this.a, "Vlocker_Click_FeedbackQuestion_PPC_TF", "from", "feedback");
                intent = new Intent(this.a, FlowWebViewActivity.class);
                intent.putExtra("tag", "normal_question");
                intent.putExtra("title", this.a.getString(R.string.feedback_normal_question));
                intent.putExtra("url", "http://mobile.moxiu.com/misc/?do=Vlocker.Help");
                this.a.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
