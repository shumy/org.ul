package org.ul.android.spi;

import java.io.IOException;
import java.io.InputStream;

import org.ul.spi.SPIvfs;

import android.content.res.AssetManager;

public class SPIvfsAndroid implements SPIvfs {
	private final AssetManager assetManager;
	
	public SPIvfsAndroid(AssetManager assetManager) {
		this.assetManager = assetManager;
	}

	@Override
	public InputStream getAsset(String filename) {
		try {
			return assetManager.open(filename);
		} catch(IOException e) {
			throw new RuntimeException("Unable to load file [" + filename + "]", e);
		}
	}

	/*@Override
	public OutputStream getOutputStream(String filename) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
