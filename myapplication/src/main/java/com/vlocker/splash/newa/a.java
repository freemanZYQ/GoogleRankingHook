package com.vlocker.splash.newa;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.vlocker.theme.imageloader.RecyclingImageView;

public abstract class a {
    protected a e;
    protected Activity f;
    protected RecyclingImageView g;

    public abstract void a();

    public void a(Context context) {
        this.f = (Activity) context;
    }

    protected void a(com.moxiu.b.a.a aVar) {
        try {
            if (!TextUtils.isEmpty(aVar.w()) && b() != null) {
                b().a(aVar.w(), 1, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(RecyclingImageView recyclingImageView) {
        this.g = recyclingImageView;
    }

    public RecyclingImageView b() {
        return this.g;
    }
}
