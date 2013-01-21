package org.ul.gl.entity;

import org.ul.gl.GLType;

public final class GLVertexAttribute {
	public final int offset;
	public final GLType type;
	public final int size;
	public final boolean normalize;
	
	public final int stride;
	
	public GLVertexAttribute(int offset, GLType type, int size, boolean normalize) {
		this.offset = offset;
		this.type = type;
		this.size = size;
		this.normalize = normalize;
		
		this.stride = type.glSize * size;
	}

}
