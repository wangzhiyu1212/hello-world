package codetest;

import java.util.*;

public class MapTest {

	public class MapKey {
		private int keyValue;

	}

	public static void main(String args[]) {
		HashMap<Customer, Integer> map = new HashMap<Customer, Integer>();
		Customer c1 = new Customer(1);
		Customer c2 = new Customer(1);
		
		map.put(c1, 1);
		map.put(c2, 2);
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		for(Customer c :map.keySet()) {
			System.out.println(c.getC());
			
		}
		
	}

}

class Customer {
	int c ;
	
	Customer (int i){
		this.c = i;
	}
	int getC() {
		return this.c;
	}
	
	public boolean equals(Object b){
		return ((Customer)b).getC() == this.c;
	}
	
	@Override
	public int hashCode() {
		return this.c;
	}
}