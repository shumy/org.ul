package ul.test;

import org.ul.gl.math.mat3;
import org.ul.gl.math.mat4;
import org.ul.gl.math.vec3;

public class MatrixTest {

	public static void main(String[] args) {
		System.out.println("Matrix test---------------------------------------------");
		
		/*
		final mat4 m = new mat4().setPerspective(60f, 1.2f, 0.1f, 100f).setRotation(new vec3(1f, 1f, 1f).setNormalize(), 40f);
		System.out.println("A " + m.determinant());
		System.out.println(m);
		
		final mat4 inv = new mat4().setInvert(m);
		System.out.println("inv(A) " + inv.determinant());
		System.out.println(inv);
		
		final mat4 identity1 = new mat4().setMultiply(m, inv);
		System.out.println("I <= A*inv(A)");
		System.out.println(identity1);
		*/
		
		final mat3 m3 = new mat3().setIdentity().set(0, 0, 2).set(1, 0, 3).set(0, 1, 3);
		System.out.println("A " + m3.determinant());
		System.out.println(m3);
		
		final mat3 inv3 = new mat3().setInvert(m3);
		System.out.println("inv(A) " + inv3.determinant());
		System.out.println(inv3);
		
		final mat3 identity2 = new mat3().setMultiply(m3, inv3);
		System.out.println("I <= A*inv(A)");
		System.out.println(identity2);
	}

}
