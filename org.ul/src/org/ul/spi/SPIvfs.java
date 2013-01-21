package org.ul.spi;

import java.io.InputStream;

public interface SPIvfs {
	InputStream getAsset(String filename);
	//OutputStream getOutputStream(String filename);
}
