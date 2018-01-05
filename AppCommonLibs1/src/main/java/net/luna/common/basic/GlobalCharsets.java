package net.luna.common.basic;

import net.luna.common.util.StringUtils;

import java.io.UnsupportedEncodingException;

public class GlobalCharsets {

    /**
     * 8 位 UCS 转换格式
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
     */
    public static final String UTF_16 = "UTF-16";
    /**
     * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /**
     * 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
     */
    public static final String US_ASCII = "US-ASCII";
    /**
     * 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序
     */
    public static final String UTF_16BE = "UTF-16BE";
    /**
     * 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序
     */
    public static final String UTF_16LE = "UTF-16LE";
    /**
     * 中文超大字符集
     */
    public static final String GBK = "GBK";

    /**
     * 文件前缀
     */
    public static final String FILE_PREFIX = "file://";


    /**
     * 改变编码字符集
     *
     * @author zhitaocai
     * @since 2014-05-22
     */
    public static class Change {

        public static String toUTF_8(String str) throws UnsupportedEncodingException {
            return changeCharset(str, UTF_8);
        }

        public static String toUTF_8(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, UTF_8);
        }

        public static String toUTF_16(String str) throws UnsupportedEncodingException {
            return changeCharset(str, UTF_16);
        }

        public static String toUTF_16(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, UTF_16);
        }

        public static String toISO_8859_1(String str) throws UnsupportedEncodingException {
            return changeCharset(str, ISO_8859_1);
        }

        public static String toISO_8859_1(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, ISO_8859_1);
        }

        public static String toASCII(String str) throws UnsupportedEncodingException {
            return changeCharset(str, US_ASCII);
        }

        public static String toASCII(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, US_ASCII);
        }

        public static String toUTF_16BE(String str) throws UnsupportedEncodingException {
            return changeCharset(str, UTF_16BE);
        }

        public static String toUTF_16BE(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, UTF_16BE);
        }

        public static String toUTF_16LE(String str) throws UnsupportedEncodingException {
            return changeCharset(str, UTF_16LE);
        }

        public static String toUTF_16LE(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, UTF_16LE);
        }

        public static String toGBK(String str) throws UnsupportedEncodingException {
            return changeCharset(str, GBK);
        }

        public static String toGBK(byte[] input) throws UnsupportedEncodingException {
            return changeCharset(input, GBK);
        }

        /**
         * 将字符串编码转换为指定的编码方式
         *
         * @param str        待转换编码的字符串
         * @param newCharset 目标编码
         * @return
         * @throws UnsupportedEncodingException
         */
        public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
            return changeCharset(str, null, newCharset);
        }

        /**
         * 将字符串编码转换为指定的编码方式
         *
         * @param str        待转换编码的字符串
         * @param oldCharset 原编码
         * @param newCharset 目标编码
         * @return 新编码后的字符串或者null
         * @throws UnsupportedEncodingException
         */
        public static String changeCharset(String str, String oldCharset, String newCharset)
                throws UnsupportedEncodingException {
            if (!StringUtils.isBlank(str)) {
                if (StringUtils.isBlank(newCharset)) {
                    return null;
                }
                byte[] bs;
                if (!StringUtils.isBlank(oldCharset)) {
                    bs = str.getBytes(oldCharset); // 用旧的字符编码解码字符串。解码可能会出现异常。
                } else {
                    bs = str.getBytes(); // 用默认字符编码解码字符串。
                }
                return changeCharset(bs, newCharset); // 用新的字符编码生成字符串
            }
            return null;
        }

        /**
         * 将字节数组转换为指定编码的字符串
         *
         * @param newCharset
         * @return
         * @throws UnsupportedEncodingException
         */
        public static String changeCharset(byte[] input, String newCharset) throws UnsupportedEncodingException {
            if (input == null) {
                return null;
            }
            if (StringUtils.isBlank(newCharset)) {
                return null;
            }
            return new String(input, newCharset);
        }

    }
}
