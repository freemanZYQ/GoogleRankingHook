package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class q {
    private static final String d = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", new Object[]{Integer.valueOf(3000)});
    private static final String e = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", new Object[]{Integer.valueOf(3)});
    private String a = null;
    private final SQLiteDatabase b;
    private final a c;

    class a extends j {
        final /* synthetic */ q a;
        private int k;
        private long l;
        private String m;
        private boolean n;
        private boolean o;
        private q p;

        a(q qVar, q qVar2) {
            this.a = qVar;
            this.p = qVar2;
            this.m = null;
            this.n = false;
            this.o = false;
            this.f = new ArrayList();
            this.k = 0;
            this.l = -1;
        }

        private void b() {
            if (!this.n) {
                this.m = this.p.b();
                if (this.l != -1 && this.l + 86400000 <= System.currentTimeMillis()) {
                    this.k = 0;
                    this.l = -1;
                }
                if (this.m != null && this.k < 2) {
                    this.n = true;
                    f();
                }
            }
        }

        public void a() {
            this.f.clear();
            this.f.add(new BasicNameValuePair("qt", "ofbh"));
            this.f.add(new BasicNameValuePair("req", this.m));
            this.c = h.a;
        }

        public void a(boolean z) {
            this.o = false;
            if (z && this.e != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.e, "utf-8"));
                    if (jSONObject != null && jSONObject.has("error") && jSONObject.getInt("error") == BDLocation.TypeNetWorkLocation) {
                        this.o = true;
                    }
                } catch (ParseException e) {
                } catch (JSONException e2) {
                } catch (IOException e3) {
                }
            }
            this.n = false;
            if (!this.o) {
                this.k++;
                this.l = System.currentTimeMillis();
            }
            new r(this).start();
        }
    }

    q(SQLiteDatabase sQLiteDatabase) {
        this.b = sQLiteDatabase;
        this.c = new a(this, this);
        if (this.b != null && this.b.isOpen()) {
            this.b.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
        }
    }

    private void a(boolean z) {
        if (z && this.a != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", new Object[]{this.a});
            if (this.a.length() > 0) {
                try {
                    this.b.execSQL(format);
                } catch (Exception e) {
                }
            }
        }
        this.a = null;
    }

    private String b() {
        Throwable th;
        String str = null;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        Cursor rawQuery;
        try {
            rawQuery = this.b.rawQuery(e, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        rawQuery.moveToFirst();
                        while (!rawQuery.isAfterLast()) {
                            jSONArray.put(rawQuery.getString(1));
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(rawQuery.getLong(0));
                            rawQuery.moveToNext();
                        }
                        try {
                            jSONObject.put("ofloc", jSONArray);
                            str = jSONObject.toString();
                        } catch (JSONException e) {
                        }
                        this.a = stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                try {
                    rawQuery.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            Object obj = str;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = str;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void a() {
        this.c.b();
    }

    void a(String str) {
        String G = Jni.G(str);
        try {
            this.b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", new Object[]{Long.valueOf(System.currentTimeMillis()), G}));
            this.b.execSQL(d);
        } catch (Exception e) {
        }
    }
}
