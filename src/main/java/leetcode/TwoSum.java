package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        
	        for(int i = 0;i<nums.length; i++) {
	        	if(map.containsKey(target - nums[i])) {
	        		return new int[] {map.get(target-nums[i]),i};
	        	}
	        	map.put(nums[i], i);
	        }
	        
	        return null;
	    }
		public static void main(String args[]) {
			TwoSum s = new TwoSum();
			int[] answer = s.twoSum(new int[] {2, 7,-11,20}, 22);
			for(int i = 0; i<answer.length; i++) {
				System.out.println(answer[i]);
			}
			

		}
	}

