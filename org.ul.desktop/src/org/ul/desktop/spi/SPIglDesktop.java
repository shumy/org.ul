package org.ul.desktop.spi;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.glu.GLU;
import org.ul.spi.SPIgl;
import org.ul.util.NativeBuffer;

public class SPIglDesktop implements SPIgl {

	@Override
	public String glGetError() {
		int errorValue = GL11.glGetError();
		if(errorValue != GL11.GL_NO_ERROR)
			return GLU.gluErrorString(errorValue);

		return null;
	}
	
	@Override
	public void glEnable(int cap) {
		GL11.glEnable(cap);
	}

	@Override
	public void glCullFace(int mode) {
		GL11.glCullFace(mode);
	}

	@Override
	public void glBlendFunc(int sfactor, int dfactor) {
		GL11.glBlendFunc(sfactor, dfactor);
	}

	@Override
	public void glDepthFunc(int func) {
		GL11.glDepthFunc(func);
	}

	@Override
	public void glClear(int mask) {
		GL11.glClear(mask);
	}

	@Override
	public void glClearColor(float red, float green, float blue, float alpha) {
		GL11.glClearColor(red, green, blue, alpha);
	}

	@Override
	public void glViewport(int x, int y, int width, int height) {
		GL11.glViewport(x, y, width, height);
	}

	@Override
	public void glScissor(int x, int y, int width, int height) {
		GL11.glScissor(x, y, width, height);
	}

	@Override
	public int glCreateShader(int type) {
		return GL20.glCreateShader(type);
	}

	@Override
	public void glShaderSource(int shader, String code) {
		GL20.glShaderSource(shader, code);
	}

	@Override
	public void glCompileShader(int shader) {
		GL20.glCompileShader(shader);
	}

	@Override
	public int glGetShaderi(int shader, int pname) {
		return GL20.glGetShaderi(shader, pname);
	}

	@Override
	public String glGetShaderInfoLog(int shader) {
		return GL20.glGetShaderInfoLog(shader, 256);
	}

	@Override
	public void glDeleteShader(int shader) {
		GL20.glDeleteShader(shader);
	}

	@Override
	public int glCreateProgram() {
		return GL20.glCreateProgram();
	}

	@Override
	public void glUseProgram(int program) {
		GL20.glUseProgram(program);
	}

	@Override
	public void glValidateProgram(int program) {
		GL20.glValidateProgram(program);
	}

	@Override
	public void glLinkProgram(int program) {
		GL20.glLinkProgram(program);
	}

	@Override
	public void glDeleteProgram(int program) {
		GL20.glDeleteProgram(program);
	}

	@Override
	public void glAttachShader(int program, int shader) {
		GL20.glAttachShader(program, shader);
	}

	@Override
	public void glDetachShader(int program, int shader) {
		GL20.glDetachShader(program, shader);
	}

	@Override
	public int glGetProgrami(int program, int pname) {
		return GL20.glGetProgrami(program, pname);
	}

	@Override
	public String glGetProgramInfoLog(int program) {
		return GL20.glGetProgramInfoLog(program, 256);
	}

	@Override
	public String glGetActiveUniform(int program, int index) {
		return GL20.glGetActiveUniform(program, index, 64);
	}

	@Override
	public int glGetUniformLocation(int program, String name) {
		return GL20.glGetUniformLocation(program, name);
	}

	@Override
	public int glGetActiveUniformSize(int program, int index) {
		return GL20.glGetActiveUniformSize(program, index);
	}

	@Override
	public int glGetActiveUniformType(int program, int index) {
		return GL20.glGetActiveUniformType(program, index);
	}

	@Override
	public String glGetActiveAttrib(int program, int index) {
		return GL20.glGetActiveAttrib(program, index, 64);
	}

	@Override
	public int glGetAttribLocation(int program, String name) {
		return GL20.glGetAttribLocation(program, name);
	}

	@Override
	public int glGetActiveAttribSize(int program, int index) {
		return GL20.glGetActiveUniformSize(program, index);
	}

	@Override
	public int glGetActiveAttribType(int program, int index) {
		return GL20.glGetActiveAttribType(program, index);
	}

	@Override
	public void glUniformMatrix4(int location, float[] matrix) {
		final NativeBuffer buffer = new NativeBuffer(64);
		buffer.putFloat(matrix);
		buffer.flip();
			GL20.glUniformMatrix4(location, false, buffer.asFloatBuffer());
		buffer.dispose();
	}

