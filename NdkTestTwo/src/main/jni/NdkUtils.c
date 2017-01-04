#include "com_ndk_test_two_NdkUtils.h"
JNIEXPORT jstring JNICALL Java_com_ndk_test_two_NdkUtils_getResult
  (JNIEnv *env, jobject object, jstring input){
    return (*env)->NewStringUTF(env,"This just a test for Android Studio NDK JNI developer!");
}

