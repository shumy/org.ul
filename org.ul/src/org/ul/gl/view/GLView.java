package org.ul.gl.view;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import org.ul.gl.math.ivec2;
import org.ul.gl.math.vec3;

public class GLView {
	public enum ClearFlag {
		COLOR(GL_COLOR_BUFFER_BIT), DEPTH(GL_DEPTH_BUFFER_BIT);
		
		final int flag;
		private ClearFlag(int flag) {
			this.flag = flag;
		}
	}
	
	private int clearFlags = GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT;
	private vec3 color = new vec3(0f, 0f, 0f);
	private ivec2 position = new ivec2(0, 0);
	private ivec2 size;
	
	public vec3 getColor() {return color;}
	public GLView setColor(vec3 color) {
		this.color = color;
		return this;
	}
	
	public ivec2 getPosition() {return position;}
	public GLView setPosition(ivec2 position) {
		this.position = position;
		return this;
	}
	
	public ivec2 getSize() {return size;}
	public GLView setSize(ivec2 size) {
		this.size = size;
		return this;
	}
	
	public void setClearFlags(ClearFlag ...flags) {
		clearFlags = 0;
		for(ClearFlag c: flags)
			clearFlags = clearFlags | c.flag; 
	}
	
	
	public void use() {
		gl.glViewport(position.data[0], position.data[1], size.data[0], size.data[1]);
		gl.glScissor(position.data[0], position.data[1], size.data[0], size.data[1]);
	}
	
	public void clear() {
		gl.glClearColor(color.data[0], color.data[1], color.data[2], 0.0f);
		gl.glClear(clearFlags);
	}
}
