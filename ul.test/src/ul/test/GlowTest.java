package ul.test;

import static java.lang.System.out;

import org.ul.IApplication;
import org.ul.gl.GL;
import org.ul.gl.GLFormat;
import org.ul.gl.buffer.tex.GLFrameBuffer;
import org.ul.gl.buffer.tex.GLTextureBuffer;
import org.ul.gl.entity.GLVertexArray.DrawPrimitive;
import org.ul.gl.math.ivec2;
import org.ul.gl.math.mat4;
import org.ul.gl.math.vec3;
import org.ul.gl.shader.GLAttribute;
import org.ul.gl.shader.GLProgram;
import org.ul.gl.shader.GLShader;
import org.ul.gl.shader.GLUniform;
import org.ul.gl.shader.GLShader.ShaderType;
import org.ul.gl.view.GLView;
import org.ul.vfs.Resource;

import ul.test.unit.RenderQuad;
import ul.test.unit.Square;

public class GlowTest implements IApplication {
	GLView offline;
	GLView scene;
	
	GLProgram drawProgram;
	GLProgram blurProgram;
	GLProgram glowProgram;
	
	GLUniform uColor;
	GLUniform uModelMatrix;
	GLUniform uViewMatrix;
	GLUniform uProjectionMatrix;
	
	GLUniform uTexelSize;
	GLUniform uTextureBlur;
	GLUniform uOrientation;
	GLUniform uBlurAmount;
	GLUniform uBlurStrength;

	GLUniform uBlendMode;
	GLUniform uSceneTexture;
	GLUniform uGlowTexture;
	
	GLTextureBuffer texture1;
	GLTextureBuffer texture2;
	GLTextureBuffer texture3;
	
	Square line;
	RenderQuad renderQuad;

	mat4 modelMatrix;
	mat4 viewMatrix;
	mat4 projectionMatrix;
	
	GLFrameBuffer fbo1;
	GLFrameBuffer fbo2;
	GLFrameBuffer fbo3;
	
	@Override
	public void init() {
		GL.init();
		
		scene = new GLView();
		
		int size = 256;
		offline = new GLView();
		offline.setSize(new ivec2(size, size));
		
		modelMatrix = new mat4().setIdentity();
		viewMatrix = new mat4().setIdentity().setTranslation(new vec3(0f, 0f, -1.5f));
		projectionMatrix = new mat4().setPerspective(60f, GL.aspectRatio, 0.1f, 100f);
		
		initDrawProgram();
		initBlurProgram();
		initGlowProgram();

		//-----------------------------------------------------------------------------------------------------------------
		line = new Square(drawProgram, -1f, 1f, 0.5f, 1.5f);
		renderQuad = new RenderQuad(blurProgram);
		
		texture1 = new GLTextureBuffer(GL.size, GLFormat.RGB);
		texture1.bindToUnit(1);
		fbo1 = new GLFrameBuffer();
		fbo1.attach(texture1);
		
		texture2 = new GLTextureBuffer(GL.size, GLFormat.RGB);
		texture2.bindToUnit(2);
		fbo2 = new GLFrameBuffer();
		fbo2.attach(texture2);
		
		texture3 = new GLTextureBuffer(GL.size, GLFormat.RGB);
		texture3.bindToUnit(3);
		fbo3 = new GLFrameBuffer();
		fbo3.attach(texture3);
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
	}
	
	private void initBlurProgram() {
		final GLShader vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/screen.vert"));
		final GLShader fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/blur.frag"));
		blurProgram = new GLProgram(vShader, fShader);
		
		out.println("Blur Program: " + blurProgram.getId());
		printProgramVars(blurProgram);
		
		uTextureBlur = blurProgram.getUniform("uTexture");
		uTexelSize = blurProgram.getUniform("uTexelSize");
		
		uOrientation = blurProgram.getUniform("uOrientation");
		uBlurAmount = blurProgram.getUniform("uBlurAmount");
		uBlurStrength = blurProgram.getUniform("uBlurStrength");
	}
	
	private void initGlowProgram() {
		final GLShader vShader = new GLShader(ShaderType.VERTEX, Resource.readText("shader/screen.vert"));
		final GLShader fShader = new GLShader(ShaderType.FRAGMENT, Resource.readText("shader/glow.frag"));
		glowProgram = new GLProgram(vShader, fShader);
		
		out.println("Glow Program: " + glowProgram.getId());
		printProgramVars(glowProgram);
		
		uBlendMode = glowProgram.getUniform("uBlendMode");
		
		uSceneTexture = glowProgram.getUniform("uSceneTexture");
		uGlowTexture = glowProgram.getUniform("uGlowTexture");
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
	public void update() {}
	
	@Override
	public void render() {
		draw();
		blur();
		glow();
	}
	
	public void draw() {
		drawProgram.use();
		drawProgram.setUniform(uColor, new vec3(0.0f, 1.0f, 0.0f));
		drawProgram.setUniform(uModelMatrix, modelMatrix);
		drawProgram.setUniform(uViewMatrix, viewMatrix);
		drawProgram.setUniform(uProjectionMatrix, projectionMatrix);
		
		fbo1.begin();
			scene.use();
			line.draw(DrawPrimitive.TRIANGLES);
		fbo1.end();
	}
	
	int blurDirection = 1;
	int blur = 1;
	
	public void blur() {
		final float scale = 1f;
		final float pixelWidth = scale/(float)scene.getSize().data[0];
		final float pixelHeight = scale/(float)scene.getSize().data[1];
		
		if(blur > 30) blurDirection = -1;
		if(blur < 2) blurDirection = 1;
		blur += blurDirection;
		
		blurProgram.use();
		blurProgram.setUniform(uBlurAmount, blur);		// 2 < uBlurAmount 	 < 10	step 1
		blurProgram.setUniform(uBlurStrength, 0.5f);	// 0 < uBlurStrength < 1	step 0.1
		
		//horizontal blur
		blurProgram.setTextureUnit(uTextureBlur, 1);
		blurProgram.setUniform(uOrientation, 0);
		blurProgram.setUniform(uTexelSize, pixelWidth);
		fbo2.begin();
			scene.use();
			renderQuad.draw();
		fbo2.end();
		
		//vertical blur
		blurProgram.setTextureUnit(uTextureBlur, 2);
		blurProgram.setUniform(uOrientation, 1);
		blurProgram.setUniform(uTexelSize, pixelHeight);
		fbo3.begin();
			scene.use();
			renderQuad.draw();
		fbo3.end();
	}
	
	public void glow() {
		glowProgram.use();
		glowProgram.setUniform(uBlendMode, 2);
		glowProgram.setTextureUnit(uSceneTexture, 1);
		glowProgram.setTextureUnit(uGlowTexture, 3);
		
		scene.use();
		renderQuad.draw();
	}
}
