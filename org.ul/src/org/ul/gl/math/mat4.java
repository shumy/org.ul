package org.ul.gl.math;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;

public class mat4 extends mat<mat4> {
	public mat4() {super(4);}

	/** Set translation matrix.
	 * @param translationVector Translation vector.
	 * @return Itself for convenience.
	 */
	public mat4 setTranslation(vec3 translationVector) {
		setIdentity();
		
		data[12] = translationVector.data[0];
		data[13] = translationVector.data[1];
		data[14] = translationVector.data[2];
		
		return this;
	}
	
	/** Optimized shortcut for setMultiply(left, right.setTranslation(translationVector))
	 * @param left Current operation.
	 * @param translationVector Apply translation.
	 * @return Itself for convenience.
	 */
	public mat4 setMultiplyTranslation(mat4 left, vec3 translationVector) {
		float t0 = translationVector.data[0];
		float t1 = translationVector.data[1];
		float t2 = translationVector.data[2];
		
		for(int i = 0; i < 12; ++i)
			data[i] = left.data[i];

		for(int i = 0; i < 4; ++i)
			data[12 + i] = left.data[i]*t0 + left.data[4 + i]*t1 + left.data[8 + i]*t2 + left.data[12 + i];
		
		return this;
	}
	
	/** Set scale matrix.
	 * @param scaleVector Scale vector. (important) Null vector is (1f, 1f, 1f)
	 * @return Itself for convenience.
	 */
	public mat4 setScale(vec3 scaleVector) {
		setZero();
		
		data[0]  = scaleVector.data[0];
		data[5]  = scaleVector.data[1];
		data[10] = scaleVector.data[2];
		data[15] = 1f;
		
		return this;
	}
	
	/** Optimized shortcut for setMultiply(left, right.setScale(scaleVector))
	 * @param left Current operation.
	 * @param scaleVector Apply scale
	 * @return Itself for convenience.
	 */
	public mat4 setMultiplyScale(mat4 left, vec3 scaleVector) {
		for(int k = 0; k < 3; ++k) {
			final int k4 = k*4;
			for(int i = 0 + k4; i < k4 + 4; ++i)
				data[i] = left.data[i]*scaleVector.data[k];
		}
		
		for(int i = 12; i < 16; ++i)
			data[i] = left.data[i];

		return this;
	}
	
