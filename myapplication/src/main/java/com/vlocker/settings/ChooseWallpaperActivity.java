package com.vlocker.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.widget.Toast;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.h;
import java.io.File;

public class ChooseWallpaperActivity extends BaseBinderActivity {
    private File a = null;
    private File b = null;
    private boolean c = false;
    private a d;
    private int e = 0;

    private void a() {
        finish();
    }

    public static void a(Activity activity) {
        Intent intent = new Intent(activity, ChooseWallpaperActivity.class);
        intent.setFlags(67108864);
        activity.startActivityForResult(intent, 256);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        Throwable th;
        Cursor cursor = null;
        super.onActivityResult(i, i2, intent);
        if (i == 257) {
            if (i2 != -1 || intent == null) {
                a();
                return;
            }
            String type;
            if (this.a.exists()) {
                this.a.delete();
            }
            Uri data = intent.getData();
            String[] strArr = new String[]{"_data"};
            Cursor query;
            try {
                query = getContentResolver().query(data, strArr, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            cursor = query.getString(query.getColumnIndex(strArr[0]));
                        }
                    } catch (Exception e) {
                        if (query == null) {
                            str = null;
                        } else {
                            query.close();
                            str = null;
                        }
                        type = intent.getType();
                        str = data.getEncodedPath();
                        if (TextUtils.isEmpty(str)) {
                            finish();
                        }
                        try {
                            if (!new File(str).exists()) {
                                finish();
                                return;
                            }
                        } catch (Exception e2) {
                        }
                        CustomWallPaperActivity.a(this, str, this.a.getAbsolutePath(), 258);
                        return;
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                    str = cursor;
                } else {
                    Object obj = cursor;
                }
            } catch (Exception e3) {
                query = null;
                if (query == null) {
                    query.close();
                    str = null;
                } else {
                    str = null;
                }
                type = intent.getType();
                str = data.getEncodedPath();
                if (TextUtils.isEmpty(str)) {
                    finish();
                }
                if (new File(str).exists()) {
                    finish();
                    return;
                }
                CustomWallPaperActivity.a(this, str, this.a.getAbsolutePath(), 258);
                return;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            try {
                if (TextUtils.isEmpty(str) || str == null) {
                    type = intent.getType();
                    if (type != null && data.getScheme().equals("file") && type.contains("image/")) {
                        str = data.getEncodedPath();
                    }
                }
            } catch (Exception e4) {
            }
            if (TextUtils.isEmpty(str)) {
                if (new File(str).exists()) {
                    finish();
                    return;
                }
                CustomWallPaperActivity.a(this, str, this.a.getAbsolutePath(), 258);
                return;
            }
            finish();
        } else if (i == 258) {
            boolean z;
            if (this.a.exists()) {
                this.b.delete();
                this.a.renameTo(this.b);
                z = true;
            } else {
                z = false;
            }
            if (this.b.exists() && r0) {
                this.e = 2;
                setResult(-1);
                this.d.h(2);
                this.d.D(false);
                this.d.w(false);
                this.d.i(0);
                this.d.q(this.b.getAbsolutePath());
                if (!this.d.ag()) {
                    this.d.v(true);
                }
            }
            a();
        }
    }

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setResult(0);
        this.d = a.a((Context) this);
        this.c = getIntent().getBooleanExtra("extra_from_cover", false);
        try {
            startActivityForResult(new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI), 257);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        this.e = 1;
        Toast.makeText(this, R.string.wallpaper_toast_tips, 1).show();
        this.b = h.b(this);
        this.a = h.c(this);
        if (this.a == null || this.a == null) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
