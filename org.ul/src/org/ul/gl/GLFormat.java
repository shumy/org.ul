package org.ul.gl;

import static org.ul.spi.SPIgl.*;

/*
public enum Attachment {
	COLOR(GL_COLOR_ATTACHMENT0),
	DEPTH(GL_DEPTH_ATTACHMENT),
	STENCIL(GL_STENCIL_ATTACHMENT);
	
	public final int glType;
	private Attachment(int glType) {
		this.glType = glType;
	}
}

public enum RFormat {
	RGBA4(GL_RGBA4),
	RGB5_A1(GL_RGB5_A1),
	
	DEPTH_COMPONENT16(GL_DEPTH_COMPONENT16),
	STENCIL_INDEX8(GL_STENCIL_INDEX8);
	
	public final int glFormat;
	private RFormat(int glFormat) {
		this.glFormat = glFormat;
	}
}

public enum TFormat {		
	DEPTH(GL_DEPTH_COMPONENT, 1),
	
	RGB(GL_RGB, 3),
	RGBA(GL_RGBA, 4),
	
	ALPHA(GL_ALPHA, 1),
	LUMINANCE(GL_LUMINANCE, 1),
	LUMINANCE_ALPHA(GL_LUMINANCE_ALPHA, 2);
	
	public final int glType;
	public final int glBytesPerPixel;
	
	private TFormat(int glType, int glBytesPerPixel) {
		this.glType = glType;
		this.glBytesPerPixel = glBytesPerPixel;
	}
}
*/

public enum GLFormat {
	DEPTH	(GL_DEPTH_COMPONENT, 	GL_DEPTH_COMPONENT16, 	GL_DEPTH_ATTACHMENT, 	1),
	STENCIL	(GL_NONE,				GL_STENCIL_INDEX8, 		GL_STENCIL_ATTACHMENT, 	1),
	
	RGB	 	(GL_RGB, 				GL_RGB5_A1, 			GL_COLOR_ATTACHMENT0, 	3),
	RGBA 	(GL_RGBA, 				GL_RGBA4, 				GL_COLOR_ATTACHMENT0, 	4);
	
	public final int glRenderFormat;
	public final int glTextureFormat;
	public final int glAttachment;
	public final int glBytesPerPixel;
	
	private GLFormat(int glTextureFormat, int glRenderType, int glAttachment, int glBytesPerPixel) {
		this.glTextureFormat = glTextureFormat;
		this.glRenderFormat = glRenderType;
		this.glAttachment = glAttachment;
		this.glBytesPerPixel = glBytesPerPixel;
	}
}
