package org.ul.gl.buffer.client;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.util.NativeBuffer;

public class CTexture extends ACBuffer<GLTextureBuffer> {
	final int width, height;
	final GLFormat format;
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public GLFormat getFormat() {return format;}
	
	public CTexture(int width, int height, GLFormat format) {
		this.width = width;
		this.height = height;
		this.format = format;
		
		this.buffer = new NativeBuffer(width * height * format.glBytesPerPixel);
	}
	
	@Override
	public void write() {
		buffer.flip();
		if(glBuffer != null)
			glBuffer.unpack(this);
	}
}
