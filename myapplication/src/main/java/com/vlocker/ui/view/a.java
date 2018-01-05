package com.vlocker.ui.view;

import android.os.Handler;
import android.os.Message;

class a extends Handler {
    final /* synthetic */ ArtworkView a;

    a(ArtworkView artworkView) {
        this.a = artworkView;
    }

    public void handleMessage(Message message) {
        this.a.k.setRotation(this.a.p);
    }
}
