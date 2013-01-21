package org.ul.gl;

import static org.ul.spi.SPIgl.*;

public enum GLType {
	BYTE(1, GL_BYTE), 
	SHORT(2, GL_SHORT), 
	FLOAT(4, GL_FLOAT), 
	INT(4, GL_INT);
	
	public final int glSize;
	public final int glType;
	
	private GLType(int elementSize, int elementType) {
		this.glSize = elementSize;
		this.glType = elementType;
	}
}
