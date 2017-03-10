package com.sammok.substringconcat;

import java.util.List;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {

		char[] sChar = s.toCharArray();

		char[][] wordsChar = new char[words.length][];

		int i = 0;
		for (String word : words) {
			wordsChar[i] = word.toCharArray();
		}

		for (i = 0; i < sChar.length; i++) {
			for (int j = 0; j < wordsChar.length; j++) {

				for (int k = 0; k < wordsChar[j].length; k++) {
					if (sChar[i] == wordsChar[j][k]) {

					}
				}
			}
		}

		return null;
	}
}
