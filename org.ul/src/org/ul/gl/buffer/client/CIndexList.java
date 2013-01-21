package org.ul.gl.buffer.client;

import org.ul.gl.buffer.GLIndexBuffer;
import org.ul.util.NativeBuffer;

public class CIndexList extends ACBuffer<GLIndexBuffer> {
	int size, stride;
	
	public int getSize() {return size;}

	public CIndexList(int size) {
		this.size = size;
		this.stride = 4;
		
		buffer = new NativeBuffer(size * stride);
	}

	@Override
	public void write() {
		buffer.flip();
		if(glBuffer != null)
			glBuffer.unpack(this);
	}
	
	public CIndexList put(int ...indices) {
		buffer.putInt(indices);
		return this;
	}
}
