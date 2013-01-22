package org.ul.gl.math;

public class vec3 extends vec<vec3> {
	public vec3() {super(3);}
	public vec3(float v0, float v1, float v2) {
		this();
		data[0] = v0;
		data[1] = v1;
		data[2] = v2;
	}
	
	// z < xXy
	public vec3 setCrossProduct(vec3 x, vec3 y) {
		data[0] = x.data[1]*y.data[2] -  x.data[2]*y.data[1];
		data[1] = x.data[2]*y.data[0] -  x.data[0]*y.data[2];
		data[2] = x.data[0]*y.data[1] -  x.data[1]*y.data[0];
		return this;
	}
}