	@Override
	public void glUniform1f(int location, float v0) {
		GL20.glUniform1f(location, v0);
	}

	@Override
	public void glUniform2f(int location, float v0, float v1) {
		GL20.glUniform2f(location, v0, v1);
	}

	@Override
	public void glUniform3f(int location, float v0, float v1, float v2) {
		GL20.glUniform3f(location, v0, v1, v2);
	}
	
	@Override
	public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
		GL20.glUniform4f(location, v0, v1, v2, v3);
	}

	@Override
	public void glUniform1i(int location, int v0) {
		GL20.glUniform1i(location, v0);
	}
	
	@Override
	public void glUniform2i(int location, int v0, int v1) {
		GL20.glUniform2i(location, v0, v1);
	}

	@Override
	public void glUniform3i(int location, int v0, int v1, int v2) {
		GL20.glUniform3i(location, v0, v1, v2);
	}

	@Override
	public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
		GL20.glUniform4i(location, v0, v1, v2, v3);
	}
	
	@Override
	public void glPixelStorei(int pname, int param) {
		GL11.glPixelStorei(pname, param);
	}
	
	@Override
	public int glGenFrameBuffer() {
		return GL30.glGenFramebuffers();
	}
	
	@Override
	public int glCheckFrameBufferStatus(int target) {
		return GL30.glCheckFramebufferStatus(target);
	}
	
	@Override
	public void glBindFrameBuffer(int target, int frame) {
		GL30.glBindFramebuffer(target, frame);
	}
	
	@Override
	public void glFrameBufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		GL30.glFramebufferTexture2D(target, attachment, textarget, texture, level);
	}
	
	@Override
	public void glFrameBufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		GL30.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
	}
	
	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, NativeBuffer pixels) {
		GL11.glReadPixels(x, y, width, height, format, type, pixels.asByteBuffer());
	}
	
	@Override
	public void glDeleteFrameBuffer(int frame) {
		GL30.glDeleteFramebuffers(frame);
	}

	@Override
	public int glGenRenderBuffer() {
		return GL30.glGenRenderbuffers();
	}
	
	@Override
	public void glBindRenderBuffer(int target, int render) {
		GL30.glBindRenderbuffer(target, render);
	}
	
	@Override
	public void glRenderBufferStorage(int target, int format, int width, int height) {
		GL30.glRenderbufferStorage(target, format, width, height);
	}
	
	@Override
	public void glDeleteRenderBuffer(int render) {
		GL30.glDeleteRenderbuffers(render);
	}

	@Override
	public int glGenTexture() {
		return GL11.glGenTextures();
	}

	@Override
	public void glBindTexture(int target, int texture) {
		GL11.glBindTexture(target, texture);
	}

	@Override
	public void glTexParameteri(int target, int pname, int param) {
		GL11.glTexParameteri(target, pname, param);
	}

	@Override
	public void glActiveTexture(int texture) {
		GL13.glActiveTexture(texture);
	}

	@Override
	public void glTexImage2D(int target, int level, int format, int width, int height, int type, NativeBuffer pixels) {
		GL11.glTexImage2D(target, level, format, width, height, 0, format, type, pixels == null?null:pixels.asByteBuffer());
	}
	
	@Override
	public void glDeleteTexture(int texture) {
		GL11.glDeleteTextures(texture);
	}
	
	/*@Override
	public void glGenerateMipmap(int target) {
		GL30.glGenerateMipmap(target);
	}*/

	@Override
	public void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset) {
		GL20.glVertexAttribPointer(index, size, type, normalized, stride, offset);
	}

	@Override
	public void glEnableVertexAttribArray(int index) {
		GL20.glEnableVertexAttribArray(index);
	}

	@Override
	public void glDisableVertexAttribArray(int index) {
		GL20.glDisableVertexAttribArray(index);
	}

	@Override
	public void glDrawElements(int mode, int count, int type, int offset) {
		GL11.glDrawElements(mode, count, type, offset);
	}

	@Override
	public int glGenBuffer() {
		return GL15.glGenBuffers();
	}

	@Override
	public void glBindBuffer(int target, int buffer) {
		GL15.glBindBuffer(target, buffer);
	}

	@Override
	public void glBufferData(int target, NativeBuffer data, int usage) {
		GL15.glBufferData(target, data == null?null:data.asByteBuffer(), usage);
	}

	@Override
	public void glDeleteBuffer(int buffer) {
		GL15.glDeleteBuffers(buffer);
	}

}
