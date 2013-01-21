package org.ul.gl.math;

import static java.lang.Math.*;

import java.util.Arrays;

public class Matrix4f {
	public final int diagonalSize 	= 4;
	public final int size 			= diagonalSize * diagonalSize;
	public final float[] data;
	
	public Matrix4f() {
		data = new float[size];
	}
	
	public Matrix4f set(int column, int row, float value) {
		data[column*diagonalSize + row] = value;
		return this;
	}
	
	public float get(int column, int row) {
		return data[column*diagonalSize + row];
	}
	
	/** Reset matrix to zeros.
	 * @return Itself for convenience. 
	 */
	public Matrix4f setZero() {
		Arrays.fill(data, 0f);
		return this;
	}
	
	/** Reset to identity matrix.
	 * @return Itself for convenience. 
	 */
	public Matrix4f setIdentity() {
		setZero();
		
		data[0]  = 1f;
		data[5]  = 1f;
		data[10] = 1f;
		data[15] = 1f;
		
		return this;
	}
	
	/** Set translation matrix.
	 * @param translationVector Translation vector.
	 * @return Itself for convenience.
	 */
	public Matrix4f setTranslation(Vector3f translationVector) {
		setIdentity();
		
		data[12] = translationVector.data[0];
		data[13] = translationVector.data[1];
		data[14] = translationVector.data[2];
		
		return this;
	}
	
	/** Set scale matrix.
	 * @param scaleVector Scale vector. (important) Null vector is (1f, 1f, 1f)
	 * @return Itself for convenience.
	 */
	public Matrix4f setScale(Vector3f scaleVector) {
		setZero();
		
		data[0]  = scaleVector.data[0];
		data[5]  = scaleVector.data[1];
		data[10] = scaleVector.data[2];
		data[15] = 1f;
		
		return this;
	}
	
	/** Set rotation matrix.
	 *  Always pass <b>normalized</b> rotationVector, or will yield incorrect results.
	 * @param rotationVector Normalized(important) vector for rotation axis.
	 * @param angle Rotate in degrees.
	 * @return Itself for convenience. 
	 */
	public Matrix4f setRotation(Vector3f rotationVector, float angle) {
		final float rAngle =degreesToRadians(angle);
		
		final float x = rotationVector.data[0];
		final float y = rotationVector.data[1];
		final float z = rotationVector.data[2];
		
		final float aCos = (float)cos(rAngle);
		final float aSin = (float)sin(rAngle);
		
		final float m1_aCos = 1 - aCos;
		
		final float xx=x*x, yy=y*y, zz=z*z;
		final float xy=x*y, xz=x*z, yz=y*z;
		
		
		set(0,0, aCos + xx*m1_aCos);	set(1,0, xy*m1_aCos - z*aSin);	set(2,0, xz*m1_aCos + y*aSin); 	set(3,0, 0);
		set(0,1, xy*m1_aCos + z*aSin);	set(1,1, aCos + yy*m1_aCos);	set(2,1, yz*m1_aCos - x*aSin);	set(3,1, 0);
		set(0,2, xz*m1_aCos - y*aSin);	set(1,2, yz*m1_aCos + x*aSin);	set(2,2, aCos + zz*m1_aCos);	set(3,2, 0);
		set(0,3, 0);					set(1,3, 0);					set(2,3, 0);					set(3,3, 1);
		
		return this;
	}
	
	/** Set perspective projection matrix.
	 * @param fieldOfView Angle of view in degrees.
	 * @param aspectRatio View with/height ratio.
	 * @param nearPlane Near cut plane (distance to eye).
	 * @param farPlane Far cut plane (distance to eye).
	 * @return Itself for convenience. 
	 */
	public Matrix4f setPerspective(float fieldOfView, float aspectRatio, float nearPlane, float farPlane) {
		setZero();
		
		final float length = nearPlane - farPlane;
		final float yScale = coTangent(degreesToRadians(fieldOfView/2f));
		final float xScale = yScale / aspectRatio;

		set(0, 0, xScale);
		set(1, 1, yScale);
		set(2, 2, (farPlane + nearPlane) / length);
		set(2, 3, -1f);
		set(3, 2, (2*nearPlane*farPlane) / length);
		set(3, 3, 1f);	//is this 0 or 1 ??
		
		return this;
	}
	
	/** Set orthogonal projection matrix.
	 * @param leftPlane Left cut plane
	 * @param rightPlane Right cut plane
	 * @param bottomPlane Bottom cut plane
	 * @param topPlane Top cut plane
	 * @param nearPlane Near cut plane (distance to eye)
	 * @param farPlane Far cut plane (distance to eye)
	 * @return
	 */
	public Matrix4f setOrthogonal(float leftPlane, float rightPlane, float bottomPlane, float topPlane, float nearPlane, float farPlane) {
		setZero();
		
		final float length = nearPlane - farPlane;
		final float width = rightPlane - leftPlane;
		final float hight = topPlane - bottomPlane;

		set(0, 0, 2f / width);
		set(1, 1, 2f / hight);
		set(2, 2, 2f / length);
		set(3, 0, -(rightPlane + leftPlane) / width);
		set(3, 1, -(topPlane + bottomPlane) / hight);
		set(3, 2, (farPlane + nearPlane) / length);
		set(3, 3, 1f);

		return this;
		//TODO: not tested...........................
	}
		
