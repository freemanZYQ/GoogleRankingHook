package com.qq.e.comm.net.rr;

import java.io.InputStream;

public interface Response {
    void close();

    byte[] getBytesContent();

    int getStatusCode();

    InputStream getStreamContent();

    String getStringContent();

    String getStringContent(String str);
}
