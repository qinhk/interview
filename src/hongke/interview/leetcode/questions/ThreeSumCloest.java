package hongke.interview.leetcode.questions;

import java.util.Arrays;

public class ThreeSumCloest {
	/*
	 * Given an array S of n integers, find three integers in S such that the
	 * sum is closest to a given number, target. Return the sum of the three
	 * integers. You may assume that each input would have exactly one solution.
	 * 
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * 
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */

	public int threeSumClosest(int[] num, int target) {
		
		if (num == null || num.length < 3) {
			return 0;
		}
		Arrays.sort(num);
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i ++) {
			for (int j = 0, k = num.length; j != k;) {
				
			}
		}
		return result;
	}
}
