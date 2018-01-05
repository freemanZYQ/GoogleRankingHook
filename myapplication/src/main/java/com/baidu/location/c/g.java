package com.baidu.location.c;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.b.h;
import com.baidu.location.h.c;
import com.baidu.location.h.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

final class g {
    private static final String[] a = new String[]{"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    final class a {
        final String a;
        final String b;
        final boolean c;
        final boolean d;
        final boolean e;
        final int f;
        final BDLocation g;
        final boolean h;
        final LinkedHashMap i;

        public a(String[] strArr) {
            if (strArr == null) {
                this.a = null;
                this.b = null;
                this.i = null;
                this.c = false;
                this.d = false;
                this.e = false;
                this.g = null;
                this.h = false;
                this.f = 8;
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            int i2 = 8;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            Object obj = null;
            BDLocation bDLocation = null;
            String str = null;
            String str2 = null;
            while (i < strArr.length) {
                if (strArr[i].equals("-loc")) {
                    str2 = strArr[i + 1];
                    String[] split = str2.split("&");
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (split[i3].startsWith("cl=")) {
                            str = split[i3].substring(3);
                        } else if (split[i3].startsWith("wf=")) {
                            String[] split2 = split[i3].substring(3).split("\\|");
                            for (String split3 : split2) {
                                String[] split4 = split3.split(";");
                                if (split4.length >= 2) {
                                    linkedHashMap.put(split4[0], Integer.valueOf(split4[1]));
                                }
                            }
                        }
                    }
                } else if (strArr[i].equals("-com")) {
                    String[] split5 = strArr[i + 1].split(";");
                    if (split5.length > 0) {
                        BDLocation bDLocation2 = new BDLocation();
                        try {
                            bDLocation2.setLatitude(Double.valueOf(split5[0]).doubleValue());
                            bDLocation2.setLongitude(Double.valueOf(split5[1]).doubleValue());
                            bDLocation2.setLocType(Integer.valueOf(split5[2]).intValue());
                            bDLocation2.setNetworkLocationType(split5[3]);
                            bDLocation = bDLocation2;
                        } catch (Exception e) {
                            bDLocation = bDLocation2;
                        }
                    } else {
                        continue;
                    }
                } else {
                    try {
                        if (strArr[i].equals("-log")) {
                            if (strArr[i + 1].equals("true")) {
                                obj = 1;
                            }
                        } else if (strArr[i].equals("-rgc")) {
                            if (strArr[i + 1].equals("true")) {
                                z2 = true;
                            }
                        } else if (strArr[i].equals("-poi")) {
                            if (strArr[i + 1].equals("true")) {
                                z3 = true;
                            }
                        } else if (strArr[i].equals("-minap")) {
                            try {
                                i2 = Integer.valueOf(strArr[i + 1]).intValue();
                            } catch (Exception e2) {
                            }
                        } else if (strArr[i].equals("-des") && strArr[i + 1].equals("true")) {
                            z = true;
                        }
                    } catch (Exception e3) {
                    }
                }
                i += 2;
            }
            if (obj == null) {
                str2 = null;
            }
            boolean z4 = true;
            this.a = str2;
            this.b = str;
            this.i = linkedHashMap;
            this.c = z4;
            this.d = z3;
            this.e = z2;
            this.f = i2;
            this.g = bDLocation;
            this.h = z;
            z4 = false;
            this.a = str2;
            this.b = str;
            this.i = linkedHashMap;
            this.c = z4;
            this.d = z3;
            this.e = z2;
            this.f = i2;
            this.g = bDLocation;
            this.h = z;
        }
    }

