package com.vlocker.weather.b;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public ArrayList a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!(str == null || str.equals(""))) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONObject("data").getJSONArray("list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.a(jSONObject.getString("city"));
                    aVar.b(jSONObject.getString("code"));
                    arrayList.add(aVar);
                }
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }
}
