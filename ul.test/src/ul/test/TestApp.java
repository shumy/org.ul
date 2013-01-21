package ul.test;

import static java.lang.System.out;

import org.ul.IApplication;
import org.ul.gl.GL;
import org.ul.gl.math.Matrix4f;
import org.ul.gl.math.Vector3f;
import org.ul.gl.shader.GLAttribute;
import org.ul.gl.shader.GLProgram;
import org.ul.gl.shader.GLShader;
import org.ul.gl.shader.GLUniform;
import org.ul.gl.shader.GLShader.ShaderType;
import org.ul.gl.view.GLView;
import org.ul.vfs.Resource;

import ul.test.unit.SimpleQuad;

public class TestApp implements IApplication {
	GLView scene;
	
	GLShader vShader;
	GLShader fShader;
	GLProgram program;
	
	GLUniform uTime;
	
	GLUniform uModelMatrix;
	GLUniform uViewMatrix;
	GLUniform uProjectionMatrix;
	
	SimpleQuad quad;

	Matrix4f modelMatrix;
	Matrix4f viewMatrix;
	Matrix4f projectionMatrix;
	
	@Override
	public void init() {
		GL.init();
		
		scene = new GLView();
		
		modelMatrix = new Matrix4f().setIdentity();
		viewMatrix = new Matrix4f().setIdentity();
		projectionMatrix = new Matrix4f().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
		vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/sun.vert"));
		fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/digit.frag"));
		program = new GLProgram(vShader, fShader);
		
		//uTime = program.getUniform("uTime");
		uModelMatrix 		= program.getUniform("uModelMatrix");
		uViewMatrix			= program.getUniform("uViewMatrix");
		uProjectionMatrix	= program.getUniform("uProjectionMatrix");
		
		for(GLUniform var: program.getUniforms())
			out.println(var);
		
		for(GLAttribute var: program.getAttributes())
			out.println(var);
		
		//------------------------------------------------------------------------------------------------------------------
		program.use();
		viewMatrix.setTranslation(new Vector3f(0f, 0f, -1f));
		
		quad = new SimpleQuad(program, -0.8f, 0.8f, 0.2f);
	}
	
	@Override
	public void resize() {
		scene.setSize(GL.width, GL.height);
	}
	
	@Override
	public void render() {
		//program.setUniform(uResolution, (float)width, (float)height);
		
		scene.use();
		quad.draw();
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
		
		//-----------
		//modelMatrix.setMultiplyTranslation(rotateM, translateV);
		
		index++;
		
		program.use();
		//program.setUniform(uTime, index/100.0f);
		program.setUniform(uModelMatrix, modelMatrix);
		program.setUniform(uViewMatrix, viewMatrix);
		program.setUniform(uProjectionMatrix, projectionMatrix);
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		program.dispose();
		vShader.dispose();
		fShader.dispose();

		//quad dispose!
	}

}
