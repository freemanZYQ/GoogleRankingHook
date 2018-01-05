package com.tencent.tauth;

import com.tencent.open.d.i;
import com.tencent.open.d.l;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public interface a {
    void a(i iVar);

    void a(l lVar);

    void a(IOException iOException);

    void a(Exception exception);

    void a(MalformedURLException malformedURLException);

    void a(SocketTimeoutException socketTimeoutException);

    void a(ConnectTimeoutException connectTimeoutException);

    void a(JSONException jSONException);

    void a(JSONObject jSONObject);
}
