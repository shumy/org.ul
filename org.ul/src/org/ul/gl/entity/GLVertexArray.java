package org.ul.gl.entity;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import java.util.HashSet;

import org.ul.gl.buffer.GLIndexBuffer;
import org.ul.gl.buffer.GLVertexBuffer;
import org.ul.gl.buffer.AGLBuffer.Target;
import org.ul.gl.shader.GLAttribute;

public class GLVertexArray {
	public enum DrawPrimitive {
		POINTS(GL_POINTS),
		
		LINES(GL_LINES),
		LINE_LOOP(GL_LINE_LOOP),
		LINE_STRIP(GL_LINE_STRIP),
		
		TRIANGLES(GL_TRIANGLES),
		TRIANGLE_STRIP(GL_TRIANGLE_STRIP),
		TRIANGLE_FAN(GL_TRIANGLE_FAN);

		int flag;
		private DrawPrimitive(int flag) {
			this.flag = flag;
		}
	}
	
	class Bind {
		final GLAttribute programAttrib;
		final GLVertexAttribute vertexAttrib;
		final GLVertexBuffer buffer;
		
		public Bind(GLAttribute programAttrib, GLVertexAttribute vertexAttrib, GLVertexBuffer buffer) {
			this.programAttrib = programAttrib;
			this.vertexAttrib = vertexAttrib;
			this.buffer = buffer;
		}
	}
	
	private GLIndexBuffer indexBuffer;
	private final HashSet<Bind> binds = new HashSet<GLVertexArray.Bind>();
	
	
	public void bindIndices(GLIndexBuffer buffer) {
		if(buffer.getTarget() != Target.INDEX)
			throw new RuntimeException("Buffer format exception, must be with target: " + Target.INDEX.name());
		
		indexBuffer = buffer;
	}
	
	public void bindAttribute(GLAttribute programAttrib, GLVertexBuffer buffer, GLVertexAttribute vertexAttrib) {
		if(programAttrib != null) {
			/*if(programAttrib.getElementType() != buffer.getElementType() || var.getElementSize() != buffer.getElementSize())
				throw new RuntimeException("Format exception for uniform: "+var.getName());*/
			
			binds.add(new Bind(programAttrib, vertexAttrib, buffer));
		}
	}
	
	public void enableAttribute(GLAttribute var, boolean enable) {
	}
	
	public void begin() {
		for(Bind bind: binds) {
			final GLAttribute var = bind.programAttrib;
			final GLVertexAttribute va = bind.vertexAttrib;
			final GLVertexBuffer buffer = bind.buffer;
			
			gl.glBindBuffer(GL_ARRAY_BUFFER, buffer.getId());
			gl.glEnableVertexAttribArray(var.getId());
			gl.glVertexAttribPointer(var.getId(), var.getElementSize(), va.type.glType, va.normalize, buffer.getStride(), va.offset);
		}
		
		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexBuffer.getId());
	}
	
	public void end() {
		gl.glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, GL_NONE);
		gl.glBindBuffer(GL_ARRAY_BUFFER, GL_NONE);
		
		for(Bind bind: binds)
			gl.glDisableVertexAttribArray(bind.programAttrib.getId());
	}
	
	public void dispose() {
	}
	
	public void draw(DrawPrimitive primitive) {
		gl.glDrawElements(primitive.flag, indexBuffer.getSize(), GL_UNSIGNED_INT, 0);
	}
}
