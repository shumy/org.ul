package org.ul.netgen;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildExecutor;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;

public class Main {
	public static void main(String[] args) throws Exception {
		genNatives();
		genWindowBuild();
		
		build();
	}
	
	public static void genNatives() throws Exception {
		new NativeCodeGenerator().generate("src", "bin", "jni");
	}
	
	public static void genWindowBuild() {
		BuildTarget target = BuildTarget.newDefaultTarget(TargetOs.Windows, false);
		target.compilerPrefix = "";
		
		BuildConfig config = new BuildConfig("util", "tmp", "gen-libs", "jni");
		new AntScriptGenerator().generate(config, target);
	}
	
	public static void genLinuxBuild() {
		BuildTarget target = BuildTarget.newDefaultTarget(TargetOs.Linux, false);
		target.compilerPrefix = "";
		
		BuildConfig config = new BuildConfig("util", "tmp", "gen-libs", "jni");
		new AntScriptGenerator().generate(config, target);
	}

	public static void build()  {
		BuildExecutor.executeAnt("jni/build.xml", "-v");
	}
}
