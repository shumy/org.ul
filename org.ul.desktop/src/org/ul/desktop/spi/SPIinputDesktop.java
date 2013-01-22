package org.ul.desktop.spi;

import static org.ul.spi.SPIinput.Key.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.ul.gl.math.ivec2;
import org.ul.spi.SPIinput;

public class SPIinputDesktop implements SPIinput {
	private final HashMap<Integer, Key> keymap = new HashMap<Integer, Key>();
	private final HashSet<Key> keys = new HashSet<Key>();
	
	public boolean isTouchLeftDown() {
		return Mouse.isButtonDown(0);
	}
	
	public boolean isTouchRightDown() {
		return Mouse.isButtonDown(1);
	}

	@Override
	public ivec2 getTouch() {
		return new ivec2(Mouse.getX(), Mouse.getY());
	}
	
	@Override
	public Set<Key> getKeys() {
		return keys;
	}
	
	public void processKeys() {
		while(Keyboard.next()) {
			final Key key = keymap.get(Keyboard.getEventKey());
			if(key != null)
				if(Keyboard.getEventKeyState())
					keys.add(key);
				else
					keys.remove(key);
		}
	}
	
	public void mapKeys() {		
		keymap.put(1, KEY_ESCAPE);
		keymap.put(199, KEY_HOME);
		
		keymap.put(2, KEY_1);
		keymap.put(3, KEY_2);
		keymap.put(4, KEY_3);
		keymap.put(5, KEY_4);
		keymap.put(6, KEY_5);
		keymap.put(7, KEY_6);
		keymap.put(8, KEY_7);
		keymap.put(9, KEY_8);
		keymap.put(10, KEY_9);
		keymap.put(11, KEY_0);
		
		keymap.put(30, KEY_A);
		keymap.put(48, KEY_B);
		keymap.put(46, KEY_C);
		keymap.put(32, KEY_D);
		keymap.put(18, KEY_E);
		keymap.put(33, KEY_F);
		keymap.put(34, KEY_G);
		keymap.put(35, KEY_H);
		keymap.put(23, KEY_I);
		keymap.put(36, KEY_J);
		keymap.put(37, KEY_K);
		keymap.put(38, KEY_L);
		keymap.put(50, KEY_M);
		keymap.put(49, KEY_N);
		keymap.put(24, KEY_O);
		keymap.put(25, KEY_P);
		keymap.put(16, KEY_Q);
		keymap.put(19, KEY_R);
		keymap.put(31, KEY_S);
		keymap.put(20, KEY_T);
		keymap.put(22, KEY_U);
		keymap.put(47, KEY_V);
		keymap.put(17, KEY_W);
		keymap.put(45, KEY_X);
		keymap.put(21, KEY_Y);
		keymap.put(44, KEY_Z);

		
	}
}
