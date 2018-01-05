package com.samsung.android.sdk.pass;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.fingerprint.FingerprintIdentifyDialog.FingerprintListener;
import com.samsung.android.fingerprint.IFingerprintClient;
import com.samsung.android.fingerprint.IFingerprintClient.Stub;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import com.samsung.android.sdk.pass.support.v1.FingerprintManagerProxyFactory;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;

public class SpassFingerprint {
    public static final String ACTION_FINGERPRINT_ADDED = "com.samsung.android.intent.action.FINGERPRINT_ADDED";
    public static final String ACTION_FINGERPRINT_REMOVED = "com.samsung.android.intent.action.FINGERPRINT_REMOVED";
    public static final String ACTION_FINGERPRINT_RESET = "com.samsung.android.intent.action.FINGERPRINT_RESET";
    public static final int STATUS_AUTHENTIFICATION_FAILED = 16;
    public static final int STATUS_AUTHENTIFICATION_PASSWORD_SUCCESS = 100;
    public static final int STATUS_AUTHENTIFICATION_SUCCESS = 0;
    public static final int STATUS_BUTTON_PRESSED = 9;
    public static final int STATUS_OPERATION_DENIED = 51;
    public static final int STATUS_QUALITY_FAILED = 12;
    public static final int STATUS_SENSOR_FAILED = 7;
    public static final int STATUS_TIMEOUT_FAILED = 4;
    public static final int STATUS_USER_CANCELLED = 8;
    public static final int STATUS_USER_CANCELLED_BY_TOUCH_OUTSIDE = 13;
    private static String q = "sdk_version";
    private IFingerprintManagerProxy a;
    private Context b;
    private int c = -1;
    private String d = null;
    private ArrayList e = null;
    private String f = null;
    private int g = -1;
    private String h = null;
    private int i = -1;
    private int[] j = null;
    private boolean k = false;
    private String l = null;
    private String m = null;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean r = false;
    private boolean s = false;
    private IBinder t = null;
    private Dialog u = null;
    private IFingerprintClient v = null;
    private Bundle w = null;
    private IFingerprintClient x = null;
    private Handler y;

    public interface IdentifyListener {
        void onCompleted();

        void onFinished(int i);

        void onReady();

        void onStarted();
    }

    public interface RegisterListener {
        void onFinished();
    }

    final class a {
        private Bundle a = new Bundle();

        public a(String str) {
            if (str != null && str.length() > 0) {
                this.a.putString("appName", str);
            }
        }

