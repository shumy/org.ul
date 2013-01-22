package ul.test;

import org.ul.gl.math.mat4;
import org.ul.gl.math.vec3;

public class MatrixTest {

	public static void main(String[] args) {
		System.out.println("Matrix test---------------------------------------------");
		
		
		final mat4 m = new mat4().setPerspective(60f, 1.2f, 0.1f, 100f).setRotation(new vec3(1f, 1f, 1f).setNormalize(), 40f);
		System.out.println("A " + m.determinant());
		System.out.println(m);
		
		final mat4 inv = new mat4().setInvert(m);
		System.out.println("inv(A) " + inv.determinant());
		System.out.println(inv);
		
		final mat4 identity1 = new mat4().setMultiply(m, inv);
		System.out.println("I <= A*inv(A)");
		System.out.println(identity1);
	}

}
