package com.vlocker.new_theme.a;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class h extends HttpEntityWrapper {
    public h(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }
}
