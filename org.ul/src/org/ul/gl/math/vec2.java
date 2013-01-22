package org.ul.gl.math;

public class vec2 extends vec<vec2> {
	public vec2() {super(2);}
	
	public vec2(float v0, float v1) {
		this();
		data[0] = v0;
		data[1] = v1;
	}
}
