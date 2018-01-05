package com.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;

public abstract class r extends Binder implements q {
    public static q a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.fingerprints.service.IFingerprintService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new s(iBinder) : (q) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean a;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a = a(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a(o.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                b(o.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a(o.a(parcel.readStrongBinder()), parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a = b(o.a(parcel.readStrongBinder()), parcel.createIntArray());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                b(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                c(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                int[] d = d(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeIntArray(d);
                return true;
            case 9:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a = a(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a = a();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 11:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                a = b();
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 12:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                c();
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                d();
                parcel2.writeNoException();
                return true;
            case IMediaObject.TYPE_OLD_TV /*14*/:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintService");
                e(o.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.fingerprints.service.IFingerprintService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
