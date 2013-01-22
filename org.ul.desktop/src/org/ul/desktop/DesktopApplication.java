package org.ul.desktop;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.ul.IApplication;
import org.ul.UL;
import org.ul.desktop.spi.SPIglDesktop;
import org.ul.desktop.spi.SPIinputDesktop;
import org.ul.desktop.spi.SPIvfsDesktop;
import org.ul.gl.GL;
import org.ul.gl.math.ivec2;
import org.ul.util.NativeLoader;

public class DesktopApplication {
	SPIinputDesktop keyProcessor;
	
	private void initSPIs() {
		NativeLoader.init();
		NativeLoader.load("util");
		
		UL.gl = new SPIglDesktop();
		UL.vfs = new SPIvfsDesktop();
		UL.input = keyProcessor= new SPIinputDesktop();
		keyProcessor.mapKeys();
	}
	
	protected void initialize(IApplication app) {
		initSPIs();
		
		try {
			/*
			DisplayMode selectedDM = null;
			final DisplayMode[] modes = Display.getAvailableDisplayModes();
			for(DisplayMode mode: modes) {
				if(mode.getWidth() == 1024)
					selectedDM = mode;
			}
			
			out.println(selectedDM.getWidth() + "x" + selectedDM.getHeight() + "x" + selectedDM.getBitsPerPixel() + " " + selectedDM.getFrequency() + "Hz");		
			Display.setDisplayMode(new DisplayMode(selectedDM.getWidth(), selectedDM.getHeight()));
			Display.setVSyncEnabled(true);
			*/
			
			Display.setDisplayMode(new DisplayMode(1280, 752));
			Display.setTitle("Shader Example");
			Display.create();
				
			GL.size = new ivec2(Display.getWidth(), Display.getHeight());
			GL.aspectRatio = GL.size.ratio();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("init");
		app.init();
		GL.errorTest("app-init");
		
		//System.out.println("resize");
		app.resize();
		GL.errorTest("app-resize");
		
		while (Display.isCloseRequested() == false) {
			Display.update();
			keyProcessor.processKeys();
			
			//System.out.println("update");
			app.update();
			GL.errorTest("app-update");
			//System.out.println("render");
			app.render();
			GL.errorTest("app-render");
			
			Display.sync(60);
		}

		//System.out.println("dispose");
		app.dispose();
		GL.errorTest("app-dispose");
		Display.destroy();
	}
}
