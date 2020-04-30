#include "HelloWorldJNI.h"
#include <iostream>

JNIEXPORT jint JNICALL Java_HelloWorldJNI_add(JNIEnv *env, jobject jobj, jint a, jint b)
{
    jclass myclass = env->FindClass("HelloWorldJNI");
    jobject myobj = env->AllocObject(myclass);
    jmethodID method = env->GetMethodID(myclass, "print", "()V");
    env->CallVoidMethod(myobj, method);
    int c = a + b;
    return c;
}
