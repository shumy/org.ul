#include <org.ul.util.NativeBuffer.h>

//@line:84
 
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_clear(JNIEnv* env, jclass clazz, jobject obj_buffer, jint numBytes) {
	char* buffer = (char*)env->GetDirectBufferAddress(obj_buffer);


//@line:90

		memset(buffer, 0, numBytes);
	

}

JNIEXPORT jobject JNICALL Java_org_ul_util_NativeBuffer_allocByteBuffer(JNIEnv* env, jclass clazz, jint numBytes) {


//@line:94

		char* ptr = (char*)malloc(numBytes);
		return env->NewDirectByteBuffer(ptr, numBytes);
	

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_freeByteBuffer(JNIEnv* env, jclass clazz, jobject obj_buffer) {
	char* buffer = (char*)env->GetDirectBufferAddress(obj_buffer);


//@line:99

		free(buffer);
	

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3FLjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jfloatArray obj_src, jobject obj_dst, jint numFloats, jint offset) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	float* src = (float*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:103

		memcpy(dst, src + offset, numFloats << 2 );
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3BILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jbyteArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	char* src = (char*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:107

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3CILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jcharArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	unsigned short* src = (unsigned short*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:111

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3SILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jshortArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	short* src = (short*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:115

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	 
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3IILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jintArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	int* src = (int*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:119

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3JILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jlongArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	long long* src = (long long*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:123

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3FILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jfloatArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	float* src = (float*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:127

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy___3DILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jdoubleArray obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);
	double* src = (double*)env->GetPrimitiveArrayCritical(obj_src, 0);


//@line:131

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	
	env->ReleasePrimitiveArrayCritical(obj_src, src, 0);

}

JNIEXPORT void JNICALL Java_org_ul_util_NativeBuffer_copy__Ljava_nio_ByteBuffer_2ILjava_nio_ByteBuffer_2II(JNIEnv* env, jclass clazz, jobject obj_src, jint srcOffset, jobject obj_dst, jint dstOffset, jint numBytes) {
	char* src = (char*)env->GetDirectBufferAddress(obj_src);
	char* dst = (char*)env->GetDirectBufferAddress(obj_dst);


//@line:135

		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	

}

