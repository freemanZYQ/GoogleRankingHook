package com.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class o extends Binder implements n {
    public o() {
        attachInterface(this, "com.fingerprints.service.IFingerprintClient");
    }

    public static n a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.fingerprints.service.IFingerprintClient");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new p(iBinder) : (n) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintClient");
                a(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintClient");
                a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.fingerprints.service.IFingerprintClient");
                a(parcel.readInt(), parcel.readInt(), parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.fingerprints.service.IFingerprintClient");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
