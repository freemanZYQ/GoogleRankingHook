package com.baidu.location.g;

import android.util.Xml;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;

class a {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    private double h = Double.MIN_VALUE;
    private double i = Double.MIN_VALUE;
    private float j = 0.0f;
    private boolean k = false;
    private boolean l = true;

    public a(String str) {
        boolean z = false;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (!z) {
                        if (!newPullParser.getName().equals("LocationRS")) {
                            break;
                        }
                        z = true;
                        break;
                    }
                    String name = newPullParser.getName();
                    if (name == null) {
                        continue;
                    } else if (name.equals("latitude")) {
                        try {
                            this.h = Double.valueOf(newPullParser.nextText()).doubleValue();
                            break;
                        } catch (Exception e) {
                            this.l = false;
                            break;
                        }
                    } else if (name.equals("longitude")) {
                        try {
                            this.i = Double.valueOf(newPullParser.nextText()).doubleValue();
                            break;
                        } catch (Exception e2) {
                            this.l = false;
                            break;
                        }
                    } else if (name.equals("hpe")) {
                        try {
                            this.j = Float.valueOf(newPullParser.nextText()).floatValue();
                            break;
                        } catch (Exception e3) {
                            this.l = false;
                            break;
                        }
                    } else if (name.equals("country")) {
                        try {
                            this.c = newPullParser.getAttributeValue(0);
                        } catch (Exception e4) {
                        }
                        try {
                            this.b = newPullParser.nextText();
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    } else if (name.equals("province")) {
                        try {
                            this.d = newPullParser.nextText();
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    } else if (name.equals("region")) {
                        try {
                            this.e = newPullParser.nextText();
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                    } else if (name.equals("street-number")) {
                        try {
                            this.g = newPullParser.nextText();
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    } else if (name.equals("city")) {
                        try {
                            this.a = newPullParser.nextText();
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                    } else if (name.equals("address-line")) {
                        try {
                            this.f = newPullParser.nextText();
                            break;
                        } catch (Exception e10) {
                            break;
                        }
                    } else {
                        try {
                            if (!name.equals("error")) {
                                break;
                            }
                            this.l = false;
                            break;
                        } catch (Exception e11) {
                            return;
                        }
                    }
                default:
                    break;
            }
        }
    }

    public boolean a() {
        return this.b.equals("China") || this.b.equals("Taiwan") || this.c.equals("HK");
    }

    public boolean b() {
        return this.l;
    }

    public double c() {
        return this.h;
    }

    public double d() {
        return this.i;
    }

    public float e() {
        return this.j;
    }
}
