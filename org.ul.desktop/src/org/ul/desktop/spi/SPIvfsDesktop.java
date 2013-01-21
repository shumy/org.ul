package org.ul.desktop.spi;

import java.io.InputStream;

import org.ul.spi.SPIvfs;

public class SPIvfsDesktop implements SPIvfs {

	@Override
	public InputStream getAsset(String filename) {
		try {
			return getClass().getClassLoader().getResourceAsStream(filename);
		} catch(Exception e) {
			throw new RuntimeException("Unable to load file [" + filename + "]", e);
		}
	}

	/*@Override
	public OutputStream getOutputStream(String filename) {
		try {
			return new FileOutputStream(filePath(filename));
		} catch(IOException e) {
			throw new RuntimeException("Unable to load file [" + filename + "]", e);
		}
	}*/

}
