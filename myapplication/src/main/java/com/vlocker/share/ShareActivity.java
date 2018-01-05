package com.vlocker.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import com.tencent.connect.c.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.b;
import com.tencent.tauth.c;
import com.vlocker.b.i;
import com.vlocker.b.p;
import com.vlocker.locker.R;
import com.vlocker.msg.as;
import com.vlocker.security.MoSecurityApplication;

public class ShareActivity extends Activity implements OnClickListener, OnItemClickListener {
    private IWXAPI a;
    private c b;
    private String c;
    private String d;
    private String e;
    private String f;
    private a g;
    private String h;
    private byte[] i;
    private GridView j;
    private b k = new c(this);

    private void a() {
        new Thread(new a(this)).start();
    }

    private void a(int i) {
        int i2 = 1;
        IMediaObject wXWebpageObject = new WXWebpageObject();
        if (!TextUtils.isEmpty(this.f)) {
            wXWebpageObject.webpageUrl = this.f;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        if (!TextUtils.isEmpty(this.c)) {
            wXMediaMessage.title = this.c;
        }
        if (!TextUtils.isEmpty(this.e)) {
            wXMediaMessage.description = this.e;
        }
        if (this.i != null) {
            wXMediaMessage.thumbData = this.i;
        } else {
            wXMediaMessage.setThumbImage(BitmapFactory.decodeResource(getResources(), R.drawable.main_icon));
        }
        BaseReq req = new Req();
        req.transaction = System.currentTimeMillis() + "";
        req.message = wXMediaMessage;
        if (i != 1) {
            i2 = 0;
        }
        req.scene = i2;
        this.a.sendReq(req);
    }

    private void a(String str) {
        new Thread(new b(this, str)).start();
    }

    private void b() {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", this.f);
            intent.addFlags(268435456);
            intent.setClassName("com.sina.weibo", "com.sina.weibo.composerinde.ComposerDispatchActivity");
            startActivity(intent);
        } catch (Exception e) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.TEXT", this.f);
            intent2.addFlags(268435456);
            intent2.setPackage("com.sina.weibo");
            startActivity(intent2);
            e.printStackTrace();
        }
    }

    private void b(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        if (TextUtils.isEmpty(this.c)) {
            bundle.putString("title", "微锁屏");
        } else {
            bundle.putString("title", this.c);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("summary", this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("targetUrl", this.f);
        }
        if (TextUtils.isEmpty(this.d)) {
            bundle.putString("imageLocalUrl", i.l + "main_icon.png");
        } else {
            bundle.putString("targetUrl", this.f);
        }
        if (i == 1) {
            bundle.putInt("cflag", 1);
        }
        this.g.a(this, bundle, this.k);
    }

    public void onClick(View view) {
        finish();
        overridePendingTransition(0, 0);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.l_activity_share);
        this.a = WXAPIFactory.createWXAPI(this, "wx450101efd07b59f1", true);
        this.a.registerApp("wx450101efd07b59f1");
        this.b = c.a("1103478279", MoSecurityApplication.a());
        this.g = new a(this, this.b.b());
        this.c = getIntent().getStringExtra("title");
        this.f = getIntent().getStringExtra("url");
        this.e = getIntent().getStringExtra("content");
        this.d = getIntent().getStringExtra("bmp");
        if (TextUtils.isEmpty(this.d)) {
            a();
        } else {
            a(this.d);
        }
        findViewById(R.id.mx_share_outside).setOnClickListener(this);
        this.h = getIntent().getStringExtra("from");
        this.j = (GridView) findViewById(R.id.mx_share_gridview);
        if ("webview".equals(this.h)) {
            this.j.setAdapter(new d(this, 1));
        } else {
            this.j.setAdapter(new d(this, 2));
        }
        this.j.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch ((int) j) {
            case 0:
                if ("hongbao".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Get_Hongbao_PPC_XXB", "ShareTo", "qzone");
                } else if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "qzone");
                }
                b(1);
                finish();
                overridePendingTransition(0, 0);
                return;
            case 1:
                if ("hongbao".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Get_Hongbao_PPC_XXB", "ShareTo", "wx_circle");
                } else if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "wx_circle");
                }
                a(1);
                finish();
                overridePendingTransition(0, 0);
                return;
            case 2:
                if ("hongbao".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Get_Hongbao_PPC_XXB", "ShareTo", "QQ");
                } else if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "QQ");
                }
                b(0);
                finish();
                overridePendingTransition(0, 0);
                return;
            case 3:
                if ("hongbao".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Get_Hongbao_PPC_XXB", "ShareTo", "wx");
                } else if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "wx");
                }
                a(0);
                finish();
                overridePendingTransition(0, 0);
                return;
            case 4:
                if ("hongbao".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Get_Hongbao_PPC_XXB", "ShareTo", "weibo");
                } else if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "weibo");
                }
                b();
                finish();
                overridePendingTransition(0, 0);
                return;
            case 5:
                if ("webview".equals(this.h)) {
                    p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "browser");
                }
                Intent a = as.a((Context) this, this.f);
                a.setFlags(268435456);
                startActivity(a);
                finish();
                overridePendingTransition(0, 0);
                return;
            case 6:
                try {
                    if ("webview".equals(this.h)) {
                        p.a((Context) this, "Vlocker_Share_Push_B_PPC_TF", "ShareTo", "copy");
                    }
                    ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.f));
                    Toast.makeText(this, "已复制到剪贴板", 1).show();
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            overridePendingTransition(0, 0);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
