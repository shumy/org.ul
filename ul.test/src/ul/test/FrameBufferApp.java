package ul.test;

import org.ul.IApplication;
import org.ul.gl.GL;
import org.ul.gl.GLFormat;
import org.ul.gl.buffer.client.CTexture;
import org.ul.gl.buffer.tex.GLFrameBuffer;
import org.ul.gl.buffer.tex.GLRenderBuffer;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.gl.math.Matrix4f;
import org.ul.gl.math.Vector3f;
import org.ul.gl.shader.GLProgram;
import org.ul.gl.shader.GLShader;
import org.ul.gl.shader.GLUniform;
import org.ul.gl.shader.GLShader.ShaderType;
import org.ul.gl.view.GLView;
import org.ul.vfs.Resource;

import ul.test.unit.SimpleQuad;

public class FrameBufferApp implements IApplication {
	GLView scene;
	
	GLProgram program1;
	GLProgram program2;
	
	
	GLUniform uModelMatrix_p1;
	GLUniform uViewMatrix_p1;
	GLUniform uProjectionMatrix_p1;
	
	GLUniform uModelMatrix_p2;
	GLUniform uViewMatrix_p2;
	GLUniform uProjectionMatrix_p2;
	GLUniform uTime_p2;
	GLUniform uTexture1_p2;
	GLUniform uTexture2_p2;
	
	GLTextureBuffer renderTexture;
	
	SimpleQuad quad;

	Matrix4f modelMatrix;
	Matrix4f viewMatrix;
	Matrix4f projectionMatrix;
	
	GLFrameBuffer fbo;
	
	@Override
	public void init() {
		GL.init();
		
		scene = new GLView();
		
		modelMatrix = new Matrix4f().setIdentity();
		viewMatrix = new Matrix4f().setIdentity();
		projectionMatrix = new Matrix4f().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
		GLShader vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/sun.vert"));
		GLShader fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/digit.frag"));
		program1 = new GLProgram(vShader, fShader);
		
		uModelMatrix_p1 		= program1.getUniform("uModelMatrix");
		uViewMatrix_p1			= program1.getUniform("uViewMatrix");
		uProjectionMatrix_p1	= program1.getUniform("uProjectionMatrix");
		
		vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/texture.vert"));
		fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/texture.frag"));
		program2 = new GLProgram(vShader, fShader);
		
		uTime_p2 = program2.getUniform("uTime");
		uTexture1_p2 = program2.getUniform("uTexture1");
		uTexture2_p2 = program2.getUniform("uTexture2");
		
		uModelMatrix_p2 		= program2.getUniform("uModelMatrix");
		uViewMatrix_p2			= program2.getUniform("uViewMatrix");
		uProjectionMatrix_p2	= program2.getUniform("uProjectionMatrix");
		
		//------------------------------------------------------------------------------------------------------------------
		program1.use();
		viewMatrix.setTranslation(new Vector3f(0f, 0f, -1f));
		
		quad = new SimpleQuad(program1, -0.8f, 0.8f, 0.2f);
		
		
		renderTexture = new GLTextureBuffer(GL.width, GL.height, GLFormat.RGB);
		renderTexture.bindToUnit(1);
		
		final CTexture cTexture = Resource.readTexture("texture2.png");
		final GLTextureBuffer texture2 = new GLTextureBuffer();
		texture2.unpack(cTexture);
		texture2.bindToUnit(2);
		
		
		final GLRenderBuffer renderBuffer = new GLRenderBuffer(GL.width, GL.height, GLFormat.RGB);
		//final GLTextureBuffer renderBuffer = new GLTextureBuffer(GL.width, GL.height, GLFormat.RGB);
		
		fbo = new GLFrameBuffer();
		fbo.attach(renderBuffer);
		
	}
	
	@Override
	public void resize() {
		scene.setSize(GL.width, GL.height);
	}
	
	@Override
	public void pause() {}
	
	@Override
	public void resume() {}
	
	@Override
	public void dispose() {
		program1.dispose();
		program2.dispose();
	}

	
	int index = 0;
	float angle = 45f;
	long lastTime;
	
	final Vector3f translateV = new Vector3f(1.0f, 0f, 0f);
	final Vector3f scaleV = new Vector3f(2f, 1f, 1f);

	
	final Matrix4f translateM = new Matrix4f().setTranslation(translateV);
	final Matrix4f scaleM = new Matrix4f().setScale(scaleV);
	final Matrix4f rotateM = new Matrix4f();
	
	final Matrix4f tmpM = new Matrix4f();
	
	@Override
	public void update() {
		angle += 1.0f;
		rotateM.setRotation(new Vector3f(0f, 0f, 1f), angle);

		index++;
	}
	
	@Override
	public void render() {
		program1.use();
		program1.setUniform(uModelMatrix_p1, modelMatrix);
		program1.setUniform(uViewMatrix_p1, viewMatrix);
		program1.setUniform(uProjectionMatrix_p1, projectionMatrix);
		
		final CTexture cTexture = new CTexture(GL.width, GL.height, GLFormat.RGB);
		fbo.begin();
			scene.use();
			quad.draw();
			fbo.pack(cTexture);
		fbo.end();
		
		renderTexture.unpack(cTexture);
		cTexture.dispose();
		
		program2.use();
		program2.setUniform(uTime_p2, index/100.0f);
		program2.setTextureUnit(uTexture1_p2, 1);
		program2.setTextureUnit(uTexture2_p2, 2);
		
		program2.setUniform(uModelMatrix_p2, modelMatrix);
		program2.setUniform(uViewMatrix_p2, viewMatrix);
		program2.setUniform(uProjectionMatrix_p2, projectionMatrix);
		
		scene.use();
		quad.draw();
	}
	
}
