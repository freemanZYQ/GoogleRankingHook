package net.luna.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * Utility functions related to IP Addresses.
 *
 * @author Andres N. Kievsky
 */
public class InetAddressUtils {
    /*
     * Do not allow instantiation
     */
    private InetAddressUtils() {
    }

    /**
     * Given an ip in a numeric, string format, return the InetAddress.
     *
     * @param ip the ip address in string format (such as 3232235780)
     * @return the InetAddress object (such as the object representing 192.168.1.4)
     */
    public static InetAddress parseNumericIp(String ip) {
        return parseNumericIp(Long.parseLong(ip));
    }

    /**
     * Given an ip in numeric format, return the InetAddress.
     *
     * @param ip the ip address in long (such as 3232235780)
     * @return the InetAddress object (such as the object representing 192.168.1.4)
     */
    public static InetAddress parseNumericIp(long ip) {
        try {
            return InetAddress.getByAddress(numericIpToByteArray(ip));
        } catch (UnknownHostException e) {
            return null;
        }
    }

    /**
     * Given an ip in numeric format, return a byte array that can be fed to
     * InetAddress.
     *
     * @param ip the ip address in long (such as 3232235780)
     * @return the byte array.
     */
    public static byte[] numericIpToByteArray(long ip) {
        byte[] ipArray = new byte[4];
        ipArray[3] = (byte) (ip & 0xff);
        ipArray[2] = (byte) ((ip >> 8) & 0xff);
        ipArray[1] = (byte) ((ip >> 16) & 0xff);
        ipArray[0] = (byte) ((ip >> 24) & 0xff);
        return ipArray;
    }

    private static final Pattern IPV4_PATTERN =
            Pattern.compile(
                    "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    private static final Pattern IPV6_STD_PATTERN =
            Pattern.compile(
                    "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN =
            Pattern.compile(
                    "^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    public static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    public static boolean isIPv6Address(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input);
    }


}