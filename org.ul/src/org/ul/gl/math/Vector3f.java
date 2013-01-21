package org.ul.gl.math;

import java.util.Arrays;

public class Vector3f {
	public final int size = 3;
	public final float[] data;
	
	public Vector3f() {
		data = new float[size];
	}
	
	public Vector3f(float x, float y, float z) {
		this();
		set(x, y, z);
	}
	
	public float l2Norm() {
		return (float) Math.sqrt(data[0]*data[0] + data[1]*data[1] + data[2]*data[2]);
	}
	
	public float dotProduct(Vector3f value) {
		float result = 0;
		for(int i=0; i < size; ++i)
			result += data[i]*value.data[i];
		return result;
	}
	
	public Vector3f set(float x, float y, float z) {
		data[0] = x;
		data[1] = y;
		data[2] = z;
		return this;
	}
	
	public Vector3f setZero() {
		Arrays.fill(data, 0f);
		return this;
	}
	
	public Vector3f setOne() {
		Arrays.fill(data, 1f);
		return this;
	}
	
	public Vector3f setNormalize() {
		final float length = l2Norm();
		data[0] /= length;
		data[1] /= length;
		data[2] /= length;
		return this;
	}
	
	// z < xXy
	public Vector3f setCrossProduct(Vector3f x, Vector3f y) {
		data[0] = x.data[1]*y.data[2] -  x.data[2]*y.data[1];
		data[1] = x.data[2]*y.data[0] -  x.data[0]*y.data[2];
		data[2] = x.data[0]*y.data[1] -  x.data[1]*y.data[0];
		return this;
	}

	public Vector3f setAdd(Vector3f src, float value) {
		for(int i=0; i<size; ++i)
			data[i] = src.data[i] + value;
		return this;
	}
	
	public Vector3f setAdd(Vector3f src1, Vector3f src2) {
		for(int i=0; i < size; ++i)
			data[i] = src1.data[i] + src2.data[i];
		return this;
	}
	
	public Vector3f setMultiply(Vector3f src, float value) {
		for(int i=0; i < size; ++i)
			data[i] = src.data[i]*value;
		return this;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; ++i) {
			sb.append(data[i]);
			sb.append("\t\t");
		}
		sb.append("\n");

		return sb.toString();
	}
}
