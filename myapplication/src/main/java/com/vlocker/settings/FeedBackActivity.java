package com.vlocker.settings;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.qq.e.comm.constants.ErrorCode.OtherError;
import com.vlocker.b.j;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.bd;
import com.vlocker.m.c;
import com.vlocker.m.h;
import com.vlocker.m.o;
import com.vlocker.m.q;
import com.vlocker.ui.widget.V2SettingHeaderBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedBackActivity extends BaseBinderActivity {
    public static boolean a = false;
    OnClickListener b = new ac(this);
    private V2SettingHeaderBar c;
    private Button d;
    private ImageView e;
    private ImageView f;
    private EditText g;
    private EditText h;
    private TextView i;
    private TextView j;
    private ProgressBar k;
    private File l = null;
    private String m = "";
    private boolean n;
    private Handler o = new ad(this);

    private Bitmap a(InputStream inputStream, int i) {
        byte[] b = b(inputStream);
        if (b != null) {
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                options.inSampleSize = 1;
                BitmapFactory.decodeByteArray(b, 0, b.length, options);
                int i2 = 1;
                while (true) {
                    if ((options.outWidth < options.outHeight ? options.outWidth : options.outHeight) > i) {
                        int i3 = i2 + 1;
                        options.inSampleSize = i3;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(b, 0, b.length, options);
                        i2 = i3;
                    } else {
                        options.inSampleSize = i2;
                        options.inJustDecodeBounds = false;
                        return BitmapFactory.decodeByteArray(b, 0, b.length, options);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void a(String str, String str2, String str3) {
        c.a(new ae(this, str, str2, str3));
    }

    private boolean a(InputStream inputStream) {
        FileOutputStream fileOutputStream;
        IOException e;
        Throwable th;
        boolean z = false;
        Bitmap a = a(inputStream, (int) OtherError.CONTAINER_INVISIBLE_ERROR);
        if (a != null) {
            if (this.l.exists()) {
                this.l.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                this.l.createNewFile();
                fileOutputStream = new FileOutputStream(this.l);
                try {
                    a.compress(CompressFormat.JPEG, 90, fileOutputStream);
                    z = true;
                    if (!(a == null || a.isRecycled())) {
                        a.recycle();
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        e2.printStackTrace();
                        if (!(a == null || a.isRecycled())) {
                            a.recycle();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (!(a == null || a.isRecycled())) {
                            a.recycle();
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e222 = e4;
                fileOutputStream = null;
                e222.printStackTrace();
                a.recycle();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                a.recycle();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return z;
    }

    private String b(String str, String str2, String str3) {
        File file;
        try {
            j();
            bd.a(h.a() + "err/", h.b());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map hashMap = new HashMap();
        hashMap.put("content", str);
        hashMap.put("contact", str2);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sysversion", VERSION.RELEASE);
        hashMap.put("cmversion", h.g(this));
        hashMap.put("uuid", h.e(this));
        hashMap.put("syslang", Locale.getDefault().getLanguage());
        hashMap.put("child", j.p(this));
        q[] qVarArr = new q[2];
        q qVar = new q();
        if (h.b() != null) {
            file = new File(h.b());
            if (file.length() > 2097152) {
                file = null;
            }
        } else {
            file = null;
        }
        if (file != null && file.exists()) {
            qVar.a(file);
        } else if (Environment.getExternalStorageDirectory() != null) {
            qVar.a(new File(o.a(), "/logs/0.log"));
        }
        qVar.a("log");
        if (qVar.a().exists() && qVar.a().length() > 0) {
            qVarArr[0] = qVar;
        }
        if (!TextUtils.isEmpty(str3)) {
            q qVar2 = new q();
            qVar2.a(new File(str3));
            qVar2.a("image");
            if (qVar2.a().exists() && qVar2.a().length() > 0) {
                qVarArr[1] = qVar2;
            }
        }
        return j.a(j.n(), hashMap, qVarArr);
    }

    private void b(String str) {
        if (this.o != null) {
            this.o.removeMessages(0);
        }
        this.k.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, getString(R.string.feedback_fail), 0).show();
            if (this.d != null) {
                this.d.setEnabled(true);
                return;
            }
            return;
        }
        try {
            int i = new JSONObject(str).getInt("code");
            if (i == 0 || i == 200) {
                Toast.makeText(this, getString(R.string.feedback_success), 0).show();
                a();
                finish();
                return;
            }
            Toast.makeText(this, getString(R.string.feedback_fail), 0).show();
            if (this.d != null) {
                this.d.setEnabled(true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private byte[] b(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr, 0, IXAdIOUtils.BUFFER_SIZE);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void c() {
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("fromweather", false)) {
            this.n = true;
        }
    }

    private void d() {
        this.c = (V2SettingHeaderBar) findViewById(R.id.settings_head_bar);
        this.c.setTitle(getString(R.string.setting_feedback_txt));
        this.c.setBackOnClickListener(new aa(this));
        this.d = (Button) findViewById(R.id.btn_commit);
        this.e = (ImageView) findViewById(R.id.add_image);
        this.f = (ImageView) findViewById(R.id.delete_img);
        this.g = (EditText) findViewById(R.id.edit_des);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        this.h = (EditText) findViewById(R.id.edit_connect);
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.j = (TextView) findViewById(R.id.tv_feedback_question);
        this.j.setText(getString(R.string.feedback_normal_question) + " 〉");
        this.j.setOnClickListener(this.b);
        this.d.setOnClickListener(this.b);
        this.e.setOnClickListener(this.b);
        this.f.setOnClickListener(this.b);
        this.i = (TextView) findViewById(R.id.join_qq_group_number);
        if (this.n) {
            this.i.setText(getString(R.string.v2_weather_feedback_qqgroup_number));
            this.i.getPaint().setUnderlineText(true);
        }
        this.i.setOnClickListener(this.b);
        this.g.addTextChangedListener(new ab(this));
        if (!TextUtils.isEmpty(a.a((Context) this).A())) {
            this.h.setText(a.a((Context) this).A());
        }
    }

    private void e() {
        if (this.l.exists()) {
            this.l.delete();
        }
        this.f.setVisibility(8);
        this.e.setImageDrawable(null);
        this.e.setClickable(true);
    }

    private void f() {
        if (TextUtils.isEmpty(this.g.getEditableText().toString())) {
            g();
        } else if (TextUtils.isEmpty(this.h.getEditableText().toString())) {
            h();
        } else {
            i();
        }
    }

    private void g() {
        Toast.makeText(this, getString(R.string.feedback_no_content), 0).show();
    }

    private void h() {
        this.h.requestFocus();
        Toast.makeText(this, getString(R.string.feedback_no_contact), 0).show();
    }

    private void i() {
        this.o.removeMessages(0);
        this.o.sendEmptyMessageDelayed(0, 39000);
        this.k.setVisibility(0);
        String obj = this.g.getText().toString();
        String obj2 = this.h.getText().toString();
        a.a((Context) this).g(obj2);
        if (this.n) {
            obj = getResources().getString(R.string.moxiu_weather_feedback) + "：" + obj;
        }
        a(obj, obj2, this.l.getAbsolutePath());
        if (this.d != null) {
            this.d.setEnabled(false);
        }
    }

    private void j() {
        if (h.b() != null) {
            File file = new File(h.b());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public void a() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 2);
                }
            }
        }
    }

    public boolean a(String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D" + str));
        try {
            startActivity(intent);
            return true;
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.qq_group_faild_hint), 1).show();
            return false;
        }
    }

    protected void b() {
        Log.i("kevint", "qq group number==" + getString(R.string.v2_setting_feedback_qqgroup_number));
        String str = "BUww-FixB4FgxwiNpPghQU7tG9YsziBv";
        if (this.n) {
            str = "pKgeJhBWr6DDeywnATUqQpR1-gtzsY-J";
        }
        a(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && intent.getData() != null) {
            try {
                if (a(getContentResolver().openInputStream(intent.getData()))) {
                    Bitmap a = a(new FileInputStream(this.l), 200);
                    if (a != null) {
                        this.e.setImageBitmap(a);
                        this.e.setClickable(false);
                        this.f.setVisibility(0);
                        return;
                    }
                    return;
                }
                Toast.makeText(this, getString(R.string.feedback_load_image_fail), 0).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, getString(R.string.feedback_load_image_fail), 0).show();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.l = new File(getCacheDir(), "cm_feedback_tmp.jpg");
        if (this.l.exists()) {
            this.l.delete();
        }
        setContentView(R.layout.l_fragment_feedback);
        c();
        d();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.setText(getResources().getString(R.string.v2_setting_feedback_qqgroup_number));
            this.n = false;
        }
        if (this.l.exists()) {
            this.l.delete();
        }
    }

    protected void onPause() {
        super.onPause();
    }
}
