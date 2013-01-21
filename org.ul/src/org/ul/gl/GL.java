package org.ul.gl;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

public class GL {
	public static int width;
	public static int height;
	public static float aspectRatio;

	public static void init() {
		//glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		
		gl.glEnable(GL_BLEND);
		gl.glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		gl.glEnable(GL_CULL_FACE);
		gl.glCullFace(GL_BACK);
		
		gl.glEnable(GL_DEPTH_TEST);
		gl.glDepthFunc(GL_LESS);
		
		gl.glEnable(GL_SCISSOR_TEST);
		
		System.out.println(GL.width + "x" + GL.height + " ratio:" + GL.aspectRatio);
	}
	
	public static void errorTest(String msg) {
		final String error = gl.glGetError();
		if(error != null)
			throw new RuntimeException(msg + " - " + error);
	}
}
