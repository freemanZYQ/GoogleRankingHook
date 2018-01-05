package com.vlocker.search;

import com.vlocker.new_theme.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class ag implements b {
    public ac a(String str) {
        ac acVar = new ac();
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() >= 2) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(1);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    M_bd_BaiduNewsInfo m_bd_BaiduNewsInfo = new M_bd_BaiduNewsInfo();
                    m_bd_BaiduNewsInfo.a(ap.a(jSONArray2.getString(i)));
                    arrayList.add(m_bd_BaiduNewsInfo);
                }
                acVar.a(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acVar;
    }

    public /* synthetic */ com.vlocker.theme.model.b b(String str) {
        return a(str);
    }
}
