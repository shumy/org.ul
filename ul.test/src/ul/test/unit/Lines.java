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

public class Lines {
	public static class LineVertex extends CVertexList {
		public static final GLVertexAttribute position = new GLVertexAttribute(0, GLType.FLOAT, 3, false);
		
		public LineVertex(int size) {
			init(size, position);
		}
		
		public LineVertex putPosition(float x, float y, float z) {
			return (LineVertex)put(position, new float[]{x, y, z});
		}
	}
	
	final GLVertexArray entity = new GLVertexArray();
	
	final GLVertexBuffer vertexBuffer = new GLVertexBuffer();
	final GLIndexBuffer indexBuffer = new GLIndexBuffer();
	
	public Lines(GLProgram program) {
		entity.bindAttribute(program.getAttribute("aPosition"), vertexBuffer, LineVertex.position);
		entity.bindIndices(indexBuffer);
	}
	
	public void update() {
		//TODO: create data...
		final LineVertex cVertex = new LineVertex(4);
		final CIndexList cIndex = new CIndexList(6);
		
		cVertex.bindTo(vertexBuffer);
		cIndex.bindTo(indexBuffer);
	}
	
	public void draw(DrawPrimitive primitive) {
		entity.begin();
			entity.draw(DrawPrimitive.LINE_LOOP);
		entity.end();
	}
}
