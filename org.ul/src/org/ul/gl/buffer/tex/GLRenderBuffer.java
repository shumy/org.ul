package org.ul.gl.buffer.tex;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.GLFormat;

public class GLRenderBuffer extends AGLPixelBuffer {
	
	public GLRenderBuffer(int width, int height, GLFormat format) {
		this.target = Target.RENDER;
		this.width = width;
		this.height = height;
		this.format = format;
		

		//glGetIntegerv(GL_MAX_RENDERBUFFER_SIZE, &maxRenderbufferSize);
		//if(width > GL_MAX_RENDERBUFFER_SIZE || height > GL_MAX_RENDERBUFFER_SIZE)
		//	throw new RuntimeException("Render buffer (width or height) exceed max size of: " + GL_MAX_RENDERBUFFER_SIZE);
		
		id = gl.glGenRenderBuffer();

		gl.glBindRenderBuffer(GL_RENDERBUFFER, id);
			gl.glRenderBufferStorage(GL_RENDERBUFFER, format.glRenderFormat, width, height);
		gl.glBindRenderBuffer(GL_RENDERBUFFER, GL_NONE);
	}

	@Override
	public void dispose() {
		gl.glDeleteRenderBuffer(id);
	}

}
