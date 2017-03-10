package com.sammok.sort.charactersbyfrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {

	class Kvp {
		Character c;
		Integer i;

		@Override
		public String toString() {
			return "Kvp [c=" + c + ", i=" + i + "]";
		}

	}

	public String frequencySort(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (Character key : s.toCharArray()) {
			Integer q = map.get(key);
			if (q == null) {
				map.put(key, 1);
			} else {
				map.put(key, ++q);
			}
		}

		ArrayList<Kvp> list = new ArrayList<>();
		for (Character key : map.keySet()) {
			Kvp kvp = new Kvp();
			kvp.c = key;
			kvp.i = map.get(key);
			list.add(kvp);
		}

		System.out.println(list);
		Collections.sort(list, new Comparator<Kvp>() {
			@Override
			public int compare(Kvp o1, Kvp o2) {
				return o1.i.compareTo(o2.i) * -1;
			}
		});

		System.out.println(list);
		StringBuffer buf = new StringBuffer();
		for (Kvp kvp : list) {
			for (int i = 0; i < kvp.i; i++) {
				buf.append(kvp.c);
			}
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().frequencySort("tree"));
	}
}
