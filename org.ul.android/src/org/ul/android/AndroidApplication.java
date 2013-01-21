package org.ul.android;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import org.ul.IApplication;
import org.ul.UL;
import org.ul.android.spi.SPIglAndroid;
import org.ul.android.spi.SPIinputAndroid;
import org.ul.android.spi.SPIvfsAndroid;
import org.ul.gl.GL;
import org.ul.util.NativeLoader;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

public class AndroidApplication extends Activity {
	boolean isInited = false;
	boolean isPaused = false;
	
	IApplication app;
	GLSurfaceView view;
	SPIinputAndroid keyProcessor;
	
	private void initSPIs() {
		NativeLoader.init();
		NativeLoader.load("util");
		
		UL.gl = new SPIglAndroid();
		UL.vfs = new SPIvfsAndroid(getAssets());
		UL.input = keyProcessor = new SPIinputAndroid();
		keyProcessor.mapKeys();
	}

	protected void initialize(IApplication app) {
		this.app = app;
		initSPIs();
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		view = new GLSurfaceView(this);
		view.setEGLContextClientVersion(2);
		view.setRenderer(new AndroidRender());
		view.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
		//view.setDebugFlags(GLSurfaceView.DEBUG_CHECK_GL_ERROR | GLSurfaceView.DEBUG_LOG_GL_CALLS);
		
        setContentView(view);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		keyProcessor.addKey(keyCode);
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		keyProcessor.addKey(keyCode);
		return super.onKeyUp(keyCode, event);
	}
	
    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
        
        System.out.println("pause");
        app.pause();
        GL.errorTest("app-pause");
        isPaused = true;
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
        
        if(isInited) {
        	System.out.println("resume");
            app.resume();
            GL.errorTest("app-resume");
            isPaused = false;
        }
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	
    	System.out.println("dispose");
        app.dispose();
        GL.errorTest("app-dispose");
        isInited = false;
    }
    	
	class AndroidRender implements GLSurfaceView.Renderer {
		
		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			//TODO: reload opengl context...
			GL.errorTest("onSurfaceCreated");
		}
		
		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			GL.width = width;
			GL.height = height;
			GL.aspectRatio = GL.width/(float)GL.height;
			
			if(!isInited) {
				System.out.println("init");
				app.init();
				GL.errorTest("app-init");
				isInited = true;
			}
			
			System.out.println("resize");
			app.resize();
			GL.errorTest("app-resize");
		}
		
		@Override
		public void onDrawFrame(GL10 gl) {
			if(!isPaused) {
				//System.out.println("update");
				app.update();
				GL.errorTest("app-update");
				//System.out.println("render");
				app.render();
				GL.errorTest("app-render");
			}
		}
	}
	
}
