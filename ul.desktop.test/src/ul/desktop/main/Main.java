package ul.desktop.main;

import org.ul.IApplication;
import org.ul.desktop.DesktopApplication;

import ul.test.AppExample;
import ul.test.FastBlurTest;
import ul.test.FrameBufferApp;
import ul.test.GlowTest;
import ul.test.NativeBufferTest;

public class Main extends DesktopApplication {
	public static void main(String[] args) {
		//final IApplication test = new FrameBufferApp();
		//final IApplication test = new AppExample();
		//final IApplication test = new GlowTest();
		final IApplication test = new FastBlurTest();
		
		new Main().initialize(test);
	}

}
