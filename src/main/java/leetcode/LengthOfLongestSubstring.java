package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int i=0,j=0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        while(j<s.length()) {
        	if(map.containsKey(s.charAt(j))) {
        		i = Math.max(i, map.get(s.charAt(j))+1);
        	}
        	map.put(s.charAt(j), j);
        	len = (len > (j-i+1))? len:(j-i+1);
        	j++;
        }
        
        return len;
    }
	public static void main(String[] args) {
		LengthOfLongestSubstring s = new LengthOfLongestSubstring();
		System.out.println(s.lengthOfLongestSubstring("fwdeepfewds"));
    }
}
