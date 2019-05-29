package leetcode;
/**
IntToRoman a = new IntToRoman();
System.out.println(a.intToRoman(1994));
System.out.println(a.intToRoman(58));
*/
public class IntToRoman {

	public String intToRoman(int num) {
		StringBuilder s = new StringBuilder();
		while (num > 0) {
			if (num >= 1000) {
				s.append("M");
				num = num - 1000;
			} else if (num >= 900 && num < 1000) {
				s.append("CM");
				num = num - 900;
			} else if (num >= 500 && num < 900) {
				s.append("D");
				num = num - 500;
			} else if (num >= 400 && num < 500) {
				s.append("CD");
				num = num - 400;
			} else if (num >= 100 && num < 400) {
				s.append("C");
				num = num - 100;
			} else if (num >= 90 && num < 100) {
				s.append("XC");
				num = num - 90;
			} else if (num >= 50 && num < 90) {
				s.append("L");
				num = num - 50;
			} else if (num >= 40 && num < 50) {
				s.append("XL");
				num = num - 40;
			} else if (num >= 10 && num < 40) {
				s.append("X");
				num = num - 10;
			} else if (num >= 9 && num < 10) {
				s.append("IX");
				num = num - 9;
			} else if (num >= 5 && num < 9) {
				s.append("V");
				num = num - 5;
			} else if (num == 4) {
				s.append("IV");
				num = num - 4;
			} else if (num == 3) {
				s.append("III");
				num = num - 3;
			} else if (num == 2) {
				s.append("II");
				num = num - 2;
			} else if (num == 1) {
				s.append("I");
				num = num - 1;
			}
		}
		return s.toString();
	}
}
