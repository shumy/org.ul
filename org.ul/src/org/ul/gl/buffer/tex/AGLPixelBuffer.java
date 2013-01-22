package org.ul.gl.buffer.tex;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.AGLBuffer;
import org.ul.gl.math.ivec2;

public abstract class AGLPixelBuffer extends AGLBuffer {
	protected ivec2 size;
	protected GLFormat format;

	public ivec2 getSize() {return size;}
	public GLFormat getFormat() {return format;}
}