	/** Matrix column based multiply (this <= left * right)
	 *  Don't use this matrix as input parameter (will yield incorrect results)
	 * @param left Current operation.
	 * @param right Operation to apply.
	 * @return Itself for convenience.
	 */
	public Matrix4f setMultiply(Matrix4f left, Matrix4f right) {
		setZero();
		
		for(int i = 0; i < diagonalSize; i++) {
			for(int j = 0; j < diagonalSize; j++) {
				final int jColumn = j*diagonalSize;
				for(int k = 0; k < diagonalSize; k++)
					data[jColumn + i] += left.data[k*diagonalSize + i] * right.data[jColumn + k];
			}
		}
		
		return this;
	}
	
	/** Optimized shortcut for setMultiply(left, right.setTranslation(translationVector))
	 * @param left Current operation.
	 * @param translationVector Apply translation.
	 * @return Itself for convenience.
	 */
	public Matrix4f setMultiplyTranslation(Matrix4f left, Vector3f translationVector) {
		float t0 = translationVector.data[0];
		float t1 = translationVector.data[1];
		float t2 = translationVector.data[2];
		
		for(int i = 0; i < 12; ++i)
			data[i] = left.data[i];

		for(int i = 0; i < 4; ++i)
			data[12 + i] = left.data[i]*t0 + left.data[4 + i]*t1 + left.data[8 + i]*t2 + left.data[12 + i];
		
		return this;
	}
	
	/** Optimized shortcut for setMultiply(left, right.setScale(scaleVector))
	 * @param left Current operation.
	 * @param scaleVector Apply scale
	 * @return Itself for convenience.
	 */
	public Matrix4f setMultiplyScale(Matrix4f left, Vector3f scaleVector) {
		for(int k = 0; k < 3; ++k) {
			final int k4 = k*4;
			for(int i = 0 + k4; i < k4 + 4; ++i)
				data[i] = left.data[i]*scaleVector.data[k];
		}
		
		for(int i = 12; i < 16; ++i)
			data[i] = left.data[i];

		return this;
	}
	
	/** Set transpose matrix.
	 * @return Itself for convenience. 
	 */
	public Matrix4f setTranspose() {
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
		return this;
	}
	
	/** Set inverted matrix
	 * @return Itself for convenience.
	 */
	public Matrix4f setInvert() {
		//TODO: invert
		return this;
		//TODO: not tested...........................
	}
	
	public float determinant() {
		
		
		/*
		+ val[M30] * val[M21] * val[M12] * val[M03] 
		- val[M20] * val[M31] * val[M12] * val[M03] 
		- val[M30] * val[M11] * val[M22] * val[M03] 
		+ val[M10] * val[M31] * val[M22] * val[M03] 
		+ val[M20] * val[M11] * val[M32] * val[M03] 
		- val[M10] * val[M21] * val[M32] * val[M03] 
		- val[M30] * val[M21] * val[M02] * val[M13] 
		+ val[M20] * val[M31] * val[M02] * val[M13]
		+ val[M30] * val[M01] * val[M22] * val[M13] 
		- val[M00] * val[M31] * val[M22] * val[M13] 
		- val[M20] * val[M01] * val[M32] * val[M13] 
		+ val[M00] * val[M21] * val[M32] * val[M13] 
		+ val[M30] * val[M11] * val[M02] * val[M23] 
		- val[M10] * val[M31] * val[M02] * val[M23] 
		- val[M30] * val[M01] * val[M12] * val[M23] 
		+ val[M00] * val[M31] * val[M12] * val[M23] 
		+ val[M10] * val[M01] * val[M32] * val[M23] 
		- val[M00] * val[M11] * val[M32] * val[M23] 
		- val[M20] * val[M11] * val[M02] * val[M33]
		+ val[M10] * val[M21] * val[M02] * val[M33] 
		+ val[M20] * val[M01] * val[M12] * val[M33] 
		- val[M00] * val[M21] * val[M12] * val[M33] 
		- val[M10] * val[M01] * val[M22] * val[M33] 
		+ val[M00] * val[M11] * val[M22] * val[M33]
		*/
		
		//Leibniz formula !!
		//http://en.wikipedia.org/wiki/Leibniz_formula_for_determinants
		
		
		//TODO: not tested...........................
	}
	
	private float coTangent(float angle) {
		return (float)(1f/tan(angle));
	}
	
	private float degreesToRadians(float degrees) {
		return degrees*(float)(PI/180d);
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
