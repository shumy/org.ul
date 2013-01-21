package org.ul.gl.buffer;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.buffer.client.CVertexList;

public class GLVertexBuffer extends AGLBuffer {
	int stride = 0;

	public int getStride() {return stride;}
	
	public GLVertexBuffer() {
		this.target = Target.VERTEX;
		alloc();
	}
	
	private void alloc() {
		id = gl.glGenBuffer();
	}
	
	public void unpack(CVertexList cVertex) {
		this.stride = cVertex.getStride();
		
		gl.glBindBuffer(GL_ARRAY_BUFFER, id);
			gl.glBufferData(GL_ARRAY_BUFFER, cVertex.getData(), GL_STATIC_DRAW);
		gl.glBindBuffer(GL_ARRAY_BUFFER, GL_NONE);
	}
	
	@Override
	public void dispose() {
		gl.glDeleteBuffer(id);
	}
}
