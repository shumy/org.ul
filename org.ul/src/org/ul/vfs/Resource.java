package org.ul.vfs;

import static org.ul.UL.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.ul.gl.GLFormat;
import org.ul.gl.buffer.client.CTexture;
import org.ul.gl.math.ivec2;

public class Resource {
	
	public static InputStream getInputStream(String filename) {
		return vfs.getAsset(filename);
	}
	
	/*public static OutputStream getOutputStream(String filename) {
		return vfs.getOutputStream(filename);
	}*/
	
	public static CTexture readTexture(String pngFileName) {
		final InputStream in = getInputStream(pngFileName);
		try {
			final PNGDecoder decoder = new PNGDecoder(in);
			final CTexture texture = new CTexture(new ivec2(decoder.getWidth(), decoder.getHeight()), GLFormat.RGBA);
				decoder.decode(texture.getData().asByteBuffer(), decoder.getWidth() * 4, PNGDecoder.Format.RGBA);
			texture.write();
			
			in.close();
			return texture;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String readText(String textFineName) {
		final StringBuilder text = new StringBuilder();
		try {
			final BufferedReader reader = new BufferedReader(new InputStreamReader(getInputStream(textFineName), "UTF-8"));
			String line = null;
			while((line = reader.readLine()) != null) {
				text.append(line);
				text.append('\n');
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return text.toString();
	}
}
