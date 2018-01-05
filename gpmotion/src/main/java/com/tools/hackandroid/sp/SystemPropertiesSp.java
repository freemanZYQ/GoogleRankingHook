package com.tools.hackandroid.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.tools.hackandroid.generator.BuildGenerator;
import com.tools.hackandroid.util.DLog;

import net.luna.common.debug.LunaLog;

/**
 * 没有支持部分api 23的参数
 */
public class SystemPropertiesSp extends AbsSp {

    public final static String HOOK_CLASS_NAME = "android.os.SystemProperties";
    public final static String HOOK_CLASS_NAME_FOR_SETTING_SYSTEM = "android.provider.Settings$System";
    public final static String HOOK_CLASS_NAME_FOR_SETTING_SECURE = "android.provider.Settings$Secure";


    public static final String RO_PRODUCT_NAME = "ro.product.name";

    public static final String RO_PRODUCT_MODEL = "ro.product.model";

    public static final String RO_PRODUCT_BRAND = "ro.product.brand";

    public static final String RO_PRODUCT_BOARD = "ro.product.board";

    public static final String RO_PRODUCT_DEVICE = "ro.product.device";

    public static final String RO_PRODUCT_MANUFACTURER = "ro.product.manufacturer";

    public static final String RO_BUILD_FINGERPRINT = "ro.build.fingerprint";

    public static final String RO_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";

    public static final String RO_BUILD_VERSION_RELEASE = "ro.build.version.release";

    public static final String RO_BUILD_ID = "ro.build.id";

    public static final String RO_BUILD_DISPLAY_ID = "ro.build.display.id";

    public static final String RO_BOOTLOADER = "ro.bootloader";

    public static final String RO_HARDWARE = "ro.hardware";

    public static final String RO_SERIALNO = "ro.serialno";

    public static final String RO_BUILD_VERSION_SDK = "ro.build.version.sdk";

    public static final String RO_BUILD_VERSION_CODENAME = "ro.build.version.codename";

    public static final String RO_BUILD_TYPE = "ro.build.type";

    public static final String RO_BUILD_TAGS = "ro.build.tags";

    public static final String RO_BUILD_USER = "ro.build.user";

    public static final String RO_BUILD_HOST = "ro.build.host";

    public static final String RO_BUILD_DATE_TIME = "ro.build.date.utc";

    public final static String RO_SETTING_ANDID = "android_id";


    /**
     * 保存本类的sp文件的名字
     *
     * @return
     */
    @Override
    public String getSharedPreferencesName() {
        return HOOK_CLASS_NAME;
    }

    /**
     * 输入测试数据
     *
     * @param context
     * @param sharedPreferences 数据所保存到的sp文件
     */
    @Override
    protected void inputTestData(Context context, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
        mSpEditor.putString(RO_PRODUCT_NAME, "1" + System.currentTimeMillis());
        mSpEditor.putString(RO_PRODUCT_MODEL, "2");
        mSpEditor.putString(RO_PRODUCT_BRAND, "3");
        mSpEditor.putString(RO_PRODUCT_BOARD, "4");
        mSpEditor.putString(RO_PRODUCT_DEVICE, "5");
        mSpEditor.putString(RO_PRODUCT_MANUFACTURER, "6");
        mSpEditor.putString(RO_BUILD_FINGERPRINT, "7");
        mSpEditor.putString(RO_BUILD_VERSION_INCREMENTAL, "8");
        mSpEditor.putString(RO_BUILD_VERSION_RELEASE, "9");
        mSpEditor.putString(RO_BUILD_ID, "10");
        mSpEditor.putString(RO_BUILD_DISPLAY_ID, "11");
        mSpEditor.putString(RO_BOOTLOADER, "12");
        mSpEditor.putString(RO_HARDWARE, "13");
        mSpEditor.putString(RO_SERIALNO, "14");
        mSpEditor.putString(RO_BUILD_VERSION_SDK, "17");
        mSpEditor.putString(RO_BUILD_VERSION_CODENAME, "15");
        mSpEditor.putString(RO_BUILD_TYPE, "16");
        mSpEditor.putString(RO_BUILD_TAGS, "18");
        mSpEditor.putString(RO_BUILD_USER, "19");
        mSpEditor.putString(RO_BUILD_HOST, "20");
        mSpEditor.putString(RO_BUILD_DATE_TIME, "21000");
        mSpEditor.apply();
    }

