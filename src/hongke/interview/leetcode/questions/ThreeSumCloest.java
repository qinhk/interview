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
			for (int j = i + 1, k = num.length - 1; j < num.length && j != k;) {
				int sum = num[i] + num[j] + num[k];
				result = abs(target - sum) < abs(target - result) ? sum : result;
				if (sum < target) {
					j ++;
				} else if (sum > target) {
					k --;
				} else {
					return sum;
				}
			}
		}
		return result;
	}
	
	private int abs (int value) {
		if (value == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return Math.abs(value);
	}
	
	public static void main(String[] args) {
		ThreeSumCloest test = new ThreeSumCloest();
		System.out.println(test.threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1));
	}
}
