package leetcode;
/**
 * JewelAndStone jas = new JewelAndStone();
		System.out.println(jas.numJewelsInStones("acbBe","aaAAbBba"));
 * @author wangl
 *
 */
public class JewelAndStone {

	public int numJewelsInStones(String J, String S) {
        char js[] = J.toCharArray();
        char ss[] = S.toCharArray();
        int count = 0;
        
        for (char j : js) {
        	for (char s : ss) {
        		if (j == s) {
        			count++;
        		}
        	}
        }
        return count;
    }
}
