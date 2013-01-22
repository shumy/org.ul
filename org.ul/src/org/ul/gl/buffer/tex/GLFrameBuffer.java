package org.ul.gl.buffer.tex;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.buffer.AGLBuffer;
import org.ul.gl.buffer.client.CTexture;

public class GLFrameBuffer extends AGLBuffer {
	
	public GLFrameBuffer() {
		this.target = Target.FRAME;
		id = gl.glGenFrameBuffer();
	}
	
	@Override
	public void dispose() {
		gl.glDeleteFrameBuffer(id);
	}
	
	public void attach(AGLPixelBuffer buffer) {
		gl.glBindFrameBuffer(GL_FRAMEBUFFER, id);
			if(buffer.getTarget() == Target.TEXTURE) {
				gl.glFrameBufferTexture2D(GL_FRAMEBUFFER, buffer.getFormat().glAttachment, GL_TEXTURE_2D, buffer.getId(), 0);
			} else if (buffer.getTarget() == Target.RENDER) {
				gl.glFrameBufferRenderbuffer(GL_FRAMEBUFFER, buffer.getFormat().glAttachment, GL_RENDERBUFFER, buffer.getId());
			}
		gl.glBindFrameBuffer(GL_FRAMEBUFFER, GL_NONE);
	}
	
	public void begin() {
		gl.glBindFrameBuffer(GL_FRAMEBUFFER, id);
	}

	public void end() {
		gl.glBindFrameBuffer(GL_FRAMEBUFFER, GL_NONE);
	}

	public void pack(CTexture cTexture) {
		gl.glReadPixels(0, 0, cTexture.getSize().data[0], cTexture.getSize().data[1], 
				cTexture.getFormat().glTextureFormat, GL_UNSIGNED_BYTE, cTexture.getData());
	}

}
