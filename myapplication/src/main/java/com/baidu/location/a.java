package com.baidu.location;

public final class a {
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;

    public class a {
        private String a = null;
        private String b = null;
        private String c = null;
        private String d = null;
        private String e = null;
        private String f = null;
        private String g = null;
        private String h = null;
        private String i = null;

        public a build() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.a != null) {
                stringBuffer.append(this.a);
            }
            if (this.c != null) {
                stringBuffer.append(this.c);
            }
            if (!(this.c == null || this.d == null || ((this.c.contains("北京") && this.d.contains("北京")) || ((this.c.contains("上海") && this.d.contains("上海")) || ((this.c.contains("天津") && this.d.contains("天津")) || (this.c.contains("重庆") && this.d.contains("重庆"))))))) {
                stringBuffer.append(this.d);
            }
            if (this.f != null) {
                stringBuffer.append(this.f);
            }
            if (this.g != null) {
                stringBuffer.append(this.g);
            }
            if (this.h != null) {
                stringBuffer.append(this.h);
            }
            if (stringBuffer.length() > 0) {
                this.i = stringBuffer.toString();
            }
            return new a();
        }

        public a city(String str) {
            this.d = str;
            return this;
        }

        public a cityCode(String str) {
            this.e = str;
            return this;
        }

        public a country(String str) {
            this.a = str;
            return this;
        }

        public a countryCode(String str) {
            this.b = str;
            return this;
        }

        public a district(String str) {
            this.f = str;
            return this;
        }

        public a province(String str) {
            this.c = str;
            return this;
        }

        public a street(String str) {
            this.g = str;
            return this;
        }

        public a streetNumber(String str) {
            this.h = str;
            return this;
        }
    }

    private a(a aVar) {
        this.country = aVar.a;
        this.countryCode = aVar.b;
        this.province = aVar.c;
        this.city = aVar.d;
        this.cityCode = aVar.e;
        this.district = aVar.f;
        this.street = aVar.g;
        this.streetNumber = aVar.h;
        this.address = aVar.i;
    }
}
