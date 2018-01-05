package com.xinmei365.fontsdk.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;
import com.xinmei365.fontsdk.bean.FailureInfo;
import com.xinmei365.fontsdk.bean.Font;
import com.xinmei365.fontsdk.c.c;
import com.xinmei365.fontsdk.c.e;
import com.xinmei365.fontsdk.c.f;
import com.xinmei365.fontsdk.callback.FontTypefaceCallBack;
import com.xinmei365.fontsdk.callback.IHttpCallBack;
import com.xinmei365.fontsdk.download.DownloadInfo;
import com.xinmei365.fontsdk.download.DownloadListener;
import com.xinmei365.fontsdk.download.b;
import com.xinmei365.fontsdk.download.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.regex.Pattern;

public class a {
    private static Handler handler = new Handler();
    private TextView J;
    private TextWatcher K;
    private Timer L;
    private boolean M;
    private String N;
    private String O;
    private Context context;
    private String fontIdNo;

    public a(Context context) {
        this.context = context;
    }

    private static boolean a(char c) {
        return c == '\u0000' || c == '\t' || c == '\n' || c == '\r' || ((c >= ' ' && c <= '퟿') || ((c >= '' && c <= '�') || c >= '\u0000'));
    }

    private String b(String str, String str2) {
        String str3 = (com.xinmei365.fontsdk.c.a.au + f.A(com.xinmei365.fontsdk.a.e)) + "/" + str + "/" + f.A(str + str2);
        return new File(str3).exists() ? str3 : null;
    }

    private void l(String str) {
        final String charSequence = this.J.getText().toString();
        if (str.equals(charSequence)) {
            getCloudTypeface(this.fontIdNo, charSequence, new FontTypefaceCallBack(this) {
                final /* synthetic */ a S;

                public void onFailure(FailureInfo failureInfo) {
                    if (failureInfo != null) {
                        e.c(failureInfo.toString());
                    }
                }

                public void onSuccess(String str, Typeface typeface) {
                    if (charSequence.equals(this.S.J.getText().toString())) {
                        this.S.J.setTypeface(typeface);
                    } else {
                        this.S.o();
                    }
                }
            });
        } else {
            o();
        }
    }

