package org.ul.spi;

import org.ul.util.NativeBuffer;

public interface SPIgl {
	public static final int GL_NONE 				= 0;
	
	public static final int GL_FALSE 				= 0;
	public static final int GL_TRUE 				= 1;
	
	public static final int GL_FLOAT 				= 5126;
	public static final int GL_FLOAT_VEC2 			= 35664;
	public static final int GL_FLOAT_VEC3 			= 35665;
	public static final int GL_FLOAT_VEC4 			= 35666;
	
	public static final int GL_FLOAT_MAT2 			= 35674;
	public static final int GL_FLOAT_MAT3 			= 35675;
	public static final int GL_FLOAT_MAT4 			= 35676;
	
	public static final int GL_INT 					= 5124;
	public static final int GL_UNSIGNED_INT 		= 5125;
	public static final int GL_INT_VEC2 			= 35667;
	public static final int GL_INT_VEC3 			= 35668;
	public static final int GL_INT_VEC4 			= 35669;
	
	public static final int GL_BYTE 				= 5120;
	public static final int GL_UNSIGNED_BYTE 		= 5121;
	public static final int GL_SHORT 				= 5122;
	public static final int GL_UNSIGNED_SHORT 		= 5123;
	
	
	public static final int GL_SAMPLER_2D 			= 35678;

	
	public static final int GL_SCISSOR_TEST 		= 3089;
	public static final int GL_DEPTH_TEST 			= 2929;
	
	public static final int GL_BLEND 				= 3042;
	public static final int GL_SRC_ALPHA 			= 770;
	public static final int GL_ONE_MINUS_SRC_ALPHA 	= 771;
	
	public static final int GL_CULL_FACE 			= 2884;
	public static final int GL_FRONT 				= 1028;
	public static final int GL_BACK 				= 1029;
	
	public static final int GL_LESS 				= 513;
	public static final int GL_EQUAL 				= 514;
	public static final int GL_LEQUAL 				= 515;
	public static final int GL_GREATER 				= 516;
	public static final int GL_NOTEQUAL 			= 517;
	public static final int GL_GEQUAL 				= 518;
	
	
	public static final int GL_DEPTH_BUFFER_BIT 	= 256;
	public static final int GL_COLOR_BUFFER_BIT 	= 16384;
	
	
	public static final int GL_FRAGMENT_SHADER 		= 35632;
	public static final int GL_VERTEX_SHADER 		= 35633;
	public static final int GL_COMPILE_STATUS 		= 35713;
	
	public static final int GL_LINK_STATUS 			= 35714;
	public static final int GL_VALIDATE_STATUS 		= 35715;
	public static final int GL_ACTIVE_UNIFORMS 		= 35718;
	public static final int GL_ACTIVE_ATTRIBUTES 	= 35721;
	
	public static final int GL_TEXTURE_2D 			= 3553;
	public static final int GL_TEXTURE0 			= 33984;
	
	
	public static final int GL_DEPTH_COMPONENT 		= 6402;
	public static final int GL_ALPHA 				= 6406;  
	public static final int GL_RGB 					= 6407;  
	public static final int GL_RGBA 				= 6408;  
	public static final int GL_LUMINANCE 			= 6409;  
	public static final int GL_LUMINANCE_ALPHA 		= 6410;
	
	public static final int GL_TEXTURE_WRAP_S 			= 10242;
	public static final int GL_TEXTURE_WRAP_T 			= 10243;
	public static final int GL_REPEAT 					= 10497;
	public static final int GL_CLAMP_TO_EDGE 			= 33071;
	public static final int GL_MIRRORED_REPEAT 			= 33648;
	
	public static final int GL_TEXTURE_MAG_FILTER 		= 10240;
	public static final int GL_TEXTURE_MIN_FILTER 		= 10241;
	public static final int GL_NEAREST 					= 9728;
	public static final int GL_LINEAR 					= 9729;
	public static final int GL_NEAREST_MIPMAP_NEAREST 	= 9984;
	public static final int GL_LINEAR_MIPMAP_NEAREST 	= 9985;
	public static final int GL_NEAREST_MIPMAP_LINEAR 	= 9986;
	public static final int GL_LINEAR_MIPMAP_LINEAR 	= 9987;
	
	public static final int GL_ARRAY_BUFFER 			= 34962;
	public static final int GL_ELEMENT_ARRAY_BUFFER 	= 34963;
	public static final int GL_FRAMEBUFFER 				= 36160;
	public static final int GL_RENDERBUFFER 			= 36161;
	
	public static final int GL_FRAMEBUFFER_COMPLETE 						= 36053;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT 			= 36054;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT 	= 36055;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS 			= 36057;
	public static final int GL_FRAMEBUFFER_UNSUPPORTED 						= 36061;
	
