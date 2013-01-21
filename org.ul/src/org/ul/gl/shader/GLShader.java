package org.ul.gl.shader;

import static org.ul.UL.*;
import static org.ul.spi.SPIgl.*;

public class GLShader {
	public enum ShaderType {
		VERTEX(GL_VERTEX_SHADER), FRAGMENT(GL_FRAGMENT_SHADER);
		
		int flag;
		private ShaderType(int flag) {
			this.flag = flag;
		}
	}
	
	private final int id;
	
	public int getId() {return id;}
	
	public GLShader(ShaderType type, String code) {
		id = gl.glCreateShader(type.flag);
		if(id == 0)
			throw new RuntimeException("Shader type not supported: " + type);

		gl.glShaderSource(id, code);
		gl.glCompileShader(id);
		if(gl.glGetShaderi(id, GL_COMPILE_STATUS) == GL_FALSE)
			throw new RuntimeException("Compilation error for shader ("+type.name()+"). Reason: "+ gl.glGetShaderInfoLog(id));
	}
	
	public void dispose() {
		gl.glDeleteShader(id);
	}
}
