package com.inveno.se.model.multimedia;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.inveno.se.f.a;
import java.io.Serializable;
import org.json.JSONObject;

public class Imgs implements Parcelable, Serializable {
    public static final Creator CREATOR = new a();
    private String a;
    private int b;
    private int c;
    private String d;
    private String e;

    public Imgs(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public Imgs(String str, int i, int i2, String str2, String str3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = str3;
    }

    public static Imgs a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("format");
            int intValue = Integer.valueOf(jSONObject.getString("width")).intValue();
            int intValue2 = Integer.valueOf(jSONObject.getString("height")).intValue();
            String string2 = jSONObject.getString("img_url");
            String str = "";
            if (jSONObject.has("surl")) {
                str = jSONObject.getString("surl");
            }
            return new Imgs(string, intValue, intValue2, string2, str);
        } catch (Exception e) {
            a.c("解析imges数组json异常:" + e);
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
