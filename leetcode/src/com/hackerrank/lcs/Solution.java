package com.hackerrank.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static String acceptInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(">");
		try {
			return br.readLine() + "\n" + br.readLine() + "\n"+ br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		String input = acceptInput();
		String a_[] = input.split("\n")[1].trim().split(" ");
		String b_[] = input.split("\n")[2].trim().split(" ");
		int[] a = new int[a_.length];
		int[] b = new int[b_.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(a_[i]);
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.valueOf(b_[i]);
		}

		int result = findLcs(a, b);
		System.out.println(result);

	}

	private static int findLcs(int[] a, int[] b) {

		int m = a.length;
		int n = b.length;
		int[][] opt = new int[m + 1][n + 1];

		int i, j;
		for (j = 0; j <= n; j++) {
			opt[0][j] = 0;
		}

		for (i = 1; i <= m; i++) {
			opt[i][0] = 0;
			for (j = 1; j <= n; j++) {
				if (a[i - 1] == b[j - 1]) {
					opt[i][j] = opt[i - 1][j - 1] + 1;
				} else {
					opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]);
				}
			}
		}

		return opt[m][n];
	}
}
