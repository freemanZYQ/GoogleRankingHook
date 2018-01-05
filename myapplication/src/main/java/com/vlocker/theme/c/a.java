package com.vlocker.theme.c;

import com.vlocker.new_theme.beans.T_AlbumThemePageInfo;
import com.vlocker.new_theme.beans.T_SpecialThemePageInfo;
import com.vlocker.theme.model.T_ThemeListPageInfo;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static a a = new a();
    private Map b = new HashMap();
    private Map c = new HashMap();
    private Map d = new HashMap();
    private Map e = new HashMap();
    private Object f;

    private a() {
    }

    public static a b() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public T_ThemeListPageInfo a(String str) {
        T_ThemeListPageInfo t_ThemeListPageInfo = (T_ThemeListPageInfo) this.c.get(str);
        if (t_ThemeListPageInfo != null) {
            return t_ThemeListPageInfo;
        }
        this.c.put(str, new T_ThemeListPageInfo());
        return (T_ThemeListPageInfo) this.c.get(str);
    }

    public Object a() {
        return this.f;
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public T_SpecialThemePageInfo b(String str) {
        T_SpecialThemePageInfo t_SpecialThemePageInfo = (T_SpecialThemePageInfo) this.d.get(str);
        if (t_SpecialThemePageInfo != null) {
            return t_SpecialThemePageInfo;
        }
        this.d.put(str, new T_SpecialThemePageInfo());
        return (T_SpecialThemePageInfo) this.d.get(str);
    }

    public T_AlbumThemePageInfo c(String str) {
        T_AlbumThemePageInfo t_AlbumThemePageInfo = (T_AlbumThemePageInfo) this.e.get(str);
        if (t_AlbumThemePageInfo != null) {
            return t_AlbumThemePageInfo;
        }
        this.e.put(str, new T_AlbumThemePageInfo());
        return (T_AlbumThemePageInfo) this.e.get(str);
    }
}
