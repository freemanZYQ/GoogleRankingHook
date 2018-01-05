package net.luna.common.util;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaCalls {
    private static final String LOG_TAG = "JavaCalls";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = new HashMap();

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t) {
            this.clazz = cls;
            this.obj = t;
        }
    }

    static {
        PRIMITIVE_MAP.put(Boolean.class, Boolean.TYPE);
        PRIMITIVE_MAP.put(Byte.class, Byte.TYPE);
        PRIMITIVE_MAP.put(Character.class, Character.TYPE);
        PRIMITIVE_MAP.put(Short.class, Short.TYPE);
        PRIMITIVE_MAP.put(Integer.class, Integer.TYPE);
        PRIMITIVE_MAP.put(Float.class, Float.TYPE);
        PRIMITIVE_MAP.put(Long.class, Long.TYPE);
        PRIMITIVE_MAP.put(Double.class, Double.TYPE);
        PRIMITIVE_MAP.put(Boolean.TYPE, Boolean.TYPE);
        PRIMITIVE_MAP.put(Byte.TYPE, Byte.TYPE);
        PRIMITIVE_MAP.put(Character.TYPE, Character.TYPE);
        PRIMITIVE_MAP.put(Short.TYPE, Short.TYPE);
        PRIMITIVE_MAP.put(Integer.TYPE, Integer.TYPE);
        PRIMITIVE_MAP.put(Float.TYPE, Float.TYPE);
        PRIMITIVE_MAP.put(Long.TYPE, Long.TYPE);
        PRIMITIVE_MAP.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return getFieldOrThrow(obj, str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static <T> T getFieldOrThrow(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
                continue;
            }
//            if (cls == null) {
//                throw new NoSuchFieldException();
//            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static void setField(Object obj, String str, Object obj2) {
        try {
            setFieldOrThrow(obj, str, obj2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void setFieldOrThrow(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                continue;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
                continue;
            }
//            if (cls == null) {
//                throw  NoSuchFieldException;
//            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }


    private static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        Method findMethodByName = findMethodByName(cls.getDeclaredMethods(), str, clsArr);
        if (findMethodByName != null) {
            findMethodByName.setAccessible(true);
            return findMethodByName;
        } else if (cls.getSuperclass() != null) {
            return getDeclaredMethod(cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    private static Method findMethodByName(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && compareClassLists(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static boolean compareClassLists(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            boolean z;
            if (clsArr2 == null || clsArr2.length == 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (clsArr2 == null) {
            if (clsArr.length != 0) {
                return false;
            }
            return true;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            int i = 0;
            while (i < clsArr.length) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!PRIMITIVE_MAP.containsKey(clsArr[i]) || !((Class) PRIMITIVE_MAP.get(clsArr[i])).equals(PRIMITIVE_MAP.get(clsArr2[i])))) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }


    public static <T> T newEmptyInstance(Class<?> cls) {
        try {
            return newEmptyInstanceOrThrow(cls);
        } catch (Throwable e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + cls.getSimpleName(), e);
            return null;
        }
    }

    public static <T> T newEmptyInstanceOrThrow(Class<?> cls) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        int i = 0;
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        while (i < parameterTypes.length) {
            objArr[i] = getDefaultValue(parameterTypes[i]);
            i++;
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object getDefaultValue(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return Integer.valueOf(0);
        }
        if (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) {
            return Boolean.valueOf(false);
        }
        if (Character.TYPE.equals(cls) || Character.class.equals(cls)) {
            return Character.valueOf('\u0000');
        }
        return null;
    }

    public static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    public static Object newInstance(String str, Object... objArr) {
        try {
            return newInstanceOrThrow(str, objArr);
        } catch (Throwable e) {
            Log.w(LOG_TAG, "Meet exception when make instance as a " + str, e);
            return null;
        }
    }

    public static Object newInstanceOrThrow(String str, Object... objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        return newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                clsArr[i] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i] = ((JavaParam) obj).clazz;
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null || !(obj instanceof JavaParam)) {
                objArr2[i] = obj;
            } else {
                objArr2[i] = ((JavaParam) obj).obj;
            }
        }
        return objArr2;
    }
}
