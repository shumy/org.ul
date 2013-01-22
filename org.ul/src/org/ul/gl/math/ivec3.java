package org.ul.gl.math;

public class ivec3 extends ivec<ivec3>{
	public ivec3() {super(3);}
	public ivec3(int v0, int v1, int v2) {
		this();
		data[0] = v0;
		data[1] = v1;
		data[2] = v2;
	}
	
	// z < xXy
	public ivec3 setCrossProduct(ivec3 x, ivec3 y) {
		data[0] = x.data[1]*y.data[2] -  x.data[2]*y.data[1];
		data[1] = x.data[2]*y.data[0] -  x.data[0]*y.data[2];
		data[2] = x.data[0]*y.data[1] -  x.data[1]*y.data[0];
		return this;
	}
}
