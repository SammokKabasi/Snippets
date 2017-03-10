package com.hackerrank.extralongfactorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) {
		int input = Integer.parseInt(acceptInput());
		BigInteger[] bigInteger = new BigInteger[input + 1];

		bigInteger[1] = new BigInteger("1");
		for (int i = 2; i <= input; i++) {
			bigInteger[i] = bigInteger[i - 1].multiply(new BigInteger(Integer.toString(i)));
			// System.out.println(i + "! ->" + bigInteger[i]);
		}
		System.out.println(bigInteger[input]);
	}

	private static String acceptInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.print(">");
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
