package com.samsung.android.sdk.pass.support.v1;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class FingerprintManagerProxyFactory {

    final class a implements InvocationHandler {
        private Object a;
        private Map b = new HashMap();

        public a(Object obj) {
            this.a = obj;
            Method[] methods = IFingerprintManagerProxy.class.getMethods();
            for (Method method : obj.getClass().getMethods()) {
                String name = method.getName();
                if (a(methods, method)) {
                    this.b.put(name, method);
                }
            }
        }

        private static boolean a(Method[] methodArr, Method method) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            for (Method method2 : methodArr) {
                if (method2.getName().equals(name)) {
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes == null || parameterTypes2 == null) {
                        return true;
                    }
                    if (parameterTypes.length == parameterTypes2.length) {
                        int length = parameterTypes.length;
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                z = true;
                            }
                        }
                        if (!z) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Method method2 = (Method) this.b.get(method.getName());
            return method2 != null ? method2.invoke(this.a, objArr) : null;
        }
    }

    public static IFingerprintManagerProxy create(Context context) {
        Object invoke;
        try {
            invoke = Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Exception e) {
            Log.e("FingerprintManagerProxy", "Cannot create FingerprintManagerProxy : " + e);
            invoke = null;
        }
        if (invoke == null) {
            return null;
        }
        InvocationHandler aVar = new a(invoke);
        return (IFingerprintManagerProxy) Proxy.newProxyInstance(FingerprintManagerProxyFactory.class.getClassLoader(), new Class[]{IFingerprintManagerProxy.class}, aVar);
    }
}
