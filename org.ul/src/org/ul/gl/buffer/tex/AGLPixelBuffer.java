package org.ul.gl.buffer.tex;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.AGLBuffer;

public abstract class AGLPixelBuffer extends AGLBuffer {
	protected int width, height;
	protected GLFormat format;

	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public GLFormat getFormat() {return format;}
}
