package com.leetcode.easy._0009_palindromnumber;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PalindromeNumber {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ss.SSS");
		double start = Double.parseDouble(dateFormat.format(new Date()));
		System.out.print("Result: ");
		int number = 121;

		Solution isPalindrome = new Solution();
		System.out.println(isPalindrome.byWhileLoop(number));

		double end = Double.parseDouble(dateFormat.format(new Date()));

		System.out.println("\n" + (end - start));
	}
}

class Solution {
	// 0.015000000000000568 => -121
	// 0.010999999999999233 => 121
	public boolean byString(int x) {
		String sourceNumber = x + "";
		String revNumber = "";

		for (int i = sourceNumber.length() - 1; i >= 0; i--) {
			revNumber += sourceNumber.charAt(i);
		}

		return sourceNumber.equals(revNumber);
	}

	// 0.0020000000000024443 => 121 (temp = temp % 10; //not having)
	public boolean byWhileLoop(int x) {

		if (x < 0)
			return false;

		int temp = x;
		int rev = 0;

		while (temp != 0) {
			int temp1 = temp % 10;
			rev = (rev * 10) + temp1 % 10;
			temp /= 10;
		}
//		System.out.println("reverse:" + rev);

		return x == rev;
	}
}