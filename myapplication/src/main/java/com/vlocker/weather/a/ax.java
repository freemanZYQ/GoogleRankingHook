package com.vlocker.weather.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vlocker.locker.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ax extends BaseAdapter {
    final /* synthetic */ aw a;

    ax(aw awVar) {
        this.a = awVar;
    }

    public int getCount() {
        return this.a.e.size();
    }

    public Object getItem(int i) {
        return this.a.e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        JSONArray jSONArray = null;
        LinearLayout linearLayout = (LinearLayout) LinearLayout.inflate(this.a.a, R.layout.l_weather_zsitem, jSONArray);
        Object obj = "";
        try {
            obj = ((JSONObject) this.a.e.get(i)).getString("title");
        } catch (JSONException e) {
            linearLayout.findViewById(R.id.layout_zs_title).setVisibility(8);
            e.printStackTrace();
        }
        try {
            jSONArray = ((JSONObject) this.a.e.get(i)).getJSONArray("list");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if ("".equals(obj)) {
            linearLayout.findViewById(R.id.layout_zs_title).setVisibility(8);
        } else {
            ((TextView) linearLayout.findViewById(R.id.tv_zs_title)).setText(obj);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            this.a.a(jSONArray, linearLayout, this.a.a, R.layout.zs_indexitem, obj);
        }
        return linearLayout;
    }
}
