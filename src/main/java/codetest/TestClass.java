package codetest;

public class TestClass {

	private int i;
	
	TestClass(){
		
	}
	
	TestClass(int i){
		this.i = i;
	}
	
	public int hashCode() {
		return i;
	}
	
	public boolean equals(Object o) {
		if ( o instanceof TestClass && o.hashCode() == this.hashCode())
			return true;
		else return false;
	}
}
