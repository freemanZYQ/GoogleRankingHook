package com.vlocker.setting;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.R;

class b extends ClickableSpan {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        p.a(this.a.c, "Vlocker_Open_TermOfService_PPC_YZY", "from", "Rescue");
        this.a.d(1);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a.c.getResources().getColor(R.color.oksetting_agree_tips_text));
    }
}
