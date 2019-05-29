package codetest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	List<String> mList = new ArrayList<String>();
	String str ;
	
	ListTest(String str) {
		this.str = str;
	}
	public static void main(String args[]){
		List<ListTest> tList = new ArrayList<ListTest>();
		tList.add(new ListTest("223"));
		tList.add(new ListTest("22"));
		tList.add(new ListTest("11"));

		for(ListTest str : tList) {
			if (str.getStr().equals("22"))
				tList.remove(str);
		}
		for(ListTest str : tList) {
			System.out.println(str.getStr());
		}
		
	}
	public List<String> getmList() {
		return mList;
	}
	public void setmList(List<String> mList) {
		this.mList = mList;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
