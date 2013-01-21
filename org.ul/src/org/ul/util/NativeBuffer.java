package org.ul.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class NativeBuffer {
	private static Integer bufferNumber = 0;
	private static int bytesAllocated = 0;
	
	private boolean disposed = false;
	private final ByteBuffer byteBuffer;

	public NativeBuffer(int numBytes) {
		byteBuffer = allocByteBuffer(numBytes);
		byteBuffer.order(ByteOrder.nativeOrder());
		
		synchronized(bufferNumber) {
			bufferNumber++;
			bytesAllocated += numBytes;
		}
	}
	
	public void dispose() {
		if(!disposed) {
			disposed = true;
			freeByteBuffer(byteBuffer);
			
			synchronized(bufferNumber) {
				bufferNumber--;
				bytesAllocated -= byteBuffer.capacity();
			}
		}
	}
	
	public void flip() {byteBuffer.flip();}
	
	public int getPosition() {return byteBuffer.position();}
	public void setPosition(int position) {byteBuffer.position(position);}
	
	public int getLimit() {return byteBuffer.limit();}
	public void setLimit(int limit) {byteBuffer.limit(limit);}
	
	public int getCapacity() {return byteBuffer.capacity();}
	
	
	public byte getByte() {
		return byteBuffer.get();
	}
	
	public short getShort() {
		return byteBuffer.getShort(); 
	}
	
	public int getInt() {
		return byteBuffer.getInt();
	}
	
	public float getFloat() {
		return byteBuffer.getFloat();
	}
	
	public void putByte(byte ...values) {
		//byteBuffer.position(byteBuffer.position() + values.length);
		//copy(values, 0, byteBuffer, byteBuffer.position(), values.length);
		for(byte v: values)
			byteBuffer.put(v);
	}
	
	public void putShort(short ...values) {
		//byteBuffer.position(byteBuffer.position() + values.length*2);
		//copy(values, 0, byteBuffer, byteBuffer.position(), values.length);
		for(short v: values)
			byteBuffer.putShort(v);
	}
	
	public void putInt(int ...values) {
		//byteBuffer.position(byteBuffer.position() + values.length*4);
		//copy(values, 0, byteBuffer, byteBuffer.position(), values.length);
		for(int v: values)
			byteBuffer.putInt(v);
	}
	
	public void putFloat(float ...values) {
		//byteBuffer.position(byteBuffer.position() + values.length*4);
		//copy(values, 0, byteBuffer, byteBuffer.position(), values.length);
		for(float v: values)
			byteBuffer.putFloat(v);
	}
	

	public void clear() {
		clear(byteBuffer, byteBuffer.capacity());
		byteBuffer.clear();
	}
	
	public ByteBuffer asByteBuffer() {
		return byteBuffer;
	}
	
	public IntBuffer asIntBuffer() {
		return byteBuffer.asIntBuffer();
	}
	
	public FloatBuffer asFloatBuffer() {
		return byteBuffer.asFloatBuffer();
	}
	
	// @off
	/*JNI 
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>
	*/
	
	private static native void clear(ByteBuffer buffer, int numBytes); /*
		memset(buffer, 0, numBytes);
	*/
	
	private static native ByteBuffer allocByteBuffer(int numBytes); /*
		char* ptr = (char*)malloc(numBytes);
		return env->NewDirectByteBuffer(ptr, numBytes);
	*/

	private static native void freeByteBuffer(ByteBuffer buffer); /*
		free(buffer);
	*/

	private native static void copy(float[] src, ByteBuffer dst, int numFloats, int offset); /*
		memcpy(dst, src + offset, numFloats << 2 );
	*/

	private native static void copy(byte[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/

	private native static void copy(char[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/

	private native static void copy(short[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	 */

	private native static void copy(int[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/
	
	private native static void copy(long[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/

	private native static void copy(float[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/
	
	private native static void copy(double[] src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/

	private native static void copy(ByteBuffer src, int srcOffset, ByteBuffer dst, int dstOffset, int numBytes); /*
		memcpy(dst + dstOffset, src + srcOffset, numBytes);
	*/
}
