package com.vlocker.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.vlocker.b.p;

class t implements OnClickListener {
    final /* synthetic */ CustomWallPaperActivity a;

    t(CustomWallPaperActivity customWallPaperActivity) {
        this.a = customWallPaperActivity;
    }

    public void onClick(View view) {
        this.a.d(this.a.getIntent().getStringExtra("image_output_path"));
        p.a(this.a, "Vlocker_Done_Custom_Wallpaper_PPC_TF", new String[0]);
        this.a.x.dismiss();
    }
}
