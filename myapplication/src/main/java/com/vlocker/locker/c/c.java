package com.vlocker.locker.c;

import android.content.Intent;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.vlocker.theme.activity.UnlockTextEditActivity;

class c implements OnLongClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public boolean onLongClick(View view) {
        Intent intent = new Intent(this.a.a, UnlockTextEditActivity.class);
        intent.setFlags(268468224);
        this.a.a.startActivity(intent);
        return true;
    }
}
