package org.ul.gl.math;

public class ivec2 extends ivec<ivec2>{
	public ivec2() {super(2);}
	
	public ivec2(int v0, int v1) {
		this();
		data[0] = v0;
		data[1] = v1;
	}
	
	/** Calculate (in every call) the ratio v0/v1 
	 * @return ratio v0/v1
	 */
	public float ratio() {
		return data[0]/(float)data[1];
	}
}
