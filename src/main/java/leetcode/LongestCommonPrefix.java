package leetcode;
/**
 * LongestCommonPrefix a = new LongestCommonPrefix();
		String[] strs = new String[] {"flower","flow","flight"};
		System.out.println(a.longestCommonPrefix(strs));
 * @author wangl
 *
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int minL=Integer.MAX_VALUE;
		StringBuilder s = new StringBuilder();
        if (strs.length == 0) return "";
        for (int i=0; i<strs.length; i++) {
        	minL = Math.min(minL, strs[i].length());
        }
        for (int j=0; j<minL; j++) {
        	char c = strs[0].charAt(j);
        	for (int i=1; i<strs.length; i++) {
        		if (c != strs[i].charAt(j))
        			return s.toString();
        	}
        	s.append(c);
        }
        return s.toString();
    }
}
