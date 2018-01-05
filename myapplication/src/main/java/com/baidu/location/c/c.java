package com.baidu.location.c;

import java.io.IOException;
import java.util.Iterator;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

class c extends Thread {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        ParseException parseException;
        ParseException parseException2;
        JSONObject jSONObject;
        Iterator keys;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        Object obj;
        Object obj2;
        Object obj3;
        int i;
        int i2;
        int i3;
        String str;
        String string;
        Double valueOf;
        int i4;
        Object obj4;
        int i5;
        int i6;
        Object obj5;
        Object obj6;
        int i7;
        Object obj7;
        Object obj8;
        IOException iOException;
        IOException iOException2;
        JSONException jSONException;
        JSONException jSONException2;
        super.run();
        if (this.a.a.h == null || this.a.a.i == null || !this.a.a.h.isOpen() || !this.a.a.i.isOpen()) {
            this.a.o = false;
            return;
        }
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        int i8;
        JSONObject jSONObject4 = null;
        try {
            jSONObject2 = new JSONObject(EntityUtils.toString(this.a.e, "utf-8"));
            try {
                jSONObject3 = jSONObject2.has("model") ? jSONObject2.getJSONObject("model") : null;
            } catch (ParseException e) {
                parseException = e;
                jSONObject3 = null;
                parseException2 = parseException;
                parseException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        obj2 = null;
                    } else {
                        try {
                            stringBuffer2.append(',');
                        } catch (Exception e2) {
                            this.a.c();
                            return;
                        } finally {
                            if (this.a.a.h != null && this.a.a.h.isOpen()) {
                                this.a.a.h.endTransaction();
                            }
                            if (this.a.a.i != null && this.a.a.i.isOpen()) {
                                this.a.a.i.endTransaction();
                            }
                            this.a.e = null;
                            this.a.o = false;
                        }
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj3 == null) {
                            obj3 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    } else {
                        if (obj == null) {
                            obj = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        obj6 = null;
                    } else {
                        stringBuffer2.append(',');
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj4 == null) {
                            obj4 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    } else {
                        if (obj5 == null) {
                            obj5 = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            } catch (IOException e3) {
                iOException = e3;
                jSONObject3 = null;
                iOException2 = iOException;
                iOException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj2 = null;
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj == null) {
                            stringBuffer.append(',');
                        } else {
                            obj = null;
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    } else {
                        if (obj3 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj3 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj6 = null;
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj5 == null) {
                            stringBuffer.append(',');
                        } else {
                            obj5 = null;
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    } else {
                        if (obj4 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj4 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            } catch (JSONException e4) {
                jSONException = e4;
                jSONObject3 = null;
                jSONException2 = jSONException;
                jSONException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        obj2 = null;
                    } else {
                        stringBuffer2.append(',');
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj3 == null) {
                            obj3 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    } else {
                        if (obj == null) {
                            obj = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        obj6 = null;
                    } else {
                        stringBuffer2.append(',');
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj4 == null) {
                            obj4 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    } else {
                        if (obj5 == null) {
                            obj5 = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            }
            try {
                if (jSONObject2.has("rgc")) {
                    jSONObject4 = jSONObject2.getJSONObject("rgc");
                }
            } catch (ParseException e5) {
                parseException2 = e5;
                parseException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj2 = null;
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj == null) {
                            stringBuffer.append(',');
                        } else {
                            obj = null;
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    } else {
                        if (obj3 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj3 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj6 = null;
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj5 == null) {
                            stringBuffer.append(',');
                        } else {
                            obj5 = null;
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    } else {
                        if (obj4 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj4 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            } catch (IOException e6) {
                iOException2 = e6;
                iOException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        obj2 = null;
                    } else {
                        stringBuffer2.append(',');
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj3 == null) {
                            obj3 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    } else {
                        if (obj == null) {
                            obj = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        obj6 = null;
                    } else {
                        stringBuffer2.append(',');
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj4 == null) {
                            obj4 = null;
                        } else {
                            stringBuffer3.append(',');
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    } else {
                        if (obj5 == null) {
                            obj5 = null;
                        } else {
                            stringBuffer.append(',');
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            } catch (JSONException e7) {
                jSONException2 = e7;
                jSONException2.printStackTrace();
                this.a.a.h.beginTransaction();
                this.a.a.i.beginTransaction();
                if (jSONObject4 != null) {
                    this.a.a.a.k().a(jSONObject4);
                }
                this.a.r = System.currentTimeMillis();
                this.a.n.a(jSONObject2.getString("bdlist").split(";"));
                this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                jSONObject = jSONObject3.getJSONObject("cell");
                keys = jSONObject.keys();
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                obj = 1;
                obj2 = 1;
                obj3 = 1;
                i = 0;
                i2 = 0;
                i3 = 0;
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj2 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj2 = null;
                    }
                    stringBuffer2.append(str);
                    i2++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj == null) {
                            stringBuffer.append(',');
                        } else {
                            obj = null;
                        }
                        stringBuffer.append(str);
                        i4 = i + 1;
                        obj4 = obj;
                    } else {
                        if (obj3 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj3 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i3++;
                        i4 = i;
                        obj4 = obj;
                    }
                    if (i2 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj2 = 1;
                        stringBuffer2.setLength(0);
                        i2 -= 100;
                    }
                    if (i3 >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj3 = 1;
                        stringBuffer3.setLength(0);
                        i3 -= 100;
                    }
                    if (i4 >= 100) {
                        this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        obj4 = 1;
                        stringBuffer.setLength(0);
                        i4 -= 100;
                    }
                    obj = obj4;
                    i = i4;
                }
                if (i2 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i3 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                jSONObject = jSONObject3.getJSONObject("ap");
                keys = jSONObject.keys();
                i5 = 0;
                i8 = 0;
                i6 = 0;
                obj5 = 1;
                obj6 = 1;
                obj4 = 1;
                stringBuffer = new StringBuffer();
                stringBuffer2 = new StringBuffer();
                stringBuffer3 = new StringBuffer();
                while (keys.hasNext()) {
                    str = (String) keys.next();
                    string = jSONObject.getString(str);
                    valueOf = Double.valueOf(string.split(",")[3]);
                    if (obj6 == null) {
                        stringBuffer2.append(',');
                    } else {
                        obj6 = null;
                    }
                    stringBuffer2.append(str);
                    i8++;
                    if (valueOf.doubleValue() <= 0.0d) {
                        if (obj5 == null) {
                            stringBuffer.append(',');
                        } else {
                            obj5 = null;
                        }
                        stringBuffer.append(str);
                        obj8 = obj4;
                        i = i6;
                        i6 = i5 + 1;
                        obj7 = obj8;
                    } else {
                        if (obj4 == null) {
                            stringBuffer3.append(',');
                        } else {
                            obj4 = null;
                        }
                        stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                        i4 = i6 + 1;
                        i6 = i5;
                        i7 = i4;
                        obj7 = obj4;
                        i = i7;
                    }
                    if (i8 >= 100) {
                        this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        obj6 = 1;
                        stringBuffer2.setLength(0);
                        i8 -= 100;
                    }
                    if (i >= 100) {
                        this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        obj7 = 1;
                        stringBuffer3.setLength(0);
                        i -= 100;
                    }
                    if (i6 > 0) {
                        this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    i5 = i6;
                    i6 = i;
                    obj4 = obj7;
                }
                if (i8 > 0) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                }
                if (i5 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
                this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
                this.a.c();
                this.a.a.h.setTransactionSuccessful();
                this.a.a.i.setTransactionSuccessful();
                this.a.a.h.endTransaction();
                this.a.a.i.endTransaction();
                this.a.e = null;
                this.a.o = false;
            }
        } catch (ParseException e8) {
            parseException = e8;
            jSONObject2 = null;
            jSONObject3 = null;
            parseException2 = parseException;
            parseException2.printStackTrace();
            this.a.a.h.beginTransaction();
            this.a.a.i.beginTransaction();
            if (jSONObject4 != null) {
                this.a.a.a.k().a(jSONObject4);
            }
            this.a.r = System.currentTimeMillis();
            this.a.n.a(jSONObject2.getString("bdlist").split(";"));
            this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj2 = null;
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj == null) {
                        stringBuffer.append(',');
                    } else {
                        obj = null;
                    }
                    stringBuffer.append(str);
                    i4 = i + 1;
                    obj4 = obj;
                } else {
                    if (obj3 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj3 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i4 = i;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i4 >= 100) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i4 -= 100;
                }
                obj = obj4;
                i = i4;
            }
            if (i2 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i5 = 0;
            i8 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj6 = null;
                }
                stringBuffer2.append(str);
                i8++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj5 == null) {
                        stringBuffer.append(',');
                    } else {
                        obj5 = null;
                    }
                    stringBuffer.append(str);
                    obj8 = obj4;
                    i = i6;
                    i6 = i5 + 1;
                    obj7 = obj8;
                } else {
                    if (obj4 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj4 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i4 = i6 + 1;
                    i6 = i5;
                    i7 = i4;
                    obj7 = obj4;
                    i = i7;
                }
                if (i8 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i8 -= 100;
                }
                if (i >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj7 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i5 = i6;
                i6 = i;
                obj4 = obj7;
            }
            if (i8 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i5 > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
            this.a.c();
            this.a.a.h.setTransactionSuccessful();
            this.a.a.i.setTransactionSuccessful();
            this.a.a.h.endTransaction();
            this.a.a.i.endTransaction();
            this.a.e = null;
            this.a.o = false;
        } catch (IOException e9) {
            iOException = e9;
            jSONObject2 = null;
            jSONObject3 = null;
            iOException2 = iOException;
            iOException2.printStackTrace();
            this.a.a.h.beginTransaction();
            this.a.a.i.beginTransaction();
            if (jSONObject4 != null) {
                this.a.a.a.k().a(jSONObject4);
            }
            this.a.r = System.currentTimeMillis();
            this.a.n.a(jSONObject2.getString("bdlist").split(";"));
            this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    obj2 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj3 == null) {
                        obj3 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i4 = i;
                    obj4 = obj;
                } else {
                    if (obj == null) {
                        obj = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    i4 = i + 1;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i4 >= 100) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i4 -= 100;
                }
                obj = obj4;
                i = i4;
            }
            if (i2 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i5 = 0;
            i8 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    obj6 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i8++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj4 == null) {
                        obj4 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i4 = i6 + 1;
                    i6 = i5;
                    i7 = i4;
                    obj7 = obj4;
                    i = i7;
                } else {
                    if (obj5 == null) {
                        obj5 = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    obj8 = obj4;
                    i = i6;
                    i6 = i5 + 1;
                    obj7 = obj8;
                }
                if (i8 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i8 -= 100;
                }
                if (i >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj7 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i5 = i6;
                i6 = i;
                obj4 = obj7;
            }
            if (i8 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i5 > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
            this.a.c();
            this.a.a.h.setTransactionSuccessful();
            this.a.a.i.setTransactionSuccessful();
            this.a.a.h.endTransaction();
            this.a.a.i.endTransaction();
            this.a.e = null;
            this.a.o = false;
        } catch (JSONException e10) {
            jSONException = e10;
            jSONObject2 = null;
            jSONObject3 = null;
            jSONException2 = jSONException;
            jSONException2.printStackTrace();
            this.a.a.h.beginTransaction();
            this.a.a.i.beginTransaction();
            if (jSONObject4 != null) {
                this.a.a.a.k().a(jSONObject4);
            }
            this.a.r = System.currentTimeMillis();
            this.a.n.a(jSONObject2.getString("bdlist").split(";"));
            this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj2 = null;
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj == null) {
                        stringBuffer.append(',');
                    } else {
                        obj = null;
                    }
                    stringBuffer.append(str);
                    i4 = i + 1;
                    obj4 = obj;
                } else {
                    if (obj3 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj3 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i4 = i;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i4 >= 100) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i4 -= 100;
                }
                obj = obj4;
                i = i4;
            }
            if (i2 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i5 = 0;
            i8 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj6 = null;
                }
                stringBuffer2.append(str);
                i8++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj5 == null) {
                        stringBuffer.append(',');
                    } else {
                        obj5 = null;
                    }
                    stringBuffer.append(str);
                    obj8 = obj4;
                    i = i6;
                    i6 = i5 + 1;
                    obj7 = obj8;
                } else {
                    if (obj4 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj4 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i4 = i6 + 1;
                    i6 = i5;
                    i7 = i4;
                    obj7 = obj4;
                    i = i7;
                }
                if (i8 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i8 -= 100;
                }
                if (i >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj7 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i5 = i6;
                i6 = i;
                obj4 = obj7;
            }
            if (i8 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i5 > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
            this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
            this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
            this.a.c();
            this.a.a.h.setTransactionSuccessful();
            this.a.a.i.setTransactionSuccessful();
            this.a.a.h.endTransaction();
            this.a.a.i.endTransaction();
            this.a.e = null;
            this.a.o = false;
        }
        this.a.a.h.beginTransaction();
        this.a.a.i.beginTransaction();
        if (jSONObject4 != null) {
            this.a.a.a.k().a(jSONObject4);
        }
        if (jSONObject2 != null && jSONObject2.has("type") && jSONObject2.getString("type").equals("0")) {
            this.a.r = System.currentTimeMillis();
        }
        if (jSONObject2 != null && jSONObject2.has("bdlist")) {
            this.a.n.a(jSONObject2.getString("bdlist").split(";"));
        }
        if (jSONObject2 != null && jSONObject2.has("loadurl")) {
            this.a.n.a(jSONObject2.getJSONObject("loadurl").getString("host"), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
        }
        if (jSONObject3 != null && jSONObject3.has("cell")) {
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    obj2 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj3 == null) {
                        obj3 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i4 = i;
                    obj4 = obj;
                } else {
                    if (obj == null) {
                        obj = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    i4 = i + 1;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i4 >= 100) {
                    this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i4 -= 100;
                }
                obj = obj4;
                i = i4;
            }
            if (i2 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
        }
        if (jSONObject3 != null && jSONObject3.has("ap")) {
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i5 = 0;
            i8 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    obj6 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i8++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj4 == null) {
                        obj4 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i4 = i6 + 1;
                    i6 = i5;
                    i7 = i4;
                    obj7 = obj4;
                    i = i7;
                } else {
                    if (obj5 == null) {
                        obj5 = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    obj8 = obj4;
                    i = i6;
                    i6 = i5 + 1;
                    obj7 = obj8;
                }
                if (i8 >= 100) {
                    this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i8 -= 100;
                }
                if (i >= 100) {
                    this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj7 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 > 0) {
                    this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i5 = i6;
                i6 = i;
                obj4 = obj7;
            }
            if (i8 > 0) {
                this.a.a.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.a.h.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i5 > 0) {
                this.a.a.h.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
        }
        this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
        this.a.a.h.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
        this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(10000)}));
        this.a.a.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(10000)}));
        if (!(jSONObject3 == null || jSONObject3.has("ap") || jSONObject3.has("cell"))) {
            this.a.c();
        }
        this.a.a.h.setTransactionSuccessful();
        this.a.a.i.setTransactionSuccessful();
        if (this.a.a.h != null && this.a.a.h.isOpen()) {
            this.a.a.h.endTransaction();
        }
        if (this.a.a.i != null && this.a.a.i.isOpen()) {
            this.a.a.i.endTransaction();
        }
        this.a.e = null;
        this.a.o = false;
    }
}
