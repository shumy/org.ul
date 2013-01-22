package org.ul.gl.shader;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

import java.util.Collection;
import java.util.HashMap;

import org.ul.gl.math.ivec2;
import org.ul.gl.math.ivec3;
import org.ul.gl.math.ivec4;
import org.ul.gl.math.mat2;
import org.ul.gl.math.mat3;
import org.ul.gl.math.mat4;
import org.ul.gl.math.vec2;
import org.ul.gl.math.vec3;
import org.ul.gl.math.vec4;
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

	public void setUniform(GLUniform var, mat2 value) {
		gl.glUniformMatrix2(var.getId(), value.data);
	}
	
	public void setUniform(GLUniform var, mat3 value) {
		gl.glUniformMatrix3(var.getId(), value.data);
	}
	
	public void setUniform(GLUniform var, mat4 value) {
		gl.glUniformMatrix4(var.getId(), value.data);
	}
	
	public void setUniform(GLUniform var, float value) {
		gl.glUniform1f(var.getId(), value);
	}
			
	public void setUniform(GLUniform var, vec2 value) {
		gl.glUniform2f(var.getId(), value.data[0], value.data[1]);
	}
	
	public void setUniform(GLUniform var, vec3 value) {
		gl.glUniform3f(var.getId(), value.data[0], value.data[1], value.data[2]);
	}
	
	public void setUniform(GLUniform var, vec4 value) {
		gl.glUniform4f(var.getId(), value.data[0], value.data[1], value.data[2], value.data[3]);
	}
	
	public void setUniform(GLUniform var, int value) {
		gl.glUniform1i(var.getId(), value);
	}

	public void setUniform(GLUniform var, ivec2 value) {
		gl.glUniform2i(var.getId(), value.data[0], value.data[1]);
	}
	
	public void setUniform(GLUniform var, ivec3 value) {
		gl.glUniform3i(var.getId(), value.data[0], value.data[1], value.data[2]);
	}
	
	public void setUniform(GLUniform var, ivec4 value) {
		gl.glUniform4i(var.getId(), value.data[0], value.data[1], value.data[2], value.data[3]);
	}
}
