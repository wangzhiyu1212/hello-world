package leetcode;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		if(s.length()<=1) return s;
        int len = s.length();
        boolean[][] b = new boolean[len][len];
        int start = 0,max=1;
        for(int i=0; i<len; i++) {
        	b[i][i] = true;
        	if(i+1<len&&s.charAt(i) == s.charAt(i+1)) {
        		b[i][i+1] = true;
        		start = i;
        		max = 2;
        	}
        }
        for(int l=3; l-1<len; l++) {
        	for(int i=0; i+l-1<len; i++) {
        		int j = i+l-1;
        		if(s.charAt(i) == s.charAt(j) && b[i+1][j-1]) {
        			b[i][j] = true;
        			start = i;
        			max = l;
        		}
        	}
        }
        return s.substring(start, start+max);
    }
	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		System.out.println(l.longestPalindrome("abffffa"));
	}
}