    /**
     * 输入随机数据
     *
     * @param context
     * @param sharedPreferences 数据所保存到的sp文件
     */
    @Override
    protected void inputRandomData(Context context, SharedPreferences sharedPreferences) {

    }

    /**
     * 输入指定的数组数据
     *
     * @param context
     * @param sharedPreferences   数据所保存到的sp文件
     * @param keyValueStringArray e.g new String [] {"key1=value1", "key2=value2", "key3=value3"}
     */
    @Override
    protected void inputDataFromKeyValueStringArray(Context context, SharedPreferences sharedPreferences,
                                                    String[] keyValueStringArray) {
        SharedPreferences.Editor mSpEditor = sharedPreferences.edit();
        for (String str : keyValueStringArray) {
            try {
                String[] kv = str.split("=", 2);
                if (kv.length != 2) {
                    continue;
                }
                if (TextUtils.isEmpty(kv[0]) || TextUtils.isEmpty(kv[1])) {
                    continue;
                }
                switch (kv[0]) {
                    case "andid":
                        DLog.e("andorid :"+kv[1]);
//                        mSpEditor.putString(RO_SETTING_ANDID, kv[1]);
                        break;
                    case "dd":
                        mSpEditor.putString(RO_PRODUCT_MODEL, kv[1]);

                        // TODO 暂时没有收集到device的参数，先用model顶替
                        mSpEditor.putString(RO_PRODUCT_DEVICE, kv[1]);

                        // TODO 暂时没有收集到board的参数，先用model顶替
                        mSpEditor.putString(RO_PRODUCT_BOARD, kv[1]);

                        break;
                    case "dv":
                        mSpEditor.putString(RO_PRODUCT_MANUFACTURER, kv[1]);

                        // TODO 暂时没有收集到brand品牌的信息，先用制造厂商顶替
                        mSpEditor.putString(RO_PRODUCT_BRAND, kv[1]);

                        break;
                    case "po":
                        mSpEditor.putString(RO_BUILD_FINGERPRINT, kv[1]);
                        break;
                    case "sn":
                        mSpEditor.putString(RO_SERIALNO, kv[1]);
                        break;
                    case "osv":
                        if (!kv[1].startsWith("android ")) {
                            continue;
                        }
                        String release = kv[1].substring(8);
                        mSpEditor.putString(RO_BUILD_VERSION_RELEASE, release);

                        // 因为暂时没有传入获取ID的值，所以只能根据RELEASE的值修改ID
                        mSpEditor.putString(RO_BUILD_ID, BuildGenerator.newIDBaseonReleaseVersion(release));

                        // 因为暂时没有传入SDK_INIT的值，所以不能只改RELEASE的值，还需要同时根据 RELEASE 的值改回SDK_INIT
                        //					int sdkinit = 14;
                        //					if (release.startsWith("4.0")) {
                        //						sdkinit = 14;
                        //					}
                        //					if (release.startsWith("4.0.3")) {
                        //						sdkinit = 15;
                        //					}
                        //					if (release.startsWith("4.1")) {
                        //						sdkinit = 16;
                        //					}
                        //					if (release.startsWith("4.2")) {
                        //						sdkinit = 17;
                        //					}
                        //					if (release.startsWith("4.3")) {
                        //						sdkinit = 18;
                        //					}
                        //					if (release.startsWith("4.4")) {
                        //						sdkinit = 19;
                        //					}
                        //					if (release.startsWith("4.4W")) {
                        //						sdkinit = 20;
                        //					}
                        //					if (release.startsWith("5.0")) {
                        //						sdkinit = 21;
                        //					}
                        //					if (release.startsWith("5.1")) {
                        //						sdkinit = 22;
                        //					}
                        //					if (release.startsWith("6")) {
                        //						sdkinit = 23;
                        //					}
                        //					mSpEditor.putString(RO_BUILD_VERSION_SDK, sdkinit + "");
                        break;
                    // TODO product hardward的篡改
                }
            } catch (Throwable e) {
                DLog.e(e);
            }
        }
        mSpEditor.putString(RO_BUILD_DATE_TIME, String.valueOf(BuildGenerator.newRandomTimeForThisApplication()));
        //		mSpEditor.putString(RO_BUILD_ID, BuildGenerator.newRandomIDForThisApplication());
        mSpEditor.apply();
    }

}
