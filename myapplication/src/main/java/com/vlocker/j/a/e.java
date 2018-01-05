package com.vlocker.j.a;

import android.os.Environment;
import java.io.File;

public class e {
    public static int a(String str) {
        return (str == null || str.equals("com.tencent.qqmusic") || str.equals("com.meizu.media.music") || str.equals("com.duomi.android") || str.equals("fm.xiami.main") || str.equals("com.sds.android.ttpod") || str.equals("com.gwsoft.imusic.controller") || str.equals("com.oppo.music") || str.equals("cn.kuwo.player") || str.equals("com.android.bbkmusic") || str.equals("com.ting.mp3.android") || str.equals("com.android.mediacenter") || str.equals("com.miui.player")) ? 1 : str.equals("com.kugou.android") ? 2 : str.equals("com.netease.cloudmusic") ? 3 : 1;
    }

    public static String b(String str) {
        if (str != null) {
            if (str.equals("com.tencent.qqmusic")) {
                return "/qqmusic/qrc";
            }
            if (str.equals("com.kugou.android")) {
                return "/kugou/lyrics";
            }
            if (str.equals("com.netease.cloudmusic")) {
                return "/netease/cloudmusic/Download/Lyric";
            }
            if (str.equals("com.meizu.media.music")) {
                return "/Music/Lyric";
            }
            if (str.equals("com.duomi.android")) {
                return "/DUOMI/lyric";
            }
            if (str.equals("fm.xiami.main")) {
                return "/Android/data/fm.xiami.main/cache/lyrics";
            }
            if (str.equals("com.sds.android.ttpod")) {
                return "/ttpod/lyric";
            }
            if (str.equals("com.gwsoft.imusic.controller")) {
                return "/iMusicBox/shared";
            }
            if (str.equals("com.oppo.music")) {
                return "/Android/data/com.oppo.music/cache/.lyric";
            }
            if (str.equals("cn.kuwo.player")) {
                return "/KuwoMusic/lyrics";
            }
            if (str.equals("com.android.bbkmusic")) {
                return new File("/i音乐/lyric").exists() ? "/i音乐/lyric" : "/i音乐/歌词";
            } else {
                if (str.equals("com.ting.mp3.android")) {
                    return "/Baidu_music/lyric";
                }
                if (str.equals("com.android.mediacenter")) {
                    return "/Musiclrc";
                }
                if (str.equals("com.miui.player")) {
                    return "/MIUI/music/lyric";
                }
            }
        }
        return "";
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        File file;
        if (str.equals("com.miui.player")) {
            file = new File("/storage/sdcard1/MIUI/music/lyric");
            if (file.listFiles() != null && file.listFiles().length > 0) {
                return "/storage/sdcard1/MIUI/music/lyric";
            }
        } else if (str.equals("com.android.mediacenter")) {
            file = new File("/storage/sdcard1/Musiclrc");
            if (file.listFiles() != null && file.listFiles().length > 0) {
                return "/storage/sdcard1/Musiclrc";
            }
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath() + b(str);
    }
}
