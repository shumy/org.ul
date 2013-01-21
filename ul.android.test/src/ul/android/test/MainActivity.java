package ul.android.test;

import org.ul.IApplication;
import org.ul.android.AndroidApplication;

import ul.test.AppExample;
import ul.test.FrameBufferApp;

import android.os.Bundle;

public class MainActivity extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//final IApplication test = new FrameBufferApp();
		final IApplication test = new AppExample();
		initialize(test);
	}

}
