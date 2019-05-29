package leetcode;

public class SortArray {
	public int[] bubbleSort(int[] nums) {
        if (nums.length <= 1) return nums;
        int temp;
        for (int i=0; i<nums.length; i++) 
        	for (int j=0; j+i+1<nums.length; j++){
        		if (nums[j]>nums[j+1]) {
        			temp = nums[j];
        			nums[j] = nums[j+1];
        			nums[j+1] = temp;
        		}
        }
        return nums;
    }
	public int[] selectSort(int[] nums) {
        if (nums.length <= 1) return nums;
        int temp;
        for (int i=0; i<nums.length; i++) 
        	for (int j=i+1; j<nums.length; j++) {
        		if (nums[i]>nums[j]) {
        			temp = nums[i];
        			nums[i] = nums[j];
        			nums[j] = temp;
        		}
        	}
        return nums;
	}
	public int[] insertSort(int[] nums) {
        if (nums.length <= 1) return nums;
        int temp;
        for (int i=1; i<nums.length; i++) {
        	for (int j=i; j>0; j--) {
        		if (nums[j]<nums[j-1]) {
        			temp = nums[j];
        			nums[j] = nums[j-1];
        			nums[j-1] = temp;
        		}
        	} 	
        }
        return nums;
	}
	public int[] quickSort(int[] nums) {
		
	}
	public void recursive(int[] a, int left, int right) {
	    	if (left >= right) return;
	    	
	}
}


