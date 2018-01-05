package com.qq.e.comm.net.rr;

import com.qq.e.comm.net.rr.a.b;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

public class S2SSResponse extends AbstractResponse {
    public S2SSResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        super(httpResponse, httpUriRequest);
    }

    public byte[] getBytesContent() {
        try {
            return a.b(super.getBytesContent());
        } catch (b e) {
            e.printStackTrace();
            return null;
        }
    }
}