	/** Set rotation matrix.
	 *  Always pass <b>normalized</b> rotationVector, or will yield incorrect results.
	 * @param rotationVector Normalized(important) vector for rotation axis.
	 * @param angle Rotate in degrees.
	 * @return Itself for convenience. 
	 */
	public mat4 setRotation(vec3 rotationVector, float angle) {
		final float rAngle = degreesToRadians(angle);
		
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
	public mat4 setPerspective(float fieldOfView, float aspectRatio, float nearPlane, float farPlane) {
		setZero();
		
		final float length = nearPlane - farPlane;
		final float yScale = coTangent(degreesToRadians(fieldOfView/2f));
		final float xScale = yScale / aspectRatio;

		set(0, 0, xScale);
		set(1, 1, yScale);
		set(2, 2, (farPlane + nearPlane) / length);
		set(2, 3, -1f);
		set(3, 2, (2*nearPlane*farPlane) / length);
		set(3, 3, 1f);
		
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
	public mat4 setOrthogonal(float leftPlane, float rightPlane, float bottomPlane, float topPlane, float nearPlane, float farPlane) {
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
	
	/** Set inverted matrix from the input matrix.
	 * Don't pass this matrix to the output, or will yield incorrect results.
	 * @param toInvert Input matrix
	 * @return Itself for convenience.
	 */
	public mat4 setInvert(mat4 toInvert) {
		//from http://www.geometrictools.com/Documentation/LaplaceExpansionTheorem.pdf
		
		final float[] a = toInvert.data;
		final float[] s = new float[6];
		final float[] c = new float[6];
		
		s[0] = a[0]*a[5] - a[1]*a[4];
		s[1] = a[0]*a[6] - a[2]*a[4];
		s[2] = a[0]*a[7] - a[3]*a[4];
		s[3] = a[1]*a[6] - a[2]*a[5];
		s[4] = a[1]*a[7] - a[3]*a[5];
		s[5] = a[2]*a[7] - a[3]*a[6];
		
		c[0] = a[8]*a[13] - a[9]*a[12];
		c[1] = a[8]*a[13] - a[10]*a[12];
		c[2] = a[8]*a[15] - a[11]*a[12];
		c[3] = a[9]*a[14] - a[10]*a[13];
		c[4] = a[9]*a[15] - a[11]*a[13];
		c[5] = a[10]*a[15] - a[11]*a[14];
		
		float det = s[0]*c[5] - s[1]*c[4] + s[2]*c[3] + s[3]*c[2] - s[4]*c[1] + s[5]*c[0];
		if(det == 0)
			throw new RuntimeException("Not Invertible!");
		
		//column 0
		//+a11c5 - a12c4 + a13c3
		//-a01c5 + a02c4 - a03c3
		//+a31s5 - a32s4 + a33s3
		//-a21s5 + a22s4 - a23s3
		data[0] =    a[5]*c[5] - a[6]*c[4] + a[7]*c[3];
		data[1] =  - a[1]*c[5] + a[2]*c[4] - a[3]*c[3];
		data[2] =    a[13]*s[5] - a[14]*s[4] + a[15]*s[3];
		data[3] =  - a[9]*s[5] + a[10]*s[4] - a[11]*s[3];
		
		//column 1
		//-a10c5 + a12c2 - a13c1
		//+a00c5 - a02c2 + a03c1
		//-a30s5 + a32s2 - a33s1
		//+a20s5 - a22s2 + a23s1
		data[4] =  - a[4]*c[5] + a[6]*c[2] - a[7]*c[1];
		data[5] =    a[0]*c[5] - a[2]*c[2] + a[3]*c[1];
		data[6] =  - a[12]*s[5] + a[14]*s[2] - a[15]*s[1];
		data[7] =    a[8]*s[5] - a[10]*s[2] + a[11]*s[1];
		
		//column 2
		//+a10c4 - a11c2 + a13c0
		//-a00c4 + a01c2 - a03c0
		//+a30s4 - a31s2 + a33s0
		//-a20s4 + a21s2 - a23s0
		data[8] =    a[4]*c[4] - a[5]*c[2] + a[7]*c[0];
		data[9] =  - a[0]*c[4] + a[1]*c[2] - a[3]*c[0];
		data[10] =   a[12]*s[4] - a[13]*s[2] + a[15]*s[0];
		data[11] = - a[8]*s[4] + a[9]*s[2] - a[11]*s[0];
		
		//column 3
		//-a10c3 + a11c1 - a12c0
		//+a00c3 - a01c1 + a02c0
		//-a30s3 + a31s1 - a32s0
		//+a20s3 - a21s1 + a22s0
		data[12] =  - a[4]*c[3] + a[5]*c[1] - a[6]*c[0];
		data[13] =    a[0]*c[3] - a[1]*c[1] + a[2]*c[0];
		data[14] =  - a[12]*s[3] + a[13]*s[1] - a[14]*s[0];
		data[15] =    a[8]*s[3] - a[9]*s[1] + a[10]*s[0];
		
		//inv(A) = adj(A)/det(A)
		det = 1f/det;
		for(int i=0; i<16; ++i)
			data[i] *= det;
		
		return this;
	}
	
	/** Calculate (in every call) the matrix determinant
	 * @return Determinant value
	 */
	public float determinant() {
		final float[] a = data;
		final float[] s = new float[6];
		final float[] c = new float[6];
		
		s[0] = a[0]*a[5] - a[1]*a[4];
		s[1] = a[0]*a[6] - a[2]*a[4];
		s[2] = a[0]*a[7] - a[3]*a[4];
		s[3] = a[1]*a[6] - a[2]*a[5];
		s[4] = a[1]*a[7] - a[3]*a[5];
		s[5] = a[2]*a[7] - a[3]*a[6];
		
		c[0] = a[8]*a[13] - a[9]*a[12];
		c[1] = a[8]*a[13] - a[10]*a[12];
		c[2] = a[8]*a[15] - a[11]*a[12];
		c[3] = a[9]*a[14] - a[10]*a[13];
		c[4] = a[9]*a[15] - a[11]*a[13];
		c[5] = a[10]*a[15] - a[11]*a[14];
		
		return s[0]*c[5] - s[1]*c[4] + s[2]*c[3] + s[3]*c[2] - s[4]*c[1] + s[5]*c[0];
	}
	
	private float coTangent(float angle) {
		return (float)(1f/tan(angle));
	}
	
	private float degreesToRadians(float degrees) {
		return degrees*(float)(PI/180d);
	}
}
