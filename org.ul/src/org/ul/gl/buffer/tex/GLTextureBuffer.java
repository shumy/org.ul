package org.ul.gl.buffer.tex;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.client.CTexture;
import org.ul.gl.math.ivec2;

public class GLTextureBuffer extends AGLPixelBuffer {
	CTexture cTexture;
	
	public GLTextureBuffer() {
		this.target = Target.TEXTURE;
		alloc();
	}
	
	public GLTextureBuffer(ivec2 size, GLFormat format) {
		this.target = Target.TEXTURE;
		this.size = size;
		this.format = format;
		
		alloc();
	}
	
	private void alloc() {
		id = gl.glGenTexture();
		gl.glBindTexture(GL_TEXTURE_2D, id);
			
			if(format != null)
				gl.glTexImage2D(GL_TEXTURE_2D, 0, format.glTextureFormat, size.data[0], size.data[1], GL_UNSIGNED_BYTE, null);
			
			gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			
			gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
			gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
			
		gl.glBindTexture(GL_TEXTURE_2D, GL_NONE);
	}
	
	public void unpack(CTexture cTexture) {
		this.size = cTexture.getSize();
		this.format = cTexture.getFormat();
		
		gl.glBindTexture(GL_TEXTURE_2D, id);
			gl.glTexImage2D(GL_TEXTURE_2D, 0, format.glTextureFormat, size.data[0], size.data[1], GL_UNSIGNED_BYTE, cTexture.getData());
		gl.glBindTexture(GL_TEXTURE_2D, GL_NONE);
	}
	
	@Override
	public void dispose() {
		gl.glDeleteTexture(id);
	}

	
	/** Bind the texture to the shader texture unit.
	 *  Use GLProgram.setTextureUnit(..) to bind with a uniform shader.
	 * @param textureUnit The texture is bound to: GL_TEXTURE0 + textureUnit
	 */
	public void bindToUnit(int textureUnit) {		
		gl.glActiveTexture(GL_TEXTURE0 + textureUnit);
			gl.glBindTexture(GL_TEXTURE_2D, id);
		gl.glActiveTexture(GL_TEXTURE0);
		gl.glBindTexture(GL_TEXTURE_2D, GL_NONE);
	}
	
}
