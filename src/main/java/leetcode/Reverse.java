package leetcode;

public class Reverse {
	public int reverse(int x) {
        int ans=0,carry;
        while (x != 0) {
        	carry = x%10;
        	x = x/10;
        	if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && x > Integer.MAX_VALUE%10)) return 0;
        	if(ans<Integer.MIN_VALUE/10 || (ans==Integer.MIN_VALUE/10 && x < Integer.MIN_VALUE%10)) return 0;
        	
        	ans = ans*10 + carry;
        }
        return ans;
    }
	public static void main(String[] args) {
		Reverse r = new Reverse();
		System.out.println(r.reverse(-1234561112));
	}
}
