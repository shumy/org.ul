package ul.test;

import static java.lang.System.out;

import org.ul.IApplication;
import org.ul.gl.GL;
import org.ul.gl.math.mat4;
import org.ul.gl.math.vec3;
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

	mat4 modelMatrix;
	mat4 viewMatrix;
	mat4 projectionMatrix;
	
	@Override
	public void init() {
		GL.init();
		
		scene = new GLView();
		
		modelMatrix = new mat4().setIdentity();
		viewMatrix = new mat4().setIdentity();
		projectionMatrix = new mat4().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
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
		viewMatrix.setTranslation(new vec3(0f, 0f, -1f));
		
		quad = new SimpleQuad(program, -0.8f, 0.8f, 0.2f);
	}
	
	@Override
	public void resize() {
		scene.setSize(GL.size);
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
	
	final vec3 translateV = new vec3(1.0f, 0f, 0f);
	final vec3 scaleV = new vec3(2f, 1f, 1f);

	
	final mat4 translateM = new mat4().setTranslation(translateV);
	final mat4 scaleM = new mat4().setScale(scaleV);
	final mat4 rotateM = new mat4();
	
	final mat4 tmpM = new mat4();
	
	@Override
	public void update() {
		/*long time = System.currentTimeMillis();
		long dif = time - lastTime;
			if(dif != 0) out.println(1000/dif);
		lastTime = time;*/
		
		angle += 1.0f;
		rotateM.setRotation(new vec3(0f, 0f, 1f), angle);
		
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
