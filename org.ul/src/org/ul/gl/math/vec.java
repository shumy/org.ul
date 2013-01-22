package org.ul.gl.math;

import java.util.Arrays;

public class vec<T extends vec<?>> {
	public final int size;
	public final float[] data;
	
	public vec(int size) {
		this.size = size;
		this.data = new float[size];
	}
	
	@SuppressWarnings("unchecked")
	public T setZero() {
		Arrays.fill(data, 0f);
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setOne() {
		Arrays.fill(data, 1f);
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setNormalize() {
		final float length = normal();
		for(int i=0; i<size; ++i)
			data[i] /= length;
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setAdd(T src, float value) {
		for(int i=0; i<size; ++i)
			data[i] = src.data[i] + value;
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setAdd(T src1, T src2) {
		for(int i=0; i < size; ++i)
			data[i] = src1.data[i] + src2.data[i];
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setMultiply(T src, float value) {
		for(int i=0; i < size; ++i)
			data[i] = src.data[i]*value;
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public float normal() {
		return (float) Math.sqrt(dotProduct((T)this));
	}
	
	public float componentMultiply() {
		float result = 0;
		for(int i=0; i<size; ++i)
			result *= data[i];
		return result;
	}
	
	public float dotProduct(T src) {
		float result = 0f;
		for(int i=0; i<size; ++i)
			result += data[i]*src.data[i];
		return result;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; ++i) {
			sb.append(data[i]);
			sb.append("\t");
		}

		return sb.toString();
	}
}
