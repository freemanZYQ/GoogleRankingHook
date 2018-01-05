package com.vlocker.search;

import com.vlocker.new_theme.d.b;
import com.vlocker.theme.model.d;
import org.json.JSONException;
import org.json.JSONObject;

public class af implements b {
    public aw a(String str) {
        aw awVar = new aw();
        d dVar = new d();
        try {
            new JSONObject(str).getJSONObject("data");
            ac acVar = new ac();
            acVar.a("sites");
            dVar.add(acVar);
            acVar = new ac();
            acVar.a("ade");
            dVar.add(acVar);
            acVar = new ac();
            acVar.a("starry");
            dVar.add(acVar);
            awVar.a(dVar);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return awVar;
    }

    public /* synthetic */ com.vlocker.theme.model.b b(String str) {
        return a(str);
    }
}
