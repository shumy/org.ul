package org.ul.gl.math;

public class vec4 extends vec<vec4> {
	public vec4() {super(4);}

	public vec4(float x, float y, float z, float w) {
		this();
		data[0] = x;
		data[1] = y;
		data[2] = z;
		data[3] = w;
	}
}
