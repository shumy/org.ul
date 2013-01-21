package org.ul.gl.buffer;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.buffer.client.CIndexList;

public class GLIndexBuffer extends AGLBuffer {
	int size = 0;
	
	public int getSize() {return size;}

	public GLIndexBuffer() {
		this.target = Target.INDEX;
		alloc();
	}
	
	private void alloc() {
		id = gl.glGenBuffer();
	}
	
	public void unpack(CIndexList cIndex) {
		this.size = cIndex.getSize();
		
		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, id);
			gl.glBufferData(GL_ELEMENT_ARRAY_BUFFER, cIndex.getData(), GL_STATIC_DRAW);
		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, GL_NONE);
	}

	@Override
	public void dispose() {
		gl.glDeleteBuffer(id);
	}
}
