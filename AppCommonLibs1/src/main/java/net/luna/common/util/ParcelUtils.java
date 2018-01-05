package net.luna.common.util;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ParcelUtils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-5-27
 */
public class ParcelUtils {

    private ParcelUtils() {
        throw new AssertionError();
    }

    /**
     * read boolean
     *
     * @param in
     * @return
     */
    public static boolean readBoolean(Parcel in) {
        return in.readInt() == 1;
    }

    /**
     * write boolean
     *
     * @param b
     * @param out
     */
    public static void writeBoolean(boolean b, Parcel out) {
        out.writeInt(b ? 1 : 0);
    }

    /**
     * Read a HashMap from a Parcel, class of key and value are both String
     *
     * @param in
     * @return
     */
    public static Map<String, String> readHashMapStringAndString(Parcel in) {
        if (in == null) {
            return null;
        }

        int size = in.readInt();
        if (size == -1) {
            return null;
        }

        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < size; i++) {
            String key = in.readString();
            map.put(key, in.readString());
        }
        return map;
    }

    /**
     * Write a HashMap to a Parcel, class of key and value are both String
     *
     * @param map
     * @param out
     * @param flags
     */
    public static void writeHashMapStringAndString(Map<String, String> map, Parcel out, int flags) {
        if (map != null) {
            out.writeInt(map.size());
            for (Entry<String, String> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeString(entry.getValue());
            }
        } else {
            out.writeInt(-1);
        }
    }

    /**
     * Read a HashMap from a Parcel, class of key is String, class of Value can parcelable
     *
     * @param <V>
     * @param in
     * @param loader
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <V extends Parcelable> Map<String, V> readHashMapStringKey(Parcel in, ClassLoader loader) {
        if (in == null) {
            return null;
        }

        int size = in.readInt();
        if (size == -1) {
            return null;
        }

        Map<String, V> map = new HashMap<String, V>();
        for (int i = 0; i < size; i++) {
            String key = in.readString();
            map.put(key, (V) in.readParcelable(loader));
        }
        return map;
    }

    /**
     * Write a HashMap to a Parcel, class of key is String, class of Value can parcelable
     *
     * @param map
     * @param out
     * @param flags
     */
    public static <V extends Parcelable> void writeHashMapStringKey(Map<String, V> map, Parcel out, int flags) {
        if (map != null) {
            out.writeInt(map.size());

            for (Entry<String, V> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeParcelable(entry.getValue(), flags);
            }
        } else {
            out.writeInt(-1);
        }
    }

    /**
     * Read a HashMap from a Parcel, class of key and value can parcelable both
     *
     * @param <V>
     * @param in
     * @param loader
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <K extends Parcelable, V extends Parcelable> Map<K, V> readHashMap(Parcel in, ClassLoader loader) {
        if (in == null) {
            return null;
        }

        int size = in.readInt();
        if (size == -1) {
            return null;
        }

        Map<K, V> map = new HashMap<K, V>();
        for (int i = 0; i < size; i++) {
            map.put((K) in.readParcelable(loader), (V) in.readParcelable(loader));
        }
        return map;
    }

    /**
     * Write a HashMap to a Parcel, class of key and value can parcelable both
     *
     * @param map
     * @param out
     * @param flags
     */
    public static <K extends Parcelable, V extends Parcelable> void writeHashMap(Map<K, V> map, Parcel out, int flags) {
        if (map != null) {
            out.writeInt(map.size());

            for (Entry<K, V> entry : map.entrySet()) {
                out.writeParcelable(entry.getKey(), flags);
                out.writeParcelable(entry.getValue(), flags);
            }
        } else {
            out.writeInt(-1);
        }
    }

    public static byte[] parcelToByte(Parcelable parcelable) {
        try {
            Parcel obtain = Parcel.obtain();
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static Parcel byteToParcel(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return obtain;
        } catch (Exception e) {
            if (e == null) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T byteToParcelBean(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel a = byteToParcel(bArr);
        if (a == null) {
            return null;
        }
        return creator.createFromParcel(a);
    }
}
