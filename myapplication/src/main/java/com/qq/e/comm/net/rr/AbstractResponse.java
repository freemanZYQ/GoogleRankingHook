package com.qq.e.comm.net.rr;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;

public abstract class AbstractResponse implements Response {
    private final HttpResponse a;
    private final HttpUriRequest b;

    public AbstractResponse(HttpResponse httpResponse, HttpUriRequest httpUriRequest) {
        this.a = httpResponse;
        this.b = httpUriRequest;
    }

    public void close() {
        if (!(this.b == null || this.b.isAborted())) {
            this.b.abort();
        }
        if (this.a != null) {
            this.a.getEntity().getContent().close();
        }
    }

    public byte[] getBytesContent() {
        if (200 != getStatusCode()) {
            return null;
        }
        InputStream streamContent = getStreamContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = streamContent.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int getStatusCode() {
        return this.a.getStatusLine().getStatusCode();
    }

    public InputStream getStreamContent() {
        InputStream content = this.a.getEntity().getContent();
        Header contentEncoding = this.a.getEntity().getContentEncoding();
        return (contentEncoding == null || !contentEncoding.getValue().contains("gzip")) ? content : new GZIPInputStream(content);
    }

    public String getStringContent() {
        return getStringContent("UTF-8");
    }

    public String getStringContent(String str) {
        String str2 = null;
        byte[] bytesContent = getBytesContent();
        if (bytesContent == null) {
            return str2;
        }
        if (bytesContent.length == 0) {
            return "";
        }
        try {
            str2 = EntityUtils.getContentCharSet(this.a.getEntity());
        } catch (Throwable th) {
        }
        if (str2 != null) {
            str = str2;
        }
        return new String(bytesContent, str);
    }
}
