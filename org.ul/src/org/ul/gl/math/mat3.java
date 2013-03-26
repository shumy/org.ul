package org.ul.gl.math;

public class mat3 extends mat<mat3> {
	public mat3() {super(3);}
	
	@Override
	public mat3 setInvert(mat3 toInvert) {
		//from http://www.geometrictools.com/Documentation/LaplaceExpansionTheorem.pdf
		final float[] a = toInvert.data;
		final float[] s = new float[3];
		
		
		s[0] = a[4]*a[8] - a[5]*a[7];
		s[1] = a[3]*a[8] - a[5]*a[6];
		s[2] = a[3]*a[7] - a[4]*a[6];
				
		//+a00(a11a22 - a12a21) - a01(a10a22 - a12a20) + a02(a10a21 - a11a20)
		float det = a[0]*s[0] - a[1]*s[1] + a[2]*s[2];
		if(det == 0)
			throw new RuntimeException("Not Invertible!");
		
		//column 0
		//+(a11a22 - a12a21) 
		//-(a01a22 - a02a21) 
		//+(a01a12 - a02a11)
		data[0] = s[0];
		data[1] = -(a[1]*a[8] - a[2]*a[7]);
		data[2] = a[1]*a[5] - a[2]*a[4];
		
		//column 1
		//-(a10a22 - a12a20) 
		//+(a00a22 - a02a20) 
		//-(a00a12 - a02a10)
		data[3] = -s[1];
		data[4] = a[0]*a[8] - a[2]*a[6];
		data[5] = -(a[0]*a[5] - a[2]*a[3]);
		
		//column 2
		//+(a10a21 - a11a20) 
		//-(a00a21 - a01a20) 
		//+(a00a11 - a01a10)
		data[6] = s[2];
		data[7] = -(a[0]*a[7] - a[1]*a[6]);
		data[8] = a[0]*a[4] - a[1]*a[3];
		
		//inv(A) = adj(A)/det(A)
		det = 1f/det;
		for(int i=0; i<9; ++i)
			data[i] *= det;
		
		return this;
	}
	
	@Override
	public float determinant() {
		final float[] a = data;
		final float[] s = new float[3];
		
		s[0] = a[4]*a[8] - a[5]*a[7];
		s[1] = a[3]*a[8] - a[5]*a[6];
		s[2] = a[3]*a[7] - a[4]*a[6];
				
		//+a00(a11a22 - a12a21) - a01(a10a22 - a12a20) + a02(a10a21 - a11a20)
		return a[0]*s[0] - a[1]*s[1] + a[2]*s[2];
	}
}
