package org.ul.gl.math;

import java.util.Arrays;

public class mat<T extends mat<?>> {
	public final int diagonalSize;
	public final int size;
	public final float[] data;
	
	public mat(int diagonalSize) {
		this.diagonalSize = diagonalSize;
		size = diagonalSize * diagonalSize;
		data = new float[size];
		
		for(int i=0; i<size; i+=diagonalSize+1)
			data[i] = 1f;
	}
	
	public float get(int column, int row) {
		return data[column*diagonalSize + row];
	}
	
	@SuppressWarnings("unchecked")
	public T set(int column, int row, float value) {
		data[column*diagonalSize + row] = value;
		return (T)this;
	}
	
	/** Reset matrix to zeros.
	 * @return Itself for convenience. 
	 */
	@SuppressWarnings("unchecked")
	public T setZero() {
		Arrays.fill(data, 0f);
		return (T)this;
	}
	
	/** Reset to identity matrix.
	 * @return Itself for convenience. 
	 */
	@SuppressWarnings("unchecked")
	public T setIdentity() {
		setZero();
		
		for(int i=0; i<size; i+=diagonalSize+1)
			data[i] = 1f;
		
		return (T)this;
	}
	
	/** Matrix column based multiply (this <= left * right)
	 *  Don't use this matrix as input parameter (will yield incorrect results)
	 * @param left Current operation.
	 * @param right Operation to apply.
	 * @return Itself for convenience.
	 */
	@SuppressWarnings("unchecked")
	public T setMultiply(T left, T right) {
		setZero();
		
		for(int i = 0; i < diagonalSize; i++) {
			for(int j = 0; j < diagonalSize; j++) {
				final int jColumn = j*diagonalSize;
				for(int k = 0; k < diagonalSize; k++)
					data[jColumn + i] += left.data[k*diagonalSize + i] * right.data[jColumn + k];
			}
		}
		
		return (T)this;
	}
	
	/** Set transpose matrix.
	 * @return Itself for convenience. 
	 */
	@SuppressWarnings("unchecked")
	public T setTranspose() {
		for(int i = 0; i < diagonalSize; ++i) {
			final int iColumn = i*diagonalSize;
			for(int row = i + 1; row < diagonalSize; ++row) {
				int position  = iColumn + row;
				int transposePosition = row*diagonalSize + i;
				
				float tmp = data[transposePosition];
				data[transposePosition] = data[position];
				data[position] = tmp;
			}
		}
		return (T)this;
	}
	
	@SuppressWarnings("unchecked")
	public T setInvert(T toInvert) {
		return (T)this;
	}
	
	public float determinant() {
		return 0f;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		for(int row = 0; row < diagonalSize; ++row) {
			for(int column = 0; column < diagonalSize; ++column) {
				sb.append(data[column*diagonalSize + row]);
				sb.append("\t\t");
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
