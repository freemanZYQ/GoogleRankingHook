package com.baidu.location.h;

import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.b.h;
import com.baidu.location.f;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class c extends k {
    public static int a = 0;
    public static int b = 0;
    private static c c = null;
    private static Method j = null;
    private static Method k = null;
    private static Method l = null;
    private static Method m = null;
    private static Method n = null;
    private static Class o = null;
    private TelephonyManager d = null;
    private i e = new i();
    private i f = null;
    private List g = null;
    private a h = null;
    private boolean i = false;
    private boolean p = false;

    class a extends PhoneStateListener {
        final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation != null) {
                try {
                    this.a.j();
                } catch (Exception e) {
                }
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (this.a.e == null) {
                return;
            }
            if (this.a.e.i == 'g') {
                this.a.e.h = signalStrength.getGsmSignalStrength();
            } else if (this.a.e.i == 'c') {
                this.a.e.h = signalStrength.getCdmaDbm();
            }
        }
    }

    private c() {
    }

    private int a(int i) {
        return i == Integer.MAX_VALUE ? -1 : i;
    }

    public static c a() {
        if (c == null) {
            c = new c();
        }
        return c;
    }

    private i a(CellInfo cellInfo) {
        int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        i iVar = new i();
        Object obj = null;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            iVar.c = a(cellIdentity.getMcc());
            iVar.d = a(cellIdentity.getMnc());
            iVar.a = a(cellIdentity.getLac());
            iVar.b = a(cellIdentity.getCid());
            iVar.i = 'g';
            iVar.h = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            obj = 1;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            iVar.e = cellIdentity2.getLatitude();
            iVar.f = cellIdentity2.getLongitude();
            iVar.d = a(cellIdentity2.getSystemId());
            iVar.a = a(cellIdentity2.getNetworkId());
            iVar.b = a(cellIdentity2.getBasestationId());
            iVar.i = 'c';
            iVar.h = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            r2 = 1;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            iVar.c = a(cellIdentity3.getMcc());
            iVar.d = a(cellIdentity3.getMnc());
            iVar.a = a(cellIdentity3.getTac());
            iVar.b = a(cellIdentity3.getCi());
            iVar.i = 'g';
            iVar.h = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            r2 = 1;
        }
        if (intValue >= 18 && r2 == null) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    iVar.c = a(cellIdentity4.getMcc());
                    iVar.d = a(cellIdentity4.getMnc());
                    iVar.a = a(cellIdentity4.getLac());
                    iVar.b = a(cellIdentity4.getCid());
                    iVar.i = 'g';
                    iVar.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e) {
            }
        }
        iVar.g = System.currentTimeMillis();
        return iVar;
    }

    private i a(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation == null || this.d == null) {
            return null;
        }
        i iVar = new i();
        iVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.e.c;
                    }
                    iVar.c = intValue;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] toCharArray = substring.toCharArray();
                    while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                        i++;
                    }
                }
                i = Integer.valueOf(substring.substring(0, i)).intValue();
                if (i < 0) {
                    i = this.e.d;
                }
                iVar.d = i;
            }
            a = this.d.getSimState();
        } catch (Exception e) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            iVar.a = ((GsmCellLocation) cellLocation).getLac();
            iVar.b = ((GsmCellLocation) cellLocation).getCid();
            iVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            iVar.i = 'c';
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 5) {
                return iVar;
            }
            if (o == null) {
                try {
                    o = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    j = o.getMethod("getBaseStationId", new Class[0]);
                    k = o.getMethod("getNetworkId", new Class[0]);
                    l = o.getMethod("getSystemId", new Class[0]);
                    m = o.getMethod("getBaseStationLatitude", new Class[0]);
                    n = o.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    o = null;
                    b = 2;
                    return iVar;
                }
            }
            if (o != null && o.isInstance(cellLocation)) {
                try {
                    int intValue2 = ((Integer) l.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.e.d;
                    }
                    iVar.d = intValue2;
                    iVar.b = ((Integer) j.invoke(cellLocation, new Object[0])).intValue();
                    iVar.a = ((Integer) k.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = m.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        iVar.e = ((Integer) invoke).intValue();
                    }
                    invoke = n.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < Integer.MAX_VALUE) {
                        iVar.f = ((Integer) invoke).intValue();
                    }
                } catch (Exception e3) {
                    b = 3;
                    return iVar;
                }
            }
        }
        c(iVar);
        return iVar;
    }

    private void c(i iVar) {
        if (!iVar.c()) {
            return;
        }
        if (this.e == null || !this.e.a(iVar)) {
            this.e = iVar;
            if (iVar.c()) {
                int size = this.g.size();
                i iVar2 = size == 0 ? null : (i) this.g.get(size - 1);
                if (iVar2 == null || iVar2.b != this.e.b || iVar2.a != this.e.a) {
                    this.g.add(this.e);
                    if (this.g.size() > 3) {
                        this.g.remove(0);
                    }
                    i();
                    this.p = false;
                }
            } else if (this.g != null) {
                this.g.clear();
            }
        }
    }

    private String d(i iVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Integer.valueOf(VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    stringBuilder.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered()) {
                            i a = a(cellInfo);
                            if (!(a == null || a.a == -1 || a.b == -1)) {
                                if (iVar.a != a.a) {
                                    stringBuilder.append(a.a + "|" + a.b + "|" + a.h + ";");
                                } else {
                                    stringBuilder.append("|" + a.b + "|" + a.h + ";");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return stringBuilder.toString();
    }

    private void h() {
        String f = h.f();
        if (f != null) {
            File file = new File(f + File.separator + "lcvif.dat");
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    for (int i = 0; i < 3; i++) {
                        long readLong = randomAccessFile.readLong();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        int readInt5 = randomAccessFile.readInt();
                        char c = '\u0000';
                        if (readInt5 == 1) {
                            c = 'g';
                        }
                        if (readInt5 == 2) {
                            c = 'c';
                        }
                        if (readLong != 0) {
                            i iVar = new i(readInt3, readInt4, readInt, readInt2, 0, c);
                            iVar.g = readLong;
                            if (iVar.c()) {
                                this.p = true;
                                this.g.add(iVar);
                            }
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                    file.delete();
                }
            }
        }
    }

    private void i() {
        int i = 0;
        if (this.g != null || this.f != null) {
            if (this.g == null && this.f != null) {
                this.g = new LinkedList();
                this.g.add(this.f);
            }
            String f = h.f();
            if (f != null) {
                File file = new File(f + File.separator + "lcvif.dat");
                int size = this.g.size();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeLong(((i) this.g.get(size - 1)).g);
                    randomAccessFile.writeInt(size);
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(2);
                    }
                    while (i < size) {
                        randomAccessFile.writeLong(((i) this.g.get(i)).g);
                        randomAccessFile.writeInt(((i) this.g.get(i)).c);
                        randomAccessFile.writeInt(((i) this.g.get(i)).d);
                        randomAccessFile.writeInt(((i) this.g.get(i)).a);
                        randomAccessFile.writeInt(((i) this.g.get(i)).b);
                        if (((i) this.g.get(i)).i == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (((i) this.g.get(i)).i == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                        i++;
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private void j() {
        i a = a(this.d.getCellLocation());
        if (a == null || !a.c()) {
            a = k();
            if (a != null) {
                c(a);
            }
        }
    }

    private i k() {
        if (Integer.valueOf(VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.d.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            i iVar = null;
            for (CellInfo cellInfo : allCellInfo) {
                try {
                    if (cellInfo.isRegistered()) {
                        i a = a(cellInfo);
                        if (a == null) {
                            iVar = a;
                        } else {
                            try {
                                if (a.c()) {
                                    a.g();
                                } else {
                                    a = null;
                                }
                                return a;
                            } catch (Exception e) {
                                return a;
                            }
                        }
                    }
                } catch (Exception e2) {
                    return iVar;
                }
            }
            return iVar;
        } catch (Exception e3) {
            return null;
        }
    }

    public String a(i iVar) {
        String str = "";
        try {
            str = d(iVar);
            if (str != null && !str.equals("") && !str.equals("&nc=")) {
                return str;
            }
            List<NeighboringCellInfo> neighboringCellInfo = this.d.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                String str2 = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    str = (lac == -1 || neighboringCellInfo2.getCid() == -1) ? str2 : iVar.a != lac ? str2 + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";" : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + ";";
                    int i2 = i + 1;
                    if (i2 >= 8) {
                        break;
                    }
                    i = i2;
                    str2 = str;
                }
                str = str2;
            }
            return (str == null || !str.equals("&nc=")) ? str : null;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
    }

    public String b(i iVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(iVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(iVar.c), Integer.valueOf(iVar.d), Integer.valueOf(iVar.a), Integer.valueOf(iVar.b), Integer.valueOf(iVar.h)}));
        if (iVar.e < Integer.MAX_VALUE && iVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) iVar.f) / 14400.0d), Double.valueOf(((double) iVar.e) / 14400.0d)}));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(iVar.g);
        if (this.g != null && this.g.size() > 0) {
            int size = this.g.size();
            stringBuffer.append("&clt=");
            for (int i = 0; i < size; i++) {
                i iVar2 = (i) this.g.get(i);
                if (iVar2.c != iVar.c) {
                    stringBuffer.append(iVar2.c);
                }
                stringBuffer.append("|");
                if (iVar2.d != iVar.d) {
                    stringBuffer.append(iVar2.d);
                }
                stringBuffer.append("|");
                if (iVar2.a != iVar.a) {
                    stringBuffer.append(iVar2.a);
                }
                stringBuffer.append("|");
                if (iVar2.b != iVar.b) {
                    stringBuffer.append(iVar2.b);
                }
                stringBuffer.append("|");
                stringBuffer.append((System.currentTimeMillis() - iVar2.g) / 1000);
                stringBuffer.append(";");
            }
        }
        if (a > 100) {
            a = 0;
        }
        stringBuffer.append("&cs=" + ((b << 8) + a));
        return stringBuffer.toString();
    }

    public synchronized void b() {
        if (!this.i) {
            if (f.isServing) {
                this.d = (TelephonyManager) f.getServiceContext().getSystemService("phone");
                this.g = new LinkedList();
                this.h = new a(this);
                h();
                if (!(this.d == null || this.h == null)) {
                    try {
                        this.d.listen(this.h, 272);
                    } catch (Exception e) {
                    }
                    this.i = true;
                }
            }
        }
    }

    public synchronized void c() {
        if (this.i) {
            if (!(this.h == null || this.d == null)) {
                this.d.listen(this.h, 0);
            }
            this.h = null;
            this.d = null;
            this.g.clear();
            this.g = null;
            i();
            this.i = false;
        }
    }

    public boolean d() {
        return this.p;
    }

    public int e() {
        return this.d == null ? 0 : this.d.getNetworkType();
    }

    public i f() {
        if (!((this.e != null && this.e.b() && this.e.c()) || this.d == null)) {
            try {
                j();
            } catch (Exception e) {
            }
        }
        if (this.e.f()) {
            this.f = null;
            this.f = new i(this.e.a, this.e.b, this.e.c, this.e.d, this.e.h, this.e.i);
        }
        if (this.e.e() && this.f != null && this.e.i == 'g') {
            this.e.d = this.f.d;
            this.e.c = this.f.c;
        }
        return this.e;
    }

    public int g() {
        String subscriberId = ((TelephonyManager) f.getServiceContext().getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }
}
