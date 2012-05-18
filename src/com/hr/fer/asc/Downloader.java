package com.hr.fer.asc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
/**
 * Klasa koja skida dokument programXXX s interneta 
 * i sprema ga u res.drawabl folder
 * U dokumentu se nalazi raspored za odreðeni program
 * @author TalkTV
 *
 */
public class Downloader {
	
	public static void Sinkroniziraj() {
		try {
	   String fileName = "filename";
		URL url = new URL("url-od-kuda-uzimamo");
		File file = new File(fileName);
		
		URLConnection ucon = url.openConnection();
		InputStream is = ucon.getInputStream();
		
		BufferedInputStream bis = new BufferedInputStream(is);
		ByteArrayBuffer baf = new ByteArrayBuffer(50);
		
		int current = 0;
		try {
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		
		}
		
		FileOutputStream fos = new FileOutputStream(file);
	
		fos.write(baf.toByteArray());
		
		fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}
