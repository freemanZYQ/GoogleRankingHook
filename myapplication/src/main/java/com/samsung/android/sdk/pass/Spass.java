package com.samsung.android.sdk.pass;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

public class Spass implements SsdkInterface {
    public static final int DEVICE_FINGERPRINT = 0;
    public static final int DEVICE_FINGERPRINT_AVAILABLE_PASSWORD = 4;
    public static final int DEVICE_FINGERPRINT_CUSTOMIZED_DIALOG = 2;
    public static final int DEVICE_FINGERPRINT_FINGER_INDEX = 1;
    public static final int DEVICE_FINGERPRINT_UNIQUE_ID = 3;
    private SpassFingerprint a;

    private static boolean a() {
        try {
            Class cls = Class.forName("com.samsung.android.feature.FloatingFeature");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("getEnableStatus", new Class[]{String.class}).invoke(invoke, new Object[]{"SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE"})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    public int getVersionCode() {
        return 8;
    }

    public String getVersionName() {
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
    }

    public void initialize(Context context) {
        if (this.a == null) {
            if (context == null) {
                throw new IllegalArgumentException("context passed is null.");
            }
            try {
                if (a()) {
                    if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                        throw new SecurityException();
                    }
                    Parcelable contentValues = new ContentValues();
                    String name = getClass().getPackage().getName();
                    String str = context.getPackageName() + "#" + getVersionCode();
                    contentValues.put("app_id", name);
                    contentValues.put("feature", str);
                    Intent intent = new Intent();
                    intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
                    intent.putExtra("data", contentValues);
                    intent.setPackage("com.samsung.android.providers.context");
                    context.sendBroadcast(intent);
                }
                if (SsdkVendorCheck.isSamsungDevice()) {
                    this.a = new SpassFingerprint(context);
                    if (!this.a.a()) {
                        throw new SsdkUnsupportedException("This device does not provide FingerprintService.", 1);
                    }
                    return;
                }
                throw new SsdkUnsupportedException("This is not Samsung device.", 0);
            } catch (SecurityException e) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("context is not valid.");
            }
        }
    }

    public boolean isFeatureEnabled(int i) {
        if (this.a == null) {
            throw new IllegalStateException("initialize() is not Called first.");
        }
        switch (i) {
            case 0:
                return this.a.a();
            case 1:
            case 2:
                return this.a.b();
            case 3:
                return this.a.c();
            case 4:
                return this.a.d();
            default:
                throw new IllegalArgumentException("type passed is not valid");
        }
    }
}
