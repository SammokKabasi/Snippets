package com.leetcode.longestcommonprefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String prefix = strs[0];
		char[] prefixArray = prefix.toCharArray();
		int length = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			char[] array = strs[i].toCharArray();
			if(length>strs[i].length()) {
				length = strs[i].length();
			}
			for (int j = 0; j < length && j < strs[i].length(); j++) {
				if (prefixArray[j] != array[j]) {
					length = j;
					break;
				}

			}
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append(prefixArray[i]);
		}

		return buffer.toString();

	}
	
	public static void main(String[] args) {
		String[] strs = {"aa", "a"};
		System.out.println(new Solution().longestCommonPrefix(strs));
	}
}