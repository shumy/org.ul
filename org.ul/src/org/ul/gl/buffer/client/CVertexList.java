package org.ul.gl.buffer.client;

import org.ul.gl.buffer.GLVertexBuffer;
import org.ul.gl.entity.GLVertexAttribute;
import org.ul.util.NativeBuffer;

public class CVertexList extends ACBuffer<GLVertexBuffer> {
	int size, stride;
	
	int nextPosition = 0;
	int limitHelper = 0;
	boolean seqActive = false;

	public int getSize() {return size;}
	public int getStride() {return stride;}
	
	protected void init(int size, GLVertexAttribute ...attribs) {
		this.size = size;
		for(GLVertexAttribute a: attribs)
			stride += a.stride;
		
		buffer = new NativeBuffer(size * stride);
	}
	
	@Override
	public void write() {
		if(seqActive) {
			buffer.setPosition(0);
			buffer.setLimit(limitHelper);
			
			nextPosition = 0;
			limitHelper = 0;
			seqActive = false;
		} else
			buffer.flip();
		
		if(glBuffer != null)
			glBuffer.unpack(this);
	}
	
	public CVertexList use(GLVertexAttribute attrib) {
		seqActive = true;
		
		nextPosition = 0 + attrib.offset;
		buffer.setPosition(nextPosition);
		return this;
	}
	
	private void position() {
		buffer.setPosition(nextPosition);
	}
	
	private void next() {
		if(buffer.getPosition() > limitHelper) 
			limitHelper = buffer.getPosition();
		nextPosition +=stride;
	}
	
	//float-----------------------------------------------------------------------------------------------	
	public CVertexList put(GLVertexAttribute attrib, float[] data) {
		return put(attrib, data, 0);
	}
	
	public CVertexList put(GLVertexAttribute attrib, float[] data, int dataOffset) {
		return put(attrib.size, data, dataOffset);
	}
	
	public CVertexList put(int size, float[] data, int dataOffset) {
		if(seqActive) position();
		for(int i=dataOffset; i<size; ++i)
			buffer.putFloat(data[i]);

		if(seqActive) next();
		return this;
	}

	//int-----------------------------------------------------------------------------------------------
	public CVertexList put(GLVertexAttribute attrib, int[] data) {
		return put(attrib, data, 0);
	}
	
	public CVertexList put(GLVertexAttribute attrib, int[] data, int dataOffset) {
		return put(attrib.size, data, dataOffset);
	}
	
	public CVertexList put(int size, int[] data, int dataOffset) {
		if(seqActive) position();
		for(int i=dataOffset; i<size; ++i)
			buffer.putInt(data[i]);

		if(seqActive) next();
		return this;
	}
	
	//short-----------------------------------------------------------------------------------------------
	public CVertexList put(GLVertexAttribute attrib, short[] data) {
		return put(attrib, data, 0);
	}
	
	public CVertexList put(GLVertexAttribute attrib, short[] data, int dataOffset) {
		return put(attrib.size, data, dataOffset);
	}
	
	public CVertexList put(int size, short[] data, int dataOffset) {
		if(seqActive) position();
		for(int i=dataOffset; i<size; ++i)
			buffer.putShort(data[i]);

		if(seqActive) next();
		return this;
	}
	
	//byte-----------------------------------------------------------------------------------------------
	public CVertexList put(GLVertexAttribute attrib, byte[] data) {
		return put(attrib, data, 0);
	}
	
	public CVertexList put(GLVertexAttribute attrib, byte[] data, int dataOffset) {
		return put(attrib.size, data, dataOffset);
	}
	
	public CVertexList put(int size, byte[] data, int dataOffset) {
		if(seqActive) position();
		for(int i=dataOffset; i<size; ++i)
			buffer.putByte(data[i]);

		if(seqActive) next();
		return this;
	}
}
