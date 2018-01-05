package com.samsung.android.sdk.pass.support;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.samsung.android.fingerprint.FingerprintIdentifyDialog.FingerprintListener;
import com.samsung.android.fingerprint.FingerprintManager.EnrollFinishListener;
import com.samsung.android.fingerprint.IFingerprintClient;

public interface IFingerprintManagerProxy {
    boolean cancel(IBinder iBinder);

    int getEnrolledFingers();

    String getFingerprintId(int i);

    String getIndexName(int i);

    int getSensorType();

    int getVersion();

    boolean hasPendingCommand();

    int identify(IBinder iBinder, String str);

    int identifyWithDialog(Context context, IFingerprintClient iFingerprintClient, Bundle bundle);

    boolean isEnrolling();

    boolean isSupportBackupPassword();

    boolean isSupportFingerprintIds();

    void notifyAppActivityState(int i, Bundle bundle);

    boolean notifyEnrollEnd();

    IBinder registerClient(IFingerprintClient iFingerprintClient, Bundle bundle);

    Dialog showIdentifyDialog(Context context, FingerprintListener fingerprintListener, String str, boolean z);

    boolean startEnrollActivity(Context context, EnrollFinishListener enrollFinishListener, String str);

    boolean unregisterClient(IBinder iBinder);
}
