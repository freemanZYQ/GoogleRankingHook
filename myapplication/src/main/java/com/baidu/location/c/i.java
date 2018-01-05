package com.baidu.location.c;

import android.content.pm.ProviderInfo;
import android.database.Cursor;
import com.baidu.location.BDLocation;
import java.util.concurrent.Callable;

class i implements Callable {
    final /* synthetic */ String[] a;
    final /* synthetic */ h b;

    i(h hVar, String[] strArr) {
        this.b = hVar;
        this.a = strArr;
    }

    public BDLocation a() {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        BDLocation bDLocation = new BDLocation();
        if (this.a.length > 0) {
            ProviderInfo providerInfo;
            ProviderInfo resolveContentProvider = h.c.getPackageManager().resolveContentProvider(h.b, 0);
            if (resolveContentProvider == null) {
                String[] o = this.b.i.o();
                providerInfo = resolveContentProvider;
                for (String resolveContentProvider2 : o) {
                    providerInfo = h.c.getPackageManager().resolveContentProvider(resolveContentProvider2, 0);
                    if (providerInfo != null) {
                        break;
                    }
                }
            } else {
                providerInfo = resolveContentProvider;
            }
            if (providerInfo != null) {
                BDLocation a;
                try {
                    Cursor query = h.c.getContentResolver().query(h.c(providerInfo.authority), this.a, null, null, null);
                    try {
                        a = g.a(query);
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        cursor = query;
                        if (cursor == null) {
                            try {
                                cursor.close();
                                a = bDLocation;
                            } catch (Exception e3) {
                                a = bDLocation;
                            }
                        } else {
                            a = bDLocation;
                        }
                        bDLocation = a;
                        bDLocation.setLocType(66);
                        return bDLocation;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = query;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    cursor = null;
                    if (cursor == null) {
                        a = bDLocation;
                    } else {
                        cursor.close();
                        a = bDLocation;
                    }
                    bDLocation = a;
                    bDLocation.setLocType(66);
                    return bDLocation;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                bDLocation = a;
            } else {
                try {
                    cursor2 = this.b.g.a(new a(this.a));
                    bDLocation = g.a(cursor2);
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e6) {
                        }
                    }
                } catch (Exception e7) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e8) {
                        }
                    }
                } catch (Throwable th4) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e9) {
                        }
                    }
                }
            }
            if (!(bDLocation == null || bDLocation.getLocType() == 67)) {
                bDLocation.setLocType(66);
            }
        }
        return bDLocation;
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
