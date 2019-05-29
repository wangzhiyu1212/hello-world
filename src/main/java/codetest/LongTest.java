package codetest;


public class LongTest {

	public static void main(String args[]) {
		
		System.out.println(sqrt(5));
		System.out.println(Math.sqrt(5));
	}
	
	 private static double sqrt(double c) {
		 
	     double low,high,middle =0;
	     if (c < 0) {
	    	 return Double.NaN;
	     }
	     else {
	    	 low = 0;
	    	 high = c;
	    	 
	    	 for (middle = (low + high)/2; Math.abs(middle*middle -c) > 1e-2 ;middle = (low + high)/2) {
	    	 if (middle*middle > c) {
	    		 high = middle;
	    	 }else if (middle*middle == c) {
	    		 return middle;
	    	 }else {
	    		 low = middle;
	    	 }
	    	 }
	     }
	     return middle;
	        
	 }

}
