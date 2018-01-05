package com.tools.hackandroid.gp;

import android.content.Intent;

/**
 * Created by bintou on 16/8/8.
 */
public class GoogleLoginServiceConstants {

    public static final String ACCOUNTS_KEY = "accounts";
    public static final String ACCOUNT_TYPE = "com.google";
    public static final String AUTHTOKEN_KEY = "authtoken";
    public static final String AUTH_ACCOUNT_KEY = "authAccount";
    public static final int ERROR_CODE_GLS_NOT_FOUND = 0;
    public static final int ERROR_CODE_GLS_VERIFICATION_FAILED = 1;
    public static final String ERROR_CODE_KEY = "errorCode";
    public static final String FEATURE_GOOGLE = "google";
    public static final String FEATURE_HOSTED_OR_GOOGLE = "hosted_or_google";
    public static final String FEATURE_LEGACY_GOOGLE = "legacy_google";
    public static final String FEATURE_LEGACY_HOSTED_OR_GOOGLE = "legacy_hosted_or_google";
    public static final String FEATURE_SAML_ACCOUNT = "saml";
    public static final String FEATURE_SERVICE_PREFIX = "service_";
    public static final String FEATURE_YOUTUBE = "youtubelinked";
    public static final int FLAG_GOOGLE_ACCOUNT = 1;
    public static final int FLAG_HOSTED_ACCOUNT = 2;
    public static final int FLAG_LEGACY_GOOGLE = 16;
    public static final int FLAG_LEGACY_HOSTED_OR_GOOGLE = 32;
    public static final int FLAG_SAML_ACCOUNT = 8;
    public static final int FLAG_YOUTUBE_ACCOUNT = 4;
    public static final String FULLY_QUALIFIED_SERVICE_NAME = "com.google.android.googleapps.GoogleLoginService";
    public static final String LOGIN_ACCOUNTS_MISSING_ACTION = "com.google.android.googlelogin.LOGIN_ACCOUNTS_MISSING";
    public static final boolean PREFER_HOSTED = false;
    public static final String REQUEST_EXTRAS = "callerExtras";
    public static final boolean REQUIRE_GOOGLE = true;
    public static final String SERVICE_PACKAGE_NAME = "com.google.android.googleapps";
    public static final Intent SERVICE_INTENT = new Intent().setClassName(SERVICE_PACKAGE_NAME, FULLY_QUALIFIED_SERVICE_NAME);
    public static final String SERVICE_NAME = "GoogleLoginService";

    public static final String YOUTUBE_USER_KEY = "YouTubeUser";

    private GoogleLoginServiceConstants() {
    }

    static String getErrorCodeMessage(int errorCode) {
        switch (errorCode) {
            case ERROR_CODE_GLS_NOT_FOUND /*0*/:
                return "The Google login service cannot be found.";
            case 1:
                return "The Google login service cannot be verified.";
            default:
                return "Unknown error";
        }
    }

    public static String featureForService(String service) {
        return FEATURE_SERVICE_PREFIX + service;
    }
}