        public final a a() {
            this.a.putString(SpassFingerprint.q, "Pass-v" + String.format("%d.%d.%d", new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)}));
            return this;
        }

        public final a a(int[] iArr) {
            if (iArr != null && iArr.length > 0) {
                this.a.putIntArray("request_template_index_list", iArr);
            }
            return this;
        }

        public final Bundle b() {
            return this.a;
        }
    }

    final class b extends Stub {
        private IdentifyListener a;
        private /* synthetic */ SpassFingerprint b;

        private b(SpassFingerprint spassFingerprint, IdentifyListener identifyListener) {
            this.b = spassFingerprint;
            this.a = identifyListener;
        }

        public final void a(IdentifyListener identifyListener) {
            this.a = identifyListener;
        }

        public final void onFingerprintEvent(FingerprintEvent fingerprintEvent) {
            if (fingerprintEvent == null) {
                Log.w("SpassFingerprintSDK", "onFingerprintEvent: null event will be ignored!");
                return;
            }
            try {
                IdentifyListener identifyListener = this.a;
                if (identifyListener != null && this.b.y != null) {
                    this.b.y.post(new c(this, fingerprintEvent, identifyListener));
                    int i = 13;
                    if (this.b.o) {
                        i = 16;
                    }
                    if (fingerprintEvent.eventId == i) {
                        Log.d("SpassFingerprintSDK", "mCompletedEventId: " + i);
                        if (!(this.b.t == null || this.b.a == null)) {
                            this.b.a.unregisterClient(this.b.t);
                            this.b.t = null;
                        }
                        if (this.b.v != null) {
                            this.b.v = null;
                        }
                        identifyListener.onCompleted();
                        this.a = null;
                    }
                }
            } catch (Exception e) {
                Log.w("SpassFingerprintSDK", "onFingerprintEvent: Error : " + e);
            }
        }
    }

    final class c implements FingerprintListener {
        private IdentifyListener a;
        private FingerprintEvent b;
        private /* synthetic */ SpassFingerprint c;

        private c(SpassFingerprint spassFingerprint, IdentifyListener identifyListener) {
            this.c = spassFingerprint;
            this.a = identifyListener;
        }

        public final void a() {
            FingerprintEvent fingerprintEvent = this.b;
            IdentifyListener identifyListener = this.a;
            if (fingerprintEvent != null && identifyListener != null && this.c.y != null) {
                this.c.y.post(new e(this, fingerprintEvent, identifyListener));
                this.a = null;
                this.b = null;
            }
        }

        public final void onEvent(FingerprintEvent fingerprintEvent) {
            try {
                if (fingerprintEvent.eventId == 13 || this.c.y == null) {
                    this.b = fingerprintEvent;
                } else {
                    this.c.y.post(new d(this, fingerprintEvent));
                }
            } catch (Exception e) {
                Log.w("SpassFingerprintSDK", "onFingerprintEvent: Error : " + e);
            }
        }
    }

    public SpassFingerprint(Context context) {
        this.b = context;
        if (this.b == null) {
            throw new IllegalArgumentException("context is null.");
        }
        try {
            this.b.getPackageManager();
            if (!this.r) {
                this.s = this.b.getPackageManager().hasSystemFeature("com.sec.feature.fingerprint_manager_service");
                this.r = true;
            }
            if (this.s) {
                try {
                    Class cls = Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER);
                    Method method = cls.getMethod("getInstance", new Class[]{Context.class});
                    Method method2 = cls.getMethod("getVersion", new Class[0]);
                    Object invoke = method.invoke(null, new Object[]{this.b});
                    if (invoke != null) {
                        this.n = ((Integer) method2.invoke(invoke, new Object[0])).intValue();
                    }
                } catch (Exception e) {
                    Log.w("SpassFingerprintSDK", "getVersion failed : " + e);
                }
                int i = this.n >>> 24;
                if (i > 1) {
                    i = 1;
                }
                if (i > 0) {
                    this.a = FingerprintManagerProxyFactory.create(this.b);
                }
                this.y = new Handler(context.getMainLooper());
            }
            SdkSupporter.copyStaticFields(this, SpassFingerprint.class, SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER, "EVENT_IDENTIFY_");
            if (this.a != null) {
                try {
                    if (this.a.getSensorType() == 2) {
                        this.o = true;
                    }
                } catch (Exception e2) {
                }
            }
        } catch (NullPointerException e3) {
            throw new IllegalArgumentException("context is not valid.");
        }
    }

    static /* synthetic */ int a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 4:
                return 4;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 12:
                return 12;
            case 13:
                return 13;
            case STATUS_OPERATION_DENIED /*51*/:
                return 51;
            case STATUS_AUTHENTIFICATION_PASSWORD_SUCCESS /*100*/:
                return 100;
            default:
                return 16;
        }
    }

    private boolean a(String str) {
        String packageName = this.b.getPackageName();
        try {
            Resources resourcesForApplication = this.b.getPackageManager().getResourcesForApplication(packageName);
            if (resourcesForApplication == null) {
                return false;
            }
            try {
                int identifier = resourcesForApplication.getIdentifier(str, "drawable", packageName);
                return (identifier == 0 || identifier == -1 || BitmapFactory.decodeResource(resourcesForApplication, identifier) == null) ? false : true;
            } catch (NotFoundException e) {
                return false;
            }
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ void b(SpassFingerprint spassFingerprint, String str) {
        if (!g()) {
            return;
        }
        if (spassFingerprint.b.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
            throw new SecurityException();
        }
        Parcelable contentValues = new ContentValues();
        String name = spassFingerprint.getClass().getPackage().getName();
        String stringBuilder = new StringBuilder(String.valueOf(spassFingerprint.b.getPackageName())).append("#8").toString();
        contentValues.put("app_id", name);
        contentValues.put("feature", stringBuilder);
        contentValues.put("extra", str);
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
        intent.putExtra("data", contentValues);
        intent.setPackage("com.samsung.android.providers.context");
        spassFingerprint.b.sendBroadcast(intent);
    }

    private synchronized void f() {
        if (!this.s) {
            throw new UnsupportedOperationException("Fingerprint Service is not supported in the platform.");
        } else if (this.a == null) {
            throw new UnsupportedOperationException("Fingerprint Service is not running on the device.");
        }
    }

    private static boolean g() {
        try {
            Class cls = Class.forName("com.samsung.android.feature.FloatingFeature");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            return ((Boolean) cls.getMethod("getEnableStatus", new Class[]{String.class}).invoke(invoke, new Object[]{"SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE"})).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    final boolean a() {
        return this.s;
    }

    final boolean b() {
        f();
        return this.n >= 16843008;
    }

    final boolean c() {
        Object obj;
        f();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportFingerprintIds", new Class[0]);
            obj = 1;
        } catch (Throwable e) {
            Log.w("SpassFingerprintSDK", e);
            obj = null;
        }
        return obj != null ? this.a.isSupportFingerprintIds() : b();
    }

    public void cancelIdentify() {
        f();
        if (this.t == null && this.v == null && this.u == null) {
            throw new IllegalStateException("No Identify request.");
        }
        if (this.t != null) {
            if (!this.a.cancel(this.t)) {
                throw new IllegalStateException("cancel() returned RESULT_FAILED due to FingerprintService Error.");
            }
        } else if (!(this.v == null && this.u == null)) {
            this.a.notifyAppActivityState(4, null);
        }
        this.v = null;
        this.u = null;
    }

    public void changeStandbyString(String str) {
        f();
        if (d()) {
            throw new IllegalStateException("setStandbyString is not supported.");
        } else if (str == null) {
            throw new IllegalArgumentException("the standby text passed is null.");
        } else if (str.length() > 100) {
            throw new IllegalArgumentException("the standby text passed is longer than 100 characters.");
        } else {
            this.m = str;
        }
    }

    final boolean d() {
        boolean z;
        f();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportBackupPassword", new Class[0]);
            z = true;
        } catch (Throwable e) {
            Log.w("SpassFingerprintSDK", e);
            z = false;
        }
        return z ? this.a.isSupportBackupPassword() : true;
    }

    public String getGuideForPoorQuality() {
        f();
        if (this.d != null) {
            return this.d;
        }
        throw new IllegalStateException("FingerprintGuide is Invalid. This API must be called inside IdentifyListener.onFinished() with STATUS_QUALITY_FAILED only.");
    }

    public int getIdentifiedFingerprintIndex() {
        f();
        if (this.c != -1) {
            return this.c;
        }
        throw new IllegalStateException("FingerprintIndex is Invalid. This API must be called inside IdentifyListener.onFinished() only.");
    }

    public SparseArray getRegisteredFingerprintName() {
        f();
        SparseArray sparseArray = new SparseArray();
        int enrolledFingers = this.a.getEnrolledFingers();
        if (enrolledFingers <= 0) {
            return null;
        }
        for (int i = 1; i <= 10; i++) {
            if (((1 << i) & enrolledFingers) != 0) {
                sparseArray.put(i, this.a.getIndexName(i));
            }
        }
        return sparseArray;
    }

    public SparseArray getRegisteredFingerprintUniqueID() {
        f();
        if (c()) {
            SparseArray sparseArray = new SparseArray();
            int enrolledFingers = this.a.getEnrolledFingers();
            if (enrolledFingers <= 0) {
                return null;
            }
            for (int i = 1; i <= 10; i++) {
                if (((1 << i) & enrolledFingers) != 0) {
                    sparseArray.put(i, this.a.getFingerprintId(i));
                }
            }
            return sparseArray;
        }
        throw new IllegalStateException("getRegisteredFingerprintUniqueID is not supported.");
    }

    public boolean hasRegisteredFinger() {
        f();
        return this.a.getEnrolledFingers() != 0;
    }

    public void registerFinger(Context context, RegisterListener registerListener) {
        f();
        if (context == null) {
            throw new IllegalArgumentException("activityContext passed is null.");
        } else if (registerListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        } else {
            if (this.a.isEnrolling()) {
                this.a.notifyEnrollEnd();
            }
            try {
                context.getPackageManager();
                try {
                    this.a.startEnrollActivity(context, new b(registerListener), toString());
                } catch (UndeclaredThrowableException e) {
                    throw new IllegalArgumentException("activityContext is invalid");
                }
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("activityContext is invalid");
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        f();
        if (b()) {
            this.k = z;
            return;
        }
        throw new IllegalStateException("setCanceledOnTouchOutside is not supported.");
    }

    public void setDialogBgTransparency(int i) {
        f();
        if (!b()) {
            throw new IllegalStateException("setDialogBGTransparency is not supported.");
        } else if (i < 0 || i > 255) {
            throw new IllegalArgumentException("the transparency passed is not valid.");
        } else {
            this.i = i;
        }
    }

    public void setDialogButton(String str) {
        f();
        if (d()) {
            throw new IllegalStateException("setDialogButton is not supported.");
        } else if (str == null) {
            throw new IllegalArgumentException("the buttonText passed is null.");
        } else if (str.length() > 32) {
            throw new IllegalArgumentException("the title text passed is longer than 32 characters.");
        } else {
            this.l = str;
        }
    }

    public void setDialogIcon(String str) {
        f();
        if (!b()) {
            throw new IllegalStateException("setDialogIcon is not supported.");
        } else if (str == null) {
            throw new IllegalArgumentException("the iconName passed is null.");
        } else if (a(str)) {
            this.h = str;
        } else {
            throw new IllegalArgumentException("the iconName passed is not valid.");
        }
    }

    public void setDialogTitle(String str, int i) {
        f();
        if (!b()) {
            throw new IllegalStateException("setDialogTitle is not supported.");
        } else if (str == null) {
            throw new IllegalArgumentException("the titletext passed is null.");
        } else if (str.length() > 256) {
            throw new IllegalArgumentException("the title text passed is longer than 256 characters.");
        } else if ((i >>> 24) != 0) {
            throw new IllegalArgumentException("alpha value is not supported in the titleColor.");
        } else {
            this.f = str;
            this.g = -16777216 + i;
        }
    }

    public void setIntendedFingerprintIndex(ArrayList arrayList) {
        f();
        if (arrayList == null) {
            Log.w("SpassFingerprintSDK", "requestedIndex is null. Identify is carried out for all indexes.");
        } else if (b()) {
            this.e = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                this.e.add((Integer) arrayList.get(i));
            }
        } else {
            throw new IllegalStateException("setIntendedFingerprintIndex is not supported.");
        }
    }

    public void startIdentify(IdentifyListener identifyListener) {
        f();
        if (identifyListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        } else if (this.t != null) {
            throw new IllegalStateException("Identify request is denied because a previous request is still in progress.");
        } else {
            if (this.x == null) {
                this.x = new b(identifyListener);
            }
            if (this.e != null) {
                this.j = new int[this.e.size()];
                for (int i = 0; i < this.e.size(); i++) {
                    this.j[i] = ((Integer) this.e.get(i)).intValue();
                }
            }
            this.w = new a(this.b.getPackageName()).a(this.j).a().b();
            this.t = this.a.registerClient(this.x, this.w);
            if (this.t == null) {
                throw new IllegalStateException("failed because registerClient returned null.");
            }
            int identify = this.a.identify(this.t, null);
            if (identify == -2) {
                this.a.unregisterClient(this.t);
                this.t = null;
                throw new IllegalStateException("Identify request is denied because a previous request is still in progress.");
            } else if (identify == 51) {
                this.a.unregisterClient(this.t);
                this.t = null;
                throw new SpassInvalidStateException("Identify request is denied because 5 identify attempts are failed.", 1);
            } else if (identify != 0) {
                if (this.a.hasPendingCommand()) {
                    this.a.cancel(this.t);
                }
                this.a.unregisterClient(this.t);
                this.t = null;
                throw new IllegalStateException("Identify operation is failed.");
            } else {
                ((b) this.x).a(identifyListener);
                this.e = null;
                this.j = null;
            }
        }
    }

    public void startIdentifyWithDialog(Context context, IdentifyListener identifyListener, boolean z) {
        f();
        if (context == null) {
            throw new IllegalArgumentException("activityContext passed is null.");
        } else if (identifyListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        } else {
            try {
                context.getPackageManager();
                if (b()) {
                    if (this.e != null && this.e.size() > 0) {
                        this.j = new int[this.e.size()];
                        for (int i = 0; i < this.e.size(); i++) {
                            this.j[i] = ((Integer) this.e.get(i)).intValue();
                        }
                    }
                    this.v = new b(identifyListener);
                    try {
                        String format = String.format("%d.%d.%d", new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("password", z);
                        bundle.putString("packageName", context.getPackageName());
                        bundle.putString(q, "Pass-v" + format);
                        bundle.putBoolean("demandExtraEvent", true);
                        if (this.j != null) {
                            bundle.putIntArray("request_template_index_list", this.j);
                        }
                        if (this.f != null) {
                            bundle.putString("titletext", this.f);
                        }
                        if (this.g != -1) {
                            bundle.putInt("titlecolor", this.g);
                        }
                        if (this.h != null) {
                            bundle.putString("iconname", this.h);
                        }
                        if (this.i != -1) {
                            bundle.putInt("transparency", this.i);
                        }
                        if (this.k) {
                            bundle.putBoolean("touchoutside", this.k);
                        }
                        if (this.l != null) {
                            bundle.putString("button_name", this.l);
                        }
                        if (this.m != null) {
                            bundle.putString("standby_string", this.m);
                        }
                        if (this.a.identifyWithDialog(context, this.v, bundle) != 0) {
                            throw new IllegalStateException("Identify operation is failed.");
                        }
                    } finally {
                        this.e = null;
                        this.j = null;
                        this.f = null;
                        this.g = -1;
                        this.i = -1;
                        this.h = null;
                        this.k = false;
                        this.m = null;
                        this.l = null;
                    }
                } else {
                    c cVar = new c(identifyListener);
                    this.u = this.a.showIdentifyDialog(context, cVar, null, z);
                    if (this.u == null) {
                        throw new IllegalStateException("Identify operation is failed.");
                    }
                    this.u.setOnDismissListener(new a(cVar));
                    this.u.show();
                }
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("activityContext is invalid");
            }
        }
    }
}
