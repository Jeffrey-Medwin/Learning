package com.leetcode.easy._0001_twosum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TwoSum {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ss.SSS");
		double start = Double.parseDouble(dateFormat.format(new Date()));

		Solution solution = new Solution();

		int[] list = new int[] {};
		int target = -9;

		int[] result = solution.twoSum(list, target);

		for (int i : result) {
			System.out.print(i + " ");
		}

		double end = Double.parseDouble(dateFormat.format(new Date()));

		System.out.println("\n" + (end - start));
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		if (length > 1) {
			for (int i = 0; i < length; i++) {
				int diff = target - nums[i];
				for (int j = i + 1; j < length; j++) {
					if (diff == nums[j]) {
						return new int[] { i, j };
					}
				}
			}
		}
		return new int[] {};
	}
}
