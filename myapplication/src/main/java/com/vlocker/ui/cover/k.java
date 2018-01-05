package com.vlocker.ui.cover;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.Build.VERSION;
import com.android.internal.widget.LockPatternUtils;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class k {
    private static KeyguardLock a = null;
    private static KeyguardManager b = null;

    public static void a(Context context, boolean z) {
        try {
            if (b == null || a == null) {
                b = (KeyguardManager) context.getSystemService("keyguard");
                a = b.newKeyguardLock("VlockerLock" + System.currentTimeMillis());
            }
            if (!b.inKeyguardRestrictedInputMode()) {
                a.disableKeyguard();
            } else if (z) {
                a.disableKeyguard();
            }
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context) {
        try {
            if (VERSION.SDK_INT > 22) {
                return c(context);
            }
            switch (new LockPatternUtils(context).getActivePasswordQuality()) {
                case 3:
                case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                case 65536:
                case 131072:
                case 196608:
                case 262144:
                case 327680:
                case 393216:
                case 397312:
                    return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Context context, boolean z) {
        try {
            if (b == null || a == null) {
                b = (KeyguardManager) context.getSystemService("keyguard");
                a = b.newKeyguardLock("VlockerLock" + System.currentTimeMillis());
            }
            if (!b.inKeyguardRestrictedInputMode()) {
                a.reenableKeyguard();
            } else if (z) {
                a.reenableKeyguard();
            }
        } catch (Exception e) {
        }
    }

    public static boolean b(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            return false;
        }
    }

    @TargetApi(16)
    private static boolean c(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
    }
}
