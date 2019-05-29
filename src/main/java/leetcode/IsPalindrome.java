package leetcode;
/**
 * IsPalindrome a = new IsPalindrome();
		System.out.println(a.isPalindrome(2147483644));
		System.out.println(13213);
 * @author wangl
 *
 */
public class IsPalindrome {
	public boolean isPalindrome(int x) {
        if(x<0)
        	return false;

        int ans=0,carry,c=x;
        while (x != 0) {
        	carry = x%10;
        	x = x/10;
        	if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && x > Integer.MAX_VALUE%10)) return false;
        	ans = ans*10 + carry;
        }
        if (c==ans)return true;
        else return false;

    }

}
