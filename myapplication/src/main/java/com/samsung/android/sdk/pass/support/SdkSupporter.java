package com.samsung.android.sdk.pass.support;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SdkSupporter {
    public static final String CLASSNAME_FINGERPRINT_CLIENT = "com.samsung.android.fingerprint.IFingerprintClient$Stub";
    public static final String CLASSNAME_FINGERPRINT_CLIENT_SPEC_BUILDER = "com.samsung.android.fingerprint.FingerprintManager$FingerprintClientSpecBuilder";
    public static final String CLASSNAME_FINGERPRINT_MANAGER = "com.samsung.android.fingerprint.FingerprintManager";

    public static boolean copyStaticFields(Object obj, Class cls, String str, String str2) {
        try {
            Field[] fields = Class.forName(str).getFields();
            Map hashMap = new HashMap();
            for (Field field : fields) {
                hashMap.put(field.getName(), field);
            }
            for (Field field2 : cls.getFields()) {
                String name = field2.getName();
                if (str2 == null || name.startsWith(str2)) {
                    Field field3 = (Field) hashMap.get(name);
                    if (field3 != null && field3.getType().equals(field2.getType())) {
                        field2.set(obj, field3.get(null));
                    }
                }
            }
        } catch (Exception e) {
            Log.w("SdkSupporter", "copyFields: failed - " + e);
        }
        return true;
    }
}
