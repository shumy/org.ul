package ul.test;

import static java.lang.System.out;

import org.ul.IApplication;
import org.ul.gl.GL;
import org.ul.gl.buffer.client.CTexture;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.gl.math.Matrix4f;
import org.ul.gl.math.Vector3f;
import org.ul.gl.shader.GLAttribute;
import org.ul.gl.shader.GLProgram;
import org.ul.gl.shader.GLShader;
import org.ul.gl.shader.GLUniform;
import org.ul.gl.shader.GLShader.ShaderType;
import org.ul.gl.view.GLView;
import org.ul.gl.view.GLView.ClearFlag;
import org.ul.vfs.Resource;

import ul.test.unit.Quad;


public class AppExample implements IApplication {	
	GLView scene;
	GLView hud;
	
	GLShader vShader;
	GLShader fShader;
	GLProgram program;
	
	GLUniform uTime;
	GLUniform uTexture1;
	GLUniform uTexture2;
	
	GLUniform uModelMatrix;
	GLUniform uViewMatrix;
	GLUniform uProjectionMatrix;
	
	Quad quad1;
	Quad quad2;	

	Matrix4f modelMatrix;
	Matrix4f viewMatrix;
	Matrix4f projectionMatrix;
	
	public void glConfig() {
		GL.init();
		
		scene = new GLView();
		scene.setSize(GL.width, GL.height);
		
		hud = new GLView();
		hud.setSize(GL.width-400, GL.height-400);
		hud.setPosition(200, 200);
		hud.setClearFlags(ClearFlag.DEPTH);
	}
	
	@Override
	public void init() {
		glConfig();
		
		modelMatrix = new Matrix4f().setIdentity();
		viewMatrix = new Matrix4f().setIdentity();
		projectionMatrix = new Matrix4f().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
		vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/texture.vert"));
		fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/texture.frag"));
		program = new GLProgram(vShader, fShader);
		
		uTime = program.getUniform("uTime");
		uTexture1 = program.getUniform("uTexture1");
		uTexture2 = program.getUniform("uTexture2");
		
		uModelMatrix 		= program.getUniform("uModelMatrix");
		uViewMatrix			= program.getUniform("uViewMatrix");
		uProjectionMatrix	= program.getUniform("uProjectionMatrix");
		
		for(GLUniform var: program.getUniforms())
			out.println(var);
		
		for(GLAttribute var: program.getAttributes())
			out.println(var);
		

		final CTexture cTexture1 = Resource.readTexture("texture1.png");
		final GLTextureBuffer texture1 = new GLTextureBuffer();
		texture1.unpack(cTexture1);
		texture1.bindToUnit(1);
		
		final CTexture cTexture2 = Resource.readTexture("texture2.png");
		final GLTextureBuffer texture2 = new GLTextureBuffer();
		texture2.unpack(cTexture2);
		texture2.bindToUnit(2);
		
		final CTexture cTexture3 = Resource.readTexture("alphatest.png");
		final GLTextureBuffer texture3 = new GLTextureBuffer();
		texture3.unpack(cTexture3);
		texture3.bindToUnit(3);
		
		//------------------------------------------------------------------------------------------------------------------
		program.use();
		viewMatrix.setTranslation(new Vector3f(0f, 0f, -1f));
		
		quad1 = new Quad(program, -0.8f, 0.8f, 0.2f);
		quad2 = new Quad(program, -0.2f, 0.2f, -0.2f);
		System.out.println("end-init");
	}

	@Override
	public void resize() {}
	
	@Override
	public void pause() {}
	
	@Override
	public void resume() {	}
	
	@Override
	public void dispose() {
		program.dispose();
		vShader.dispose();
		fShader.dispose();
		
		//quad dispose!
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
		/*long time = System.currentTimeMillis();
		long dif = time - lastTime;
			if(dif != 0) out.println(1000/dif);
		lastTime = time;*/
		
		angle += 1.0f;
		rotateM.setRotation(new Vector3f(0f, 0f, 1f), angle);
		
		//modelMatrix.setMultiply(rotateM, tmpM.setMultiply(translateM, scaleM));
		//modelMatrix.setMultiply(rotateM, tmpM.setMultiplyScale(translateM, scaleV));
		
		//modelMatrix.setMultiply(rotateM, scaleM);
		//modelMatrix.setMultiplyScale(rotateM, scaleV);
		
		//modelMatrix.setMultiply(rotateM, translateM);
		modelMatrix.setMultiplyTranslation(rotateM, translateV);
		
		index++;
		program.use();
		program.setUniform(uTime, index/100.0f);
		program.setUniform(uModelMatrix, modelMatrix);
		program.setUniform(uViewMatrix, viewMatrix);
		program.setUniform(uProjectionMatrix, projectionMatrix);
	}
	
	@Override
	public void render() {
		scene.use();
		program.setTextureUnit(uTexture1, 1);
		program.setTextureUnit(uTexture2, 2);
		quad1.draw();

		program.setTextureUnit(uTexture2, 0);
		quad2.draw();
		
		hud.use();
		program.setTextureUnit(uTexture1, 3);
		program.setTextureUnit(uTexture2, 3);
		quad2.draw();
		
		/*glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		program.setTextureUnit(uTexture1, 1);
		program.setTextureUnit(uTexture2, 2);
		quad1.draw();
		
		program.setTextureUnit(uTexture2, 0);
		quad2.draw();*/
	}

}