    public static boolean m(String str) {
        String replaceAll = str.replaceAll(" ", "").replaceAll("\n", "");
        int length = replaceAll.length();
        for (int i = 0; i < length; i++) {
            if (a(replaceAll.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void o() {
        if (this.M) {
            final String charSequence = this.J.getText().toString();
            handler.postDelayed(new Runnable(this) {
                final /* synthetic */ a S;

                public void run() {
                    this.S.l(charSequence);
                }
            }, 500);
        }
    }

    public void a(IHttpCallBack iHttpCallBack, String str, String str2) {
        com.xinmei365.fontsdk.b.e eVar = new com.xinmei365.fontsdk.b.e(this.context, String.format("http://api.yun.galaxyfont.com/index/min_ttf?appKey=%s&fontIdNo=%s&str=%s&type=%s", new Object[]{com.xinmei365.fontsdk.a.e, str, str2, "1"}));
        eVar.a(iHttpCallBack);
        eVar.z();
    }

    public void a(String str, TextView textView) {
        this.J = textView;
        this.fontIdNo = str;
        this.M = true;
        if (textView != null && str != null) {
            l(textView.getText().toString());
            if (this.L == null) {
                this.L = new Timer();
            }
            if (this.K == null) {
                this.K = new TextWatcher(this) {
                    final /* synthetic */ a S;

                    {
                        this.S = r1;
                    }

                    public void afterTextChanged(Editable editable) {
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (i3 > 0) {
                            this.S.o();
                        }
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }
                };
            }
            textView.addTextChangedListener(this.K);
        }
    }

    public void a(String str, String str2, String str3, FontTypefaceCallBack fontTypefaceCallBack, boolean z) {
        b a = b.a(this.context, new com.xinmei365.fontsdk.download.b.a("colored_font", 20));
        final String str4 = (com.xinmei365.fontsdk.c.a.au + f.A(com.xinmei365.fontsdk.a.e)) + "/" + str2 + "/" + f.A(str2 + str3);
        d a2 = a.a(str, str4);
        final boolean z2 = z;
        final String str5 = str2;
        final String str6 = str3;
        final FontTypefaceCallBack fontTypefaceCallBack2 = fontTypefaceCallBack;
        a2.b(new DownloadListener(this) {
            final /* synthetic */ a S;

            public void canceled(DownloadInfo downloadInfo) {
            }

            public void failed(DownloadInfo downloadInfo, int i) {
                if (z2) {
                    this.S.a(new IHttpCallBack(this) {
                        final /* synthetic */ AnonymousClass6 Y;

                        {
                            this.Y = r1;
                        }

                        public void o(String str) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.Y.S.a(str, str5, str6, fontTypefaceCallBack2, false);
                        }

                        public void onErr(int i, String str) {
                            fontTypefaceCallBack2.onFailure(new FailureInfo(i, str));
                        }

                        public /* synthetic */ void onSuccess(Object obj) {
                            o((String) obj);
                        }
                    }, str5, str6);
                } else {
                    fontTypefaceCallBack2.onFailure(new FailureInfo(i, com.xinmei365.fontsdk.download.a.b.valueOf(i)));
                }
            }

            public void paused(DownloadInfo downloadInfo) {
            }

            public void prepared(DownloadInfo downloadInfo) {
            }

            public void processing(DownloadInfo downloadInfo) {
            }

            public void successed(DownloadInfo downloadInfo) {
                Typeface typeface = null;
                File file = new File(str4);
                if (file.exists()) {
                    try {
                        typeface = Typeface.createFromFile(file);
                    } catch (Exception e) {
                    }
                }
                if (typeface != null) {
                    fontTypefaceCallBack2.onSuccess(str5, typeface);
                    e.v(str5);
                } else if (z2) {
                    this.S.a(new IHttpCallBack(this) {
                        final /* synthetic */ AnonymousClass6 Y;

                        {
                            this.Y = r1;
                        }

                        public void o(String str) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            this.Y.S.a(str, str5, str6, fontTypefaceCallBack2, false);
                        }

                        public void onErr(int i, String str) {
                            fontTypefaceCallBack2.onFailure(new FailureInfo(i, str));
                        }

                        public /* synthetic */ void onSuccess(Object obj) {
                            o((String) obj);
                        }
                    }, str5, str6);
                } else {
                    fontTypefaceCallBack2.onFailure(new FailureInfo(FailureInfo.ERROR_DOWNLOAD_FAILURE, "download the font failed,& Font not found " + file.getAbsolutePath()));
                }
            }

            public void waited(DownloadInfo downloadInfo) {
            }
        });
        a.a(a2);
    }

    public boolean cleanCloudCache() {
        return !new File(com.xinmei365.fontsdk.c.a.au).exists() ? true : c.z(com.xinmei365.fontsdk.c.a.au);
    }

    public long getCloudCacheSize() {
        File file = new File(com.xinmei365.fontsdk.c.a.au);
        return !file.exists() ? 0 : file.length();
    }

    public void getCloudTypeface(final Font font, final String str, final FontTypefaceCallBack fontTypefaceCallBack) {
        if (font == null || str == null) {
            fontTypefaceCallBack.onFailure(new FailureInfo(1006, FailureInfo.valueOf(1006) + "font or text  can not be null"));
        } else if (font.getFontFromType() != 0) {
            fontTypefaceCallBack.onFailure(new FailureInfo(1006, "This font is not supported cloud"));
        } else if (!font.isLocalFont() || font.getFontLocalPath() == null) {
            getCloudTypeface(font.getFontIdNo(), str, fontTypefaceCallBack);
        } else {
            new AsyncTask(this) {
                final /* synthetic */ a S;

                protected void a(Typeface typeface) {
                    if (typeface != null) {
                        fontTypefaceCallBack.onSuccess(font.getFontIdNo(), typeface);
                    } else {
                        this.S.getCloudTypeface(font.getFontIdNo(), str, fontTypefaceCallBack);
                    }
                }

                protected Typeface b(Void... voidArr) {
                    return com.xinmei365.fontsdk.a.c(font.getFontLocalPath());
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return b((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    a((Typeface) obj);
                }
            }.execute(new Void[0]);
        }
    }

    public void getCloudTypeface(final String str, String str2, final FontTypefaceCallBack fontTypefaceCallBack) {
        if (fontTypefaceCallBack == null || str == null || str2 == null) {
            if (fontTypefaceCallBack != null) {
                fontTypefaceCallBack.onFailure(new FailureInfo(1006, FailureInfo.valueOf(1006)));
            } else {
                Log.e("FontCenter", "callBack can't be null");
            }
        } else if (!n(str)) {
            fontTypefaceCallBack.onFailure(new FailureInfo(1006, FailureInfo.valueOf(1006)));
        } else if (m(str2)) {
            fontTypefaceCallBack.onSuccess(str, Typeface.DEFAULT);
        } else {
            if (!this.M) {
                e.u(str);
            }
            try {
                this.N = str2;
                this.O = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            new AsyncTask(this) {
                final /* synthetic */ a S;

                protected void a(Typeface typeface) {
                    if (typeface != null) {
                        fontTypefaceCallBack.onSuccess(str, typeface);
                        e.w(str);
                        return;
                    }
                    String A = f.A(str + this.S.N);
                    this.S.a(String.format("http://cdn.yun.galaxyfont.com/xmht_android_fonts/%s/%s/%s/%s/%s/%s/%s.ttf", new Object[]{com.xinmei365.fontsdk.a.e, str, A.substring(0, 2), A.substring(2, 4), A.substring(4, 6), A.substring(6, 8), A.substring(8, A.length())}), str, this.S.O, fontTypefaceCallBack, true);
                }

                protected Typeface b(Void... voidArr) {
                    Typeface typeface = null;
                    String a = this.S.b(str, this.S.O);
                    if (!TextUtils.isEmpty(a) && new File(a).exists()) {
                        try {
                            typeface = com.xinmei365.fontsdk.a.c(a);
                        } catch (Exception e) {
                        }
                    }
                    return typeface;
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return b((Void[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    a((Typeface) obj);
                }
            }.execute(new Void[0]);
        }
    }

    public void k(String str) {
        if (str != null) {
            this.fontIdNo = str;
            o();
        }
    }

    public boolean n(String str) {
        return (str == null || str.isEmpty() || str.length() != 8) ? false : Pattern.compile("[A-Za-z0-9]+").matcher(str).matches();
    }

    public void setAutoCloudFont(Font font) {
        if (font != null) {
            this.fontIdNo = font.getFontIdNo();
            k(this.fontIdNo);
        }
    }

    public void setAutoCloudTextView(TextView textView) {
        this.J = textView;
    }

    public void startAutoCloudText(Font font, TextView textView) {
        if (font != null && textView != null) {
            this.J = textView;
            this.fontIdNo = font.getFontIdNo();
            a(font.getFontIdNo(), textView);
        }
    }

    public void stopAutoCloudText() {
        this.M = false;
        if (this.L != null) {
            if (this.J != null) {
                this.J.removeTextChangedListener(this.K);
            }
            this.L.cancel();
            this.L = null;
        }
    }
}
