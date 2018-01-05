package com.xinmei365.fontsdk.b;

import android.content.Context;
import com.xinmei365.fontsdk.bean.Font;
import com.xinmei365.fontsdk.c.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class a extends c {
    public a(Context context, String str) {
        this.ai = context;
        this.E = str;
        a(f.A(str) + "fontlist.dat", 86400000);
    }

    public void error() {
    }

    public void x() {
    }

    public void x(String str) {
        try {
            ArrayList createFontsByJSONArray = Font.createFontsByJSONArray(new JSONArray(str));
            if (createFontsByJSONArray != null && createFontsByJSONArray.size() != 0) {
                this.obj = createFontsByJSONArray;
            }
        } catch (JSONException e) {
            this.errorCode = 1005;
            this.aj = e.getMessage();
        }
    }
}
