package leetcode;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2)
			return findMedianSortedArrays(nums2, nums1);
		int left = 0, m1, m2;
		int m = (n1 + n2 + 1) / 2;
		int right = n1;
		while (left < right) {
			m1 = left + (right - left) / 2;
			m2 = m - m1;
			if (nums1[m1] < nums2[m2 - 1]) {
				left = m1 + 1;
			} else
				right = m1;
		}
		m1 = left;
		m2 = m - m1;
		if ((n1 + n2) % 2 == 0) {
			if (n1 > 0) {
				int c1 = Math.max((m1 > 0) ? nums1[m1 - 1] : Integer.MIN_VALUE,
						(m2 > 0) ? nums2[m2 - 1] : Integer.MIN_VALUE);
				int c2 = Math.min((m1 == n1)? Integer.MAX_VALUE:nums1[m1], (m2 == n2)?Integer.MAX_VALUE:nums2[m2]);
				return (c1 + c2) * 0.5;
			}
			else 
				return (nums2[m2-1] + nums2[m2]) * 0.5;
		} else {
			if (n1 > 0)
				return Math.max((m1 > 0) ? nums1[m1 - 1] : Integer.MIN_VALUE,
						(m2 > 0) ? nums2[m2 - 1] : Integer.MIN_VALUE);
			else
				return nums2[m - 1];
		}
	}
}
