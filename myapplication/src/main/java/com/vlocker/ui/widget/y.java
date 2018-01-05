package com.vlocker.ui.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.modelbase.BaseResp.ErrCode;
import java.lang.ref.WeakReference;

final class y extends Handler {
    private WeakReference a;

    public y(DialogInterface dialogInterface) {
        this.a = new WeakReference(dialogInterface);
    }

    public void handleMessage(Message message) {
        if (message != null && message.obj != null) {
            switch (message.what) {
                case ErrCode.ERR_SENT_FAILED /*-3*/:
                case ErrCode.ERR_USER_CANCEL /*-2*/:
                case -1:
                    if (this.a != null) {
                        DialogInterface dialogInterface = (DialogInterface) this.a.get();
                        if (dialogInterface != null) {
                            ((OnClickListener) message.obj).onClick(dialogInterface, message.what);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }
}
