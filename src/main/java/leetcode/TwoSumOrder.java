package leetcode;

public class TwoSumOrder {
	public int[] twoSumOrder(int[] numbers, int target) {
        if (null == numbers || numbers.length < 2 ) {
        	return null;
        }
        int i = 0, j = numbers.length - 1;
        while ( i<j ) {
        	if ((numbers[i] + numbers[j]) > target) {
        		j--;
        	} else if ((numbers[i] + numbers[j]) < target) {
        		i++;
        	} else {
        		return new int[] {i+1,j+1};
        	}
        }
        return null;
    }
	public static void main(String args[]) {
		TwoSumOrder s = new TwoSumOrder();
		int[] answer = s.twoSumOrder(new int[] {2, 7,13,20}, 13);
		for(int i = 0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	
	}
	
}
