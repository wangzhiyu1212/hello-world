package leetcode;
/**
 * MaxArea a = new MaxArea();
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(a.maxArea(height));
 * @author wangl
 *
 */
public class MaxArea {
	public int maxArea(int[] height) {
		int max = 0, l = 0, r = height.length - 1;
		while (l < r) {
			max = Math.max(max, (r - l)*Math.min(height[l], height[r]));
			if (height[l] > height[r])
				r--;
			else l++;
		}
		return max;
	}
}
