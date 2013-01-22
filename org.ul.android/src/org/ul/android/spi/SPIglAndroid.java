package org.ul.android.spi;

import android.opengl.GLES20;
import android.opengl.GLU;

import org.ul.spi.SPIgl;
import org.ul.util.NativeBuffer;

public class SPIglAndroid implements SPIgl {
	
	@Override
	public String glGetError() {
		int errorValue = GLES20.glGetError();
		if(errorValue != GLES20.GL_NO_ERROR)
			return GLU.gluErrorString(errorValue);

		return null;
	}
	
	private String convert(byte[] value) {
		int lenght = -1;
		byte c = 0;
		do {
			lenght++;
			c = value[lenght];
		} while(c != 0);
		return new String(value, 0, lenght);
	}

	@Override
	public void glEnable(int cap) {
		GLES20.glEnable(cap);
	}

	@Override
	public void glCullFace(int mode) {
		GLES20.glCullFace(mode);
	}

	@Override
	public void glBlendFunc(int sfactor, int dfactor) {
		GLES20.glBlendFunc(sfactor, dfactor);
	}

	@Override
	public void glDepthFunc(int func) {
		GLES20.glDepthFunc(func);
	}

	@Override
	public void glClear(int mask) {
		GLES20.glClear(mask);
	}

	@Override
	public void glClearColor(float red, float green, float blue, float alpha) {
		GLES20.glClearColor(red, green, blue, alpha);
	}

	@Override
	public void glViewport(int x, int y, int width, int height) {
		GLES20.glViewport(x, y, width, height);
	}

	@Override
	public void glScissor(int x, int y, int width, int height) {
		GLES20.glScissor(x, y, width, height);
	}

	@Override
	public int glCreateShader(int type) {
		return GLES20.glCreateShader(type);
	}

	@Override
	public void glShaderSource(int shader, String code) {
		GLES20.glShaderSource(shader, code);
	}

	@Override
	public void glCompileShader(int shader) {
		GLES20.glCompileShader(shader);
	}

	@Override
	public int glGetShaderi(int shader, int pname) {
		final int[] x = new int[1];
		GLES20.glGetShaderiv(shader, pname, x, 0);
		return x[0];
	}

	@Override
	public String glGetShaderInfoLog(int shader) {
		return GLES20.glGetShaderInfoLog(shader);
	}

	@Override
	public void glDeleteShader(int shader) {
		GLES20.glDeleteShader(shader);
	}

	@Override
	public int glCreateProgram() {
		return GLES20.glCreateProgram();
	}

	@Override
	public void glUseProgram(int program) {
		GLES20.glUseProgram(program);
	}

	@Override
	public void glValidateProgram(int program) {
		GLES20.glValidateProgram(program);
	}

	@Override
	public void glLinkProgram(int program) {
		GLES20.glLinkProgram(program);
	}

	@Override
	public void glDeleteProgram(int program) {
		GLES20.glDeleteProgram(program);
	}

	@Override
	public void glAttachShader(int program, int shader) {
		GLES20.glAttachShader(program, shader);
	}

	@Override
	public void glDetachShader(int program, int shader) {
		GLES20.glDetachShader(program, shader);
	}

	@Override
	public int glGetProgrami(int program, int pname) {
		final int[] p = new int[1];
		GLES20.glGetProgramiv(program, pname, p, 0);
		return p[0];
	}

	@Override
	public String glGetProgramInfoLog(int program) {
		return GLES20.glGetProgramInfoLog(program);
	}

	@Override
	public int glGetUniformLocation(int program, String name) {
		return GLES20.glGetUniformLocation(program, name);
	}

	@Override
	public String glGetActiveUniform(int program, int index) {
		final byte[] name = new byte[64];
		final int[] ignore = new int[1];
		GLES20.glGetActiveUniform(program, index, 128, ignore, 0, ignore, 0, ignore, 0, name, 0);
		return convert(name);
	}
	
	@Override
	public int glGetActiveUniformType(int program, int index) {
		final int[] type = new int[1];
		final int[] ignore = new int[1];
		final byte[] ignoreb = new byte[1];
		GLES20.glGetActiveUniform(program, index, 0, ignore, 0, ignore, 0, type, 0, ignoreb, 0);
		return type[0];
	}
	
	@Override
	public int glGetActiveUniformSize(int program, int index) {
		final int[] size = new int[1];
		final int[] ignore = new int[1];
		final byte[] ignoreb = new byte[1];
		GLES20.glGetActiveUniform(program, index, 0, ignore, 0, size, 0, ignore, 0, ignoreb, 0);
		return size[0];
	}

	@Override
	public int glGetAttribLocation(int program, String name) {
		return GLES20.glGetAttribLocation(program, name);
	}

	@Override
	public String glGetActiveAttrib(int program, int index) {
		final byte[] name = new byte[64];
		final int[] ignore = new int[1];
		GLES20.glGetActiveAttrib(program, index, 64, ignore, 0, ignore, 0, ignore, 0, name, 0);
		return convert(name);
	}
	
	@Override
	public int glGetActiveAttribType(int program, int index) {
		final int[] type = new int[1];
		final int[] ignore = new int[1];
		final byte[] ignoreb = new byte[1];
		GLES20.glGetActiveAttrib(program, index, 0, ignore, 0, ignore, 0, type, 0, ignoreb, 0);
		return type[0];
	}
	
	@Override
	public int glGetActiveAttribSize(int program, int index) {
		final int[] size = new int[1];
		final int[] ignore = new int[1];
		final byte[] ignoreb = new byte[1];
		GLES20.glGetActiveAttrib(program, index, 0, ignore, 0, size, 0, ignore, 0, ignoreb, 0);
		return size[0];
	}
	