	public static final int GL_MAX_RENDERBUFFER_SIZE 	= 34024;
	public static final int GL_RGBA4 					= 32854;
	public static final int GL_RGB5_A1 					= 32855;

	public static final int GL_DEPTH_COMPONENT16 		= 33189;
	public static final int GL_STENCIL_INDEX8 			= 36168;
	
	public static final int GL_UNSIGNED_SHORT_4_4_4_4 	= 32819;
	public static final int GL_UNSIGNED_SHORT_5_5_5_1 	= 32820;
	
	public static final int GL_COLOR_ATTACHMENT0 		= 36064;
	public static final int GL_DEPTH_ATTACHMENT 		= 36096;
	public static final int GL_STENCIL_ATTACHMENT 		= 36128;
	
	public static final int GL_POINTS 					= 0;
	public static final int GL_LINES 					= 1;
	public static final int GL_LINE_LOOP 				= 2;
	public static final int GL_LINE_STRIP 				= 3;
	public static final int GL_TRIANGLES 				= 4;
	public static final int GL_TRIANGLE_STRIP 			= 5;
	public static final int GL_TRIANGLE_FAN 			= 6;
	
	
	public static final int GL_STREAM_DRAW 				= 35040;
	public static final int GL_STATIC_DRAW 				= 35044;
	public static final int GL_DYNAMIC_DRAW 			= 35048;
	  
	
	public static final int GL_UNPACK_ALIGNMENT 		= 3317;
	public static final int GL_PACK_ALIGNMENT 			= 3333;
	
	String glGetError();
	
	void glEnable(int cap);
	void glCullFace(int mode);
	void glBlendFunc(int sfactor, int dfactor);
	void glDepthFunc(int func);
	
	void glClear(int mask);
	void glClearColor(float red, float green, float blue, float alpha);
	
	void glViewport(int x, int y, int width, int height);
	void glScissor(int x, int y, int width, int height);
	
	int glCreateShader(int type);
	void glShaderSource(int shader, String code);
	void glCompileShader(int shader);
	int glGetShaderi(int shader, int pname);
	String glGetShaderInfoLog(int shader);
	void glDeleteShader(int shader);
	
	int glCreateProgram();
	void glUseProgram(int program);
	void glValidateProgram(int program);
	void glLinkProgram(int program);
	void glAttachShader(int program, int shader);
	void glDetachShader(int program, int shader);
	int glGetProgrami(int program, int pname);
	String glGetProgramInfoLog(int program);
	void glDeleteProgram(int program);
	
	String glGetActiveUniform(int program, int index);
	int glGetUniformLocation(int program, String name);
	int glGetActiveUniformSize(int program, int index);
	int glGetActiveUniformType(int program, int index);
	
	String glGetActiveAttrib(int program, int index);
	int glGetAttribLocation(int program, String name);
	int glGetActiveAttribSize(int program, int index);
	int glGetActiveAttribType(int program, int index);
	
	void glUniform1i(int location, int v0);
	void glUniform2i(int location, int v0, int v1);
	void glUniform3i(int location, int v0, int v1, int v2);
	void glUniform4i(int location, int v0, int v1, int v2, int v3);
	void glUniform1f(int location, float v0);
	void glUniform2f(int location, float v0, float v1);
	void glUniform3f(int location, float v0, float v1, float v2);
	void glUniform4f(int location, float v0, float v1, float v2, float v3);
	void glUniformMatrix2(int location, float[] matrix);
	void glUniformMatrix3(int location, float[] matrix);
	void glUniformMatrix4(int location, float[] matrix);
	
	void glPixelStorei(int pname, int param);
	
	int glGenFrameBuffer();
	int glCheckFrameBufferStatus(int target);
	void glBindFrameBuffer(int target, int frame);
	void glFrameBufferTexture2D(int target, int attachment, int textarget, int texture, int level);
	void glFrameBufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
	void glReadPixels(int x, int y, int width, int height, int format, int type, NativeBuffer pixels);
	void glDeleteFrameBuffer(int frame);
	
	int glGenRenderBuffer();
	void glBindRenderBuffer(int target, int render);
	void glRenderBufferStorage(int target, int format, int width, int height);
	void glDeleteRenderBuffer(int texture);
	
	int glGenTexture();
	void glBindTexture(int target, int texture);
	void glTexParameteri(int target, int pname, int param);
	void glActiveTexture(int texture);
	void glTexImage2D(int target, int level, int format, int width, int height, int type, NativeBuffer pixels);
	//void glGenerateMipmap(int target);
	void glDeleteTexture(int texture);
	
	void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset);
	void glEnableVertexAttribArray(int index);
	void glDisableVertexAttribArray(int index);
	void glDrawElements(int mode, int count, int type, int offset);
	
	int glGenBuffer();
	void glBindBuffer(int target, int buffer);
	void glBufferData(int target, NativeBuffer data, int usage);
	void glDeleteBuffer(int buffer);
}
