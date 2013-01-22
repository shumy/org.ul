package org.ul.gl.math;

public class ivec4 extends ivec<ivec4>{
	public ivec4() {super(4);}
	
	public ivec4(int v0, int v1, int v2, int v3) {
		this();
		data[0] = v0;
		data[1] = v1;
		data[2] = v2;
		data[3] = v3;
	}
}
