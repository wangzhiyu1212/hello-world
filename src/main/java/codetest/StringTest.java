package codetest;

public class StringTest {

	public static void main(String[] args) {
		String a = "aaaac";
		String b = "aaaac";
		a = "bbbc";
		System.out.println(b);
	}
	
	public static class S {
		String s1 ;
		String s2 ;
		
		public S (String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}
		
		public String getS1() {
			return s1;
		}
	}
}
