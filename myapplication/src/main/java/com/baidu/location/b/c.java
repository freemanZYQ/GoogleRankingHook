package com.baidu.location.b;

import com.baidu.location.h.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private static c a = null;
    private long b = 0;
    private long c = 0;
    private long d = 0;
    private String e = null;
    private String f = null;
    private String g = "loc.map.baidu.com";
    private String h = "dns.map.baidu.com";
    private int i = 0;
    private a j = new a(this);

    class a extends j {
        final /* synthetic */ c a;
        private boolean k = false;

        public a(c cVar) {
            this.a = cVar;
        }

        public void a() {
            if (this.a.h.equals("dns.map.baidu.com") || System.currentTimeMillis() - this.a.b > 720000) {
                switch (d.a().g()) {
                    case 1:
                        this.a.h = "111.13.100.247";
                        break;
                    case 2:
                        this.a.h = "111.206.37.190";
                        break;
                    case 3:
                        this.a.h = "180.97.33.196";
                        break;
                    default:
                        this.a.h = "dns.map.baidu.com";
                        break;
                }
            }
            this.c = "http://" + this.a.h + ":80/remotedns?pid=lbs-geolocation";
        }

        public void a(boolean z) {
            String str = null;
            if (z && this.e != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.e, "utf-8"));
                    if (jSONObject.getInt("errno") == 0 && jSONObject.has("data")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        JSONObject jSONObject3 = jSONArray.getJSONObject(1);
                        String string = jSONObject2.has("loc.map.baidu.com") ? jSONObject2.getJSONArray("loc.map.baidu.com").getJSONObject(0).getString("ip") : null;
                        if (jSONObject3.has("dns.map.baidu.com")) {
                            str = jSONObject3.getJSONArray("dns.map.baidu.com").getJSONObject(0).getString("ip");
                        }
                        if (!(string == null || str == null)) {
                            this.a.h = str;
                            this.a.g = string;
                        }
                        if (jSONObject.has("switch")) {
                            this.a.i = jSONObject.getInt("switch");
                        }
                        this.a.b = System.currentTimeMillis();
                        c();
                    }
                } catch (Exception e) {
                }
            }
            this.k = false;
        }

        void b() {
            if (!this.k) {
                this.k = true;
                d();
            }
        }

        void c() {
            if (System.currentTimeMillis() - this.a.d < 1200000) {
                this.a.d();
                return;
            }
            String str;
            InetAddress byName;
            try {
                str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"net.dns1"});
            } catch (Exception e) {
                str = null;
            }
            try {
                byName = InetAddress.getByName("loc.map.baidu.com");
            } catch (Exception e2) {
                byName = null;
            }
            if (byName != null && byName.getHostAddress() != null && str != null && !"".equals(str)) {
                this.a.e = str;
                this.a.f = byName.getHostAddress();
                this.a.d = System.currentTimeMillis();
                this.a.d();
            }
        }
    }

    private c() {
        e();
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("dnsServer")) {
                this.e = jSONObject.getString("dnsServer");
            }
            if (jSONObject.has("locServer")) {
                this.f = jSONObject.getString("locServer");
            }
            if (jSONObject.has("address")) {
                this.g = jSONObject.getString("address");
            }
            if (jSONObject.has("locServer")) {
                this.h = jSONObject.getString("dnsServerIp");
            }
            if (jSONObject.has("DnsProxyTime")) {
                this.b = jSONObject.getLong("DnsProxyTime");
            }
            if (jSONObject.has("DnsExtraTime")) {
                this.c = jSONObject.getLong("DnsExtraTime");
            }
            if (jSONObject.has("DnsExtraUpdateTime")) {
                this.d = jSONObject.getLong("DnsExtraUpdateTime");
            }
            if (jSONObject.has("enable")) {
                this.i = jSONObject.getInt("enable");
            }
        } catch (Exception e) {
        }
    }

    private String c() {
        String str = null;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.e != null) {
                jSONObject.put("dnsServer", this.e);
            }
            if (this.f != null) {
                jSONObject.put("locServer", this.f);
            }
            if (this.g != null) {
                jSONObject.put("address", this.g);
            }
            if (this.h != null) {
                jSONObject.put("dnsServerIp", this.h);
            }
            jSONObject.put("DnsProxyTime", this.b);
            jSONObject.put("DnsExtraTime", this.c);
            jSONObject.put("DnsExtraUpdateTime", this.d);
            jSONObject.put("enable", this.i);
            str = jSONObject.toString();
        } catch (Exception e) {
        }
        return str;
    }

    private void d() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(d.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(d.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(800);
            String c = c();
            if (c != null) {
                randomAccessFile.writeBoolean(true);
                byte[] bytes2 = c.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void e() {
        try {
            File file = new File(d.a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(800);
                if (randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    a(new String(bArr));
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public String b() {
        String str = "loc.map.baidu.com";
        if (this.i == 1 && System.currentTimeMillis() - this.b < 360000) {
            str = this.g;
        }
        if (System.currentTimeMillis() - this.b > 300000) {
            this.j.b();
        }
        return str;
    }
}
