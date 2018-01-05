package com.vlocker.setting;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.R;

class c extends ClickableSpan {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        p.a(this.a.c, "Vlocker_Open_PrivacyPolicy_PPC_YZY", "from", "Rescue");
        this.a.d(2);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a.c.getResources().getColor(R.color.oksetting_agree_tips_text));
    }
}
