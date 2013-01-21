package org.ul.gl.buffer.client;

import org.ul.IDisposable;
import org.ul.util.NativeBuffer;

public abstract class ACBuffer<B> implements IDisposable {
	NativeBuffer buffer;
	B glBuffer = null;
	
	public NativeBuffer getData() {return buffer;}
	public void bindTo(B glBuffer) {this.glBuffer = glBuffer;}
	
	@Override
	public void dispose() {
		glBuffer = null;
		buffer.dispose();
		buffer = null;
	}
	
	abstract void write();
}
