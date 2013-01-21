package org.ul.util;

import java.util.HashSet;
import java.util.Set;

public class NativeLoader {
	public enum OS {WINDOWS, LINUX, MAC, ANDROID}
	
	private static String preFix, posFix;
	
	private static boolean is64Bit = false;
	private static OS os;
	
	private static Set<String> loadedLibs = new HashSet<String>();
	
	public static void init() {
		is64Bit = System.getProperty("os.arch").equals("amd64");
		final String osName = System.getProperty("os.name");
		
		if(osName.contains("Windows")) {
			os = OS.WINDOWS;
			
			preFix = "";
			if(is64Bit)
				posFix = "64.dll";
			else
				posFix = ".dll";
			
		} else if(osName.contains("Linux")) { //also for Android (based linux)
			os = OS.LINUX;
			
			preFix = "lib";
			if(is64Bit) 
				posFix = "64.so";
			else
				posFix = ".so";
			
		} else if(osName.contains("Mac")) {
			os = OS.MAC;
			
			preFix = "lib";
			posFix = ".dylib";
		}
	
		final String vm = System.getProperty("java.vm.name");
		if (vm != null && vm.contains("Dalvik")) {
			os = OS.ANDROID;
			preFix = "";
			posFix = "";
		}
			
	}
	
	public static boolean is64Bit() {return is64Bit;}
	public static OS getOS() {return os;}
	
	public static void load(String libName) {
		if(!loadedLibs.contains(libName)) {
			//System.loadLibrary(preFix + libName + posFix);
			System.loadLibrary(libName);
			loadedLibs.add(libName);
		}
	}
}
