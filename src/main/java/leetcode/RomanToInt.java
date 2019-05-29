package leetcode;

public class RomanToInt {

	public int romanToInt(String s) {
        int ans = 0,len = s.length();
        char[] c = s.toCharArray();
        for(int i=0;i<len;i++) {
        	if(c[i] == 'I') {
        		if ((i+1<c.length) && (c[i+1] == 'V')) {
        			ans = ans + 4;
        			i++;
        		} else if ((i+1<c.length) && (c[i+1] == 'X')) {
        			ans = ans + 9;
        			i++;
        		} else
        			ans = ans + 1;
        	} 
        	else if (c[i] == 'V') {
        		ans = ans + 5;
        	}
        	else if (c[i] == 'X') {
        		if ((i+1<c.length) && (c[i+1] == 'L')) {
        			ans = ans + 40;
        			i++;
        		} else if ((i+1<c.length) && (c[i+1] == 'C')) {
        			ans = ans + 90;
        			i++;
        		} else
        			ans = ans + 10;
        	}
        	else if (c[i] == 'L') {
        		ans = ans + 50;
        	}
        	else if (c[i] == 'C') {
        		if ((i+1<c.length) && (c[i+1] == 'D')) {
        			ans = ans + 400;
        			i++;
        		} else if ((i+1<c.length) && (c[i+1] == 'M')) {
        			ans = ans + 900;
        			i++;
        		} else
        			ans = ans + 100;
        	}
        	else if (c[i] == 'D') {
        		ans = ans + 500;
        	}
        	else if (c[i] == 'M') {
        		ans = ans + 1000;
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		RomanToInt a = new RomanToInt();
		System.out.println(a.romanToInt("LVIII"));
	}
}