    static Cursor a(BDLocation bDLocation) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String format = b.format(new Date(System.currentTimeMillis()));
        Object matrixCursor = new MatrixCursor(a);
        Object[] objArr = new Object[a.length];
        objArr[matrixCursor.getColumnIndex("CoorType")] = "gcj02";
        objArr[matrixCursor.getColumnIndex("Time")] = format;
        objArr[matrixCursor.getColumnIndex("LocType")] = Integer.valueOf(bDLocation.getLocType());
        objArr[matrixCursor.getColumnIndex("Longitude")] = Double.valueOf(bDLocation.getLongitude());
        objArr[matrixCursor.getColumnIndex("Latitude")] = Double.valueOf(bDLocation.getLatitude());
        objArr[matrixCursor.getColumnIndex("Radius")] = Float.valueOf(bDLocation.getRadius());
        objArr[matrixCursor.getColumnIndex("NetworkLocationType")] = bDLocation.getNetworkLocationType();
        com.baidu.location.a address = bDLocation.getAddress();
        if (address != null) {
            str = address.country;
            str2 = address.countryCode;
            str3 = address.province;
            str4 = address.city;
            str5 = address.cityCode;
            str6 = address.district;
            str7 = address.street;
            format = address.streetNumber;
        } else {
            format = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        objArr[matrixCursor.getColumnIndex("Country")] = str;
        objArr[matrixCursor.getColumnIndex("CountryCode")] = str2;
        objArr[matrixCursor.getColumnIndex("Province")] = str3;
        objArr[matrixCursor.getColumnIndex("City")] = str4;
        objArr[matrixCursor.getColumnIndex("CityCode")] = str5;
        objArr[matrixCursor.getColumnIndex("District")] = str6;
        objArr[matrixCursor.getColumnIndex("Street")] = str7;
        objArr[matrixCursor.getColumnIndex("StreetNumber")] = format;
        List poiList = bDLocation.getPoiList();
        if (poiList == null) {
            objArr[matrixCursor.getColumnIndex("PoiList")] = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < poiList.size(); i++) {
                Poi poi = (Poi) poiList.get(i);
                stringBuffer.append(poi.getId()).append(";").append(poi.getName()).append(";").append(poi.getRank()).append(";|");
            }
            objArr[matrixCursor.getColumnIndex("PoiList")] = stringBuffer.toString();
        }
        objArr[matrixCursor.getColumnIndex("LocationDescription")] = bDLocation.getLocationDescribe();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    static BDLocation a(Cursor cursor) {
        BDLocation bDLocation = new BDLocation();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            bDLocation.setLocType(67);
        } else {
            Integer num = null;
            Double d = null;
            Double d2 = null;
            String str = null;
            String str2 = null;
            Float f = null;
            String str3 = null;
            if (cursor.getColumnIndex("LocType") != -1) {
                num = Integer.valueOf(cursor.getInt(cursor.getColumnIndex("LocType")));
            }
            if (cursor.getColumnIndex("Latitude") != -1) {
                d = Double.valueOf(cursor.getDouble(cursor.getColumnIndex("Latitude")));
            }
            if (cursor.getColumnIndex("Longitude") != -1) {
                d2 = Double.valueOf(cursor.getDouble(cursor.getColumnIndex("Longitude")));
            }
            if (cursor.getColumnIndex("CoorType") != -1) {
                str = cursor.getString(cursor.getColumnIndex("CoorType"));
            }
            if (cursor.getColumnIndex("NetworkLocationType") != -1) {
                str2 = cursor.getString(cursor.getColumnIndex("NetworkLocationType"));
            }
            if (cursor.getColumnIndex("Radius") != -1) {
                f = Float.valueOf(cursor.getFloat(cursor.getColumnIndex("Radius")));
            }
            if (cursor.getColumnIndex("Time") != -1) {
                str3 = cursor.getString(cursor.getColumnIndex("Time"));
            }
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            if (cursor.getColumnIndex("Country") != -1) {
                str4 = cursor.getString(cursor.getColumnIndex("Country"));
            }
            if (cursor.getColumnIndex("CountryCode") != -1) {
                str5 = cursor.getString(cursor.getColumnIndex("CountryCode"));
            }
            if (cursor.getColumnIndex("Province") != -1) {
                str6 = cursor.getString(cursor.getColumnIndex("Province"));
            }
            if (cursor.getColumnIndex("City") != -1) {
                str7 = cursor.getString(cursor.getColumnIndex("City"));
            }
            if (cursor.getColumnIndex("CityCode") != -1) {
                str8 = cursor.getString(cursor.getColumnIndex("CityCode"));
            }
            if (cursor.getColumnIndex("District") != -1) {
                str9 = cursor.getString(cursor.getColumnIndex("District"));
            }
            if (cursor.getColumnIndex("Street") != -1) {
                str10 = cursor.getString(cursor.getColumnIndex("Street"));
            }
            if (cursor.getColumnIndex("StreetNumber") != -1) {
                str11 = cursor.getString(cursor.getColumnIndex("StreetNumber"));
            }
            com.baidu.location.a build = new com.baidu.location.a.a().country(str4).countryCode(str5).province(str6).city(str7).cityCode(str8).district(str9).street(str10).streetNumber(str11).build();
            List list = null;
            if (cursor.getColumnIndex("PoiList") != -1) {
                list = new ArrayList();
                str5 = cursor.getString(cursor.getColumnIndex("PoiList"));
                if (str5 != null) {
                    try {
                        String[] split = str5.split("\\|");
                        for (String str82 : split) {
                            String[] split2 = str82.split(";");
                            if (split2.length >= 3) {
                                list.add(new Poi(split2[0], split2[1], Double.valueOf(split2[2]).doubleValue()));
                            }
                        }
                    } catch (Exception e) {
                        if (list.size() == 0) {
                            list = null;
                        }
                    } catch (Throwable th) {
                        if (list.size() == 0) {
                        }
                    }
                }
                if (list.size() == 0) {
                    list = null;
                }
            }
            str5 = null;
            if (cursor.getColumnIndex("LocationDescription") != -1) {
                str5 = cursor.getString(cursor.getColumnIndex("LocationDescription"));
            }
            bDLocation.setTime(str3);
            bDLocation.setRadius(f.floatValue());
            bDLocation.setLocType(num.intValue());
            bDLocation.setCoorType(str);
            bDLocation.setLatitude(d.doubleValue());
            bDLocation.setLongitude(d2.doubleValue());
            bDLocation.setNetworkLocationType(str2);
            bDLocation.setAddr(build);
            bDLocation.setPoiList(list);
            bDLocation.setLocationDescribe(str5);
        }
        return bDLocation;
    }

    static String a(BDLocation bDLocation, int i) {
        if (bDLocation == null || bDLocation.getLocType() == 67) {
            return String.format(Locale.CHINA, "&ofl=%s|%d", new Object[]{"1", Integer.valueOf(i)});
        }
        String format = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[]{"1", Integer.valueOf(i), Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())});
        String str = bDLocation.getAddress() != null ? format + "&ofaddr=" + bDLocation.getAddress().address : format;
        if (bDLocation.getPoiList() == null || bDLocation.getPoiList().size() <= 0) {
            return str;
        }
        Poi poi = (Poi) bDLocation.getPoiList().get(0);
        return str + String.format(Locale.US, "&ofpoi=%s|%s", new Object[]{poi.getId(), poi.getName()});
    }

    static String a(BDLocation bDLocation, BDLocation bDLocation2, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bDLocation2 == null) {
            stringBuffer.append("&ofcl=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofcl=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())}));
        }
        if (bDLocation == null) {
            stringBuffer.append("&ofwf=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofwf=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())}));
        }
        if (aVar == null || !aVar.e) {
            stringBuffer.append("&rgcn=0");
        } else {
            stringBuffer.append("&rgcn=1");
        }
        if (aVar == null || !aVar.d) {
            stringBuffer.append("&poin=0");
        } else {
            stringBuffer.append("&poin=1");
        }
        if (aVar == null || !aVar.h) {
            stringBuffer.append("&desc=0");
        } else {
            stringBuffer.append("&desc=1");
        }
        if (aVar != null) {
            stringBuffer.append(String.format(Locale.US, "&aps=%d", new Object[]{Integer.valueOf(aVar.f)}));
        }
        return stringBuffer.toString();
    }

    static String[] a(i iVar, com.baidu.location.h.g gVar, BDLocation bDLocation, String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (iVar != null) {
            stringBuffer.append(c.a().b(iVar));
        }
        if (gVar != null) {
            stringBuffer.append(gVar.a(30));
        }
        if (stringBuffer.length() > 0) {
            if (str != null) {
                stringBuffer.append(str);
            }
            arrayList.add("-loc");
            arrayList.add(stringBuffer.toString());
        }
        if (bDLocation != null) {
            String format = String.format(Locale.US, "%f;%f;%d;%s", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Integer.valueOf(bDLocation.getLocType()), bDLocation.getNetworkLocationType()});
            arrayList.add("-com");
            arrayList.add(format);
        }
        if (z) {
            arrayList.add("-log");
            arrayList.add("true");
        }
        if (h.f.equals("all")) {
            arrayList.add("-rgc");
            arrayList.add("true");
        }
        if (h.h) {
            arrayList.add("-poi");
            arrayList.add("true");
        }
        if (h.g) {
            arrayList.add("-des");
            arrayList.add("true");
        }
        arrayList.add("-minap");
        arrayList.add(Integer.toString(i));
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
