package com.google.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

/**
 * Created by apple on 16/10/5.
 */
public class Cache {

    private static final int CACHE_MAGIC = 0x20140623;

    public int size;
    private Entry mEntry;

    public int getEntryLength() {
        return size;
    }

    public Entry getEntry() {
        return this.mEntry;
    }

    public void setEntry(Entry entry) {
        mEntry = entry;
    }

    public static class Entry {

        public String mEtag;
        public long mServerDate;
        /**
         * The data returned from cache.
         */
        public byte[] data;
        public Map<String, String> responseHeaders = Collections.emptyMap();
        private String mKey;

        /**
         * @param is
         * @return
         * @throws IOException
         */
        public static Entry readMagic(InputStream is) throws IOException {
            Entry mEntry = new Entry();
            int magic = ByteUtils.readInt(is);
            String key = ByteUtils.readString(is);
            String etag = ByteUtils.readString(is);
            long serverDate = ByteUtils.readLong(is);
            if (magic != CACHE_MAGIC) {
                // don't bother deleting, it'll get pruned eventually
                throw new IOException();
            }
            mEntry.mKey = key;
            mEntry.mEtag = etag;
            mEntry.mServerDate = serverDate;
            mEntry.responseHeaders = ByteUtils.readStringStringMap(is);
            return mEntry;
        }

        public String getKey() {
            return mKey;
        }

        public void setKey(String key) {
            mKey = key;
        }

        public byte[] get() {
            if (data != null) {
                return data;
            }
            return null;
        }

        /**
         * Writes the contents of this CacheHeader to the specified OutputStream.
         */
        public boolean writeMagic(OutputStream os) {
            try {
                ByteUtils.writeInt(os, CACHE_MAGIC);
                ByteUtils.writeString(os, mKey == null ? "" : mKey);
                ByteUtils.writeString(os, mEtag == null ? "" : mEtag);
                ByteUtils.writeLong(os, mServerDate);
                ByteUtils.writeStringStringMap(responseHeaders, os);
                os.flush();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

    }
}
