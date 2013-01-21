package ul.test;

import org.ul.util.NativeBuffer;
import org.ul.util.NativeLoader;

public class NativeBufferTest {
	public static void main(String[] args) {
		NativeLoader.init();
		NativeLoader.load("util");
		
		
		final NativeBuffer bb = new NativeBuffer(3);
		System.out.println(bb.getPosition() +  "-" + bb.getLimit() + "-" + bb.getCapacity());
		bb.putByte((byte)1);
		System.out.println(bb.getPosition() +  "-" + bb.getLimit() + "-" + bb.getCapacity());
		bb.putByte((byte)2);
		System.out.println(bb.getPosition() +  "-" + bb.getLimit() + "-" + bb.getCapacity());
		bb.flip();
		System.out.println(bb.getPosition() +  "-" + bb.getLimit() + "-" + bb.getCapacity());

		while(bb.getPosition() != bb.getLimit())
			System.out.println(bb.getByte());
		
		bb.dispose();
		
		final NativeBuffer ib = new NativeBuffer(8);
		System.out.println(ib.getPosition() +  "-" + ib.getLimit() + "-" + ib.getCapacity());
		ib.putInt(1);
		System.out.println(ib.getPosition() +  "-" + ib.getLimit() + "-" + ib.getCapacity());
		ib.putInt(2);
		System.out.println(ib.getPosition() +  "-" + ib.getLimit() + "-" + ib.getCapacity());
		ib.flip();
		System.out.println(ib.getPosition() +  "-" + ib.getLimit() + "-" + ib.getCapacity());

		while(ib.getPosition() != ib.getLimit())
			System.out.println(ib.getInt());
		
		ib.dispose();
	}
}
