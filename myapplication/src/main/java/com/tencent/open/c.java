package com.tencent.open;

import com.tencent.open.a.j;
import java.lang.reflect.Method;
import java.util.List;

public class c {
    public void call(String str, List list, b bVar) {
        Method method = null;
        for (Method method2 : getClass().getDeclaredMethods()) {
            if (method2.getName().equals(str) && method2.getParameterTypes().length == list.size()) {
                method = method2;
                break;
            }
        }
        if (method != null) {
            try {
                Object invoke;
                switch (list.size()) {
                    case 0:
                        invoke = method.invoke(this, new Object[0]);
                        break;
                    case 1:
                        invoke = method.invoke(this, new Object[]{list.get(0)});
                        break;
                    case 2:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                        break;
                    case 3:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                        break;
                    case 4:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                        break;
                    case 5:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                        break;
                    default:
                        invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)});
                        break;
                }
                Class returnType = method.getReturnType();
                j.b("openSDK_LOG.JsBridge", "-->call, result: " + invoke + " | ReturnType: " + returnType.getName());
                if ("void".equals(returnType.getName()) || returnType == Void.class) {
                    if (bVar != null) {
                        bVar.a(null);
                    }
                } else if (bVar != null && customCallback()) {
                    bVar.a(invoke != null ? invoke.toString() : null);
                }
            } catch (Throwable e) {
                j.a("openSDK_LOG.JsBridge", "-->handler call mehtod ex. targetMethod: " + method, e);
                if (bVar != null) {
                    bVar.a();
                }
            }
        } else if (bVar != null) {
            bVar.a();
        }
    }

    public boolean customCallback() {
        return false;
    }
}
