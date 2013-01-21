package ul.test.unit;

import org.ul.gl.GLType;
import org.ul.gl.buffer.GLIndexBuffer;
import org.ul.gl.buffer.GLVertexBuffer;
import org.ul.gl.buffer.client.CIndexList;
import org.ul.gl.buffer.client.CVertexList;
import org.ul.gl.entity.GLVertexArray;
import org.ul.gl.entity.GLVertexAttribute;
import org.ul.gl.entity.GLVertexArray.DrawPrimitive;
import org.ul.gl.shader.GLProgram;

public class Square {
	public static class QuadVertex extends CVertexList {
		public static final GLVertexAttribute position = new GLVertexAttribute(0, GLType.FLOAT, 3, false);
		
		public QuadVertex(int size) {
			init(size, position);
		}
		
		public QuadVertex putPosition(float x, float y, float z) {
			return (QuadVertex)put(position, new float[]{x, y, z});
		}
	}
	
	final GLVertexArray entity = new GLVertexArray();

	final QuadVertex cVertex = new QuadVertex(4);
	final CIndexList cIndex = new CIndexList(6);
	
	final GLVertexBuffer vertexBuffer = new GLVertexBuffer();
	final GLIndexBuffer indexBuffer = new GLIndexBuffer();
	
	public Square(GLProgram program, float x, float y, float width, float height) {
		cVertex.bindTo(vertexBuffer);
		cVertex.
			putPosition(x, 			y, 				0f).
			putPosition(x, 			y - height, 	0f).
			putPosition(x + width, 	y - height, 	0f).
			putPosition(x + width, 	y, 				0f).
		write();
		
		cIndex.bindTo(indexBuffer);
		cIndex.put(
			0, 1, 2,
			2, 3, 0
		).write();
		
		entity.bindAttribute(program.getAttribute("aPosition"), vertexBuffer, QuadVertex.position);
		entity.bindIndices(indexBuffer);
	}
	
	public void draw(DrawPrimitive primitive) {
		entity.begin();
			entity.draw(primitive);
		entity.end();
	}
}
