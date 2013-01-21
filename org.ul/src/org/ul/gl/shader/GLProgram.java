package org.ul.gl.shader;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import java.util.Collection;
import java.util.HashMap;

import org.ul.gl.math.Matrix4f;
import org.ul.gl.math.Vector3f;
import org.ul.gl.shader.GLVar.ElementType;

public final class GLProgram {	
	private final int id;
	private final GLShader vShader;
	private final GLShader fShader;
	
	private final HashMap<String, GLUniform> uniforms = new HashMap<String, GLUniform>();
	private final HashMap<String, GLAttribute> attributes = new HashMap<String, GLAttribute>();
	
	public int getId() {return id;}

	public GLProgram(GLShader vShader, GLShader fShader) {
		id = gl.glCreateProgram();
		this.vShader = vShader;
		this.fShader = fShader;
		
		link();
	}
	
	private void link() {
		gl.glAttachShader(id, vShader.getId());
		gl.glAttachShader(id, fShader.getId());
		
		gl.glLinkProgram(id);
		if(gl.glGetProgrami(id, GL_LINK_STATUS) == GL_FALSE)
			throw new RuntimeException("Could not link program. Reason: " + gl.glGetProgramInfoLog(id));

		/*
		gl.glValidateProgram(id);
		if(gl.glGetProgrami(id, GL_VALIDATE_STATUS) == GL_FALSE)
			throw new RuntimeException("Could not validate program. Reason: " + gl.glGetProgramInfoLog(id));
		*/
		
		int uNumber = gl.glGetProgrami(id, GL_ACTIVE_UNIFORMS);
		for(int i=0; i<uNumber; ++i) {
			final String uName = gl.glGetActiveUniform(id, i);
			final int uLocation = gl.glGetUniformLocation(id, uName);
			final int uSize = gl.glGetActiveUniformSize(id, i);
			final int uType = gl.glGetActiveUniformType(id, i);
			final GLUniform uniform = new GLUniform(uLocation, uName, uSize, uType);

			uniforms.put(uName, uniform);
		}
		
		int aNumber = gl.glGetProgrami(id, GL_ACTIVE_ATTRIBUTES);
		for(int i=0; i<aNumber; ++i) {
			final String aName = gl.glGetActiveAttrib(id, i);
			final int aLocation = gl.glGetAttribLocation(id, aName);
			final int aSize = gl.glGetActiveAttribSize(id, i);
			final int aType = gl.glGetActiveAttribType(id, i);
			final GLAttribute attribute = new GLAttribute(aLocation, aName, aSize, aType);
			
			attributes.put(aName, attribute);
		}
		
		//clear error (sometimes we get strange errors that are not supposed to exist) !!!
		gl.glGetError();
	}
	

	public void use() {
		gl.glUseProgram(id);
	}
	
	public void dispose() {
		gl.glDetachShader(id, vShader.getId());
		gl.glDetachShader(id, fShader.getId());

		gl.glDeleteProgram(id);
		gl.glUseProgram(GL_NONE);
	}
		
	public Collection<GLAttribute> getAttributes() {
		return attributes.values();
	}
	
	public GLAttribute getAttribute(String name) {
		GLAttribute var = attributes.get(name);
		if(var == null) throw new RuntimeException("No attribute found: " + name);
		return var;
	}
	
	public Collection<GLUniform> getUniforms() {
		return uniforms.values();
	}
	
	public GLUniform getUniform(String name) {
		GLUniform var = uniforms.get(name);
		if(var == null) throw new RuntimeException("No uniform found: " + name);
		return var;
	}
	
	//set uniform values....................................................................
	public void setTextureUnit(GLUniform var, int textureUnit) {
		if(var.getElementType() != ElementType.TEXTURE)
			throw new RuntimeException("Uniform is not of sampler2D type: "+var.getName());
		
		gl.glUniform1i(var.getId(), textureUnit);
	}
	
	public void setUniform(GLUniform var, Matrix4f value) {
		if(var.getElementType() != ElementType.MATRIX || var.getElementSize() != value.diagonalSize)
			throw new RuntimeException("Format exception for uniform: "+var.getName());

		gl.glUniformMatrix4(var.getId(), value.data);
	}
	
	
	public void setUniform(GLUniform var, Vector3f value) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != 3) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform3f(var.getId(), value.data[0], value.data[1], value.data[2]);
	}
	
	public void setUniform(GLUniform var, float value) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != 1)
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform1f(var.getId(), value);
	}
	
	public void setUniform(GLUniform var, float v0, float v1) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != 2) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform2f(var.getId(), v0, v1);
	}
	
	public void setUniform(GLUniform var, float v0, float v1, float v2) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != 3) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform3f(var.getId(), v0, v1, v2);
	}
	
	public void setUniform(GLUniform var, float v0, float v1, float v2, float v3) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != 4) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform4f(var.getId(), v0, v1, v2, v3);
	}
	
	
	public void setUniform(GLUniform var, int value) {
		if(var.getElementType() != ElementType.INT || var.getElementSize() != 1) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform1i(var.getId(), value);
	}
	
	public void setUniform(GLUniform var, int v0, int v1) {
		if(var.getElementType() != ElementType.INT || var.getElementSize() != 2) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform2i(var.getId(), v0, v1);
	}
	
	public void setUniform(GLUniform var, int v0, int v1, int v2) {
		if(var.getElementType() != ElementType.INT || var.getElementSize() != 3) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform3i(var.getId(), v0, v1, v2);
	}
	
	public void setUniform(GLUniform var, int v0, int v1, int v2, int v3) {
		if(var.getElementType() != ElementType.INT || var.getElementSize() != 3) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		gl.glUniform4i(var.getId(), v0, v1, v2, v3);
	}
	
	/*public void setUniform(GLUniform var, float ...value) {
		if(var.getElementType() != ElementType.FLOAT || var.getElementSize() != value.length) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		switch(value.length) {
			case 1: glUniform1f(var.getId(), value[0]); break;
			case 2: glUniform2f(var.getId(), value[0], value[1]); break;
			case 3: glUniform3f(var.getId(), value[0], value[1], value[2]); break;
			case 4: glUniform4f(var.getId(), value[0], value[1], value[2], value[3]); break;
		}
	}
	
	
	public void setUniform(GLUniform var, int ...value) {
		if(var.getElementType() != ElementType.INT || var.getElementSize() != value.length) 
			throw new RuntimeException("Format exception for uniform: "+var.getName());
		
		switch(value.length) {
			case 1: glUniform1i(var.getId(), value[0]); break;
			case 2: glUniform2i(var.getId(), value[0], value[1]); break;
			case 3: glUniform3i(var.getId(), value[0], value[1], value[2]); break;
			case 4: glUniform4i(var.getId(), value[0], value[1], value[2], value[3]); break;
		}
	}*/
}
