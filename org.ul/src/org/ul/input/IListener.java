package org.ul.input;

public interface IListener {
	boolean touchDown(int screenX, int screenY, int pointer, int button);
	boolean touchUp(int screenX, int screenY, int pointer, int button);
	boolean touchDragged(int screenX, int screenY, int pointer);
	
	void on();
}
