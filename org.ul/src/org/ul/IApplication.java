package org.ul;

public interface IApplication {

	void init();
	void resize();
	
	void pause();
	void resume();
	
	void update();
	void render();
	
	void dispose();
}
