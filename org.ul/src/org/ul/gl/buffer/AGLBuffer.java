package org.ul.gl.buffer;

import org.ul.IDisposable;

public abstract class AGLBuffer implements IDisposable {
	public enum Target {VERTEX, INDEX, FRAME, RENDER, TEXTURE;}
	
	protected int id = 0;
	protected Target target;
	
	public int getId() {return id;}
	public Target getTarget() {return target;}
}
