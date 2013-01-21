package org.ul.gl.shader;

import static org.ul.spi.SPIgl.*;

public abstract class GLVar {
	public enum ElementType {
		BYTE, SHORT, FLOAT, INT, MATRIX, TEXTURE;
	}
	
	protected final int id;
	protected final Class<?> varType;
	protected final String name;
	
	protected ElementType elementType;
	protected int elementSize;
	protected int vectorSize;
	
	protected GLVar(Class<?> varType, int id, String name, int vectorSize, int glType) {
		this.varType = varType;
		this.id = id;
		this.name = name;
		
		this.vectorSize = vectorSize;
		
		setupType(glType);
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	
	public ElementType getElementType() {return elementType;}
	public int getElementSize() {return elementSize;}
	
	public int getVectorSize() {return vectorSize;}
	
	
	private void setupType(int glType) {
		switch(glType) {
			case GL_FLOAT:		elementType = ElementType.FLOAT;  elementSize = 1; break;
			case GL_FLOAT_VEC2: elementType = ElementType.FLOAT;  elementSize = 2; break;
			case GL_FLOAT_VEC3: elementType = ElementType.FLOAT;  elementSize = 3; break;
			case GL_FLOAT_VEC4: elementType = ElementType.FLOAT;  elementSize = 4; break;
			
			case GL_FLOAT_MAT2: elementType = ElementType.MATRIX; elementSize = 2; break;
			case GL_FLOAT_MAT3: elementType = ElementType.MATRIX; elementSize = 3; break;
			case GL_FLOAT_MAT4: elementType = ElementType.MATRIX; elementSize = 4; break;
			
			case GL_INT:		elementType = ElementType.INT; 	  elementSize = 1; break;
			case GL_INT_VEC2:	elementType = ElementType.INT; 	  elementSize = 2; break;
			case GL_INT_VEC3: 	elementType = ElementType.INT; 	  elementSize = 3; break;
			case GL_INT_VEC4:	elementType = ElementType.INT; 	  elementSize = 4; break;
			
			//case GL_SAMPLER_1D: elementType = ElementType.TEXTURE; 	elementSize = 1; break;
			case GL_SAMPLER_2D: elementType = ElementType.TEXTURE; 	elementSize = 2; break;
			//case GL_SAMPLER_3D: elementType = ElementType.TEXTURE; 	elementSize = 3; break;
		}
	}
	
	@Override
	public String toString() {
		return varType.getSimpleName() + ": id=" + id + ", name=" + name + 
				", elementType=" + elementType + ", elementSize=" + elementSize + ", vectorSize=" + vectorSize;
	}
}
