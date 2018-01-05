package net.luna.common.util;

import net.luna.common.entity.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONUtils {

    public static boolean isPrintException = false;

    private JSONUtils() {
        throw new AssertionError();
    }

    /**
     * get Long from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getLong(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getLong(String)}</li>
     * </ul>
     */
    public static Long getLong(JSONObject jsonObject, String key, Long defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getLong(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get Long from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getLong(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static Long getLong(String jsonData, String key, Long defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getLong(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getLong(JSONObject, String, Long)
     */
    public static long getLong(JSONObject jsonObject, String key, long defaultValue) {
        return getLong(jsonObject, key, (Long) defaultValue);
    }

    /**
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getLong(String, String, Long)
     */
    public static long getLong(String jsonData, String key, long defaultValue) {
        return getLong(jsonData, key, (Long) defaultValue);
    }

    /**
     * get Int from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getInt(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getInt(String)}</li>
     * </ul>
     */
    public static Integer getInt(JSONObject jsonObject, String key, Integer defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getInt(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get Int from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getInt(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static Integer getInt(String jsonData, String key, Integer defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getInt(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getInt(JSONObject, String, Integer)
     */
    public static int getInt(JSONObject jsonObject, String key, int defaultValue) {
        return getInt(jsonObject, key, (Integer) defaultValue);
    }

    /**
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getInt(String, String, Integer)
     */
    public static int getInt(String jsonData, String key, int defaultValue) {
        return getInt(jsonData, key, (Integer) defaultValue);
    }

    /**
     * get Double from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getDouble(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getDouble(String)}</li>
     * </ul>
     */
    public static Double getDouble(JSONObject jsonObject, String key, Double defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getDouble(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get Double from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getDouble(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static Double getDouble(String jsonData, String key, Double defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getDouble(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getDouble(JSONObject, String, Double)
     */
    public static double getDouble(JSONObject jsonObject, String key, double defaultValue) {
        return getDouble(jsonObject, key, (Double) defaultValue);
    }

    /**
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return
     * @see JSONUtils#getDouble(String, String, Double)
     */
    public static double getDouble(String jsonData, String key, double defaultValue) {
        return getDouble(jsonData, key, (Double) defaultValue);
    }

    /**
     * get String from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getString(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getString(String)}</li>
     * </ul>
     */
    public static String getString(JSONObject jsonObject, String key, String defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * 从json数组中获取string <br/>
     * 如果获取的结果为null或空串，则返回defaultValue
     *
     * @param ary
     * @param index
     * @param defaultValue
     * @return
     */
    public static String getString(JSONArray ary, int index, String defaultValue) {
        try {
            if (ary != null) {
                if (ary.length() > index && index > -1) {
                    String str = ary.getString(index);
                    if (str != null) {
                        str = str.trim();

                        if (str.length() > 0) {
                            return str;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            if (isPrintException) {
                e.printStackTrace();
            }
        }
        return defaultValue;
    }

    /**
     * get String from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getString(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static String getString(String jsonData, String key, String defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getString(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get String from jsonObject
     *
     * @param jsonObject
     * @param defaultValue
     * @param keyArray
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if keyArray is null or empty, return defaultValue</li>
     * <li>get {@link #getJSONObject(JSONObject, String, JSONObject)} by
     * recursion, return it. if anyone is null, return directly</li>
     * </ul>
     */
    public static String getStringCascade(JSONObject jsonObject, String defaultValue, String... keyArray) {
        if (jsonObject == null || ArrayUtils.isEmpty(keyArray)) {
            return defaultValue;
        }

        String data = jsonObject.toString();
        for (String key : keyArray) {
            data = getStringCascade(data, key, defaultValue);
            if (data == null) {
                return defaultValue;
            }
        }
        return data;
    }

    /**
     * get String from jsonData
     *
     * @param jsonData
     * @param defaultValue
     * @param keyArray
     * @return <ul>
     * <li>if jsonData is null, return defaultValue</li>
     * <li>if keyArray is null or empty, return defaultValue</li>
     * <li>get {@link #getJSONObject(JSONObject, String, JSONObject)} by
     * recursion, return it. if anyone is null, return directly</li>
     * </ul>
     */
    public static String getStringCascade(String jsonData, String defaultValue, String... keyArray) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        String data = jsonData;
        for (String key : keyArray) {
            data = getString(data, key, defaultValue);
            if (data == null) {
                return defaultValue;
            }
        }
        return data;
    }

    /**
     * get String array from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getJSONArray(String)} exception, return
     * defaultValue</li>
     * <li>if {@link JSONArray#getString(int)} exception, return
     * defaultValue</li>
     * <li>return string array</li>
     * </ul>
     */
    public static String[] getStringArray(JSONObject jsonObject, String key, String[] defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            JSONArray statusArray = jsonObject.getJSONArray(key);
            if (statusArray != null) {
                String[] value = new String[statusArray.length()];
                for (int i = 0; i < statusArray.length(); i++) {
                    value[i] = statusArray.getString(i);
                }
                return value;
            }
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
        return defaultValue;
    }

    /**
     * get String array from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getStringArray(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static String[] getStringArray(String jsonData, String key, String[] defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getStringArray(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get String list from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getJSONArray(String)} exception, return
     * defaultValue</li>
     * <li>if {@link JSONArray#getString(int)} exception, return
     * defaultValue</li>
     * <li>return string array</li>
     * </ul>
     */
    public static List<String> getStringList(JSONObject jsonObject, String key, List<String> defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            JSONArray statusArray = jsonObject.getJSONArray(key);
            if (statusArray != null) {
                List<String> list = new ArrayList<String>();
                for (int i = 0; i < statusArray.length(); i++) {
                    list.add(statusArray.getString(i));
                }
                return list;
            }
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
        return defaultValue;
    }

    /**
     * get String list from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getStringList(JSONObject, String, List)}</li>
     * </ul>
     */
    public static List<String> getStringList(String jsonData, String key, List<String> defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getStringList(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get JSONObject from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getJSONObject(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getJSONObject(String)}</li>
     * </ul>
     */
    public static JSONObject getJSONObject(JSONObject jsonObject, String key, JSONObject defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getJSONObject(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get JSONObject from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonData is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getJSONObject(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static JSONObject getJSONObject(String jsonData, String key, JSONObject defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getJSONObject(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get JSONObject from jsonObject
     *
     * @param jsonObject
     * @param defaultValue
     * @param keyArray
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if keyArray is null or empty, return defaultValue</li>
     * <li>get {@link #getJSONObject(JSONObject, String, JSONObject)} by
     * recursion, return it. if anyone is null, return directly</li>
     * </ul>
     */
    public static JSONObject getJSONObjectCascade(JSONObject jsonObject, JSONObject defaultValue, String... keyArray) {
        if (jsonObject == null || ArrayUtils.isEmpty(keyArray)) {
            return defaultValue;
        }

        JSONObject js = jsonObject;
        for (String key : keyArray) {
            js = getJSONObject(js, key, defaultValue);
            if (js == null) {
                return defaultValue;
            }
        }
        return js;
    }

    /**
     * get JSONObject from jsonData
     *
     * @param jsonData
     * @param defaultValue
     * @param keyArray
     * @return <ul>
     * <li>if jsonData is null, return defaultValue</li>
     * <li>if keyArray is null or empty, return defaultValue</li>
     * <li>get {@link #getJSONObject(JSONObject, String, JSONObject)} by
     * recursion, return it. if anyone is null, return directly</li>
     * </ul>
     */
    public static JSONObject getJSONObjectCascade(String jsonData, JSONObject defaultValue, String... keyArray) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getJSONObjectCascade(jsonObject, defaultValue, keyArray);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get JSONArray from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>if {@link JSONObject#getJSONArray(String)} exception, return
     * defaultValue</li>
     * <li>return {@link JSONObject#getJSONArray(String)}</li>
     * </ul>
     */
    public static JSONArray getJSONArray(JSONObject jsonObject, String key, JSONArray defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getJSONArray(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get JSONArray from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getJSONArray(JSONObject, String, JSONObject)}</li>
     * </ul>
     */
    public static JSONArray getJSONArray(String jsonData, String key, JSONArray defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getJSONArray(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get Boolean from jsonObject
     *
     * @param jsonObject
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if key is null or empty, return defaultValue</li>
     * <li>return {@link JSONObject#getBoolean(String)}</li>
     * </ul>
     */
    public static boolean getBoolean(JSONObject jsonObject, String key, Boolean defaultValue) {
        if (jsonObject == null || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return jsonObject.getBoolean(key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get Boolean from jsonData
     *
     * @param jsonData
     * @param key
     * @param defaultValue
     * @return <ul>
     * <li>if jsonObject is null, return defaultValue</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return defaultValue</li>
     * <li>return
     * {@link JSONUtils#getBoolean(JSONObject, String, Boolean)}</li>
     * </ul>
     */
    public static boolean getBoolean(String jsonData, String key, Boolean defaultValue) {
        if (StringUtils.isEmpty(jsonData)) {
            return defaultValue;
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getBoolean(jsonObject, key, defaultValue);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return defaultValue;
        }
    }

    /**
     * get map from jsonObject.
     *
     * @param jsonObject key-value pairs json
     * @param key
     * @return <ul>
     * <li>if jsonObject is null, return null</li>
     * <li>return {@link JSONUtils#parseKeyAndValueToMap(String)}</li>
     * </ul>
     */
    public static Map<String, String> getMap(JSONObject jsonObject, String key) {
        return JSONUtils.parseKeyAndValueToMap(JSONUtils.getString(jsonObject, key, null));
    }

    /**
     * get map from jsonData.
     *
     * @param jsonData key-value pairs string
     * @param key
     * @return <ul>
     * <li>if jsonData is null, return null</li>
     * <li>if jsonData length is 0, return empty map</li>
     * <li>if jsonData {@link JSONObject#JSONObject(String)} exception,
     * return null</li>
     * <li>return {@link JSONUtils#getMap(JSONObject, String)}</li>
     * </ul>
     */
    public static Map<String, String> getMap(String jsonData, String key) {

        if (jsonData == null) {
            return null;
        }
        if (jsonData.length() == 0) {
            return new HashMap<String, String>();
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            return getMap(jsonObject, key);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * parse key-value pairs to map. ignore empty key, if getValue exception,
     * put empty value
     *
     * @param sourceObj key-value pairs json
     * @return <ul>
     * <li>if sourceObj is null, return null</li>
     * <li>else parse entry by
     * {@link MapUtils#putMapNotEmptyKey(Map, String, String)} one by
     * one</li>
     * </ul>
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, String> parseKeyAndValueToMap(JSONObject sourceObj) {
        if (sourceObj == null) {
            return null;
        }

        Map<String, String> keyAndValueMap = new HashMap<String, String>();
        for (Iterator iter = sourceObj.keys(); iter.hasNext(); ) {
            String key = (String) iter.next();
            MapUtils.putMapNotEmptyKey(keyAndValueMap, key, getString(sourceObj, key, ""));

        }
        return keyAndValueMap;
    }

    /**
     * parse key-value pairs to map. ignore empty key, if getValue exception,
     * put empty value
     *
     * @param source key-value pairs json
     * @return <ul>
     * <li>if source is null or source's length is 0, return empty map</li>
     * <li>if source {@link JSONObject#JSONObject(String)} exception,
     * return null</li>
     * <li>return {@link JSONUtils#parseKeyAndValueToMap(JSONObject)}</li>
     * </ul>
     */
    public static Map<String, String> parseKeyAndValueToMap(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }

        try {
            JSONObject jsonObject = new JSONObject(source);
            return parseKeyAndValueToMap(jsonObject);
        } catch (JSONException e) {
            if (isPrintException) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static JSONObject toJsonObject(String json) {
        try {
            if (json == null) {
                return null;
            }
            return new JSONObject(json);
        } catch (Throwable e) {
        }
        return null;
    }

    public static JSONArray toJsonArray(String json) {
        try {
            if (json == null) {
                return null;
            }
            return new JSONArray(json);
        } catch (Throwable e) {
        }
        return null;
    }

    /**
     * 从jsonObject中获取JsonObject
     *
     * @param obj
     * @param key
     * @param defaultValue
     * @return
     */
    public static JSONObject getJsonObject(JSONObject obj, String key, JSONObject defaultValue) {
        try {
            if (isKeyNotNull(obj, key)) {
                return obj.getJSONObject(key);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 从JSONArray中获取int
     *
     * @param ary
     * @param index
     * @param defaultValue
     * @return
     */
    public static JSONObject getJsonObject(JSONArray ary, int index, JSONObject defaultValue) {
        try {
            if (ary != null) {
                if (ary.length() > index && index > -1) {
                    return ary.getJSONObject(index);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 从jsonObject中获取JsonArray
     *
     * @param obj
     * @param key
     * @param defaultValue
     * @return
     */
    public static JSONArray getJsonArray(JSONObject obj, String key, JSONArray defaultValue) {
        try {
            if (isKeyNotNull(obj, key)) {
                return obj.getJSONArray(key);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 从JSONArray中获取int
     *
     * @param ary
     * @param index
     * @param defaultValue
     * @return
     */
    public static JSONArray getJsonArray(JSONArray ary, int index, JSONArray defaultValue) {
        try {
            if (ary != null) {
                if (ary.length() > index && index > -1) {
                    return ary.getJSONArray(index);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static boolean isKeyNotNull(JSONObject jsonObject, String key) {
        return jsonObject != null && !jsonObject.isNull(key);
    }

    /**
     * 写入int到jsonobject
     *
     * @param jo
     * @param key
     * @param value
     */
    public static void putInt(JSONObject jo, String key, int value) {
        try {
            if (jo != null) {
                jo.put(key, value);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入long到jsonobject
     *
     * @param jo
     * @param key
     * @param value
     */
    public static void putLong(JSONObject jo, String key, long value) {
        try {
            if (jo != null) {
                jo.put(key, value);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入string到jsonobject
     *
     * @param jo
     * @param key
     * @param value
     */
    public static void putString(JSONObject jo, String key, String value) {
        try {
            if (jo != null) {
                if (StringUtils.isBlank(value)) {
                    jo.put(key, "");
                } else {
                    jo.put(key, value);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入jsonObject到jsonobject
     *
     * @param jo
     * @param key
     * @param value
     */
    public static void putJsonObject(JSONObject jo, String key, JSONObject value) {
        try {
            if (jo != null) {
                jo.put(key, value);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
