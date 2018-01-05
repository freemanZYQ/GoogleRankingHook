package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import com.tencent.open.a.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class a {
    protected HashMap a = new HashMap();

    public void a(c cVar, String str) {
        this.a.put(str, cVar);
    }

    public void a(String str, String str2, List list, b bVar) {
        j.a("openSDK_LOG.JsBridge", "getResult---objName = " + str + " methodName = " + str2);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        c cVar = (c) this.a.get(str);
        if (cVar != null) {
            j.b("openSDK_LOG.JsBridge", "call----");
            cVar.call(str2, list, bVar);
            return;
        }
        j.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (bVar != null) {
            bVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        j.a("openSDK_LOG.JsBridge", "-->canHandleUrl---url = " + str);
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList((str + "/#").split("/")));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List subList = arrayList.subList(4, arrayList.size() - 1);
        b bVar = new b(webView, 4, str);
        webView.getUrl();
        a(str2, str3, subList, bVar);
        return true;
    }
}