	@Override
	public void glUniformMatrix2(int location, float[] matrix) {
		GLES20.glUniformMatrix2fv(location, 1, false, matrix, 0);
	}

	@Override
	public void glUniformMatrix3(int location, float[] matrix) {
		GLES20.glUniformMatrix3fv(location, 1, false, matrix, 0);
	}
	
	@Override
	public void glUniformMatrix4(int location, float[] matrix) {
		GLES20.glUniformMatrix4fv(location, 1, false, matrix, 0);
	}

	@Override
	public void glUniform1f(int location, float v0) {
		GLES20.glUniform1f(location, v0);
	}

	@Override
	public void glUniform2f(int location, float v0, float v1) {
		GLES20.glUniform2f(location, v0, v1);
	}

	@Override
	public void glUniform3f(int location, float v0, float v1, float v2) {
		GLES20.glUniform3f(location, v0, v1, v2);
	}
	
	@Override
	public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
		GLES20.glUniform4f(location, v0, v1, v2, v3);
	}
	
	@Override
	public void glUniform1i(int location, int v0) {
		GLES20.glUniform1i(location, v0);
	}

	@Override
	public void glUniform2i(int location, int v0, int v1) {
		GLES20.glUniform2i(location, v0, v1);
	}

	@Override
	public void glUniform3i(int location, int v0, int v1, int v2) {
		GLES20.glUniform3i(location, v0, v1, v2);
	}

	@Override
	public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
		GLES20.glUniform4i(location, v0, v1, v2, v3);
	}
	
	@Override
	public void glPixelStorei(int pname, int param) {
		GLES20.glPixelStorei(pname, param);
	}
	
	@Override
	public int glGenFrameBuffer() {
		final int[] f = new int[1];
		GLES20.glGenFramebuffers(1, f, 0);
		return f[0];
	}
	
	@Override
	public void glBindFrameBuffer(int target, int frame) {
		GLES20.glBindFramebuffer(target, frame);
	}
	
	@Override
	public int glCheckFrameBufferStatus(int target) {
		return GLES20.glCheckFramebufferStatus(target);
	}
	
	@Override
	public void glFrameBufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		GLES20.glFramebufferTexture2D(target, attachment, textarget, texture, level);
	}
	
	@Override
	public void glFrameBufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		GLES20.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
	}
	
	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, NativeBuffer pixels) {
		GLES20.glReadPixels(x, y, width, height, format, type, pixels.asByteBuffer());
	}
	
	@Override
	public void glDeleteFrameBuffer(int frame) {
		GLES20.glDeleteFramebuffers(1, new int[]{frame}, 0);
	}

	@Override
	public int glGenRenderBuffer() {
		final int[] f = new int[1];
		GLES20.glGenRenderbuffers(1, f, 0);
		return f[0];
	}
	
	@Override
	public void glBindRenderBuffer(int target, int render) {
		GLES20.glBindRenderbuffer(target, render);
	}
	
	@Override
	public void glRenderBufferStorage(int target, int format, int width, int height) {
		GLES20.glRenderbufferStorage(target, format, width, height);
	}
	
	@Override
	public void glDeleteRenderBuffer(int render) {
		GLES20.glDeleteRenderbuffers(1, new int[]{render}, 0);
	}
	
	@Override
	public int glGenTexture() {
		final int[] t = new int[1];
		GLES20.glGenTextures(1, t, 0);
		return t[0];
	}

	@Override
	public void glBindTexture(int target, int texture) {
		GLES20.glBindTexture(target, texture);
	}

	@Override
	public void glTexParameteri(int target, int pname, int param) {
		GLES20.glTexParameteri(target, pname, param);
	}

	@Override
	public void glActiveTexture(int texture) {
		GLES20.glActiveTexture(texture);
	}

	@Override
	public void glTexImage2D(int target, int level, int format, int width, int height, int type, NativeBuffer pixels) {
		GLES20.glTexImage2D(target, level, format, width, height, 0, format, type, pixels == null?null:pixels.asByteBuffer());
	}
	
	@Override
	public void glDeleteTexture(int texture) {
		GLES20.glDeleteTextures(1, new int[]{texture}, 0);
	}

	/*@Override
	public void glGenerateMipmap(int target) {
		GLES20.glGenerateMipmap(target);
	}*/
	
	@Override
	public void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset) {
		GLES20.glVertexAttribPointer(index, size, type, normalized, stride, offset);
	}

	@Override
	public void glEnableVertexAttribArray(int index) {
		GLES20.glEnableVertexAttribArray(index);
	}

	@Override
	public void glDisableVertexAttribArray(int index) {
		GLES20.glDisableVertexAttribArray(index);
	}

	@Override
	public void glDrawElements(int mode, int count, int type, int offset) {
		GLES20.glDrawElements(mode, count, type, offset);
	}

	@Override
	public int glGenBuffer() {
		final int[] b = new int[1];
		GLES20.glGenBuffers(1, b, 0);
		return b[0];
	}

	@Override
	public void glBindBuffer(int target, int buffer) {
		GLES20.glBindBuffer(target, buffer);
	}

	@Override
	public void glBufferData(int target, NativeBuffer data, int usage) {
		int size = data == null?0:data.getLimit();
		GLES20.glBufferData(target, size, data == null?null:data.asByteBuffer(), usage);
	}

	@Override
	public void glDeleteBuffer(int buffer) {
		GLES20.glDeleteBuffers(1, new int[]{buffer}, 0);
	}

}
