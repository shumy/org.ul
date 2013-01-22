package org.ul.gl.buffer.client;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.gl.math.ivec2;
import org.ul.util.NativeBuffer;

public class CTexture extends ACBuffer<GLTextureBuffer> {
	final ivec2 size;
	final GLFormat format;
	
	public ivec2 getSize() {return size;}
	public GLFormat getFormat() {return format;}
	
	public CTexture(ivec2 size, GLFormat format) {
		this.size = size;
		this.format = format;
		
		this.buffer = new NativeBuffer(size.componentMultiply() * format.glBytesPerPixel);
	}
	
	@Override
	public void write() {
		buffer.flip();
		if(glBuffer != null)
			glBuffer.unpack(this);
	}
}
