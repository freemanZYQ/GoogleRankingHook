package com.vlocker.h;

import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Message;

class f extends Handler {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void handleMessage(Message message) {
        Parameters parameters;
        switch (message.what) {
            case 0:
                if (this.a.a != null) {
                    parameters = this.a.a.getParameters();
                    parameters.setFlashMode("off");
                    this.a.a.setParameters(parameters);
                    return;
                }
                return;
            case 1:
                this.a.a.autoFocus(this.a);
                parameters = this.a.a.getParameters();
                parameters.setFlashMode("on");
                this.a.a.setParameters(parameters);
                this.a.a.stopPreview();
                this.a.a.release();
                this.a.a = null;
                this.a.b = false;
                return;
            default:
                return;
        }
    }
}
