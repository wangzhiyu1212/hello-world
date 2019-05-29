package codetest;

public class HashTest {

	public static void main(String args[]) {
		TestClass t1 = new TestClass(2);
		TestClass t2 = new TestClass(2);
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		if (t1.equals(t2)) 
			System.out.println("Y");
		else
			System.out.println("X");
	}

}
