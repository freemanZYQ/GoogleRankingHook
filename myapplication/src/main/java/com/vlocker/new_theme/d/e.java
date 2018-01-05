package com.vlocker.new_theme.d;

import com.vlocker.new_theme.beans.f;
import com.vlocker.theme.model.T_ThemeItemInfo;
import com.vlocker.theme.model.T_ThemePreviewParserInfo;
import com.vlocker.theme.model.b;
import com.vlocker.theme.model.d;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements b {
    private int a;

    public f a(String str) {
        f fVar = new f();
        List dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("code") == 200) {
                int i;
                com.vlocker.new_theme.beans.e eVar;
                jSONObject = jSONObject.getJSONObject("data");
                JSONArray jSONArray = jSONObject.getJSONArray("themes");
                JSONArray jSONArray2 = jSONObject.getJSONArray("tags");
                JSONObject jSONObject2 = jSONObject.getJSONObject("zone");
                JSONArray jSONArray3 = jSONObject2.getJSONArray("list");
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        d dVar2 = new d();
                        com.vlocker.new_theme.beans.e eVar2 = new com.vlocker.new_theme.beans.e();
                        jSONObject = jSONArray.getJSONObject(i2);
                        eVar2.b(jSONObject.getString("title"));
                        eVar2.d(jSONObject.getString("url"));
                        eVar2.c(jSONObject.getString("logo"));
                        eVar2.a(com.vlocker.theme.f.e.f(com.vlocker.theme.f.e.a, jSONObject.getString("title")));
                        try {
                            JSONArray jSONArray4 = jSONObject.getJSONArray("themes");
                            eVar2.c(0);
                            for (i = 0; i < jSONArray4.length(); i++) {
                                dVar2.add(a((JSONObject) jSONArray4.get(i)));
                            }
                            eVar2.a(dVar2);
                            dVar.add(eVar2);
                        } catch (Exception e) {
                            try {
                                e.printStackTrace();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                List list = dVar;
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        } catch (JSONException e32) {
                            e32.printStackTrace();
                        }
                    }
                }
                d dVar3 = (d) com.vlocker.theme.f.e.a(dVar);
                if (jSONArray2.length() > 0) {
                    eVar = new com.vlocker.new_theme.beans.e();
                    List arrayList = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        com.vlocker.new_theme.beans.e eVar3 = new com.vlocker.new_theme.beans.e();
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        eVar3.b(jSONObject3.getString("title"));
                        eVar3.d(jSONObject3.getString("url"));
                        eVar3.c(jSONObject3.getString("logo"));
                        arrayList.add(eVar3);
                    }
                    eVar.c(1);
                    eVar.a(arrayList);
                    dVar3.add(eVar);
                }
                if (jSONArray3.length() > 0) {
                    eVar = new com.vlocker.new_theme.beans.e();
                    i = 0;
                    d dVar4 = new d();
                    while (i < jSONArray3.length()) {
                        com.vlocker.new_theme.beans.e eVar4;
                        d dVar5;
                        if (i == 0) {
                            eVar.b("设计师新品");
                        }
                        this.a++;
                        dVar4.add(a((JSONObject) jSONArray3.get(i)));
                        if (this.a == 3) {
                            eVar.c(2);
                            eVar.a(dVar4);
                            dVar3.add(eVar);
                            eVar4 = new com.vlocker.new_theme.beans.e();
                            this.a = 0;
                            dVar5 = new d();
                        } else {
                            dVar5 = dVar4;
                            eVar4 = eVar;
                        }
                        i++;
                        eVar = eVar4;
                        dVar4 = dVar5;
                    }
                }
                fVar.b(jSONObject2.getJSONObject("meta").getString("next"));
                fVar.b(dVar3);
            }
        } catch (JSONException e322) {
            e322.printStackTrace();
        } catch (Exception e22) {
            e22.printStackTrace();
        }
        return fVar;
    }

    public T_ThemeItemInfo a(JSONObject jSONObject) {
        T_ThemeItemInfo t_ThemeItemInfo;
        d dVar;
        T_ThemePreviewParserInfo t_ThemePreviewParserInfo;
        T_ThemePreviewParserInfo t_ThemePreviewParserInfo2;
        PatternSyntaxException e;
        JSONException e2;
        try {
            t_ThemeItemInfo = new T_ThemeItemInfo();
            try {
                t_ThemeItemInfo.a(jSONObject.getString("id"));
                t_ThemeItemInfo.b(com.vlocker.theme.f.e.b(jSONObject.getString("title")));
                t_ThemeItemInfo.c(jSONObject.getString("tags"));
                t_ThemeItemInfo.d(jSONObject.getString("desc"));
                t_ThemeItemInfo.c(jSONObject.getInt("size"));
                t_ThemeItemInfo.e(jSONObject.getInt("downnum"));
                t_ThemeItemInfo.h(jSONObject.getString("ctime"));
                t_ThemeItemInfo.d(jSONObject.getInt("grade"));
                t_ThemeItemInfo.g(jSONObject.getString("author"));
                t_ThemeItemInfo.f(jSONObject.getString("show"));
                t_ThemeItemInfo.e(jSONObject.getString("package"));
                t_ThemeItemInfo.i(jSONObject.getString("preview1") + com.vlocker.theme.f.e.a(1));
                t_ThemeItemInfo.b(jSONObject.getInt("is_lockscreen"));
                t_ThemeItemInfo.j(jSONObject.getString("preview1") + com.vlocker.theme.f.e.a(0));
                t_ThemeItemInfo.k(jSONObject.getString("preview2") + com.vlocker.theme.f.e.a(0));
                int i;
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("mpic");
                    JSONObject jSONObject2;
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        dVar = new d();
                        t_ThemePreviewParserInfo = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo2 = new T_ThemePreviewParserInfo();
                        for (i = 0; i < 2; i++) {
                            if (i == 0) {
                                t_ThemePreviewParserInfo.a(jSONObject.getString("preview1") + com.vlocker.theme.f.e.a(0));
                                dVar.add(t_ThemePreviewParserInfo);
                            }
                            if (i == 1) {
                                t_ThemePreviewParserInfo2.a(jSONObject.getString("preview2") + com.vlocker.theme.f.e.a(0));
                                dVar.add(t_ThemePreviewParserInfo2);
                            }
                        }
                        t_ThemeItemInfo.a(dVar);
                        t_ThemeItemInfo.l(jSONObject.getString("file"));
                        try {
                            t_ThemeItemInfo.f(jSONObject.getInt("edit"));
                            jSONObject2 = jSONObject.getJSONObject("event");
                            if (jSONObject2 != null) {
                                t_ThemeItemInfo.m(jSONObject2.getString("title"));
                                t_ThemeItemInfo.n(jSONObject2.getString("preview"));
                                t_ThemeItemInfo.o(jSONObject2.getString("dataurl"));
                            }
                        } catch (Exception e3) {
                        }
                        try {
                            if (jSONObject.getString("logurl") != null) {
                                t_ThemeItemInfo.p(jSONObject.getString("logurl"));
                            }
                        } catch (Exception e4) {
                        }
                        try {
                            if (jSONObject.getString("diggnum") != null) {
                                t_ThemeItemInfo.g(jSONObject.getInt("diggnum"));
                            }
                        } catch (Exception e5) {
                        }
                        return t_ThemeItemInfo;
                    }
                    d dVar2 = new d();
                    for (i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        T_ThemePreviewParserInfo t_ThemePreviewParserInfo3 = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo3.a(jSONObject3.getString("preview") + com.vlocker.theme.f.e.a(0));
                        dVar2.add(t_ThemePreviewParserInfo3);
                    }
                    t_ThemeItemInfo.a(dVar2);
                    t_ThemeItemInfo.l(jSONObject.getString("file"));
                    t_ThemeItemInfo.f(jSONObject.getInt("edit"));
                    jSONObject2 = jSONObject.getJSONObject("event");
                    if (jSONObject2 != null) {
                        t_ThemeItemInfo.m(jSONObject2.getString("title"));
                        t_ThemeItemInfo.n(jSONObject2.getString("preview"));
                        t_ThemeItemInfo.o(jSONObject2.getString("dataurl"));
                    }
                    if (jSONObject.getString("logurl") != null) {
                        t_ThemeItemInfo.p(jSONObject.getString("logurl"));
                    }
                    if (jSONObject.getString("diggnum") != null) {
                        t_ThemeItemInfo.g(jSONObject.getInt("diggnum"));
                    }
                    return t_ThemeItemInfo;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    try {
                        dVar = new d();
                        t_ThemePreviewParserInfo = new T_ThemePreviewParserInfo();
                        t_ThemePreviewParserInfo2 = new T_ThemePreviewParserInfo();
                        for (i = 0; i < 2; i++) {
                            if (i == 0) {
                                t_ThemePreviewParserInfo.a(jSONObject.getString("preview1") + com.vlocker.theme.f.e.a(0));
                                dVar.add(t_ThemePreviewParserInfo);
                            }
                            if (i == 1) {
                                t_ThemePreviewParserInfo2.a(jSONObject.getString("preview2") + com.vlocker.theme.f.e.a(0));
                                dVar.add(t_ThemePreviewParserInfo2);
                            }
                        }
                        t_ThemeItemInfo.a(dVar);
                    } catch (Exception e62) {
                        e62.printStackTrace();
                    }
                }
            } catch (PatternSyntaxException e7) {
                e = e7;
                e.printStackTrace();
                return t_ThemeItemInfo;
            } catch (JSONException e8) {
                e2 = e8;
                e2.printStackTrace();
                return t_ThemeItemInfo;
            }
        } catch (PatternSyntaxException e9) {
            PatternSyntaxException patternSyntaxException = e9;
            t_ThemeItemInfo = null;
            e = patternSyntaxException;
            e.printStackTrace();
            return t_ThemeItemInfo;
        } catch (JSONException e10) {
            JSONException jSONException = e10;
            t_ThemeItemInfo = null;
            e2 = jSONException;
            e2.printStackTrace();
            return t_ThemeItemInfo;
        }
    }

    public /* synthetic */ b b(String str) {
        return a(str);
    }
}
