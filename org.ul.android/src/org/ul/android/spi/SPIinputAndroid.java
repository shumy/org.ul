package org.ul.android.spi;

import static org.ul.spi.SPIinput.Key.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.ul.gl.math.ivec2;
import org.ul.spi.SPIinput;

public class SPIinputAndroid implements SPIinput {
	private final HashMap<Integer, Key> keymap = new HashMap<Integer, Key>();
	private final HashSet<Key> keys = new HashSet<Key>();

	@Override
	public boolean isTouchLeftDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTouchRightDown() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ivec2 getTouch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Key> getKeys() {
		return keys;
	}
	
	public void addKey(int androidKey) {
		final Key key = keymap.get(androidKey);
		if(key != null)
			keys.add(key);
	}
	
	public void removeKey(int androidKey) {
		final Key key = keymap.get(androidKey);
		if(key != null)
			keys.remove(key);
	}
	
	public void mapKeys() {
		keymap.put(111, KEY_ESCAPE);
		keymap.put(3, KEY_HOME);
		 
		keymap.put(7, KEY_0);
		keymap.put(8, KEY_1);
		keymap.put(9, KEY_2);
		keymap.put(10, KEY_3);
		keymap.put(11, KEY_4);
		keymap.put(12, KEY_5);
		keymap.put(13, KEY_6);
		keymap.put(14, KEY_7);
		keymap.put(15, KEY_8);
		keymap.put(16, KEY_9);
		
		keymap.put(29, KEY_A);
		keymap.put(30, KEY_B);
		keymap.put(31, KEY_C);
		keymap.put(32, KEY_D);
		keymap.put(33, KEY_E);
		keymap.put(34, KEY_F);
		keymap.put(35, KEY_G);
		keymap.put(36, KEY_H);
		keymap.put(37, KEY_I);
		keymap.put(38, KEY_J);
		keymap.put(39, KEY_K);
		keymap.put(40, KEY_L);
		keymap.put(41, KEY_M);
		keymap.put(42, KEY_N);
		keymap.put(43, KEY_O);
		keymap.put(44, KEY_P);
		keymap.put(45, KEY_Q);
		keymap.put(46, KEY_R);
		keymap.put(47, KEY_S);
		keymap.put(48, KEY_T);
		keymap.put(49, KEY_U);
		keymap.put(50, KEY_V);
		keymap.put(51, KEY_W);
		keymap.put(52, KEY_X);
		keymap.put(53, KEY_Y);
		keymap.put(54, KEY_Z);
	}

}
