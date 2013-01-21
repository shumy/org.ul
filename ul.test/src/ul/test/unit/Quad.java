package ul.test.unit;

import org.ul.gl.GLType;
import org.ul.gl.buffer.GLIndexBuffer;
import org.ul.gl.buffer.GLVertexBuffer;
import org.ul.gl.buffer.client.CIndexList;
import org.ul.gl.buffer.client.CVertexList;
import org.ul.gl.entity.GLVertexArray;
import org.ul.gl.entity.GLVertexAttribute;
import org.ul.gl.entity.GLVertexArray.DrawPrimitive;
import org.ul.gl.shader.GLAttribute;
import org.ul.gl.shader.GLProgram;

public class Quad {
	public static class QuadVertex extends CVertexList {
		public static final GLVertexAttribute position = new GLVertexAttribute(0, GLType.FLOAT, 3, false);
		public static final GLVertexAttribute texCoord = new GLVertexAttribute(position.stride, GLType.INT, 2, false);
		
		public QuadVertex(int size) {
			init(size, position, texCoord);
		}
		
		public QuadVertex putPosition(float x, float y, float z) {
			return (QuadVertex)put(position, new float[]{x, y, z});
		}
		
		public QuadVertex putTexCoord(int t, int s) {
			return (QuadVertex)put(texCoord, new int[]{t, s});
		}
	}
	
	final GLVertexArray entity = new GLVertexArray();

	final QuadVertex cVertex = new QuadVertex(4);
	final CIndexList cIndex = new CIndexList(6);
	
	final GLVertexBuffer vertexBuffer = new GLVertexBuffer();
	final GLIndexBuffer indexBuffer = new GLIndexBuffer();
	
	public Quad(GLProgram program, float x, float y, float z) {
		final GLAttribute aTextureCoord = program.getAttribute("aTextureCoord");

		cVertex.bindTo(vertexBuffer);
		cVertex.
			putPosition(x, 		y, 		z).
			putTexCoord(0, 0).
			
			putPosition(x, 		y - 1f, z).
			putTexCoord(0, 1).
			
			putPosition(x + 1f, y - 1f, z).
			putTexCoord(1, 1).
			
			putPosition(x + 1f, y, 		z).
			putTexCoord(1, 0).
		write();
		
		/*quadVertex.
			use(QuadVertexBuffer.texCoord).
			putTexCoord(0, 0).
			putTexCoord(0, 1).
			putTexCoord(1, 1).
			putTexCoord(1, 0).
		end();*/
		//quadVertex.load();
		
		cIndex.bindTo(indexBuffer);
		cIndex.put(
			0, 1, 2,
			2, 3, 0
		).write();
		
		entity.bindAttribute(program.getAttribute("aPosition"), vertexBuffer, QuadVertex.position);
		entity.bindAttribute(aTextureCoord, vertexBuffer, QuadVertex.texCoord);
		entity.bindIndices(indexBuffer);
	}
	
	public void draw() {
		entity.begin();
			entity.draw(DrawPrimitive.TRIANGLES);
		entity.end();
	}
}
