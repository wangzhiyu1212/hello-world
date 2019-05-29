package leetcode;
/**
 * Convert c = new Convert();
	System.out.println(c.convert("LEETCODEISHIRING", 1));
 */
import java.util.ArrayList;
import java.util.List;

public class Convert {
	public String convert(String s, int numRows) {
		if(s.length()<=1 ||numRows > s.length()||numRows<=1)
			return s;
		List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i=0; i<numRows; i++)
        	list.add(new StringBuilder());
        int rowNum = 0;
        int t = 0;
        for(char c:s.toCharArray()) {
        	if(rowNum == 0) {
        		list.get(rowNum).append(c);
        		t = 1;
        	}
        	else if(rowNum == numRows-1) {
        		list.get(rowNum).append(c);
        		t = -1;
        	}
        	else 
        		list.get(rowNum).append(c);
        	rowNum = rowNum + t;
        }
        StringBuilder out = new StringBuilder();
        for(int i=0; i<numRows; i++)
        	out.append(list.get(i));
        return out.toString();
    }

}
