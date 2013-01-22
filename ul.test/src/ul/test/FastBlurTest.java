package ul.test;

import static java.lang.System.out;

import org.ul.IApplication;
import org.ul.UL;
import org.ul.gl.GL;
import org.ul.gl.GLFormat;
import org.ul.gl.buffer.tex.GLFrameBuffer;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.gl.entity.GLVertexArray.DrawPrimitive;
import org.ul.gl.math.ivec2;
import org.ul.gl.math.ivec3;
import org.ul.gl.math.mat4;
import org.ul.gl.math.vec3;
import org.ul.gl.shader.GLAttribute;
import org.ul.gl.shader.GLProgram;
import org.ul.gl.shader.GLShader;
import org.ul.gl.shader.GLUniform;
import org.ul.gl.shader.GLShader.ShaderType;
import org.ul.gl.view.GLView;
import org.ul.spi.SPIinput;
import org.ul.vfs.Resource;

import ul.test.unit.RenderQuad;
import ul.test.unit.Square;

public class FastBlurTest implements IApplication {
	GLView offline;
	GLView scene;
	
	GLProgram drawProgram;
	GLProgram blurProgram;
	
	GLUniform uColor;
	GLUniform uModelMatrix;
	GLUniform uViewMatrix;
	GLUniform uProjectionMatrix;
	
	GLUniform uTexelSize;
	GLUniform uOrientation;
	GLUniform uTexture;

	GLTextureBuffer texture1;
	GLTextureBuffer texture2;
	
	Square obj1;
	Square obj2;
	RenderQuad renderQuad;

	mat4 modelMatrix;
	mat4 viewMatrix;
	mat4 projectionMatrix;
	
	GLFrameBuffer fbo1;
	GLFrameBuffer fbo2;
	
	@Override
	public void init() {
		GL.init();
		
		scene = new GLView();
		
		offline = new GLView();
		offline.setSize(GL.size);
		
		modelMatrix = new mat4().setIdentity();
		viewMatrix = new mat4().setIdentity().setTranslation(new vec3(0f, 0f, -1.0f));
		projectionMatrix = new mat4().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
		initDrawProgram();
		initBlurProgram();

		//-----------------------------------------------------------------------------------------------------------------
		obj1 = new Square(drawProgram, -0.5f, 0.5f, 1.0f, 1.0f);
		obj2 = new Square(drawProgram, -0.49f, 0.49f, 0.98f, 0.98f);
		renderQuad = new RenderQuad(blurProgram);
		
		texture1 = new GLTextureBuffer(offline.getSize(), GLFormat.RGB);
		texture1.bindToUnit(1);
		fbo1 = new GLFrameBuffer();
		fbo1.attach(texture1);
		
		texture2 = new GLTextureBuffer(offline.getSize(), GLFormat.RGB);
		texture2.bindToUnit(2);
		fbo2 = new GLFrameBuffer();
		fbo2.attach(texture2);
	}
	
	private void initDrawProgram() {
		final GLShader vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/simple.vert"));
		final GLShader fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/simple.frag"));
		drawProgram = new GLProgram(vShader, fShader);
		
		out.println("Draw Program: " + drawProgram.getId());
		printProgramVars(drawProgram);
		
		uColor = drawProgram.getUniform("uColor");
		
		uModelMatrix 		= drawProgram.getUniform("uModelMatrix");
		uViewMatrix			= drawProgram.getUniform("uViewMatrix");
		uProjectionMatrix	= drawProgram.getUniform("uProjectionMatrix");
		
		drawProgram.use();
		drawProgram.setUniform(uViewMatrix, viewMatrix);
		drawProgram.setUniform(uProjectionMatrix, projectionMatrix);
	}
	
	private void initBlurProgram() {
		final GLShader vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/fast_blur.vert"));
		final GLShader fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/fast_blur.frag"));
		blurProgram = new GLProgram(vShader, fShader);
		
		out.println("Blur Program: " + blurProgram.getId());
		printProgramVars(blurProgram);
		
		uTexelSize = blurProgram.getUniform("uTexelSize");
		uOrientation = blurProgram.getUniform("uOrientation");
		uTexture = blurProgram.getUniform("uTexture");
	}
	
	private void printProgramVars(GLProgram program) {
		for(GLUniform var: program.getUniforms())
			out.println(var);
		
		for(GLAttribute var: program.getAttributes())
			out.println(var);
	}
	
	@Override
	public void resize() {
		scene.setSize(GL.size);
	}
	
	@Override
	public void pause() {}
	
	@Override
	public void resume() {}
	
	@Override
	public void dispose() {
		drawProgram.dispose();
		blurProgram.dispose();
	}
	
	@Override
	public void update() {
		final ivec2 pos = UL.input.getTouch();
		
		if(UL.input.isTouchLeftDown()) {
			System.out.println(pos);
			//System.out.println(proj);
			
			/*
			for(SPIinput.Key key: UL.input.getKeys()) {
				System.out.print(key.name() + ", ");
			}
			*/
		}
	}
	
	@Override
	public void render() {
		draw();
		blur();
	}
	
	float angle = 1.0f;
	final vec3 rotVec = new vec3(0f, 0f, 1f);
	
	public void draw() {
		angle += 0.2f;
		modelMatrix.setRotation(rotVec, angle);
		
		drawProgram.use();
		drawProgram.setUniform(uModelMatrix, modelMatrix);
		
		fbo1.begin();
			offline.use();
			offline.clear();
			
			drawProgram.setUniform(uColor, new vec3(0.0f, 1.0f, 0.0f));
			obj1.draw(DrawPrimitive.LINE_LOOP);
			
			drawProgram.setUniform(uColor, new vec3(1.0f, 0.0f, 0.0f));
			obj2.draw(DrawPrimitive.LINE_LOOP);
		
		fbo1.end();
	}
	
	float blurScale = 0;
	
	public void blur() {
		blurScale += 0.1;
		
		//final float scale = ((float)Math.sin(blurScale) + 1f) * 10f + 2f;
		final float scale = 1f;
		final float pixelWidth = scale/(float)scene.getSize().data[0];
		final float pixelHeight = scale/(float)scene.getSize().data[1];

		blurProgram.use();
		
		//horizontal blur
		blurProgram.setUniform(uOrientation, 0);
		blurProgram.setTextureUnit(uTexture, 1);
		blurProgram.setUniform(uTexelSize, pixelWidth);
		fbo2.begin();
			offline.use();
			offline.clear();
			renderQuad.draw();
		fbo2.end();
		
		//vertical blur
		blurProgram.setUniform(uOrientation, 1);
		blurProgram.setTextureUnit(uTexture, 2);
		blurProgram.setUniform(uTexelSize, pixelHeight);
		
		scene.use();
		scene.clear();
		renderQuad.draw();
	}
}
