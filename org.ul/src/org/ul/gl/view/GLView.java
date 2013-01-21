package org.ul.gl.view;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

public class GLView {
	public enum ClearFlag {
		COLOR(GL_COLOR_BUFFER_BIT), DEPTH(GL_DEPTH_BUFFER_BIT);
		
		final int flag;
		private ClearFlag(int flag) {
			this.flag = flag;
		}
	}
	
	private int clearFlags = GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT;
	private float red, green, blue;
	private int x, y;
	private int width, height;
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public GLView() {
		//setColor(0.4f, 0.6f, 0.9f);	//XNA default color
		//setColor(0.2f, 0.2f, 0.2f);
		setColor(0f, 0f, 0f);
	}
	
	public void setClearFlags(ClearFlag ...flags) {
		clearFlags = 0;
		for(ClearFlag c: flags)
			clearFlags = clearFlags | c.flag; 
	}
	
	public void setColor(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void use() {
		gl.glViewport(x, y, width, height);
		gl.glScissor(x, x, width, height);
	}
	
	public void clear() {
		gl.glClearColor(red, green, blue, 0.0f);
		gl.glClear(clearFlags);
	}
}
