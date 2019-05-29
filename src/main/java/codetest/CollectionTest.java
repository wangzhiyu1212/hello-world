package codetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {

	public static void main(String argsp[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(323);
		list.add(23213);
		
		for (Integer i : list) {
			System.out.println(i);
		}
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "123");
		map.put(34, "2321");
		map.put(34, "3");
		
		for (Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
		}
	}
	
	
	
}
