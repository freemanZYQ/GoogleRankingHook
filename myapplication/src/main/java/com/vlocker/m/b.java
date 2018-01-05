package com.vlocker.m;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog.Calls;

public class b {
    public static int a(Context context) {
        int count;
        Throwable th;
        Cursor cursor = null;
        Cursor query;
        try {
            query = context.getContentResolver().query(Calls.CONTENT_URI, new String[]{"_id"}, "type=3 and new=1", null, null);
            if (query != null) {
                try {
                    count = query.getCount();
                } catch (Exception e) {
                    count = -1;
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e2) {
                        }
                    }
                    return count;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e4) {
                }
            }
        } catch (Exception e5) {
            query = null;
            count = -1;
            if (query != null) {
                query.close();
            }
            return count;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return count;
    }

    public static int b(Context context) {
        int count;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"_id"}, " read = 0 ", null, null);
            if (query != null) {
                try {
                    count = query.getCount();
                } catch (Exception e) {
                    cursor = query;
                    if (cursor != null) {
                        return 0;
                    }
                    try {
                        cursor.close();
                        return 0;
                    } catch (Exception e2) {
                        return 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
                return count;
            }
            try {
                query.close();
                return count;
            } catch (Exception e4) {
                return count;
            }
        } catch (Exception e5) {
            cursor = null;
            if (cursor != null) {
                return 0;
            }
            cursor.close();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }
}
