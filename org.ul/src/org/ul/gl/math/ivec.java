package org.ul.gl.math;

import java.util.Arrays;

public class ivec<T extends ivec<?>> {
	public final int size;
	public final int[] data;
	
	public ivec(int size) {
		this.size = size;
		this.data = new int[size];
	}
	
	@SuppressWarnings("unchecked")
	public T setZero() {
		Arrays.fill(data, 0);
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setOne() {
		Arrays.fill(data, 1);
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setAdd(T src, int value) {
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
	public T setMultiply(T src, int value) {
		for(int i=0; i < size; ++i)
			data[i] = src.data[i]*value;
		return (T)this;
	}
	
	public int componentMultiply() {
		int result = 0;
		for(int i=0; i<size; ++i)
			result *= data[i];
		return result;
	}
		
	public int dotProduct(T src) {
		int result = 0;
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
